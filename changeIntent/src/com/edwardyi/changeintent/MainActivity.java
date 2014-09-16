package com.edwardyi.changeintent;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
	private Button btn1;
	private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btn_1);
        //取得上下文
        context = this;
        //以new View.OnClickListener物件傳入
        btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
		        Intent intent = new Intent(context,SecondActivity.class);
		        startActivity(intent);
//		        Main.this.startActivityforResult(intent,1);
			}
		});
           
    }


   
}
