package com.homeworkreminder;

/*
 * 
 Copyright 2014 Xuefei Han
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 Apache License
 Version 2.0, January 2004
 http://www.apache.org/licenses/

 TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION

 1. Definitions.

 "License" shall mean the terms and conditions for use, reproduction,
 and distribution as defined by Sections 1 through 9 of this document.

 "Licensor" shall mean the copyright owner or entity authorized by
 the copyright owner that is granting the License.

 "Legal Entity" shall mean the union of the acting entity and all
 other entities that control, are controlled by, or are under common
 control with that entity. For the purposes of this definition,
 "control" means (i) the power, direct or indirect, to cause the
 direction or management of such entity, whether by contract or
 otherwise, or (ii) ownership of fifty percent (50%) or more of the
 outstanding shares, or (iii) beneficial ownership of such entity.

 "You" (or "Your") shall mean an individual or Legal Entity
 exercising permissions granted by this License.

 "Source" form shall mean the preferred form for making modifications,
 including but not limited to software source code, documentation
 source, and configuration files.

 "Object" form shall mean any form resulting from mechanical
 transformation or translation of a Source form, including but
 not limited to compiled object code, generated documentation,
 and conversions to other media types.

 "Work" shall mean the work of authorship, whether in Source or
 Object form, made available under the License, as indicated by a
 copyright notice that is included in or attached to the work
 (an example is provided in the Appendix below).

 "Derivative Works" shall mean any work, whether in Source or Object
 form, that is based on (or derived from) the Work and for which the
 editorial revisions, annotations, elaborations, or other modifications
 represent, as a whole, an original work of authorship. For the purposes
 of this License, Derivative Works shall not include works that remain
 separable from, or merely link (or bind by name) to the interfaces of,
 the Work and Derivative Works thereof.

 "Contribution" shall mean any work of authorship, including
 the original version of the Work and any modifications or additions
 to that Work or Derivative Works thereof, that is intentionally
 submitted to Licensor for inclusion in the Work by the copyright owner
 or by an individual or Legal Entity authorized to submit on behalf of
 the copyright owner. For the purposes of this definition, "submitted"
 means any form of electronic, verbal, or written communication sent
 to the Licensor or its representatives, including but not limited to
 communication on electronic mailing lists, source code control systems,
 and issue tracking systems that are managed by, or on behalf of, the
 Licensor for the purpose of discussing and improving the Work, but
 excluding communication that is conspicuously marked or otherwise
 designated in writing by the copyright owner as "Not a Contribution."

 "Contributor" shall mean Licensor and any individual or Legal Entity
 on behalf of whom a Contribution has been received by Licensor and
 subsequently incorporated within the Work.

 2. Grant of Copyright License. Subject to the terms and conditions of
 this License, each Contributor hereby grants to You a perpetual,
 worldwide, non-exclusive, no-charge, royalty-free, irrevocable
 copyright license to reproduce, prepare Derivative Works of,
 publicly display, publicly perform, sublicense, and distribute the
 Work and such Derivative Works in Source or Object form.

 3. Grant of Patent License. Subject to the terms and conditions of
 this License, each Contributor hereby grants to You a perpetual,
 worldwide, non-exclusive, no-charge, royalty-free, irrevocable
 (except as stated in this section) patent license to make, have made,
 use, offer to sell, sell, import, and otherwise transfer the Work,
 where such license applies only to those patent claims licensable
 by such Contributor that are necessarily infringed by their
 Contribution(s) alone or by combination of their Contribution(s)
 with the Work to which such Contribution(s) was submitted. If You
 institute patent litigation against any entity (including a
 cross-claim or counterclaim in a lawsuit) alleging that the Work
 or a Contribution incorporated within the Work constitutes direct
 or contributory patent infringement, then any patent licenses
 granted to You under this License for that Work shall terminate
 as of the date such litigation is filed.

 4. Redistribution. You may reproduce and distribute copies of the
 Work or Derivative Works thereof in any medium, with or without
 modifications, and in Source or Object form, provided that You
 meet the following conditions:

 (a) You must give any other recipients of the Work or
 Derivative Works a copy of this License; and

 (b) You must cause any modified files to carry prominent notices
 stating that You changed the files; and

 (c) You must retain, in the Source form of any Derivative Works
 that You distribute, all copyright, patent, trademark, and
 attribution notices from the Source form of the Work,
 excluding those notices that do not pertain to any part of
 the Derivative Works; and

 (d) If the Work includes a "NOTICE" text file as part of its
 distribution, then any Derivative Works that You distribute must
 include a readable copy of the attribution notices contained
 within such NOTICE file, excluding those notices that do not
 pertain to any part of the Derivative Works, in at least one
 of the following places: within a NOTICE text file distributed
 as part of the Derivative Works; within the Source form or
 documentation, if provided along with the Derivative Works; or,
 within a display generated by the Derivative Works, if and
 wherever such third-party notices normally appear. The contents
 of the NOTICE file are for informational purposes only and
 do not modify the License. You may add Your own attribution
 notices within Derivative Works that You distribute, alongside
 or as an addendum to the NOTICE text from the Work, provided
 that such additional attribution notices cannot be construed
 as modifying the License.

 You may add Your own copyright statement to Your modifications and
 may provide additional or different license terms and conditions
 for use, reproduction, or distribution of Your modifications, or
 for any such Derivative Works as a whole, provided Your use,
 reproduction, and distribution of the Work otherwise complies with
 the conditions stated in this License.

 5. Submission of Contributions. Unless You explicitly state otherwise,
 any Contribution intentionally submitted for inclusion in the Work
 by You to the Licensor shall be under the terms and conditions of
 this License, without any additional terms or conditions.
 Notwithstanding the above, nothing herein shall supersede or modify
 the terms of any separate license agreement you may have executed
 with Licensor regarding such Contributions.

 6. Trademarks. This License does not grant permission to use the trade
 names, trademarks, service marks, or product names of the Licensor,
 except as required for reasonable and customary use in describing the
 origin of the Work and reproducing the content of the NOTICE file.

 7. Disclaimer of Warranty. Unless required by applicable law or
 agreed to in writing, Licensor provides the Work (and each
 Contributor provides its Contributions) on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 implied, including, without limitation, any warranties or conditions
 of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A
 PARTICULAR PURPOSE. You are solely responsible for determining the
 appropriateness of using or redistributing the Work and assume any
 risks associated with Your exercise of permissions under this License.

 8. Limitation of Liability. In no event and under no legal theory,
 whether in tort (including negligence), contract, or otherwise,
 unless required by applicable law (such as deliberate and grossly
 negligent acts) or agreed to in writing, shall any Contributor be
 liable to You for damages, including any direct, indirect, special,
 incidental, or consequential damages of any character arising as a
 result of this License or out of the use or inability to use the
 Work (including but not limited to damages for loss of goodwill,
 work stoppage, computer failure or malfunction, or any and all
 other commercial damages or losses), even if such Contributor
 has been advised of the possibility of such damages.

 9. Accepting Warranty or Additional Liability. While redistributing
 the Work or Derivative Works thereof, You may choose to offer,
 and charge a fee for, acceptance of support, warranty, indemnity,
 or other liability obligations and/or rights consistent with this
 License. However, in accepting such obligations, You may act only
 on Your own behalf and on Your sole responsibility, not on behalf
 of any other Contributor, and only if You agree to indemnify,
 defend, and hold each Contributor harmless for any liability
 incurred by, or claims asserted against, such Contributor by reason
 of your accepting any such warranty or additional liability.

 END OF TERMS AND CONDITIONS

 APPENDIX: How to apply the Apache License to your work.

 To apply the Apache License to your work, attach the following
 boilerplate notice, with the fields enclosed by brackets "[]"
 replaced with your own identifying information. (Don't include
 the brackets!)  The text should be enclosed in the appropriate
 comment syntax for the file format. We also recommend that a
 file or class name and description of purpose be included on the
 same "printed page" as the copyright notice for easier
 identification within third-party archives.

 Copyright 2013 47 Degrees

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.


 Caldroid License
 Available for use under the MIT License
 Copyright (c) 2013 by Roomorama Inc.
 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

 InfiniteViewPager License
 Copyright (c) 2012 Antony Tran
 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

 date4j license
 Copyright (c) 2010-2013 Hirondelle Systems All rights reserved.
 Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright
 notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 notice, this list of conditions and the following disclaimer in the
 documentation and/or other materials provided with the distribution.
 * Neither the name of Hirondelle Systems nor the
 names of its contributors may be used to endorse or promote products
 derived from this software without specific prior written permission.


 THIS SOFTWARE IS PROVIDED BY HIRONDELLE SYSTEMS ''AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL HIRONDELLE SYSTEMS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.


 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import Receivers.DateChangeReceiver;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.Legend;
import com.github.mikephil.charting.utils.Legend.LegendPosition;
import com.github.mikephil.charting.utils.ValueFormatter;
import com.homeworkreminder.Theme.ColorScheme;
import com.homeworkreminder.Theme.ThemeManager;
import com.homeworkreminder.Versions.VersionHelper;
import com.homeworkreminder.Widget.Widget;
import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

public class Main extends FragmentActivity implements OnClickListener {

	private static IntentFilter intentFilter;

	static {
		intentFilter = new IntentFilter();
		intentFilter.addAction(Intent.ACTION_TIME_TICK);
		intentFilter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
		intentFilter.addAction(Intent.ACTION_TIME_CHANGED);
	}

	public static boolean active = false;
	static boolean firstStart = false;

	private static List<Task> TaskHolder = new ArrayList<Task>();
	private static List<Task> Completed = new ArrayList<Task>();
	private static List<Task> Upcoming = new ArrayList<Task>();
	private static HashMap<Calendar, List<Task>> TaskMap = new HashMap<Calendar, List<Task>>();
	private static HashMap<String, List<Task>> SubjectMap = new HashMap<String, List<Task>>();
	private static ArrayList<String> subjectArray = new ArrayList<String>();
	private static boolean TaskChanged = false;
	private static CoreDatabase Database;
	final static String DEFAULT_SUBJECT = "Default subject";
	final static String ADD_SUBJECT = "Create new";
	private static int UpcomingDate = 7;
	private static boolean isActionBarExtensionOpen = false;

	private DrawerListAdapter drawerAdapter;
	private static SwipeListView swipelistview;
	private static ItemAdapter adapter;
	private String[] DrawerItems;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private static ListView mDrawerList;
	private final CharSequence mDrawerTitle = "Home";
	private CharSequence mTitle = "Upcoming";
	private static int prevScreen;
	private RelativeLayout main_container;
	private static RelativeLayout main_content;
	private static Context context;
	private float dpWidth;
	private LayoutInflater inflater;
	private static ScheduleClient scheduleClient;
	private static AlarmHandler alarmHandler;
	private static CaldroidFragment caldroidFragment;
	private static ListView info_list;
	private static InfoListAdapter info_adapter;
	private View calView;
	private static Date lastSelectedCalendarDate = Calendar.getInstance()
			.getTime();
	private static Calendar currCalendarMonth = Calendar.getInstance();
	private static RelativeLayout notask_notify;
	private static TextView notask;
	private static TextView tv_calendar_notaskfordate;
	private RelativeLayout actionBarExtension;
	private static ExpandableListView subjectlistview;
	private static SubjectListAdapter subject_adapter;
	private static ThemeManager theme;
	private ActionBar actionBar;
	private Button actionBarExtensionToggle;
	private LinearLayout extensionToggleContainer;
	private Button addNewSubject;
	private ImageView extensionToggleView;
	private RelativeLayout extensionContentContainer;
	private Button extensionMask;
	private static SharedPreferences prefs;
	private static DateChangeReceiver dateReceiver = new DateChangeReceiver();
	private PieChart chart;
	private TextView extensionText;
	private final Activity activity = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		registerReceiver(dateReceiver, intentFilter);
		setContentView(R.layout.home);
		inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		context = this;
		prefs = PreferenceManager.getDefaultSharedPreferences(context);
		theme = new ThemeManager(this) {

			@Override
			public void setColor(ColorScheme scheme) {
				// TODO Auto-generated method stub
				mDrawerList.setBackgroundColor(scheme.getUltraDarkColor());
				mDrawerList.setSelector(new ColorDrawable(scheme
						.getNormalColor()));
				actionBar.setBackgroundDrawable(new ColorDrawable(scheme
						.getSuperDarkColor()));
				actionBarExtension.setBackgroundColor(scheme
						.getSuperDarkColor());
				actionBarExtension.getChildAt(0).setBackgroundColor(
						scheme.getSuperDarkColor());
				setColorComboForActionBar(scheme.getColorName());
				if (Build.VERSION.SDK_INT >= 11)
				{
				    VersionHelper.refreshActionBarMenu(activity);
				}
			}

		};

		main_content = (RelativeLayout) findViewById(R.id.main_content_screen);
		actionBarExtension = (RelativeLayout) findViewById(R.id.actionbar_extension);
		main_container = (RelativeLayout) findViewById(R.id.main_container);
		notask_notify = (RelativeLayout) findViewById(R.id.notask_notify);
		notask = (TextView) findViewById(R.id.tv_notask);
		actionBarExtension.setVisibility(View.VISIBLE);
		caldroidFragment = new CaldroidFragment();

		if (savedInstanceState != null) {
			caldroidFragment.restoreStatesFromKey(savedInstanceState,
					"CALDROID_SAVED_STATE");
		} else {
			Bundle args = new Bundle();
			Calendar cal = Calendar.getInstance();
			args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
			args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
			args.putBoolean(CaldroidFragment.ENABLE_SWIPE, true);
			args.putBoolean(CaldroidFragment.SIX_WEEKS_IN_CALENDAR, true);
			caldroidFragment.setArguments(args);
		}
		actionBar = getActionBar();
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setIcon(R.drawable.ic_drawer);
		prevScreen = 0;
		firstStart = true;
		drawerAdapter = new DrawerListAdapter(this);
		DrawerItems = getResources().getStringArray(R.array.home_drawer);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.home_drawer);
		mDrawerList = (ListView) findViewById(R.id.nav_drawer);
		mDrawerList.setAdapter(drawerAdapter);
		SharedPreferences getPrefs = PreferenceManager
				.getDefaultSharedPreferences(this);
		int startupscreen = Integer.parseInt(getPrefs.getString(
				"Startup_screen", "0"));
		UpcomingDate = Integer.parseInt(getPrefs
				.getString("Upcoming_date", "7"));

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.home, R.string.drawer_open, R.string.drawer_close) {

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu();
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		Database = new CoreDatabase(this);
		swipelistview = (SwipeListView) findViewById(R.id.example_swipe_lv_list);
		swipelistview.setVisibility(View.GONE);
		subjectlistview = (ExpandableListView) findViewById(R.id.subject_listview);
		// add_subject_btn = (ImageButton) findViewById(R.id.add_subject_btn);
		subjectlistview.setVisibility(View.GONE);
		// add_subject_btn.setVisibility(View.GONE);
		notask.setText("Loading");
		TaskHolder = Database.getAllTask("Pending");
		Collections.sort(TaskHolder, new Comparator<Task>() {
			public int compare(Task o1, Task o2) {
				return o1.getDue().compareTo(o2.getDue());
			}
		});
		generateTaskMap(TaskHolder);
		// get subjects
		subjectArray = Database.querySubjectList();
		subjectArray.add(0, DEFAULT_SUBJECT);
		generateSubjectMap();
		Completed = Database.getAllTask("Completed");
		adapter = new ItemAdapter(this, R.layout.custom_row, TaskHolder,
				swipelistview, prefs.getString("Color_scheme", "Default"));
		subject_adapter = new SubjectListAdapter(this, subjectArray,
				SubjectMap, subjectlistview);
		swipelistview.setSwipeListViewListener(new BaseSwipeListViewListener() {
			@Override
			public void onOpened(int position, boolean toRight) {
			}

			@Override
			public void onClosed(int position, boolean fromRight) {
			}

			@Override
			public void onListChanged() {
			}

			@Override
			public void onMove(int position, float x) {
			}

			@Override
			public void onStartOpen(int position, int action, boolean right) {
			}

			@Override
			public void onStartClose(int position, boolean right) {
			}

			@Override
			public void onClickFrontView(int position) {
				if (swipelistview.isOpen(position)) {
					swipelistview.openAnimate(position);
				}
			}

			@Override
			public void onClickBackView(int position) {
			}

			@Override
			public void onDismiss(int[] reverseSortedPositions) {
			}
		});
		// These are the swipe listview settings. you can change these
		// setting as your requirement
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		DisplayMetrics outMetrics = new DisplayMetrics();
		display.getMetrics(outMetrics);
		float density = getResources().getDisplayMetrics().density;
		dpWidth = outMetrics.widthPixels / density;
		swipelistview.setSwipeMode(SwipeListView.SWIPE_MODE_LEFT); // modes
		swipelistview.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL);
		swipelistview.setOffsetLeft(Util.convertDpToPixel(dpWidth - 180 + 10,
				this)); // left side offset
		swipelistview.setOffsetRight(0); // right side offset
		swipelistview.setAnimationTime(300); // animation time
		swipelistview.setSwipeOpenOnLongPress(false);
		swipelistview.setAdapter(adapter);
		main_container.setBackgroundColor(context.getResources().getColor(
				R.color.pure_white));

		if (startupscreen == 0) {
			mDrawerList.performItemClick(mDrawerList.getChildAt(0), 0,
					mDrawerList.getItemIdAtPosition(0));
		} else if (startupscreen == 1) {
			mDrawerList.performItemClick(mDrawerList.getChildAt(1), 1,
					mDrawerList.getItemIdAtPosition(1));
		} else if (startupscreen == 2) {
			mDrawerList.performItemClick(mDrawerList.getChildAt(2), 2,
					mDrawerList.getItemIdAtPosition(2));
		} else if (startupscreen == 3) {
			mDrawerList.performItemClick(mDrawerList.getChildAt(3), 3,
					mDrawerList.getItemIdAtPosition(3));
		} else if (startupscreen == 4) {
			mDrawerList.performItemClick(mDrawerList.getChildAt(4), 4,
					mDrawerList.getItemIdAtPosition(4));
		} else {
			mDrawerList.performItemClick(mDrawerList.getChildAt(0), 0,
					mDrawerList.getItemIdAtPosition(0));
		}
		firstStart = false;
		alarmHandler = new AlarmHandler(this);
		scheduleClient = new ScheduleClient(this.getApplicationContext());
		scheduleClient.doBindService();
		this.initActionBarExtension();
		theme.loadColorScheme(PreferenceManager
				.getDefaultSharedPreferences(this));
	}

	protected static List<Task> getTaskHolder() {
		return TaskHolder;
	}

	protected static List<Task> getUpcoming() {
		return Upcoming;
	}

	protected static HashMap<String, List<Task>> getSubjectMap() {
		return SubjectMap;
	}

	protected static HashMap<Calendar, List<Task>> getTaskMap() {
		return TaskMap;
	}

	protected static List<Task> getCompleted() {
		return Completed;
	}

	protected static boolean hasTaskChanged() {
		return TaskChanged;
	}

	protected static void setTaskChanged(boolean change) {
		TaskChanged = change;
	}

	protected static CoreDatabase getDatabase() {
		return Database;
	}

	protected static int getUpcomingDate() {
		return UpcomingDate;
	}

	protected static void setUpcomingDate(int date) {
		UpcomingDate = date;
	}

	protected static ItemAdapter getswipelistAdapter() {
		return adapter;
	}

	protected static ScheduleClient getScheduleClient() {
		return scheduleClient;
	}

	protected static AlarmHandler getAlarmHandler() {
		return alarmHandler;
	}

	protected static CaldroidFragment getcaldroidFragment() {

		return caldroidFragment;
	}

	protected static SwipeListView getSwipeListView() {
		return swipelistview;
	}

	protected static int getPreviousScreen() {
		return prevScreen;
	}

	private static void generateSubjectMap() {
		// TODO Auto-generated method stub

		Iterator<String> it = subjectArray.iterator();
		while (it.hasNext()) {
			String subject = it.next();
			if (subject.contentEquals(ADD_SUBJECT)) {
				continue;
			}
			List<Task> list = Database.queryBySubject(subject);
			Collections.sort(list, new Comparator<Task>() {
				public int compare(Task o1, Task o2) {
					return o1.getDue().compareTo(o2.getDue());
				}
			});
			SubjectMap.put(subject, list);
		}

	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.settings_icon:
			Intent i = new Intent(this, UserSettings.class);
			startActivity(i);
			break;
		case R.id.add_icon:
			Intent h = new Intent(this, AddTask.class);
			startActivity(h);
			break;
		}
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_action, menu);

		return super.onCreateOptionsMenu(menu);
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			selectItem(position);

		}

		private void selectItem(int position) {
			// TODO Auto-generated method stub
			switch (position) {
			case 0:
				if (prevScreen == 0 && !firstStart) {
					mDrawerLayout.closeDrawer(mDrawerList);
					mDrawerList.setItemChecked(position, true);
					break;
				}
				clearScreen(prevScreen, position);
				if (!firstStart) {
					swipelistRevive();
				}
				main_container.setBackgroundColor(context.getResources()
						.getColor(R.color.pure_white));
				actionBarExtension.setVisibility(View.VISIBLE);
				DataToTiles(1);

				mDrawerList.setItemChecked(position, true);
				setTitle(DrawerItems[position]);
				mDrawerLayout.closeDrawer(mDrawerList);

				break;
			case 1:
				if (prevScreen == 1) {
					mDrawerLayout.closeDrawer(mDrawerList);
					mDrawerList.setItemChecked(position, true);
					break;
				}
				clearScreen(prevScreen, position);
				main_container.setBackgroundColor(context.getResources()
						.getColor(R.color.pure_white));
				actionBarExtension.setVisibility(View.VISIBLE);
				subject_adapter = new SubjectListAdapter(context, subjectArray,
						SubjectMap, subjectlistview);
				subjectlistview.setAdapter(subject_adapter);
				subjectlistview.setVisibility(View.VISIBLE);
				mDrawerList.setItemChecked(position, true);
				setTitle(DrawerItems[position]);
				mDrawerLayout.closeDrawer(mDrawerList);
				break;
			case 2:
				if (prevScreen == 2) {
					mDrawerLayout.closeDrawer(mDrawerList);
					mDrawerList.setItemChecked(position, true);
					break;
				}
				clearScreen(prevScreen, position);

				swipelistRevive();
				main_container.setBackgroundColor(context.getResources()
						.getColor(R.color.pure_white));
				actionBarExtension.setVisibility(View.VISIBLE);
				DataToTiles(0);

				mDrawerList.setItemChecked(position, true);
				setTitle(DrawerItems[position]);
				mDrawerLayout.closeDrawer(mDrawerList);
				break;
			case 3:
				if (prevScreen == 3) {
					mDrawerLayout.closeDrawer(mDrawerList);
					mDrawerList.setItemChecked(position, true);
					break;
				}
				clearScreen(prevScreen, position);
				main_container.setBackgroundColor(context.getResources()
						.getColor(R.color.background_grey));
				actionBarExtension.setVisibility(View.GONE);
				initCalendarPage();

				mDrawerList.setItemChecked(position, true);
				setTitle(DrawerItems[position]);
				mDrawerLayout.closeDrawer(mDrawerList);
				break;
			case 4:
				if (prevScreen == 4) {
					mDrawerLayout.closeDrawer(mDrawerList);
					mDrawerList.setItemChecked(position, true);
					break;
				}
				clearScreen(prevScreen, position);

				swipelistRevive();
				main_container.setBackgroundColor(context.getResources()
						.getColor(R.color.pure_white));
				actionBarExtension.setVisibility(View.VISIBLE);
				DataToTiles(2);

				mDrawerList.setItemChecked(position, true);
				setTitle(DrawerItems[position]);
				mDrawerLayout.closeDrawer(mDrawerList);
				break;
			}
		}

	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.extension_switch:
			if (!isActionBarExtensionOpen) {
				this.onActionBarExtensionOpen(prevScreen);
			} else {
				this.onActionBarExtensionClose();
			}
			break;
		case R.id.new_subject_btn:
			this.showDialogForNewSubject();
			break;
		case R.id.extension_mask:
			if (isActionBarExtensionOpen) {
				this.onActionBarExtensionClose();
			}
		}
	}

	private void clearScreen(int fromWhere, int position) {
		switch (fromWhere) {
		case 0:
			swipelistview.setVisibility(View.GONE);
			notask_notify.setVisibility(View.GONE);
			break;
		case 1:
			subjectlistview.setVisibility(View.GONE);
			// add_subject_btn.setVisibility(View.GONE);
			SubjectListAdapter.isEditModeActivated = false;
			break;
		case 2:
			swipelistview.setVisibility(View.GONE);
			notask_notify.setVisibility(View.GONE);
			break;
		case 3:
			try {
				main_content.removeView(calView);
				caldroidFragment = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 4:
			swipelistview.setVisibility(View.GONE);
			notask_notify.setVisibility(View.GONE);
			break;
		}
		prevScreen = position;
		if (isActionBarExtensionOpen) {
			this.onActionBarExtensionClose();
		}
	}

	private void swipelistRevive() {
		swipelistview = (SwipeListView) findViewById(R.id.example_swipe_lv_list);

		adapter = new ItemAdapter(this, R.layout.custom_row, TaskHolder,
				swipelistview, prefs.getString("Color_scheme", "Default"));

		swipelistview.setSwipeListViewListener(new BaseSwipeListViewListener() {
			@Override
			public void onOpened(int position, boolean toRight) {
			}

			@Override
			public void onClosed(int position, boolean fromRight) {
			}

			@Override
			public void onListChanged() {
			}

			@Override
			public void onMove(int position, float x) {
			}

			@Override
			public void onStartOpen(int position, int action, boolean right) {
			}

			@Override
			public void onStartClose(int position, boolean right) {
			}

			@Override
			public void onClickFrontView(int position) {
				if (swipelistview.isOpen(position)) {
					swipelistview.openAnimate(position);
				}

			}

			@Override
			public void onClickBackView(int position) {
				swipelistview.closeOpenedItems();
			}

			@Override
			public void onDismiss(int[] reverseSortedPositions) {

			}
		});
		swipelistview.setSwipeMode(SwipeListView.SWIPE_MODE_LEFT);
		swipelistview.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL);
		swipelistview.setOffsetLeft(Util.convertDpToPixel(dpWidth - 182 + 11,
				this));
		swipelistview.setOffsetRight(0);
		swipelistview.setAnimationTime(335);
		swipelistview.setSwipeOpenOnLongPress(false);
		swipelistview.setVisibility(View.VISIBLE);
		swipelistview.setAdapter(adapter);
	}

	private void DataToTiles(int code) {
		switch (code) {
		case 0:
			if (!TaskHolder.isEmpty()) {
				swipelistview.setVisibility(View.VISIBLE);
				notask_notify.setVisibility(View.GONE);
				adapter = new ItemAdapter(this, R.layout.custom_row,
						TaskHolder, swipelistview, prefs.getString(
								"Color_scheme", "Default"));
				swipelistview.setAdapter(adapter);
				adapter.notifyDataSetChanged();
			} else {
				swipelistview.setVisibility(View.GONE);
				notask.setText("No task(s) found");
				notask_notify.setVisibility(View.VISIBLE);
			}
			break;
		case 1:
			Upcoming.clear();
			if (!TaskHolder.isEmpty()) {
				for (Task i : TaskHolder) {
					if (i.getDueDays() <= UpcomingDate) {
						Upcoming.add(i);
					} else {
						break;
					}
				}
				adapter = new ItemAdapter(this, R.layout.custom_row, Upcoming,
						swipelistview, prefs.getString("Color_scheme",
								"Default"));
				swipelistview.setAdapter(adapter);
				adapter.notifyDataSetChanged();
				checkEmpty(Upcoming, 0);
			} else {
				swipelistview.setVisibility(View.GONE);
				notask.setText("No task(s) due in the next " + UpcomingDate
						+ " days");
				notask_notify.setVisibility(View.VISIBLE);
			}

			break;
		case 2:
			if (!Completed.isEmpty()) {
				swipelistview.setVisibility(View.VISIBLE);
				notask_notify.setVisibility(View.GONE);
				adapter = new ItemAdapter(this, R.layout.custom_row, Completed,
						swipelistview, prefs.getString("Color_scheme",
								"Default"));
				swipelistview.setAdapter(adapter);
				adapter.notifyDataSetChanged();
			} else {
				swipelistview.setVisibility(View.GONE);
				notask.setText("No completed task(s)");
				notask_notify.setVisibility(View.VISIBLE);
			}
			break;
		}
		TaskChanged = false;
	}

	private static void deleteTask(int pos, int status) {
		switch (status) {
		case 0:
			if (prevScreen == 0) {
				Upcoming.remove(pos);
			}
			Task temp = TaskHolder.get(pos);
			if (!temp.isLinked()) {
				Database.deleteRecord(temp.getId());
			} else {
				deleteLinkedTask(temp);
			}
			TaskHolder.remove(pos);
			if (prevScreen == 0) {
				checkEmpty(Upcoming, prevScreen);
			} else {
				checkEmpty(TaskHolder, prevScreen);
			}
			removeFromTaskMap(genTaskMapKey(temp.getDue()), temp);
			removeFromSubjectMap(temp.getSubject(), temp);
			if (temp.isAlarmActive()) {
				scheduleClient.cancelAlarm(temp.getId());
			}
			adapter.notifyDataSetChanged();
			break;
		case 1:
			Task t = Completed.get(pos);
			Completed.remove(pos);
			checkEmpty(Completed, prevScreen);
			if (!t.isLinked()) {
				Database.deleteRecord(t.getId());
			} else {
				deleteLinkedTask(t);
				updateListView(true);
			}
			break;
		}
	}

	private static void deleteTask(Task t) {
		switch (Util.isCompleted(t.getStatus())) {
		case 0:
			if (prevScreen == 0) {
				int index = findById(Upcoming, t.getId());
				if (index != -1 && index < Upcoming.size()) {
					Upcoming.remove(index);
				}
			}
			if (!t.isLinked()) {
				Database.deleteRecord(t.getId());
			} else {
				deleteLinkedTask(t);
			}
			int pos = findById(TaskHolder, t.getId());
			if (pos != -1 && pos < TaskHolder.size()) {
				TaskHolder.remove(pos);
			}
			if (prevScreen == 0) {
				checkEmpty(Upcoming, prevScreen);
			} else {
				checkEmpty(TaskHolder, prevScreen);
			}
			removeFromTaskMap(genTaskMapKey(t.getDue()), t);
			removeFromSubjectMap(t.getSubject(), t);
			if (t.isAlarmActive()) {
				scheduleClient.cancelAlarm(t.getId());
			}
			updateListView(true);
			break;
		case 1:
			int index = findById(Completed, t.getId());
			if (index != -1 && index < Completed.size()) {
				Completed.remove(index);
			}
			checkEmpty(Completed, prevScreen);
			if (!t.isLinked()) {
				Database.deleteRecord(t.getId());
			} else {
				deleteLinkedTask(t);
			}
			break;
		}
	}

	private static void deleteAllLinkedTasks(Task task, int status) {
		// TODO Auto-generated method stub
		if (!task.isLinked()) {
			deleteById(task.getId(), status);
			return;
		}
		Task t = task;
		while (!t.getPreviousTag().contentEquals(EditTask.getLinkedStartTag())) {
			Task temp = Database
					.queryById(Integer.parseInt(t.getPreviousTag()));
			deleteById(temp.getId(), Util.isCompleted(temp.getStatus()));
			deleteLinkedTask(temp);
			t = Database.queryById(t.getId());
		}
		while (!t.getNextTag().contentEquals(EditTask.getLinkedEndTag())) {
			Task temp = Database.queryById(Integer.parseInt(t.getNextTag()));
			deleteById(temp.getId(), Util.isCompleted(temp.getStatus()));
			deleteLinkedTask(temp);
			t = Database.queryById(t.getId());
		}
		deleteById(t.getId(), status);
		deleteLinkedTask(t);
	}

	public static void deleteSelection(int pos, int status) {
		if (TaskHolder.get(pos).isLinked()) {
			showLinkedDeleteDialog(pos, status);
		} else {
			deleteTask(pos, status);
		}
		updateAppWidget();
	}

	public static void deleteSelection(Task t) {
		if (t.isLinked()) {
			showLinkedDeleteDialog(t);
		} else {
			deleteTask(t);
		}
		updateAppWidget();
	}

	private static void showLinkedDeleteDialog(final int pos, final int status) {
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
		alertDialog.setTitle(context.getResources().getString(
				R.string.dialog_LinkedDelete_title));
		alertDialog.setMessage(context.getResources().getString(
				R.string.dialog_LinkedDelete_ContentChange));
		alertDialog.setPositiveButton(
				context.getResources().getString(R.string.text_yes),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						new LinkedDeleteThread().execute(TaskHolder.get(pos));
						// deleteAllLinkedTasks(TaskHolder.get(pos), status);
					}
				});
		// Setting Negative Button
		alertDialog.setNegativeButton(
				context.getResources().getString(R.string.text_no),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						deleteTask(pos, status);
					}
				});
		alertDialog.show();
	}

	private static void showLinkedDeleteDialog(final Task t) {
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
		alertDialog.setTitle(context.getResources().getString(
				R.string.dialog_LinkedDelete_title));
		alertDialog.setMessage(context.getResources().getString(
				R.string.dialog_LinkedDelete_ContentChange));
		alertDialog.setPositiveButton(
				context.getResources().getString(R.string.text_yes),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						new LinkedDeleteThread().execute(t);
						// deleteAllLinkedTasks(t,
						// Util.isCompleted(t.getStatus()));
					}
				});
		// Setting Negative Button
		alertDialog.setNegativeButton(
				context.getResources().getString(R.string.text_no),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						deleteTask(t);
					}
				});
		alertDialog.show();
	}

	private static void deleteLinkedTask(Task t) {
		// TODO Auto-generated method stub
		// handles only database single linked task deletion
		String prev_tag = t.getPreviousTag();
		String nxt_tag = t.getNextTag();
		if (prev_tag == null || nxt_tag == null) {
			return;
		}
		if (prev_tag.contentEquals(EditTask.getLinkedStartTag())
				&& !nxt_tag.contentEquals(EditTask.getLinkedEndTag())) {
			// deleting the first node
			Task second_task = Database.queryById(Integer.parseInt(t
					.getNextTag()));
			Task old_second_task = second_task.deepCopy();
			second_task.setPreviousTag(EditTask.getLinkedStartTag());
			Database.updateRepeatingTask(second_task.getId(), second_task
					.getName(), second_task.getType(),
					second_task.getSubject(), second_task.getStatus(),
					second_task.getDue().get(Calendar.YEAR), second_task
							.getDue().get(Calendar.MONTH), second_task.getDue()
							.get(Calendar.DAY_OF_MONTH), second_task.getDue()
							.get(Calendar.HOUR),
					second_task.getDue().get(Calendar.MINUTE), second_task
							.getReminders(), second_task.getNotes(), Util
							.isAlarmActive(second_task.isAlarmActive()),
					second_task.getIndex(), second_task.getInterval(),
					second_task.getPreviousTag(), second_task.getNextTag());
			updateInTaskHolder(old_second_task, second_task);
			updateInCompleted(old_second_task, second_task);
			updateInSubjectMap(old_second_task, second_task);
			updateInTaskMap(old_second_task, second_task);
		} else if (!prev_tag.contentEquals(EditTask.getLinkedStartTag())
				&& nxt_tag.contentEquals(EditTask.getLinkedEndTag())) {
			// deleting the last node
			Task secondlast_task = Database.queryById(Integer
					.parseInt(prev_tag));
			Task old_secondlast_task = secondlast_task.deepCopy();
			secondlast_task.setNextTag(EditTask.getLinkedEndTag());
			Database.updateRepeatingTask(secondlast_task.getId(),
					secondlast_task.getName(), secondlast_task.getType(),
					secondlast_task.getSubject(), secondlast_task.getStatus(),
					secondlast_task.getDue().get(Calendar.YEAR),
					secondlast_task.getDue().get(Calendar.MONTH),
					secondlast_task.getDue().get(Calendar.DAY_OF_MONTH),
					secondlast_task.getDue().get(Calendar.HOUR),
					secondlast_task.getDue().get(Calendar.MINUTE),
					secondlast_task.getReminders(), secondlast_task.getNotes(),
					Util.isAlarmActive(secondlast_task.isAlarmActive()),
					secondlast_task.getIndex(), secondlast_task.getInterval(),
					secondlast_task.getPreviousTag(),
					secondlast_task.getNextTag());
			updateInTaskHolder(old_secondlast_task, old_secondlast_task);
			updateInCompleted(old_secondlast_task, secondlast_task);
			updateInSubjectMap(old_secondlast_task, secondlast_task);
			updateInTaskMap(old_secondlast_task, secondlast_task);
		} else if (!prev_tag.contentEquals(EditTask.getLinkedStartTag())
				&& !nxt_tag.contentEquals(EditTask.getLinkedEndTag())) {
			// deleting a middle node
			Task previous_task = Database.queryById(Integer.parseInt(prev_tag));
			Log.d("CRASH", ":"+prev_tag);
			Task old_prev_task = previous_task.deepCopy();
			previous_task.setNextTag(nxt_tag);
			Database.updateRepeatingTask(previous_task.getId(), previous_task
					.getName(), previous_task.getType(), previous_task
					.getSubject(), previous_task.getStatus(), previous_task
					.getDue().get(Calendar.YEAR),
					previous_task.getDue().get(Calendar.MONTH), previous_task
							.getDue().get(Calendar.DAY_OF_MONTH), previous_task
							.getDue().get(Calendar.HOUR), previous_task
							.getDue().get(Calendar.MINUTE), previous_task
							.getReminders(), previous_task.getNotes(), Util
							.isAlarmActive(previous_task.isAlarmActive()),
					previous_task.getIndex(), previous_task.getInterval(),
					previous_task.getPreviousTag(), previous_task.getNextTag());
			updateInTaskHolder(old_prev_task, previous_task);
			updateInCompleted(old_prev_task, previous_task);
			updateInSubjectMap(old_prev_task, previous_task);
			updateInTaskMap(old_prev_task, previous_task);

			Task next_task = Database.queryById(Integer.parseInt(nxt_tag));
			Task old_next_task = next_task.deepCopy();
			next_task.setPreviousTag(prev_tag);
			Database.updateRepeatingTask(next_task.getId(),
					next_task.getName(), next_task.getType(), next_task
							.getSubject(), next_task.getStatus(), next_task
							.getDue().get(Calendar.YEAR), next_task.getDue()
							.get(Calendar.MONTH),
					next_task.getDue().get(Calendar.DAY_OF_MONTH), next_task
							.getDue().get(Calendar.HOUR), next_task.getDue()
							.get(Calendar.MINUTE), next_task.getReminders(),
					next_task.getNotes(), Util.isAlarmActive(next_task
							.isAlarmActive()), next_task.getIndex(), next_task
							.getInterval(), next_task.getPreviousTag(),
					next_task.getNextTag());
			updateInTaskHolder(old_next_task, next_task);
			updateInCompleted(old_next_task, next_task);
			updateInSubjectMap(old_next_task, next_task);
			updateInTaskMap(old_next_task, next_task);
		}
		Database.deleteRecord(t.getId());
	}

	protected static void cancelAlarm(int task_id) {
		scheduleClient.cancelAlarm(task_id);
	}

	protected static void completeTask(int pos) {
		if (prevScreen == 0) {
			Database.completeTask(Upcoming.get(pos).getId());
			Task t = Upcoming.get(pos);
			TaskHolder.remove(Upcoming.get(pos));
			t.setStatus("Completed");
			Completed.add(t);
			Upcoming.remove(pos);
			checkEmpty(Upcoming, prevScreen);
			removeFromTaskMap(genTaskMapKey(t.getDue()), t);
			removeFromSubjectMap(t.getSubject(), t);

		} else {
			Database.completeTask(TaskHolder.get(pos).getId());
			Task temp = TaskHolder.get(pos);
			temp.setStatus("Completed");
			Completed.add(temp);
			TaskHolder.remove(pos);
			checkEmpty(TaskHolder, prevScreen);
			removeFromTaskMap(genTaskMapKey(temp.getDue()), temp);
			removeFromSubjectMap(temp.getSubject(), temp);
		}
		updateAppWidget();
	}

	public static void completeTaskById(int id) {
		if (id == -1) {
			Log.d("ID", "id from widget is -1");
			return;
		}
		int index = findById(TaskHolder, id);
		if (index != -1 && index < TaskHolder.size()) {
			if (prevScreen == 0) {
				int pos = findById(Upcoming, id);
				if (pos != -1 && pos < Upcoming.size()) {
					Log.d("ID", "id found in upcoming");
					Upcoming.remove(pos);

				}
				Task t = TaskHolder.get(index);
				try {
					Main.getScheduleClient().cancelAlarm(t.getId());
					Main.getDatabase().deactivateAlarm(t.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
				TaskHolder.remove(index);
				t.setStatus("Completed");
				Completed.add(t);
				checkEmpty(Upcoming, prevScreen);
				removeFromTaskMap(genTaskMapKey(t.getDue()), t);
				removeFromSubjectMap(t.getSubject(), t);

			} else {
				Task temp = TaskHolder.get(index);
				try {
					Main.getScheduleClient().cancelAlarm(temp.getId());
					Main.getDatabase().deactivateAlarm(temp.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
				temp.setStatus("Completed");
				Completed.add(temp);
				TaskHolder.remove(index);
				checkEmpty(TaskHolder, prevScreen);
				removeFromTaskMap(genTaskMapKey(temp.getDue()), temp);
				removeFromSubjectMap(temp.getSubject(), temp);
			}
			Main.updateListView(true);
		}
	}

	protected static void uncompleteTask(int position) {
		// TODO Auto-generated method stub
		if (Database.uncompleteTask(Completed.get(position).getId())) {

		}
		Task temp = Completed.get(position);
		temp.setStatus("Pending");
		temp.reCalculateDueDays();
		addAndSort(temp);
		Completed.remove(position);
		checkEmpty(Completed, prevScreen);
		updateAppWidget();
	}

	private static void checkEmpty(List<Task> t, int code) {
		if (t.isEmpty()) {
			switch (code) {
			case 2:
				swipelistview.setVisibility(View.GONE);
				notask.setText("No task(s) found");
				notask_notify.setVisibility(View.VISIBLE);
				break;
			case 0:
				swipelistview.setVisibility(View.GONE);
				notask.setText("No task(s) due in the next " + UpcomingDate
						+ " days");
				notask_notify.setVisibility(View.VISIBLE);
				break;
			case 4:
				notask.setText("No completed task(s)");
				notask_notify.setVisibility(View.VISIBLE);
			}
		} else {
			notask_notify.setVisibility(View.GONE);
			swipelistview.setVisibility(View.VISIBLE);
		}
	}

	@SuppressWarnings("deprecation")
	private void initCalendarPage() {
		lastSelectedCalendarDate = Calendar.getInstance().getTime();
		calView = this.inflater.inflate(R.layout.calendar, main_content, false);
		if (caldroidFragment == null) {
			caldroidFragment = new CaldroidFragment();
			Bundle args = new Bundle();
			Calendar cal = Calendar.getInstance();
			args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
			args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
			args.putBoolean(CaldroidFragment.ENABLE_SWIPE, true);
			args.putBoolean(CaldroidFragment.SIX_WEEKS_IN_CALENDAR, true);
			caldroidFragment.setArguments(args);
		}
		caldroidFragment.setBackgroundResourceForDate(R.color.bg_blue, Calendar
				.getInstance().getTime());
		caldroidFragment.setTextColorForDate(R.color.pure_white, Calendar
				.getInstance().getTime());
		info_list = (ListView) calView.findViewById(R.id.info_listview);

		main_content.addView(calView);

		FragmentTransaction t = getSupportFragmentManager().beginTransaction();
		t.replace(R.id.calendar_container, caldroidFragment);
		t.commit();
		tv_calendar_notaskfordate = (TextView) findViewById(R.id.tv_calendar_notaskfordate);
		final CaldroidListener listener = new CaldroidListener() {

			@Override
			public void onSelectDate(Date date, View view) {
				initInfoListForDate(date);
				Calendar c = Calendar.getInstance();
				c.set(Calendar.YEAR, date.getYear() + 1900);
				c.set(Calendar.MONTH, date.getMonth());
				c.set(Calendar.DAY_OF_MONTH, date.getDate());
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);
				Calendar r = Calendar.getInstance();
				r.set(Calendar.YEAR, lastSelectedCalendarDate.getYear() + 1900);
				r.set(Calendar.MONTH, lastSelectedCalendarDate.getMonth());
				r.set(Calendar.DAY_OF_MONTH, lastSelectedCalendarDate.getDate());
				r.set(Calendar.HOUR_OF_DAY, 0);
				r.set(Calendar.MINUTE, 0);
				r.set(Calendar.SECOND, 0);
				r.set(Calendar.MILLISECOND, 0);
				if (c.get(Calendar.MONTH) != currCalendarMonth
						.get(Calendar.MONTH)) {
					caldroidFragment.setBackgroundResourceForDate(
							R.drawable.border_bg, date);
					caldroidFragment.setTextColorForDate(R.color.caldroid_gray,
							date);
				} else {
					if (TaskMap.containsKey(c) && !TaskMap.get(c).isEmpty()) {
						caldroidFragment.setTextColorForDate(
								R.color.pure_white, date);
						caldroidFragment.setBackgroundResourceForDate(
								R.drawable.border_bg_green, date);
					} else {
						caldroidFragment.setBackgroundResourceForDate(
								R.drawable.border_bg, date);
						caldroidFragment.setTextColorForDate(R.color.black,
								date);
					}
				}
				if (r.get(Calendar.MONTH) != currCalendarMonth
						.get(Calendar.MONTH)) {
					caldroidFragment.setBackgroundResourceForDate(
							R.color.pure_white, lastSelectedCalendarDate);
					caldroidFragment.setTextColorForDate(R.color.caldroid_gray,
							lastSelectedCalendarDate);
				} else {
					if (TaskMap.containsKey(r) && !TaskMap.get(r).isEmpty()) {
						caldroidFragment.setTextColorForDate(
								R.color.pure_white, lastSelectedCalendarDate);
						caldroidFragment.setBackgroundResourceForDate(
								R.color.bg_green, lastSelectedCalendarDate);
					} else {
						caldroidFragment.setBackgroundResourceForDate(
								R.color.pure_white, lastSelectedCalendarDate);
						caldroidFragment.setTextColorForDate(R.color.black,
								lastSelectedCalendarDate);
					}
				}

				lastSelectedCalendarDate = new Date(date.getTime());
				caldroidFragment.setBackgroundResourceForDate(R.color.bg_blue,
						Calendar.getInstance().getTime());
				caldroidFragment.setTextColorForDate(R.color.pure_white,
						Calendar.getInstance().getTime());
				caldroidFragment.refreshView();
			}

			@Override
			public void onChangeMonth(int month, int year) {
				month--;
				currCalendarMonth.set(Calendar.MONTH, month);
				currCalendarMonth.set(Calendar.YEAR, year);
				Calendar v = Calendar.getInstance();
				v.set(Calendar.YEAR, lastSelectedCalendarDate.getYear() + 1900);
				v.set(Calendar.MONTH, lastSelectedCalendarDate.getMonth());
				v.set(Calendar.DAY_OF_MONTH, lastSelectedCalendarDate.getDate());
				v.set(Calendar.HOUR_OF_DAY, 0);
				v.set(Calendar.MINUTE, 0);
				v.set(Calendar.SECOND, 0);
				v.set(Calendar.MILLISECOND, 0);
				if (v.get(Calendar.MONTH) != month) {
					caldroidFragment.setBackgroundResourceForDate(
							R.color.pure_white, lastSelectedCalendarDate);
					caldroidFragment.setTextColorForDate(R.color.caldroid_gray,
							lastSelectedCalendarDate);
				} else {
					if (TaskMap.containsKey(v)) {
						caldroidFragment.setTextColorForDate(
								R.color.pure_white, lastSelectedCalendarDate);
						caldroidFragment.setBackgroundResourceForDate(
								R.color.bg_green, lastSelectedCalendarDate);
					} else {
						caldroidFragment.setBackgroundResourceForDate(
								R.color.pure_white, lastSelectedCalendarDate);
						caldroidFragment.setTextColorForDate(R.color.black,
								lastSelectedCalendarDate);
					}
				}
				Calendar k = Calendar.getInstance();
				k.set(Calendar.DAY_OF_MONTH, 1);
				k.set(Calendar.YEAR, year);
				k.set(Calendar.MONTH, month);
				Calendar prev = Calendar.getInstance();
				Calendar nxt = Calendar.getInstance();
				prev.set(Calendar.YEAR, k.get(Calendar.YEAR));
				nxt.set(Calendar.YEAR, k.get(Calendar.YEAR));
				prev.set(Calendar.MONTH, k.get(Calendar.MONTH) - 1);
				nxt.set(Calendar.MONTH, k.get(Calendar.MONTH) + 1);
				prev.set(Calendar.DAY_OF_MONTH, 1);
				int prev_month = prev.get(Calendar.MONTH);
				nxt.set(Calendar.DAY_OF_MONTH, 1);
				int nxt_month = nxt.get(Calendar.MONTH);
				while (k.get(Calendar.MONTH) == month) {
					caldroidFragment.setBackgroundResourceForDate(
							R.color.pure_white, k.getTime());
					caldroidFragment.setTextColorForDate(R.color.black,
							k.getTime());
					k.add(Calendar.DAY_OF_MONTH, 1);
				}
				while (prev.get(Calendar.MONTH) == prev_month) {
					caldroidFragment.setBackgroundResourceForDate(
							R.color.pure_white, prev.getTime());
					caldroidFragment.setTextColorForDate(R.color.caldroid_gray,
							prev.getTime());
					prev.add(Calendar.DAY_OF_MONTH, 1);
				}

				while (nxt.get(Calendar.MONTH) == nxt_month) {
					caldroidFragment.setBackgroundResourceForDate(
							R.color.pure_white, nxt.getTime());
					caldroidFragment.setTextColorForDate(R.color.caldroid_gray,
							nxt.getTime());
					nxt.add(Calendar.DAY_OF_MONTH, 1);
				}
				setCalendarTaskForMonth(month, year);
				Date r = new Date(year - 1900, month, 1, 0, 0, 0);
				if (initInfoListForDate(r)) {
					caldroidFragment.setTextColorForDate(R.color.pure_white, r);
					caldroidFragment.setBackgroundResourceForDate(
							R.drawable.border_bg_green, r);
				} else {
					caldroidFragment.setBackgroundResourceForDate(
							R.drawable.border_bg, r);
					caldroidFragment.setTextColorForDate(R.color.black, r);
				}
				lastSelectedCalendarDate = (Date) r.clone();
				caldroidFragment.setBackgroundResourceForDate(R.color.bg_blue,
						Calendar.getInstance().getTime());
				caldroidFragment.setTextColorForDate(R.color.pure_white,
						Calendar.getInstance().getTime());
				caldroidFragment.refreshView();
			}

			@Override
			public void onLongClickDate(Date date, View view) {
			}

			@Override
			public void onCaldroidViewCreated() {
			}

		};

		caldroidFragment.setCaldroidListener(listener);
		caldroidFragment.setBackgroundResourceForDate(R.color.bg_blue, Calendar
				.getInstance().getTime());
		caldroidFragment.setTextColorForDate(R.color.pure_white, Calendar
				.getInstance().getTime());
		setCalendarTaskForMonth(Calendar.getInstance().get(Calendar.MONTH),
				Calendar.getInstance().get(Calendar.YEAR));
	}

	@Override
	protected void onStop() {
		if (scheduleClient != null)
			scheduleClient.doUnbindService();
		super.onStop();
	}

	private static void setCalendarTaskForMonth(int month, int year) {
		for (Calendar u : TaskMap.keySet()) {
			if (TaskMap.get(u).isEmpty()) {
				continue;
			}
			Calendar t = Calendar.getInstance();
			Calendar v = Calendar.getInstance();
			v.set(Calendar.YEAR, u.get(Calendar.YEAR));
			v.set(Calendar.MONTH, u.get(Calendar.MONTH));
			v.set(Calendar.DAY_OF_MONTH, u.get(Calendar.DAY_OF_MONTH));
			v.set(Calendar.HOUR_OF_DAY, u.get(Calendar.HOUR_OF_DAY));
			v.set(Calendar.MINUTE, u.get(Calendar.MINUTE));
			v.set(Calendar.SECOND, u.get(Calendar.SECOND));
			v.set(Calendar.MILLISECOND, u.get(Calendar.MILLISECOND));
			if (v.get(Calendar.MONTH) == month && v.get(Calendar.YEAR) == year) {
				if (v.get(Calendar.MONTH) == t.get(Calendar.MONTH)
						&& v.get(Calendar.DAY_OF_MONTH) == t
								.get(Calendar.DAY_OF_MONTH)
						&& v.get(Calendar.YEAR) == t.get(Calendar.YEAR)) {
					continue;
				}
				caldroidFragment.setBackgroundResourceForDate(R.color.bg_green,
						v.getTime());
				caldroidFragment.setTextColorForDate(R.color.pure_white,
						v.getTime());
			}
		}

		caldroidFragment.setBackgroundResourceForDate(R.color.bg_blue, Calendar
				.getInstance().getTime());
		caldroidFragment.setTextColorForDate(R.color.pure_white, Calendar
				.getInstance().getTime());

	}

	private static void generateTaskMap(List<Task> l) {
		// go through every item in TaskHolder and add them to hashmap
		Iterator<Task> iterator = l.iterator();
		while (iterator.hasNext()) {
			Task t = iterator.next();
			Calendar key = Calendar.getInstance();
			key.set(Calendar.YEAR, t.getDue().get(Calendar.YEAR));
			key.set(Calendar.MONTH, t.getDue().get(Calendar.MONTH));
			key.set(Calendar.DAY_OF_MONTH, t.getDue()
					.get(Calendar.DAY_OF_MONTH));
			key.set(Calendar.HOUR_OF_DAY, 0);
			key.set(Calendar.MINUTE, 0);
			key.set(Calendar.SECOND, 0);
			key.set(Calendar.MILLISECOND, 0);
			if (!TaskMap.containsKey(key)) {
				List<Task> newlist = new ArrayList<Task>();
				newlist.add(t);
				TaskMap.put(key, newlist);
			} else {
				if (!TaskMap.get(key).contains(t)) {
					List<Task> g = TaskMap.get(key);
					g.add(t);
					TaskMap.put(key, g);
				}
			}
		}
	}

	private static void addToTaskMap(Task t) {
		Calendar key = Calendar.getInstance();
		key.set(Calendar.YEAR, t.getDue().get(Calendar.YEAR));
		key.set(Calendar.MONTH, t.getDue().get(Calendar.MONTH));
		key.set(Calendar.DAY_OF_MONTH, t.getDue().get(Calendar.DAY_OF_MONTH));
		key.set(Calendar.HOUR_OF_DAY, 0);
		key.set(Calendar.MINUTE, 0);
		key.set(Calendar.SECOND, 0);
		key.set(Calendar.MILLISECOND, 0);
		if (!TaskMap.containsKey(key)) {
			List<Task> newlist = new ArrayList<Task>();
			newlist.add(t);
			TaskMap.put(key, newlist);
		} else {
			if (!TaskMap.get(key).contains(t)
					&& findById(TaskMap.get(key), t.getId()) == -1) {
				List<Task> g = TaskMap.get(key);
				g.add(t);
				TaskMap.put(key, g);
			}
		}
	}

	protected static void updateInTaskMap(Task old_t, Task new_t) {
		try{
			if(removeFromTaskMap(genTaskMapKey(old_t.getDue()), old_t))
				addToTaskMap(new_t);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void updateInTaskHolder(Task old_t, Task new_t) {
		if (old_t.getStatus().contentEquals("Completed")
				|| new_t.getStatus().contentEquals("Completed")) {
			return;
		}
		int index = findById(TaskHolder, old_t.getId());
		if (index != -1) {
			TaskHolder.remove(index);
			TaskHolder.add(index, new_t);
		} else {
			Log.d("NOT FOUND", "id " + old_t.getId()
					+ " is not found in TaskHolder");
		}
		int i = findById(Upcoming, old_t.getId());
		if (i != -1) {
			Upcoming.remove(i);
			Upcoming.add(i, new_t);
		}
	}

	private static void updateInSubjectMap(Task old_t, Task new_t) {
		int del_index = findById(SubjectMap.get(old_t.getSubject()),
				old_t.getId());
		if (del_index != -1) {
			List<Task> temp = SubjectMap.get(old_t.getSubject());
			temp.remove(del_index);
			SubjectMap.put(old_t.getSubject(), temp);
			temp = SubjectMap.get(new_t.getSubject());
			temp.add(new_t);
			SubjectMap.put(new_t.getSubject(), temp);
		} else {
			Log.d("NOT FOUND", "id " + old_t.getId()
					+ " is not found in SubjectMap");
		}
	}

	private static void updateInCompleted(Task old_t, Task new_t) {
		if (old_t.getStatus().contentEquals("Pending")
				|| new_t.getStatus().contentEquals("Pending")) {
			return;
		}
		int index = findById(Completed, old_t.getId());
		if (index != -1) {
			Completed.remove(index);
			Completed.add(index, new_t);
		} else {
			Log.d("NOT FOUND", "id " + old_t.getId()
					+ " is not found in Completed");
		}
	}

	protected static boolean removeFromTaskMap(Calendar k, Task object) {
		if (TaskMap.get(k).contains(object)) {
			TaskMap.get(k).remove(object);
			return true;
		} else {
			int index = findById(TaskMap.get(k), object.getId());
			if (index != -1 && index < TaskMap.get(k).size()) {
				TaskMap.get(k).remove(index);
				return true;
			}
			return false;
		}
	}

	protected static void addAndSort(Task t) {
		// everytime we add a new task, we update the TaskHolder
		if (t.getStatus().contentEquals("Completed")) {
			Completed.add(t);
			return;
		}
		TaskHolder.add(t);
		Collections.sort(TaskHolder, new Comparator<Task>() {
			public int compare(Task o1, Task o2) {
				return o1.getDue().compareTo(o2.getDue());
			}
		});
		addToTaskMap(t);
		if (t.getDueDays() <= UpcomingDate && !Upcoming.contains(t)) {
			Upcoming.add(t);
			Collections.sort(Upcoming, new Comparator<Task>() {
				public int compare(Task o1, Task o2) {
					return o1.getDue().compareTo(o2.getDue());
				}
			});
		}
		addToSubjectMap(t);
	}

	@SuppressWarnings("deprecation")
	private static boolean initInfoListForDate(Date date) {
		// TODO Auto-generated method stub
		// find the corresponding list<Task> in the hashmap
		// give this list to the listview
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, date.getYear() + 1900);
		c.set(Calendar.MONTH, date.getMonth());
		c.set(Calendar.DAY_OF_MONTH, date.getDate());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		List<Task> l = TaskMap.get(c);
		if (l == null) {
			tv_calendar_notaskfordate.setVisibility(View.VISIBLE);
			List<Task> i = new ArrayList<Task>();
			info_adapter = new InfoListAdapter(context,
					R.layout.calendar_info_single_row, i);
			info_list.setAdapter(info_adapter);
			info_list.setVisibility(View.GONE);
			return false;
		} else {
			if (!l.isEmpty()) {
				info_list.setVisibility(View.VISIBLE);
				tv_calendar_notaskfordate.setVisibility(View.GONE);
				info_adapter = new InfoListAdapter(context,
						R.layout.calendar_info_single_row, l);
				info_list.setAdapter(info_adapter);
				info_list.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(context, EditTask.class);
						Bundle b = new Bundle();
						b.putInt("id", info_adapter.getId(position));
						intent.putExtra("info", b);
						context.startActivity(intent);
					}
				});
				return true;
			} else {
				info_list.setVisibility(View.GONE);
				tv_calendar_notaskfordate.setVisibility(View.VISIBLE);
				return false;
			}
		}

	}

	protected static Calendar genTaskMapKey(Calendar h) {
		// h .MONTH starts from 1
		Calendar key = Calendar.getInstance();
		key.set(Calendar.YEAR, h.get(Calendar.YEAR));
		key.set(Calendar.MONTH, h.get(Calendar.MONTH));
		key.set(Calendar.DAY_OF_MONTH, h.get(Calendar.DAY_OF_MONTH));
		key.set(Calendar.HOUR_OF_DAY, 0);
		key.set(Calendar.MINUTE, 0);
		key.set(Calendar.SECOND, 0);
		key.set(Calendar.MILLISECOND, 0);

		return key;
	}

	@SuppressWarnings("deprecation")
	protected static void updateListView(boolean terminationCode) {
		// TODO Auto-generated method stub
		if (terminationCode) {
			switch (prevScreen) {
			case 0:
				adapter = new ItemAdapter(context, R.layout.custom_row,
						Upcoming, swipelistview, prefs.getString(
								"Color_scheme", "Default"));
				checkEmpty(Upcoming, 0);
				break;
			case 1:
				subject_adapter.notifyDataSetChanged();
				break;
			case 2:
				adapter = new ItemAdapter(context, R.layout.custom_row,
						TaskHolder, swipelistview, prefs.getString(
								"Color_scheme", "Default"));
				checkEmpty(TaskHolder, 2);
				break;
			case 3:
				Calendar v = Calendar.getInstance();
				v.set(Calendar.YEAR, lastSelectedCalendarDate.getYear() + 1900);
				v.set(Calendar.MONTH, lastSelectedCalendarDate.getMonth());
				v.set(Calendar.DAY_OF_MONTH, lastSelectedCalendarDate.getDate());
				v.set(Calendar.HOUR_OF_DAY, 0);
				v.set(Calendar.MINUTE, 0);
				v.set(Calendar.SECOND, 0);
				v.set(Calendar.MILLISECOND, 0);
				if (v.get(Calendar.MONTH) != currCalendarMonth
						.get(Calendar.MONTH)) {
					caldroidFragment.setBackgroundResourceForDate(
							R.color.pure_white, lastSelectedCalendarDate);
					caldroidFragment.setTextColorForDate(R.color.caldroid_gray,
							lastSelectedCalendarDate);
				} else {
					if (TaskMap.containsKey(v)) {
						caldroidFragment.setTextColorForDate(
								R.color.pure_white, lastSelectedCalendarDate);
						caldroidFragment.setBackgroundResourceForDate(
								R.color.bg_green, lastSelectedCalendarDate);
					} else {
						caldroidFragment.setBackgroundResourceForDate(
								R.color.pure_white, lastSelectedCalendarDate);
						caldroidFragment.setTextColorForDate(R.color.black,
								lastSelectedCalendarDate);
					}
				}
				Calendar k = Calendar.getInstance();
				k.set(Calendar.DAY_OF_MONTH, 1);
				k.set(Calendar.YEAR, currCalendarMonth.get(Calendar.YEAR));
				k.set(Calendar.MONTH, currCalendarMonth.get(Calendar.MONTH));
				Calendar prev = Calendar.getInstance();
				Calendar nxt = Calendar.getInstance();
				prev.set(Calendar.YEAR, k.get(Calendar.YEAR));
				nxt.set(Calendar.YEAR, k.get(Calendar.YEAR));
				prev.set(Calendar.MONTH, k.get(Calendar.MONTH) - 1);
				nxt.set(Calendar.MONTH, k.get(Calendar.MONTH) + 1);
				prev.set(Calendar.DAY_OF_MONTH, 1);
				int prev_month = prev.get(Calendar.MONTH);
				nxt.set(Calendar.DAY_OF_MONTH, 1);
				int nxt_month = nxt.get(Calendar.MONTH);
				while (k.get(Calendar.MONTH) == currCalendarMonth
						.get(Calendar.MONTH)) {
					caldroidFragment.setBackgroundResourceForDate(
							R.color.pure_white, k.getTime());
					caldroidFragment.setTextColorForDate(R.color.black,
							k.getTime());
					k.add(Calendar.DAY_OF_MONTH, 1);
				}
				while (prev.get(Calendar.MONTH) == prev_month) {
					caldroidFragment.setBackgroundResourceForDate(
							R.color.pure_white, prev.getTime());
					caldroidFragment.setTextColorForDate(R.color.caldroid_gray,
							prev.getTime());
					prev.add(Calendar.DAY_OF_MONTH, 1);
				}

				while (nxt.get(Calendar.MONTH) == nxt_month) {
					caldroidFragment.setBackgroundResourceForDate(
							R.color.pure_white, nxt.getTime());
					caldroidFragment.setTextColorForDate(R.color.caldroid_gray,
							nxt.getTime());
					nxt.add(Calendar.DAY_OF_MONTH, 1);
				}
				setCalendarTaskForMonth(currCalendarMonth.get(Calendar.MONTH),
						currCalendarMonth.get(Calendar.YEAR));
				Date r = new Date(currCalendarMonth.get(Calendar.YEAR) - 1900,
						currCalendarMonth.get(Calendar.MONTH), 1, 0, 0, 0);
				if (initInfoListForDate(r)) {
					caldroidFragment.setTextColorForDate(R.color.pure_white, r);
					caldroidFragment.setBackgroundResourceForDate(
							R.drawable.border_bg_green, r);
				} else {
					caldroidFragment.setBackgroundResourceForDate(
							R.drawable.border_bg, r);
					caldroidFragment.setTextColorForDate(R.color.black, r);
				}
				lastSelectedCalendarDate = (Date) r.clone();
				caldroidFragment.setBackgroundResourceForDate(R.color.bg_blue,
						Calendar.getInstance().getTime());
				caldroidFragment.setTextColorForDate(R.color.pure_white,
						Calendar.getInstance().getTime());
				caldroidFragment.refreshView();
				break;
			case 4:
				adapter = new ItemAdapter(context, R.layout.custom_row,
						Completed, swipelistview, prefs.getString(
								"Color_scheme", "Default"));
				checkEmpty(Completed, 4);
				break;
			}
			swipelistview.setAdapter(adapter);
			adapter.notifyDataSetChanged();
		} else {
		}
	}

	protected static void addToSubjectMap(Task t) {

		if (!SubjectMap.containsKey(t.getSubject())) {
			addSubject(t.getSubject());
			List<Task> newlist = new ArrayList<Task>();
			newlist.add(t);
			SubjectMap.put(t.getSubject(), newlist);
		} else {
			if (!SubjectMap.get(t.getSubject()).contains(t)) {
				List<Task> g = SubjectMap.get(t.getSubject());
				g.add(t);
				Collections.sort(g, new Comparator<Task>() {
					public int compare(Task o1, Task o2) {
						return o1.getDue().compareTo(o2.getDue());
					}
				});
				SubjectMap.put(t.getSubject(), g);
			}
		}

	}

	protected static void removeFromSubjectMap(String k, Task object) {
		if (SubjectMap.get(k).contains(object)) {
			SubjectMap.get(k).remove(object);
		} else {
			int index = findById(SubjectMap.get(k), object.getId());
			if (index != -1 && index < SubjectMap.get(k).size()) {
				SubjectMap.get(k).remove(index);
			}
		}
	}

	protected static void addSubject(String new_subject) {
		List<Task> l = new ArrayList<Task>();
		subjectArray.add(new_subject);
		SubjectMap.put(new_subject, l);
		Database.insertSubject(new_subject);
		subject_adapter.notifyDataSetChanged();
	}

	protected static void removeSubject(String subject) {

		subjectArray.remove(subject);
		Database.deleteSubject(subject);
		subject_adapter.notifyDataSetChanged();
	}

	protected static void updateSubject(String Old, String New, int childSize) {
		int i = subjectArray.indexOf(Old);
		subjectArray.remove(Old);
		subjectArray.add(i, New);
		Database.updateSubjectTable(Old, New);
		// need to update all children
		List<Task> temp = SubjectMap.get(Old);
		if (childSize > 0) {
			Iterator<Task> it = temp.iterator();
			while (it.hasNext()) {
				Task t = it.next();
				if (Upcoming.contains(t)) {
					int j = Upcoming.indexOf(t);
					Upcoming.get(j).setSubject(New);
				}
				if (TaskHolder.contains(t)) {
					int j = TaskHolder.indexOf(t);
					TaskHolder.get(j).setSubject(New);
				}
				Database.updateSubject(t.getId(), New);
				Task h = new Task(t.getId(), t.getName(), t.getType(), New,
						t.getDue(), t.getReminders(), t.getNotes(),
						t.getStatus(), t.getLinked(), t.getIndex(),
						t.getInterval(), t.getPreviousTag(), t.getNextTag(),
						t.isAlarmActive());

				updateInTaskMap(t, h);
			}
			SubjectMap.put(New, temp);
			SubjectMap.remove(Old);
		} else {
			SubjectMap.put(New, temp);
			SubjectMap.remove(Old);
		}
		Main.swipelistview.closeOpenedItems();
	}

	protected static int findById(List<Task> list, int id) {
		int index = 0;
		Iterator<Task> it = list.iterator();
		while (it.hasNext()) {
			Task h = it.next();
			if (h.getId() == id) {
				break;
			} else {
				index++;
			}
		}
		if (index >= list.size()) {
			index = -1;
		}
		return index;
	}

	protected static void deleteById(int id, int status) {
		// does not handle database deletion
		if (status == 0) {
			int index = findById(TaskHolder, id);
			int i = findById(Upcoming, id);
			try {
				Task theobject = TaskHolder.remove(index);
				if (Upcoming.contains(theobject)) {
					Upcoming.remove(theobject);
				} else if (i != -1 && i < Upcoming.size()) {
					Upcoming.remove(i);
				}
				removeFromTaskMap(genTaskMapKey(theobject.getDue()), theobject);
				removeFromSubjectMap(theobject.getSubject(), theobject);
				if (theobject.isAlarmActive()) {
					alarmHandler.CancelAlarm(theobject.getId());
				}
			} catch (Exception e) {
				Toast.makeText(context, "Failed to delete task",
						Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}
		} else {
			try {
				Completed.remove(findById(Completed, id));
			} catch (Exception e) {
				Toast.makeText(context, "Failed to delete task",
						Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}
		}
	}

	protected static void clearAll() {
		List<ContentValues> alarms = Database.queryAlarmList();
		for (ContentValues v : alarms) {
			scheduleClient.cancelAlarm(v.getAsInteger("original_id"));
		}
		alarmHandler.cancelAllDisplayingNotifications();
		Upcoming.clear();
		TaskHolder.clear();
		TaskMap.clear();
		SubjectMap.clear();
		subjectArray.clear();
		Database.deleteAll();
		Database.deleteAllSubjects();
		Database.deleteAllAlarms();
		subjectArray.add(DEFAULT_SUBJECT);
		generateSubjectMap();
		generateTaskMap(TaskHolder);
		// updateListView(true);
	}

	protected static void reGenerateUpcoming() {
		// TODO Auto-generated method stub
		Upcoming.clear();
		if (!TaskHolder.isEmpty()) {
			for (Task i : TaskHolder) {
				if (i.getDueDays() <= UpcomingDate) {
					Upcoming.add(i);
				} else {
					break;
				}
			}
			adapter = new ItemAdapter(context, R.layout.custom_row, Upcoming,
					swipelistview, prefs.getString("Color_scheme", "Default"));
			swipelistview.setAdapter(adapter);
			adapter.notifyDataSetChanged();
			checkEmpty(Upcoming, 0);
		}
	}

	public static Context getContext() {
		return context;
	}

	public static ThemeManager getThemeManager() {
		return theme;
	}

	public static void updateAppWidget() {
		Intent intent = new Intent(context, Widget.class);
		intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
		// Use an array and EXTRA_APPWIDGET_IDS instead of
		// AppWidgetManager.EXTRA_APPWIDGET_ID,
		// since it seems the onUpdate() is only fired on that:
		int ids[] = AppWidgetManager.getInstance(context).getAppWidgetIds(
				new ComponentName(context, Widget.class));
		intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
		context.sendBroadcast(intent);
	}

	static class LinkedDeleteThread extends AsyncTask<Task, Void, Void> {

		ProgressDialog progress;

		@Override
		protected Void doInBackground(Task... params) {
			// TODO Auto-generated method stub
			deleteAllLinkedTasks(params[0],
					Util.isCompleted(params[0].getStatus()));
			return null;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			progress = new ProgressDialog(context);
			progress.setIndeterminate(false);
			progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progress.setCancelable(false);
			progress.setTitle(context.getResources().getString(
					R.string.dialog_linked_delete_title));
			progress.setMessage(context.getResources().getString(
					R.string.dialog_linked_delete_msg));
			;
			progress.show();
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			progress.cancel();
			updateListView(true);
			updateAppWidget();
		}

	}

	@SuppressWarnings("deprecation")
	public void initActionBarExtension() {
		actionBarExtensionToggle = (Button) findViewById(R.id.extension_switch);
		actionBarExtensionToggle.setOnClickListener(this);
		addNewSubject = (Button) findViewById(R.id.new_subject_btn);
		addNewSubject.setOnClickListener(this);
		addNewSubject.setVisibility(View.GONE);
		extensionToggleView = (ImageView) findViewById(R.id.extension_switch_view);
		this.extensionToggleView.setBackgroundDrawable(getResources()
				.getDrawable(R.drawable.ic_action_expand));
		extensionToggleView.setVisibility(View.VISIBLE);
		this.extensionToggleContainer = (LinearLayout) findViewById(R.id.extension_switch_container);
		this.extensionContentContainer = (RelativeLayout) findViewById(R.id.extension_content);
		this.extensionContentContainer.setVisibility(View.GONE);
		this.extensionMask = (Button) findViewById(R.id.extension_mask);
		this.extensionMask.setOnClickListener(this);
		this.extensionMask.setVisibility(View.GONE);
		chart = (PieChart) findViewById(R.id.pie_chart);
		chart.setVisibility(View.GONE);
		this.extensionText = (TextView) findViewById(R.id.extension_text);
	}

	private void initChart() {
		// TODO Auto-generated method stub
		if (prevScreen == 2) {
			this.setChartData(TaskHolder);
		} else if (prevScreen == 0) {
			this.setChartData(Upcoming);
		} else if (prevScreen == 4) {
			this.setChartData(Completed);
		}
	}

	private void setChartData(List<Task> list) {
		// TODO Auto-generated method stub
		this.chart.setVisibility(View.VISIBLE);
		this.extensionText.setVisibility(View.VISIBLE);
		ArrayList<Entry> values = new ArrayList<Entry>();
		ArrayList<String> xVals = new ArrayList<String>();
		// IMPORTANT: In a PieChart, no values (Entry) should have the same
		// xIndex (even if from different DataSets), since no values can be
		// drawn above each other.
		int hw = this.getHomeworkCount(list);
		int lab = this.getLabCount(list);
		int exam = this.getExamCount(list);
		int other = this.getOtherCount(list);
		if (prevScreen == 0) {
			this.extensionText.setText("You have "
					+ Util.calcSum(hw, lab, exam, other)
					+ " task(s) due in the next " + UpcomingDate + " days");
		} else if(prevScreen == 4){
			this.extensionText.setText("So far you have completed "+ Util.calcSum(hw, lab, exam, other)+" task(s)");
		}
		else {
			this.extensionText.setText("You have "
					+ Util.calcSum(hw, lab, exam, other)
					+ " task(s) waiting to be completed");
		}
		if (hw != 0) {
			values.add(new Entry((float) hw, 0));
			xVals.add(TaskType.HOMEWORK.getLabel());
		}
		if (lab != 0) {
			values.add(new Entry((float) lab, 1));
			xVals.add(TaskType.LAB.getLabel());
		}
		if (exam != 0) {
			values.add(new Entry((float) exam, 2));
			xVals.add(TaskType.EXAM.getLabel());
		}
		if (other != 0) {
			values.add(new Entry((float) other, 3));
			xVals.add(TaskType.OTHER.getLabel());
		}
		if (xVals.isEmpty()) {
			this.chart.setVisibility(View.GONE);
			if (prevScreen == 4) {
				this.extensionText.setText(getResources().getString(
						R.string.extension_no_completed_task));
			} else {
				this.extensionText.setText(getResources().getString(
						R.string.extension_no_task));
			}
			return;
		}
		PieDataSet set1 = new PieDataSet(values, "");
		set1.setSliceSpace(0f);
		set1.setColors(this.setColorsForChart(hw, lab, exam, other));
		PieData data = new PieData(xVals, set1);
		chart.setCenterText("");
		chart.setHoleRadius(20f);
		chart.setDescription("");
		chart.setDrawYValues(true);
		chart.setDrawCenterText(true);
		chart.setDrawHoleEnabled(true);
		chart.setRotationAngle(0);
		chart.setData(data);
		chart.highlightValues(null);
		chart.setHighlightEnabled(true);
		chart.setClickable(false);
		chart.setDrawXValues(true);
		chart.setRotationEnabled(true);
		chart.setUsePercentValues(false);
		chart.setTransparentCircleRadius(30f);
		chart.animateXY(1500, 1500);
		chart.setDrawLegend(false);
		chart.setNoDataText("");
		chart.setValueFormatter(new ValueFormatter() {

			@Override
			public String getFormattedValue(float value) {
				// TODO Auto-generated method stub
				return String.valueOf((int) value);
			}

		});
		Legend l = chart.getLegend();
		l.setTextColor(getResources().getColor(R.color.pure_white));
		l.setPosition(LegendPosition.RIGHT_OF_CHART);
		l.setXEntrySpace(7f);
		l.setYEntrySpace(5f);
		chart.invalidate();
	}

	private ArrayList<Integer> setColorsForChart(int hw, int lab, int exam,
			int other) {
		ArrayList<Integer> colors = new ArrayList<Integer>();
		if (hw != 0) {
			colors.add(theme.getComboFromName(
					prefs.getString("Color_scheme", "Default")).getHWColor());
		}
		if (lab != 0) {
			colors.add(theme.getComboFromName(
					prefs.getString("Color_scheme", "Default")).getLabColor());
		}
		if (exam != 0) {
			colors.add(theme.getComboFromName(
					prefs.getString("Color_scheme", "Default")).getExamColor());
		}
		if (other != 0) {
			colors.add(theme.getComboFromName(
					prefs.getString("Color_scheme", "Default")).getOtherColor());
		}
		return colors;
	}

	private int getHomeworkCount(List<Task> list) {
		// TODO Auto-generated method stub
		int count = 0;
		Iterator<Task> it = list.iterator();
		while (it.hasNext()) {
			Task t = it.next();
			if (t.getType().contentEquals(TaskType.HOMEWORK.getLabel())) {
				count++;
			}
		}
		return count;
	}

	private int getLabCount(List<Task> list) {
		// TODO Auto-generated method stub
		int count = 0;
		Iterator<Task> it = list.iterator();
		while (it.hasNext()) {
			Task t = it.next();
			if (t.getType().contentEquals(TaskType.LAB.getLabel())) {
				count++;
			}
		}
		return count;
	}

	private int getExamCount(List<Task> list) {
		// TODO Auto-generated method stub
		int count = 0;
		Iterator<Task> it = list.iterator();
		while (it.hasNext()) {
			Task t = it.next();
			if (t.getType().contentEquals(TaskType.EXAM.getLabel())) {
				count++;
			}
		}
		return count;
	}

	private int getOtherCount(List<Task> list) {
		// TODO Auto-generated method stub
		int count = 0;
		Iterator<Task> it = list.iterator();
		while (it.hasNext()) {
			Task t = it.next();
			if (t.getType().contentEquals(TaskType.OTHER.getLabel())) {
				count++;
			}
		}
		return count;
	}

	public void setColorComboForActionBar(String color) {
		this.extensionToggleContainer.setBackgroundColor(theme
				.getColorSchemeFromName(color).getSuperDarkColor());
		this.extensionContentContainer.setBackgroundColor(theme
				.getColorSchemeFromName(color).getDarkerColor());
	}

	public void onActionBarExtensionOpen(int selection) {
		isActionBarExtensionOpen = true;
		this.extensionToggleView.setVisibility(View.GONE);
		this.extensionToggleView.setBackgroundDrawable(getResources()
				.getDrawable(R.drawable.ic_action_collapse));
		this.extensionToggleView.setVisibility(View.VISIBLE);
		this.extensionMask.setVisibility(View.VISIBLE);
		switch (selection) {
		case 0:
			this.extensionContentContainer.setVisibility(View.VISIBLE);
			this.initChart();
			break;
		case 1:
			this.extensionContentContainer.setVisibility(View.VISIBLE);
			this.addNewSubject.setVisibility(View.VISIBLE);
			this.extensionText.setVisibility(View.GONE);
			break;
		case 2:
			this.extensionContentContainer.setVisibility(View.VISIBLE);
			this.initChart();
			break;
		case 3:

			break;
		case 4:
			this.extensionContentContainer.setVisibility(View.VISIBLE);
			this.initChart();
			break;
		default:
			Log.d("ITEMSELECTION", "Screen " + selection + " not found");
		}
	}

	public void onActionBarExtensionClose() {
		isActionBarExtensionOpen = false;
		this.extensionToggleView.setVisibility(View.GONE);
		this.extensionToggleView.setBackgroundDrawable(getResources()
				.getDrawable(R.drawable.ic_action_expand));
		this.extensionToggleView.setVisibility(View.VISIBLE);
		this.addNewSubject.setVisibility(View.GONE);
		this.extensionContentContainer.setVisibility(View.GONE);
		this.extensionMask.setVisibility(View.GONE);
		this.chart.setVisibility(View.GONE);
	}

	public static boolean isActionBarExtensionOpen() {
		return isActionBarExtensionOpen;
	}

	private void showDialogForNewSubject() {
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
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
					public void onClick(DialogInterface dialog, int which) {
						String subject = input.getText().toString();
						if (subject.contentEquals("")) {
							Toast.makeText(context,
									"Subject name cannot be empty",
									Toast.LENGTH_LONG).show();
							return;
						}
						if (!(subjectArray.contains(subject))) {
							addSubject(subject);
							dialog.dismiss();
						} else if (subject.contentEquals(ADD_SUBJECT)) {
							Toast.makeText(context, "Cannot use this name",
									Toast.LENGTH_LONG).show();
							dialog.dismiss();
						} else {
							Toast.makeText(context, "Subject already exists",
									Toast.LENGTH_LONG).show();
							dialog.dismiss();
						}

					}
				});
		// Setting Negative Button
		alertDialog.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						// Write your code here to execute after
						// dialog
						dialog.cancel();
					}
				});
		alertDialog.show();
	}

	public static void updateAdapterTheme(String new_color_name) {
		adapter.setThemeLabel(new_color_name);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		active = true;
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		active = false;
		super.onDestroy();
		unregisterReceiver(dateReceiver);
	}

	public static void updateDueDaysForAll() {
		for (Task t : TaskHolder) {
			t.reCalculateDueDays();
			AlarmHandler.setduedays(t.getDueDays());
		}
		for (Task t : Upcoming) {
			t.reCalculateDueDays();
		}
		adapter.notifyDataSetChanged();
		if (prevScreen == 0) {
			reGenerateUpcoming();
		}
		updateAppWidget();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if (isActionBarExtensionOpen) {
			this.onActionBarExtensionClose();
		}
	}

}
