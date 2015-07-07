package framework;

public abstract interface IEndUserInteraction {

	public abstract void OffGUI(ListenerEndUserInteraction handler);

	public abstract void SetTempGUI(ListenerEndUserInteraction handler);

	public abstract void profileGUI(ListenerEndUserInteraction handler);

}