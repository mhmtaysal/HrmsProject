package kodlama.io.northwindHmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Data
 @EqualsAndHashCode(callSuper=false)

@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
public class Employees extends Users {
	
	@Column(name="employeesid")
	private int emplyeesid;
	
	@Column(name="firstname")
	private int firstname;
	
	@Column(name="lastname")
	private int lastname;
	
	
	

}
