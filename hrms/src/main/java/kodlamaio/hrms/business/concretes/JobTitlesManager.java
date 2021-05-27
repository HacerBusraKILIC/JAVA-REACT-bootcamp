package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitlesService;
import kodlamaio.hrms.business.validationRules.JobTitleValidator;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.JobTitlesDao;
import kodlamaio.hrms.entities.concretes.JobTitles;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class JobTitlesManager implements JobTitlesService {

	private JobTitlesDao jobTitlesDao;
	
	@Autowired
	public JobTitlesManager(JobTitlesDao jobTitlesDao) {
		super();
		this.jobTitlesDao = jobTitlesDao;
	}

	@Override
	public DataResult<List<JobTitles>> getAll() {
		return new SuccessDataResult<List<JobTitles>>(this.jobTitlesDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(JobTitles jobTitles) {
		 var titles = jobTitlesDao.findAll();
	        for (var tittle : titles)
	        {
	            if (jobTitles.getTitle().equals(tittle.getTitle()))
	                return new ErrorResult("İş pozisyonu daha önce eklenmiş!");
	        }
	        
	        JobTitleValidator validator = new JobTitleValidator();
	        Result[] validators = new Result[]{
	                validator.isTitleFilled(jobTitles.getTitle()),
	        };
	        
	        for (var item : validators) {
	            if (!item.isSuccess())
	                return new ErrorResult(item.getMessage());
	        }
	        
		this.jobTitlesDao.save(jobTitles);
		return new SuccessResult("İş pozisyonu eklendi");
	}

}
