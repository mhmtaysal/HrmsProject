package kodlama.io.northwindHmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.northwindHmrs.business.abstracts.JobAdvertisementService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.JobAdvertisements;

@RestController
@RequestMapping("/api/jobAdvertisement")

public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;
@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}


@PostMapping("/add")
public Result add(@RequestBody JobAdvertisements jobAdvertisements) {
	return this.jobAdvertisementService.add(jobAdvertisements);
}

@PostMapping("/changeToActive")
public Result changeToActive(int id) {
	return this.jobAdvertisementService.changeToActive(id);
}


@GetMapping("/getAll")
public DataResult<List<JobAdvertisements>> getAll(){
	return this.jobAdvertisementService.getAll();
}


@GetMapping("/getActive")
public DataResult<List<JobAdvertisements>> getActive(){
	return this.jobAdvertisementService.getByIsActive();
}


@GetMapping("/getOrderByApplicationDeadline")
public DataResult<List<JobAdvertisements>> getOrderByApplicationDeadline(){
	return this.jobAdvertisementService.getByIsActiveTrueOrderByApplicationDeadlineDesc();
}



@GetMapping("/getActiveEmployer")
public DataResult<List<JobAdvertisements>> getActiveEmployer(int id){
	return this.jobAdvertisementService.getByIsActiveTrueAndEmployerId(id);
}



}
