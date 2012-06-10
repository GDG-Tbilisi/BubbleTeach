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

	Button but;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstact);

		String alphabet = "abcdefghijqlmnopqrstuvwxyz";
		TableLayout table = (TableLayout)findViewById(R.id.table);
		

		int pos = 0;
		for (int i = 0; i < 7; i++) {
			TableRow row = new TableRow(this);
			for (int j = 0; j < 4; j++) {
				if (pos == 26) {
					break;
				}
				but = new Button(this);

				but.setText(Character.toString(alphabet.charAt(pos++)));
				but.setHeight(80);
				but.setWidth(70);
				but.setBackgroundResource(R.drawable.burti);
				row.addView(but);
						}
			table.addView(row);
			
			
		}

	}

}
