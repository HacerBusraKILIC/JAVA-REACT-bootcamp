package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.validationRules.JobAdvertisementValidator;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import net.bytebuddy.asm.Advice.This;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	 
	private JobAdvertisementDao jobAdvertisementDao;
	
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		JobAdvertisementValidator validator = new JobAdvertisementValidator(jobAdvertisementDao);
		Result[] validators = new Result[]{
				validator.areRequiredInformationFilled(jobAdvertisement)
		};
		
		for(var item : validators) {
			if(!item.isSuccess())
                return new ErrorResult(item.getMessage());
        }
		
		jobAdvertisementDao.save(jobAdvertisement);
		
		return new SuccessResult("İş ilanı eklendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedCreationDate() {
		Sort sort = Sort.by(Sort.Direction.ASC, "creationDate");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort), "Başarılı");
	}

}
