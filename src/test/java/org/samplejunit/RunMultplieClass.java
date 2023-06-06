package org.samplejunit;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Samplw.class, Samplw2.class, Samplw3.class })
public class RunMultplieClass {

	public static void main(String[] args) {
		Result r = JUnitCore.runClasses(Samplw.class, Samplw2.class, Samplw3.class);

		// To get Run cout
		int runCount = r.getRunCount();
		System.out.println(runCount);
		// to get ignore count
		int ignoreCount = r.getIgnoreCount();
		System.out.println(ignoreCount);
		// to get Failure COunt
		int failureCount = r.getFailureCount();
		System.out.println(failureCount);
		// to get failer Method name
		List<Failure> failures = r.getFailures();

		for (int i = 0; i < failures.size(); i++) {
			Failure failure = failures.get(i);
			System.out.println(failure);
		}

	}
}
