package com.imooc;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Toast;

import com.imooc.view.QQSlidingMenu;

public class QQSlidingMenuActivity extends Activity implements OnClickListener{

	private QQSlidingMenu mLeftMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_qq_slidingmenu);
		mLeftMenu = (QQSlidingMenu) findViewById(R.id.id_menu);
		findViewById(R.id.rl_1).setOnClickListener(this);
	}

	public void toggleMenu(View view) {
		mLeftMenu.toggle();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rl_1 :
			Toast.makeText(this, "点击了item 1", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}

}
