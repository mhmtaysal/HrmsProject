package kodlama.io.northwindHmrs.core.ImageService;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.northwindHmrs.core.utilities.results.DataResult;


public interface ImageService {

	 DataResult<?> save(MultipartFile file);
	 
}
