package kodlamaio.hrms.business.validationRules;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;

public class CandidateValidator extends UserValidator {
	
	private CandidateDao candidateDao;
    private UserDao userDao;
    
    @Autowired
	public CandidateValidator(CandidateDao candidateDao, UserDao userDao) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
	}
    
    public Result areAllInformationFilledOnRegister(Candidate candidate) {
        if(candidate.getIdentityNumber().equals("") ||
           candidate.getBirthYear() == 0 ||
           candidate.getEmail().equals("") ||
           candidate.getFirstName().equals("") ||
           candidate.getLastName().equals("")
        ) {
            return new ErrorResult("Alalnlar boş geçilemez");
        }
        return new SuccessResult();
    } 
    
    public Result isEmailTaken(String email) {
        var candidates = userDao.findAll();
        for (var candidate : candidates) {
            if (candidate.getEmail().equals(email))
                return new ErrorResult(email + " ile daha önce kayıt olunmuş1");
        }
        return new SuccessResult();
    }
    
    public Result isIdentityIdTaken(String identityNumber){
        var candidates = candidateDao.findAll();
        for (var candidate : candidates) {
            if (candidate.getIdentityNumber().equals(identityNumber))
                return new ErrorResult(identityNumber + " ile daha önce kayıt olunmuş1");
        }
        return new SuccessResult();
    }
    
}
