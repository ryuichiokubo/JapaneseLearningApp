package com.ryuichiokubo.japaneselearningapp;

import java.util.ArrayList;

import android.app.Activity;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

class StoryProvider {
	
	private static final String TAG = "StoryProvider";
	
	private static final int TYPE_MAIN = 1;
	private static final int TYPE_SUB = 2;
	
	private static final String j_sentence = "リュウとケンは%sをしています。";
	private static final String[] j_words = {"旅行"};

	private static final String r_sentence = "Ryu to Ken wa %s o shiteimasu.";
	private static final String[] r_words = {"ryokou"};

	private static final String e_sentence = "Ryu and Ken are %s.";
	private static final String[] e_words = {"traveling"};

	private Activity activity;
	
	ArrayList<TextView> effectViews = new ArrayList<TextView>();
	
	StoryProvider(Activity a) {
		activity = a;
	}
	
	private LinearLayout getOneSentence(String sentence, String[] words, int type) {
		LinearLayout layout = new LinearLayout(activity);
		layout.setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		params.setMargins(0, 2, 0, 0);
		layout.setLayoutParams(params);

		String parts[] = sentence.split("%s");
		int i = 0;

		while (i < parts.length) {
			// text view for other than words
			if (parts[i].length() != 0) {
				TextView tv1 = new TextView(activity);
				tv1.setText(parts[i]);	
				layout.addView(tv1);
		    	Log.i(TAG, "@@@@ added tv1: " + parts[i]);
			}
			
			// text view for words
			if (i < words.length) {
				TextView tv2 = new TextView(activity);
				tv2.setText(words[i]);
				if (type == TYPE_MAIN) {
					tv2.setBackgroundColor(0x66b7d9ed);
					tv2.setOnClickListener((OnClickListener) activity);
				} else {
					effectViews.add(tv2);					
				}
				layout.addView(tv2);
		    	Log.i(TAG, "@@@@ added tv2: " + words[i]);
			}
			
			i++;
		}
		
		return layout;
	}
	
	protected LinearLayout getTextComponent() {
		LinearLayout layout = new LinearLayout(activity);
		layout.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		params.setMargins(0, 34, 0, 0);
		layout.setLayoutParams(params);

		layout.addView(getOneSentence(j_sentence, j_words, TYPE_MAIN));
		layout.addView(getOneSentence(r_sentence, r_words, TYPE_SUB));
		layout.addView(getOneSentence(e_sentence, e_words, TYPE_SUB));
		
		return layout;
	}
}
