package utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateStepDef {
    private static final Pattern GIVEN_PATTERN = Pattern.compile("^Given (.*)$");
    private static final Pattern WHEN_PATTERN = Pattern.compile("^And (.*)$");
    private static final Pattern THEN_PATTERN = Pattern.compile("^Then (.*)$");


    public static void createSD() {
        try {
            // Step 1: Redirect System.out to capture the output
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            System.setOut(printStream);

            // Step 2: Execute the Cucumber tests
            newFeature();

            // Step 3: Capture the test results from the output stream
            String output = byteArrayOutputStream.toString();

            // Step 4: Write the output to a new Java file
            writeOutputToFile(output, "src/main/java/stepDefinitions/CucumberTestResult.java");

            System.out.println("Test results saved to CucumberTestResult.java");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void newFeature(){
        // Specify the feature file path
        String featureFilePath = "src/main/resources/features/smoke-USDesktop.feature";  // Change to your .feature file path
        try {
            File featureFile = new File(featureFilePath);
            if (!featureFile.exists()) {
                System.out.println("Feature file not found!");
                return;
            }
            // Read the feature file and generate step definitions
            generateStepDefinitions(featureFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateStepDefinitions(File featureFile) throws IOException {
        // Create BufferedReader to read the feature file
        BufferedReader reader = new BufferedReader(new FileReader(featureFile));
        String line;
        while ((line = reader.readLine()) != null) {
            // Trim leading and trailing spaces
            line = line.trim();
            String type =null;

            // Process each step line based on its type
            if (line.startsWith("Given")) {
                type="Given";
                processStep(GIVEN_PATTERN, line,type);

            } else if (line.startsWith("And")) {
                type="And";
                processStep(WHEN_PATTERN, line,type);

            } else if (line.startsWith("Then")) {
                type="Then";
                processStep(THEN_PATTERN, line,type);

            }
        }
        reader.close();
    }

    public static void processStep(Pattern pattern, String step,String type) {
        // Match the pattern with the step line
        Matcher matcher = pattern.matcher(step);
        if (matcher.matches()) {
            String stepText = matcher.group(1);  // The step description without "Given", "When", "Then"
            generateStepDefinitionMethod(stepText,type);
        }
    }

    public static void generateStepDefinitionMethod(String stepText,String Type) {
        // Generate a simple method signature based on the step
        String methodName = convertToMethodName(stepText);
        String stepDefinition = String.format(
                "\n@"+Type+"(\"%s\")\n" +
                        "public void %s() {\n" +
                        "    // Write the implementation for the step: '%s'\n" +
                        "}\n\n", stepText, methodName, stepText);

        // Output the generated step definition
        System.out.println(stepDefinition);
    }

    // Utility method to convert step text into a valid Java method name
    public static String convertToMethodName(String stepText) {
        // Remove non-alphabetical characters, and convert to camelCase
        String[] words = stepText.split(" ");
        StringBuilder methodName = new StringBuilder();
        for (String word : words) {
            if (methodName.length() == 0) {
                methodName.append(word.toLowerCase());
            } else {
                methodName.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase());
            }
        }
        return methodName.toString();
    }


    private static void writeOutputToFile(String output, String fileName) throws IOException {
        // Step 5: Write the captured output to a new Java file
        String fileContent = "package stepDefinitions;\n\n" +
                "import cucumber.api.java.en.And;\n" +
                "import cucumber.api.java.en.Given;\n" +
                "import cucumber.api.java.en.Then;\n" +
                "import cucumber.api.java.en.When;\n\n" +
                "import pages.HomePage;\n" +
                "import wdMethods.ProjMethods;\n\n"+
                "public class CucumberTestResult extends ProjMethods{\n\n" +
                "private HomePage homePage;\n\n"+
                "public CucumberTestResult() {\n" +
                "\t\thomePage = new HomePage();\n" +
                "\t}"+
                output.replace("\n", "\n        ") + "\n" +
                "    }\n" ;

        // Write to a new file
        Path filePath = Paths.get(fileName);
        Files.write(filePath, fileContent.getBytes());
    }
}
