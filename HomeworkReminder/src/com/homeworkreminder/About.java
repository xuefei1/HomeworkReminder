package com.homeworkreminder;

import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.homeworkreminder.Theme.ColorScheme;
import com.homeworkreminder.Theme.ThemeManager;

public class About extends Activity {
	
	Button about_ok_btn;
	View customActionBarView;
	private ThemeManager theme;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		 LayoutInflater inflater = (LayoutInflater) getActionBar()
		            .getThemedContext().getSystemService(LAYOUT_INFLATER_SERVICE);
		    customActionBarView = inflater.inflate(R.layout.about_actionbar, null);
		    ActionBar actionBar = getActionBar();
		    actionBar.setDisplayOptions(
		            ActionBar.DISPLAY_SHOW_CUSTOM,
		            ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME
		                    | ActionBar.DISPLAY_SHOW_TITLE);
		    actionBar.setCustomView(customActionBarView,
		            new ActionBar.LayoutParams(
		                    ViewGroup.LayoutParams.MATCH_PARENT,
		                    ViewGroup.LayoutParams.MATCH_PARENT));
		    setContentView(R.layout.about);
		    SharedPreferences prefs = PreferenceManager
					.getDefaultSharedPreferences(this);
		    theme = new ThemeManager(this){

				@Override
				public void setColor(ColorScheme scheme) {
					// TODO Auto-generated method stub
					StateListDrawable ok_btn_selector = new StateListDrawable();
					ok_btn_selector.addState(
							new int[] { android.R.attr.state_pressed },
							new ColorDrawable(scheme.getDarkerColor()));
					ok_btn_selector.addState(StateSet.WILD_CARD,
							new ColorDrawable(scheme.getSuperDarkColor()));
					about_ok_btn.setBackgroundDrawable(ok_btn_selector);
				}
		    	
		    };
		    about_ok_btn = (Button) findViewById(R.id.about_ok_btn);
		    about_ok_btn.setOnClickListener(new View.OnClickListener() {
			
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
		    theme.loadColorScheme(prefs);
	}

	
}
