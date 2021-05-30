package kodlama.io.northwindHmrs.dataAccess.abstracts;

import kodlama.io.northwindHmrs.entities.concretes.Candidates;

import org.springframework.data.jpa.repository.JpaRepository;
public interface CandidatesDao extends JpaRepository<Candidates, Integer> {

}
