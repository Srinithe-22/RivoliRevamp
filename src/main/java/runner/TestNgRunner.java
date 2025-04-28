import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import utils.GmailReader;
import utils.ReadWriteExcelProperties;
import wdMethods.ProjMethods;

//@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/main/resources/features"}
				,plugin={"html:target/cucumber/index.html","pretty:target/pretty"}
				,monochrome=true
				,glue 	  = {"stepDefinitions"}
				,dryRun = false
				,tags = "@HomePage"
				,snippets=SnippetType.CAMELCASE
				)

public class TestNgRunner extends ProjMethods{

	private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass(ITestContext context) throws Exception {
    	context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(1);
        context.getCurrentXmlTest().getSuite().setPreserveOrder(false);

        //CreateFeatureFile.readTestcase();
        //CreateStepDef.createSD();

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        ReadWriteExcelProperties readWriteExcelProperties = new ReadWriteExcelProperties();
        readWriteExcelProperties.readWriteProperties();
        new GmailReader();
    }


   @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
   public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
       testNGCucumberRunner.runScenario(pickle.getPickle());
       String scenarioName = pickle.getPickle().getName();

   }


    @DataProvider(name = "scenarios",parallel=true)
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }

}
