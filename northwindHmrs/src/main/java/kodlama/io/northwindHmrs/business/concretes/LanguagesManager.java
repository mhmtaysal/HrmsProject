package kodlama.io.northwindHmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.LanguagesService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.LanguagesDao;
import kodlama.io.northwindHmrs.entities.concretes.Languages;

@Service
public class LanguagesManager implements LanguagesService  {
	private final LanguagesDao languagesDao;
	
	@Autowired
    public LanguagesManager(LanguagesDao languagesDao) {
        this.languagesDao = languagesDao;
    }

	@Override
	public Result add(Languages language) {
		  this.languagesDao.save(language);
	      return new SuccessResult("Data eklendi.");
	}

	@Override
	public DataResult<List<Languages>> getAll() {
		return new SuccessDataResult<List<Languages>>(this.languagesDao.findAll());
	}
}
