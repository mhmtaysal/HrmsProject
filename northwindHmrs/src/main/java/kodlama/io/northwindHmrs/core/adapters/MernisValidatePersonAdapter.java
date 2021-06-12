package kodlama.io.northwindHmrs.core.adapters;

import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.entities.concretes.Candidates;
import mernisService.FakeMernisValidationService;
@Service
public class MernisValidatePersonAdapter implements ValidatePersonService {

	@Override
	public boolean CheckIfRealPerson(Candidates candidate) {
		FakeMernisValidationService client = new FakeMernisValidationService();
		boolean result = client.validatePerson(candidate);
		return result; 
		}

}
