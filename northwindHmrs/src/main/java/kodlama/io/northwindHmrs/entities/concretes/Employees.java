package kodlama.io.northwindHmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
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
	@Id
	@Column(name="employeesid")
	@PrimaryKeyJoinColumn
	private int emplyeesid;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	public Employees(String email, String password, String firstname, String lastname) {
		super(email, password);
		this.firstname = firstname;
		this.lastname = lastname;
	}

	

}
