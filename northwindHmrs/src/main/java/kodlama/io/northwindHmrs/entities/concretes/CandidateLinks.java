package kodlama.io.northwindHmrs.entities.concretes;

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
@Table(name = "candidate_links")


public class CandidateLinks {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name = "link")
    private String link;
	
	@ManyToOne()
	@JoinColumn(name = "link_id")
	private LinkTypes linkId;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidates candidate;
	

}
