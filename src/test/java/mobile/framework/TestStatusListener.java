package mobile.framework;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class TestStatusListener extends CommonMethodsAndAssertions implements ITestListener{
	
	ExtentReports extrep = extreports.getreportobject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String name = result.getMethod().getMethodName();
		 test = extrep.createTest(name);
		 extenttest.set(test);
	}
	
	public void onTestFailure(ITestResult result) {
		
		extenttest.get().fail(result.getThrowable());
		String methodname = result.getMethod().getMethodName();
		try {
			String dest=takeScreenshot(result.getName()+"_Failure");
			extenttest.get().addScreenCaptureFromPath(dest, methodname);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onTestSuccess(ITestResult result) {
		
		extenttest.get().log(Status.PASS, "Test success");
		String methodname = result.getMethod().getMethodName();
		if (methodname.contains("API"))
		{
		String outout = result.toString();
		System.out.println(outout);
		test.info(outout);
		}
		try {
			String dest=takeScreenshot(result.getName()+"_Success");
			extenttest.get().addScreenCaptureFromPath(dest, methodname);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extrep.flush();
	}

}
