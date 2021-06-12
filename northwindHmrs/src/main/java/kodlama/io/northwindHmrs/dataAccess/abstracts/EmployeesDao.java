package kodlama.io.northwindHmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwindHmrs.entities.concretes.Employees;

public interface  EmployeesDao extends JpaRepository<Employees, Integer> {
	

}
