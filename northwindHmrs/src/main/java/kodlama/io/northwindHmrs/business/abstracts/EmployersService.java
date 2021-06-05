package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.Employers;

public interface EmployersService {
	
	DataResult<List<Employers>> getAll();
	Result addEmployer(Employers employer);

}
