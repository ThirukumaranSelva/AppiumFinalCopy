package com.qa.utils;

import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class VideoManager {

    public void startRecording() {
        ((CanRecordScreen) new DriverManager().getDriver()).startRecordingScreen();
    }

    public void stopRecording(String scenarioName) throws IOException {
        var media = ((CanRecordScreen) new DriverManager().getDriver()).stopRecordingScreen();
        GlobalParams globalParams = new GlobalParams();
        String videoLoc = globalParams.getPlatformName() + "_" + globalParams.getDeviceName() + File.separator + "Videos";
        File file = new File(videoLoc);
        synchronized (file) {
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file + File.separator +scenarioName + "_"+Utils.dateAndTime()+
                    ".mp4");
            fileOutputStream.write(Base64.decodeBase64(media));
            fileOutputStream.close();
            Utils.logger().info("Videopath:" + file + File.separator + scenarioName +"_"+Utils.dateAndTime()+ ".mp4");
        } catch (Exception e) {
            e.getStackTrace();
            Utils.logger().info("Exception caught in Video Manager");
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}
