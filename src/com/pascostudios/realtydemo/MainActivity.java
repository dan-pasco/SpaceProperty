package com.pascostudios.realtydemo;

import android.support.v4.app.Fragment;

import com.pascostudios.realtydemo.util.FrameContainer;


public class MainActivity extends FrameContainer {

	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		return new MainPage();
	}

   
}
