package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	
	Result add(JobAdvertisement jobAdvertisement); 
	
	DataResult<List<JobAdvertisement>> getAllSortedCreationDate(int sortDirection);

	DataResult<List<JobAdvertisement>> getByIsActive();
	
	DataResult<List<JobAdvertisement>>  getByEmployerIdAndIsActiveTrue(int employerId);

    Result updateIsActive(boolean isActive, int id);

}
