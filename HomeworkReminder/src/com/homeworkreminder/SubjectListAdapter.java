package com.homeworkreminder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.homeworkreminder.Theme.ColorScheme;
import com.homeworkreminder.Theme.ThemeManager;

public class SubjectListAdapter extends BaseExpandableListAdapter implements
		OnGroupClickListener, OnChildClickListener {

	private Context context;
	private List<String> _listDataHeader; // header titles
	// child data in format of header title, child title
	private HashMap<String, List<Task>> _listDataChild;
	private ExpandableListView _subjectlistview;
	final String DEFAULT_SUBJECT = "Default subject";
	final String ADD_SUBJECT = "Create new";
	private int lastExpandedPosition = -1;

	ImageView expandHeader;
	ImageView collapseHeader;
	ImageButton deleteSubjectButton;
	ImageButton saveChangesButton;
	ImageButton deleteTaskButton;
	ImageButton editSubjectButton;
	TextView subjectName;
	TextView subjectSize;
	EditText subjectNameEdit;
	TextView taskName;
	TextView taskdue;
	RelativeLayout childRightContainer;
	RelativeLayout childLeftContainer;
	static boolean isEditModeActivated = false;
	private ThemeManager theme;

	public SubjectListAdapter(Context ctx, List<String> subjects,
			HashMap<String, List<Task>> taskmap, ExpandableListView lv) {
		this.context = ctx;
		this._listDataHeader = subjects;
		this._listDataChild = taskmap;
		this._subjectlistview = lv;
		this._subjectlistview.setOnGroupClickListener(this);
		this._subjectlistview.setOnChildClickListener(this);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return this._listDataHeader.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return this._listDataChild.get(this._listDataHeader.get(groupPosition))
				.size();
	}

	@Override
	public String getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return this._listDataHeader.get(groupPosition);
	}

	@Override
	public Task getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return this._listDataChild.get(this._listDataHeader.get(groupPosition))
				.get(childPosition);
	}
	
	public List<Task> getChildList(int groupPosition){
		
		return this._listDataChild.get(this._listDataHeader.get(groupPosition));
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View getGroupView(final int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		String headerName = (String) getGroup(groupPosition);

		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(
					R.layout.subject_listview_header, parent, false);
		}
		final View temp_view = convertView;
		subjectName = (TextView) convertView.findViewById(R.id.tv_subject_name);
		subjectName.setTypeface(null, Typeface.BOLD);
		subjectName.setText(headerName);
		subjectSize = (TextView) convertView.findViewById(R.id.tv_subject_info);
		subjectSize.setText("Contains "
				+ this._listDataChild.get(
						this._listDataHeader.get(groupPosition)).size()
				+ " task(s)");
		expandHeader = (ImageView) convertView
				.findViewById(R.id.subject_listview_expand);
		
		collapseHeader = (ImageView) convertView
				.findViewById(R.id.subject_listview_collapse);
		SharedPreferences getPrefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		theme = new ThemeManager(context){

			@Override
			public void setColor(ColorScheme scheme) {
				// TODO Auto-generated method stub
				temp_view.setBackgroundColor(scheme.getNormalColor());
			}
			
		};
		
		theme.loadColorScheme(getPrefs);
		
		if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
			expandHeader.setVisibility(View.VISIBLE);
			collapseHeader.setVisibility(View.GONE);
		}
		deleteSubjectButton = (ImageButton) convertView
				.findViewById(R.id.subject_listview_delete_subject);
		deleteSubjectButton.setOnClickListener(new View.OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(getChildrenCount(groupPosition) > 0){
					AlertDialog.Builder b = new AlertDialog.Builder(context);
					b.setTitle("Warning");
					b.setMessage("Deleting this subject will delete all task(s) inside. Proceed?" );
					final AlertDialog d = b.create();
					d.setButton("Yes", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							d.dismiss();
							//delete tasks inside the group
							List<Task> list = getChildList(groupPosition);
							Iterator<Task> it = list.iterator();
							while(it.hasNext()){
								Task t = it.next();
								int index_upcoming = Main.findById(Main.getUpcoming(), t.getId());
								int index_all = Main.findById(Main.getTaskHolder(), t.getId());
								if(Main.getUpcoming().contains(t)){
									Main.getUpcoming().remove(t);
								}else if(index_upcoming!=-1){
									Main.getUpcoming().remove(index_upcoming);
								}
								if(Main.getTaskHolder().contains(t)){
									Main.getTaskHolder().remove(t);
								}else if(index_all != -1){
									Main.getTaskHolder().remove(index_upcoming);
								}
								Main.getDatabase().deleteRecord(t.getId());
								Main.removeFromTaskMap(Main.genTaskMapKey(t.getDue()),t);
								try{
									Main.getScheduleClient().cancelAlarm(t.getId());
								}catch(Exception e){
									e.printStackTrace();
								}
							}
							Main.getSubjectMap().remove(getGroup(groupPosition));
							Main.removeSubject(getGroup(groupPosition));
						}
						
					});
					d.setButton2("No", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							d.dismiss();
						}
					});
					d.show();

				}else{
					Main.getSubjectMap().remove(getGroup(groupPosition));
					Main.removeSubject(getGroup(groupPosition));
				}
				if(_listDataHeader.size()>1){
					int temp_position = groupPosition;
					if(_listDataHeader.size()<=groupPosition){
						temp_position = _listDataHeader.size()-1;
					}
					onEditModeDeactivated(temp_position, temp_view,
							_subjectlistview);
				}else{
					isEditModeActivated = false;
				}
				
				notifyDataSetChanged();
			}
		});

		deleteSubjectButton.setFocusable(false);
		editSubjectButton = (ImageButton) convertView
				.findViewById(R.id.subject_listview_edit);
		editSubjectButton.setFocusable(false);
		editSubjectButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!isEditModeActivated)
					onEditModeActivated(groupPosition, temp_view,
							_subjectlistview);
			}
		});
		saveChangesButton = (ImageButton) convertView
				.findViewById(R.id.subject_listview_save);
		saveChangesButton.setFocusable(false);
		saveChangesButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onEditModeDeactivated(groupPosition, temp_view,
						_subjectlistview);
			}
		});

		return convertView;
	}

	@Override
	public View getChildView(final int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(
					R.layout.subject_listview_child, parent, false);
		}
		childRightContainer = (RelativeLayout) convertView
				.findViewById(R.id.subject_listview_child_right_container);
		childLeftContainer = (RelativeLayout) convertView
				.findViewById(R.id.subject_listview_child_left_container);

		deleteTaskButton = (ImageButton) convertView
				.findViewById(R.id.subject_listview_child_delete);
		deleteTaskButton.setFocusable(false);
		deleteTaskButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Main.deleteSelection(getChild(groupPosition, childPosition));
				notifyDataSetChanged();
			}
		});

		if (isEditModeActivated) {
			childLeftContainer.setVisibility(View.VISIBLE);
			childRightContainer.setVisibility(View.INVISIBLE);
		} else {
			childLeftContainer.setVisibility(View.INVISIBLE);
			childRightContainer.setVisibility(View.VISIBLE);
		}

		taskName = (TextView) convertView.findViewById(R.id.tv_child_name);
		taskdue = (TextView) convertView
				.findViewById(R.id.tv_subject_child_due);

		taskName.setText(_listDataChild.get(this.getGroup(groupPosition))
				.get(childPosition).getName());
		if (_listDataChild.get(this.getGroup(groupPosition)).get(childPosition)
				.getDueDays() > 1) {
			if(_listDataChild.get(this.getGroup(groupPosition)).get(childPosition)
					.getDueDays() == 1000){
				taskdue.setTextColor(context.getResources().getColor(
						R.color.charcoal));
				taskdue.setText("Due in the future");
			}else{
			taskdue.setTextColor(context.getResources().getColor(
					R.color.charcoal));
			taskdue.setText("Due in "
					+ _listDataChild.get(this.getGroup(groupPosition))
							.get(childPosition).getDueDays() + " days");
			}
		} else if (_listDataChild.get(this.getGroup(groupPosition))
				.get(childPosition).getDueDays() == 1) {
			taskdue.setTextColor(context.getResources().getColor(
					R.color.charcoal));
			taskdue.setText("Due tomorrow");
		} else if (_listDataChild.get(this.getGroup(groupPosition))
				.get(childPosition).getDueDays() == -1) {
			taskdue.setTextColor(context.getResources().getColor(R.color.red));
			taskdue.setText("Due yesterday");
		} else if (_listDataChild.get(this.getGroup(groupPosition))
				.get(childPosition).getDueDays() < -1) {
			if(_listDataChild.get(this.getGroup(groupPosition)).get(childPosition)
					.getDueDays() == -1000){
				taskdue.setTextColor(context.getResources().getColor(R.color.red));
				taskdue.setText("Due in the past");
			}else{
				int v = -_listDataChild.get(this.getGroup(groupPosition))
						.get(childPosition).getDueDays();
				taskdue.setTextColor(context.getResources().getColor(R.color.red));
				taskdue.setText(v
						+ " days overdue");
			}
		} else {
			taskdue.setTextColor(context.getResources().getColor(
					R.color.charcoal));
			taskdue.setText("Due today");
		}

		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

	private void onEditModeActivated(int groupPosition, View v,
			ExpandableListView parent) {
		isEditModeActivated = true;
		if (!parent.isGroupExpanded(groupPosition)) {
			parent.expandGroup(groupPosition);
		}

		expandHeader = (ImageView) v.findViewById(R.id.subject_listview_expand);
		collapseHeader = (ImageView) v
				.findViewById(R.id.subject_listview_collapse);
		expandHeader.setVisibility(View.GONE);
		collapseHeader.setVisibility(View.GONE);

		editSubjectButton = (ImageButton) v
				.findViewById(R.id.subject_listview_edit);
		saveChangesButton = (ImageButton) v
				.findViewById(R.id.subject_listview_save);
		editSubjectButton.setVisibility(View.GONE);
		saveChangesButton.setVisibility(View.VISIBLE);
		if (!getGroup(groupPosition).contentEquals(DEFAULT_SUBJECT)) {
			deleteSubjectButton = (ImageButton) v
					.findViewById(R.id.subject_listview_delete_subject);
			deleteSubjectButton.setVisibility(View.VISIBLE);
			subjectName = (TextView) v.findViewById(R.id.tv_subject_name);
			subjectSize = (TextView) v.findViewById(R.id.tv_subject_info);
			subjectNameEdit = (EditText) v
					.findViewById(R.id.subject_listview_et);
			subjectName.setVisibility(View.GONE);
			subjectSize.setVisibility(View.GONE);
			subjectNameEdit.setText(getGroup(groupPosition));
			subjectNameEdit.setVisibility(View.VISIBLE);
		} else {
			subjectNameEdit = (EditText) v
					.findViewById(R.id.subject_listview_et);
			deleteSubjectButton = (ImageButton) v
					.findViewById(R.id.subject_listview_delete_subject);
			deleteSubjectButton.setVisibility(View.GONE);
			subjectNameEdit.setVisibility(View.GONE);

		}
		notifyDataSetChanged();

	}

	private void onEditModeDeactivated(int groupPosition, View v,
			ExpandableListView parent) {
		isEditModeActivated = false;
		expandHeader = (ImageView) v.findViewById(R.id.subject_listview_expand);
		collapseHeader = (ImageView) v
				.findViewById(R.id.subject_listview_collapse);
		expandHeader.setVisibility(View.GONE);
		collapseHeader.setVisibility(View.VISIBLE);

		editSubjectButton = (ImageButton) v
				.findViewById(R.id.subject_listview_edit);
		saveChangesButton = (ImageButton) v
				.findViewById(R.id.subject_listview_save);
		deleteSubjectButton = (ImageButton) v
				.findViewById(R.id.subject_listview_delete_subject);
		deleteSubjectButton.setVisibility(View.GONE);
		editSubjectButton.setVisibility(View.VISIBLE);
		saveChangesButton.setVisibility(View.GONE);
		subjectName = (TextView) v.findViewById(R.id.tv_subject_name);
		subjectSize = (TextView) v.findViewById(R.id.tv_subject_info);
		subjectNameEdit = (EditText) v.findViewById(R.id.subject_listview_et);
		if (!getGroup(groupPosition).contentEquals(DEFAULT_SUBJECT)) {
			subjectName.setVisibility(View.VISIBLE);
			subjectSize.setVisibility(View.VISIBLE);
			if(!subjectNameEdit.getText().toString().contentEquals(subjectName.getText().toString())){
				Main.updateSubject(subjectName.getText().toString(), subjectNameEdit.getText().toString(), getChildrenCount(groupPosition));
			
			}
			subjectNameEdit.setVisibility(View.GONE);
			
		} else {
			subjectName.setVisibility(View.VISIBLE);
			subjectSize.setVisibility(View.VISIBLE);
			subjectNameEdit.setVisibility(View.GONE);
		}

		notifyDataSetChanged();
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		// TODO Auto-generated method stub
		if (isEditModeActivated) {
			return true;
		}
		Intent intent = new Intent(context, EditTask.class);
		Bundle b = new Bundle();
		b.putInt("id", this.getChild(groupPosition, childPosition).getId());
		intent.putExtra("info", b);
		context.startActivity(intent);
		return false;
	}

	@Override
	public boolean onGroupClick(ExpandableListView parent, View v,
			int groupPosition, long id) {
		// TODO Auto-generated method stub

		if (isEditModeActivated) {
			return true;
		}

		expandHeader = (ImageView) v.findViewById(R.id.subject_listview_expand);
		collapseHeader = (ImageView) v
				.findViewById(R.id.subject_listview_collapse);

		if (parent.isGroupExpanded(groupPosition)) {
			expandHeader.setVisibility(View.VISIBLE);
			collapseHeader.setVisibility(View.GONE);

		} else {
			expandHeader.setVisibility(View.GONE);
			collapseHeader.setVisibility(View.VISIBLE);
		}

		return false;
	}

	@Override
	public void onGroupExpanded(int groupPosition) {
		// TODO Auto-generated method stub
		super.onGroupExpanded(groupPosition);
		/*
		 * if (lastExpandedPosition != -1 && groupPosition !=
		 * lastExpandedPosition) {
		 * _subjectlistview.collapseGroup(lastExpandedPosition); }
		 * lastExpandedPosition = groupPosition;
		 * expandHeader.setVisibility(View.GONE);
		 * collapseHeader.setVisibility(View.VISIBLE);
		 */
		if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
			_subjectlistview.collapseGroup(lastExpandedPosition);
		}
		lastExpandedPosition = groupPosition;

	}

	@Override
	public void onGroupCollapsed(int groupPosition) {
		// TODO Auto-generated method stub
		super.onGroupCollapsed(groupPosition);
		/*
		 * expandHeader.setVisibility(View.VISIBLE);
		 * collapseHeader.setVisibility(View.GONE);
		 */
	}

}
