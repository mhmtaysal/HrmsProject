package kodlama.io.northwindHmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwindHmrs.entities.concretes.EmployersActivationByEmployees;

public interface EmployersActivationByEmployeesDao extends JpaRepository<EmployersActivationByEmployees, Integer>{

}
