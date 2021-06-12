package kodlama.io.northwindHmrs.business.abstracts;

import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;
import kodlama.io.northwindHmrs.entities.concretes.Employers;

public interface EmailService {
	
	Result sendActivationCodeCandidates(Candidates candidate, String activationCode);
	Result sendActivationCodeEmployers(Employers employer, String activationCode);
}



