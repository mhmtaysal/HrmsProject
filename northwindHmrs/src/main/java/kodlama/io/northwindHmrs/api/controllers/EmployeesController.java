package kodlama.io.northwindHmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.northwindHmrs.business.abstracts.EmployeesService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.Employees;
import kodlama.io.northwindHmrs.entities.concretes.Users;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {
	
private EmployeesService employeesService;

@Autowired
public EmployeesController(EmployeesService employeesService) {
	super();
	this.employeesService = employeesService;
}


@GetMapping("/getall")
public List<Employees> getAll(){
	return this.employeesService.getAll();
}


@PostMapping("/register")
public Result addEmployees(@RequestBody Employees employees) {
	return this.employeesService.addEployees(employees);
}


// Verification  code will be add

//@Transactional
//@PostMapping("/employerVerification")
//public Result updateEmployerSetVerificationStatusForUserId(@RequestParam("employerId") int employerId) {
//	return this.personnelService.updateEmployerSetVerificationStatusForUserId(employerId);
//}

		
}
