package kodlama.io.northwindHmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "employersid")
@EqualsAndHashCode(callSuper=true)

public class Employers extends Users{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "employersid")
	private int id;
	
	@Column(name = "companyname")
	private String companyName;
	
	@Column(name = "webaddress")
	private String webAddress;
	
	@Column(name = "phonenumber")
	private String phoneNumber;

}
