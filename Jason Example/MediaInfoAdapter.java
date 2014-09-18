package com.heran.media;

import java.util.ArrayList;
import com.heran.kok.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MediaInfoAdapter extends BaseAdapter {
	
  private ArrayList<MediaInfo> fileLis = null;
	private LayoutInflater infater = null;
	private int layout = -1;
    
	public MediaInfoAdapter(Context context,  ArrayList<MediaInfo> list, int layout) 
	{
		infater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.fileLis = list;
		this.layout = layout;
//		asyncImageLoader = new AsyncImageLoader();
	}
	
	public int getCount() {
		return fileLis.size();
	}
	
	public Object getItem(int position) {
		return fileLis.get(position);
	}
	
	public long getItemId(int position) {
		return 0;
	}
	
	public View getView(int position, View convertview, ViewGroup group) 
	{
	 
		View view = null;
		ViewHolder holder = null;
		if (convertview == null || convertview.getTag() == null) 
		{
			view = infater.inflate(layout, null);
			holder = new ViewHolder(view);
			view.setTag(holder);
		} 
		else{
			view = convertview ;
			holder = (ViewHolder) convertview.getTag() ;
		}
		MediaInfo mediaInfo = (MediaInfo) getItem(position);
		holder.mediaName.setText(mediaInfo.getTitle());
		holder.mediaNo.setText(mediaInfo.getFileName().substring(0, mediaInfo.getFileName().indexOf(".")));
		holder.singerName.setText(mediaInfo.getSinger());
		mediaInfo.setHolder(holder);
		return view;
	}
	
	public class ViewHolder 
	{
		TextView mediaNo;
		TextView mediaName;
		TextView singerName;
//		ImageView radioButton;
//		boolean isSelect = false;

		public ViewHolder(View view) {
			this.mediaNo = (TextView) view.findViewById(R.id.fileNo_TextView);
			this.mediaName = (TextView) view.findViewById(R.id.fileName_TextView);
			this.singerName = (TextView) view.findViewById(R.id.singer_TextView);
		}
	}
  
  /**
   * FOR ListView
   * @param isAll:是否刪除所有檔案
   * @param firstPosition:當下目前第一筆INDEX
   * @param oldFirstPosition:上一次狀態第一筆INDEX
   * @param visibleItemCount:畫面可顯示出ITEM數量
   */

  
  
}