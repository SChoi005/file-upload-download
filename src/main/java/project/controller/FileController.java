package project.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.entity.File;
import project.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController{
    
    @Autowired
    FileService fileService;
    
    @PostMapping("/upload")
    public void fileUpload(@RequestParam("file") MultipartFile file) throws IOException{
        fileService.store(file);
    }
    
    @PostMapping("/multi-upload")
    public void fileUpload(@RequestParam("file") MultipartFile[] files) throws IOException{
        for(MultipartFile file:files){
            fileService.store(file);
        }
    }
    
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> fileDownload(@PathVariable Long id){
        
        File file = fileService.getFile(id);
        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(file.getData());
    }
    
}