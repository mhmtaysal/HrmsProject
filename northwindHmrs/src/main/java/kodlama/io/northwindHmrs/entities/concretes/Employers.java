package kodlama.io.northwindHmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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


@EqualsAndHashCode(callSuper=false) // Sorulacak ?

public class Employers extends Users{



	@Id
	@Column(name = "id")
	@PrimaryKeyJoinColumn
	private int id;
	
	@Column(name = "companyname")
	private String compamyName;
	
	 @Column(name = "webaddress")
	private String webAdress;
	 
	    @Column(name = "phonenumber")

	private String phoneNumber;
	    
		public Employers(String email, String password, int id, String compamyName, String webAdress, String phoneNumber) {
			super(email, password);
			this.id = id;
			this.compamyName = compamyName;
			this.webAdress = webAdress;
			this.phoneNumber = phoneNumber;
		}
	    
	   
}
