package eCommerceSim.business.concretes;

import eCommerceSim.business.abstracts.EmailService;

public class EmailManager implements EmailService {

	@Override
	public void send(String message, String email) {
		System.out.println("E-Mail : " + email + " Mesaj : " + message + " basariyla gönderildi.");
		
	}

}
