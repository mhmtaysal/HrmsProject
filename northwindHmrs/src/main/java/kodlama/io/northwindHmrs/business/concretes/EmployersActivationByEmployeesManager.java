package kodlama.io.northwindHmrs.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.EmployersActivationByEmployeesService;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.EmployersActivationByEmployeesDao;
import kodlama.io.northwindHmrs.entities.concretes.EmployersActivationByEmployees;
@Service
public class EmployersActivationByEmployeesManager implements EmployersActivationByEmployeesService {
	
	private EmployersActivationByEmployeesDao activationDao;
	
	@Autowired
	public EmployersActivationByEmployeesManager(EmployersActivationByEmployeesDao activationDao) {
		super();
		this.activationDao = activationDao;
	}
	
	
	
	@Override
	public Result add(EmployersActivationByEmployees activationConfirm) {
		
		this.activationDao.save(activationConfirm);
		return new SuccessResult("Kod Kaydedildi");
	}

}
