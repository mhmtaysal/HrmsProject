package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.Employers;

public interface EmployersService {

	public Result addEmplyers(Employers employers,String passwordAggain);
	
	public List<Employers> getAll();
	
	public List<String> getAllEmails();
	
	
}
