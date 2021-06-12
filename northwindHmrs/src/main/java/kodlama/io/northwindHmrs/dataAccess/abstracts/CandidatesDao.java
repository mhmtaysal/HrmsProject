package kodlama.io.northwindHmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwindHmrs.entities.concretes.Candidates;

public interface CandidatesDao extends JpaRepository<Candidates, Integer>{
Candidates getByEmail(String email);
Candidates findByNationalIdentity (String nationalityId);
List<Candidates> findByEmail(String mail);
}
