package kodlama.io.northwindHmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwindHmrs.business.abstracts.JobAdvertisementService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.ErrorResult;
import kodlama.io.northwindHmrs.core.utilities.results.Result;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessResult;
import kodlama.io.northwindHmrs.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.northwindHmrs.entities.concretes.JobAdvertisements;

@Service

public class JobAdvertsismentManager implements JobAdvertisementService {



	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertsismentManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisements jobAdvertisements) {
		this.jobAdvertisementDao.save(jobAdvertisements);
		return new SuccessResult("İş ilanı eklendi.");
	}

	@Override
	public Result update(JobAdvertisements jobAdvertisements) {
		this.jobAdvertisementDao.save(jobAdvertisements);
		return new SuccessResult("İş ilanı güncellendi.");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertisementDao.deleteById(id);
		return new SuccessResult("İş ilanı kaldırıldı.");
	}

	@Override
	public Result changeToActive(int id) {
		if(getById(id) == null) {
			return new ErrorResult("Böyle bir iş ilanı yok!");
		}
		if (getById(id).getData().isActive() == false) {
			return new SuccessResult("İş ilani zaten kapalı!");
		
		}
		JobAdvertisements jobAdvertisements = getById(id).getData();
		jobAdvertisements.setActive(false);
		update(jobAdvertisements);
		return new SuccessResult("İş ilanı başarılı şekilde kapatıldı!");
	}

	@Override
	public DataResult<JobAdvertisements> getById(int id) {
		return new SuccessDataResult<JobAdvertisements>(this.jobAdvertisementDao.getOne(id));
	}

	@Override
	public DataResult<List<JobAdvertisements>> getAll() {
		return new SuccessDataResult<List<JobAdvertisements>>(this.jobAdvertisementDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvertisements>> getByIsActive() {
		return new SuccessDataResult<List<JobAdvertisements>>(this.jobAdvertisementDao.findByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisements>> getByIsActiveTrueOrderByApplicationDeadlineDesc() {
		return new SuccessDataResult<List<JobAdvertisements>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByApplicationDeadlineDesc());
	}

	@Override
	public DataResult<List<JobAdvertisements>> getByIsActiveTrueAndEmployerId(int id) {
		return new SuccessDataResult<List<JobAdvertisements>>(this.jobAdvertisementDao.findByIsActiveTrueAndEmployerId(id));
	}

}
