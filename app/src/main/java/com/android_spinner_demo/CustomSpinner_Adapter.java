package com.android_spinner_demo;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android_spinner_demo.R;

public class CustomSpinner_Adapter extends BaseAdapter {
	private ArrayList<SpinnerData_Items> arrayList;
	LayoutInflater inflater;
	ViewHolder holder = null;

	public CustomSpinner_Adapter(Context context,
			ArrayList<SpinnerData_Items> arrayList) {
		this.arrayList = arrayList;
		this.inflater = LayoutInflater.from(context);

	}

	@Override
	public int getCount() {

		// Array list size
		return arrayList.size();
	}

	@Override
	public SpinnerData_Items getItem(int pos) {

		return arrayList.get(pos);
	}

	@Override
	public long getItemId(int pos) {

		return pos;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {

		if (view == null) {
			view = inflater.inflate(R.layout.custom_spinner_layout, parent,
					false);
			holder = new ViewHolder();
			holder.text = (TextView) view.findViewById(R.id.text);
			holder.imageView = (ImageView) view.findViewById(R.id.image);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		// Setting text and image
		holder.text.setText(arrayList.get(position).getText());
		holder.imageView.setBackgroundResource(arrayList.get(position)
				.getImage());

		return view;
	}

	// Viewholder for holding the views
	public class ViewHolder {
		TextView text;
		ImageView imageView;
	}

}
