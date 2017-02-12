package com.herumi.mcladt;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.herumi.mcl.*;

public class MainActivity extends Activity {

	public String BLSsignature()
	{
		Bn256.SystemInit();

		String xa = "12723517038133731887338407189719511622662176727675373276651903807414909099441";
		String xb = "4168783608814932154536427934509895782246573715297911553964171371032945126671";
		String ya = "13891744915211034074451795021214165905772212241412891944830863846330766296736";
		String yb = "7937318970632701341203597196594272556916396164729705624521405069090520231616";

		G2 Q = new G2(xa, xb, ya, yb);

		String out = "";
		Fr s = new Fr();
		s.setRand(); // secret key
		out += "secret key " + s + "\n";
		G2 pub = new G2();
		Bn256.mul(pub, Q, s); // public key = sQ

		String m = "signature test";
		G1 H = new G1();
		H.hashAndMapToG1(m); // H = Hash(m)
		G1 sign = new G1();
		Bn256.mul(sign, H, s); // signature of m = s H

		GT e1 = new GT();
		GT e2 = new GT();
		Bn256.pairing(e1, H, pub); // e1 = e(H, s Q)
		Bn256.pairing(e2, sign, Q); // e2 = e(s H, Q);
		if (e1.equals(e2)) {
			out += "BLS signature ok";
		} else {
			out += "BLS signature ng";
		}
		return out;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView t = (TextView)findViewById(R.id.textView1);
		String s = "start\n";
		try {
			System.loadLibrary("gnustl_shared");
			System.loadLibrary("gmp");
			System.loadLibrary("gmpxx");

			System.loadLibrary("mcl_bn256");
			s += BLSsignature();

			System.loadLibrary("mcladt");
			s += mclTest();

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
