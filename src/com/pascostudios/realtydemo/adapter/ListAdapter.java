package com.pascostudios.realtydemo.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.pascostudios.realtydemo.R;
import com.pascostudios.realtydemo.app.AppController;
import com.pascostudios.realtydemo.model.Properties;

public class ListAdapter extends BaseAdapter {
	
	 private Activity activity;
	    private LayoutInflater inflater;
	    private List<Properties> propertyItems;
	    ImageLoader imageLoader = com.pascostudios.realtydemo.app.AppController.getInstance().getImageLoader();
	    
	    public ListAdapter(Activity activity, List<Properties> propertyItems) {
	        this.activity = activity;
	        this.propertyItems = propertyItems;
	    }

	    @Override
	    public int getCount() {
	        return propertyItems.size();
	    }
	 
	    @Override
	    public Object getItem(int location) {
	        return propertyItems.get(location);
	    }
	 
	    @Override
	    public long getItemId(int position) {
	        return position;
	    }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 if (inflater == null)
	            inflater = (LayoutInflater) activity
	                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        if (convertView == null)
	            convertView = inflater.inflate(R.layout.list_view, null);
	 
	        if (imageLoader == null)
	            imageLoader = AppController.getInstance().getImageLoader();
	        
	        
	        NetworkImageView thumbNail = (NetworkImageView) convertView
	                .findViewById(R.id.thumbnail);
	        TextView title = (TextView) convertView.findViewById(R.id.title);
	        TextView address = (TextView) convertView.findViewById(R.id.address);
	        TextView price = (TextView) convertView.findViewById(R.id.pricePoint);
	 
	        // getting movie data for the row
	        Properties m = propertyItems.get(position);
	 
	        // thumbnail image
	        thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);
	         
	        // title
	        title.setText(m.getPropertyName());
	         
	        // address
	        address.setText(m.getAddress());
	         
	        // habitable
	       
	         
	        // release year
	        price.setText(String.valueOf(m.getPrice()));
	 
	        return convertView;
	}

}
