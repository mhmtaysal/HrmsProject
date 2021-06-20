package kodlama.io.northwindHmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwindHmrs.entities.concretes.CandidateExperience;

public interface CandidateExperienceDao extends JpaRepository<CandidateExperience, Integer>{
	List<CandidateExperience> getByCandidateId(int candidateId);
	 List<CandidateExperience> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId);
}
