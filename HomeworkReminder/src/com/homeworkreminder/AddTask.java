package com.homeworkreminder;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.homeworkreminder.Theme.ColorScheme;
import com.homeworkreminder.Theme.ThemeManager;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class AddTask extends Activity implements OnClickListener {

	private ArrayList<String> subjectArray = new ArrayList<String>();

	SharedPreferences sp;
	Button date_btn;
	Button time_btn;
	ImageButton add_reminder;
	ImageButton remove_extra_reminder_0;
	ImageButton remove_extra_reminder_1;
	Button save_btn;
	Button cancel_btn;
	Spinner type_spinner;
	Spinner subject_spinner;
	Spinner default_reminder_spinner;
	Spinner extra_reminder_spinner0;
	Spinner extra_reminder_spinner1;
	Spinner postlab_spinner;
	Spinner linked_interval_spinner;
	Spinner linked_amount_spinner;
	Spinner linked_indexing_spinner;
	TextView tvDue;
	Calendar calendar = Calendar.getInstance();
	DateFormat format = DateFormat.getDateInstance();
	Calendar time = Calendar.getInstance();
	EditText name;
	EditText notes;
	Context context;
	Switch reminder_switch;
	LinearLayout default_reminder_layout;
	LinearLayout extra_reminder_0_layout;
	LinearLayout extra_reminder_1_layout;
	LinearLayout postlab_layout;
	LinearLayout linked_info_container;
	Switch linked_switch;

	final static String startOfLinked = "START";
	final static String endOfLinked = "END";
	final static String placeHolder = "NXT";
	boolean isInfoValid = true;
	boolean lab_ex = false;
	boolean reminderEnable = true;
	static int reminder_count = 1;
	final String DEFAULT_SUBJECT = "Default subject";
	final String ADD_SUBJECT = "Create new";
	final String NOREMINDER = "NOREMINDER";
	static int Due_Year = Calendar.getInstance().get(Calendar.YEAR);
	static int Due_Month = Calendar.getInstance().get(Calendar.MONTH);
	static int Due_Day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	static int Due_Hour = 16;
	static int Due_Minute = 0;
	boolean terminationCode = false;
	static CoreDatabase Database;
	private static ThemeManager theme;
	private SharedPreferences prefs;
	ActionBar actionBar;
	private LinearLayout actionBarLayout;
	private ProgressDialog progress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		reminder_count = 1;
		terminationCode = false;
		// inflate custom action bar
		LayoutInflater inflater = (LayoutInflater) getActionBar()
				.getThemedContext().getSystemService(LAYOUT_INFLATER_SERVICE);
		View customActionBarView = inflater.inflate(R.layout.actionbar_custom,
				null);
		actionBar = getActionBar();
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM,
				ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME
						| ActionBar.DISPLAY_SHOW_TITLE);
		actionBar.setCustomView(customActionBarView,
				new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT));
		actionBarLayout = (LinearLayout) findViewById(R.id.add_action_bar_custom);
		// actionbar buttons
		save_btn = (Button) findViewById(R.id.save_btn);
		cancel_btn = (Button) findViewById(R.id.cancel_btn);
		save_btn.setOnClickListener(this);
		cancel_btn.setOnClickListener(this);

		// get setting
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		setContentView(R.layout.add_new);
		context = this;
		theme = new ThemeManager(context) {

			@SuppressLint("NewApi")
			@SuppressWarnings("deprecation")
			@Override
			public void setColor(ColorScheme scheme) {
				// TODO Auto-generated method stub
				StateListDrawable save_btn_selector = new StateListDrawable();
				save_btn_selector.addState(
						new int[] { android.R.attr.state_pressed },
						new ColorDrawable(scheme.getDarkerColor()));
				save_btn_selector.addState(StateSet.WILD_CARD,
						new ColorDrawable(scheme.getSuperDarkColor()));
				StateListDrawable cancel_btn_selector = new StateListDrawable();
				cancel_btn_selector.addState(
						new int[] { android.R.attr.state_pressed },
						new ColorDrawable(scheme.getDarkerColor()));
				cancel_btn_selector.addState(StateSet.WILD_CARD,
						new ColorDrawable(scheme.getSuperDarkColor()));
				actionBarLayout.setBackgroundColor(scheme.getSuperDarkColor());
				actionBarLayout.getChildAt(0).setBackgroundDrawable(
						cancel_btn_selector);
				actionBarLayout.getChildAt(1).setBackgroundDrawable(
						save_btn_selector);
				StateListDrawable date_btn_selector = new StateListDrawable();
				date_btn_selector.addState(
						new int[] { android.R.attr.state_pressed },
						new ColorDrawable(scheme.getLightColor()));
				date_btn_selector.addState(new int[] {}, new ColorDrawable(
						scheme.getNormalColor()));
				StateListDrawable time_btn_selector = new StateListDrawable();
				time_btn_selector.addState(
						new int[] { android.R.attr.state_pressed },
						new ColorDrawable(scheme.getLightColor()));
				time_btn_selector.addState(new int[] {}, new ColorDrawable(
						scheme.getNormalColor()));
				date_btn.setBackgroundDrawable(date_btn_selector);
				time_btn.setBackgroundDrawable(time_btn_selector);
				StateListDrawable thumbStates = new StateListDrawable();
				thumbStates.addState(
						new int[] { android.R.attr.state_checked },
						new ColorDrawable(scheme.getNormalColor()));
				thumbStates.addState(
						new int[] { -android.R.attr.state_checked },
						new ColorDrawable(ColorScheme.GREY.getNormalColor()));
				thumbStates.addState(
						new int[] { -android.R.attr.state_enabled },
						new ColorDrawable(ColorScheme.GREY.getLightColor()));
				thumbStates.addState(
						new int[] { android.R.attr.state_pressed },
						new ColorDrawable(scheme.getLightColor()));
				reminder_switch.setThumbDrawable(thumbStates);
				thumbStates = new StateListDrawable();
				thumbStates.addState(
						new int[] { android.R.attr.state_checked },
						new ColorDrawable(scheme.getNormalColor()));
				thumbStates.addState(
						new int[] { -android.R.attr.state_checked },
						new ColorDrawable(ColorScheme.GREY.getNormalColor()));
				thumbStates.addState(
						new int[] { -android.R.attr.state_enabled },
						new ColorDrawable(ColorScheme.GREY.getLightColor()));
				thumbStates.addState(
						new int[] { android.R.attr.state_pressed },
						new ColorDrawable(scheme.getLightColor()));
				linked_switch.setThumbDrawable(thumbStates);
			}

		};

		// get subjects
		Database = new CoreDatabase(context);
		subjectArray = Database.querySubjectList();
		subjectArray.add(0, DEFAULT_SUBJECT);
		subjectArray.add(1, ADD_SUBJECT);

		// reminder layouts
		default_reminder_layout = (LinearLayout) findViewById(R.id.default_reminder_container);
		extra_reminder_0_layout = (LinearLayout) findViewById(R.id.extra_reminder_container_0);
		extra_reminder_1_layout = (LinearLayout) findViewById(R.id.extra_reminder_container_1);

		// postlab_layout
		postlab_layout = (LinearLayout) findViewById(R.id.postlab_container);

		// time+date picker
		date_btn = (Button) findViewById(R.id.date_picker);
		time_btn = (Button) findViewById(R.id.time_picker);

		// edittexts
		name = (EditText) findViewById(R.id.et_name);
		notes = (EditText) findViewById(R.id.et_notes);
		/*
		 * add_reminder = (Button) findViewById(R.id.add_new_reminder_button);
		 * remove_extra_reminder_0 = (Button)
		 * findViewById(R.id.remove_extra_reminder_0_button);
		 * remove_extra_reminder_1 = (Button)
		 * findViewById(R.id.remove_extra_reminder_1_button);
		 */
		date_btn.setOnClickListener(this);
		time_btn.setOnClickListener(this);

		// switch
		reminder_switch = (Switch) findViewById(R.id.reminder_switch);
		reminder_switch.setChecked(true);
		reminder_switch.setOnClickListener(this);
		linked_switch = (Switch) findViewById(R.id.islinked_switch);
		linked_switch.setChecked(false);
		linked_switch.setOnClickListener(this);
		linked_switch.setVisibility(View.VISIBLE);

		// linked section
		linked_info_container = (LinearLayout) findViewById(R.id.linked_info_container);
		linked_amount_spinner = (Spinner) findViewById(R.id.linked_amount_spinner);
		linked_interval_spinner = (Spinner) findViewById(R.id.linked_interval_spinner);
		linked_indexing_spinner = (Spinner) findViewById(R.id.linked_autoindex_spinner);
		ArrayAdapter<CharSequence> linked_interval_adapter = ArrayAdapter
				.createFromResource(this, R.array.interval_array,
						R.layout.custom_spinner1);
		linked_interval_adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		linked_interval_spinner.setAdapter(linked_interval_adapter);
		ArrayAdapter<CharSequence> linked_amount_adapter = ArrayAdapter
				.createFromResource(this, R.array.amount_array,
						R.layout.custom_spinner1);
		linked_amount_adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		linked_amount_spinner.setAdapter(linked_amount_adapter);
		ArrayAdapter<CharSequence> linked_indexing_adapter = ArrayAdapter
				.createFromResource(this, R.array.indexing_array,
						R.layout.custom_spinner1);
		linked_indexing_adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		linked_indexing_spinner.setAdapter(linked_indexing_adapter);
		linked_interval_spinner.setSelection(0);
		linked_amount_spinner.setSelection(8);
		linked_indexing_spinner.setSelection(2);
		linked_info_container.setVisibility(View.GONE);

		// init type spinner
		type_spinner = (Spinner) findViewById(R.id.type_spinner);
		ArrayAdapter<CharSequence> type_adapter = ArrayAdapter
				.createFromResource(this, R.array.type_array,
						R.layout.custom_spinner2);
		// Specify the layout to use when the list of choices appears
		type_adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		type_spinner.setAdapter(type_adapter);
		type_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				tvDue = (TextView) findViewById(R.id.tv_due);
				switch (position) {
				case 0:
					tvDue.setText("Due: ");
					lab_ex = false;
					postlab_layout.setVisibility(View.GONE);
					break;
				case 1:
					if (!lab_ex) {

						postlab_spinner = (Spinner) findViewById(R.id.postlab_spinner);
						ArrayAdapter<CharSequence> postlab_adapter = ArrayAdapter
								.createFromResource(context,
										R.array.postlab_array,
										R.layout.custom_spinner1);
						postlab_adapter
								.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
						postlab_spinner.setAdapter(postlab_adapter);
						postlab_spinner.setSelection(0);
						tvDue.setText("Lab date:");
						lab_ex = true;
						postlab_layout.setVisibility(View.VISIBLE);

					}
					tvDue.setText("Lab date:");
					break;
				case 2:
					tvDue.setText("Date:");
					lab_ex = false;
					postlab_layout.setVisibility(View.GONE);
					break;
				case 3:
					tvDue.setText("Due: ");
					lab_ex = false;
					postlab_layout.setVisibility(View.GONE);
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
			}
		});

		// set subject spinner
		subject_spinner = (Spinner) findViewById(R.id.subject_spinner);
		final ArrayAdapter<String> subject_adapter = new ArrayAdapter<String>(
				this, R.layout.custom_spinner2, subjectArray);
		subject_adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		subject_spinner.setAdapter(subject_adapter);
		subject_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switch (position) {
				case 0:
					break;
				case 1:
					AlertDialog.Builder alertDialog = new AlertDialog.Builder(
							context);
					alertDialog.setTitle("Create a new subject");
					alertDialog.setMessage("Name the your subject");
					final EditText input = new EditText(context);
					LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
							LinearLayout.LayoutParams.MATCH_PARENT,
							LinearLayout.LayoutParams.WRAP_CONTENT);
					lp.setMargins(10, 0, 10, 0);
					input.setLayoutParams(lp);
					alertDialog.setView(input);
					alertDialog.setPositiveButton("Create",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									// Write your code here to execute after
									// dialog
									String subject = input.getText().toString();
									if (!(subjectArray.contains(subject))) {
										subjectArray.add(subject);
										int p = subject_adapter
												.getPosition(subject);
										subject_spinner.setSelection(p);
										subject_adapter.notifyDataSetChanged();
										Main.addSubject(subject);
										dialog.dismiss();
									} else {
										int p = subject_adapter
												.getPosition(subject);
										subject_spinner.setSelection(p);
										Toast.makeText(context,
												"Subject already exists",
												Toast.LENGTH_LONG).show();
										dialog.dismiss();
									}

								}
							});
					// Setting Negative Button
					alertDialog.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									// Write your code here to execute after
									// dialog
									dialog.cancel();
									subject_spinner.setSelection(0);
								}
							});
					alertDialog.show();
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
			}
		});

		// notes edittext
		notes = (EditText) findViewById(R.id.et_notes);

		Due_Year = Calendar.getInstance().get(Calendar.YEAR);
		Due_Month = Calendar.getInstance().get(Calendar.MONTH);
		Due_Day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		Due_Hour = 16;
		Due_Minute = 0;
		updateDate();
		updateTime(16, 0);

		// check reminder master switch
		if (!reminderEnable) {
			reminder_switch.setChecked(false);
			reminder_switch.setEnabled(false);
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
			alertDialog.setTitle("WARNING");
			alertDialog
					.setMessage("Reminder disabled, you will not be able to set reminder(s) for this task. "
							+ System.getProperty("line.separator")
							+ "To enable reminders, go to Settings -> Reminders.");
			alertDialog.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					});
			alertDialog.show();
		}

		// init default reminder
		if (reminder_switch.isChecked()) {
			add_reminder = (ImageButton) findViewById(R.id.add_new_reminder_button);
			add_reminder.setOnClickListener(this);
			default_reminder_layout.setVisibility(View.VISIBLE);
			default_reminder_spinner = (Spinner) findViewById(R.id.default_reminder_select_spinner);
			ArrayAdapter<CharSequence> default_reminder_adapter = ArrayAdapter
					.createFromResource(this, R.array.reminder_select_array,
							R.layout.custom_spinner1);
			default_reminder_adapter
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			default_reminder_spinner.setAdapter(default_reminder_adapter);
			default_reminder_spinner.setSelection(1);
		}
		theme.loadColorScheme(prefs);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.date_picker:
			setDate();
			break;
		case R.id.time_picker:
			setTime();
			break;
		case R.id.save_btn:
			// islinked?
			if (linked_switch.isChecked()) {
				new NewLinkedTaskThread().execute();

			} else {
				saveTask();
			}
			break;
		case R.id.cancel_btn:
			terminationCode = false;
			finish();
			break;
		case R.id.add_new_reminder_button:
			switch (reminder_count) {
			case 1:
				extra_reminder_0_layout.setVisibility(View.VISIBLE);

				remove_extra_reminder_0 = (ImageButton) findViewById(R.id.remove_extra_reminder_0_button);
				extra_reminder_spinner0 = (Spinner) findViewById(R.id.extra_reminder_select_spinner_0);
				remove_extra_reminder_0.setOnClickListener(this);
				ArrayAdapter<CharSequence> extra_reminder0_adapter = ArrayAdapter
						.createFromResource(this,
								R.array.reminder_select_array,
								R.layout.custom_spinner1);
				extra_reminder0_adapter
						.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				extra_reminder_spinner0.setAdapter(extra_reminder0_adapter);
				extra_reminder_spinner0.setSelection(2);
				reminder_count++;
				break;
			case 2:
				extra_reminder_1_layout.setVisibility(View.VISIBLE);

				remove_extra_reminder_1 = (ImageButton) findViewById(R.id.remove_extra_reminder_1_button);
				extra_reminder_spinner1 = (Spinner) findViewById(R.id.extra_reminder_select_spinner_1);
				remove_extra_reminder_1.setOnClickListener(this);
				ArrayAdapter<CharSequence> extra_reminder1_adapter = ArrayAdapter
						.createFromResource(this,
								R.array.reminder_select_array,
								R.layout.custom_spinner1);
				extra_reminder1_adapter
						.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				extra_reminder_spinner1.setAdapter(extra_reminder1_adapter);
				extra_reminder_spinner1.setSelection(3);
				reminder_count++;
				break;
			case 3:
				reminder_count = 3;
				break;
			}
			break;
		case R.id.remove_extra_reminder_0_button:
			extra_reminder_0_layout.setVisibility(View.GONE);
			reminder_count--;
			break;
		case R.id.remove_extra_reminder_1_button:
			extra_reminder_1_layout.setVisibility(View.GONE);
			reminder_count--;
			break;
		case R.id.reminder_switch:
			if (reminder_switch.isChecked()) {
				/*
				 * ObjectAnimator default_reminder_alpha_animation =
				 * ObjectAnimator.ofFloat(default_reminder_layout, View.ALPHA,
				 * 1); startAnimation(default_reminder_layout,
				 * default_reminder_alpha_animation,0);
				 */
				default_reminder_layout.setVisibility(View.VISIBLE);
				default_reminder_spinner = (Spinner) findViewById(R.id.default_reminder_select_spinner);
				ArrayAdapter<CharSequence> default_reminder_adapter = ArrayAdapter
						.createFromResource(this,
								R.array.reminder_select_array,
								R.layout.custom_spinner1);
				default_reminder_adapter
						.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				default_reminder_spinner.setAdapter(default_reminder_adapter);
				default_reminder_spinner.setSelection(1);
				reminder_count = 1;

			} else {
				switch (reminder_count) {
				case 1:
					default_reminder_layout.setVisibility(View.GONE);
					break;
				case 2:

					default_reminder_layout.setVisibility(View.GONE);
					extra_reminder_0_layout.setVisibility(View.GONE);
					break;
				case 3:

					default_reminder_layout.setVisibility(View.GONE);
					extra_reminder_0_layout.setVisibility(View.GONE);
					extra_reminder_1_layout.setVisibility(View.GONE);
					break;
				}
			}
			break;
		case R.id.islinked_switch:
			if (linked_switch.isChecked()) {
				linked_info_container.setVisibility(View.VISIBLE);
				this.setDueTextByType();
			} else {
				linked_info_container.setVisibility(View.GONE);
				this.setDueTextByType();
			}
			break;
		}
	}

	private void setDueTextByType() {
		// TODO Auto-generated method stub
		switch (type_spinner.getSelectedItemPosition()) {
		case 0:
			if (linked_switch.isChecked()) {
				tvDue.setText("First task due: ");
				lab_ex = false;
				postlab_layout.setVisibility(View.GONE);
			} else {
				tvDue.setText("Due: ");
				lab_ex = false;
				postlab_layout.setVisibility(View.GONE);
			}
			break;
		case 1:
			if (!lab_ex) {

				postlab_spinner = (Spinner) findViewById(R.id.postlab_spinner);
				ArrayAdapter<CharSequence> postlab_adapter = ArrayAdapter
						.createFromResource(context, R.array.postlab_array,
								R.layout.custom_spinner1);
				postlab_adapter
						.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				postlab_spinner.setAdapter(postlab_adapter);
				postlab_spinner.setSelection(0);
				tvDue.setText("Lab date:");
				lab_ex = true;
				postlab_layout.setVisibility(View.VISIBLE);

			}
			if (linked_switch.isChecked()) {
				tvDue.setText("First lab date: ");
			} else {
				tvDue.setText("Lab date:");
			}

			break;
		case 2:
			if (linked_switch.isChecked()) {
				tvDue.setText("First exam due: ");
				lab_ex = false;
				postlab_layout.setVisibility(View.GONE);
			} else {
				tvDue.setText("Date: ");
				lab_ex = false;
				postlab_layout.setVisibility(View.GONE);
			}
			break;
		case 3:
			if (linked_switch.isChecked()) {
				tvDue.setText("First task due: ");
				lab_ex = false;
				postlab_layout.setVisibility(View.GONE);
			} else {
				tvDue.setText("Due: ");
				lab_ex = false;
				postlab_layout.setVisibility(View.GONE);
			}
			break;
		}
	}

	public void updateDate() {
		date_btn.setText(format.format(calendar.getTime()));
	}

	public void setDate() {
		DatePickerDialog p = new DatePickerDialog(context, d,
				calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));
		p.show();
	}

	public void setTime() {
		new TimePickerDialog(context, t, time.get(Calendar.HOUR_OF_DAY),
				time.get(Calendar.MINUTE), false).show();
	}

	public void updateTime(int hours, int mins) {
		String timeSet = "";
		if (hours > 12) {
			hours -= 12;
			timeSet = "PM";
		} else if (hours == 0) {
			hours += 12;
			timeSet = "AM";
		} else if (hours == 12)
			timeSet = "PM";
		else
			timeSet = "AM";
		String minutes = "";
		if (mins < 10)
			minutes = "0" + mins;
		else
			minutes = String.valueOf(mins);
		// Append in a StringBuilder
		String aTime = new StringBuilder().append(hours).append(':')
				.append(minutes).append(" ").append(timeSet).toString();
		time_btn.setText(aTime);
	}

	DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			calendar.set(Calendar.YEAR, year);
			Due_Year = year;
			calendar.set(Calendar.MONTH, monthOfYear);
			Due_Month = monthOfYear;
			calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			Due_Day = dayOfMonth;
			updateDate();
		}
	};
	TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			// TODO Auto-generated method stub
			time.set(Calendar.HOUR_OF_DAY, hourOfDay);
			Due_Hour = hourOfDay;
			time.set(Calendar.MINUTE, minute);
			Due_Minute = minute;
			updateTime(time.get(Calendar.HOUR_OF_DAY),
					time.get(Calendar.MINUTE));
		}
	};

	@SuppressWarnings("unused")
	private void startAnimation(View v, final Animator animation,
			final int animation_resource_id) {
		animation.start();
	}

	@SuppressWarnings("deprecation")
	private void saveTask() {
		final ContentValues values = fetchInfo();
		if (this.isInfoValid) {
			if (Util.invalidDueDate(this, values)) {
				AlertDialog.Builder b = new AlertDialog.Builder(this);
				b.setTitle("Due date warning");
				b.setMessage("The due date picked has passed. Reminder(s) will not be activated. Do you still wish to save this task?");
				final AlertDialog d = b.create();
				d.setButton("Yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						d.dismiss();
						if (reminder_switch.isChecked()) {
							String[] r = Util.convertStringToArray(values
									.getAsString("reminders"));
							long id = Main.getDatabase().insertSingleTask(
									values.getAsString("name"),
									values.getAsString("type"),
									values.getAsString("subject"),
									values.getAsInteger("due_year"),
									values.getAsInteger("due_month"),
									values.getAsInteger("due_day"),
									values.getAsInteger("due_hour"),
									values.getAsInteger("due_min"), r,
									values.getAsString("notes"), 0);
							Main.setTaskChanged(true);
							Task t = new Task((int) id, values
									.getAsString("name"), values
									.getAsString("type"), values
									.getAsString("subject"), Util
									.generateDueCalendar(
											values.getAsInteger("due_year"),
											values.getAsInteger("due_month"),
											values.getAsInteger("due_day"),
											values.getAsInteger("due_hour"),
											values.getAsInteger("due_min")), r,
									values.getAsString("notes"), "Pending", 0,
									0, 0, "0", "0", false);
							Main.addAndSort(t);
							terminationCode = true;
							if (values.getAsString("type").contentEquals("Lab")) {
								generatePostLabTask(postlab_spinner
										.getSelectedItem().toString(), values);
							}
							finish();
						} else {
							String[] e = { NOREMINDER };
							long id = Main.getDatabase().insertSingleTask(
									values.getAsString("name"),
									values.getAsString("type"),
									values.getAsString("subject"),
									values.getAsInteger("due_year"),
									values.getAsInteger("due_month"),
									values.getAsInteger("due_day"),
									values.getAsInteger("due_hour"),
									values.getAsInteger("due_min"), e,
									values.getAsString("notes"), 0);
							Main.setTaskChanged(true);
							Task t = new Task((int) id, values
									.getAsString("name"), values
									.getAsString("type"), values
									.getAsString("subject"), Util
									.generateDueCalendar(
											values.getAsInteger("due_year"),
											values.getAsInteger("due_month"),
											values.getAsInteger("due_day"),
											values.getAsInteger("due_hour"),
											values.getAsInteger("due_min")), e,
									values.getAsString("notes"), "Pending", 0,
									0, 0, "0", "0", false);
							Main.addAndSort(t);
							terminationCode = true;
							if (values.getAsString("type").contentEquals("Lab")) {
								generatePostLabTask(postlab_spinner
										.getSelectedItem().toString(), values);
							}
							Main.updateAppWidget();
							finish();
						}
					}
				});
				d.setButton2("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						values.put("isValid", false);
						d.dismiss();
						terminationCode = false;
					}
				});
				d.show();
			} else {
				if (reminder_switch.isChecked()) {
					String[] r = Util.convertStringToArray(values
							.getAsString("reminders"));
					long id = Main.getDatabase().insertSingleTask(
							values.getAsString("name"),
							values.getAsString("type"),
							values.getAsString("subject"),
							values.getAsInteger("due_year"),
							values.getAsInteger("due_month"),
							values.getAsInteger("due_day"),
							values.getAsInteger("due_hour"),
							values.getAsInteger("due_min"), r,
							values.getAsString("notes"), 1);
					values.put("id", id);
					Main.getScheduleClient().setAlarmForNotification(values);
					Task t = new Task((int) id, values.getAsString("name"),
							values.getAsString("type"),
							values.getAsString("subject"),
							Util.generateDueCalendar(
									values.getAsInteger("due_year"),
									values.getAsInteger("due_month"),
									values.getAsInteger("due_day"),
									values.getAsInteger("due_hour"),
									values.getAsInteger("due_min")), r,
							values.getAsString("notes"), "Pending", 0, 0, 0,
							"0", "0", true);
					Main.setTaskChanged(true);
					Main.addAndSort(t);
					terminationCode = true;
					if (values.getAsString("type").contentEquals("Lab")) {
						generatePostLabTask(postlab_spinner.getSelectedItem()
								.toString(), values);
					}
					finish();
				} else {
					String[] e = { NOREMINDER };
					long id = Main.getDatabase().insertSingleTask(
							values.getAsString("name"),
							values.getAsString("type"),
							values.getAsString("subject"),
							values.getAsInteger("due_year"),
							values.getAsInteger("due_month"),
							values.getAsInteger("due_day"),
							values.getAsInteger("due_hour"),
							values.getAsInteger("due_min"), e,
							values.getAsString("notes"), 1);
					values.put("id", id);
					Main.getScheduleClient().setAlarmForNotification(values);
					Task t = new Task((int) id, values.getAsString("name"),
							values.getAsString("type"),
							values.getAsString("subject"),
							Util.generateDueCalendar(
									values.getAsInteger("due_year"),
									values.getAsInteger("due_month"),
									values.getAsInteger("due_day"),
									values.getAsInteger("due_hour"),
									values.getAsInteger("due_min")), e,
							values.getAsString("notes"), "Pending", 0, 0, 0,
							"0", "0", true);
					Main.setTaskChanged(true);
					Main.addAndSort(t);
					terminationCode = true;
					if (values.getAsString("type").contentEquals("Lab")) {
						generatePostLabTask(postlab_spinner.getSelectedItem()
								.toString(), values);
					}
					finish();
				}
			}
			Main.updateAppWidget();
		} else {
			Util.infoIncomplete("Name", this);
			name.setText("");
			name.requestFocus();
		}
	}

	public static ThemeManager getThemeManager() {
		return theme;
	}

	private boolean generatePostLabTask(String string, ContentValues values) {
		// TODO Auto-generated method stub
		ContentValues c = new ContentValues();
		String[] d = { NOREMINDER };
		if (!string.contentEquals("Not specified")) {
			c.put("name", values.getAsString("name") + " " + "postlab");
			c.put("type", "Homework");
			c.put("subject", values.getAsString("subject"));

			c.put("reminders", Util.convertArrayToString(d));
			c.put("notes", "");
			Calendar postlab_due = Calendar.getInstance();
			postlab_due = Util.generateDueCalendar(
					values.getAsInteger("due_year"),
					values.getAsInteger("due_month"),
					values.getAsInteger("due_day"),
					values.getAsInteger("due_hour"),
					values.getAsInteger("due_min"));
			if (string.contentEquals("1 day after the lab")) {
				postlab_due.add(Calendar.DAY_OF_MONTH, 1);
			} else if (string.contentEquals("2 days after the lab")) {
				postlab_due.add(Calendar.DAY_OF_MONTH, 2);
			} else if (string.contentEquals("3 days after the lab")) {
				postlab_due.add(Calendar.DAY_OF_MONTH, 3);
			} else if (string.contentEquals("1 week after the lab")) {
				postlab_due.add(Calendar.DAY_OF_MONTH, 7);
			} else if (string.contentEquals("2 weeks after the lab")) {
				postlab_due.add(Calendar.DAY_OF_MONTH, 14);
			} else if (string.contentEquals("3 weeks after the lab")) {
				postlab_due.add(Calendar.DAY_OF_MONTH, 21);
			} else {
				postlab_due.add(Calendar.DAY_OF_MONTH, 7);
			}
			c.put("due_year", postlab_due.get(Calendar.YEAR));
			c.put("due_month", postlab_due.get(Calendar.MONTH));
			c.put("due_day", postlab_due.get(Calendar.DAY_OF_MONTH));
			c.put("due_hour", postlab_due.get(Calendar.HOUR_OF_DAY));
			c.put("due_min", postlab_due.get(Calendar.MINUTE));

			long id = Main.getDatabase().insertSingleTask(
					c.getAsString("name"), c.getAsString("type"),
					c.getAsString("subject"), c.getAsInteger("due_year"),
					c.getAsInteger("due_month"), c.getAsInteger("due_day"),
					c.getAsInteger("due_hour"), c.getAsInteger("due_min"), d,
					c.getAsString("notes"), 0);
			Task t = new Task((int) id, c.getAsString("name"),
					c.getAsString("type"), c.getAsString("subject"),
					postlab_due, d, c.getAsString("notes"), "Pending", 0, 0, 0,
					"0", "0", false);
			Main.setTaskChanged(true);
			Main.addAndSort(t);
			return true;
		}
		return false;
	}

	private ContentValues fetchInfo() {
		ContentValues rv = new ContentValues();
		rv.put("isValid", true);
		if (!name.getText().toString().matches("")) {
			rv.put("name", name.getText().toString());
			this.isInfoValid = true;
		} else {
			this.isInfoValid = false;
			rv.put("isValid", false);
			return rv;
		}
		String type = type_spinner.getSelectedItem().toString();
		rv.put("type", type);
		String subject = subject_spinner.getSelectedItem().toString();
		rv.put("subject", subject);
		rv.put("due_year", Due_Year);
		rv.put("due_month", Due_Month);
		rv.put("due_day", Due_Day);
		rv.put("due_hour", Due_Hour);
		rv.put("due_min", Due_Minute);
		if (this.linked_switch.isChecked()) {
			rv.put("interval", Util.getInterval(linked_interval_spinner
					.getSelectedItemPosition()));
		} else {
			rv.put("interval", 0);
		}
		if (reminder_switch.isChecked()) {
			rv.put("reminders",
					Util.convertArrayToString(genReminderArray(reminder_count)));
		} else {
			rv.put("reminders",
					Util.convertArrayToString(new String[] { NOREMINDER }));
		}
		rv.put("notes", notes.getText().toString());
		return rv;
	}

	private String[] genReminderArray(int reminder_count) {
		switch (reminder_count) {
		case 1:
			String[] reminder_array = { default_reminder_spinner
					.getSelectedItem().toString() };
			return reminder_array;
		case 2:
			String[] reminder_array1 = {
					default_reminder_spinner.getSelectedItem().toString(),
					extra_reminder_spinner0.getSelectedItem().toString() };
			return reminder_array1;
		case 3:
			String[] reminder_array2 = {
					default_reminder_spinner.getSelectedItem().toString(),
					extra_reminder_spinner0.getSelectedItem().toString(),
					extra_reminder_spinner1.getSelectedItem().toString() };
			return reminder_array2;
		default:
			String[] empty = {};
			return empty;
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Main.updateListView(terminationCode);
	}

	class NewLinkedTaskThread extends AsyncTask<Void, Void, Void> {

		private ProgressDialog progress;
		CoreDatabase db;

		public NewLinkedTaskThread() {
		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			this.saveLinkedTask();
			return null;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			db = new CoreDatabase(context);
			progress = new ProgressDialog(context);
			progress.setIndeterminate(false);
			progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progress.setCancelable(false);
			progress.setTitle(context.getResources().getString(
					R.string.dialog_linked_save_title));
			progress.setMessage(context.getResources().getString(
					R.string.dialog_linked_save_msg));
			progress.show();
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			progress.cancel();
			Main.updateListView(true);
			/*
			for (Task t : Main.getTaskHolder()) {
				Toast.makeText(
						context,
						t.getName() + "/" + t.getId() + "/"
								+ t.getPreviousTag() + "/" + t.getNextTag(),
						Toast.LENGTH_LONG).show();
			}
			*/
			finish();
		}

		private synchronized void saveLinkedTask() {
			int interval = Util.getInterval(linked_interval_spinner
					.getSelectedItemPosition());
			int autoindex = linked_indexing_spinner.getSelectedItemPosition();
			int amount = Integer.valueOf(linked_amount_spinner
					.getSelectedItem().toString());
			int index = 0;
			String previous_tag = "PREV";
			ContentValues values = fetchInfo();
			if (!isInfoValid) {
				Util.infoIncomplete("Name", context);
				name.setText("");
				name.requestFocus();
				return;
			}
			Calendar firstDue = Calendar.getInstance();
			firstDue.set(Calendar.YEAR, values.getAsInteger("due_year"));
			firstDue.set(Calendar.MONTH, values.getAsInteger("due_month"));
			firstDue.set(Calendar.DAY_OF_MONTH, values.getAsInteger("due_day"));
			firstDue.set(Calendar.HOUR_OF_DAY, values.getAsInteger("due_hour"));
			firstDue.set(Calendar.MINUTE, values.getAsInteger("due_min"));
			String name = values.getAsString("name");
			for (index = 0; index < amount; index++) {
				// take care of names
				if (autoindex == 2) {
					int a = index + 1;
					String new_name = new String(name);
					new_name += " " + a;
					values.put("name", new_name);
				} else if (autoindex == 1) {
					String another_name = new String(name);
					another_name += " " + index;
					values.put("name", another_name);
				}
				// take care of due dates
				Util.setDueDate(values, index, interval, firstDue, "due_year",
						"due_month", "due_day", "due_hour", "due_min");

				// take care of tags
				if (index == 0) {
					values.put("prev_tag", startOfLinked);
				} else {
					values.put("prev_tag", previous_tag);
				}

				if (index == amount - 1) {
					values.put("next_tag", endOfLinked);
				} else {
					values.put("next_tag", placeHolder);
				}
				// add
				if (reminder_switch.isChecked()
						&& !Util.invalidDueDate(context, values)) {
					// have reminders
					long id = db.insertRepeatingTask(
							values.getAsString("name"), values
									.getAsString("type"), values
									.getAsString("subject"), values
									.getAsInteger("due_year"), values
									.getAsInteger("due_month"), values
									.getAsInteger("due_day"), values
									.getAsInteger("due_hour"), values
									.getAsInteger("due_min"), Util
									.convertStringToArray(values
											.getAsString("reminders")), values
									.getAsString("notes"), 1, index, values
									.getAsInteger("interval"), values
									.getAsString("prev_tag"), values
									.getAsString("next_tag"));
					values.put("id", id);
					if (index != amount - 1) {
						if (values.getAsString("type").contentEquals("Lab")
								&& generatePostLabTask(postlab_spinner
										.getSelectedItem().toString(), values)) {
							db.updateNextTag(id, id + 2);
							values.put("next_tag", String.valueOf(id + 2));
						} else {
							db.updateNextTag(id, id + 1);
							values.put("next_tag", String.valueOf(id + 1));
						}
					}
					Main.getScheduleClient().setAlarmForNotification(values);
					Task t = new Task((int) id, values.getAsString("name"),
							values.getAsString("type"),
							values.getAsString("subject"),
							Util.generateDueCalendar(
									values.getAsInteger("due_year"),
									values.getAsInteger("due_month"),
									values.getAsInteger("due_day"),
									values.getAsInteger("due_hour"),
									values.getAsInteger("due_min")),
							Util.convertStringToArray(values
									.getAsString("reminders")),
							values.getAsString("notes"), "Pending", 1, index,
							values.getAsInteger("interval"),
							values.getAsString("prev_tag"),
							values.getAsString("next_tag"), true);
					Main.setTaskChanged(true);
					Main.addAndSort(t);
					terminationCode = true;
					previous_tag = String.valueOf(id);

				} else {
					// no reminders
					long id = db.insertRepeatingTask(
							values.getAsString("name"), values
									.getAsString("type"), values
									.getAsString("subject"), values
									.getAsInteger("due_year"), values
									.getAsInteger("due_month"), values
									.getAsInteger("due_day"), values
									.getAsInteger("due_hour"), values
									.getAsInteger("due_min"), Util
									.convertStringToArray(values
											.getAsString("reminders")), values
									.getAsString("notes"), 0, index, values
									.getAsInteger("interval"), values
									.getAsString("prev_tag"), values
									.getAsString("next_tag"));
					if (index != amount - 1) {
						if (values.getAsString("type").contentEquals("Lab")
								&& generatePostLabTask(postlab_spinner
										.getSelectedItem().toString(), values)) {
							db.updateNextTag(id, id + 2);
							values.put("next_tag", String.valueOf(id + 2));
						} else {
							db.updateNextTag(id, id + 1);
							values.put("next_tag", String.valueOf(id + 1));
						}
					}
					Task t = new Task((int) id, values.getAsString("name"),
							values.getAsString("type"),
							values.getAsString("subject"),
							Util.generateDueCalendar(
									values.getAsInteger("due_year"),
									values.getAsInteger("due_month"),
									values.getAsInteger("due_day"),
									values.getAsInteger("due_hour"),
									values.getAsInteger("due_min")),
							Util.convertStringToArray(values
									.getAsString("reminders")),
							values.getAsString("notes"), "Pending", 1, index,
							values.getAsInteger("interval"),
							values.getAsString("prev_tag"),
							values.getAsString("next_tag"), false);
					Main.setTaskChanged(true);
					Main.addAndSort(t);
					terminationCode = true;
					previous_tag = String.valueOf(id);
				}
			}
			Main.updateAppWidget();
		}
	}
}
