package kodlama.io.northwindHmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.northwindHmrs.business.abstracts.JobPositionsService;
import kodlama.io.northwindHmrs.entities.concretes.JobPositions;

@RestController
@RequestMapping("/api/jobpositions")
public class jobPositionsController {
	
	
	 @Autowired
	private JobPositionsService jobpositionService;
	 
	public jobPositionsController(JobPositionsService jobpositionService) {
		super();
		this.jobpositionService = jobpositionService;
	}

	
	
	@GetMapping("/getall")
	public List<JobPositions> getAll(){
		return this.jobpositionService.getAll()  ;
		
	}
	
	

}
