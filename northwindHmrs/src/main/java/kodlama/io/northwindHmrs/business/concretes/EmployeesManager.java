package kodlama.io.northwindHmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlama.io.northwindHmrs.business.abstracts.EmployeesService;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.EmployeesDao;
import kodlama.io.northwindHmrs.dataAccess.abstracts.EmployersDao;
import kodlama.io.northwindHmrs.entities.concretes.Employees;

public class EmployeesManager implements EmployeesService{

	private EmployeesDao employeesDao;
	private EmployersDao employersDao;
	
	@Autowired
	public EmployeesManager(EmployeesDao employeesDao, EmployersDao employersDao) {
		super();
		this.employeesDao = employeesDao;
		this.employersDao = employersDao;
	}

	@Override
	public List<Employees> getAll() {
		return this.employeesDao.findAll();
		
	}

	@Override
	public Result addEployees(Employees employees) {

	this.employeesDao.save(employees);
	return new SuccessResult("Personel Eklendi");
	}

}
