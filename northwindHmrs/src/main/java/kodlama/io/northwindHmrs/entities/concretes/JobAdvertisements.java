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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisements")


public class JobAdvertisements {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //AutoIncrement 
	@Column(name = "id")
	private int id;
	

	@Column(name = "job_detail")
	private String jobDetail;
	
	@Column(name = "min_salary")
	private double minSalary;
	
	@Column(name = "max_salary")
	private double maxSalary;
	
	
	@Column(name = "position_quota")
	private int positionQuota;
	
	@Column(name = "application_deadline")
	private Date applicationDeadline;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "job_list_date")
	private Date jobListDate;
	//(targetEntity = Employers.class,fetch = FetchType.LAZY,optional = false)
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employers employer;
	
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	
	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobPosition jobPosition;
	
}
