package ej.listner;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class suite_listener implements ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("suite started");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("suite ended");
		
	}

}
