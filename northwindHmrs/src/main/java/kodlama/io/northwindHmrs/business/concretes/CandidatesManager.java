package kodlama.io.northwindHmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.CandidatesService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.ErrorResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.CandidatesDao;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;

@Service
public class CandidatesManager implements CandidatesService {

	

	private CandidatesDao candidatesDao;
	
	@Autowired
	public CandidatesManager(CandidatesDao candidatesDao) {
		this.candidatesDao=candidatesDao;
	}
	
	
	@Override
	public DataResult<List<Candidates>> getAll() {
		return new SuccessDataResult<List<Candidates>>(this.candidatesDao.findAll(),"Data Listelendi");

	}

	@Override
	public Result add(Candidates candidates) {
		return new SuccessDataResult<Candidates>(this.candidatesDao.save(candidates),"Kayıt Yapıldı");
	}

//	@Override
//	public Result isNationalityIdExist(String nationalityId) {
//
//		if (candidatesDao.findByNationalIdentity(nationalityId).isEmpty()) {
//			return new SuccessResult();
//
//		} else {
//			return new ErrorResult("Bu Tc kimlik no ile kayıtlı kullanıcı var.");
//		}
//	}

//	@Override
//	public Result isCandidatesEmailExist(String mail) {
//		if (candidatesDao.findByEmail(mail).isEmpty()) {
//			return new SuccessResult();
//
//		} else {
//			return new ErrorResult("Bu mail ile kayıtlı kullanıcı var.");
//		}
//	}


	@Override
	public DataResult<Candidates> getByNationalId(String nationalId) {
		return new SuccessDataResult<Candidates>(this.candidatesDao.findByNationalIdentity(nationalId));
	}



}
