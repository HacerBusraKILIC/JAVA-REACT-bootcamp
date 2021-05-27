package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService extends UserService<Candidate> {
	Result verifyAccountByVerificationCode(String email,String code);
}
