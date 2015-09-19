package com.pascostudios.realtydemo;

import java.util.UUID;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.pascostudios.realtydemo.app.AppController;
import com.pascostudios.realtydemo.model.Properties;
import com.pascostudios.realtydemo.model.PropertiesLab;

public class PropertyDetails extends Fragment {
	
	public static final String EXTRA_PROPERTY_ID = "propertyList.PROPERTY_ID";
	public static final String BASE_PRICE = "the.price.man";
	Properties mProperty;
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();
	UUID propertyId;
	NetworkImageView thumbnail;
	
	
	
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		propertyId = (UUID) getArguments().getSerializable(EXTRA_PROPERTY_ID);
		
		mProperty = PropertiesLab.get(getActivity()).getProperty(propertyId);
		
	
		
		
		
		
	}

	
	






	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.property_details, container, false);
		
		if (imageLoader == null){
			
			 imageLoader = AppController.getInstance().getImageLoader();
			
		}
		
		TextView propertyName = (TextView) v.findViewById(R.id.property_name_details);
		propertyName.setText(mProperty.getPropertyName());
		
		
		 thumbnail = (NetworkImageView) v.findViewById(R.id.imageView1);
		
		thumbnail.setImageUrl(mProperty.getThumbnailUrl(), imageLoader);
		
		NetworkImageView scroll1 = (NetworkImageView) v.findViewById(R.id.scroll1);
		scroll1.setImageUrl(mProperty.getImage1(), imageLoader);
		
		scroll1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				thumbnail.setImageUrl(mProperty.getImage1(), imageLoader);
				
			}
		});
		
		
		NetworkImageView scroll2 = (NetworkImageView) v.findViewById(R.id.scroll2);
		scroll2.setImageUrl(mProperty.getImage2(), imageLoader);
		
		scroll2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				thumbnail.setImageUrl(mProperty.getImage2(), imageLoader);
				
			}
		});
		
		NetworkImageView scroll3 = (NetworkImageView) v.findViewById(R.id.scroll3);
		scroll3.setImageUrl(mProperty.getImage3(), imageLoader);
		
		scroll3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				thumbnail.setImageUrl(mProperty.getImage3(), imageLoader);
				
			}
		});
		

		NetworkImageView scroll4 = (NetworkImageView) v.findViewById(R.id.scroll4);
		scroll4.setImageUrl(mProperty.getImage4(), imageLoader);
		
		scroll4.setImageUrl(mProperty.getImage4(), imageLoader);
		
		scroll4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				thumbnail.setImageUrl(mProperty.getImage4(), imageLoader);
				
			}
		});
		
		
		TextView bedroom = (TextView) v.findViewById(R.id.bedroom_number);
		bedroom.setText(String.valueOf(mProperty.getBedrooms()));
		
		TextView bathroom = (TextView) v.findViewById(R.id.bathroom_number);
		bathroom.setText(String.valueOf(mProperty.getBathrooms()));
		
		TextView price = (TextView) v.findViewById(R.id.price);
		price.setText(String.valueOf(mProperty.getPrice()));
		
		TextView description = (TextView) v.findViewById(R.id.description);
		description.setText(mProperty.getDescription());
		
		Button qualify = (Button) v.findViewById(R.id.qualify_button);
		
		qualify.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				FragmentManager fm = getActivity().getSupportFragmentManager();
				Qualify qualify =  Qualify.newInstance(mProperty.getPrice());
				qualify.show(fm, BASE_PRICE);
				
			}
		});
		
		
		return v;
	}









	public static PropertyDetails newInstance(UUID propertyId) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_PROPERTY_ID, propertyId);
		
		PropertyDetails fragment = new PropertyDetails();
		fragment.setArguments(args);
		
		
		return fragment;
	}
	

	
	

}
