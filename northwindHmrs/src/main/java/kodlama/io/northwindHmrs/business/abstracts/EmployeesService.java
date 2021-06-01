package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.Employees;

public interface EmployeesService {
	public List<Employees> getAll();
	public Result addEployees(Employees employees);
	
	
	

}
