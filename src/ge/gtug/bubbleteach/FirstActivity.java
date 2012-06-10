package ge.gtug.bubbleteach;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;


import java.util.ArrayList;
import java.util.Locale;

import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class FirstActivity extends Activity {
	String letterer;
	Button but;
	 boolean te = true;
	 boolean te1 = true;
	TextToSpeech ttx;
	ImageButton btnBig;
	ImageButton btnSmall;
	ImageButton btnNext;
	static final int check = 111;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstact);
		btnBig = (ImageButton) findViewById(R.id.btnDidiOn);
		btnSmall = (ImageButton) findViewById(R.id.btnPataraoff);
		btnNext = (ImageButton)findViewById(R.id.button2);
		ttx = new TextToSpeech(FirstActivity.this,
				new TextToSpeech.OnInitListener() {

					public void onInit(int status) {
						// TODO Auto-generated method stub
						if (status != TextToSpeech.ERROR) {
							ttx.setLanguage(Locale.US);
						}
					}
				});
	
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		final TableLayout  table = (TableLayout) findViewById(R.id.table);

		createView(alphabet,table);
		
		
		btnBig.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			if (te) {
				btnBig.setBackgroundResource(R.drawable.didioff);
				btnSmall.setBackgroundResource(R.drawable.pataraon);
				table.removeAllViews();
				String alphabet = "abcdefghijklmnopqrstuvwxyz";
				TableLayout table = (TableLayout) findViewById(R.id.table);
				createView(alphabet,table);
				te = false;
			}else{
				btnBig.setBackgroundResource(R.drawable.didion);
				btnSmall.setBackgroundResource(R.drawable.pataraoff);
				table.removeAllViews();
				String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				TableLayout table = (TableLayout) findViewById(R.id.table);
				createView(alphabet,table);
				te = true;
			}
			
				
			}
		});
		btnSmall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (te1) {
					btnBig.setBackgroundResource(R.drawable.didioff);
					btnSmall.setBackgroundResource(R.drawable.pataraon);
					table.removeAllViews();
					String alphabet = "abcdefghijklmnopqrstuvwxyz";
					TableLayout table = (TableLayout) findViewById(R.id.table);
					createView(alphabet,table);
					te1 = false;
				}else{
					btnBig.setBackgroundResource(R.drawable.didion);
					btnSmall.setBackgroundResource(R.drawable.pataraoff);
					table.removeAllViews();
					String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
					TableLayout table = (TableLayout) findViewById(R.id.table);
					createView(alphabet,table);
					te1 = true;
				}
			}
			
		});
		btnNext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent i = new Intent();
   	    	  i.setClass(getApplicationContext(), SecondActivity.class);
   	    	  startActivity(i);
			}
		});
	}
	
	

	
	private void createView(String alphabet, TableLayout table) {
		// TODO Auto-generated method stub
		int pos = 0;
		for (int i = 0; i < 7; i++) {
			TableRow row = new TableRow(this);
			for (int j = 0; j < 4; j++) {
				if (pos == 26) {
					break;
				}
				but = new Button(this);
				but.setClickable(true);
				but.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						Button b = (Button) v;
						String buttonText = b.getText().toString();
						letterer = buttonText;
						AlertDialog alertDialog = new AlertDialog.Builder(
								FirstActivity.this).create();
						alertDialog.setTitle(buttonText);
						ttx.speak(buttonText, TextToSpeech.QUEUE_FLUSH, null);
						Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
						vibe.vibrate(100);
						
						Intent intent= new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
						intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
						intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something dude!");
						startActivityForResult(intent, check);
					}
				});

				but.setText(Character.toString(alphabet.charAt(pos++)));
				but.setHeight(80);
				but.setWidth(70);
				but.setBackgroundResource(R.drawable.burti);
				but.setId(pos);
				row.addView(but);

			}
			table.addView(row);

		}
	
		
	}




	

	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
		//Context context = getApplicationContext();
		
	//	int duration = Toast.LENGTH_LONG;
		AlertDialog alert = new AlertDialog.Builder(
					FirstActivity.this).create();
		if(requestCode == check && resultCode == RESULT_OK){
			ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			Object[] elements = results.toArray();
			
			
			
			String letter = (String) elements[0];
			
			if (letter == letterer) {
				alert.setTitle("Correct . sgsg " + letter );
			}else{ 
				alert.setTitle("sgsg . Try Again  " + letter);
			}
			alert.show();
			//CharSequence text = results[0];
           /* String text = results[0];
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();*/
			
		}
		else {
			/*String text = "fail";
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();*/
			alert.setTitle("Try Again ");
			alert.show();
		}
    	super.onActivityResult(requestCode, resultCode, data);
    }
}
