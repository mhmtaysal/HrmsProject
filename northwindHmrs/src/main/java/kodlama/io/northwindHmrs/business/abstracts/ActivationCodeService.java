package kodlama.io.northwindHmrs.business.abstracts;

import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.ActivationCode;
import kodlama.io.northwindHmrs.entities.concretes.Users;

public interface ActivationCodeService {
	
	ActivationCode getByCode(String code);
	String createActivationCode(Users user);
	Result activateUser(String code);
	

}
