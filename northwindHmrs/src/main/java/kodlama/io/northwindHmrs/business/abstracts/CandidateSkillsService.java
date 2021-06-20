package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.CandidateSkills;

public interface CandidateSkillsService {


	Result add(CandidateSkills candidateSkills);

	Result addAll(List<CandidateSkills> candidateSkill);

	DataResult<List<CandidateSkills>> getAll();

	DataResult<List<CandidateSkills>> getAllByCandidateId(int candidateId);
}
