package logic;

import iotsuite.common.GlobalVariable;
import iotsuite.pubsubmiddleware.PubSubMiddleware;
import android.app.Activity;
import iotsuite.semanticmodel.*;
import framework.*;
import factory.*;
import deviceImpl.*;

public class LogicEndUserInteraction extends EndUserInteraction {

	IEndUserInteraction objEndUserInteraction;
	Activity ui;
	public LogicEndUserInteraction obj = this;
	public String deviceType;
	JavaSEEndUserInteraction objJavaSEEndUserInteraction = null;

	public LogicEndUserInteraction(PubSubMiddleware myPubSubMiddleware,
			final Device deviceInfo, final Object ui) {
		super(myPubSubMiddleware, deviceInfo);
		deviceType = deviceInfo.getType();

		if (deviceType.equals(GlobalVariable.deviceJAVASEType)) {

			objEndUserInteraction = EndUserInteractionFactory
					.getEndUserInteractionDriver(deviceInfo.getType(),
							(Activity) ui, obj);

			objEndUserInteraction.OffGUI(handlerCommand);

			objEndUserInteraction.SetTempGUI(handlerCommand);

			objEndUserInteraction.profileGUI(handlerCommand);

		}

	}

	ListenerEndUserInteraction handlerCommand = new ListenerEndUserInteraction() {

		@Override
		public void onNewOffCommand() {
			OffFromGUI();
		}

		@Override
		public void onNewSetTempCommand(TempStruct newValue) {
			SetTempFromGUI(newValue);
		}

		@Override
		public void onNewprofileRequest(String request) {
			profileRequest(request);
		}

	};

	@Override
	public void onNewprofileResponse(TempStruct arg) {
		objJavaSEEndUserInteraction.profileResponseReceived(arg);

	}
}