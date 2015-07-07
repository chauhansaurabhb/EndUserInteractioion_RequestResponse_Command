package deviceImpl;

import framework.*;

public class JavaSETemperatureSensor implements ITemperatureSensor {

	public JavaSETemperatureSensor() {

	}

	/*
	 * @Override public TempStruct gettempMeasurement(){ return null; }
	 */

	@Override
	public void gettempMeasurement(ListenertempMeasurement handler) {

	}

	@Override
	public boolean isEventDriven() {
		return true;
	}

}