package com.springbootwebservice.service;

import java.util.List;

import com.springbootwebservice.entity.Images;


public interface ImagesService {
	
	Images saveImages(Images images);

	List<Images> getAllImages();

	Images getImageById(long imageId);
	Images updateImages(Images image, long id);

	void deleteImages(long id);

}
