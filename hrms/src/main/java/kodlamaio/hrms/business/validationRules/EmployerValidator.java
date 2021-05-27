package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

public class EmployerValidator extends UserValidator {
	
	private EmployerDao employerDao;
	
    public EmployerValidator(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	public Result areAllInformationFilledOnRegister(Employer employer) {
    	if(employer.getPhoneNumber().equals("") ||
           employer.getEmail().equals("") ||
           employer.getWebAdress().equals("") ||
           employer.getCompanyName().equals("") ||
           employer.getPassword().equals("")) {
    		return new ErrorResult("Boş alan geçilemez");
        }
        
    	return new SuccessResult("Alan kontrolü başarılı!");
    }
    
    public Result isEmailTaken(String email) {
        var employers = employerDao.findAll();
        for (var employer : employers) {
            if (employer.getEmail().equals(email))
                return new ErrorResult(email + " hesabıyla daha önce kayıt olunmuş!");
        }
        return new SuccessResult();
    }
}
