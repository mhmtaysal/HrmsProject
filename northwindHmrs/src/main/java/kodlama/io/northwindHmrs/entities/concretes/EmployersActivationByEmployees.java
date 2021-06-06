package kodlama.io.northwindHmrs.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers_activation_by_employees")
@NoArgsConstructor
@AllArgsConstructor

public class EmployersActivationByEmployees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "employers_id")
	private int employersId;
	
	@Column(name = "employees_id")
	private int employeesId;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	
	@Column(name = "confirmed_date", columnDefinition = "Date Default CURRENT_DATE")
	private LocalDate confirmedDate;
	

}
