package kodlama.io.northwindHmrs.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.ActivationCodeService;
import kodlama.io.northwindHmrs.business.abstracts.AuthService;
import kodlama.io.northwindHmrs.business.abstracts.CandidatesService;
import kodlama.io.northwindHmrs.business.abstracts.EmailService;
import kodlama.io.northwindHmrs.business.abstracts.EmployersService;
import kodlama.io.northwindHmrs.business.abstracts.ValidationService;
import kodlama.io.northwindHmrs.core.utilities.results.ErrorResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.ActivationCodeDao;
import kodlama.io.northwindHmrs.entities.concretes.ActivationCode;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;
import kodlama.io.northwindHmrs.entities.concretes.Employers;
import kodlama.io.northwindHmrs.entities.concretes.Users;

@Service

public class AuthManager implements AuthService{

	
	
	private EmailService emailService;
	private CandidatesService candidatesService;
	private EmployersService employersService;
	private ActivationCodeService activationCodeService;
	private ValidationService validationService;
	private ActivationCodeDao activationCodeDao;
	
	
	
	
	
	
	

	@Autowired
	public AuthManager(EmailService emailService, CandidatesService candidatesService,
			 EmployersService employersService, ActivationCodeService activationCodeService,
			ValidationService validationService,ActivationCodeDao activationCodeDao) {
		super();
		this.emailService = emailService;
		this.candidatesService = candidatesService;
		this.employersService = employersService;
		this.activationCodeService = activationCodeService;
		this.validationService = validationService;
		this.activationCodeDao = activationCodeDao;
	}
	
	

	@Override
	public Result registerCandidates(Candidates candidate, String confirmPassword) {
		
		if(!validationService.CheckIfMernisPerson(candidate)) {
			return new ErrorResult("Not verified by the mernis system");
		}
		
		if(!validationService.checkIfExistNationalId(candidate.getNationalIdentity())) {
			return new ErrorResult("This nationalId is already Exist");
		}
		
		

		if(!validationService.checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult(candidate.getEmail() + " invalid email address.");
		}
		
		if(!validationService.checkIfNullinfoForCandidates(candidate)) {
			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}
		
		if(!validationService.checkIfConfirmPassword(candidate.getPassword(), confirmPassword)) {
			return new ErrorResult("Passwords do not match.");
		}
		
		if(!validationService.isValidEmail(candidate.getEmail())) {
			return new ErrorResult("Your email address is incorrect!");
		}
		
		
		String activationCode = createActivationCode();
		this.candidatesService.add(candidate);
		createActivationProcess(candidate, activationCode);
		
		return emailService.sendActivationCodeCandidates(candidate, activationCode);
		
		

	}

	
	
	
	@Override
	public Result registerEmployers(Employers employer, String confirmPassword) {
		if(!validationService.checkIfNullinfoForEmployers(employer)) {
			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}
		
		if(!validationService.checkEmailAndDomain(employer.getEmail(), employer.getWebAddress())) {
			return new ErrorResult("Invalid email address.");
		}
		
		if(!validationService.checkIfEmailExists(employer.getEmail())) {
			return new ErrorResult(employer.getEmail() + " invalid email address.");
		}
		
		if(!validationService.checkIfConfirmPassword(employer.getPassword(), confirmPassword)) {
			return new ErrorResult("Passwords do not match.");
		}
		
		if(!validationService.isValidEmail(employer.getEmail())) {
			return new ErrorResult("Your email address is incorrect!");
		}
		
		
		String activationCode = createActivationCode();
		this.employersService.addEmployer(employer);
		createActivationProcess(employer, activationCode);
		
		return emailService.sendActivationCodeEmployers(employer, activationCode);
	}

	
	
	
	
	
	@Override
	public Result confirmEmail(int id, String confirmActivationCode) {
		ActivationCode activationCodeTable = activationCodeDao.getOne(id);	
		if(activationCodeTable.getId() != id) {
			return new ErrorResult("Id uyuşmadı!!");
		}
		
		else if(!activationCodeDao.findById(activationCodeTable.getId()).isPresent()) {
			return new ErrorResult("Activation Code Tablosunda "+ id + " id numarasına sahip kişi bulunumadı!!");
		}
		
		else if(!confirmActivationCode.equals(activationCodeTable.getActivationCode())) {
			return new ErrorResult("Email Doğrulama kodunuz hatalı!");
		}
		
		else if(activationCodeTable.isConfirmed() == false){
			activationCodeTable.setConfirmed(true);
			activationCodeDao.save(activationCodeTable);
			return new SuccessResult("E-mail Doğrulama Başarılı!");
		}
		else {
			return new ErrorResult("is_confirmed zaten true!");
		}
		
		
	}
	
	
	
    private String createActivationCode() {
    	int upperBound = 9999, lowerBound = 1000;
		int randomCode = lowerBound + (int) (Math.random()*(upperBound - lowerBound)+1);
	    String code = String.valueOf(randomCode);
		return code;
	}

    private void createActivationProcess(Users user, String activationCode) {
		ActivationCode activationObject = new ActivationCode();		
		activationObject.setUserId(user.getId());
		activationObject.setConfirmed(false);
		activationObject.setActivationCode(activationCode);
		this.activationCodeService.add(activationObject);
	}
    
    

}
