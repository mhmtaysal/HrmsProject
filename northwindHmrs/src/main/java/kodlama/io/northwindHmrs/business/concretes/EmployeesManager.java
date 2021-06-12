package kodlama.io.northwindHmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.EmployeesService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.EmployeesDao;
import kodlama.io.northwindHmrs.entities.concretes.Employees;

@Service
public class EmployeesManager implements EmployeesService {

	private EmployeesDao employeesDao;

	@Autowired
	public EmployeesManager(EmployeesDao employeesDao) {
		super();
		this.employeesDao = employeesDao;
	}

	@Override
	public Result add(Employees employee) {
		this.employeesDao.save(employee);
		return new SuccessResult("kayıt eklendi!");
	}

	@Override
	public DataResult<List<Employees>> getAll() {

		return new SuccessDataResult<List<Employees>>(this.employeesDao.findAll(), "Çalışanlar listelendi");
	}

	@Override
	public DataResult<Employees> getByEmployess(int id) {
return new SuccessDataResult<Employees>(this.employeesDao.findById(id).get(), "Çalışan Lİstelendi");

	}

}
