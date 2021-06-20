package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.CandidateSchool;

public interface CandidateSchoolService {
	 Result add(CandidateSchool candidateSchool);
	 DataResult<List<CandidateSchool>> getAll();
	 Result addAll(List<CandidateSchool> candidateSchools);
	 DataResult<List<CandidateSchool>> getAllByCandidatesIdOrderByEndedDate(int candidateId);

}
