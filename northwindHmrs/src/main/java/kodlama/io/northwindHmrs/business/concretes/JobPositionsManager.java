

package kodlama.io.northwindHmrs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.JobPositionsService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.ErrorResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.JobPositionsDao;
import kodlama.io.northwindHmrs.entities.concretes.JobPositions;


@Service
public class JobPositionsManager implements JobPositionsService{

	
	private JobPositionsDao jobpositionsdao;
	private List<String> jobPositions = new ArrayList<>();

	@Autowired
	public JobPositionsManager(JobPositionsDao jobpositionsdao) {
		super();
		this.jobpositionsdao = jobpositionsdao;
	}



	@Override
	public List<JobPositions> getAll() {
		
		return jobpositionsdao.findAll();	
		
	}



	@Override
	public Result addJobPosition(JobPositions jobPositions) {
		
Result result = new ErrorResult("İş Pozisyonu Eklenemedi");

		
if (positionIsItUsed(jobPositions.getPosition())) {
	this.jobpositionsdao.save(jobPositions);
		return new SuccessResult("İş pozisyonu eklendi.");
}
return result;
	}

	
	
	
	public boolean positionIsItUsed(String positionName) {
		boolean result = true;
		if(getAllEmail().contains(positionName)) {
			result = false;
		}
		return result;
	}

	@Override
	public List<String> getAllEmail() {
		for (int i = 0; i < getAll().size(); i++) {
			jobPositions.add(getAll().get(i).getPosition());
		}
		return jobPositions;
	}

	
}
