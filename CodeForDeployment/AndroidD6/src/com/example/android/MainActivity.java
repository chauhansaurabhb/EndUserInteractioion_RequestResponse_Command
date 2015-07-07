package com.example.android;

import iotsuite.android.localmiddleware.IDataListener;
import iotsuite.android.localmiddleware.PubSubsSensingFramework;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.R;

import framework.TempStruct;

public class MainActivity extends Activity implements IDataListener {

	public static PubSubsSensingFramework pubSubSensingFramework;
	String message;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		new sim.deviceD6.Startup().startDevice(this,
				this.getApplicationContext());

		pubSubSensingFramework = PubSubsSensingFramework.getInstance();
		pubSubSensingFramework.registerForSensorData(this, "profileResponse");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void sendMessage(View view) {

		// pubSubSensingFramework = PubSubsSensingFramework.getInstance();
		// pubSubSensingFramework.registerForSensorData(this,
		// "profileResponse");
		// deviceImpl.AndroidEndUserInteraction.listenerOffCommand
		// .onNewOffCommand();

		// double value = Double.parseDouble(message);
		// deviceImpl.AndroidEndUserInteraction.listenerSetTempCommand.onNewSetTempCommand(new
		// TempStruct);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		message = editText.getText().toString();
		deviceImpl.AndroidEndUserInteraction.listenerprofileRequest
				.onNewprofileRequest(message);

		// System.out.println("I am in Main Activity");

		// TextView tv = (TextView) findViewById(R.id.textView1);

		// System.out.println("Again in Main Activity");

		// System.out.println("I am in Android Main Activity" +
		// AndroidEndUserInteraction.txtDisplay);

		// tv.setText(AndroidEndUserInteraction.txtDisplay);
	}

	public void OffHeater(View view) {

		deviceImpl.AndroidEndUserInteraction.listenerOffCommand
				.onNewOffCommand();
	}

	public void setTemp(View view) {

		EditText e1 = (EditText) findViewById(R.id.edit_temp);
		String message = e1.getText().toString();
		Double value = Double.parseDouble(message);
		deviceImpl.AndroidEndUserInteraction.listenerSetTempCommand
				.onNewSetTempCommand(new TempStruct(value, "C"));

	}

	@Override
	public void onDataReceived(String eventName, Object data) {
		System.out
				.println("AndroidEndUserInteraction: Profile Response has been received....");
		TempStruct tempData = (TempStruct) data;
		System.out.println("Temperature Value:" + tempData.gettempValue());
		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setText(Double.toString(tempData.gettempValue()));

	}

}
