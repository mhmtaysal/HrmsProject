package kodlama.io.northwindHmrs.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.CandidateExperiencesService;
import kodlama.io.northwindHmrs.business.abstracts.CandidateImageService;
import kodlama.io.northwindHmrs.business.abstracts.CandidateLanguageService;
import kodlama.io.northwindHmrs.business.abstracts.CandidateLinksService;
import kodlama.io.northwindHmrs.business.abstracts.CandidateSchoolService;
import kodlama.io.northwindHmrs.business.abstracts.CandidateSkillsService;
import kodlama.io.northwindHmrs.business.abstracts.CvDtoService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.CandidateExperienceDao;
import kodlama.io.northwindHmrs.dataAccess.abstracts.CandidateLanguageDao;
import kodlama.io.northwindHmrs.dataAccess.abstracts.CandidateLinksDao;
import kodlama.io.northwindHmrs.dataAccess.abstracts.CandidateSchoolDao;
import kodlama.io.northwindHmrs.dataAccess.abstracts.CandidateSkillsDao;
import kodlama.io.northwindHmrs.dataAccess.abstracts.CandidatesDao;
import kodlama.io.northwindHmrs.dataAccess.abstracts.CandidatesImageDao;
import kodlama.io.northwindHmrs.entities.Dtos.CvDto;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;

@Service
public class CvDtoManager implements CvDtoService {

	
	private CandidatesDao candidateDao;
	private CandidateSchoolDao  candidateSchoolDao;
	private CandidateSchoolService candidateSchoolService;
	private CandidateLanguageDao candidateLanguageDao;
	private CandidateLanguageService candidateLanguageService;
	private CandidateSkillsDao candidateSkillsDao;
	private CandidateSkillsService candidateSkillsService;
	private CandidateLinksDao candidateLinksDao;
	private CandidateLinksService candidateLinksService;
	private CandidateExperienceDao candidateExperiencesDao;
	private CandidateExperiencesService candidateExperiencesService;
	private CandidateImageService candidateImageService;
	private CandidatesImageDao candidateImageDao;
	
	@Autowired
	public CvDtoManager(CandidatesDao candidateDao, CandidateSchoolDao candidateSchoolDao,
			CandidateSchoolService candidateSchoolService, CandidateLanguageDao candidateLanguageDao,
			CandidateLanguageService candidateLanguageService, CandidateSkillsDao candidateSkillsDao,
			CandidateSkillsService candidateSkillsService, CandidateLinksDao candidateLinksDao,
			CandidateLinksService candidateLinksService, CandidateExperienceDao candidateExperiencesDao,
			CandidateExperiencesService candidateExperiencesService, CandidateImageService candidateImageService,
			CandidatesImageDao candidateImageDao) {
		super();
		this.candidateDao = candidateDao;
		this.candidateSchoolDao = candidateSchoolDao;
		this.candidateSchoolService = candidateSchoolService;
		this.candidateLanguageDao = candidateLanguageDao;
		this.candidateLanguageService = candidateLanguageService;
		this.candidateSkillsDao = candidateSkillsDao;
		this.candidateSkillsService = candidateSkillsService;
		this.candidateLinksDao = candidateLinksDao;
		this.candidateLinksService = candidateLinksService;
		this.candidateExperiencesDao = candidateExperiencesDao;
		this.candidateExperiencesService = candidateExperiencesService;
		this.candidateImageService = candidateImageService;
		this.candidateImageDao = candidateImageDao;
	}

	@Override
	public Result add(CvDto cvDto, int candidateId) {
		Candidates candidate = this.candidateDao.findById(candidateId).get();
        cvDto.setCandidate(candidate);

        cvDto.getCandidateSchools().forEach(candidateSchool -> candidateSchool.setCandidate(candidate));
        candidateSchoolService.addAll(cvDto.getCandidateSchools());
        
        cvDto.getCandidateLanguages().forEach(candidateLanguage -> candidateLanguage.setCandidate(candidate));
        candidateLanguageService.addAll(cvDto.getCandidateLanguages());
        
        cvDto.getCandidateSkills().forEach(candidateSkills -> candidateSkills.setCandidate(candidate));
        candidateSkillsService.addAll(cvDto.getCandidateSkills());
        
        cvDto.getCandidateLinks().forEach(candidateLinks -> candidateLinks.setCandidate(candidate));
        candidateLinksService.addAll(cvDto.getCandidateLinks());
      
        cvDto.getCandidateExperiences().forEach(candidateExperiences -> candidateExperiences.setCandidate(candidate));
        candidateExperiencesService.addAll(cvDto.getCandidateExperiences());
        
        cvDto.getCandidateImages().forEach(candidateImage -> candidateImage.setCandidate(candidate));
        candidateImageService.addAll(cvDto.getCandidateImages());
        
        
        return new SuccessResult("Okullar ve Diller Cv'ye eklendi.");
	}

	@Override
	public DataResult<CvDto> getCVByCandidate(int candidateId) {
		CvDto cvDto = new CvDto();
		cvDto.setCandidate(this.candidateDao.getById(candidateId));
		cvDto.setCandidateSchools(this.candidateSchoolDao.getAllByCandidateIdOrderByEndedDate(candidateId));
		cvDto.setCandidateLanguages(this.candidateLanguageDao.getByCandidateId(candidateId));
		cvDto.setCandidateSkills(this.candidateSkillsDao.getByCandidateId(candidateId));
		cvDto.setCandidateLinks(this.candidateLinksDao.getByCandidateId(candidateId));
		cvDto.setCandidateExperiences(this.candidateExperiencesDao.getAllByCandidateIdOrderByLeaveDateDesc(candidateId));
		cvDto.setCandidateImages(this.candidateImageDao.getByCandidateId(candidateId));
	

		return new SuccessDataResult<CvDto>(cvDto);
	}

}
