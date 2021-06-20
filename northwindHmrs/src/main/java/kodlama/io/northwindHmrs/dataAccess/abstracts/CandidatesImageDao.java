package kodlama.io.northwindHmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwindHmrs.entities.concretes.CandidatesImage;

public interface CandidatesImageDao extends JpaRepository<CandidatesImage, Integer> {

	List<CandidatesImage> getAllByCandidateId(int candidateId);
	  List<CandidatesImage> getByCandidateId(int candidateId);
}
