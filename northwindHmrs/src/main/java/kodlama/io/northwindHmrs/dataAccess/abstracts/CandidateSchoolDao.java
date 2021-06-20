package kodlama.io.northwindHmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwindHmrs.entities.concretes.CandidateSchool;

public interface CandidateSchoolDao extends JpaRepository<CandidateSchool, Integer>  {

	
	List<CandidateSchool> getByCandidateId(int candidateId);
	List<CandidateSchool> getAllByCandidateIdOrderByEndedDate(int candidateId);
	
	
}
