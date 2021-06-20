package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.CandidateLanguage;

public interface CandidateLanguageService {
	
	Result add(CandidateLanguage candidateLanguage);
    Result addAll(List<CandidateLanguage> candidateLanguage);
    DataResult<List<CandidateLanguage>> getAll();
    DataResult<List<CandidateLanguage>> getAllByCandidateId(int candidateId);

}
