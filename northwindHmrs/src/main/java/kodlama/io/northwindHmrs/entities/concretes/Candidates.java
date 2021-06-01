package kodlama.io.northwindHmrs.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates")

@EqualsAndHashCode(callSuper=false)


public class Candidates extends Users {
   
	@Id
	@Column(name = "id")
	@PrimaryKeyJoinColumn
	private int id;

    @Column(name = "firstname")
    private String firstName;
    
    @Column(name = "lastname")
    private String lastName;
    
    @Column(name = "nationalidentity")
    private String nationalIdentity;
    
    @Column(name = "dateofbirth")
    private Date dateOfBirth;
    
    
    public Candidates(String email, String password, String firstName, String lastName, String nationalIdentity,
    		Date dateOfBirth) {
		super(email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalIdentity = nationalIdentity;
		this.dateOfBirth = dateOfBirth;
	}

    
    
}
