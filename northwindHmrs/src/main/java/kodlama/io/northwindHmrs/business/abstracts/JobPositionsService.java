package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.JobPositions;


public interface JobPositionsService {
	public	List<JobPositions> getAll();
	public	Result addJobPosition(JobPositions jobPositions);
	public List<String> getAllEmail();
	
}