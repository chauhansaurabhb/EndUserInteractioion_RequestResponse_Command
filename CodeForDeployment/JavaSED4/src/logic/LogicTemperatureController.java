package logic;

import iotsuite.pubsubmiddleware.PubSubMiddleware;
import android.content.Context;
import iotsuite.semanticmodel.*;
import framework.*;

public class LogicTemperatureController extends TemperatureController {
	private double tempValue;
	
	public LogicTemperatureController(PubSubMiddleware pubSubM,
			Device deviceInfo, Object ui, Context myContext) {
		super(pubSubM, deviceInfo);
	}

	@Override
	public void onNewtempPref(TempStruct arg) {
		// TODO : write code here.    	tempValue=arg.gettempValue();
    	if(tempValue==-100)
    	{
    		Off();
    	}
    
    	else
    	{
    		System.out.println("I am in Logic Temperature"+arg.gettempValue());
    		TempStruct tempStruct=new TempStruct(arg.gettempValue(), arg.getunitOfMeasurement());
    		SetTemp(tempStruct);
    	}
    	
	}

}