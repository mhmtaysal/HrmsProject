package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.CandidateExperience;

public interface CandidateExperiencesService {



	Result add(CandidateExperience candidateExperience);

	Result addAll(List<CandidateExperience> candidateExperience);

	DataResult<List<CandidateExperience>> getAll();

	DataResult<List<CandidateExperience>> getAllByCandidateIdOrderByLeaveDate(int candidateId);
}
