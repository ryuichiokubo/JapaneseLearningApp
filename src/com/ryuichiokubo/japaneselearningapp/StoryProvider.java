package com.ryuichiokubo.japaneselearningapp;

import android.app.Activity;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

class StoryProvider {
	
	private static final String TAG = "StoryProvider";
	
	private static final String sentence = "%sとケンは%sをしています。";
	private static final String[] words = {"リュウ","旅行"};

	public StoryProvider() {

	}
	
	protected static String getFullSentence() {
		int i = 0;
		String s = sentence;
		while (i < words.length) {
			s = s.replaceFirst("%s", words[i]);
			i++;
		}
		return s;
	}
	
	protected static LinearLayout getTextComponent(Activity a) {
		LinearLayout layout = new LinearLayout(a);
		String parts[] = sentence.split("%s");
		int i = 0;

		while (i < parts.length) {
			// text view for other than words
			if (parts[i].length() != 0) {
				TextView tv1 = new TextView(a);
				tv1.setText(parts[i]);	
				layout.addView(tv1);
		    	Log.i(TAG, "@@@@ added tv1: " + parts[i]);
			}
			
			// text view for words
			if (i < words.length) {
				TextView tv2 = new TextView(a);
				tv2.setText(words[i]);
				tv2.setBackgroundColor(0x66b7d9ed);
				tv2.setOnClickListener((OnClickListener) a);
				layout.addView(tv2);
		    	Log.i(TAG, "@@@@ added tv2: " + words[i]);
			}
			
			i++;
		}
		
		return layout;
	}
}
