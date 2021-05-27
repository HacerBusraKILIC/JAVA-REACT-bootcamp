package kodlamaio.hrms.core.utilities.verification;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.HotmailVerificationAdapter;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeEmployerDao;
import kodlamaio.hrms.entities.concretes.VerificationCodeEmployer;

@Service
public class VerificationCodeEmployerManager implements VerificationCodeEmployerService {

	private VerificationCodeEmployerDao verificationCodeEmployerDao;
	
	@Autowired
	public VerificationCodeEmployerManager(VerificationCodeEmployerDao verificationCodeEmployerDao) {
		super();
		this.verificationCodeEmployerDao = verificationCodeEmployerDao;
	}

	@Override
	public Result sendVerificationCode(int entityId, String email) {
		MailVerificationService mailService = new HotmailVerificationAdapter();
		var code = mailService.sendVerificationCode(email);
		
		VerificationCodeEmployer verificationCode = new VerificationCodeEmployer();
		verificationCode.setCode(code);
		verificationCode.setEmployerId(entityId);
		verificationCode.setVerificationDate(LocalDateTime.now());
		
		verificationCodeEmployerDao.save(verificationCode);
		return new SuccessResult("Verification işlemi başarılı");
	}

	@Override
	public DataResult<List<VerificationCodeEmployer>> getAll() {
		return new SuccessDataResult<List<VerificationCodeEmployer>>(verificationCodeEmployerDao.findAll());
	}

	@Override
	public Result verifyAccount(int verificationCodeId, int entityId, String code) {
		var verificationCodes = getAll().getData();
        VerificationCodeEmployer verificationCode = null;
        for (var item : verificationCodes){
            if (item.getId()==verificationCodeId)
                verificationCode = item;
        }

        verificationCode.setVerified(true);
        verificationCodeEmployerDao.save(verificationCode);

        return new ErrorResult();
	}

}
