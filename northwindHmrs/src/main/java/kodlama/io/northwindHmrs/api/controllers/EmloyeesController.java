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

@RestController
@RequestMapping("/api/employees")
public class EmloyeesController {
	


private EmployeesService employeesService;

@Autowired
public EmloyeesController(EmployeesService employeesService) {
		super();
		this.employeesService = employeesService;
	}

	

@GetMapping("/getall")
public DataResult<List<Employees>> getAll(){
	return this.employeesService.getAll();
}


@GetMapping("/getEmployee")
public DataResult<Employees> getOne(int id){
	return this.employeesService.getByEmployess(id);
}

@PostMapping("/addEmployee")

public Result addEmployee(@RequestBody Employees employee) {
	return this.employeesService.add(employee);
}


}
