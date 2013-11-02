package com.ryuichiokubo.japaneselearningapp;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class StoryActivity extends Activity implements OnClickListener {

	private static final String TAG = "StoryActivity";
	
	private StoryProvider provider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_story);
		// Show the Up button in the action bar.
		setupActionBar();
		
	    LinearLayout storyContainer = (LinearLayout)findViewById(R.id.storyContents);
	    provider = new StoryProvider(this);
	    storyContainer.addView(provider.getTextComponent());
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.story, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
    	Log.i(TAG, "@@@@ click" + v.getId());
    	for (TextView view: provider.effectViews) {
    		view.setBackgroundColor(0x66ff0000);
    	}
	}

}
