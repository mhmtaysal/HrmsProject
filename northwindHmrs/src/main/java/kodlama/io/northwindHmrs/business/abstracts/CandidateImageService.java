package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.CandidatesImage;

public interface CandidateImageService {
	
	Result add(CandidatesImage candidatesImage);

	Result addAll(List<CandidatesImage> candidatesImages);

	Result add(CandidatesImage candidatesImage, MultipartFile file);

	DataResult<List<CandidatesImage>> getAll();

	DataResult<List<CandidatesImage>> getAllByCandidateId(int candidateId);

}
