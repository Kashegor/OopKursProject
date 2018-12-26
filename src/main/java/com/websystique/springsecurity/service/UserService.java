package com.websystique.springsecurity.service;

import com.websystique.springsecurity.model.User;

import java.util.HashSet;
import java.util.Set;

public interface UserService {

	User findById(int id);
	
	User findBySso(String sso);

	Set getBucket(int id);

	Set getBucket(String sso);

}