package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.JobAdvertisements;

public interface JobAdvertisementService {
	

	Result add(JobAdvertisements jobAdvertisements);
	
	Result update(JobAdvertisements jobAdvertisements);
	
	Result delete(int id);
	
	Result changeToActive(int id);
	
	DataResult<JobAdvertisements>getById(int id);

	DataResult<List<JobAdvertisements>> getAll();
	
	DataResult<List<JobAdvertisements>> getByIsActive();
	
	DataResult<List<JobAdvertisements>> getByIsActiveTrueOrderByApplicationDeadlineDesc();
	
	DataResult<List<JobAdvertisements>> getByIsActiveTrueAndEmployerId(int id);

}
