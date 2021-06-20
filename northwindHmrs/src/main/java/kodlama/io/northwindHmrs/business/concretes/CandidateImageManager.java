package kodlama.io.northwindHmrs.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.northwindHmrs.business.abstracts.CandidateImageService;
import kodlama.io.northwindHmrs.core.ImageService.ImageService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.CandidatesImageDao;
import kodlama.io.northwindHmrs.entities.concretes.CandidatesImage;

@Service
public class CandidateImageManager implements CandidateImageService{
	private CandidatesImageDao candidateImageDao;
	private ImageService imageService;
	
	
	public CandidateImageManager(CandidatesImageDao candidateImageDao, ImageService imageService) {
		super();
		this.candidateImageDao = candidateImageDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(CandidatesImage candidatesImage) {
		this.candidateImageDao.save(candidatesImage);
	      return new SuccessResult("Data eklendi.");
	}

	@Override
	public Result addAll(List<CandidatesImage> candidatesImages) {
		candidateImageDao.saveAll(candidatesImages);
	      return new SuccessResult("Datalar eklendi.");
	}

//	look again ?
	@Override
	public Result add(CandidatesImage candidatesImage, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
        String url = result.get("url");
        candidatesImage.setUrl(url);
        candidatesImage.setUploadedDate(LocalDateTime.now());
        return add(candidatesImage);
	}

	@Override
	public DataResult<List<CandidatesImage>> getAll() {
		return new SuccessDataResult<>(this.candidateImageDao.findAll());
	}

	@Override
	public DataResult<List<CandidatesImage>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<>(this.candidateImageDao.getAllByCandidateId(candidateId));
	}

}
