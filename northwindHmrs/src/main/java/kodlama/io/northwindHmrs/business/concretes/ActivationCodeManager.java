package kodlama.io.northwindHmrs.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.ActivationCodeService;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.ActivationCodeDao;
import kodlama.io.northwindHmrs.entities.concretes.ActivationCode;
@Service
public class ActivationCodeManager implements ActivationCodeService {

	private ActivationCodeDao activationCodeDao;
	
	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
		super();
		this.activationCodeDao = activationCodeDao;
	}

	
	
	@Override
	public Result add(ActivationCode code) {
	this.activationCodeDao.save(code);
		return new SuccessResult("Kod kayıt edildi!");
	}

	@Override
	public boolean sendActivationCode(String emailAddress) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	String code = "";
	public String createActivationCode() {
		int randomCode = (int) (Math.random()*9999);
		code = String.valueOf(randomCode);
		return code;
	}


}
