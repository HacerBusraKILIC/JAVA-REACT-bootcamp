package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.validationRules.EmployerValidator;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verification.VerificationEmployerService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private VerificationEmployerService verificationEmployerService;
	
	public EmployerManager(EmployerDao employerDao, VerificationEmployerService verificationEmployerService) {
		super();
		this.employerDao = employerDao;
		this.verificationEmployerService = verificationEmployerService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll());

	}

	@Override
	public Result add(Employer employer) {
		EmployerValidator validator = new EmployerValidator(employerDao);
		
		 Result[] validators = new Result[]{
	                validator.areAllInformationFilledOnRegister(employer),
	                validator.isEmailTaken(employer.getEmail()),
	                validator.arePasswordsSame(employer.getPassword(), employer.getPassword()),
	                validator.isEmailValid(employer.getEmail())
	        };
		 
		 for (var item : validators) {
	            if (!item.isSuccess())
	                return new ErrorResult(item.getMessage());
	        }
		 
		 employerDao.save(employer);
		 
		 verificationEmployerService.sendVerificationCode(employer.getId(), employer.getEmail());
		return 	new SuccessResult("Kayıt işlemi başarılı!");
	}

	@Override
	public Result verifyAccountByVerificationCode(String email, String code) {
		var entities = getAll().getData();
        Employer employer = null;

        for (var item : entities) {
            if (item.getEmail().equals(email)){
                employer = item;
                var result = verificationEmployerService.verifyAccount(employer.getId(),code);
                if (!result.isSuccess())
                    return result;
            }
        }



        return new SuccessResult("Doğrulama işlemi başarılı!");
	}


}
