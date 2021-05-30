package kodlama.io.northwindHmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.northwindHmrs.business.abstracts.UserService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.Users;

@RestController
@RequestMapping("api/users")
public class UsersController {
	
private UserService userService;
@Autowired
public UsersController(UserService userService) {
	super();
	this.userService = userService;
}


@GetMapping("/getall")
public DataResult<List<Users>> getAll(){
	return this.userService.getAll();
}
@PostMapping("/register")
public Result register(@RequestBody Users users) {
	return this.userService.addUsers(users);
}


// Verification  code will be add

//@Transactional
//@PostMapping("/employerVerification")
//public Result updateEmployerSetVerificationStatusForUserId(@RequestParam("employerId") int employerId) {
//	return this.personnelService.updateEmployerSetVerificationStatusForUserId(employerId);
//}

		
}
