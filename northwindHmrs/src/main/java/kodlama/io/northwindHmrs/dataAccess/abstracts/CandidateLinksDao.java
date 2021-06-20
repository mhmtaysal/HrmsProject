package kodlama.io.northwindHmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwindHmrs.entities.concretes.CandidateLinks;

public interface CandidateLinksDao extends JpaRepository<CandidateLinks, Integer> {

	List<CandidateLinks> getAllByCandidateId(int candidateId);
	List<CandidateLinks> getByCandidateId(int candidateId);
	
}
