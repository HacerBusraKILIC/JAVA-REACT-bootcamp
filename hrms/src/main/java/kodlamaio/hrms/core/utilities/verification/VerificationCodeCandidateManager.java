package kodlamaio.hrms.core.utilities.verification;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.HotmailVerificationAdapter;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeCandidateDao;
import kodlamaio.hrms.entities.concretes.VerificationCodeCandidate;

@Service
public class VerificationCodeCandidateManager implements VerificationCodeCandidateService {

	private VerificationCodeCandidateDao verificationCodeCandidateDao;
	
	@Autowired
	public VerificationCodeCandidateManager(VerificationCodeCandidateDao verificationCodeCandidateDao) {
		super();
		this.verificationCodeCandidateDao = verificationCodeCandidateDao;
	}

	@Override
	public Result sendVerificationCode(int entityId, String email) {
		MailVerificationService service = new HotmailVerificationAdapter();
        var code = service.sendVerificationCode(email);

        VerificationCodeCandidate verificationCode = new VerificationCodeCandidate();
        verificationCode.setCode(code);
        verificationCode.setCondidateId(entityId);
        verificationCode.setVerificationDate(LocalDate.now());

        verificationCodeCandidateDao.save(verificationCode);
        
        return new SuccessResult();
	}

	@Override
	public DataResult<List<VerificationCodeCandidate>> getAll() {
		return new SuccessDataResult<List<VerificationCodeCandidate>>(verificationCodeCandidateDao.findAll());
	}

	@Override
	public Result verifyAccount(int verificationCodeId, int entityId, String code) {
		var verificationCodes = getAll().getData();
        VerificationCodeCandidate verificationCode = null;
        
        for (var item : verificationCodes){
            if (item.getId()==verificationCodeId)
                verificationCode = item;
        }
        
        verificationCode.setVerified(true);
        verificationCodeCandidateDao.save(verificationCode);
        
		return new SuccessResult();
	}

}
