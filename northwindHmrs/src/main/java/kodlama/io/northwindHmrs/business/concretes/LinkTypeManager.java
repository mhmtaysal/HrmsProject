package kodlama.io.northwindHmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlama.io.northwindHmrs.business.abstracts.LinkTypeService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.LinkTypeDao;
import kodlama.io.northwindHmrs.entities.concretes.LinkTypes;

public class LinkTypeManager implements LinkTypeService {

	private LinkTypeDao linkTypeDao;

	@Autowired
	public LinkTypeManager(LinkTypeDao linkTypeDao) {
		super();
		this.linkTypeDao = linkTypeDao;
	}

	@Override
	public Result add(LinkTypes linkTypes) {
		this.linkTypeDao.save(linkTypes);
		return new SuccessResult("Data eklendi.");
	}

	@Override
	public DataResult<List<LinkTypes>> getAll() {
		return new SuccessDataResult<List<LinkTypes>>(this.linkTypeDao.findAll());
	}

}

	
	
	

