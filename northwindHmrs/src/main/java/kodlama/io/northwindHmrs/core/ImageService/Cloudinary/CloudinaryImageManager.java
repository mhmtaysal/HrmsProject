package kodlama.io.northwindHmrs.core.ImageService.Cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

import kodlama.io.northwindHmrs.core.ImageService.ImageService;
import kodlama.io.northwindHmrs.core.utilities.results.DataResult;
import kodlama.io.northwindHmrs.core.utilities.results.ErrorDataResult;
import kodlama.io.northwindHmrs.core.utilities.results.SuccessDataResult;

public class CloudinaryImageManager implements ImageService {


	 private final Cloudinary cloudinary;

	    @Autowired
	    public CloudinaryImageManager(Cloudinary cloudinary) {
	        this.cloudinary = cloudinary;
	    }
	    
	    
	@Override
	public DataResult<?> save(MultipartFile file) {
        try{
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(uploadResult);
        } catch (IOException e){
            e.printStackTrace();
        }
        return new ErrorDataResult<Map>();
	}

}
