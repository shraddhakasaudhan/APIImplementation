package com.springbootwebservice.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.springbootwebservice.entity.FollowersAndFollowing;
import com.springbootwebservice.exception.ResourceNotFoundException;
import com.springbootwebservice.repo.FollowersAndFollowingRepo;
import com.springbootwebservice.service.FollowersAndFollowingService;
@Service
@Transactional
public class FollowersAndFollowingimple implements FollowersAndFollowingService {
	
	private static FollowersAndFollowingRepo followersAndfollowingRepo;
	
	

	

	@Override
	public FollowersAndFollowing saveFollowersAndFollowing(FollowersAndFollowing followersandfollowing) {
		return followersAndfollowingRepo.save(followersandfollowing);
	}

	@Override
	public List<FollowersAndFollowing> getAllFollowersAndFollowing() {
		return followersAndfollowingRepo.findAll();
	}

	@Override
	public FollowersAndFollowing getFollowersAndFollowingById(long id) {
		
		return followersAndfollowingRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("FollowersAndFollowing", "ID", id));

	}

	@Override
	public FollowersAndFollowing updateFollowersAndFollowing(FollowersAndFollowing followersandfollowing,
			long id) {
		
		FollowersAndFollowing existingFollowersAndFollowing = followersAndfollowingRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("FollowersAndFollowing", "Id", id));
				
		existingFollowersAndFollowing.setFollowersName(followersandfollowing.getFollowersName());
		existingFollowersAndFollowing.setFollowingName(followersandfollowing.getFollowingName());
		
		
		
		
		//save existing  to database
				
		followersAndfollowingRepo.save(existingFollowersAndFollowing);
				
		return existingFollowersAndFollowing;

	}

	@Override
	public void deleteFollowersAndFollowing(long id) {
		
		followersAndfollowingRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("FollowersAndFollowing","ID", id));
		followersAndfollowingRepo.deleteById(id);
		 
	}
	
	 
}
