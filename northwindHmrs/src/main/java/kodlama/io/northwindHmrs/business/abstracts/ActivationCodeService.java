package kodlama.io.northwindHmrs.business.abstracts;

import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.ActivationCode;

public interface ActivationCodeService {

	Result add(ActivationCode activationCode);
	boolean sendActivationCode(String emailAddress);
}
