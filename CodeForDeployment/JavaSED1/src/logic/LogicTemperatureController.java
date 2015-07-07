package logic;

import iotsuite.pubsubmiddleware.PubSubMiddleware;
import android.content.Context;
import iotsuite.semanticmodel.*;
import framework.*;

public class LogicTemperatureController extends TemperatureController {

	public LogicTemperatureController(PubSubMiddleware pubSubM,
			Device deviceInfo, Object ui, Context myContext) {
		super(pubSubM, deviceInfo);
	}

	@Override
	public void onNewtempPref(TempStruct arg) {
		// TODO : write code here.

	}

}