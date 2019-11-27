package StartMethod;

import PublicMethod.AppiumTool;
import PublicMethod.TimeLog;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class DriverStartSetUp {

//    private AndroidDriver driver;
//    public AppiumTool at;
//    private TimeLog tl = new TimeLog();
//    private static final DriverStartSetUp driverStartSetUp = new DriverStartSetUp();
//
//    public static AndroidDriver getDriver() {
//        return driverStartSetUp.driver;
//    }
//
//    public DriverStartSetUp() {
//
//    }
//
//    private DriverStartSetUp(AndroidDriver driver) throws Exception {
//        init();
//    }
//
//    public void init() throws Exception {
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        //存放app的目录：apps
//        File classpathRoot = new File(System.getProperty("user.dir"));
//        File appDir = new File(classpathRoot, "apps");
//        //测试App的文件名
//        File app = new File(appDir, "xesapp.apk");
//        /* 设置自动化相关参数 */
//        //设置执行手机操作系统
//        capabilities.setCapability("platformName", "Android");
//        //测试机的唯一标示
//        capabilities.setCapability("deviceName", "5EF0218606002337");
//        //设置安卓系统版本
//        capabilities.setCapability("platformVersion", "4.4.2");
//        //返回抽象路径名的绝对路径名字符串
//        capabilities.setCapability("app", app.getAbsolutePath());
//        //设置系统
//        capabilities.setCapability("device", "src/Android");
//        //app 包名
//        capabilities.setCapability("appPackage", "com.xes.jazhanghui.activity");
//        //打开App的activity
//        capabilities.setCapability("appActivity", "com.xes.jazhanghui.activity.mvp.start.StartActivity");
//        //支持中文输入
//        capabilities.setCapability("unicodeKeyboard", true);
//        //测试结束后还原默认输入法
//        capabilities.setCapability("resetKeyboard", true);
//        //Appium与IDEA 测试机通信协议
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        tl.insertLog("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//
//    }
//
//    public AppiumTool getAt(AndroidDriver driver){
//
//        at = new AppiumTool(driver);
//        return at;
//    }

//    public static void getRepeateNum(int[] num) {
//        int NumChange;
//        System.out.println("重复数字是：");
//        for(int i = 0; i < num.length; i++) {
//            while(num[i] != i) {
//                if(num[i] == num[num[i]]) {
//                    System.out.println(num[i]);
//                    break;
//                } else {
//                    NumChange = num[num[i]];
//                    num[num[i]] = num[i];
//                    num[i] = NumChange;
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] num = new int[5];   //数组长度可以自己定义
//        System.out.println("请输入一组数据：");
//        for (int j = 0; j < 5; j++) {
//            num[j] = scanner.nextInt();
//        }
//        getRepeateNum(num);
//    }
    public static void main(String[] args) {
        int[] num = {1, 2, 13, 1, 13, 3, 5, 5, 7, 9, 9, 10, 10, 18, 18};
        int number;
        for (int i = 0; i < num.length; i++){
            for (int j = 0; j < num.length; j++){
                if ((num[i] == num[j]) && (i!=j)){
                        System.out.println(num[j]);
                }
            }
        }
        //从小到大排序
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    number = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = number;
                }
            }
        }
        //从大到小排序
        for (int i = 0;i < num.length-1 ; i++){
            for (int j = num.length - 1; j > 0; j--) {
                if (num[j] > num[j-1]){
                    number = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = number;
                }
            }
        }
        System.out.print("排序后的数组：");
        for (int x:num) {
            System.out.print(x+" ");
        }
        System.out.println("");
    }
}
