package kodlama.io.northwindHmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.northwindHmrs.business.abstracts.JobPositionsService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;
import kodlama.io.northwindHmrs.entities.concretes.JobPositions;

@RestController
@RequestMapping("/api/jobpositions")
public class jobPositionsController {

	
	private JobPositionsService jobpositionService;
	
	@Autowired
	public jobPositionsController(JobPositionsService jobpositionService) {
		super();
		this.jobpositionService = jobpositionService;
	}

	
	
	@GetMapping("/getall")
	public List<JobPositions> getAll(){
		return this.jobpositionService.getAll() ;
	}
		
		
		
	@PostMapping("/add")
    public Result add(@RequestBody JobPositions jobPositions) {
    	return this.jobpositionService.addJobPosition(jobPositions) ;
	    }
		
		
	}


