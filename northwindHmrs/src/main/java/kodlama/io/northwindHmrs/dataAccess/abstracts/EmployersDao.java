package kodlama.io.northwindHmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwindHmrs.entities.concretes.Employers;

public interface EmployersDao extends JpaRepository<Employers, Integer>{
 Employers getByEmail(String email);
}
