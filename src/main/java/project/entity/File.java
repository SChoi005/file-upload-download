package project.entity;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class File{
    
    private String uuid;
    
    private String fileName;
    
    private Long fileSize;
    
    private String path;
    
}