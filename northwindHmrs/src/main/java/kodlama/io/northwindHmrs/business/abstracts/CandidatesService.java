package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;

public interface CandidatesService {
	
	DataResult<List<Candidates>> getAll();
	Result add(Candidates candidates);
//	Result isNationalityIdExist(String nationalityId);
//	Result isCandidatesEmailExist(String mail);
	DataResult<Candidates> getByNationalId(String nationalId);

}
