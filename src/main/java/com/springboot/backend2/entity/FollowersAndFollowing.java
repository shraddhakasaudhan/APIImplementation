package com.springbootwebservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "followersandfollowing")
public class FollowersAndFollowing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="followers_id", nullable=false)
	private String followersName;
	
	@Column(name = "following_id", nullable=false)
	private String followingName;

}
