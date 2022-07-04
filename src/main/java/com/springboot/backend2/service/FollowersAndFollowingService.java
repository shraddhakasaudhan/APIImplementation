package com.springbootwebservice.service;

import java.util.List;

import com.springbootwebservice.entity.FollowersAndFollowing;

public interface FollowersAndFollowingService {
	
	FollowersAndFollowing saveFollowersAndFollowing(FollowersAndFollowing followersandfollowing);

	List<FollowersAndFollowing> getAllFollowersAndFollowing();

	FollowersAndFollowing getFollowersAndFollowingById(long id);
	FollowersAndFollowing updateFollowersAndFollowing(FollowersAndFollowing followersandfollowing, long id);

	void deleteFollowersAndFollowing(long id);

}

