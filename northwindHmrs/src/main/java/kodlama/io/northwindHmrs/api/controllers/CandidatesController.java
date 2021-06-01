package kodlama.io.northwindHmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.northwindHmrs.business.abstracts.CandidatesService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;
import kodlama.io.northwindHmrs.entities.concretes.Users;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	
	
	private CandidatesService candidatesService;
    
	@Autowired
	public CandidatesController(CandidatesService candidatesService) {
		super();
		this.candidatesService = candidatesService;
	}

	
	@GetMapping("/getall")
	public List<Candidates> getAll(){
		return this.candidatesService.getAll();
	}
	
	@PostMapping("/add")
    public Result addCandidates(@RequestBody Candidates candidates, String passwordAgain) {
    	return this.candidatesService.addCandidates(candidates,passwordAgain);
    }
	
	
	
}