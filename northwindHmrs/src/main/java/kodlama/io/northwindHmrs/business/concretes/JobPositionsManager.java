package kodlama.io.northwindHmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.JobPositionsService;
import kodlama.io.northwindHmrs.dataAccess.abstracts.JobPositionsDao;
import kodlama.io.northwindHmrs.entities.concretes.JobPositions;


@Service
public class JobPositionsManager implements JobPositionsService{

	
	private JobPositionsDao jobpositionsdao;
	

	@Autowired

	public JobPositionsManager(JobPositionsDao jobpositionsdao) {
		super();
		this.jobpositionsdao = jobpositionsdao;
	}



	@Override
	public List<JobPositions> getAll() {
return this.jobpositionsdao.findAll();
		
	}

	
}
