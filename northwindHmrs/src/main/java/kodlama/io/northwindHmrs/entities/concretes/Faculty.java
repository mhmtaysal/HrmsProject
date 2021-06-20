package kodlama.io.northwindHmrs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "faculties")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","CandidateSchool"})



public class Faculty {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name = "name")
//	@NotNull
//	@NotBlank
	private String name;
	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name = "university_id")
	private University university;
	
	@JsonIgnore
	@OneToMany(mappedBy = "faculty")
	private List<CandidateSchool> candidateSchools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "faculty")
	private List<Department> departments;

}
