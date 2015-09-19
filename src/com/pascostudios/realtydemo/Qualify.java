package com.pascostudios.realtydemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class Qualify extends DialogFragment {
	
	



	public static final String BASE_PRICE = "the.price.man";
	double basePrice;
	int downpayment;
	int numYears = 0;
	int interestRate = 0;
	int amountToPay;
	private TextView basePriceText,yearText,interestText,resultText;
	private SeekBar interestBar,yearsBar;
	private EditText downPayment;
	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	
		
	}
	
	public static Qualify newInstance(Double price){
		
		Bundle args = new Bundle();
		args.putSerializable(BASE_PRICE, price);
		
		Qualify fragment = new Qualify();
		fragment.setArguments(args);
		
		
		return fragment;
		
		
		
	}



	@Override
	@NonNull
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		View v = getActivity().getLayoutInflater().inflate(R.layout.qualify_view, null);
		
		 basePriceText = (TextView) v.findViewById(R.id.base_price);
		 downPayment = (EditText) v.findViewById(R.id.down_eT);
		 yearText = (TextView) v.findViewById(R.id.years_text);
	     interestText = (TextView) v.findViewById(R.id.interest_text);
		 resultText = (TextView) v.findViewById(R.id.result_text);
		 
		 
		 
		 basePrice = (Double) getArguments().getSerializable(BASE_PRICE);
		 String myPrice = Double.toString(basePrice);
		 basePriceText.setText(myPrice);
		 
		 
		 downPayment.setText("0");
		 
		 interestBar = (SeekBar) v.findViewById(R.id.seek_interest);
		 interestBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			 int onProg;
			 
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				interestRate = onProg;
				
				calculateRate();
				
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				onProg = progress;
				interestText.setText(onProg + "%");
				
			}
		});
		 
		 
		 yearsBar = (SeekBar) v.findViewById(R.id.seek_years);
		 yearsBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			 
			 
			 int onProg;
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
				numYears = onProg;
				calculateRate();
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
			onProg = progress;
			String year = "";
			
			if (onProg > 1){
				
				year = " years";
			}else{
				
				year = " year";
			}
			
			
			yearText.setText(onProg + year);
			
				
			}
		});
		 
		
		
		
		return new AlertDialog.Builder(getActivity()).setTitle("Qualify")
				.setView(v)
				.setPositiveButton("Ok", null)
				.create();
	}



	protected void calculateRate() {
		
		Double principal;
		
		if (numYears == 0){
			numYears = 0;
		}
		
		if (interestRate == 0){
			
			interestRate = 0;
		}
		
		if(downPayment == null){
			

			String downText = downPayment.getText().toString();
			principal = Double.parseDouble(downText);
			
		
		
		}else{
			
			String downText = downPayment.getText().toString();
			principal = Double.parseDouble(downText);
			
			
		}
		
		double baseMinusDown = basePrice - principal;
		
		double rate = interestRate;
		
		double yearly = numYears * 12;
		
		double topMul = baseMinusDown * rate;
		
		double amortVal = topMul/yearly;
		
		double decimal = Math.round(amortVal);
		
		String amortization = Double.toString(decimal);
		
		resultText.setText(amortization);
		
		
		
	}


	

}
