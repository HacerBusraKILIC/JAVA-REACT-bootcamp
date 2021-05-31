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
	public DataResult<List<JobAdvertisement>> getAllSortedCreationDate(int sortDirection) {
		Sort sort ;
		 if (sortDirection == 0) {
	            sort = Sort.by(Sort.Direction.DESC, "creationDate");
	        } else {
	            sort = Sort.by(Sort.Direction.ASC, "creationDate");
	        }
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort), "Başarılı");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActive(true), "Aktif iş ilanları listelendi");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployerIdAndIsActiveTrue(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployerIdAndIsActiveTrue(employerId));

	}

	@Override
	public Result updateIsActive(boolean isActive, int id) {
		this.jobAdvertisementDao.updateIsActive(isActive, id);
		return new SuccessResult("İş ilanı durumu güncellendi");
	}


}
