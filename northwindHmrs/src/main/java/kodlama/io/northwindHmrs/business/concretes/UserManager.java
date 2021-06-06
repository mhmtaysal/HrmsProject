package kodlama.io.northwindHmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.UserService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.UserDao;
import kodlama.io.northwindHmrs.entities.concretes.Users;
@Service
public class UserManager implements UserService  {
	private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	
	@Override
	public DataResult<Users> getUsersByEmail(String email) {
		return new SuccessDataResult<Users>(this.userDao.findUsersByEmail(email));	}


	@Override
	public DataResult<List<Users>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result addUsers(Users users) {
		return null;
	}

}
