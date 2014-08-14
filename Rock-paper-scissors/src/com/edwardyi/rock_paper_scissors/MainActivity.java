package com.edwardyi.rock_paper_scissors;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends ActionBarActivity {
	private Button btn_play;
	private RadioGroup rdg1;
	private RadioGroup rdg2;
	private TextView txt_result;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViews();
		btn_play.setOnClickListener(btn_callback);
		rdg1.setOnCheckedChangeListener(rdg_callback);
	}
	
	private void findViews(){
		btn_play = (Button)findViewById(R.id.btn_play);
		rdg1 = (RadioGroup)findViewById(R.id.group1);
		rdg2 = (RadioGroup)findViewById(R.id.group2);
		txt_result = (TextView)findViewById(R.id.txt_result);
	}
//	點擊按鈕事件
	public Button.OnClickListener btn_callback = new OnClickListener(){
		@Override
		public void onClick(View v) {
			
			// TODO Auto-generated method stub
			int checkedId1 = rdg1.getCheckedRadioButtonId();
			int checkedId2 = rdg2.getCheckedRadioButtonId();
//			System.out.println(checkedId1+"|"+checkedId2);
			if(checkedId1 == checkedId2 && checkedId1 != -1 && checkedId2 != -1){
				txt_result.setText("在一次!");
			}
			if(checkedId1 == R.id.opt1_paper ){
				if(checkedId2 == R.id.opt2_scissor){
					txt_result.setText("player1輸了!");
				}else if(checkedId2 == R.id.opt2_rock){
					txt_result.setText("player1贏了!");
				}else{
					txt_result.setText("在一次!");
				}
			}else if(checkedId1 == R.id.opt1_rock){
				if(checkedId2 == R.id.opt2_paper){
					txt_result.setText("player1輸了!");
				}else if(checkedId2 == R.id.opt2_scissor){
					txt_result.setText("player1贏了!");
				}else{
					txt_result.setText("在一次!");
				}
			}else{
				if(checkedId2 == R.id.opt2_rock){
					txt_result.setText("player1輸了!");
				}else if(checkedId2 == R.id.opt2_paper){
					txt_result.setText("player1贏了!");
				}else{
					txt_result.setText("在一次!");
				}
			}
			
		}
		
	} ;
//	點擊RadioButton事件
	public RadioGroup.OnCheckedChangeListener rdg_callback = new OnCheckedChangeListener(){

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
//			判斷是否為group1
//			System.out.println(group.getId()+"|"+R.id.group1+"|"+rdg2.getCheckedRadioButtonId());
//			
//		
//			if(group.getId() == R.id.group1){
////			判斷group1和group2是否相同
//				int checkedId2 = rdg2.getCheckedRadioButtonId();
//				if(checkedId == checkedId2){
//					txt_result.setText("在一次!");
//				}
//				
//			}
		}
		
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
