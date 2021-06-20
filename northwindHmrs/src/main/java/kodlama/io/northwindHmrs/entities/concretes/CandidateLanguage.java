package kodlama.io.northwindHmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate_languages")


public class CandidateLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	
	@Column(name = "level")
    @Min(1)
    @Max(5)
    @NotNull
    private short level;
	//targetEntity = Languages.class,fetch = FetchType.LAZY,optional = false
	@ManyToOne()
	@JoinColumn(name = "language_id")
	private Languages language;
	//targetEntity = Candidates.class,fetch = FetchType.LAZY,optional = false
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidates candidate;
}
