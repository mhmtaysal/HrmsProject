package kodlama.io.northwindHmrs.core.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import kodlama.io.northwindHmrs.core.abstracts.MernisCheckService;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;
@Component
@Primary
public class FakeMernisCheckAdapter implements MernisCheckService{

	@Override
	public boolean checkIfRealPerson(Candidates candidates) {
		return true;
	}

}
