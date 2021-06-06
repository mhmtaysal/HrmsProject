package kodlama.io.northwindHmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwindHmrs.entities.concretes.Users;

public interface UserDao extends JpaRepository <Users, Integer> {
	Users findUsersByEmail(String email);
}
