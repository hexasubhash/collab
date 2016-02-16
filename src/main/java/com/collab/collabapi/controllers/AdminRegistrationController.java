package com.collab.collabapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collab.collabapi.model.UserProfile;
import com.collab.collabapi.ro.AdminRegistrationRO;
import com.collab.collabapi.ro.CitiesRO;
import com.collab.collabapi.ro.Constants;
import com.collab.collabapi.ro.UserProfileRO;
import com.collab.collabapi.service.UserProfileService;
import com.collab.collabapi.utils.EmailValidator;

//http://websystique.com/springmvc/spring-mvc-4-restful-web-services-crud-example-resttemplate/
//http://stackoverflow.com/questions/26549379/when-use-responseentityt-and-restcontroller-for-spring-restful-applications
@RestController
public class AdminRegistrationController {
	@Autowired
	private UserProfileService userProfileService;

	// For add and update person both
	@RequestMapping(value = "/adminregister/fetchcities", method = RequestMethod.GET)
	public ResponseEntity<AdminRegistrationRO> createUser(@ModelAttribute UserProfileRO userProfileRO,
			HttpServletResponse response) {

		List<CitiesRO> cityList = this.userProfileService.fetchCities();
		
		if (cityList != null) {			
			AdminRegistrationRO adminRegistrationRO = new AdminRegistrationRO();
			adminRegistrationRO.setCities(cityList);
			return new ResponseEntity<AdminRegistrationRO>(adminRegistrationRO, HttpStatus.OK);
			
		} else {
			return new ResponseEntity<AdminRegistrationRO>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	
	// For add and update person both
		@RequestMapping(value = "/adminregister/saveadminuser", method = RequestMethod.POST)
		public ResponseEntity<AdminRegistrationRO> saveAdminUser(@ModelAttribute RegistrationWizardModelSubmit registrationWizardModelSubmit,
				HttpServletResponse response) {
			Map<String, String> errorMap = new HashMap<String, String>();			
			registrationWizardModelSubmit.getAddress();
			
			List<CitiesRO> cityList = this.userProfileService.fetchCities();
			
			if (cityList != null) {			
				AdminRegistrationRO adminRegistrationRO = new AdminRegistrationRO();
				adminRegistrationRO.setCities(cityList);
				return new ResponseEntity<AdminRegistrationRO>(adminRegistrationRO, HttpStatus.OK);
			} else {
				return new ResponseEntity<AdminRegistrationRO>(HttpStatus.UNAUTHORIZED);
			}
		}
	
	
	
	
	
	private void isThisFieldEmpty(String field, Map<String, String> errorMap, String fieldName) {
		if (StringUtils.isEmpty(field) || "0".equals(field) || StringUtils.isEmpty(field.trim())) {
			errorMap.put(fieldName, Constants.ERROR_EMPTY_FIELD);
		}
	}
	
	private void validateStep1(RegistrationWizardModelSubmit model,
			Map<String, String> errorMap, HttpServletRequest request) {
		isThisFieldEmpty(model.getFirstName(), errorMap, Constants.FORM_FIRST_NAME);
		isThisFieldEmpty(model.getLastName(), errorMap, Constants.FORM_LAST_NAME);
		isThisFieldEmpty(model.getCompany(), errorMap, Constants.FORM_COMPANY);
		isThisFieldEmpty(model.getCfunction(), errorMap, Constants.FORM_COMPANY_FUNCTION);
		isThisFieldEmpty(model.getAddress(), errorMap, Constants.FORM_ADDRESS);
		isThisFieldEmpty(model.getPostalcode(), errorMap, Constants.FORM_POSTAL_CODE);
		isThisFieldEmpty(model.getCity(), errorMap, Constants.FORM_CITY);
		isThisFieldEmpty(model.getCountryId(), errorMap, Constants.FORM_COUNTRY_ID);
		isThisFieldEmpty(model.getSite(), errorMap, Constants.FORM_SITE);
		isThisFieldEmpty(model.getPhone(), errorMap, Constants.FORM_PHONE);
		isThisFieldEmpty(model.getEmail(), errorMap, Constants.FORM_EMAIL);
		isThisFieldEmpty(model.getRepeatEmail(), errorMap, Constants.FORM_REPEAT_EMAIL);
		if (model.getMale() == null) {
			errorMap.put(Constants.FORM_GENDER, Constants.ERROR_EMPTY_FIELD);
		}
		// Validate USA state field.
		if (model.getUsaStatesVisible()) {
			if (StringUtils.isEmpty(model.getStateId())) {
				errorMap.put(Constants.FORM_STATE_ID, Constants.ERROR_INCORRECT_VALUE);
			}
		}
		// Validate email format.
		if (!EmailValidator.getInstance().validate(model.getEmail())) {
			errorMap.put(Constants.FORM_EMAIL, Constants.ERROR_INCORRECT_VALUE);
		}
		// Email and repeat email must be the same.
		/*if (!StringUtils.equalsIgnoreCase(model.getEmail(), model.getRepeatEmail())) {
			errorMap.put(Constants.FORM_REPEAT_EMAIL, Constants.ERROR_INCORRECT_VALUE);
		}*/
		
		// Validate email. If it exists send error.
		/*if(!errorMap.containsKey(Constants.FORM_EMAIL) && !errorMap.containsKey(Constants.FORM_REPEAT_EMAIL)) {
			// Validate only if error is not already there.
			WebEasyUser user = BackendFactory.getWebeasyBackend().getWebEasyUserFromUsername(model.getEmail());
			if(user != null) {
				errorMap.put(Constants.FORM_EMAIL, Constants.ERROR_EMAIL_USED);
			}
		}*/
	}
	
}
