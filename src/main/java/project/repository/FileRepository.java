package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.entity.File;

public interface FileRepository extends JpaRepository<File, Long>{
}