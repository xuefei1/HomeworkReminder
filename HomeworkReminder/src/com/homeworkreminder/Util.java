package com.homeworkreminder;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;



public class Util {

	public static String strSeparator = "__,__";

	public static String convertArrayToString(String[] array) {
		String str = "";
		for (int i = 0; i < array.length; i++) {
			str = str + array[i];
			// Do not append comma at the end of last element
			if (i < array.length - 1) {
				str = str + strSeparator;
			}
		}
		return str;
	}

	public static String[] convertStringToArray(String str) {
		String[] arr = str.split(strSeparator);
		return arr;
	}

	public static Calendar setDueDate(ContentValues values, int currIndex,
			int interval, Calendar original_first_due, 
			String year_field, String month_field, String day_field,
			String hour_field, String minute_field) {
		Calendar b = Calendar.getInstance();
		b.setTime(original_first_due.getTime());
		b.add(Calendar.DAY_OF_MONTH, interval * currIndex);
		values.put(year_field, b.get(Calendar.YEAR));
		values.put(month_field,  b.get(Calendar.MONTH));
		values.put(day_field,  b.get(Calendar.DAY_OF_MONTH));
		values.put(hour_field,  b.get(Calendar.HOUR_OF_DAY));
		values.put(minute_field,  b.get(Calendar.MINUTE));
		return b;
	}

	public static int convertDpToPixel(float dp, Context ctx) {
	    DisplayMetrics metrics = ctx.getResources().getDisplayMetrics();
	    float px = dp * (metrics.densityDpi / 160f);
	    return (int) px;
	}
	
	public static void infoIncomplete(String err, Context ctx){
		AlertDialog.Builder b = new AlertDialog.Builder(ctx);
		b.setTitle("Incomplete fields");
		b.setMessage("Invalid input for " + "'" + err + "'" );
		final AlertDialog d = b.create();
		d.setButton("Ok", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				d.dismiss();
			}
		});
		d.show();	
	}

	public static int calculateDueDays(Calendar due){
		
		Calendar o = Calendar.getInstance();
		Calendar d = Calendar.getInstance();
		d.set(Calendar.YEAR, due.get(Calendar.YEAR));
		d.set(Calendar.MONTH, due.get(Calendar.MONTH));
		d.set(Calendar.DAY_OF_MONTH, due.get(Calendar.DAY_OF_MONTH));
		d.set(Calendar.HOUR_OF_DAY, due.get(Calendar.HOUR_OF_DAY));
		d.set(Calendar.MINUTE, due.get(Calendar.MINUTE));
		int Diffdays = 0;
		if(o.get(Calendar.YEAR) == d.get(Calendar.YEAR) &&
                  o.get(Calendar.DAY_OF_YEAR) == d.get(Calendar.DAY_OF_YEAR)){

			return 0;
		}
		if(d.after(o)){
			while(d.after(o)){
				d.add(Calendar.DAY_OF_MONTH, -1);
				Diffdays++;
				if(Diffdays > 99){
					return 1000;
				}
			}
			return Diffdays;
		}else if(d.before(o)){
			while(d.before(o)){
				d.add(Calendar.DAY_OF_MONTH, 1);
				Diffdays--;
				if(Diffdays < -99){
					return -1000;
				}
			}
			return Diffdays;
		}else{
			return 0;
		}
		
	}
	
	public static Calendar setReminder(Context ctx, ContentValues v, String period){
		Calendar due = Calendar.getInstance();
		due.set(Calendar.YEAR, v.getAsInteger("due_year"));
		due.set(Calendar.MONTH, v.getAsInteger("due_month"));
		due.set(Calendar.DAY_OF_MONTH, v.getAsInteger("due_day"));
		due.set(Calendar.HOUR_OF_DAY, v.getAsInteger("due_hour"));
		due.set(Calendar.MINUTE, v.getAsInteger("due_min"));
		due.set(Calendar.SECOND, 0);
		due.set(Calendar.MILLISECOND, 0);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, due.get(Calendar.YEAR));
		c.set(Calendar.MONTH, due.get(Calendar.MONTH));
		c.set(Calendar.DAY_OF_MONTH, due.get(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR_OF_DAY, due.get(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, due.get(Calendar.MINUTE));
		c.set(Calendar.SECOND, due.get(Calendar.SECOND));
		c.set(Calendar.MILLISECOND,due.get(Calendar.MILLISECOND));
		switch(period){
		case "3 weeks before":
			c.add(Calendar.DATE, -21);
			AlarmHandler.setduedays(calculateDueDays(due));
			break;
		case "2 weeks before":
			c.add(Calendar.DATE, -14);
			AlarmHandler.setduedays(calculateDueDays(due));
			break;
		case "1 week before":
			c.add(Calendar.DATE, -7);
			AlarmHandler.setduedays(calculateDueDays(due));
			break;
		case "3 days before":
			c.add(Calendar.DATE, -3);
			AlarmHandler.setduedays(calculateDueDays(due));
			break;
		case "2 days before":
			c.add(Calendar.DATE, -2);
			AlarmHandler.setduedays(calculateDueDays(due));
			break;
		case "24 hours before":
			c.add(Calendar.DATE, -1);
			AlarmHandler.setduedays(calculateDueDays(due));
			break;
		case "12 hours before":
			c.add(Calendar.HOUR_OF_DAY, -12);
			AlarmHandler.setduedays(-12);
			break;
		case "8 hours before":
			c.add(Calendar.HOUR_OF_DAY, -8);
			AlarmHandler.setduedays(-8);
			break;
		case "4 hours before":
			c.add(Calendar.HOUR_OF_DAY, -4);
			AlarmHandler.setduedays(-4);
			break;
		case "2 hours before":
			c.add(Calendar.HOUR_OF_DAY, -2);
			AlarmHandler.setduedays(-2);
			break;
		case "1 hour before":
			c.add(Calendar.HOUR_OF_DAY, -1);
			AlarmHandler.setduedays(-1);
			break;
		case "30 minutes before":
			c.add(Calendar.MINUTE, -30);
			AlarmHandler.setduedays(-30);
			break;
		case "10 minutes before":
			c.add(Calendar.MINUTE, -10);
			AlarmHandler.setduedays(-10);
			break;
		}
		return c;
	}

	public static boolean invalidDueDate(Context ctx, ContentValues h) {
		// TODO Auto-generated method stub
		Calendar today = Calendar.getInstance();
		Calendar due = Calendar.getInstance();
		due.set(Calendar.YEAR, h.getAsInteger("due_year"));
		due.set(Calendar.MONTH, h.getAsInteger("due_month"));
		due.set(Calendar.DAY_OF_MONTH, h.getAsInteger("due_day"));
		due.set(Calendar.HOUR_OF_DAY, h.getAsInteger("due_hour"));
		due.set(Calendar.MINUTE, h.getAsInteger("due_min"));
		due.set(Calendar.SECOND, 0);
		due.set(Calendar.MILLISECOND, 0);
		
		if(due.before(today)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean invalidDueDate(Calendar due) {
		// TODO Auto-generated method stub
		Calendar today = Calendar.getInstance();
		if(due.before(today)){
			return true;
		}else{
			return false;
		}
	}
	
	public static int getInterval(int index){
		switch(index){
		case 0:
			return 7;
		case 1:
			return 14;	
		case 2:
			return 21;
		case 3:
			return 1;
		case 4:
			return 2;
		case 5:
			return 3;
		case 6:
			return 4;
		case 7:
			return 5;
		}
		return 0;
	}

	public static Calendar generateDueCalendar(int due_year, int due_month,
			int due_day, int due_hour, int due_minute) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, due_year);
		c.set(Calendar.MONTH, due_month);
		c.set(Calendar.DAY_OF_MONTH, due_day);
		c.set(Calendar.HOUR_OF_DAY, due_hour);
		c.set(Calendar.MINUTE, due_minute);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		return c;
	}

	public static boolean isAlarmActive(int alarm) {
		// TODO Auto-generated method stub
		if(alarm == 0){
			return false;
		}else{
			return true;
		}
	}
	public static int isAlarmActive(boolean bool) {
		// TODO Auto-generated method stub
		if(bool){
			return 1;
		}else{
			return 0;
		}
	}

	public static int getTypePosition(String type) {
		// TODO Auto-generated method stub
		if(type.contentEquals("Homework")){
			return 0;
		}else if(type.contentEquals("Lab")){
			return 1;
		}else if(type.contentEquals("Exam")){
			return 2;
		}else{
			return 3;
		}
	}

	@SuppressWarnings("unchecked")
	public static int getSubjectPosition(String subject,
			ArrayList<String> subjectArray) {
		// TODO Auto-generated method stub
		ArrayList<String> k = new ArrayList<String>();
		k = (ArrayList<String>) subjectArray.clone();
		return k.indexOf(subject);
	}

	public static int getReminderPosition(String string, String[] reminders) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(reminders));
		return list.indexOf(string);
	}

	public static int calculateInterval(Calendar first, Calendar second) {
		// TODO Auto-generated method stub
		int interval = 0;
		first.set(Calendar.SECOND, 0);
		first.set(Calendar.MILLISECOND, 0);
		second.set(Calendar.SECOND, 0);
		second.set(Calendar.MILLISECOND, 0);
		if(first.before(second)){
			while(first.before(second)){
				first.add(Calendar.DAY_OF_MONTH, 1);
				interval++;
			}
		}else if(first.after(second)){
			while(second.before(first)){
				second.add(Calendar.DAY_OF_MONTH, 1);
				interval++;
			}
		}else{
			return 0;
		}
		return interval;
	}
	 
	public static int isCompleted(String status){
		if(status.contentEquals("Pending")){
			return 0;
		}else{
			return 1;
		}
	}
	
	public static String generateDueDaysString(int duedays){
		if (duedays > 0) {
			if (duedays == 1000) {
				return new String("Due in the future");
			} else if (duedays == 1) {
				return new String("Due tomorrow");
			} else {
				return new String("Due in " + duedays + " days");
			}
		} else if (duedays < 0) {
			if (duedays == -1000) {
				return new String("Overdue");
			} else if (duedays == -1) {
				return new String("Due yesterday");
			} else {
				duedays = 0 - duedays;
				return new String(duedays + " days overdue");
			}
		} else {
			return new String("Due today");
		}
	}
	
	public static int calcSum(int...value){
		int result = 0;
		for(int i: value){
			result += i;
		}
		return result;
	}
}
