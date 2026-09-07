package LearnFramework.BaseTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//This is used for retry the failed test case

public class Retry implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		 int count=0;
		 int maxtry=1;
		if(count<maxtry)
		{
			count++;
			return true;
			
		}
		return false;
	}

}
