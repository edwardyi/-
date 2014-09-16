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
import android.widget.Toast;


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
		        /*另一種寫法
		         *intent.setClass(context, SecondActivity.class);
		         *不傳遞參數給下一個Activity的寫法
		         *startActivity(intent);
		         * Bundle bdl = new Bundle();
		           bdl.putString("test","測試");
		         **/       
		        /**
		         * intent.putExtra()方法傳遞key-value值到下一頁
		         */
		        intent.putExtra("test","測試");
		        startActivityForResult(intent,1);
//		        Main.this.startActivityforResult(intent,1);
			}
		});
           
    }
    /**
     * 接收從第二頁傳來的Intent返回結果
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
               super.onActivityResult(requestCode, resultCode, data);

               switch(requestCode){
                  case 1:
	                 Toast.makeText(this, data.getExtras().getString("B"), 0).show();
	              break;
	              
              }
    }


   
}
