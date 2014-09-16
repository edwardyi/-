package com.edwardyi.changeintent;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends ActionBarActivity {
	private Button btn_2;
	private TextView txt_2;
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_layout);
		btn_2 = (Button)findViewById(R.id.btn_2);
		txt_2 = (TextView)findViewById(R.id.txt_2);
		context = this;
		Bundle msg = this.getIntent().getExtras();
		txt_2.setText(msg.getString("test"));
		btn_2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context,MainActivity.class);
				intent.putExtra("B","從B頁返回喔~");
				setResult(1,intent);
				finish();
				
			}
		});
	}

	
}
