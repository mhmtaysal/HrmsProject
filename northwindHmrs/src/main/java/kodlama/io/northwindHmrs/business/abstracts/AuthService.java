package kodlama.io.northwindHmrs.business.abstracts;

import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;
import kodlama.io.northwindHmrs.entities.concretes.Employers;

public interface AuthService {
	
	Result registerCandidates(Candidates candidate, String confirmPassword);
	Result registerEmployers(Employers  employer, String confirmPassword);
	Result confirmEmail(int id, String confirmActivationCode);

}
