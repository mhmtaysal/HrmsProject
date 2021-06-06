package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.entities.concretes.JobPosition;

public interface JobPositionService {
	

	List<JobPosition> getAll();

}
