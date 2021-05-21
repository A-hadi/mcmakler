package mcmakler.test.base;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class listeners implements ITestListener  {
	MainDriver listenDriver =new MainDriver();
	
	public static String TEST_NAME;
	
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		//hey i am done


	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		//
		

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		 String[] strPathArray = {result.getInstanceName(),result.getName()};

		//screenshot
		try {
			listenDriver.getScreenshot(strPathArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		TEST_NAME = result.getInstanceName() +" "+ result.getName();
		System.out.println("------------------------ "+TEST_NAME +" ------------------------");


	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub


	}

}
