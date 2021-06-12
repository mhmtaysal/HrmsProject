package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.Employees;

public interface EmployeesService {
	
	Result add(Employees employee);
	DataResult<List<Employees>> getAll();
	DataResult<Employees> getByEmployess(int id);
	
	
}
