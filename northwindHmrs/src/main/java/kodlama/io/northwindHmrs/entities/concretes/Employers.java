package kodlama.io.northwindHmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")


@PrimaryKeyJoinColumn(name="employersid")
@EqualsAndHashCode(callSuper=true) // Sorulacak ?

public class Employers extends Users{
	@Column(name = "companyname")
	private String compamyName;
	
	 @Column(name = "webaddress")
	private String webAdress;
	 
	    @Column(name = "phonenumber")

	private String phoneNumber;
	

}
