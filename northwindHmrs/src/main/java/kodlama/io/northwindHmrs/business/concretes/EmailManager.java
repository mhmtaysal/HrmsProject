package kodlama.io.northwindHmrs.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.EmailService;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;
import kodlama.io.northwindHmrs.entities.concretes.Employers;

@Service
public class EmailManager implements EmailService {
	@Autowired
	public EmailManager() {
	}

	@Override
	public Result sendActivationCodeCandidates(Candidates candidate, String activationCode) {
		String message = "Sayın " + candidate.getFirstName() + " "+ candidate.getLastName() + ", "+  candidate.getEmail() + " mail adresinize gönderilen aktivasyon kodunuz: "+ activationCode;
		return new SuccessResult(message);
	}

	@Override
	public Result sendActivationCodeEmployers(Employers employer, String activationCode) {
		String message = "Değerli " + employer.getCompanyName() + " şirketi, "+ employer.getEmail() + " mail adresinize gönderilen aktivasyon kodunuz: "+ activationCode;
		return new SuccessResult(message);
	}

}
