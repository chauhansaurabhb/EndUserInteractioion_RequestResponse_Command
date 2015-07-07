package deviceImpl;

import framework.*;

public class JavaSEBadgeReader implements IBadgeReader {

	public JavaSEBadgeReader() {

	}

	/*
	 * @Override public BadgeStruct getbadgeDetected(){ return null; }
	 */

	@Override
	public void getbadgeDetected(ListenerbadgeDetected handler) {

	}

	/*
	 * @Override public BadgeStruct getbadgeDisappeared(){ return null; }
	 */

	@Override
	public void getbadgeDisappeared(ListenerbadgeDisappeared handler) {

	}

	@Override
	public boolean isEventDriven() {
		return true;
	}

}