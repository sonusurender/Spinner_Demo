package com.android_spinner_demo;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.android_spinner_demo.R;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	private static Spinner simple_spinner, custom_spinner;
	private static Button submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		setListeners();
	}

	// Initializing all views
	void init() {

		simple_spinner = (Spinner) findViewById(R.id.simple_spinner);

		custom_spinner = (Spinner) findViewById(R.id.custom_spinner);
		submit = (Button) findViewById(R.id.btnSubmit);

		// Loading items to simple spinner
		loadItemstoSimpleSpinner();

		// Loading items to custom spinner
		loadItemstoCustomSpinner();
	}

	// Simple Spinner items loader method
	void loadItemstoSimpleSpinner() {

		// Getting string array from strings.xml
		String[] spinner_items = getResources().getStringArray(
				R.array.simple_spinner_items);

		// List for storing data for spinner
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < spinner_items.length; i++) {
			list.add(spinner_items[i]);
		}

		// Adappter for showing data
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);

		// Setting dropdown view
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// Setting adapter
		simple_spinner.setAdapter(dataAdapter);
	}

	// Cusotm Spinner items loader method
	void loadItemstoCustomSpinner() {

		// String array for texts
		String[] spinner_items = getResources().getStringArray(
				R.array.custom_spinner_items);

		// Integer array for images
		Integer[] spinner_images = { R.drawable.cupcake, R.drawable.donut,
				R.drawable.eclair, R.drawable.froyo, R.drawable.gingerbread,
				R.drawable.honeycomb, R.drawable.icecream };

		// Arrays list for storing string and integer arrays into spinnerdata
		// items
		ArrayList<SpinnerData_Items> list = new ArrayList<SpinnerData_Items>();
		for (int i = 0; i < spinner_items.length; i++) {
			list.add(new SpinnerData_Items(spinner_items[i], spinner_images[i]));
		}

		// Custom adapter for custom spinner
		CustomSpinner_Adapter adapter = new CustomSpinner_Adapter(
				MainActivity.this, list);

		// Setting adapter
		custom_spinner.setAdapter(adapter);
	}

	// Setting listeners
	void setListeners() {

		// Click listener on button
		submit.setOnClickListener(this);

		// Item selected listener
		simple_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				// Showing a toast when item is selected
				Toast.makeText(
						parent.getContext(),
						"On Spinner Item Select : \n"
								+ parent.getItemAtPosition(position).toString(), // Getting
																					// item
																					// from
																					// position
						Toast.LENGTH_SHORT).show();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		custom_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parentView, View v,
					int position, long id) {

				// Getting textView text and showing via toast
				String text = ((TextView) v.findViewById(R.id.text)).getText()
						.toString();

				Toast.makeText(getApplicationContext(), text,
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {

			}

		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSubmit:
			Toast.makeText(

					// Showing a toast on button click for simple spinner
					MainActivity.this,
					"On Button Click : " + "\n"
							+ String.valueOf(simple_spinner.getSelectedItem()), // Get
																				// simple
																				// spinner
																				// item
																				// selected
					Toast.LENGTH_SHORT).show();
			break;

		}

	}

}
