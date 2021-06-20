package kodlama.io.northwindHmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwindHmrs.entities.concretes.Skills;

public interface SkillsDao extends JpaRepository<Skills, Integer> {

}
