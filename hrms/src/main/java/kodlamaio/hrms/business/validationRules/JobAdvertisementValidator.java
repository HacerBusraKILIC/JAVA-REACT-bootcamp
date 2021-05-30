package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public class JobAdvertisementValidator implements BaseValidator {

	private JobAdvertisementDao jobAdvertisementDao;
	
    public JobAdvertisementValidator(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	public Result areRequiredInformationFilled(JobAdvertisement jobAdvertisement) {
        if(jobAdvertisement.getJobTitles().equals("") ||
           jobAdvertisement.getJobDescription().equals("") ||
           jobAdvertisement.getCity().equals("") ||
           jobAdvertisement.getNumberOfOpenPositions() == 0
        		) {
            return new ErrorResult("Alanlar boş geçilemez");
        }
        return new SuccessResult();
    } 
    
}
