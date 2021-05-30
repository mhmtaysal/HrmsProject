package kodlama.io.northwindHmrs.business.abstracts;



import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.Users;

public interface UserService {
	
	DataResult<List<Users>> getAll();
	Result addUsers(Users users);
}