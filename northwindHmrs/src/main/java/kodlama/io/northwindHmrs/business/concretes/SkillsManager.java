package kodlama.io.northwindHmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.SkillsService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.SkillsDao;
import kodlama.io.northwindHmrs.entities.concretes.Skills;

@Service
public class SkillsManager  implements SkillsService {

	private SkillsDao skillsDao;

	@Autowired
	public SkillsManager(SkillsDao skillsDao) {
		super();
		this.skillsDao = skillsDao;
	}

	@Override
	public Result add(Skills skills) {
		this.skillsDao.save(skills);
		return new SuccessResult("Data eklendi.");
	}

	@Override
	public DataResult<List<Skills>> getAll() {
		return new SuccessDataResult<List<Skills>>(this.skillsDao.findAll());
	}

}
