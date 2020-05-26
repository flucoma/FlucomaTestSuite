//This will run the tests for all classes inheriting from FlucomaUnitTest,
//and output the result to a log text file
FlucomaTestSuite {

	//Should conditions be used here instead?
	*runAll {
		var flucomaTestClasses = FlucomaUnitTest.allSubclasses;
		var numberOfTests = flucomaTestClasses.size;

		//are variables thread safe in sclang? can i do atomic increment and comparison?
		//otherwise, a solution here would be to have an array of booleans
		var testsCounter = 0;

		flucomaTestClasses.do({
			arg testClass;

			//run the test. it's already forked in there.
			testClass.run(true, true);

			//Check the completion of the test
			forkIfNeeded {
				var testCompleted = testClass.completed;
				while ({testCompleted == false}, {
					0.2.wait;
					testCompleted = testClass.completed;
					if(testCompleted, {
						testsCounter = testsCounter + 1;
					});
				});
			}
		});

		//Check completion of all tests
		forkIfNeeded {
			var testsCompleted = testsCounter == numberOfTests;
			while ({testsCompleted == false}, {
				0.2.wait;
				testsCompleted = testsCounter == numberOfTests;
				if(testsCompleted, {
					"Finished all Flucoma tests".postln;
				});
			});
		};
	}

	*outputLogFile {

	}
}