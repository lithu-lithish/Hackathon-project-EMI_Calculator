package cucumber.hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import io.cucumber.java.Scenario;

import io.cucumber.java.Before;

public class AttachScreenshot {
    static Scenario scenario;

    @Before
    public void getScenario(Scenario scenario)
    {
        AttachScreenshot.scenario = scenario;
    }

    public static void attachScreenshotToReport(File screenShotFile)
    {
        try {
            byte[] fileBytes = Files.readAllBytes(screenShotFile.toPath());
             scenario.attach(fileBytes, "image/png", screenShotFile.getName().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
