package logic;

import iotsuite.pubsubmiddleware.PubSubMiddleware;
import android.content.Context;
import iotsuite.semanticmodel.*;
import framework.*;

public class LogicProximity extends Proximity {

	private double tempPreference = 0;
	private String userProfile;
	private boolean responseArrived = false;
	private boolean continueFlag = false;

	public LogicProximity(PubSubMiddleware pubSubM, Device deviceInfo,
			Object ui, Context myContext) {
		super(pubSubM, deviceInfo);
	}

	@Override
	public void onNewbadgeDetected(BadgeStruct arg) {
		// TODO : write code here.
		userProfile = arg.getbadgeID();
		getprofile(userProfile);
	}

	@Override
	public void onNewprofileReceived(TempStruct arg) {
		// TODO : write code here
		System.out.println("I am in Logic Proximity"+arg.gettempValue());
		tempPreference = arg.gettempValue();
		TempStruct tempStruct = new TempStruct(tempPreference, "C");
		settempPref(tempStruct);
	}

	@Override
	public void onNewbadgeDisappeared(BadgeStruct arg) {
		TempStruct tempStruct = new TempStruct(-100, "C");
		settempPref(tempStruct);
	}

}