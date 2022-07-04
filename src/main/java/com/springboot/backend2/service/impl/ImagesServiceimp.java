package com.springbootwebservice.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootwebservice.entity.Images;
import com.springbootwebservice.exception.ResourceNotFoundException;
import com.springbootwebservice.repo.ImagesRepo;
import com.springbootwebservice.service.ImagesService;



@Service
public class ImagesServiceimp implements ImagesService{
	
private ImagesRepo imageRepo;
	
	public ImagesServiceimp(ImagesRepo imageRepo) {
	super();
	this.imageRepo = imageRepo;
}


	@Override
	public Images saveImages(Images images) {
		
		return imageRepo.save(images);
	}


	@Override
	public List<Images> getAllImages() {
		
		return imageRepo.findAll();
	}
	
	@Override
	public Images getImageById(long id) {
		
		//Optional<Images> image = imageRepo.findById(imageId);
				//if(image.isPresent()) {
				//return image.get();
				//}
				//else {
				//throw new ResourceNotFoundException("Images", "ID", imageId);
				//}
				return imageRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Images", "ID", id));
			
	}
	

	@Override
	public Images updateImages(Images image, long id) {
		
		// we need to check whether image by given id is exist in database or not
		
				Images existingImage = imageRepo.findById(id).orElseThrow(
						() -> new ResourceNotFoundException("Images", "Id", id));
						
				existingImage.setUser_id(image.getUser_id());
				
				
				//save existing  to database
						
				imageRepo.save(existingImage);
						
				return existingImage;
		
	}


	@Override
	public void deleteImages(long id) {
		//check whether images is exist in database or not
		imageRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Images", "id", id));
				
		imageRepo.deleteById(id);
		
		
	}


	

	
}



