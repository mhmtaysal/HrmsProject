package kodlama.io.northwindHmrs.core.adapters;

import kodlama.io.northwindHmrs.entities.concretes.Candidates;

public interface ValidatePersonService {
	boolean CheckIfRealPerson(Candidates candidate);
}