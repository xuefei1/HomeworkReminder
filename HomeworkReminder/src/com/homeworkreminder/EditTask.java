package com.homeworkreminder;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.homeworkreminder.Theme.ColorScheme;
import com.homeworkreminder.Theme.ThemeManager;

import android.animation.Animator;
import android.annotation.SuppressLint;
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
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.AsyncTask;
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
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class EditTask extends Activity implements OnClickListener {

	public ArrayList<String> subjectArray = new ArrayList<String>();

	SharedPreferences sp;
	Button date_btn;
	Button time_btn;
	ImageButton add_reminder;
	ImageButton remove_extra_reminder_0;
	ImageButton remove_extra_reminder_1;
	Button save_btn;
	Button cancel_btn;
	Button enable_edit_btn;
	Button delete_btn;
	Button ok_btn;
	Spinner type_spinner;
	Spinner subject_spinner;
	Spinner default_reminder_spinner;
	Spinner extra_reminder_spinner0;
	Spinner extra_reminder_spinner1;
	Spinner postlab_spinner;
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

	private int id = 0;
	private Task thisTask;
	boolean lab_ex = false;
	boolean reminderEnable;
	static int reminder_count = 1;
	final String DEFAULT_SUBJECT = "Default subject";
	final String ADD_SUBJECT = "Create new";
	final String NOREMINDER = "NOREMINDER";
	private final static String startOfLinked = "START";
	private final static String endOfLinked = "END";
	private static int Due_Year = Calendar.getInstance().get(Calendar.YEAR);
	private static int Due_Month = Calendar.getInstance().get(Calendar.MONTH);
	private static int Due_Day = Calendar.getInstance().get(
			Calendar.DAY_OF_MONTH);
	private static int Due_Hour = 16;
	private static int Due_Minute = 0;
	boolean terminationCode = false;
	static CoreDatabase Database;
	public static boolean isViewModeActive = true;
	public static boolean isEditModeActive = false;
	public static boolean isCompleted = false;
	String[] reminders;
	private static ThemeManager theme;
	private SharedPreferences prefs;
	ActionBar actionBar;
	private LinearLayout actionBarSaveLayout;
	private LinearLayout actionBarViewLayout;
	private LinearLayout actionBarViewOnlyLayout;
	View customActionBarView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		terminationCode = false;
		lab_ex = false;
		reminder_count = 1;
		isViewModeActive = true;
		isEditModeActive = false;
		isCompleted = false;
		Bundle extras = getIntent().getBundleExtra("info");
		if (extras != null) {
			id = extras.getInt("id");
		}
		context = this;
		Database = new CoreDatabase(context);
		subjectArray = Database.querySubjectList();
		subjectArray.add(0, DEFAULT_SUBJECT);
		subjectArray.add(1, ADD_SUBJECT);
		thisTask = Database.queryById(id);

		if (thisTask.getStatus().contentEquals("Completed")) {
			isCompleted = true;
			LayoutInflater inflater = (LayoutInflater) getActionBar()
					.getThemedContext().getSystemService(
							LAYOUT_INFLATER_SERVICE);
			customActionBarView = inflater.inflate(
					R.layout.actionbar_viewonly_custom, null);
			actionBar = getActionBar();
			actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM,
					ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME
							| ActionBar.DISPLAY_SHOW_TITLE);
			actionBar.setCustomView(customActionBarView,
					new ActionBar.LayoutParams(
							ViewGroup.LayoutParams.MATCH_PARENT,
							ViewGroup.LayoutParams.MATCH_PARENT));
			ok_btn = (Button) findViewById(R.id.ok_btn);
			delete_btn = (Button) findViewById(R.id.delete_btn);
			ok_btn.setOnClickListener(this);
			delete_btn.setOnClickListener(this);
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
			alertDialog.setTitle("WARNING");
			alertDialog
					.setMessage("You will not be able to edit completed task(s)");
			alertDialog.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					});
			alertDialog.show();

		} else {
			isCompleted = false;
			// inflate custom action bar
			LayoutInflater inflater = (LayoutInflater) getActionBar()
					.getThemedContext().getSystemService(
							LAYOUT_INFLATER_SERVICE);
			customActionBarView = inflater.inflate(
					R.layout.actionbar_view_custom, null);
			actionBar = getActionBar();
			actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM,
					ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME
							| ActionBar.DISPLAY_SHOW_TITLE);
			actionBar.setCustomView(customActionBarView,
					new ActionBar.LayoutParams(
							ViewGroup.LayoutParams.MATCH_PARENT,
							ViewGroup.LayoutParams.MATCH_PARENT));
			enable_edit_btn = (Button) findViewById(R.id.edit_enable_btn);
			ok_btn = (Button) findViewById(R.id.ok_btn);
			delete_btn = (Button) findViewById(R.id.delete_btn);
			ok_btn.setOnClickListener(this);
			delete_btn.setOnClickListener(this);
			enable_edit_btn.setOnClickListener(this);
		}

		setContentView(R.layout.add_new);
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		if (isViewModeActive && isCompleted) {
			actionBarViewOnlyLayout = (LinearLayout) findViewById(R.id.add_action_bar_viewonly_custom);
		} else if (isViewModeActive && !isCompleted) {
			actionBarViewLayout = (LinearLayout) findViewById(R.id.add_action_bar_view_custom);
		} else {
			actionBarSaveLayout = (LinearLayout) findViewById(R.id.add_action_bar_custom);
		}
		theme = new ThemeManager(context) {

			@SuppressLint("NewApi")
			@SuppressWarnings("deprecation")
			@Override
			public void setColor(ColorScheme scheme) {
				// TODO Auto-generated method stub
				if (isViewModeActive && isCompleted) {
					StateListDrawable ok_btn_selector_viewonly = new StateListDrawable();
					ok_btn_selector_viewonly.addState(
							new int[] { android.R.attr.state_pressed },
							new ColorDrawable(scheme.getDarkerColor()));
					ok_btn_selector_viewonly.addState(StateSet.WILD_CARD,
							new ColorDrawable(scheme.getSuperDarkColor()));
					StateListDrawable delete_btn_selector_viewonly = new StateListDrawable();
					delete_btn_selector_viewonly.addState(
							new int[] { android.R.attr.state_pressed },
							new ColorDrawable(scheme.getDarkerColor()));
					delete_btn_selector_viewonly.addState(StateSet.WILD_CARD,
							new ColorDrawable(scheme.getSuperDarkColor()));
					actionBarViewOnlyLayout.setBackgroundColor(scheme
							.getSuperDarkColor());
					actionBarViewOnlyLayout
							.getChildAt(0)
							.setBackgroundDrawable(delete_btn_selector_viewonly);
					actionBarViewOnlyLayout.getChildAt(1)
							.setBackgroundDrawable(ok_btn_selector_viewonly);
				} else if (isViewModeActive && !isCompleted) {
					StateListDrawable ok_btn_selector = new StateListDrawable();
					ok_btn_selector.addState(
							new int[] { android.R.attr.state_pressed },
							new ColorDrawable(scheme.getDarkerColor()));
					ok_btn_selector.addState(StateSet.WILD_CARD,
							new ColorDrawable(scheme.getSuperDarkColor()));
					StateListDrawable delete_btn_selector = new StateListDrawable();
					delete_btn_selector.addState(
							new int[] { android.R.attr.state_pressed },
							new ColorDrawable(scheme.getDarkerColor()));
					delete_btn_selector.addState(StateSet.WILD_CARD,
							new ColorDrawable(scheme.getSuperDarkColor()));
					StateListDrawable edit_btn_selector = new StateListDrawable();
					edit_btn_selector.addState(
							new int[] { android.R.attr.state_pressed },
							new ColorDrawable(scheme.getDarkerColor()));
					edit_btn_selector.addState(StateSet.WILD_CARD,
							new ColorDrawable(scheme.getSuperDarkColor()));
					actionBarViewLayout.setBackgroundColor(scheme
							.getUltraDarkColor());
					actionBarViewLayout.getChildAt(0).setBackgroundDrawable(
							delete_btn_selector);
					actionBarViewLayout.getChildAt(1).setBackgroundDrawable(
							edit_btn_selector);
					actionBarViewLayout.getChildAt(2).setBackgroundDrawable(
							ok_btn_selector);
				} else {
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
					actionBarSaveLayout.setBackgroundColor(scheme
							.getSuperDarkColor());
					actionBarSaveLayout.getChildAt(0).setBackgroundDrawable(
							cancel_btn_selector);
					actionBarSaveLayout.getChildAt(1).setBackgroundDrawable(
							save_btn_selector);
				}
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

		default_reminder_layout = (LinearLayout) findViewById(R.id.default_reminder_container);
		extra_reminder_0_layout = (LinearLayout) findViewById(R.id.extra_reminder_container_0);
		extra_reminder_1_layout = (LinearLayout) findViewById(R.id.extra_reminder_container_1);

		postlab_layout = (LinearLayout) findViewById(R.id.postlab_container);

		// can not access linked function in editing page
		linked_info_container = (LinearLayout) findViewById(R.id.linked_info_container);
		linked_switch = (Switch) findViewById(R.id.islinked_switch);
		linked_switch.setVisibility(View.GONE);
		linked_info_container.setVisibility(View.GONE);

		date_btn = (Button) findViewById(R.id.date_picker);
		time_btn = (Button) findViewById(R.id.time_picker);
		date_btn.setOnClickListener(this);
		time_btn.setOnClickListener(this);

		name = (EditText) findViewById(R.id.et_name);
		notes = (EditText) findViewById(R.id.et_notes);

		reminder_switch = (Switch) findViewById(R.id.reminder_switch);
		reminder_switch.setChecked(true);
		reminder_switch.setOnClickListener(this);

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
						postlab_layout.setVisibility(View.GONE);
					}
					tvDue.setText("Lab date:");
					break;
				case 2:
					// postlab_layout.removeView(child);
					tvDue.setText("Date:");
					lab_ex = false;
					postlab_layout.setVisibility(View.GONE);
					break;
				case 3:
					// postlab_layout.removeView(child);
					tvDue.setText("Due: ");
					lab_ex = false;
					postlab_layout.setVisibility(View.GONE);
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
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
		updateDate();
		updateTime(16, 0);

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
		Resources f = getResources();
		this.reminders = f.getStringArray(R.array.reminder_select_array);
		setDefaultViewMode();
		theme.loadColorScheme(prefs);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.delete_btn:
			Main.deleteSelection(thisTask);
			finish();
			break;
		case R.id.ok_btn:
			finish();
			break;
		case R.id.edit_enable_btn:
			this.enableEditMode();
			break;
		case R.id.date_picker:
			setDate();
			break;
		case R.id.time_picker:
			setTime();
			break;
		case R.id.save_btn:
			ContentValues new_values = fetchInfo();
			if (thisTask.isLinked() && this.checkLinkedChanges(new_values)) {
				showLinkedChangeDialog(new_values);
			}else if(thisTask.isLinked()){
				this.updateSingleLinkedTask(new_values);
			}
			else {
				saveSingleTask(new_values);
			}
			break;
		case R.id.cancel_btn:
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
			alertDialog.setTitle("WARNING");
			alertDialog
					.setMessage("All unsaved changes will be discarded, proceed?");
			alertDialog.setPositiveButton("Yes",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							terminationCode = false;
							dialog.dismiss();
							finish();
						}
					});
			alertDialog.setNegativeButton("No",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					});
			alertDialog.show();
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
		}
	}

	private boolean checkLinkedChanges(ContentValues newValueToCompare) {
		// TODO Auto-generated method stub
		String old_type = thisTask.getType();
		String old_subject = thisTask.getSubject();
		String old_reminders = Util.convertArrayToString(thisTask
				.getReminders());
		Calendar old_due = Calendar.getInstance();
		old_due.setTime(thisTask.getDue().getTime());
		old_due.set(Calendar.SECOND, 0);
		old_due.set(Calendar.MILLISECOND, 0);
		// new_values
		String new_type = newValueToCompare.getAsString("type");
		String new_subject = newValueToCompare.getAsString("subject");
		Calendar new_due = Calendar.getInstance();
		new_due.set(newValueToCompare.getAsInteger("due_year"),
				newValueToCompare.getAsInteger("due_month"),
				newValueToCompare.getAsInteger("due_day"),
				newValueToCompare.getAsInteger("due_hour"),
				newValueToCompare.getAsInteger("due_min"), 0);
		new_due.set(Calendar.MILLISECOND, 0);
		String new_reminders;
		if (reminder_switch.isChecked()) {
			new_reminders = Util
					.convertArrayToString(genReminderArray(reminder_count));
		} else {
			new_reminders = Util
					.convertArrayToString(new String[] { NOREMINDER });
		}

		// start comparing
		if (!old_type.contentEquals(new_type)) {
			return true;
		} else if (!old_subject.contentEquals(new_subject)) {
			return true;
		} else if (!old_reminders.contentEquals(new_reminders)) {
			return true;
		} else if (old_due.compareTo(new_due) != 0) {
			return true;
		}
		return false;
	}

	private void showLinkedChangeDialog(final ContentValues new_value) {
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
		alertDialog.setTitle(getResources().getString(
				R.string.dialog_LinkedChange_title));
		alertDialog.setMessage(getResources().getString(
				R.string.dialog_LinkedChange_ContentChange));
		alertDialog.setPositiveButton(
				getResources().getString(R.string.text_yes),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						new LinkedUpdateThread().execute(new_value);
					}

				});
		// Setting Negative Button
		alertDialog.setNegativeButton(getResources()
				.getString(R.string.text_no),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						updateSingleLinkedTask(new_value);
						finish();
					}
				});
		alertDialog.show();
	}

	@SuppressWarnings("deprecation")
	private void updateSingleLinkedTask(final ContentValues values) {
		if (values.getAsBoolean("isValid")) {
			if (Util.invalidDueDate(this, values)) {
				Main.deleteById(thisTask.getId(), 0);
				updateLinkedTaskInDB(
						0,
						values,
						Util.generateDueCalendar(
								values.getAsInteger("due_year"),
								values.getAsInteger("due_month"),
								values.getAsInteger("due_day"),
								values.getAsInteger("due_hour"),
								values.getAsInteger("due_min")));
				Main.setTaskChanged(true);
				Task t = Database.queryById(thisTask.getId());
				Main.addAndSort(t);
				terminationCode = true;
				finish();
			} else {
				Main.deleteById(thisTask.getId(), 0);
				values.put("id", thisTask.getId());
				if (reminder_switch.isChecked()) {
					updateLinkedTaskInDB(
							1,
							values,
							Util.generateDueCalendar(
									values.getAsInteger("due_year"),
									values.getAsInteger("due_month"),
									values.getAsInteger("due_day"),
									values.getAsInteger("due_hour"),
									values.getAsInteger("due_min")));
					Main.getScheduleClient().setAlarmForNotification(values);
				} else {
					updateLinkedTaskInDB(
							0,
							values,
							Util.generateDueCalendar(
									values.getAsInteger("due_year"),
									values.getAsInteger("due_month"),
									values.getAsInteger("due_day"),
									values.getAsInteger("due_hour"),
									values.getAsInteger("due_min")));
				}
				Task t = Database.queryById(thisTask.getId());
				;
				Main.setTaskChanged(true);
				Main.addAndSort(t);
				terminationCode = true;
				finish();
			}

		} else {
			Util.infoIncomplete("Name", this);
			name.setText("");
			name.requestFocus();
		}
	}

	private void updateFirstLinkedTask(final ContentValues values) {
		if (values.getAsBoolean("isValid")) {
			if (Util.invalidDueDate(this, values)) {
				Main.deleteById(thisTask.getId(), 0);
				updateLinkedTaskInDB(
						0,
						values,
						Util.generateDueCalendar(
								values.getAsInteger("due_year"),
								values.getAsInteger("due_month"),
								values.getAsInteger("due_day"),
								values.getAsInteger("due_hour"),
								values.getAsInteger("due_min")));
				Main.setTaskChanged(true);
				Task t = Database.queryById(thisTask.getId());
				Main.addAndSort(t);
				terminationCode = true;
			} else {
				Main.deleteById(thisTask.getId(), 0);
				values.put("id", thisTask.getId());
				if (reminder_switch.isChecked()) {
					updateLinkedTaskInDB(
							1,
							values,
							Util.generateDueCalendar(
									values.getAsInteger("due_year"),
									values.getAsInteger("due_month"),
									values.getAsInteger("due_day"),
									values.getAsInteger("due_hour"),
									values.getAsInteger("due_min")));
					Main.getScheduleClient().setAlarmForNotification(values);
				} else {
					updateLinkedTaskInDB(
							0,
							values,
							Util.generateDueCalendar(
									values.getAsInteger("due_year"),
									values.getAsInteger("due_month"),
									values.getAsInteger("due_day"),
									values.getAsInteger("due_hour"),
									values.getAsInteger("due_min")));
				}
				Task t = Database.queryById(thisTask.getId());
				Main.setTaskChanged(true);
				Main.addAndSort(t);
				Main.updateAppWidget();
				terminationCode = true;
			}
		} else {
			Util.infoIncomplete("Name", this);
			name.setText("");
			name.requestFocus();
		}
	}

	private void updateAllLinkedTask(ContentValues values) {
		int interval = thisTask.getInterval();
		this.updateFirstLinkedTask(values);
		Task t = Database.queryById(thisTask.getId());
		Calendar first_due = Calendar.getInstance();
		first_due.setTime(t.getDue().getTime());
		int index = 1;
		while (!t.getNextTag().contentEquals(endOfLinked)) {
			t = Database.queryById(Integer.parseInt(t.getNextTag()));
			Main.deleteById(t.getId(), Util.isCompleted(t.getStatus()));
			Calendar new_due_date = Util.setDueDate(values, index, interval,
					first_due, "due_year", "due_month", "due_day", "due_hour",
					"due_min");
			if (reminder_switch.isChecked()
					&& !Util.invalidDueDate(new_due_date) && t.isPending()) {
				Database.updateRepeatingTask(t.getId(), t.getName(), values
						.getAsString("type"), values.getAsString("subject"), t
						.getStatus(), new_due_date.get(Calendar.YEAR),
						new_due_date.get(Calendar.MONTH), new_due_date
								.get(Calendar.DAY_OF_MONTH), new_due_date
								.get(Calendar.HOUR_OF_DAY), new_due_date
								.get(Calendar.MINUTE), Util
								.convertStringToArray(values
										.getAsString("reminders")), t
								.getNotes(), 1, t.getIndex(), t.getInterval(),
						t.getPreviousTag(), t.getNextTag());
			} else {
				Database.updateRepeatingTask(t.getId(), t.getName(), values
						.getAsString("type"), values.getAsString("subject"), t
						.getStatus(), new_due_date.get(Calendar.YEAR),
						new_due_date.get(Calendar.MONTH), new_due_date
								.get(Calendar.DAY_OF_MONTH), new_due_date
								.get(Calendar.HOUR_OF_DAY), new_due_date
								.get(Calendar.MINUTE), Util
								.convertStringToArray(values
										.getAsString("reminders")), t
								.getNotes(), 0, t.getIndex(), t.getInterval(),
						t.getPreviousTag(), t.getNextTag());
			}
			t = Database.queryById(t.getId());
			if (reminder_switch.isChecked()
					&& !Util.invalidDueDate(new_due_date) && t.isPending()) {
				Main.getScheduleClient().setAlarmForNotification(
						t.getContentValues());
			}
			this.updateTaskInMain(t);
			index++;
		}
		Main.updateAppWidget();
	}

	private void updateLinkedTaskInDB(int isAlarmActive,
			ContentValues new_value, Calendar new_due) {
		Database.updateRepeatingTask(thisTask.getId(),
				new_value.getAsString("name"), new_value.getAsString("type"),
				new_value.getAsString("subject"), thisTask.getStatus(),
				new_due.get(Calendar.YEAR), new_due.get(Calendar.MONTH),
				new_due.get(Calendar.DAY_OF_MONTH),
				new_due.get(Calendar.HOUR_OF_DAY),
				new_due.get(Calendar.MINUTE),
				Util.convertStringToArray(new_value.getAsString("reminders")),
				new_value.getAsString("notes"), isAlarmActive,
				thisTask.getIndex(), thisTask.getInterval(),
				thisTask.getPreviousTag(), thisTask.getNextTag());
	}

	private void updateTaskInMain(Task t) {
		Main.setTaskChanged(true);
		Main.addAndSort(t);
		terminationCode = true;
	}

	protected void setDefaultViewMode() {
		isViewModeActive = true;
		isEditModeActive = false;

		name.setText(thisTask.getName());
		name.setEnabled(false);
		notes.setHint("");
		notes.setText(thisTask.getNotes());
		notes.setEnabled(false);

		type_spinner.setSelection(Util.getTypePosition(thisTask.getType()));
		type_spinner.setEnabled(false);

		subject_spinner.setSelection(Util.getSubjectPosition(
				thisTask.getSubject(), subjectArray));
		subject_spinner.setEnabled(false);

		Due_Year = thisTask.getDue().get(Calendar.YEAR);
		Due_Month = thisTask.getDue().get(Calendar.MONTH);
		Due_Day = thisTask.getDue().get(Calendar.DAY_OF_MONTH);

		Due_Hour = thisTask.getDue().get(Calendar.HOUR_OF_DAY);
		Due_Minute = thisTask.getDue().get(Calendar.MINUTE);

		calendar.set(Calendar.YEAR, Due_Year);
		calendar.set(Calendar.MONTH, Due_Month);
		calendar.set(Calendar.DAY_OF_MONTH, Due_Day);
		updateDate();

		time.set(Calendar.HOUR_OF_DAY, Due_Hour);
		time.set(Calendar.MINUTE, Due_Minute);
		updateTime(time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE));

		date_btn.setEnabled(false);
		time_btn.setEnabled(false);

		if (!thisTask.getReminders()[0].contentEquals(NOREMINDER)) {
			reminder_count = thisTask.getReminders().length;
			reminder_switch.setChecked(true);
			reminder_switch.setEnabled(false);
			ArrayAdapter<CharSequence> default_reminder_adapter;
			ArrayAdapter<CharSequence> extra_reminder0_adapter;
			ArrayAdapter<CharSequence> extra_reminder1_adapter;
			switch (thisTask.getReminders().length) {
			case 1:
				add_reminder = (ImageButton) findViewById(R.id.add_new_reminder_button);
				add_reminder.setOnClickListener(this);
				default_reminder_layout.setVisibility(View.VISIBLE);
				default_reminder_spinner = (Spinner) findViewById(R.id.default_reminder_select_spinner);
				default_reminder_adapter = ArrayAdapter.createFromResource(
						this, R.array.reminder_select_array,
						R.layout.custom_spinner1);
				default_reminder_adapter
						.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				default_reminder_spinner.setAdapter(default_reminder_adapter);
				default_reminder_spinner.setSelection(Util.getReminderPosition(
						thisTask.getReminders()[0], this.reminders));
				add_reminder.setEnabled(false);
				default_reminder_spinner.setEnabled(false);
				break;
			case 2:
				default_reminder_layout.setVisibility(View.VISIBLE);
				default_reminder_spinner = (Spinner) findViewById(R.id.default_reminder_select_spinner);
				default_reminder_adapter = ArrayAdapter.createFromResource(
						this, R.array.reminder_select_array,
						R.layout.custom_spinner1);
				default_reminder_adapter
						.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				default_reminder_spinner.setAdapter(default_reminder_adapter);
				default_reminder_spinner.setSelection(Util.getReminderPosition(
						thisTask.getReminders()[0], reminders));

				extra_reminder_0_layout.setVisibility(View.VISIBLE);
				remove_extra_reminder_0 = (ImageButton) findViewById(R.id.remove_extra_reminder_0_button);
				extra_reminder_spinner0 = (Spinner) findViewById(R.id.extra_reminder_select_spinner_0);
				remove_extra_reminder_0.setOnClickListener(this);
				extra_reminder0_adapter = ArrayAdapter
						.createFromResource(this,
								R.array.reminder_select_array,
								R.layout.custom_spinner1);
				extra_reminder0_adapter
						.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				extra_reminder_spinner0.setAdapter(extra_reminder0_adapter);
				extra_reminder_spinner0.setSelection(Util.getReminderPosition(
						thisTask.getReminders()[1], reminders));
				add_reminder.setEnabled(false);
				default_reminder_spinner.setEnabled(false);
				remove_extra_reminder_0.setEnabled(false);
				extra_reminder_spinner0.setEnabled(false);
				break;
			case 3:
				default_reminder_layout.setVisibility(View.VISIBLE);
				default_reminder_spinner = (Spinner) findViewById(R.id.default_reminder_select_spinner);
				default_reminder_adapter = ArrayAdapter.createFromResource(
						this, R.array.reminder_select_array,
						R.layout.custom_spinner1);
				default_reminder_adapter
						.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				default_reminder_spinner.setAdapter(default_reminder_adapter);
				default_reminder_spinner.setSelection(Util.getReminderPosition(
						thisTask.getReminders()[0], reminders));

				extra_reminder_0_layout.setVisibility(View.VISIBLE);
				remove_extra_reminder_0 = (ImageButton) findViewById(R.id.remove_extra_reminder_0_button);
				extra_reminder_spinner0 = (Spinner) findViewById(R.id.extra_reminder_select_spinner_0);
				remove_extra_reminder_0.setOnClickListener(this);
				extra_reminder0_adapter = ArrayAdapter
						.createFromResource(this,
								R.array.reminder_select_array,
								R.layout.custom_spinner1);
				extra_reminder0_adapter
						.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				extra_reminder_spinner0.setAdapter(extra_reminder0_adapter);
				extra_reminder_spinner0.setSelection(Util.getReminderPosition(
						thisTask.getReminders()[1], reminders));
				extra_reminder_1_layout.setVisibility(View.VISIBLE);

				remove_extra_reminder_1 = (ImageButton) findViewById(R.id.remove_extra_reminder_1_button);
				extra_reminder_spinner1 = (Spinner) findViewById(R.id.extra_reminder_select_spinner_1);
				remove_extra_reminder_1.setOnClickListener(this);
				extra_reminder1_adapter = ArrayAdapter
						.createFromResource(this,
								R.array.reminder_select_array,
								R.layout.custom_spinner1);
				extra_reminder1_adapter
						.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				extra_reminder_spinner1.setAdapter(extra_reminder1_adapter);
				extra_reminder_spinner1.setSelection(Util.getReminderPosition(
						thisTask.getReminders()[2], reminders));
				add_reminder.setEnabled(false);
				default_reminder_spinner.setEnabled(false);
				remove_extra_reminder_0.setEnabled(false);
				extra_reminder_spinner0.setEnabled(false);
				remove_extra_reminder_1.setEnabled(false);
				extra_reminder_spinner1.setEnabled(false);
				break;
			}
		} else {
			reminder_switch.setChecked(false);
			reminder_switch.setEnabled(false);
			default_reminder_layout.setVisibility(View.GONE);
			if (!thisTask.getReminders()[0].contentEquals("NOREMINDER")) {

			}

		}

	}

	protected void enableEditMode() {
		isViewModeActive = false;
		isEditModeActive = true;
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
		actionBarSaveLayout = (LinearLayout) findViewById(R.id.add_action_bar_custom);
		theme.loadColorScheme(prefs);
		// actionbar buttons
		save_btn = (Button) findViewById(R.id.save_btn);
		cancel_btn = (Button) findViewById(R.id.cancel_btn);
		save_btn.setOnClickListener(this);
		cancel_btn.setOnClickListener(this);
		name.setEnabled(true);
		notes.setEnabled(true);
		notes.setHint("Optional");
		type_spinner.setEnabled(true);
		subject_spinner.setEnabled(true);
		date_btn.setEnabled(true);
		time_btn.setEnabled(true);
		reminder_switch.setEnabled(true);
		switch (thisTask.getReminders().length) {
		case 1:
			add_reminder.setEnabled(true);
			default_reminder_spinner.setEnabled(true);
			break;
		case 2:
			add_reminder.setEnabled(true);
			default_reminder_spinner.setEnabled(true);
			remove_extra_reminder_0.setEnabled(true);
			extra_reminder_spinner0.setEnabled(true);
			break;
		case 3:
			add_reminder.setEnabled(true);
			default_reminder_spinner.setEnabled(true);
			remove_extra_reminder_0.setEnabled(true);
			extra_reminder_spinner0.setEnabled(true);
			remove_extra_reminder_1.setEnabled(true);
			extra_reminder_spinner1.setEnabled(true);
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
	private void saveSingleTask(final ContentValues values) {
		if (values.getAsBoolean("isValid")) {
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
						Main.deleteById(thisTask.getId(), 0);
						Main.getDatabase().updateSingleTask(
								thisTask.getId(),
								values.getAsString("name"),
								values.getAsString("type"),
								values.getAsString("subject"),
								values.getAsInteger("due_year"),
								values.getAsInteger("due_month"),
								values.getAsInteger("due_day"),
								values.getAsInteger("due_hour"),
								values.getAsInteger("due_min"),
								Util.convertStringToArray(values
										.getAsString("reminders")),
								values.getAsString("notes"), 0);
						Main.setTaskChanged(true);
						Task t = new Task(thisTask.getId(), values
								.getAsString("name"), values
								.getAsString("type"), values
								.getAsString("subject"), Util
								.generateDueCalendar(
										values.getAsInteger("due_year"),
										values.getAsInteger("due_month"),
										values.getAsInteger("due_day"),
										values.getAsInteger("due_hour"),
										values.getAsInteger("due_min")), Util
								.convertStringToArray(values
										.getAsString("reminders")), values
								.getAsString("notes"), "Pending", 0, 0, 0, "0",
								"0", false);
						Main.addAndSort(t);
						terminationCode = true;
						finish();
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
				Main.deleteById(thisTask.getId(), 0);
				Task t;
				if (reminder_switch.isChecked()) {
					Main.getDatabase().updateSingleTask(
							thisTask.getId(),
							values.getAsString("name"),
							values.getAsString("type"),
							values.getAsString("subject"),
							values.getAsInteger("due_year"),
							values.getAsInteger("due_month"),
							values.getAsInteger("due_day"),
							values.getAsInteger("due_hour"),
							values.getAsInteger("due_min"),
							Util.convertStringToArray(values
									.getAsString("reminders")),
							values.getAsString("notes"), 1);
					values.put("id", thisTask.getId());
					Main.getScheduleClient().setAlarmForNotification(values);
					t = new Task(thisTask.getId(), values.getAsString("name"),
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
							values.getAsString("notes"), "Pending", 0, 0, 0,
							"0", "0", true);
				} else {
					Main.getDatabase().updateSingleTask(
							thisTask.getId(),
							values.getAsString("name"),
							values.getAsString("type"),
							values.getAsString("subject"),
							values.getAsInteger("due_year"),
							values.getAsInteger("due_month"),
							values.getAsInteger("due_day"),
							values.getAsInteger("due_hour"),
							values.getAsInteger("due_min"),
							Util.convertStringToArray(values
									.getAsString("reminders")),
							values.getAsString("notes"), 0);
					values.put("id", thisTask.getId());
					t = new Task(thisTask.getId(), values.getAsString("name"),
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
							values.getAsString("notes"), "Pending", 0, 0, 0,
							"0", "0", false);
				}
				Main.setTaskChanged(true);
				Main.addAndSort(t);
				Main.updateAppWidget();
				terminationCode = true;
				finish();
			}

		} else {
			Util.infoIncomplete("Name", this);
			name.setText("");
			name.requestFocus();
		}
	}

	private ContentValues fetchInfo() {
		ContentValues rv = new ContentValues();
		rv.put("isValid", true);
		if (!name.getText().toString().matches("")) {
			rv.put("name", name.getText().toString());
		} else {
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
		Main.getSwipeListView().closeOpenedItems();
	}

	public static String getLinkedStartTag() {
		return startOfLinked;
	}

	public static String getLinkedEndTag() {
		return endOfLinked;
	}

	class LinkedUpdateThread extends AsyncTask<ContentValues, Void, Void> {

		ProgressDialog progress;
		CoreDatabase db;

		@Override
		protected Void doInBackground(ContentValues... params) {
			// TODO Auto-generated method stub
			updateAllLinkedTask(params[0]);
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
			;
			progress.show();
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			progress.cancel();
			Main.updateListView(true);
			finish();
		}
		
		
	}

}
