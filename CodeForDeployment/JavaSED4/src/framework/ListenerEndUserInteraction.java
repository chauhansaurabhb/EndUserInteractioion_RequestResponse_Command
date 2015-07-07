package framework;

public abstract class ListenerEndUserInteraction {

	public abstract void onNewOffCommand();

	public abstract void onNewSetTempCommand(TempStruct newValue);

	public abstract void onNewprofileRequest(String request);

}