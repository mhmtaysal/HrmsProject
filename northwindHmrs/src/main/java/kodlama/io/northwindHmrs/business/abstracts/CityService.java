package kodlama.io.northwindHmrs.business.abstracts;

import java.util.List;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.entities.concretes.City;

public interface CityService {
	
	DataResult<List<City>> getAll();
}
