package com.homeworkreminder;

import java.util.Calendar;

import android.content.ContentValues;



public class Task implements Comparable<Task>{
	
	private int ID = -1; 
	private String NAME = null;
	private String TYPE = null;
	private String SUBJECT = null;
	private Calendar DUE = Calendar.getInstance();
	private String[] REMINDERS = {};
	private String NOTES = null;
	private String STATUS = null;
	private int DUEDAYS = 0;
	
	private int LINKED = 0;
	private int INTERVAL = 0;
	private int INDEX = 0;
	private String PRE_TAG = null;
	private String NXT_TAG = null;
	private boolean ALARM_ACTIVE = true;
	
	public Task(int id, String name, String type, String subject, Calendar due, 
			String[] reminders, String notes, String status, int islinked, int index, int interval
			, String pre_tag, String nxt_tag, boolean alarm){
		this.ID = id;
		this.NAME = name;
		this.TYPE = type;
		this.SUBJECT = subject;
		this.DUE.set(Calendar.YEAR, due.get(Calendar.YEAR));
		this.DUE.set(Calendar.MONTH, due.get(Calendar.MONTH));
		this.DUE.set(Calendar.DAY_OF_MONTH, due.get(Calendar.DAY_OF_MONTH));
		this.DUE.set(Calendar.HOUR_OF_DAY, due.get(Calendar.HOUR_OF_DAY));
		this.DUE.set(Calendar.MINUTE, due.get(Calendar.MINUTE));
		this.DUE.set(Calendar.SECOND, 0);
		this.DUE.set(Calendar.MILLISECOND,0);
		this.REMINDERS = reminders;
		this.NOTES = notes;
		this.STATUS = status;
		this.DUEDAYS = Util.calculateDueDays(this.DUE);
		this.LINKED = islinked;
		this.INDEX = index;
		this.INTERVAL = interval;
		this.PRE_TAG = pre_tag;
		this.NXT_TAG = nxt_tag;
		this.ALARM_ACTIVE = alarm;
		
	}
	
	public int getId(){
		return this.ID;
	}
	
	public String getName(){
		return this.NAME;
	}
	
	public void setName(String new_name){
		this.NAME = new_name;
	}
	
	public String getType(){
		return this.TYPE;
	}
	
	public void setType(String new_type){
		switch(new_type){
		case "Homework":
			this.TYPE = new_type;
			break;
		case "Lab":
			this.TYPE = new_type;
			break;
		case "Exam":
			this.TYPE = new_type;
			break;
		case "Other":
			this.TYPE = new_type;
			break;
		}
	}
	
	public String getSubject(){
		return this.SUBJECT;
	}
	
	public void setSubject(String new_subject){
		this.SUBJECT = new_subject;
	}
	
	public Calendar getDue(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, this.DUE.get(Calendar.YEAR));
		c.set(Calendar.MONTH,this.DUE.get(Calendar.MONTH));
		c.set(Calendar.DAY_OF_MONTH, this.DUE.get(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR_OF_DAY, this.DUE.get(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, this.DUE.get(Calendar.MINUTE));
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND,0);
		
		return c;
	}
	
	public void setDue(Calendar h){
		
		this.DUE.set(Calendar.YEAR, h.get(Calendar.YEAR));
		this.DUE.set(Calendar.MONTH, h.get(Calendar.MONTH));
		this.DUE.set(Calendar.DAY_OF_MONTH, h.get(Calendar.DAY_OF_MONTH));
		this.DUE.set(Calendar.HOUR_OF_DAY, h.get(Calendar.HOUR_OF_DAY));
		this.DUE.set(Calendar.MINUTE, h.get(Calendar.MINUTE));
		this.DUE.set(Calendar.SECOND, 0);
		this.DUE.set(Calendar.MILLISECOND,0);
	}
	
	public String[] getReminders(){
		return this.REMINDERS;
	}
	
	public void setReminders(String[] s){
		this.REMINDERS = s;
	}
	
	public String getNotes(){
		return this.NOTES;
	}
	
	public void setNotes(String notes){
		this.NOTES = notes;
	}
	
	public String getStatus(){
		return this.STATUS;
	}
	
	public void setStatus(String new_status){
		this.STATUS = new_status;
	}
	
	public int getDueDays(){
		return this.DUEDAYS;
	}
	
	public void reCalculateDueDays(){
		this.DUEDAYS = Util.calculateDueDays(this.DUE);
	}
	
	public boolean isLinked(){
		if(this.LINKED == 0){
			return false;
		}else{
			return true;
		}
	}
	
	public int getIndex(){
		return this.INDEX;
	}
	
	public void setIndex(int new_index){
		this.INDEX = new_index;
	}
	
	public String getPreviousTag(){
		return this.PRE_TAG;
	}

	public void setPreviousTag(String new_tag){
		this.PRE_TAG = new_tag;
	}
	
	public String getNextTag(){
		return this.NXT_TAG;
	}

	public void setNextTag(String new_tag){
		this.NXT_TAG = new_tag;
	}
	
	public boolean isAlarmActive(){
		return this.ALARM_ACTIVE;
	}
	
	public void setAlarmState(boolean state){
		this.ALARM_ACTIVE = state;
	}
	
	public int getLinked(){
		return this.LINKED;
	}
	
	public int getInterval(){
		return this.INTERVAL;
	}
	
	public Task deepCopy(){
		Task rv = new Task(this.getId(), this.getName(), this.getType(), this.getSubject(), this.getDue(), this.getReminders(), this.getNotes(), this.getStatus(), this.getLinked(), 
				this.getIndex(), this.getInterval(), this.getPreviousTag(), this.getNextTag(), this.isAlarmActive());
		return rv;
	}
	
	public boolean isPending(){
		return this.getStatus().contentEquals("Pending");
	}

	@Override
	public int compareTo(Task another) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if(o == null)	return false;
		else if(o == this) return true;
		else if(!(o instanceof Task)) return false;
		Task t = (Task)o;
		return this.getId() == t.getId();
	}

	public ContentValues getContentValues(){
		ContentValues v = new ContentValues();
		v.put("id", this.getId());
		v.put("name", this.getName());
		v.put("duedays", this.getDueDays());
		v.put("type", this.getType());
		v.put("subject", this.getSubject());
		v.put("due_year", this.getDue().get(Calendar.YEAR));
		v.put("due_month", this.getDue().get(Calendar.MONTH));
		v.put("due_day", this.getDue().get(Calendar.DAY_OF_MONTH));
		v.put("due_hour", this.getDue().get(Calendar.HOUR_OF_DAY));
		v.put("due_min", this.getDue().get(Calendar.MINUTE));
		v.put("reminders", Util.convertArrayToString(this.getReminders()));
		v.put("notes", this.getNotes());
		v.put("interval", this.getInterval());
		v.put("next_tag", this.getNextTag());
		v.put("prev_tag", this.getPreviousTag());
		v.put("alarm_active", this.isAlarmActive());
		v.put("linked", this.isLinked());
		return v;
	}
}
