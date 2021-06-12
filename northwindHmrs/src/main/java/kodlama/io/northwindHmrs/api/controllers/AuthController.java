package kodlama.io.northwindHmrs.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.northwindHmrs.business.abstracts.AuthService;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;
import kodlama.io.northwindHmrs.entities.concretes.Employers;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

	

	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}


	
	@PostMapping("/registerEmployer")
	public Result registerEmployer(@RequestBody Employers employer,String confirmPassword) {
		return this.authService.registerEmployers(employer, confirmPassword);
	}
	
	@PostMapping("/registerCandidate")
	public Result registerCandidate(@RequestBody Candidates candidate ,String confirmPassword) {
		return this.authService.registerCandidates(candidate, confirmPassword);
	}
	
	@PostMapping("/confirmEmail")
	public Result registerCandidate(int id ,String confirmActivationCode) {
		return this.authService.confirmEmail(id, confirmActivationCode);
	}
	
	
}
