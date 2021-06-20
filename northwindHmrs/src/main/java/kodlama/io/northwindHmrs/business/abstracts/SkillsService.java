package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.entities.concretes.Skills;

public interface SkillsService {
	
	Result add(Skills skills);

	DataResult<List<Skills>> getAll();
	
	

}
