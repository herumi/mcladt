package com.herumi.mcladt;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView t = (TextView)findViewById(R.id.textView1);
		String s;
		try {
			System.loadLibrary("gnustl_shared");
			System.loadLibrary("crypto");
			System.loadLibrary("ssl");
			System.loadLibrary("gmp");
			System.loadLibrary("gmpxx");
			System.loadLibrary("mcladt");
			s = "OK : " + mclTest();
		} catch (Exception e) {
			s = "ERR : " + e;
		}
		t.setText(s);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public native String mclTest();
}
