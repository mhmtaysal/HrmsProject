package kodlama.io.northwindHmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwindHmrs.entities.concretes.ActivationCode;

public interface ActivationCodeDao extends  JpaRepository<ActivationCode, Integer> {
	ActivationCode findByActivationCode(String activation_code);

}
