package ge.gtug.bubbleteach;


import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SecondActivity extends Activity {
  /** Called when the activity is first created. */
	public  ImageView floatingImage;
	public int i =0;
  @Override 
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.secondact);
    
      Button buttonStartTranslate = (Button)findViewById(R.id.starttranslate);
    //  floatingImage = (ImageView)findViewById(R.id.floatingimage);
      buttonStartTranslate.setOnClickListener(btnListener);
    
     // final Animation animationFalling = AnimationUtils.loadAnimation(this, R.layout.falling);    

  }
  
  public Animation test (){
	  return AnimationUtils.loadAnimation(this, R.layout.falling);	  
  }
  
  private OnClickListener btnListener = new OnClickListener()
  {
  
  	@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
  		if (i==0){
  			floatingImage = (ImageView)findViewById(R.id.floatingimage);
  			Animation ani = test();
  	  	    floatingImage.startAnimation(ani);
  			i++;
  		}
  		if(i>1){
  			floatingImage = new ImageView(getApplicationContext());
  			floatingImage.setImageResource(R.drawable.ic_launcher);
  			floatingImage.setMinimumHeight(20);
  			floatingImage.setMinimumWidth(20);
  			LinearLayout l = (LinearLayout)findViewById(R.id.sec);
  	  		l.addView(floatingImage);
  	  		Animation bani  = test();
  	  		floatingImage.startAnimation(bani);  			
  		}
  		
  	    
  	   /* ImageView b = new ImageView(getApplicationContext());  	    
  		b.setImageResource(R.drawable.ic_launcher);
  		LinearLayout l = (LinearLayout)findViewById(R.id.layout);
  		l.addView(b);
  		
  		Animation bani  = test();
  		b.startAnimation(bani);
*/  	    
			
			
		}
  };
}