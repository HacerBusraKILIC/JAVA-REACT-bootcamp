package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService extends UserService<Employer> {
	 Result verifyAccountByVerificationCode(String email, String code);
}
