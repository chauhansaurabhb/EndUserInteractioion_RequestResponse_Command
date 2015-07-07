package logic;

import iotsuite.pubsubmiddleware.PubSubMiddleware;
import iotsuite.android.localmiddleware.PubSubsSensingFramework;
import android.app.Activity;
import iotsuite.semanticmodel.*;
import framework.*;
import android.content.Context;
import factory.*;

public class LogicEndUserInteraction extends EndUserInteraction {

	IEndUserInteraction objEndUserInteraction;
	Activity ui;
	public LogicEndUserInteraction obj = this;
	public String deviceType;
	public static PubSubsSensingFramework pubSubSensingFramework;

	public LogicEndUserInteraction(PubSubMiddleware myPubSubMiddleware,
			final Device deviceInfo, final Object ui, Context myContext) {
		super(myPubSubMiddleware, deviceInfo);

		deviceType = deviceInfo.getType();

		pubSubSensingFramework = PubSubsSensingFramework.getInstance();

		this.ui = (Activity) ui;
		this.ui.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				objEndUserInteraction = EndUserInteractionFactory
						.getEndUserInteractionDriver(deviceInfo.getType(),
								(Activity) ui, obj);

				objEndUserInteraction.OffGUI(handlerCommand);

				objEndUserInteraction.SetTempGUI(handlerCommand);

				objEndUserInteraction.profileGUI(handlerCommand);

			}
		});

	}

	ListenerEndUserInteraction handlerCommand = new ListenerEndUserInteraction() {

		@Override
		public void onNewOffCommand() {
			System.out.println("I am in Off() Command ....");
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

		System.out
				.println("I am in LogicEndUserInteraction... Profile has been received");
		pubSubSensingFramework.publish("profileResponse", arg);

	}

}