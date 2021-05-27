package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthenticationService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.validationRules.CandidateValidator;
import kodlamaio.hrms.core.utilities.adapters.MernisServiceAdapter;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verification.VerificationCandidateService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
    private UserDao userDao;
    private VerificationCandidateService verificationCandidateService;
    
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "Candidate listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		CandidateValidator validator = new CandidateValidator(candidateDao,userDao);
        Result[] validators = new Result[]{
                validator.areAllInformationFilledOnRegister(candidate),
                validator.isEmailTaken(candidate.getEmail()),
                validator.arePasswordsSame(candidate.getPassword(), candidate.getPassword()),
                validator.isIdentityIdTaken(candidate.getIdentityNumber()),
                validator.isEmailValid(candidate.getEmail())
        };

        for (var item : validators) {
            if (!item.isSuccess())
                return new ErrorResult(item.getMessage());
        }
        
        AuthenticationService authenticationService =
                new AuthenticationManager(new MernisServiceAdapter());
        
        if (!authenticationService.checkIfRealPerson(
        		candidate.getIdentityNumber(),
        		candidate.getFirstName(),
        		candidate.getLastName(),
        		candidate.getBirthYear()
                ).isSuccess()
        ){
            return new ErrorResult("Geçerli kişi değil!");
        }

        candidateDao.save(candidate);

        verificationCandidateService.sendVerificationCode(candidate.getId(),candidate.getEmail());

        return new SuccessResult("Kayıt işlemi "+candidate.getEmail()+" adresinize gelecek olan onay kodu ile hesabınızı onaylayınız.");
    }

	@Override
	public Result verifyAccountByVerificationCode(String email, String code) {
		 var candidates = getAll().getData();
	        Candidate candidate = null;

	        for (var item : candidates) {
	            if (item.getEmail().equals(email))
	                candidate = item;
	        }

	        var result = verificationCandidateService.verifyAccount(candidate.getId(),code);
	        if (!result.isSuccess())
	            return result;

	        return new SuccessResult("Doğrulama maili gönderildi");

	}

}
