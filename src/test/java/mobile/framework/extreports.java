package mobile.framework;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extreports {
	
	public static ExtentReports getreportobject()
	{
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
	ExtentSparkReporter	reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("reportTitle");
	reporter.config().setDocumentTitle("Tabtitle");
	
	ExtentReports extrep = new ExtentReports();
	extrep.attachReporter(reporter);
	extrep.setSystemInfo("Tester", "hoping");
	return extrep;	
	}

}
