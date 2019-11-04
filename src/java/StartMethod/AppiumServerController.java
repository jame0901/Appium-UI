package StartMethod;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AppiumServerController {

    // private Process mProcess;
    private HashMap<String, Process> processHashMap = new HashMap<>();
    private String nodePath = "node";
    private String appiumJsPath;
    private String port;
    private String bootstrapPort;
    private String chromedriver_port;
    private String UID;

    private static AppiumServerController appiumServerController = new AppiumServerController();

    private AppiumServerController() {
    }

//    public void startServer() throws Exception {
//        Process process;
//        BufferedReader envReader = new BufferedReader(new FileReader(new File("env.txt")));
//        String envLine;
//        while ((envLine = envReader.readLine()) != null) {
//            if (envLine.startsWith("#"))
//                continue;
//
//            String[] split = envLine.split("=");
//            if (split.length != 2)
//                continue;
//            switch (split[0]) {
//                case "node":
//                    nodePath = split[1];
//                    System.out.println("New node path: " + nodePath);
//                    break;
//                case "appium.js":
//                    appiumJsPath = split[1];
//                    System.out.println("New appium.js path: " + appiumJsPath);
//                    break;
//                case "port":
//                    port = split[1];
//                    break;
//                case "bootstrap_port":
//                    bootstrapPort = split[1];
//                    break;
//                case "chromedriver_port":
//                    chromedriver_port = split[1];
//                    break;
//                case "UID":
//                    UID = split[1];
//                    break;
//                default:
//                    break;
//            }
//        }
//        // startServer(nodePath,
//        // appiumJsPath,port,bootstrapPort,chromedriver_port,UID);
//        String cmd = nodePath + " \"" + appiumJsPath + "\" " + "--session-override " + " -p " + port + " -bp "
//                + bootstrapPort + " --chromedriver-port " + chromedriver_port + " -U " + UID;
//        System.out.println(cmd);
//        process = Runtime.getRuntime().exec(cmd);
//        processHashMap.put(String.valueOf(port), process);
//        System.out.println(process);
//        InputStream inputStream = process.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//        }
//        process.waitFor();
//        System.out.println("Stop appium server one");
//        inputStream.close();
//        reader.close();
//        process.destroy();
//    }

//    public void startServer( String nodePath, String appiumPath, String port, String bootstrapPort,
//                            String chromeDriverPort, String udid) throws Exception {
//        System.out.println("AppiumServerController startServer()");
//        Process process;
//        String cmd = nodePath + " \"" + appiumPath + "\" " + "--session-override " + " -p " + port + " -bp "
//                + bootstrapPort + " --chromedriver-port " + chromeDriverPort + " -U " + udid;
//        System.out.println("cmd = " + cmd);
//        process = Runtime.getRuntime().exec(cmd);
//        processHashMap.put(port, process);
//        System.out.println("process = " + process);
//        InputStream inputStream = process.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        String line;
//        System.out.println("line reader.readLine() = " + reader.readLine());
//        while ((line = reader.readLine()) != null) {
//            System.out.println("line = " + line);
//            if (line.startsWith("[Appium] Appium REST http interface listener started on")) {
//                // lock.unlock();
//            }
//        }
//        process.waitFor();
//        System.out.println("Stop appium server AppiumServerController");
//        inputStream.close();
//        reader.close();
//        process.destroy();
//    }

    @Parameters({"port", "platformName", "platformVersion", "deviceName", "appPackage", "appActivity"
            , "noReset", "app"})
    @BeforeSuite
    public void startServer(String nodePath, String appiumPath, String port,String bootstrapPort, String chromeDriverPort, String udid) {
        boolean needStartServer = true;
        if (needStartServer) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        AppiumServerController.getInstance().startServer(nodePath, appiumPath, port, bootstrapPort, chromeDriverPort, udid);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterSuite
    public void stopServer(Process process) {

        if (process != null) {
            System.out.println(process);
            process.destroy();
        }
    }

    public void stopServer(String port) {
        Process process = processHashMap.get(port);
        stopServer(process);
        processHashMap.remove(port);
    }

    public static AppiumServerController getInstance() {
        return appiumServerController;
    }
}
