package kodlama.io.northwindHmrs.business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlama.io.northwindHmrs.business.abstracts.CandidatesService;
import kodlama.io.northwindHmrs.business.abstracts.UserService;
import kodlama.io.northwindHmrs.business.abstracts.ValidationService;
import kodlama.io.northwindHmrs.core.adapters.ValidatePersonService;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;
import kodlama.io.northwindHmrs.entities.concretes.Employers;


@Service
public class ValidationManager implements ValidationService  {
	
	private UserService userService;
	private CandidatesService candidateService;	
	private ValidatePersonService validatePersonService;
	
	@Autowired
	public ValidationManager(UserService userService, CandidatesService candidateService,
			ValidatePersonService validatePersonService) {
		super();
		this.userService = userService;
		this.candidateService = candidateService;
		this.validatePersonService = validatePersonService;
	}

	@Override
	public boolean CheckIfMernisPerson(Candidates candidate) {
		
		return validatePersonService.CheckIfRealPerson(candidate);
	}

	@Override
	public boolean checkIfExistNationalId(String nationalId) {
		return candidateService.getByNationalId(nationalId).getData() == null;
		}

	@Override
	public boolean checkIfNullinfoForCandidates(Candidates candidate) {
		
		

		if(candidate.getFirstName() != null && !candidate.getFirstName().isEmpty() &&
		   candidate.getEmail() != null && !candidate.getEmail().isEmpty() &&
		   candidate.getPassword() != null && !candidate.getPassword().isEmpty() &&
		   candidate.getLastName() != null && !candidate.getLastName().isEmpty() &&
		   candidate.getNationalIdentity() != null && !candidate.getNationalIdentity().isEmpty() &&
		   candidate.getDateOfBirth() != null
		   )
		{
			return true;
		}
				
		return false;
	}

	@Override
	public boolean checkIfNullinfoForEmployers(Employers employer) {

		if(employer.getCompanyName() != null && !employer.getCompanyName().isEmpty() &&
		   employer.getEmail() != null && !employer.getEmail().isEmpty() &&
		   employer.getPassword() != null && !employer.getPassword().isEmpty() &&
		   employer.getPhoneNumber() != null && !employer.getPhoneNumber().isEmpty() &&
		   employer.getWebAddress() != null && !employer.getWebAddress().isEmpty() 
		  )
		{
			return true;
		}
				
		return false;
	}

	@Override
	public boolean checkEmailAndDomain(String email, String website) {

		String mailDomain = email.split("@")[1];
		
		return mailDomain.equals(website);
	}

	@Override
	public boolean checkIfEmailExists(String email) {
		return this.userService.getUsersByEmail(email).getData()==null;
		
	}

	@Override
	public boolean checkIfConfirmPassword(String password, String confirmPassword) {
		return password.equals(confirmPassword);
	}

	
	
	@Override
	public boolean isValidEmail(String email) {
		String emailRegex = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{3}\\b";

	    Pattern pat = Pattern.compile(emailRegex);
	    if (email == null)
	        return false;
	    return pat.matcher(email).matches();
	}

	
	
}
