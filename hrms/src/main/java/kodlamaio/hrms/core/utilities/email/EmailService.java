package kodlamaio.hrms.core.utilities.email;

import kodlamaio.hrms.core.utilities.results.Result;

public interface EmailService {
	Result send(String to, String title, String message);
}
