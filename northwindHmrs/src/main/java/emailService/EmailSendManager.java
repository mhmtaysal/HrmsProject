package emailService;

import org.springframework.stereotype.Service;

@Service
public class EmailSendManager {
	
	public void emailSending(String email) {
		System.out.println(email + " adresine doğrulama maili gönderildi.");
	}
	

}
