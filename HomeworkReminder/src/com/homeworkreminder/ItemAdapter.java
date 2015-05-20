package com.homeworkreminder;

import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.fortysevendeg.swipelistview.SwipeListView;
import com.homeworkreminder.Theme.ColorScheme;
import com.homeworkreminder.Theme.ThemeManager;

public class ItemAdapter extends ArrayAdapter {

	List<?> data;
	Context context;
	int layoutResID;
	View thisview;
	SwipeListView swlv;
	Task t;
	Button toggle_btn;
	CheckBox complete;
	TextView tv_name;
	TextView tv_due;
	int pos;
	String theme_label;
	private static ThemeManager theme;
	private static final String HOMEWORK = "Homework";
	private static final String LAB = "Lab";
	private static final String EXAM = "Exam";
	private static final String OTHER = "Other";

	public ItemAdapter(Context context, int layoutResourceId, List data,
			SwipeListView swlv, String theme_label) {
		super(context, layoutResourceId, data);
		this.swlv = swlv;
		this.data = data;
		this.context = context;
		this.layoutResID = layoutResourceId;
		this.theme_label = theme_label;
		if(theme == null){
			theme = new ThemeManager(context){

				@Override
				public void setColor(ColorScheme scheme) {
					// TODO Auto-generated method stub
					
				}
				
			};
		}
	}

	public void destroy() {

	}

	public void updateData(List new_data) {
		this.data = new_data;
		this.notifyDataSetChanged();
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		NewsHolder holder = null;
		View row = convertView;
		holder = null;
		thisview = row;
		this.pos = position;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResID, parent, false);

			holder = new NewsHolder();

			holder.button2 = (Button) row.findViewById(R.id.del_button);
			holder.button3 = (Button) row.findViewById(R.id.edit_button);
			row.setTag(holder);
		} else {
			holder = (NewsHolder) row.getTag();
		}
		// ////////////////////////////////////////////////////////////////////////////
		final Task itemdata = (Task) data.get(position);
		// ////////////////////////////////////////////////////////////////////////////
		tv_name = (TextView) row.findViewById(R.id.tv_taskname);
		tv_due = (TextView) row.findViewById(R.id.tv_due);
		complete = (CheckBox) row.findViewById(R.id.cb_complete);
		if (itemdata.getType().contentEquals(HOMEWORK)) {
			holder.button3.setBackgroundColor(theme.getComboFromName(theme_label).getHWColor());
		} else if (itemdata.getType().contentEquals(LAB)) {
			holder.button3.setBackgroundColor(theme.getComboFromName(theme_label).getLabColor());
		} else if (itemdata.getType().contentEquals(EXAM)) {
			holder.button3.setBackgroundColor(theme.getComboFromName(theme_label).getExamColor());
		} else {
			holder.button3.setBackgroundColor(theme.getComboFromName(theme_label).getOtherColor());
		}

		tv_name.setText(itemdata.getName());

		int diff_days = itemdata.getDueDays();
		if (diff_days > 0) {
			tv_due.setTextColor(context.getResources().getColor(
					R.color.charcoal));
			if (diff_days == 1000) {
				tv_due.setText("Due in the future");
			} else if (diff_days == 1) {
				tv_due.setText("Due tomorrow");
			} else {
				tv_due.setText("Due in " + diff_days + " days");
			}
		} else if (diff_days < 0) {
			tv_due.setTextColor(context.getResources().getColor(R.color.red));
			if (diff_days == -1000) {
				tv_due.setText("Overdue");
			} else if (diff_days == -1) {
				tv_due.setText("Due yesterday");
			} else {
				diff_days = 0 - diff_days;
				tv_due.setText(diff_days + " days overdue");
			}
		} else {
			tv_due.setTextColor(context.getResources().getColor(R.color.red));
			tv_due.setText("Due today");
		}

		holder.button2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (itemdata.getStatus()) {
				case "Pending":
					Main.deleteSelection(position, 0);
					if (!data.isEmpty()) {
						swlv.closeAnimate(position);
					}
					notifyDataSetChanged();
					break;
				case "Completed":
					Main.deleteSelection(position, 1);
					if (!data.isEmpty()) {
						swlv.closeAnimate(position);
					}
					notifyDataSetChanged();
					break;
				}
			}
		});

		holder.button3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (swlv.isOpen(position)) {
					swlv.closeAnimate(position);
				}
				Intent intent = new Intent(context, EditTask.class);
				Bundle b = new Bundle();
				b.putInt("id", itemdata.getId());
				intent.putExtra("info", b);
				context.startActivity(intent);
			}
		});

		toggle_btn = (Button) row.findViewById(R.id.options_button);
		toggle_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (swlv.isOpen(position)) {
					swlv.closeAnimate(position);
				} else {
					swlv.openAnimate(position);
				}
			}
		});

		switch (itemdata.getStatus()) {
		case "Pending":
			complete.setChecked(false);
			break;
		case "Completed":
			complete.setChecked(true);
			tv_due.setTextColor(context.getResources().getColor(
					R.color.charcoal));
			tv_due.setText("Completed");
			break;
		default:
		}
		complete.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (((CheckBox) v).isChecked()) {
					if (itemdata.isAlarmActive()) {
						Main.getScheduleClient().cancelAlarm(itemdata.getId());
						Main.getDatabase().deactivateAlarm(itemdata.getId());
					}
					Main.completeTask(position);
					// data.remove(position);
					notifyDataSetChanged();
				}

				else {
					ContentValues h = new ContentValues();
					h.put("name", itemdata.getName());
					h.put("id", itemdata.getId());
					h.put("type", itemdata.getType());
					h.put("reminders",
							Util.convertArrayToString(itemdata.getReminders()));
					h.put("due_year", itemdata.getDue().get(Calendar.YEAR));
					h.put("due_month", itemdata.getDue().get(Calendar.MONTH));
					h.put("due_day",
							itemdata.getDue().get(Calendar.DAY_OF_MONTH));
					h.put("due_hour",
							itemdata.getDue().get(Calendar.HOUR_OF_DAY));
					h.put("due_min", itemdata.getDue().get(Calendar.MINUTE));
					if (!Util.invalidDueDate(context, h)) {
						Main.getScheduleClient().setAlarmForNotification(h);
						Main.getDatabase().activateAlarm(itemdata.getId());
					} else {
					}

					Main.uncompleteTask(position);
					notifyDataSetChanged();
				}

			}
		});
		return row;

	}
	
	public void setThemeLabel(String new_theme_label){
		this.theme_label = new_theme_label;
		this.notifyDataSetChanged();
	}

	static class NewsHolder {
		Button button2;
		Button button3;
	}

}
