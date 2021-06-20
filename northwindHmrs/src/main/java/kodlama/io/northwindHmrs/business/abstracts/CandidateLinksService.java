package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.CandidateLinks;

public interface CandidateLinksService {
	

	Result add(CandidateLinks candidateLinks);
    Result addAll(List<CandidateLinks> candidateLinks);
    DataResult<List<CandidateLinks>> getAll();
    DataResult<List<CandidateLinks>> getAllByCandidateId(int candidateId);

}
