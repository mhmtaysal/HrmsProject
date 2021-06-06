package kodlama.io.northwindHmrs.business.abstracts;

import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.EmployersActivationByEmployees;

public interface EmployersActivationByEmployeesService {
Result add(EmployersActivationByEmployees activationConfirm);
	
}
