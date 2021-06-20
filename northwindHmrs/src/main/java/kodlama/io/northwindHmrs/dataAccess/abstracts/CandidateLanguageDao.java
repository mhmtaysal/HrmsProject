package kodlama.io.northwindHmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwindHmrs.entities.concretes.CandidateLanguage;

public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage, Integer>  {

	

	   List<CandidateLanguage> getAllByCandidateId(int candidateId);
		List<CandidateLanguage> getByCandidateId(int candidateId);
		
		
}
