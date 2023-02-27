package driver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class AppiumServer {

    public static void main(String[] args) {
        AppiumServer.start();
    }

    static void start() {
        getInstance().start();
    }
    public static void stop() {
        Runtime runtime = Runtime.getRuntime();
        String[] command = {"killall", "-9", "node"};
        try {
            runtime.exec(command);
            System.out.println("Appium server stopped");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static AppiumDriverLocalService getInstance() {
        HashMap<String, String> env = new HashMap(System.getenv());
        env.put("ANDROID_HOME", "/Users/williamsoares/Library/Android/sdk");

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withAppiumJS(new File("/Applications/Appium Server GUI.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/opt/homebrew/bin/node"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withEnvironment(env)
                .withLogFile(new File("AppiumLog.txt"));
        return AppiumDriverLocalService.buildService(builder);
    }

}
