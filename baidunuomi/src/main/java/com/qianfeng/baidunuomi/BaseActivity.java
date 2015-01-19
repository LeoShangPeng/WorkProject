package com.qianfeng.baidunuomi;

import com.qianfeng.baidunuomi.utils.AppManager;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class BaseActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AppManager.getAppManager().addActivity(this);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		AppManager.getAppManager().finishActivity();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

}
