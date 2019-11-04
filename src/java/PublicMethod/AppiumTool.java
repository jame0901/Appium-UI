package PublicMethod;

import StartMethod.DriverStartSetUp;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class AppiumTool{
    public AndroidDriver driver;
    public WebElement operationalElements;
    private String element;
    private int time;
    private String sendkey;
    private String i ;
    private int number;
    private String string;
    TimeLog tl = new TimeLog();
    DesiredCapabilities capabilities = new DesiredCapabilities();

//    public AppiumTool(AndroidDriver driver){
//        this.driver = driver;
//    }

    public String getElement(){
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public WebElement getoperationalElements(){
        return operationalElements;
    }

    public void setOperationalElements(WebElement operationalElements) {
        this.operationalElements = operationalElements;
    }

    public int getTime(){
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getI(){
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public String getSendKey(){
        return sendkey;
    }

    public void setSendKey(String sendKey) {
        this.sendkey = sendKey;
    }

    public String getString(){
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void setUp()throws Exception {

        //存放app的目录：apps
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        //测试App的文件名
        File app = new File(appDir, "xesapp.apk");
        /* 设置自动化相关参数 */
        //设置执行手机操作系统
        capabilities.setCapability("platformName", "Android");
        //测试机的唯一标示
        capabilities.setCapability("deviceName","5EF0218606002337");
        //设置安卓系统版本
        capabilities.setCapability("platformVersion", "4.4.2");
        //返回抽象路径名的绝对路径名字符串
        capabilities.setCapability("app", app.getAbsolutePath());
        //设置系统
        capabilities.setCapability("device", "src/Android");
        //app 包名
        capabilities.setCapability("appPackage", "com.xes.jazhanghui.activity");
        //打开App的activity
        capabilities.setCapability("appActivity", "com.xes.jazhanghui.activity.mvp.start.StartActivity");
        //支持中文输入
        capabilities.setCapability("unicodeKeyboard", true);
        tl.insertLog("test");
        //测试结束后还原默认输入法
        capabilities.setCapability("resetKeyboard", true);
        //Appium与IDEA 测试机通信协议
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        tl.insertLog("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        tl.insertLog("test");
        tl.insertLog("test");
        tl.insertLog("test");
    }

    public void clcikElements(String element,int time,int number)throws Exception{

      try{
          Thread.sleep(time);
          switch (number){

              case 1:
                  driver.findElement(By.xpath(element)).click();
                  break;
              case 2:
                  driver.findElement(By.linkText(element)).click();
                  break;
              case 3:
                  driver.findElement(By.className(element)).click();
                  break;
              case 4:
                  driver.findElement(By.id(element)).click();
                  break;
              case 5:
                  driver.findElement(By.name(element)).click();
                  break;
              case 6:
                  driver.findElement(By.partialLinkText(element)).click();
                  break;
              case 7:
                  driver.findElement(By.tagName(element)).click();
                  break;
              case 8:
                  driver.findElement(By.cssSelector(element)).click();
                  break;
              default:
                  tl.insertLog("输入不符合要求的查找元素方式");
                  break;
          }

      }catch (Exception e){

          tl.insertLog("未找到要点击的元素："+element);
          e.printStackTrace();

      }
    }

    public String locationElement (String string,String element,int time,String i,int number)throws Exception{

        try {

            Thread.sleep(time);
            switch (number){

                case 1:
                    string = driver.findElement(By.xpath(element)).toString();
                    tl.insertLog("找到元素"+element);
                    break;
                case 2:
                    string = driver.findElement(By.linkText(element)).toString();
                    tl.insertLog("找到元素"+element);
                    break;
                case 3:
                    string = driver.findElement(By.className(element)).toString();
                    tl.insertLog("找到元素"+element);
                    break;
                case 4:
                    string = driver.findElement(By.id(element)).toString();
                    tl.insertLog("找到元素"+element);
                    break;
                case 5:
                    string = driver.findElement(By.name(element)).toString();
                    tl.insertLog("找到元素"+element);
                    break;
                case 6:
                    string = driver.findElement(By.partialLinkText(element)).toString();
                    tl.insertLog("找到元素"+element);
                    break;
                case 7:
                    string = driver.findElement(By.tagName(element)).toString();
                    tl.insertLog("找到元素"+element);
                    break;
                case 8:
                    string = driver.findElement(By.cssSelector(element)).toString();
                    tl.insertLog("找到元素"+element);
                    break;
                default:
                    tl.insertLog("输入不符合要求的查找元素方式");
                    break;
            }
        }catch (Exception e){

            tl.insertLog("未找到元素："+element);
            string = i;
        }
        return string;
    }

    public void sendKey(String element,String sendkey,int time,int number)throws Exception{

        try {

            Thread.sleep(time);
            switch (number){

                case 1:
                    driver.findElement(By.xpath(element)).clear();
                    driver.findElement(By.xpath(element)).sendKeys(sendkey);
                    break;
                case 2:
                    driver.findElement(By.linkText(element)).clear();
                    driver.findElement(By.linkText(element)).sendKeys(sendkey);
                    break;
                case 3:
                    driver.findElement(By.className(element)).clear();
                    driver.findElement(By.className(element)).sendKeys(sendkey);
                    break;
                case 4:
                    driver.findElement(By.id(element)).clear();
                    driver.findElement(By.id(element)).sendKeys(sendkey);
                    break;
                case 5:
                    driver.findElement(By.name(element)).clear();
                    driver.findElement(By.name(element)).sendKeys(sendkey);
                    break;
                case 6:
                    driver.findElement(By.partialLinkText(element)).clear();
                    driver.findElement(By.partialLinkText(element)).sendKeys(sendkey);
                    break;
                case 7:
                    driver.findElement(By.tagName(element)).clear();
                    driver.findElement(By.tagName(element)).sendKeys(sendkey);
                    break;
                case 8:
                    driver.findElement(By.cssSelector(element)).clear();
                    driver.findElement(By.cssSelector(element)).sendKeys(sendkey);
                    break;
                default:
                    tl.insertLog("输入不符合要求的查找元素方式");
                    break;
            }
        }catch (Exception e){

            tl.insertLog("未找到元素："+element+"导致输入"+sendkey+"失败！");
        }
    }

    public void pageDownElement(String element,int number,int time)throws Exception{

        Thread.sleep(time);
        try {

            switch (number){

                case 1:
                    driver.findElement(By.xpath(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                case 2:
                    driver.findElement(By.linkText(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                case 3:
                    driver.findElement(By.className(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                case 4:
                    driver.findElement(By.id(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                case 5:
                    driver.findElement(By.name(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                case 6:
                    driver.findElement(By.partialLinkText(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                case 7:
                    driver.findElement(By.tagName(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                case 8:
                    driver.findElement(By.cssSelector(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                default:
                    tl.insertLog("输入不符合要求的查找元素方式");
                    break;
            }
        }catch (Exception e){

            tl.insertLog("页面小幅度下啦加载失败");
        }
    }

    public void pageDownEndElement(String element,int number,int time)throws Exception{

        Thread.sleep(time);
        try {

            switch (number){

                case 1:
                    driver.findElement(By.xpath(element)).sendKeys(Keys.END);
                    break;
                case 2:
                    driver.findElement(By.linkText(element)).sendKeys(Keys.END);
                    break;
                case 3:
                    driver.findElement(By.className(element)).sendKeys(Keys.END);
                    break;
                case 4:
                    driver.findElement(By.id(element)).sendKeys(Keys.END);
                    break;
                case 5:
                    driver.findElement(By.name(element)).sendKeys(Keys.END);
                    break;
                case 6:
                    driver.findElement(By.partialLinkText(element)).sendKeys(Keys.END);
                    break;
                case 7:
                    driver.findElement(By.tagName(element)).sendKeys(Keys.END);
                    break;
                case 8:
                    driver.findElement(By.cssSelector(element)).sendKeys(Keys.END);
                    break;
                default:
                    tl.insertLog("输入不符合要求的查找元素方式");
                    break;
            }
        }catch (Exception e){

            tl.insertLog("页面下啦到底加载失败");
        }
    }

}
