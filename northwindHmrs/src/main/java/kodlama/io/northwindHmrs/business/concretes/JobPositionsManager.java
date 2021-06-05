package kodlama.io.northwindHmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.JobPositionService;
import kodlama.io.northwindHmrs.dataAccess.abstracts.JobPositionDao;
import kodlama.io.northwindHmrs.entities.concretes.JobPosition;
@Service
public class JobPositionsManager implements JobPositionService {

	@Autowired
	public JobPositionsManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}



	private JobPositionDao  jobPositionDao;

	
	
	@Override
	public List<JobPosition> getAll() {
		
		return this.jobPositionDao.findAll();
	}
	
	

}
