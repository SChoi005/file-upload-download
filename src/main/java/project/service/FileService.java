package project.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import project.entity.File;
import project.repository.FileRepository;

@Service
public class FileService{
    
    @Autowired
    FileRepository fileRepository;
    
    public File store(MultipartFile file) throws IOException{
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        File f = new File();
        
        f.setFileName(fileName);
        f.setFileSize(file.getSize());
        f.setData(file.getBytes());
        f.setType(file.getContentType());
        
        return fileRepository.save(f);
    }
    
    
}