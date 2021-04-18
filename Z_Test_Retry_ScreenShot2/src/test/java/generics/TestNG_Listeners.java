package generics;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import BasicGoogleTest.Base;

public class TestNG_Listeners extends Base implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		System.out.println(("Listners:"+result.getTestClass()+"--->Starting execution for method= "+result.getName()));
		
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println(("Listners:"+result.getTestClass()+"--->Execution passed for method= "+result.getName()));
		
	}

	
	public void onTestFailure(ITestResult result) {
		System.out.println(("Listners:"+result.getTestClass()+"--->Execution failed for method= "+result.getName()+" -->Exception= " +result.getThrowable()));
		//Take screenshot
				Screenshots sc=new Screenshots(driver);
				sc.TakeSnapOnFailure();
		
			}

	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Listners:"+result.getTestClass()+"--->Execution skipped for method= "+result.getName());
		
	}

	
	public void onStart(ITestContext context) {
		System.out.println("Listners:onStart= "+context.getName());
		
	}

	
	public void onFinish(ITestContext context) {
		System.out.println("Listners:onfinish = "+context.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
