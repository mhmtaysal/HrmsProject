package kodlama.io.northwindHmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwindHmrs.entities.concretes.CandidateSkills;

public interface CandidateSkillsDao extends JpaRepository<CandidateSkills, Integer>{

	 List<CandidateSkills> getAllByCandidateId(int candidateId);
	 List<CandidateSkills> getByCandidateId(int candidateId);
}
