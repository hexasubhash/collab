	package com.collab.collabapi.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collab.collabapi.model.UserProfile;
import com.collab.collabapi.ro.UserProfileRO;
import com.collab.collabapi.service.UserProfileService;

//http://websystique.com/springmvc/spring-mvc-4-restful-web-services-crud-example-resttemplate/
//http://stackoverflow.com/questions/26549379/when-use-responseentityt-and-restcontroller-for-spring-restful-applications
@RestController
public class UserProfileController {
	@Autowired
	private UserProfileService userProfileService;

	// For add and update person both
	@RequestMapping(value = "/userprofile/register", method = RequestMethod.POST)
	public ResponseEntity<UserProfileRO> createUser(@ModelAttribute UserProfileRO userProfileRO,
			HttpServletResponse response) {

		UserProfile userProfile = this.userProfileService.getUserProfileByCellNo(userProfileRO.getPhoneNo());
		if (userProfile != null) {
			userProfile.setActive(true);
			this.userProfileService.updateUserProfile(userProfile);
			BeanUtils.copyProperties(userProfile, userProfileRO);
			return new ResponseEntity<UserProfileRO>(userProfileRO, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserProfileRO>(HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(value = "/userprofile/authenticate", method = RequestMethod.POST)
	public ResponseEntity<UserProfileRO> authUser(@ModelAttribute UserProfileRO userProfileRO) {

		UserProfile userProfile = this.userProfileService.getUserProfileByCellNo(userProfileRO.getPhoneNo());
		if (userProfile != null) {
			BeanUtils.copyProperties(userProfile, userProfileRO);
			return new ResponseEntity<UserProfileRO>(userProfileRO, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserProfileRO>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(value = "collabadmin/auth", method = RequestMethod.POST)
	public ResponseEntity<UserProfileRO> authCollabAdminUser(@ModelAttribute UserProfileRO userProfileRO) {

		String password = userProfileRO.getPassword();
		String userName = userProfileRO.getEmailId();
		
		if(password.equals("subhash123") && userName.equals("i.subhash@gmail.com"))
		{
			return new ResponseEntity<UserProfileRO>(userProfileRO, HttpStatus.OK);
		}else
		{
			return new ResponseEntity<UserProfileRO>(HttpStatus.UNAUTHORIZED);
		}
	}

}
