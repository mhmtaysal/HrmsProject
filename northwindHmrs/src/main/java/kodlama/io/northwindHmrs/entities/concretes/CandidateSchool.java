package kodlama.io.northwindHmrs.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate_schools")
public class CandidateSchool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;

	
	@ManyToOne(targetEntity = Candidates.class,fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "candidate_id")
	private Candidates candidate;
	
	
	@Column(name = "started_date")
	@NotNull
	private Date startedDate;
	
	@Column(name = "ended_date")
	private Date endedDate;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@ManyToOne()
	@JoinColumn(name = "department_id")
	private Department department;
	
	@ManyToOne()
	@JoinColumn(name = "university_id")
	private University university;
	
	//targetEntity = Faculty.class,fetch = FetchType.LAZY,optional = false
	
	@ManyToOne()
	@JoinColumn(name = "faculty_id")
	private Faculty faculty;
	
	
}
