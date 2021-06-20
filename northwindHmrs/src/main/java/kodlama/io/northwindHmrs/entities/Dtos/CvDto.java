package kodlama.io.northwindHmrs.entities.Dtos;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlama.io.northwindHmrs.entities.abstracts.Dto;
import kodlama.io.northwindHmrs.entities.concretes.CandidateExperience;
import kodlama.io.northwindHmrs.entities.concretes.CandidateLanguage;
import kodlama.io.northwindHmrs.entities.concretes.CandidateLinks;
import kodlama.io.northwindHmrs.entities.concretes.CandidateSchool;
import kodlama.io.northwindHmrs.entities.concretes.CandidateSkills;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;
import kodlama.io.northwindHmrs.entities.concretes.CandidatesImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
 
public class CvDto implements Dto {
	

	 @JsonIgnore
	 private Candidates candidate;
	 private List<@Valid CandidateSchool> candidateSchools;
	 private List<@Valid CandidateLanguage> candidateLanguages;
	 private List<@Valid CandidateSkills> candidateSkills;
	 private List<@Valid CandidateLinks> candidateLinks;
	 private List<@Valid CandidateExperience> candidateExperiences;
	 private List<@Valid CandidatesImage> candidateImages;
	 
	 

}
