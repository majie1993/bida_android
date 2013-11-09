package com.android.bida;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class BaseActivity extends SlidingFragmentActivity {
    private int titleRes;  
    Fragment frag;  
      
    public BaseActivity(int titleRes) {  
        this.titleRes = titleRes;
    }
    
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        // TODO Auto-generated method stub  
        super.onCreate(savedInstanceState);
        this.setTitle(titleRes);
        
        //设置behind View
        this.setBehindContentView(R.layout.sliding_menu);  
        this.setContentView(R.layout.menu_frame);

        if(savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
            MenuFragment fragment = new MenuFragment();
            fragmentTransaction.replace(R.id.menu_frame, fragment);
            fragmentTransaction.commit();
        } else {
            frag = this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
        }
        
        SlidingMenu menu = this.getSlidingMenu();  
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }  
    
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}


