package test;

import junit.framework.Test;
import junit.framework.TestSuite;
/*
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
*/
public class AllTests {
	public static Test suite() {
			TestSuite suite = new TestSuite("Tous les tests");
			suite.addTestSuite(testDaysModel.class);
			suite.addTestSuite(testCalendarContent.class);
			suite.addTestSuite(testExceptionFunction.class);
			return suite;
		}
	
	
	public static void main(String args[]) {
			junit.textui.TestRunner.run(suite());
		}
}
