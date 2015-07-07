package logic;

import iotsuite.pubsubmiddleware.*;
import iotsuite.common.GlobalVariable;
import android.content.Context;
import iotsuite.semanticmodel.*;
import android.app.Activity;
import framework.*;
import factory.*;

public class LogicBadgeReader extends BadgeReader {

	IBadgeReader objBadgeReader;
	Activity ui;
	public LogicBadgeReader obj = this;
	Device deviceInfo;
	public String deviceType;

	public LogicBadgeReader(PubSubMiddleware pubSubM, final Device deviceInfo,
			final Object ui, Context myContext) {
		super(pubSubM, deviceInfo);

		deviceType = deviceInfo.getType();

		if (deviceType.equals(GlobalVariable.deviceJAVASEType)) {

			IBadgeReader objBadgeReader = BadgeReaderFactory.getBadgeReader(
					myDeviceInfo.getType(), null, null);

			if (objBadgeReader.isEventDriven()) {

				objBadgeReader.getbadgeDetected(badgeDetectedEvent);

				objBadgeReader.getbadgeDisappeared(badgeDisappearedEvent);

			} else {

				objBadgeReader.getbadgeDetected(badgeDetectedEvent);

				objBadgeReader.getbadgeDisappeared(badgeDisappearedEvent);

			}

		} else {

			this.ui = (Activity) ui;
			this.ui.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					objBadgeReader = BadgeReaderFactory.getBadgeReader(
							deviceInfo.getType(), (Activity) ui, obj);

					if (objBadgeReader.isEventDriven()) {

						objBadgeReader.getbadgeDetected(badgeDetectedEvent);

						objBadgeReader
								.getbadgeDisappeared(badgeDisappearedEvent);

					} else {

						objBadgeReader.getbadgeDetected(badgeDetectedEvent);

						objBadgeReader
								.getbadgeDisappeared(badgeDisappearedEvent);

					}

				}
			});
		}

	}

	ListenerbadgeDetected badgeDetectedEvent = new ListenerbadgeDetected() {

		@Override
		public void onNewbadgeDetected(BadgeStruct response) {

			BadgeStruct sBadgeStruct = new BadgeStruct(response.getbadgeID(),
					response.getbadgeEvent());
			setbadgeDetected(sBadgeStruct);
		}

	};

	ListenerbadgeDisappeared badgeDisappearedEvent = new ListenerbadgeDisappeared() {

		@Override
		public void onNewbadgeDisappeared(BadgeStruct response) {

			BadgeStruct sBadgeStruct = new BadgeStruct(response.getbadgeID(),
					response.getbadgeEvent());
			setbadgeDisappeared(sBadgeStruct);
		}

	};

}