package kodlama.io.northwindHmrs.core.abstracts;

import kodlama.io.northwindHmrs.entities.concretes.Candidates;

public interface MernisCheckService {

	public boolean checkIfRealPerson(Candidates candidates);
}
