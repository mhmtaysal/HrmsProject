package kodlama.io.northwindHmrs.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate_experiences")

public class CandidateExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name = "company_name")
	private String companyName;
	
	@ManyToOne()
	@JoinColumn(name = "position_id")
	private JobPosition position;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "leave_date")
	private Date leaveDate;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidates candidate;

}
