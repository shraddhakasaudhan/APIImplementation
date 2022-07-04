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

import com.springbootwebservice.entity.FollowersAndFollowing;
import com.springbootwebservice.service.FollowersAndFollowingService;
@RestController
@RequestMapping("/api/followers")
public class FollowersAndFollowingController {
	
	private FollowersAndFollowingService followersAndfollowingService;

	
	
	public FollowersAndFollowingController(FollowersAndFollowingService followersAndfollowingService) {
		super();
		this.followersAndfollowingService = followersAndfollowingService;
	}



	@PostMapping
	public ResponseEntity<FollowersAndFollowing> saveFollowersAndFollowing(@RequestBody FollowersAndFollowing followersAndfollowing){
		return new ResponseEntity<FollowersAndFollowing>(followersAndfollowingService.saveFollowersAndFollowing(followersAndfollowing), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<FollowersAndFollowing> getAllFollowersAndFollowing(){
		return followersAndfollowingService.getAllFollowersAndFollowing();
	}
	
	@GetMapping("id")
	public ResponseEntity<FollowersAndFollowing> getFollowersAndFollowingById(@PathVariable("id") long id){
		return new ResponseEntity<FollowersAndFollowing>(followersAndfollowingService.getFollowersAndFollowingById(id),HttpStatus.OK);
	}
	
	@PutMapping("id")
	public ResponseEntity<FollowersAndFollowing> updateFollowersAndFollowing(@PathVariable("id") long id, @RequestBody FollowersAndFollowing followersAndfollowing){
		return new ResponseEntity<FollowersAndFollowing>(followersAndfollowingService.updateFollowersAndFollowing(followersAndfollowing, id), HttpStatus.OK);
		
	}
	
	@DeleteMapping("id")
	public ResponseEntity<String> deleteFollowersAndFollowing(@PathVariable("id") long id){
		 followersAndfollowingService.deleteFollowersAndFollowing(id);
		 return new ResponseEntity<String>("Users removed successfully",HttpStatus.OK);
	}

}

