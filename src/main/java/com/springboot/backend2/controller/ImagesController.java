package com.springbootwebservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootwebservice.entity.Images;
import com.springbootwebservice.service.ImagesService;
@RestController
@RequestMapping("/api/images")
public class ImagesController {
	
	private ImagesService imagesService;

	public ImagesController(ImagesService imagesService) {
		super();
		this.imagesService = imagesService;
	}
	
	@PostMapping
	public ResponseEntity<Images> saveImages(@RequestBody Images images){
		return new ResponseEntity<Images>(imagesService.saveImages(images), HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public List<Images> getAllImages(){
		
		return imagesService.getAllImages();
		
	}
	@GetMapping("imageId")
	public ResponseEntity<Images> getImagesById(@PathVariable("id") long imageId){
		return new ResponseEntity<Images>(imagesService.getImageById(imageId), HttpStatus.OK);
	}
	
	@PutMapping("imageId")
	public ResponseEntity<Images> updateImages(@PathVariable("imageId") long imageId, @RequestBody Images images){
		return new ResponseEntity<Images>(imagesService.updateImages(images, imageId), HttpStatus.OK);
	}
	
	@DeleteMapping("imageId")
	public ResponseEntity<String> deleteImages(@PathVariable("imageId") long imageId){
		imagesService.deleteImages(imageId);
		return new ResponseEntity<String>("Images deleted successfully",HttpStatus.OK);
		
	}
	

}
