package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;

public interface CandidatesService {
public Result addCandidates(Candidates candidates,String passwordAgain);

public List<Candidates> getAll();
public List<String> getAllEmails();
public List<String> getAllNationalityId();

}
