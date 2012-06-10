package ge.gtug.bubbleteach;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class BubbleTeachActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	// TODO Auto-generated method stub
    	int evAct = event.getAction();
    	
    	switch(evAct){
    	      case MotionEvent.ACTION_DOWN:
    	    	  Intent i = new Intent();
    	    	  i.setClass(getApplicationContext(), FirstActivity.class);
    	    	  startActivity(i);
    	    	  
    	
    	}
        
    	return super.onTouchEvent(event);
    }
}