package kodlama.io.northwindHmrs.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwindHmrs.entities.concretes.Users;



public interface UsersDao extends JpaRepository<Users, Integer>  {
    
   Users findByEmail(String email);
}
