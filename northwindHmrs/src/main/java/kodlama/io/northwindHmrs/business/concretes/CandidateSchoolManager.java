package kodlama.io.northwindHmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.CandidateSchoolService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.ErrorResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.CandidateSchoolDao;
import kodlama.io.northwindHmrs.dataAccess.abstracts.CandidatesDao;
import kodlama.io.northwindHmrs.dataAccess.abstracts.DepartmentDao;
import kodlama.io.northwindHmrs.entities.concretes.CandidateSchool;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;
@Service
public class CandidateSchoolManager implements CandidateSchoolService {

	private CandidateSchoolDao candidateSchoolDao;
	private DepartmentDao departmentDao;
	private CandidatesDao candidatesDao;
	

	@Autowired
	public CandidateSchoolManager(CandidateSchoolDao candidateSchoolDao,DepartmentDao departmentDao,
			CandidatesDao candidatesDao) {
		super();
		this.candidateSchoolDao = candidateSchoolDao;
		this.departmentDao = departmentDao;
		this.candidatesDao = candidatesDao;
	}


	@Override
	public Result add(CandidateSchool candidateSchool) {
		if(this.departmentDao.getByDepartmentId(candidateSchool.getDepartment().getId(),
				candidateSchool.getUniversity().getId(), 
				candidateSchool.getFaculty().getId())==null) {
			return new ErrorResult("Data boş.");
		}
		
		Candidates candidate = this.candidatesDao.getOne(candidateSchool.getCandidate().getId());
		if(!candidatesDao.findById(candidate.getId()).isPresent()) {
			return new ErrorResult("Kullanıcı bulunamadı.");
		}
			
		this.candidateSchoolDao.save(candidateSchool);
		return new SuccessResult("Data eklendi.");
		
	}


	@Override
	public DataResult<List<CandidateSchool>> getAll() {
		return new SuccessDataResult<List<CandidateSchool>>(this.candidateSchoolDao.findAll());
	}


	@Override
	public Result addAll(List<CandidateSchool> candidateSchools) {
		candidateSchoolDao.saveAll(candidateSchools);
        return new SuccessResult("Data eklendi.");
	}


	@Override
	public DataResult<List<CandidateSchool>> getAllByCandidatesIdOrderByEndedDate(int candidateId) {
		return new SuccessDataResult<>(this.candidateSchoolDao.
				 getAllByCandidateIdOrderByEndedDate(candidateId), "Data sıralanarak listelendi.");
	}
	
	
}
