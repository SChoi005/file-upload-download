package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController{
    
    @Autowired
    FileService fileService;
    
    @PostMapping("/upload")
    public void fileUpload(@RequestParam("file") MultipartFile file){

    }
    
    @GetMapping("/download/{fileName}")
    public void fileDownload(@PathVariable String fileName){
    
    }
    
}