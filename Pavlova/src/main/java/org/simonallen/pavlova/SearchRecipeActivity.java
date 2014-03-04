package org.simonallen.pavlova;

import android.app.ListActivity;
import android.widget.SimpleAdapter;
import android.os.Bundle;
import android.content.Intent;
import android.app.SearchManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by simon on 24/11/2013.
 */
public class SearchRecipeActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("CUTTHECRAP", "STARTED");
		handleIntent(getIntent());
	}

	@Override
	protected void onNewIntent(Intent intent) {
		setIntent(intent);
		handleIntent(intent);
		Log.d("CUTTHECRAP", "newintent");
	}

	private void handleIntent(Intent intent) {

		if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
			String query = intent.getStringExtra(SearchManager.QUERY);
			//use the query to search your data somehow
			Log.d("CUTTHECRAP", query);

			String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
					"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
					"Linux", "OS/2" };

			ArrayList<HashMap<String, String>> results = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> result = new HashMap<String, String>();

			result.put("name", "Recipe 1");
			result.put("desc", "Recipe desc");

			results.add(result);

			// use your own layout
			SimpleAdapter adapter = new SimpleAdapter(this, results,
					R.layout.recipe_search_list_layout, new String[] {"name", "desc"}, new int[] {R.id.recipe_search_result_name, R.id.recipe_search_result_desc});
			setListAdapter(adapter);
			//Log.d("Pavlova", getFilesDir().getAbsolutePath());
		}
	}
}
