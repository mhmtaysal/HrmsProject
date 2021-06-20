package kodlama.io.northwindHmrs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.CandidateLanguageService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.CandidateLanguageDao;
import kodlama.io.northwindHmrs.entities.concretes.CandidateLanguage;


@Service
public class CandidateLanguageManager implements CandidateLanguageService {

	private CandidateLanguageDao candidateLanguageDao; 
	
	
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
		super();
		this.candidateLanguageDao = candidateLanguageDao;
	}

	@Override
	public Result add(CandidateLanguage candidateLanguage) {
		this.candidateLanguageDao.save(candidateLanguage);
	      return new SuccessResult("Data eklendi.");
	}

	@Override
	public Result addAll(List<CandidateLanguage> candidateLanguage) {
		candidateLanguageDao.saveAll(candidateLanguage);
	      return new SuccessResult("Datalar eklendi.");
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAll() {
		  return new SuccessDataResult<>(this.candidateLanguageDao.findAll());
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<>(this.candidateLanguageDao.getAllByCandidateId(candidateId));
	}

}
