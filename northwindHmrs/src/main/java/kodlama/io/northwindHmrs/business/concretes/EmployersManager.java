package kodlama.io.northwindHmrs.business.concretes;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.base.Objects;
import kodlama.io.northwindHmrs.business.abstracts.EmployersService;
import kodlama.io.northwindHmrs.core.abstracts.EmailSendService;
import kodlama.io.northwindHmrs.core.utilities.results.ErrorResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.EmployersDao;
import kodlama.io.northwindHmrs.entities.concretes.Employers;
@Service
public class EmployersManager implements EmployersService{
	

	private EmployersDao employersDao;
	private EmailSendService emailSendService;
	private List<String> emails = new ArrayList<>();

	@Autowired
	public EmployersManager(EmployersDao employersDao, EmailSendService emailSendService) {
		super();
		this.employersDao = employersDao;
		this.emailSendService = emailSendService;
	}
	
	@Override
	public List<Employers> getAll() {
		return this.employersDao.findAll();

	}

	
	
	
	@Override
	public Result addEmplyers(Employers employers, String passwordAggain) {
	
		Result result = new ErrorResult("Kayıt Başarısız!");
		if(emailIsItUsed(
				employers.getEmail())&&
				Objects.equal(passwordAggain, employers.getPassword())){
			emailSendService.emailSend(employers.getEmail());
			this.employersDao.save(employers);
			result = new SuccessResult("Kayıt Başarılı");
		}
		return result;
		}
				
		
	


	@Override
	public List<String> getAllEmails() {
for(int i=0; i < getAll().size();i++) {
emails.add(getAll().get(i).getEmail());	
}
return emails;
}
		
	
	public boolean emailIsItUsed(String email) {
		boolean result = true;
		if (getAllEmails().contains(email)) {
			result = false;
		}
		return result;
		}
}