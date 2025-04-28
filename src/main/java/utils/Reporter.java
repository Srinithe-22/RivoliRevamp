package utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.automation.remarks.video.RecordingUtils;
import com.automation.remarks.video.recorder.IVideoRecorder;
import com.automation.remarks.video.recorder.VideoRecorder;
import com.aventstack.extentreports.model.Media;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.MediaEntityModelProvider;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;

import javax.mail.MessagingException;


public abstract class Reporter {

	//public static ExtentHtmlReporter html;
	public static ExtentSparkReporter html;
	public static ExtentReports extent;
	public static JsonFormatter json;
	public ExtentTest test, suiteTest;
	public String testCaseName, testNodes, testDescription, category, authors;
	public Boolean appendExisting = true;
	private Process ffmpegProcess;

	String userDir = System.getProperty("user.dir");
	Path paths = Paths.get(userDir);
	String project = String.valueOf(paths.getFileName());

	String path = "C:\\Results\\" + project;
	String imagePath = "C:\\Results\\" + project + "\\Image";
	String filename=null;
	IVideoRecorder videoRecorder;

	private static Map<RemoteWebDriver, ExtentTest> testDriver;

	public void reportStep(String desc, String status, boolean bSnap) {

		Media img = null;
		if (bSnap && !status.equalsIgnoreCase("INFO")) {

			long snapNumber;
			snapNumber = takeSnap();
	            /*img = MediaEntityBuilder.createScreenCaptureFromPath
                        ("./../reports/images/"+snapNumber+".jpg").build();

                 */
			System.out.println(imagePath + "\\" + snapNumber + ".jpg");
			img = MediaEntityBuilder.createScreenCaptureFromPath
					(imagePath + "\\" + snapNumber + ".jpg").build();
		}

		// Write if it is successful or failure or information
		if (status.toUpperCase().equals("PASS")) {
			testDriver.get(getDriver()).pass(desc, img);
		} else if (status.toUpperCase().equals("FAIL")) {
			testDriver.get(getDriver()).fail(desc, img);
			throw new RuntimeException("FAILED");
		} else if (status.toUpperCase().equals("INFO")) {
			testDriver.get(getDriver()).info(desc);
		} else if (status.toUpperCase().equals("WARN")) {
			testDriver.get(getDriver()).warning(desc, img);
		}
	}

	public void reportStep(String desc, String status) {
		reportStep(desc, status, false);
	}

	public abstract long takeSnap();


	public void startResult() {
		try {
			/*String command = "ffmpeg -f x11grab -video_size 1280x720 -i :0.0 -t 00:10:00 -r 30 target/test-classes/videos/test_video.mp4";
			ffmpegProcess = Runtime.getRuntime().exec(command);*/

			videoRecorder = new VideoRecorder("Recordings");
			videoRecorder.start();


			String date = DateFormat.getDateInstance().format(new Date());
			String dateTime = DateFormat.getDateTimeInstance().format(new Date());
			dateTime = dateTime.replace(",", "_");
			dateTime = dateTime.replace(" ", "_");
			dateTime = dateTime.replace(":", "-");


			File f = new File(imagePath);
			if (f.mkdir()) {
				System.out.println("Directory has been created successfully");
			} else {
				System.out.println("Directory cannot be created");
			}

			testDriver = new HashMap<RemoteWebDriver, ExtentTest>();
			//html = new ExtentHtmlReporter("./reports/result_"+dateTime+".html");
			File nf = new File(path);
			if (nf.mkdir()) {
				System.out.println("Directory has been created successfully");
			} else {
				System.out.println("Directory cannot be created");
			}

			filename="result_" + dateTime + ".html";
			html = new ExtentSparkReporter(path +"/"+date+"/"+ filename);
			json = new JsonFormatter(path + "/jsonreport_" + dateTime + ".json");
			//html.setAppendExisting(appendExisting);
			extent = new ExtentReports();
			extent.attachReporter(html);
       /* if (!appendExisting) {

			FileUtils.cleanDirectory(new File("./reports/images/"));
        }
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        */

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public synchronized ExtentTest startTestModule(String testCaseName, String testDescription) {
		return testDriver.put(getDriver(), extent.createTest(testCaseName,testDescription));
	}

	public synchronized ExtentTest startTestCase(String testCaseName, String testDescription, String testNodes) {
		return testDriver.put(getDriver(), extent.createTest(testCaseName, testDescription)).createNode(testNodes);
	}


	public void endResult() throws MessagingException, UnsupportedEncodingException {
		extent.flush();
		videoRecorder.stop();

		SendSSLEmail s=new SendSSLEmail();
		s.sendNewMail(filename);
	}

	public abstract RemoteWebDriver getDriver();

}


