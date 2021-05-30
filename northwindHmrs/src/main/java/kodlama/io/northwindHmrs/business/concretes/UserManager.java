package kodlama.io.northwindHmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.UserService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.UsersDao;
import kodlama.io.northwindHmrs.entities.concretes.Users;

@Service
public class UserManager implements UserService {

	private UsersDao usersDao;
	
	@Autowired
	public UserManager(UsersDao usersDao) {
		super();
		this.usersDao = usersDao;
	}
	
	@Override
	public DataResult<List<Users>> getAll() {		
		return new SuccessDataResult<List<Users>>(this.usersDao.findAll());
	}

	@Override
	public Result addUsers(Users users) {
		this.usersDao.save(users);
		return new SuccessResult("Kişi eklendi");
	}
	
	
	
	

}