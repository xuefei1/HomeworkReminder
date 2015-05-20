package com.homeworkreminder;

import java.util.ArrayList;

import com.homeworkreminder.R;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerListAdapter extends BaseAdapter{
	
	Context context;
	ArrayList<SingleDrawerListRow> list;
	Resources res;
	View row;
	
	DrawerListAdapter(Context ctx){
		list = new ArrayList<SingleDrawerListRow>();
		this.context = ctx;
		res = context.getResources();
		String[] names = res.getStringArray(R.array.home_drawer);
		int[] images = {R.drawable.ic_action_event,
				R.drawable.ic_action_collection, R.drawable.ic_action_copy,
				R.drawable.ic_action_go_to_today, R.drawable.ic_action_accept};
		for(int i = 0; i<5; i++){
			list.add(new SingleDrawerListRow(names[i], images[i]));
		}
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		row = inflater.inflate(R.layout.drawer_list_item, parent, false);
		TextView t = (TextView) row.findViewById(R.id.drawer_list_item_textview);
		ImageView v = (ImageView) row.findViewById(R.id.drawer_list_item_image);
		
		SingleDrawerListRow temp = list.get(position);
		t.setText(temp.name);
		v.setImageResource(temp.image);
		return row;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		// return number of elements inside the array
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		// returns the object at position
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		// return the id of the row
		return position;
	}

}

class SingleDrawerListRow{
	
	String name;
	int image;
	
	SingleDrawerListRow(String n, int h){
		this.name = n;
		this.image = h;
	}
}
