package ge.gtug.bubbleteach;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Locale;


import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class FirstActivity extends Activity {
	
	Button but ; 
	
	/** Called when the activity is first created. */

	
	TextToSpeech ttx;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstact);

	/*	ttx = new TextToSpeech(
        		FirstActivity.this, 
        		new TextToSpeech.OnInitListener() {
			
			public void onInit(int status) {
				// TODO Auto-generated method stub
				if(status !=TextToSpeech.ERROR){
					ttx.setLanguage(Locale.US);					
				}
				
			}
		});*/


	

		String alphabet = "abcdefghijqlmnopqrstuvwxyz";

		int pos = 0;
		for (int i = 0; i < 7; i++) {
			TableRow row = new TableRow(this);
			for (int j = 0; j < 4; j++) {
				if (pos == 26) {
					break;
				}
			    but = new Button(this);
				but.setOnClickListener(btnListener);
				but.setText(Character.toString(alphabet.charAt(pos++)));
				but.setHeight(80);
				but.setWidth(70);
				but.setBackgroundResource(R.drawable.burti);
				row.addView(but);
				but.setId(pos);
				
				
				TableLayout table = (TableLayout) findViewById(R.id.table);
				((ViewGroup)table.getParent()).removeView(table);

			table.addView(row);
			but.destroyDrawingCache();
			

		}}
		
		

	}
	
	/* @Override
	    protected void onPause() {
	    	// TODO Auto-generated method stub
	    	if(ttx != null){
	    		ttx.stop();
	    		ttx.shutdown();  	
	    	}
	    	super.onPause();
	    }*/
	 
	 private OnClickListener btnListener = new OnClickListener()
	    {
	    
	    	public void onClick(View v) {
				 
	    	/*Button b = (Button)v;
	    	   String buttonText = b.getText().toString();
	    		
	    		ttx.speak(buttonText, TextToSpeech.QUEUE_FLUSH, null);
				Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
				vibe.vibrate(100);
	    	*/	
	    		Log.d("message", "value");
				
			}
	    };

			/*

	 */
		
}
