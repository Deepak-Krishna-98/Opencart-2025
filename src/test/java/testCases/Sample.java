package testCases;

import org.testng.annotations.Test;

public class Sample  {
	
	
	@Test(priority=1)
	
	void openapp() {
		System.out.println("Test Run Sucessfully");	}
	@Test
	
    void pauseapp() {
	 System.out.println("Paused");
 }
	@Test
	
	 void closeapp() {
		System.out.println(" Test closed");
		
	}
}
