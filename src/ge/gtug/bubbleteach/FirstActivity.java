package ge.gtug.bubbleteach;

import ge.gtug.bubbleteach.R.layout;
import android.app.Activity;


import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FirstActivity extends Activity {
	/** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstact);
        

/*        Button next = (Button) findViewById(R.id.Button02);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }

        });*/
    
        
        LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		//---create a layout---
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);// This Cant override Manifest android:screenOrientation
		
		//---create a button---
		Button btn = new Button(this);
		btn.setText("This is a Button");
		btn.setLayoutParams(params);
		//---adds the textview---

		layout.addView(btn);
		//---create a layout param for the layout---
		LinearLayout.LayoutParams layoutParam =	new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT );
		this.addContentView(layout, layoutParam);

        
       

}}
