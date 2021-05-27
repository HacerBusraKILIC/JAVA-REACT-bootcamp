package kodlamaio.hrms.core.utilities.adapters;

import kodlamaio.hrms.core.utilities.verification.MailVerificationService;
import kodlamaio.hrms.mailVerification.HotmailVerificationService;

public class HotmailVerificationAdapter implements MailVerificationService {

	@Override
	public String sendVerificationCode(String email) {
		HotmailVerificationService service = new HotmailVerificationService();
		return service.sendVerificationCode(email);
	}

}
