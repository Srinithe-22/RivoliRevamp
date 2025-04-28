package stepDefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.io.FilenameUtils;
import utils.GlobalVariables;
import wdMethods.ProjMethods;

public class Hooks extends ProjMethods{
	
	@Before
	public void launchBrowser(Scenario sc) throws InterruptedException {
		String featureName = FilenameUtils.getBaseName(sc.getUri().toString());
		System.out.println("Launching Browser "+featureName);

		String scenarioName = null;
		dataSheetName = "TC002_MessagingTest";
		sheetName = "";

		if(featureName.contains("USMobile")) {
			GlobalVariables.addGlobalVariable("environment", "US");
			GlobalVariables.addGlobalVariable("mobileWeb", "true");
			scenarioName = "US Mobile - " + sc.getName();
		}else if(featureName.contains("USDesktop")) {
			GlobalVariables.addGlobalVariable("environment", "US");
			GlobalVariables.addGlobalVariable("mobileWeb", "false");
			scenarioName = "US Desktop - " + sc.getName();
		}else if(featureName.contains("CanadaDesktop")) {
			GlobalVariables.addGlobalVariable("environment", "CANADA");
			GlobalVariables.addGlobalVariable("mobileWeb", "false");
			scenarioName = "Canada Desktop - " + sc.getName();
		}else if(featureName.contains("CanadaMobile")) {
			GlobalVariables.addGlobalVariable("environment", "CANADA");
			GlobalVariables.addGlobalVariable("mobileWeb", "true");
			scenarioName = "Canada Mobile - " + sc.getName();
		}else {
			reportStep("Invalid feature file name", "FAIL");
		}
		System.out.println(scenarioName);

		startApp(browser,scenarioName ,bRemote);
		startTestModule(scenarioName, sc.getId());
	}
	
	@After
	public void executeAfterScenario() {
		closeAllBrowsers();
	}




}
