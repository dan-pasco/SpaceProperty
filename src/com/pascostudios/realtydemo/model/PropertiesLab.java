package com.pascostudios.realtydemo.model;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class PropertiesLab {
	
	private ArrayList<Properties> mProperties;
	
	private static PropertiesLab sPropertiesLab;
	private Context mAppContext;
	
	
	private PropertiesLab (Context appcontext) {
		
		mAppContext = appcontext;
		mProperties = new ArrayList<Properties>();
		
		
	}
	
	
	 public static PropertiesLab get(Context c) {
	        if (sPropertiesLab == null) {
	            sPropertiesLab = new PropertiesLab(c.getApplicationContext());
	        }
	        return sPropertiesLab;
	    }
	 
	 public Properties getProperty(UUID id) {
	        for (Properties c : mProperties) {
	            if (c.getId().equals(id))
	                return c;
	        }
	        return null;
	    }
	 
	 
	 
	 public ArrayList<Properties> setMovies(ArrayList<Properties> c){
		 
		 mProperties = c;
		 
		 return mProperties;
		 
	 }
	
	
	

}
