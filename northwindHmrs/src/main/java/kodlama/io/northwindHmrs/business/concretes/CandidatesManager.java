package kodlama.io.northwindHmrs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import kodlama.io.northwindHmrs.business.abstracts.CandidatesService;
import kodlama.io.northwindHmrs.core.abstracts.EmailCheckService;
import kodlama.io.northwindHmrs.core.abstracts.EmailSendService;
import kodlama.io.northwindHmrs.core.abstracts.MernisCheckService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.ErrorResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.CandidatesDao;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;
@Service
public class CandidatesManager implements CandidatesService{


	private EmailCheckService emailCheckService;
	private CandidatesDao candidatesdao;
	private EmailSendService emailSendService;
	private MernisCheckService mernisCheckService;
	
	private List<String> emails = new ArrayList<>();
	private List<String> nationalityIds = new ArrayList<>();
	

	@Autowired
	public CandidatesManager(EmailCheckService emailCheckService, CandidatesDao candidatesdao,
			EmailSendService emailSendService, MernisCheckService mernisCheckService) {
		super();
		this.emailCheckService = emailCheckService;
		this.candidatesdao = candidatesdao;
		this.emailSendService = emailSendService;
		this.mernisCheckService = mernisCheckService;
	}

	
	@Override
	public Result addCandidates(Candidates candidates, String passwordAgain) {
		Result result = new ErrorResult("Kayıt Başarısız!");
		
		if (
			emailCheckService.emailCheck(candidates.getEmail()) &&
			emailIsItUsed(candidates.getEmail()) &&
			nationalityIdUsed(candidates.getNationalIdentity()) &&
			mernisCheckService.checkIfRealPerson(candidates) &&
			Objects.equal(passwordAgain, candidates.getPassword())){
			emailSendService.emailSend(candidates.getEmail());
			this.candidatesdao.save(candidates);
			result = new SuccessResult("Kayıt Başarılı");				
			}
				
				
		return result;
	}
	
	
	

	

	@Override
	public List<Candidates> getAll() {
return this.candidatesdao.findAll();
	}

	@Override
	public List<String> getAllEmails() {
		for (int i = 0; i < getAll().size(); i++) {
			emails.add(getAll().get(i).getEmail());
		}
		return emails;
	}

	@Override
	public List<String> getAllNationalityId() {
		for (int i = 0; i < getAll().size(); i++) {
			nationalityIds.add(getAll().get(i).getNationalIdentity());
		}
		return nationalityIds;
	}
	
	
	
	
	public boolean emailIsItUsed(String email) {
		
		boolean result = true;
		if(getAllEmails().contains(email)) {
			return false;
		}
		return result;
	}
	
	
	public boolean nationalityIdUsed(String nationalityId) {
		
		boolean result = true;
				if(getAllNationalityId().contains(nationalityId)) {
					
					result = false;}
				return result;
	}
	

}
