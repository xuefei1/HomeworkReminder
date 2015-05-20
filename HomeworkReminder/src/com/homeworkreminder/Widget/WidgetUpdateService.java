package com.homeworkreminder.Widget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.homeworkreminder.CoreDatabase;
import com.homeworkreminder.R;
import com.homeworkreminder.Task;
import com.homeworkreminder.Util;
import com.homeworkreminder.Theme.ColorScheme;
import com.homeworkreminder.Theme.ThemeManager;

public class WidgetUpdateService extends RemoteViewsService {

	@Override
	public RemoteViewsFactory onGetViewFactory(Intent intent) {
		return new WidgetRemoteViewsFactory(this.getApplicationContext(),
				intent);
	}

	class WidgetRemoteViewsFactory implements
			RemoteViewsService.RemoteViewsFactory {
		private int count = 0;
		private Context context;
		private int appWidgetId;
		private SharedPreferences prefs;
		private CoreDatabase db;
		private ArrayList<Task> upcoming = new ArrayList<Task>();

		public WidgetRemoteViewsFactory(Context context, Intent intent) {
			this.context = context;
			this.appWidgetId = intent.getIntExtra(
					AppWidgetManager.EXTRA_APPWIDGET_ID,
					AppWidgetManager.INVALID_APPWIDGET_ID);
			this.prefs = PreferenceManager.getDefaultSharedPreferences(context);
		}

		public void onCreate() {
			// In onCreate() you setup any connections / cursors to your data
			// source. Heavy lifting,
			// for example downloading or creating content etc, should be
			// deferred to onDataSetChanged()
			// or getViewAt(). Taking more than 20 seconds in this call will
			// result in an ANR.
			upcoming.clear();
			this.db = new CoreDatabase(this.context);
			List<Task> all = db.getAllTask(context.getResources().getString(
					R.string.task_pending));
			Iterator<Task> it = all.iterator();
			while (it.hasNext()) {
				Task t = it.next();
				if (Util.calculateDueDays(t.getDue()) <= Integer.parseInt(prefs
						.getString("Upcoming_date", "7"))) {
					this.upcoming.add(t);
				}
			}
			Collections.sort(upcoming, new Comparator<Task>() {
				public int compare(Task o1, Task o2) {
					return o1.getDue().compareTo(o2.getDue());
				}
			});
			this.count = upcoming.size();

		}

		@Override
		public void onDataSetChanged() {
			// TODO Auto-generated method stub
			upcoming.clear();
			List<Task> all = db.getAllTask(context.getResources().getString(
					R.string.task_pending));
			Iterator<Task> it = all.iterator();
			while (it.hasNext()) {
				Task t = it.next();
				if (Util.calculateDueDays(t.getDue()) <= Integer.parseInt(prefs
						.getString("Upcoming_date", "7"))) {
					this.upcoming.add(t);
				}
			}
			Collections.sort(upcoming, new Comparator<Task>() {
				public int compare(Task o1, Task o2) {
					return o1.getDue().compareTo(o2.getDue());
				}
			});
			this.count = upcoming.size();
		}

		@Override
		public void onDestroy() {
			// TODO Auto-generated method stub
			upcoming.clear();
			this.db = null;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return this.count;
		}

		@Override
		public RemoteViews getViewAt(int position) {
			// TODO Auto-generated method stub
			// position will always range from 0 to getCount() - 1.
			// We construct a remote views item based on our widget item xml
			// file,
			// and set the
			// text based on the position.
			final RemoteViews rv = new RemoteViews(context.getPackageName(),
					R.layout.widget_listview_row);
			rv.setTextViewText(R.id.widget_tv_taskname, upcoming.get(position)
					.getName());
			rv.setTextColor(R.id.widget_tv_taskname, context.getResources().getColor(R.color.pure_white));
			int due_days = Util.calculateDueDays(upcoming.get(position)
					.getDue());
			rv.setTextColor(R.id.widget_tv_due, context.getResources()
						.getColor(R.color.pure_white));
			rv.setTextViewText(R.id.widget_tv_due,
					Util.generateDueDaysString(due_days));
			Bundle extras = new Bundle();
			extras.putInt("position", position);
			extras.putInt("id", upcoming.get(position).getId());
			Intent fillInIntent = new Intent(context, Widget.class);
			fillInIntent.setAction("complete");
			fillInIntent.putExtras(extras);
			// Make it possible to distinguish the individual on-click
			// action of a given item
			rv.setOnClickFillInIntent(R.id.widget_complete_btn, fillInIntent);
			return rv;
		}

		@Override
		public RemoteViews getLoadingView() {
			// TODO Auto-generated method stub
			// You can create a custom loading view (for instance when
			// getViewAt()
			// is slow.) If you
			// return null here, you will get the default loading view
			return null;
		}

		@Override
		public int getViewTypeCount() {
			// TODO Auto-generated method stub
			return 1;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return upcoming.get(position).getId();
		}

		@Override
		public boolean hasStableIds() {
			// TODO Auto-generated method stub
			return false;
		}
	}

}
