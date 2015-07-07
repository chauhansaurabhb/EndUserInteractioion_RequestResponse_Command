package factory;

import logic.*;
import android.app.Activity;
import deviceImpl.*;
import framework.*;
import iotsuite.common.*;

public class EndUserInteractionFactory {

	public static IEndUserInteraction getEndUserInteractionDriver(
			String nameEndUserInteraction, Activity context,
			LogicEndUserInteraction obj) {

		if (nameEndUserInteraction.equals(GlobalVariable.deviceAndroidType))
			return new AndroidEndUserInteraction(context, obj);

		return null;
	}

}