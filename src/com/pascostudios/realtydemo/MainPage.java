package com.pascostudios.realtydemo;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.pascostudios.realtydemo.adapter.ListAdapter;
import com.pascostudios.realtydemo.app.AppController;
import com.pascostudios.realtydemo.model.Properties;
import com.pascostudios.realtydemo.model.PropertiesLab;

public class MainPage extends Fragment {
	
	   private static final String url = "http://www.pascosoft.org/latest.php";
	    private ProgressDialog pDialog;
	    private List<Properties> propertyList = new ArrayList<Properties>();
	    private ListView listView;
	    private ListAdapter adapter;
	    private Context context;
	    private  JsonArrayRequest propertyReq;
	    
	    
	    
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			
			pDialog = new ProgressDialog(getActivity());
	        pDialog.setMessage("Loading....");
	        pDialog.show();
	        
	        propertyReq = new JsonArrayRequest(url, new Response.Listener<JSONArray>(
	        		) {

						@Override
						public void onResponse(JSONArray response) {
							
							for (int i = 0; i < response.length(); i++) {
								
								
								try {
									JSONObject obj = response.getJSONObject(i);
									Properties p = new Properties();
									p.setPropertyName(obj.getString("PropertyName"));
									p.setThumbnailUrl(obj.getString("PrimaryImage"));  
									p.setPrice(obj.getInt("PricePoint"));
									p.setAddress(obj.getString("Extra1"));
									p.setImage1(obj.getString("InsideImage1"));
									p.setImage2(obj.getString("InsideImage2"));
									p.setImage3(obj.getString("InsideImage3"));
									p.setImage4(obj.getString("InsideImage4"));
									p.setDescription(obj.getString("Description"));
									p.setBathrooms(obj.getInt("Bathrooms"));
									p.setBedrooms(obj.getInt("Bedrooms"));
									
								
									
									// adding movie to movies array
									
									propertyList.add(p);
									PropertiesLab.get(getActivity()).setMovies((ArrayList<Properties>) propertyList);
									
									
								} catch (JSONException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}	
								
							}
							// notifying list adapter about data changes
	                        // so that it renders the list view with updated data
							
	                        adapter.notifyDataSetChanged();
							hidePDialog();
						}
			}, new Response.ErrorListener(
					
					) {
						
						@Override
						public void onErrorResponse(VolleyError arg0) {
							// TODO Auto-generated method stub
							hidePDialog();
						}
			});
	     // Adding request to request queue
	        AppController.getInstance().addToRequestQueue(propertyReq);
	       
			
			
			
		} 
		
		

		@Override
		public View onCreateView(LayoutInflater inflater,
				@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
			View v = inflater.inflate(R.layout.property_main_list_view, container, false);
		
			listView = (ListView) v.findViewById(R.id.list);
			adapter = new ListAdapter(getActivity(), propertyList);
			listView.setAdapter(adapter);
			
			
			listView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					
					
					Properties p = propertyList.get(position);
					
					Intent i = new Intent(getActivity(),PropertyDetailsActivity.class);
					i.putExtra(PropertyDetails.EXTRA_PROPERTY_ID, p.getId());
					startActivityForResult(i, 0);
					
				}
				
				
			});
			
			
			return v;
			
		}
		
	    
	    
	    
	    
	    
	    
	    

		private void hidePDialog() {
	        if (pDialog != null) {
	            pDialog.dismiss();
	            pDialog = null;
	        }
	    }
	        
	    
	    
	    
	    

}
