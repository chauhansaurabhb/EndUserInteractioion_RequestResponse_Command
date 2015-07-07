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

		if (nameEndUserInteraction.equals(GlobalVariable.deviceJAVASEType))
			return new JavaSEEndUserInteraction(context, obj);

		return null;
	}

}