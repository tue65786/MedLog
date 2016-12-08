/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author westy
 */
public class MedLogTestRunnerMain {
    public static void main(String[] args) {
		Result result = JUnitCore.runClasses(MedLogUnitTestSuite.class);
		for (Failure failure : result.getFailures()){
			System.out.println(failure.toString());
		}
		int percentPassed = (int)((double)result.getFailureCount()* 100.0 / result.getRunCount());
		      
                System.out.println("com.medlog.webservice.MedLogTestRunnerMain.main()\nTests run: "
				+result.getRunCount()+"("+percentPassed+" % passed)\n"+"Success: "+result.wasSuccessful());
}
}
