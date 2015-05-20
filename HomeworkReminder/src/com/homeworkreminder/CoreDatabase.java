package com.homeworkreminder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class CoreDatabase {

	private static final String DATABASE_NAME = "HRCoreDatabase";
	private static final String DATABASE_TABLE = "HRCoreTable";
	private static final String ID = "_id";
	private static final String NAME = "Name";
	private static final String TYPE = "Type";
	private static final String SUBJECT = "Subject";
	private static final String DUE_YEAR = "Due_Year";
	private static final String DUE_MONTH = "Due_Month";
	private static final String DUE_DAY = "Due_Day";
	private static final String DUE_HOUR = "Due_Hour";
	private static final String DUE_MIN = "Due_Min";
	private static final String REMINDERS = "Reminders";
	private static final String NOTES = "Notes";
	private static final String STATUS = "Status";
	private static final String ALARM_ACTIVE = "Alarm_Active";

	private static final String LINKED = "Linked";
	private static final String INTERVAL = "Interval";
	private static final String INDEX = "Task_Index";
	private static final String PRE_TAG = "Pre_tag";
	private static final String NXT_TAG = "Nxt_tag";

	private static final String SUBJECT_TABLE = "SubjectTable";
	private static final String SUBJECT_ID = "subject_id";

	private static final String ALARM_TABLE = "AlarmTable";
	private static final String ALARM_DATABASE_ID = "AlarmDatabaseID";
	private static final String ALARM_ID = "AlarmID";
	private static final String ALARM_TASK_ID = "AlarmTaskID";
	private static final String ALARM_NAME = "AlarmName";
	private static final String ALARM_TYPE = "AlarmType";
	private static final String ALARM_SUBJECT = "AlarmSubject";
	private static final String ALARM_DUE_YEAR = "AlarmDueYear";
	private static final String ALARM_DUE_MONTH = "AlarmDueMonth";
	private static final String ALARM_DUE_DAY = "AlarmDueDay";
	private static final String ALARM_DUE_HOUR = "AlarmDueHour";
	private static final String ALARM_DUE_MINUTE = "AlarmDueMinute";
	private static final String ALARM_REMINDER = "AlarmReminder";

	private static final int DATABASE_VERSION = 1;
	private final Context context;
	public boolean InvalidDue = false;
	private static final String DATABASE_COUNT = "SELECT * FROM "
			+ DATABASE_TABLE + " WHERE " + ID + " = (SELECT MAX(" + ID
			+ ")  FROM " + DATABASE_TABLE + ");";

	private static final String ALARM_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
			+ ALARM_TABLE
			+ " ("
			+ ALARM_DATABASE_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ ALARM_ID
			+ " INTEGER, "
			+ ALARM_TASK_ID
			+ " INTEGER, "
			+ ALARM_NAME
			+ " VARCHAR(255), "
			+ ALARM_TYPE
			+ " VARCHAR(255), "
			+ ALARM_SUBJECT
			+ " VARCHAR(255), "
			+ ALARM_DUE_YEAR
			+ " INTEGER, "
			+ ALARM_DUE_MONTH
			+ " INTEGER, "
			+ ALARM_DUE_DAY
			+ " INTEGER, "
			+ ALARM_DUE_HOUR
			+ " INTEGER, "
			+ ALARM_DUE_MINUTE
			+ " INTEGER, "
			+ ALARM_REMINDER + " VARCHAR(255) " + ");";

	private static final String SUBJECT_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
			+ SUBJECT_TABLE
			+ "("
			+ SUBJECT_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ SUBJECT
			+ " VARCHAR(255) " + ");";
	private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS "
			+ DATABASE_TABLE + "(" + ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255),"
			+ TYPE + " VARCHAR(255)," + SUBJECT + " VARCHAR(255), " + DUE_YEAR
			+ " INTEGER," + DUE_MONTH + " INTEGER," + DUE_DAY + " INTEGER,"
			+ DUE_HOUR + " INTEGER," + DUE_MIN + " INTEGER," + REMINDERS
			+ " VARCHAR(255), " + NOTES + " VARCHAR(255), " + STATUS
			+ " VARVHAR(255)," + LINKED + " INTEGER, " + INDEX + " INTEGER, "
			+ INTERVAL + " INTEGER," + PRE_TAG + " VARCHAR(255)," + NXT_TAG
			+ " VARCHAR(255), " + ALARM_ACTIVE + " INTEGER " + ");";
	private static final String DATABASE_DELETE = "DROP TABLE IF EXISTS "
			+ DATABASE_TABLE;
	private static final String SUBJECT_TABLE_DELETE = "DROP TABLE IF EXISTS "
			+ SUBJECT_TABLE;
	private static final String ALARM_TABLE_DELETE = "DROP TABLE IF EXISTS "
			+ ALARM_TABLE;
	private static DatabaseHelper DBHelper;

	public CoreDatabase(Context ctx) {
		this.context = ctx;
		DBHelper = DatabaseHelper.getInstance(context);
	}
	

	private static class DatabaseHelper extends SQLiteOpenHelper {
		
		private static DatabaseHelper helper;

		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}
		
		 public static synchronized DatabaseHelper getInstance(Context context)
		    {
		        if (helper == null)
		        	helper =  new DatabaseHelper(context.getApplicationContext());   
		        return helper;

		    }


		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			try {
				db.execSQL(DATABASE_CREATE);
				db.execSQL(SUBJECT_TABLE_CREATE);
				db.execSQL(ALARM_TABLE_CREATE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			try {
				db.execSQL(DATABASE_DELETE);
				db.execSQL(SUBJECT_TABLE_DELETE);
				db.execSQL(ALARM_TABLE_DELETE);
				onCreate(db);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public long insertSingleTask(String name, String type, String subject,
			int due_year, int due_month, int due_day, int due_hour,
			int due_min, String[] reminders, String notes, int AlarmActive) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(NAME, name);
		contentValues.put(TYPE, type);
		contentValues.put(SUBJECT, subject);
		contentValues.put(DUE_YEAR, due_year);
		contentValues.put(DUE_MONTH, due_month);
		contentValues.put(DUE_DAY, due_day);
		contentValues.put(DUE_HOUR, due_hour);
		contentValues.put(DUE_MIN, due_min);
		contentValues.put(REMINDERS, Util.convertArrayToString(reminders));
		contentValues.put(NOTES, notes);
		contentValues.put(STATUS, "Pending");
		contentValues.put(LINKED, 0);
		contentValues.put(INDEX, 0);
		contentValues.put(INTERVAL, 0);
		contentValues.put(PRE_TAG, "0");
		contentValues.put(NXT_TAG, "0");
		contentValues.put(ALARM_ACTIVE, AlarmActive);
		long id = db.insert(DATABASE_TABLE, null, contentValues);
		//db.close();

		return id;
	}

	public long insertRepeatingTask(String name, String type, String subject,
			int due_year, int due_month, int due_day, int due_hour,
			int due_min, String[] reminders, String notes, int AlarmActive,
			int currIndex, int interval, String prv_tag, String nxt_tag) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(NAME, name);
		contentValues.put(TYPE, type);
		contentValues.put(SUBJECT, subject);
		contentValues.put(DUE_YEAR, due_year);
		contentValues.put(DUE_MONTH, due_month);
		contentValues.put(DUE_DAY, due_day);
		contentValues.put(DUE_HOUR, due_hour);
		contentValues.put(DUE_MIN, due_min);
		contentValues.put(REMINDERS, Util.convertArrayToString(reminders));
		contentValues.put(NOTES, notes);
		contentValues.put(STATUS, "Pending");
		contentValues.put(LINKED, 1);
		contentValues.put(INDEX, currIndex);
		contentValues.put(INTERVAL, interval);
		contentValues.put(PRE_TAG, prv_tag);
		contentValues.put(NXT_TAG, nxt_tag);
		contentValues.put(ALARM_ACTIVE, AlarmActive);
		long id = db.insert(DATABASE_TABLE, null, contentValues);
		//db.close();
		return id;
	}

	public long updateRepeatingTask(int id, String name, String type,
			String subject, String status, int due_year, int due_month,
			int due_day, int due_hour, int due_min, String[] reminders,
			String notes, int AlarmActive, int currIndex, int interval,
			String prv_tag, String nxt_tag) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(NAME, name);
		contentValues.put(TYPE, type);
		contentValues.put(SUBJECT, subject);
		contentValues.put(DUE_YEAR, due_year);
		contentValues.put(DUE_MONTH, due_month);
		contentValues.put(DUE_DAY, due_day);
		contentValues.put(DUE_HOUR, due_hour);
		contentValues.put(DUE_MIN, due_min);
		contentValues.put(REMINDERS, Util.convertArrayToString(reminders));
		contentValues.put(STATUS, status);
		contentValues.put(NOTES, notes);
		contentValues.put(LINKED, 1);
		contentValues.put(INDEX, currIndex);
		contentValues.put(INTERVAL, interval);
		contentValues.put(PRE_TAG, prv_tag);
		contentValues.put(NXT_TAG, nxt_tag);
		contentValues.put(ALARM_ACTIVE, AlarmActive);
		String[] whereArgs = new String[] { String.valueOf(id) };
		int i = db.update(DATABASE_TABLE, contentValues, ID + "=?", whereArgs);
		//db.close();
		return i;
	}

	public void updateNextTag(long previous_id, long its_next_id) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(NXT_TAG, String.valueOf(its_next_id));
		String[] whereArgs = new String[] { String.valueOf(previous_id) };
		db.update(DATABASE_TABLE, contentValues, ID + "=?", whereArgs);
		//db.close();
	}

	public int updateSingleTask(int id, String name, String type,
			String subject, int due_year, int due_month, int due_day,
			int due_hour, int due_min, String[] reminders, String notes,
			int AlarmActive) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(NAME, name);
		contentValues.put(TYPE, type);
		contentValues.put(SUBJECT, subject);
		contentValues.put(DUE_YEAR, due_year);
		contentValues.put(DUE_MONTH, due_month);
		contentValues.put(DUE_DAY, due_day);
		contentValues.put(DUE_HOUR, due_hour);
		contentValues.put(DUE_MIN, due_min);
		contentValues.put(REMINDERS, Util.convertArrayToString(reminders));
		contentValues.put(NOTES, notes);
		contentValues.put(STATUS, "Pending");
		contentValues.put(LINKED, 0);
		contentValues.put(INDEX, 0);
		contentValues.put(INTERVAL, 0);
		contentValues.put(PRE_TAG, "0");
		contentValues.put(NXT_TAG, "0");
		contentValues.put(ALARM_ACTIVE, AlarmActive);
		String[] whereArgs = new String[] { String.valueOf(id) };
		int i = db.update(DATABASE_TABLE, contentValues, ID + "=?", whereArgs);
		//db.close();

		return i;
	}

	public long insertAlarm(int Alarm_ID, int originalTaskID, String name,
			String type, String subject, int due_year, int due_month,
			int due_day, int due_hour, int due_minute, String reminder) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(ALARM_ID, Alarm_ID);
		contentValues.put(ALARM_TASK_ID, originalTaskID);
		contentValues.put(ALARM_NAME, name);
		contentValues.put(ALARM_TYPE, type);
		contentValues.put(ALARM_SUBJECT, subject);
		contentValues.put(ALARM_DUE_YEAR, due_year);
		contentValues.put(ALARM_DUE_MONTH, due_month);
		contentValues.put(ALARM_DUE_DAY, due_day);
		contentValues.put(ALARM_DUE_HOUR, due_hour);
		contentValues.put(ALARM_DUE_MINUTE, due_minute);
		contentValues.put(ALARM_REMINDER, reminder);
		long id = db.insert(ALARM_TABLE, null, contentValues);
		//db.close();
		return id;
	}

	public ArrayList<ContentValues> queryAlarmList() {
		ArrayList<ContentValues> list = new ArrayList<ContentValues>();
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		String[] columns = { ALARM_DATABASE_ID, ALARM_ID, ALARM_TASK_ID,
				ALARM_NAME, ALARM_TYPE, ALARM_SUBJECT, ALARM_DUE_YEAR,
				ALARM_DUE_MONTH, ALARM_DUE_DAY, ALARM_DUE_HOUR,
				ALARM_DUE_MINUTE, ALARM_REMINDER };
		Cursor cursor = db.query(ALARM_TABLE, columns, null, null, null, null,
				null);
		while (cursor.moveToNext()) {
			ContentValues value = new ContentValues();
			int index_alarm_database_id = cursor
					.getColumnIndex(ALARM_DATABASE_ID);
			int index_alarm_id = cursor.getColumnIndex(ALARM_ID);
			int index_alarm_task_id = cursor.getColumnIndex(ALARM_TASK_ID);
			int index_name = cursor.getColumnIndex(ALARM_NAME);
			int index_type = cursor.getColumnIndex(ALARM_TYPE);
			int index_subject = cursor.getColumnIndex(ALARM_SUBJECT);
			int index_due_year = cursor.getColumnIndex(ALARM_DUE_YEAR);
			int index_due_month = cursor.getColumnIndex(ALARM_DUE_MONTH);
			int index_due_day = cursor.getColumnIndex(ALARM_DUE_DAY);
			int index_due_minute = cursor.getColumnIndex(ALARM_DUE_MINUTE);
			int index_due_hour = cursor.getColumnIndex(ALARM_DUE_HOUR);
			int index_alarm_reminder = cursor.getColumnIndex(ALARM_REMINDER);

			int alarm_database_id = cursor.getInt(index_alarm_database_id);
			int alarm_id = cursor.getInt(index_alarm_id);
			int alarm_task_id = cursor.getInt(index_alarm_task_id);
			String name = cursor.getString(index_name);
			String type = cursor.getString(index_type);
			String subject = cursor.getString(index_subject);
			int due_year = cursor.getInt(index_due_year);
			int due_month = cursor.getInt(index_due_month);
			int due_day = cursor.getInt(index_due_day);
			int due_hour = cursor.getInt(index_due_hour);
			int due_minute = cursor.getInt(index_due_minute);
			String reminder = cursor.getString(index_alarm_reminder);

			value.put("alarm_database_id", alarm_database_id);
			value.put("id", (long) alarm_id);
			value.put("original_id", alarm_task_id);
			value.put("name", name);
			value.put("type", type);
			value.put("subject", subject);
			value.put("due_year", due_year);
			value.put("due_month", due_month);
			value.put("due_day", due_day);
			value.put("due_hour", due_hour);
			value.put("due_min", due_minute);
			value.put("reminder", reminder);
			list.add(value);
		}
		cursor.close();
		//db.close();
		return list;
	}

	public void updateAlarmTable(int database_id, int new_alarm_id,
			int original_id, String new_name, String new_type, String subject,
			int due_year, int due_month, int due_day, int due_hour,
			int due_minute, String new_reminder) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		ContentValues v = new ContentValues();
		v.put(ALARM_NAME, new_name);
		v.put(ALARM_ID, new_alarm_id);
		v.put(ALARM_TASK_ID, original_id);
		v.put(ALARM_TYPE, new_type);
		v.put(ALARM_SUBJECT, subject);
		v.put(ALARM_DUE_YEAR, due_year);
		v.put(ALARM_DUE_MONTH, due_month);
		v.put(ALARM_DUE_DAY, due_day);
		v.put(ALARM_DUE_HOUR, due_hour);
		v.put(ALARM_DUE_MINUTE, due_minute);
		v.put(ALARM_REMINDER, new_reminder);
		String[] whereArgs = new String[] { String.valueOf(database_id) };
		db.update(ALARM_TABLE, v, ALARM_DATABASE_ID + "=?", whereArgs);
		//db.close();
	}

	public void deleteAlarm(int alarm_id) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		String[] whereArgs = new String[] { String.valueOf(alarm_id) };
		db.delete(ALARM_TABLE, ALARM_ID + "=?", whereArgs);
		//db.close();
	}

	public void deleteAllAlarms() {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		db.delete(ALARM_TABLE, null, null);
		//db.close();
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////

	public long insertSubject(String subject) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(SUBJECT, subject);
		long id = db.insert(SUBJECT_TABLE, null, contentValues);
		//db.close();
		return id;
	}

	public ArrayList<String> querySubjectList() {
		ArrayList<String> rl = new ArrayList<String>();
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		String[] columns = { SUBJECT_ID, SUBJECT };
		Cursor cursor = db.query(SUBJECT_TABLE, columns, null, null, null,
				null, null);
		while (cursor.moveToNext()) {
			int index_subject = cursor.getColumnIndex(SUBJECT);
			String subject = cursor.getString(index_subject);
			rl.add(subject);
		}
		cursor.close();
		//db.close();
		return rl;
	}

	public void updateSubjectTable(String old_sub, String new_sub) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		String[] whereArgs = new String[] { old_sub };
		ContentValues args = new ContentValues();
		args.put(SUBJECT, new_sub);
		db.update(SUBJECT_TABLE, args, SUBJECT + "=?", whereArgs);
		db.close();
	}

	public void deleteSubject(String subject) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		String[] whereArgs = new String[] { subject };
		db.delete(SUBJECT_TABLE, SUBJECT + "=?", whereArgs);
		//db.close();
	}

	public void deleteAllSubjects() {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		db.delete(SUBJECT_TABLE, null, null);
		//db.close();
	}

	public List<Task> getAllTask(String status) {

		List<Task> t_list = new ArrayList<Task>();
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		Cursor cursor;
		if (status.contentEquals("Pending")) {
			String[] columns = { ID, NAME, TYPE, SUBJECT, DUE_YEAR, DUE_MONTH,
					DUE_DAY, DUE_HOUR, DUE_MIN, REMINDERS, NOTES, STATUS,
					LINKED, INDEX, INTERVAL, PRE_TAG, NXT_TAG, ALARM_ACTIVE };

			cursor = db.query(DATABASE_TABLE, columns, null, null, null, null,
					null);
			while (cursor.moveToNext()) {
				int index_status = cursor.getColumnIndex(STATUS);
				String s = cursor.getString(index_status);
				if (s.contentEquals("Completed")) {
					continue;
				}

				int index_id = cursor.getColumnIndex(ID);
				int index_name = cursor.getColumnIndex(NAME);
				int index_type = cursor.getColumnIndex(TYPE);
				int index_subject = cursor.getColumnIndex(SUBJECT);
				int index_year = cursor.getColumnIndex(DUE_YEAR);
				int index_month = cursor.getColumnIndex(DUE_MONTH);
				int index_day = cursor.getColumnIndex(DUE_DAY);
				int index_hour = cursor.getColumnIndex(DUE_HOUR);
				int index_minute = cursor.getColumnIndex(DUE_MIN);
				int index_reminders = cursor.getColumnIndex(REMINDERS);
				int index_notes = cursor.getColumnIndex(NOTES);
				int index_interval = cursor.getColumnIndex(INTERVAL);
				int index_pre_tag = cursor.getColumnIndex(PRE_TAG);
				int index_nxt_tag = cursor.getColumnIndex(NXT_TAG);
				int index_linked = cursor.getColumnIndex(LINKED);
				int index_index = cursor.getColumnIndex(INDEX);
				int index_alarm = cursor.getColumnIndex(ALARM_ACTIVE);

				int id = cursor.getInt(index_id);
				String name = cursor.getString(index_name);
				String type = cursor.getString(index_type);
				String subject = cursor.getString(index_subject);
				int due_year = cursor.getInt(index_year);
				int due_month = cursor.getInt(index_month);
				int due_day = cursor.getInt(index_day);
				int due_hour = cursor.getInt(index_hour);
				int due_minute = cursor.getInt(index_minute);
				String[] reminders = Util.convertStringToArray(cursor
						.getString(index_reminders));
				String notes = cursor.getString(index_notes);
				int interval = cursor.getInt(index_interval);
				String pre_tag = cursor.getString(index_pre_tag);
				String nxt_tag = cursor.getString(index_nxt_tag);
				int linked = cursor.getInt(index_linked);
				int index = cursor.getInt(index_index);
				int alarm = cursor.getInt(index_alarm);
				Task t = new Task(id, name, type, subject,
						Util.generateDueCalendar(due_year, due_month, due_day,
								due_hour, due_minute), reminders, notes,
						status, linked, index, interval, pre_tag, nxt_tag,
						Util.isAlarmActive(alarm)

				);
				t_list.add(t);
			}
			cursor.close();
			//db.close();
			return t_list;
		} else if (status.contentEquals("Completed")) {
			String[] columns = { ID, NAME, TYPE, SUBJECT, DUE_YEAR, DUE_MONTH,
					DUE_DAY, DUE_HOUR, DUE_MIN, REMINDERS, NOTES, STATUS,
					LINKED, INDEX, INTERVAL, PRE_TAG, NXT_TAG, ALARM_ACTIVE };
			cursor = db.query(DATABASE_TABLE, columns, null, null, null, null,
					null);

			while (cursor.moveToNext()) {
				int index_status = cursor.getColumnIndex(STATUS);
				String s = cursor.getString(index_status);
				if (s.contentEquals("Pending")) {
					continue;
				}
				int index_id = cursor.getColumnIndex(ID);
				int index_name = cursor.getColumnIndex(NAME);
				int index_type = cursor.getColumnIndex(TYPE);
				int index_subject = cursor.getColumnIndex(SUBJECT);
				int index_year = cursor.getColumnIndex(DUE_YEAR);
				int index_month = cursor.getColumnIndex(DUE_MONTH);
				int index_day = cursor.getColumnIndex(DUE_DAY);
				int index_hour = cursor.getColumnIndex(DUE_HOUR);
				int index_minute = cursor.getColumnIndex(DUE_MIN);
				int index_reminders = cursor.getColumnIndex(REMINDERS);
				int index_notes = cursor.getColumnIndex(NOTES);
				int index_interval = cursor.getColumnIndex(INTERVAL);
				int index_pre_tag = cursor.getColumnIndex(PRE_TAG);
				int index_nxt_tag = cursor.getColumnIndex(NXT_TAG);
				int index_linked = cursor.getColumnIndex(LINKED);
				int index_index = cursor.getColumnIndex(INDEX);
				int index_alarm = cursor.getColumnIndex(ALARM_ACTIVE);

				int id = cursor.getInt(index_id);
				String name = cursor.getString(index_name);
				String type = cursor.getString(index_type);
				String subject = cursor.getString(index_subject);
				int due_year = cursor.getInt(index_year);
				int due_month = cursor.getInt(index_month);
				int due_day = cursor.getInt(index_day);
				int due_hour = cursor.getInt(index_hour);
				int due_minute = cursor.getInt(index_minute);
				String[] reminders = Util.convertStringToArray(cursor
						.getString(index_reminders));
				String notes = cursor.getString(index_notes);
				int interval = cursor.getInt(index_interval);
				String pre_tag = cursor.getString(index_pre_tag);
				String nxt_tag = cursor.getString(index_nxt_tag);
				int linked = cursor.getInt(index_linked);
				int index = cursor.getInt(index_index);
				int alarm = cursor.getInt(index_alarm);
				Task t = new Task(id, name, type, subject,
						Util.generateDueCalendar(due_year, due_month, due_day,
								due_hour, due_minute), reminders, notes,
						status, linked, index, interval, pre_tag, nxt_tag,
						Util.isAlarmActive(alarm));
				t_list.add(t);
			}
			cursor.close();
			//db.close();
			return t_list;
		}
		//db.close();
		return t_list;
	}

	public List<Task> selectByName(String name) {

		SQLiteDatabase db = DBHelper.getWritableDatabase();
		String[] columns = { ID, NAME, TYPE, SUBJECT, DUE_YEAR, DUE_MONTH,
				DUE_DAY, DUE_HOUR, DUE_MIN, REMINDERS, NOTES, STATUS, LINKED,
				INDEX, INTERVAL, PRE_TAG, NXT_TAG, ALARM_ACTIVE };
		Cursor cursor = db.query(DATABASE_TABLE, columns, NAME + " = ' " + name
				+ " ' ", null, null, null, null);
		List<Task> t_list = new ArrayList<Task>();
		while (cursor.moveToNext()) {
			int index_status = cursor.getColumnIndex(STATUS);
			String s = cursor.getString(index_status);
			int index_id = cursor.getColumnIndex(ID);
			int index_name = cursor.getColumnIndex(NAME);
			int index_type = cursor.getColumnIndex(TYPE);
			int index_subject = cursor.getColumnIndex(SUBJECT);
			int index_year = cursor.getColumnIndex(DUE_YEAR);
			int index_month = cursor.getColumnIndex(DUE_MONTH);
			int index_day = cursor.getColumnIndex(DUE_DAY);
			int index_hour = cursor.getColumnIndex(DUE_HOUR);
			int index_minute = cursor.getColumnIndex(DUE_MIN);
			int index_reminders = cursor.getColumnIndex(REMINDERS);
			int index_notes = cursor.getColumnIndex(NOTES);
			int index_interval = cursor.getColumnIndex(INTERVAL);
			int index_pre_tag = cursor.getColumnIndex(PRE_TAG);
			int index_nxt_tag = cursor.getColumnIndex(NXT_TAG);
			int index_linked = cursor.getColumnIndex(LINKED);
			int index_index = cursor.getColumnIndex(INDEX);
			int index_alarm = cursor.getColumnIndex(ALARM_ACTIVE);

			int id = cursor.getInt(index_id);
			String n = cursor.getString(index_name);
			String type = cursor.getString(index_type);
			String subject = cursor.getString(index_subject);
			int due_year = cursor.getInt(index_year);
			int due_month = cursor.getInt(index_month);
			int due_day = cursor.getInt(index_day);
			int due_hour = cursor.getInt(index_hour);
			int due_minute = cursor.getInt(index_minute);
			String[] reminders = Util.convertStringToArray(cursor
					.getString(index_reminders));
			String notes = cursor.getString(index_notes);
			int interval = cursor.getInt(index_interval);
			String pre_tag = cursor.getString(index_pre_tag);
			String nxt_tag = cursor.getString(index_nxt_tag);
			int linked = cursor.getInt(index_linked);
			int index = cursor.getInt(index_index);
			int alarm = cursor.getInt(index_alarm);
			Task t = new Task(id, n, type, subject, Util.generateDueCalendar(
					due_year, due_month, due_day, due_hour, due_minute),
					reminders, notes, s, linked, index, interval, pre_tag,
					nxt_tag, Util.isAlarmActive(alarm)

			);
			t_list.add(t);
		}
		cursor.close();
		//db.close();
		return t_list;
	}

	public Task queryById(int id) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		Cursor cursor = db.query(DATABASE_TABLE, null, ID + " =? ",
				new String[] { Integer.toString(id) }, null, null, null);
		Task t = null;
		while (cursor.moveToNext()) {
			int index_status = cursor.getColumnIndex(STATUS);
			String s = cursor.getString(index_status);
			int index_name = cursor.getColumnIndex(NAME);
			int index_type = cursor.getColumnIndex(TYPE);
			int index_subject = cursor.getColumnIndex(SUBJECT);
			int index_year = cursor.getColumnIndex(DUE_YEAR);
			int index_month = cursor.getColumnIndex(DUE_MONTH);
			int index_day = cursor.getColumnIndex(DUE_DAY);
			int index_hour = cursor.getColumnIndex(DUE_HOUR);
			int index_minute = cursor.getColumnIndex(DUE_MIN);
			int index_reminders = cursor.getColumnIndex(REMINDERS);
			int index_notes = cursor.getColumnIndex(NOTES);
			int index_interval = cursor.getColumnIndex(INTERVAL);
			int index_pre_tag = cursor.getColumnIndex(PRE_TAG);
			int index_nxt_tag = cursor.getColumnIndex(NXT_TAG);
			int index_linked = cursor.getColumnIndex(LINKED);
			int index_index = cursor.getColumnIndex(INDEX);
			int index_alarm = cursor.getColumnIndex(ALARM_ACTIVE);

			String n = cursor.getString(index_name);
			String type = cursor.getString(index_type);
			String subject = cursor.getString(index_subject);
			int due_year = cursor.getInt(index_year);
			int due_month = cursor.getInt(index_month);
			int due_day = cursor.getInt(index_day);
			int due_hour = cursor.getInt(index_hour);
			int due_minute = cursor.getInt(index_minute);
			String[] reminders = Util.convertStringToArray(cursor
					.getString(index_reminders));
			String notes = cursor.getString(index_notes);
			int interval = cursor.getInt(index_interval);
			String pre_tag = cursor.getString(index_pre_tag);
			String nxt_tag = cursor.getString(index_nxt_tag);
			int linked = cursor.getInt(index_linked);
			int index = cursor.getInt(index_index);
			int alarm = cursor.getInt(index_alarm);
			t = new Task(id, n, type, subject, Util.generateDueCalendar(
					due_year, due_month, due_day, due_hour, due_minute),
					reminders, notes, s, linked, index, interval, pre_tag,
					nxt_tag, Util.isAlarmActive(alarm));
		}
		//db.close();
		return t;
	}

	public String[] queryReminder(int id) {

		String string = "";
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		String[] columns = { ID, REMINDERS };
		Cursor cursor = db.query(DATABASE_TABLE, columns, ID + " =? ",
				new String[] { Integer.toString(id) }, null, null, null);
		while (cursor.moveToNext()) {
			int index_reminder = cursor.getColumnIndex(REMINDERS);
			string = cursor.getString(index_reminder);
		}
		cursor.close();
		//db.close();
		return Util.convertStringToArray(string);
	}

	public Calendar queryDueCalendar(int id) {

		SQLiteDatabase db = DBHelper.getWritableDatabase();
		String[] columns = { ID, DUE_YEAR, DUE_MONTH, DUE_DAY, DUE_HOUR,
				DUE_MIN };
		Calendar calendar = Calendar.getInstance();
		String[] whereArgs = new String[] { String.valueOf(id) };
		Cursor cursor = db.query(DATABASE_TABLE, columns, ID + " =?",
				whereArgs, null, null, null);
		cursor.moveToFirst();
		while (cursor.moveToNext()) {
			int index_year = cursor.getColumnIndex(DUE_YEAR);
			int index_month = cursor.getColumnIndex(DUE_MONTH);
			int index_day = cursor.getColumnIndex(DUE_DAY);
			int index_hour = cursor.getColumnIndex(DUE_HOUR);
			int index_minute = cursor.getColumnIndex(DUE_MIN);
			int due_year = cursor.getInt(index_year);
			int due_month = cursor.getInt(index_month);
			int due_day = cursor.getInt(index_day);
			int due_hour = cursor.getInt(index_hour);
			int due_minute = cursor.getInt(index_minute);
			calendar.set(Calendar.YEAR, due_year);
			calendar.set(Calendar.MONTH, due_month);
			calendar.set(Calendar.DAY_OF_MONTH, due_day);
			calendar.set(Calendar.HOUR_OF_DAY, due_hour);
			calendar.set(Calendar.MINUTE, due_minute);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
		}
		cursor.close();
		//db.close();
		return calendar;
	}

	public List<Task> queryBySubject(String subject) {

		SQLiteDatabase db = DBHelper.getWritableDatabase();
		String[] columns = { ID, NAME, TYPE, SUBJECT, DUE_YEAR, DUE_MONTH,
				DUE_DAY, DUE_HOUR, DUE_MIN, REMINDERS, NOTES, STATUS, LINKED,
				INDEX, INTERVAL, PRE_TAG, NXT_TAG, ALARM_ACTIVE };
		Cursor cursor = db.query(DATABASE_TABLE, columns, SUBJECT + " = '"
				+ subject + "'", null, null, null, null);
		List<Task> t_list = new ArrayList<Task>();
		while (cursor.moveToNext()) {
			int index_status = cursor.getColumnIndex(STATUS);
			String s = cursor.getString(index_status);
			if (s.contentEquals("Completed")) {
				continue;
			}
			int index_id = cursor.getColumnIndex(ID);
			int index_name = cursor.getColumnIndex(NAME);
			int index_type = cursor.getColumnIndex(TYPE);
			int index_subject = cursor.getColumnIndex(SUBJECT);
			int index_year = cursor.getColumnIndex(DUE_YEAR);
			int index_month = cursor.getColumnIndex(DUE_MONTH);
			int index_day = cursor.getColumnIndex(DUE_DAY);
			int index_hour = cursor.getColumnIndex(DUE_HOUR);
			int index_minute = cursor.getColumnIndex(DUE_MIN);
			int index_reminders = cursor.getColumnIndex(REMINDERS);
			int index_notes = cursor.getColumnIndex(NOTES);
			int index_interval = cursor.getColumnIndex(INTERVAL);
			int index_pre_tag = cursor.getColumnIndex(PRE_TAG);
			int index_nxt_tag = cursor.getColumnIndex(NXT_TAG);
			int index_linked = cursor.getColumnIndex(LINKED);
			int index_index = cursor.getColumnIndex(INDEX);
			int index_alarm = cursor.getColumnIndex(ALARM_ACTIVE);

			int id = cursor.getInt(index_id);
			String n = cursor.getString(index_name);
			String type = cursor.getString(index_type);
			String sub = cursor.getString(index_subject);
			int due_year = cursor.getInt(index_year);
			int due_month = cursor.getInt(index_month);
			int due_day = cursor.getInt(index_day);
			int due_hour = cursor.getInt(index_hour);
			int due_minute = cursor.getInt(index_minute);
			String[] reminders = Util.convertStringToArray(cursor
					.getString(index_reminders));
			String notes = cursor.getString(index_notes);
			int interval = cursor.getInt(index_interval);
			String pre_tag = cursor.getString(index_pre_tag);
			String nxt_tag = cursor.getString(index_nxt_tag);
			int linked = cursor.getInt(index_linked);
			int index = cursor.getInt(index_index);
			int alarm = cursor.getInt(index_alarm);
			Task t = new Task(id, n, type, sub, Util.generateDueCalendar(
					due_year, due_month, due_day, due_hour, due_minute),
					reminders, notes, s, linked, index, interval, pre_tag,
					nxt_tag, Util.isAlarmActive(alarm));
			t_list.add(t);
		}
		cursor.close();
		//db.close();
		return t_list;
	}

	public void tempDisplay() {

		List<Task> l = new ArrayList<Task>();
		l = this.getAllTask("Pending");
		for (Task h : l) {
			Toast u = Toast.makeText(
					context,
					h.getId() + "  " + h.getIndex() + "        " + h.getName()
							+ "        " + h.getNotes() + "        "
							+ h.getStatus() + "        " + h.getSubject()
							+ "       " + h.getInterval() + "       "
							+ h.getType() + "       "
							+ h.getDue().get(Calendar.YEAR) + "           "
							+ h.getDue().get(Calendar.MONTH) + "           "
							+ h.getDue().get(Calendar.DAY_OF_MONTH)
							+ "           "
							+ h.getDue().get(Calendar.HOUR_OF_DAY)
							+ "           " + h.getDue().get(Calendar.MINUTE)
							+ "               " + h.getReminders()[0],
					Toast.LENGTH_LONG);
			u.show();

		}
	}

	public void deleteRecord(long rowId) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		db.delete(DATABASE_TABLE, ID + "=" + rowId, null);
		//db.close();
	}

	public void deleteAll() {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		db.delete(DATABASE_TABLE, null, null);
		//db.close();
	}

	public void deleteCompleted() {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		final String complete = "Completed";
		String[] whereArgs = new String[] { complete };
		db.delete(DATABASE_TABLE, STATUS + "=?", whereArgs);
		//db.close();
	}

	public void updateRecord(int id) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		ContentValues args = new ContentValues();
		db.update(DATABASE_TABLE, args, null, null);
		//db.close();
	}

	public boolean completeTask(int rowId) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		ContentValues args = new ContentValues();
		args.put(STATUS, "Completed");
		long l = db.update(DATABASE_TABLE, args, ID + "=" + rowId, null);
		//db.close();
		return l > 0;
	}

	public boolean uncompleteTask(int rowId) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		ContentValues args = new ContentValues();
		args.put(STATUS, "Pending");
		long l = db.update(DATABASE_TABLE, args, ID + "=" + rowId, null);
		//db.close();
		return l > 0;
	}

	public boolean deactivateAlarm(int rowId) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		ContentValues args = new ContentValues();
		args.put(ALARM_ACTIVE, 0);
		boolean v = db.update(DATABASE_TABLE, args, ID + "=" + rowId, null) > 0;
		//db.close();
		return v;
	}

	public boolean activateAlarm(int rowId) {
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		ContentValues args = new ContentValues();
		args.put(ALARM_ACTIVE, 1);
		boolean v = db.update(DATABASE_TABLE, args, ID + "=" + rowId, null) > 0;
		//db.close();
		return v;
	}

	public void updateSubject(int id, String new_subject) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = DBHelper.getWritableDatabase();
		ContentValues args = new ContentValues();
		args.put(SUBJECT, new_subject);
		db.update(DATABASE_TABLE, args, ID + "=" + id, null);
		//db.close();
	}
}
