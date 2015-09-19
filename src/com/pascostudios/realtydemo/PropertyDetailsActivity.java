package com.pascostudios.realtydemo;

import java.util.UUID;

import android.support.v4.app.Fragment;

import com.pascostudios.realtydemo.util.FrameContainer;

public class PropertyDetailsActivity extends FrameContainer {

	@Override
	protected Fragment createFragment() {
		
		UUID propertyId = (UUID) getIntent().getSerializableExtra(PropertyDetails.EXTRA_PROPERTY_ID);
	
		return PropertyDetails.newInstance(propertyId);
	}

}
