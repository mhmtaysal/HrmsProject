package kodlama.io.northwindHmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.CandidateExperiencesService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.CandidateExperienceDao;
import kodlama.io.northwindHmrs.entities.concretes.CandidateExperience;

@Service
public class CandidateExperienceManager implements CandidateExperiencesService  {

	private CandidateExperienceDao candidateExperiencesDao;
	@Autowired
	public CandidateExperienceManager(CandidateExperienceDao candidateExperiencesDao) {
		super();
		this.candidateExperiencesDao = candidateExperiencesDao;
	}

	@Override
	public Result add(CandidateExperience candidateExperience) {
this.candidateExperiencesDao.save(candidateExperience);
		return new SuccessResult("Data eklendi.");
	}

	@Override
	public Result addAll(List<CandidateExperience> candidateExperience) {
		candidateExperiencesDao.saveAll(candidateExperience);
	      return new SuccessResult("Datalar eklendi.");
	}

	@Override
	public DataResult<List<CandidateExperience>> getAll() {
		return new SuccessDataResult<>(this.candidateExperiencesDao.findAll());
	}

	@Override
	public DataResult<List<CandidateExperience>> getAllByCandidateIdOrderByLeaveDate(int candidateId) {
		return new SuccessDataResult<>(this.candidateExperiencesDao.getAllByCandidateIdOrderByLeaveDateDesc(candidateId));
		}

	
}
