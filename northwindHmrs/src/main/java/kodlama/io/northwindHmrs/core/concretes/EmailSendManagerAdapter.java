package kodlama.io.northwindHmrs.core.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emailService.EmailSendManager;
import kodlama.io.northwindHmrs.core.abstracts.EmailSendService;

	@Service
public class EmailSendManagerAdapter implements EmailSendService {

	private EmailSendManager emailSendManager;
	
	
	@Autowired
	public EmailSendManagerAdapter(EmailSendManager emailSendManager) {
	this.emailSendManager =emailSendManager;
}
	
	@Override
	public void emailSend(String email) {
		emailSendManager.emailSending(email);
	}
	
	

}
