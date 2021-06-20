package kodlama.io.northwindHmrs.business.abstracts;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.Dtos.CvDto;

public interface CvDtoService {

	  Result add(CvDto cvDto,int candidateId);
	  DataResult<CvDto> getCVByCandidate(int candidateId);

}
