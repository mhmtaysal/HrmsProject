package kodlama.io.northwindHmrs.entities.concretes;


import java.util.Date;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="activation_codes")
public class ActivationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "activation_code")
	private String activationCode;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	
	@Column(name = "confirm_date",columnDefinition = "Date Default CURRENT_DATE")
	
	private Date confirmDate;
}