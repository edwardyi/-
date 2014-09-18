package com.edwardyi.menucategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	//ListView
	private static String[] strs = new String[]{"資料1","資料2","資料3"};
	private ListView listview1;
	private Context context;
	private TextView txt1;
	private SimpleAdapter simplelist;
	private List<Map<String,Object>>datalist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
        /*
         * 長按TextView兩秒出現的menu
         */
        this.registerForContextMenu((TextView)(findViewById(R.id.txt1)));
        /*
         * ListView
         */
       listview1 = (ListView)findViewById(R.id.listView1);
       ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, strs);
       datalist = new ArrayList<Map<String,Object>>();
       simplelist = new SimpleAdapter(context, getData(), R.layout.item, new String[]{"image","text"}, new int[]{R.id.imageView1,R.id.textview1});
       listview1.setAdapter(simplelist);
       
    }
    public List<Map<String,Object>> getData(){
    	for(int i=0;i<20;i++){
    		Map map = new HashMap();
    		map.put("image", R.drawable.ic_launcher);
    		map.put("text", "測試"+i);
    		datalist.add(map);
    	}
    	return datalist;
    }
    /*  長按TextView
     * (non-Javadoc)
     * @see android.app.Activity#onCreateContextMenu(android.view.ContextMenu, android.view.View, android.view.ContextMenu.ContextMenuInfo)
     */
    public void onCreateContextMenu(ContextMenu menu,View view,ContextMenuInfo info){
    	menu.add(0,0,0,"3C");
    	menu.add(0,1,1,"4D");
    	menu.add(0,2,2,"5E");
    	super.onCreateContextMenu(menu, view, info);
    }
    public boolean onContextItemSelected(MenuItem item){
    	switch(item.getItemId()){
    		case 0:
    			Toast.makeText(context, "3C", Toast.LENGTH_SHORT).show();
    		break;
    		case 1:
    			Toast.makeText(context, "4D~", Toast.LENGTH_SHORT).show();
    		break;
    		case 2:
    			Toast.makeText(context, "5E gg~", Toast.LENGTH_SHORT).show();
    		break;
    	}
		return super.onContextItemSelected(item);
    	
    }
    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     * OptionsMenu
     */
    public boolean onCreateOptionsMenu(Menu menu){
    	menu.add(0,0,0,"退出");
    	menu.add(0,1,0,"設置");
    	SubMenu submenu = menu.addSubMenu(0, 2, 0, "子Menu");
    	submenu.addSubMenu(0, 3, 0, "AA");
    	submenu.addSubMenu(0, 4, 0, "BB");
    	return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId()){
    		case 0:
    			finish();
//    			Toast.makeText(context, "退出~", Toast.LENGTH_SHORT).show();
    		break;
    		case 1:
    			Toast.makeText(context, "設置~", Toast.LENGTH_SHORT).show();
    		break;
    		case 2:
    			Toast.makeText(context, "2設置~", Toast.LENGTH_SHORT).show();
    		break;
    		case 3:
    			Toast.makeText(context, "3設置~", Toast.LENGTH_SHORT).show();
    		break;
    		case 4:
    			Toast.makeText(context, "4設置~", Toast.LENGTH_SHORT).show();
    		break;
    	}
    	return true;
    }
}
