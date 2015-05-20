package com.homeworkreminder;

import java.util.List;

import com.homeworkreminder.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class InfoListAdapter extends ArrayAdapter{
		
	List<?> data;
	Context context;
	int layoutResID;
	View singleRow;
	TextView name;
	TextView type;
	
	public InfoListAdapter(Context c, int resource, List<?> objects) {
		super(c, resource, objects);
		// TODO Auto-generated constructor stub
		this.context = c;
		this.layoutResID = resource;
		this.data = objects;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		this.singleRow = convertView;
		if (singleRow == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			singleRow = inflater.inflate(layoutResID, parent, false);

		}
		name = (TextView) singleRow.findViewById(R.id.tv_calinfo_name);
		type = (TextView) singleRow.findViewById(R.id.tv_calinfo_type);
		Task rowInfo = (Task) data.get(position);
		name.setText(rowInfo.getName());
		if(rowInfo.getName().length() >=15){
			type.setText("");
		}else{
			type.setText(" "+rowInfo.getType());
		}
		return singleRow;
	}
	
	public int getId(int position){
		Task t = (Task) data.get(position);
		return t.getId();
	}
	
}
