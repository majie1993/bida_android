package com.android.bida;

import android.os.Bundle;
import android.util.Log;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends BaseActivity {
	
    public MainActivity() {
		super(R.string.app_name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initAll();
        lbsThread.start();
    }
    
    public void initAll() {
        actionBarInit();
		listInit();
		menuInit();
    }
    
    public void actionBarInit() {
    	
    }
    
    public void listInit() {
    	
    }
    
    // 记录到BLOG
    public void menuInit() {
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		setContentView(R.layout.activity_main);
		getSlidingMenu().setSecondaryMenu(R.layout.menu_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.menu_frame, new MenuFragment())
		.commit();
    }
    
    Thread lbsThread = new Thread("lbsThread") {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Log.v("GetLbsInfo", "doing work");	
		}
    };
}
