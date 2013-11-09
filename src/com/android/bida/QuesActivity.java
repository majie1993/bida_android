package com.android.bida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class QuesActivity extends BaseActivity {
	
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
    	switch (item.getItemId()) {
    	case 1:
    		Toast.makeText(getApplicationContext(), "弹出分享", Toast.LENGTH_SHORT).show();
    		break;
    	default:
    		break;
    	}
		return super.onOptionsItemSelected(item);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu);
        MenuItem share = menu.add(0, 1, 0, R.string.share);
        share.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return true;
	}
    
    

	public QuesActivity() {
		super(R.string.app_name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MenuItemCompat.setShowAsAction(, 1);
        initAll();
    }
    
    public void initAll() {
        QuesInit();
		AnswerInit();
		OtherInit();
    }
    
    public void QuesInit() {
    	
    }
    
    public void AnswerInit() {
    	
    }

    // 记录到BLOG
    public void OtherInit() {

    	// MenuInit
    	getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		setContentView(R.layout.question_answer);
		
		getSlidingMenu().setSecondaryMenu(R.layout.menu_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.menu_frame, new MenuFragment())
		.commit();
    	
		// Create The Button to Answer Question 
    	Button answerQuesBut = (Button) findViewById(R.id.answer_ques);

    	answerQuesBut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(QuesActivity.this, AnswerQuesActivity.class);
				QuesActivity.this.startActivity(intent);
				QuesActivity.this.finish();
			}
		});
    
    }
    
}
