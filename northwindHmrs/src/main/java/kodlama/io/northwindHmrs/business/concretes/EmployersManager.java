package kodlama.io.northwindHmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.EmployersService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.EmployersDao;
import kodlama.io.northwindHmrs.entities.concretes.Employers;
@Service
public class EmployersManager implements EmployersService {

	private EmployersDao employersDao;
	
	@Autowired
	public EmployersManager(EmployersDao employersDao) {
		super();
		this.employersDao = employersDao;
	}

	
	
	@Override
	public DataResult<List<Employers>> getAll() {
		return new SuccessDataResult<List<Employers>>(this.employersDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result addEmployer(Employers employer) {
		return new SuccessDataResult<Employers>
		(this.employersDao.save(employer),"Data Listelendi");
	}
	
	

}
