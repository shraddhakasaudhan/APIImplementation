package com.springbootwebservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootwebservice.entity.FollowersAndFollowing;

public interface FollowersAndFollowingRepo extends JpaRepository<FollowersAndFollowing, Long>{

}
