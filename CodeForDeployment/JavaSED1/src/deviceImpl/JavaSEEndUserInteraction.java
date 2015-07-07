package deviceImpl;

import logic.*;
import framework.*;
import android.content.Context;

public class JavaSEEndUserInteraction implements IEndUserInteraction {

	private ListenerEndUserInteraction listenerOffCommand = null;

	private ListenerEndUserInteraction listenerSetTempCommand = null;

	private ListenerEndUserInteraction listenerprofileRequest = null;

	public JavaSEEndUserInteraction(Context context, LogicEndUserInteraction obj) {

	}

	@Override
	public void OffGUI(ListenerEndUserInteraction handler) {
		listenerOffCommand = handler;
	}

	@Override
	public void SetTempGUI(ListenerEndUserInteraction handler) {
		listenerSetTempCommand = handler;
	}

	@Override
	public void profileGUI(ListenerEndUserInteraction handler) {
		listenerprofileRequest = handler;
	}

	public void profileResponseReceived(TempStruct response) {

	}

}