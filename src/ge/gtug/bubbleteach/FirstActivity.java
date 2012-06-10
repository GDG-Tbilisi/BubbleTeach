package ge.gtug.bubbleteach;

import android.app.Activity;
import android.app.AlertDialog;
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

	Button but;

	TextToSpeech ttx;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstact);

		ttx = new TextToSpeech(FirstActivity.this,
				new TextToSpeech.OnInitListener() {

					public void onInit(int status) {
						// TODO Auto-generated method stub
						if (status != TextToSpeech.ERROR) {
							ttx.setLanguage(Locale.US);
						}
					}
				});
	

		String alphabet = "abcdefghijqlmnopqrstuvwxyz";
		TableLayout table = (TableLayout) findViewById(R.id.table);

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
						AlertDialog alertDialog = new AlertDialog.Builder(
								FirstActivity.this).create();
						alertDialog.setTitle(buttonText);
						alertDialog.show();
						ttx.speak(buttonText, TextToSpeech.QUEUE_FLUSH, null);
						Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
						vibe.vibrate(100);
						

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

}
