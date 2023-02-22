package utn.comunicate.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService {
    
    Cloudinary cloudinary;

    private Map<String,String> ValuesMap = new HashMap<>( );

    public CloudinaryService () {
        ValuesMap.put("cloud_name", "dpjai1g99");
        ValuesMap.put("api_key", "143665652248698");
        ValuesMap.put("api_secret", "ltbw8C4hZ9By4laeUJ5Y7eGKlNs");
        cloudinary = new Cloudinary(ValuesMap);
    }   

    public Map upload (MultipartFile multipartFile) throws IOException{
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }

    public Map delete(String id) throws IOException{
        Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return result;
    }

    private File convert(MultipartFile multipartFile) throws IOException{
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }

}
