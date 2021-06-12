package kodlama.io.northwindHmrs.business.abstracts;

import kodlama.io.northwindHmrs.entities.concretes.Candidates;
import kodlama.io.northwindHmrs.entities.concretes.Employers;

public interface ValidationService {
	boolean CheckIfMernisPerson(Candidates candidate);
	boolean checkIfExistNationalId(String nationalId);
	boolean checkIfNullinfoForCandidates(Candidates candidate);
	boolean checkIfNullinfoForEmployers(Employers employer);
	boolean checkEmailAndDomain(String email, String website);
	boolean checkIfEmailExists(String email);
	boolean isValidEmail(String email);
	boolean checkIfConfirmPassword(String password, String confirmPassword);
	
}

	


