package com.homeworkreminder;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.homeworkreminder.Theme.ColorScheme;
import com.homeworkreminder.Theme.ThemeManager;
import com.homeworkreminder.Versions.VersionHelper;

public class UserSettings extends PreferenceActivity{

	private CoreDatabase Database;
	private static Context context;
	private ListPreference colorSchemePreference;
	private ThemeManager theme;
	private ActionBar actionBar;
	SharedPreferences getPrefs;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.prefs);
		actionBar = getActionBar();
		getActionBar().setTitle("Settings");
		getActionBar().setDisplayShowHomeEnabled(false);
		setContentView(R.layout.user_settings);
		Database = new CoreDatabase(this);
		context = this;
		final Activity activity = this;
		getPrefs = PreferenceManager.getDefaultSharedPreferences(context);
		colorSchemePreference = (ListPreference) findPreference("Color_scheme");
		colorSchemePreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener(){

			@Override
			public boolean onPreferenceChange(Preference preference,
					Object newValue) {
				// TODO Auto-generated method stub
				theme.loadColorScheme(theme.getColorSchemeFromName(newValue.toString()));
				if (Build.VERSION.SDK_INT >= 11)
				{
				    VersionHelper.refreshActionBarMenu(activity);
				}
				Main.getThemeManager().loadColorScheme(Main.getThemeManager().getColorSchemeFromName(newValue.toString()));
				Main.updateAppWidget();
				Main.updateAdapterTheme(newValue.toString());
				preference.setSummary(newValue.toString());
				return true;
			}
			
		});
		
		theme = new ThemeManager(context){

			@Override
			public void setColor(ColorScheme scheme) {
				// TODO Auto-generated method stub
				actionBar.setBackgroundDrawable(new ColorDrawable(scheme.getSuperDarkColor()));
			}
			
		};
		
		theme.loadColorScheme(getPrefs);
		
		Preference btnDeleteAll = (Preference)findPreference("Clear_all");
		btnDeleteAll.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
		                @Override
		                public boolean onPreferenceClick(Preference arg0) { 
		                	AlertDialog.Builder b = new AlertDialog.Builder(context);
		        			b.setTitle("WARNING");
		        			b.setMessage("This action is not reversible, proceed?" );
		        			final AlertDialog d = b.create();
		        			d.setButton("Yes", new DialogInterface.OnClickListener() {
		        				@Override
		        				public void onClick(DialogInterface dialog, int which) {
		        					// TODO Auto-generated method stub
		        					new DeleteAllTasksThread().execute();
		        					d.dismiss();
		        				}});
		        			d.setButton2("No", new DialogInterface.OnClickListener() {
		        				@Override
		        				public void onClick(DialogInterface dialog, int which) {
		        					// TODO Auto-generated method stub
		        					d.dismiss();
		        				}
		        			});
		        			d.show();
		                    return true;
		                }
		            });
		Preference btnDeleteCompleted = (Preference)findPreference("Clear_completed");
		btnDeleteCompleted.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
		                @Override
		                public boolean onPreferenceClick(Preference arg0) { 
		                	AlertDialog.Builder g = new AlertDialog.Builder(context);
		        			g.setTitle("WARNING");
		        			g.setMessage("This action is not reversible, proceed?");	
		        			final AlertDialog h = g.create();
		        			h.setButton("Yes", new DialogInterface.OnClickListener() {
		        				@Override
		        				public void onClick(DialogInterface dialog, int which) {
		        					// TODO Auto-generated method stub
		        					h.dismiss();
		        					new DeleteCompletedTasksThread().execute();
		        				}});
		        			h.setButton2("No", new DialogInterface.OnClickListener() {
		        				@Override
		        				public void onClick(DialogInterface dialog, int which) {
		        					// TODO Auto-generated method stub
		        					
		        					h.dismiss();
		        				}
		        			});
		        			h.show();
		                    return true;
		                }
		            });
		Preference btnAbout = (Preference)findPreference("About");
		btnAbout.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
		                @Override
		                public boolean onPreferenceClick(Preference arg0) { 
		                	Intent i = new Intent(context, About.class);
		        			startActivity(i);
		                    return true;
		                }
		            });
	}

	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		SharedPreferences getPrefs = PreferenceManager
				.getDefaultSharedPreferences(this);
		Main.setUpcomingDate(Integer.parseInt(getPrefs.getString("Upcoming_date", "7")));
		if(Main.getPreviousScreen() == 0){
			Main.reGenerateUpcoming();
		}
		Main.updateListView(true);
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.settings_done_icon:
			finish();
			break;
		}
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.settings_action, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	public static Context getContext(){
		return context;
	}
	
	public ThemeManager getThemeManager(){
		return theme;
	}
	
	class DeleteCompletedTasksThread extends AsyncTask<Void, Void, Void>{
ProgressDialog progress;
		
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			Database.deleteCompleted();
			Main.getCompleted().clear();
			return null;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			progress = new ProgressDialog(context);
			progress.setIndeterminate(false);
			progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progress.setCancelable(false);
			progress.setTitle(context.getResources().getString(R.string.dialog_linked_delete_title));
			progress.setMessage(context.getResources().getString(R.string.dialog_linked_delete_msg));
			progress.setOnCancelListener(new DialogInterface.OnCancelListener(){

				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
					Main.getswipelistAdapter().notifyDataSetChanged();
					Main.updateListView(true);
				}
				
			});
			progress.show();
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			progress.cancel();
		}
	}
	class DeleteAllTasksThread extends AsyncTask<Void, Void, Void>{

		ProgressDialog progress;
		
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			Main.clearAll();
			return null;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			progress = new ProgressDialog(context);
			progress.setIndeterminate(false);
			progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progress.setCancelable(false);
			progress.setTitle(context.getResources().getString(R.string.dialog_linked_delete_title));
			progress.setMessage(context.getResources().getString(R.string.dialog_linked_delete_msg));
			progress.setOnCancelListener(new DialogInterface.OnCancelListener(){

				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
					Main.updateListView(true);
					Main.updateAppWidget();
				}
				
			});
			progress.show();
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			progress.cancel();
		}
		
	}
}
