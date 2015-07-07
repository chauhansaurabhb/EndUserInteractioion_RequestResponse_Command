package deviceImpl;

import logic.*;
import framework.*;
import android.app.Application;
import android.content.Context;
import iotsuite.android.localmiddleware.IDataListener;
import iotsuite.android.localmiddleware.PubSubsSensingFramework;

public class AndroidEndUserInteraction  extends Application implements IEndUserInteraction,
		IDataListener {
	
	

	public static ListenerEndUserInteraction listenerOffCommand = null;
	public static ListenerEndUserInteraction listenerSetTempCommand = null;
	public static ListenerEndUserInteraction listenerprofileRequest = null;
	public static PubSubsSensingFramework pubSubSensingFramework;

	public  double temp;
	public static String txtDisplay;
	//private static String temp1;
	

	public AndroidEndUserInteraction(Context context,
			LogicEndUserInteraction obj) {

		// For receiving profile
		pubSubSensingFramework = PubSubsSensingFramework.getInstance();
		pubSubSensingFramework.registerForSensorData(this, "profileResponse");

	}

	@Override
	public void OffGUI(ListenerEndUserInteraction handler) {
		System.out.println("I am OffGUI.......");
		listenerOffCommand = handler;
	}

	@Override
	public void SetTempGUI(ListenerEndUserInteraction handler) {
		System.out.println("I am SetTempGUI.......");

		listenerSetTempCommand = handler;
	}

	@Override
	public void profileGUI(ListenerEndUserInteraction handler) {
		System.out.println("I am profileGUI.......");
		listenerprofileRequest = handler;
	}

	@Override
	public void onDataReceived(String eventName, Object data) {

		System.out
				.println("AndroidEndUserInteraction: Profile Response has been received....");
		TempStruct tempData = (TempStruct) data;
		System.out.println("Temperature Value:" + tempData.gettempValue());
		//temp = tempData.gettempValue();
		txtDisplay = Double.toString(tempData.gettempValue());

	}

	
	
	 
	

}