package kodlama.io.northwindHmrs.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.northwindHmrs.core.ImageService.ImageService;
import kodlama.io.northwindHmrs.core.ImageService.Cloudinary.CloudinaryImageManager;

@Configuration
public class AppConfiguration {
	
	@Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dgfimpyp9",
                "api_key", "559497441591421",
                "api_secret", "qXZGvlycICDV5FBK3b4KEO0Oz4M"));
    }

    @Bean
    public ImageService imageService(){
        return new CloudinaryImageManager(cloudinaryService());
    }

}
