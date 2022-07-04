package com.springbootwebservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootwebservice.entity.Images;
public interface ImagesRepo extends JpaRepository<Images, Long>{

}
