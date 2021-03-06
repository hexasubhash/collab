package com.collab.collabapi.dao;

import java.util.List;

import com.collab.collabapi.model.City;
import com.collab.collabapi.model.UserProfile;
import com.collab.collabapi.ro.CitiesRO;

public interface UserProfileDAO {

	public void addUserProfile(UserProfile p);

	public void updateUserProfile(UserProfile p);

	public List<UserProfile> listUserProfiles();

	public UserProfile getUserProfileById(int id);

	public void removeUserProfile(int id);
	
	public UserProfile getUserProfileByCellNo(String cellNo);
	
	public List<CitiesRO> fetchCity();
}
