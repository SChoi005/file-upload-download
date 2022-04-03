package project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class File{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fileName;
    
    private Long fileSize;
    
    @Lob //To store Large Object in db
    private byte[] data;

    private String type;
    
}