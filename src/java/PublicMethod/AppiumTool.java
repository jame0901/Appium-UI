package PublicMethod;

import StartMethod.DriverStartSetUp;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.time.Duration;

public class AppiumTool{
    public AndroidDriver driver;
    public WebElement operationalElements;
    private String element;
    private int time;
    private String sendkey;
    private String i ;
    private String string;
    Point point;
    Dimension dimension;
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
        //测试结束后还原默认输入法
        capabilities.setCapability("resetKeyboard", true);
        //Appium与IDEA 测试机通信协议
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        tl.insertLog("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void clcikElements(String element,int time,ElementMethod elementMethod)throws Exception{

      try{
          Thread.sleep(time);
          switch (elementMethod){

              case xpath:
                  driver.findElement(By.xpath(element)).click();
                  tl.insertLog("点击元素"+element);
                  break;
              case linkText:
                  driver.findElement(By.linkText(element)).click();
                  tl.insertLog("点击元素"+element);
                  break;
              case className:
                  driver.findElement(By.className(element)).click();
                  tl.insertLog("点击元素"+element);
                  break;
              case id:
                  driver.findElement(By.id(element)).click();
                  tl.insertLog("点击元素"+element);
                  break;
              case name:
                  driver.findElement(By.name(element)).click();
                  tl.insertLog("点击元素"+element);
                  break;
              case partialLinkText:
                  driver.findElement(By.partialLinkText(element)).click();
                  tl.insertLog("点击元素"+element);
                  break;
              case tagName:
                  driver.findElement(By.tagName(element)).click();
                  tl.insertLog("点击元素"+element);
                  break;
              case cssSelector:
                  driver.findElement(By.cssSelector(element)).click();
                  tl.insertLog("点击元素"+element);
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

    public String locationElement (String string,String element,int time,String i,ElementMethod elementMethod)throws Exception{

        try {

            Thread.sleep(time);
            switch (elementMethod){

                case xpath:
                    string = driver.findElement(By.xpath(element)).toString();
                    tl.insertLog("找到元素"+element);
                    break;
                case linkText:
                    string = driver.findElement(By.linkText(element)).toString();
                    tl.insertLog("找到元素"+element);
                    break;
                case className:
                    string = driver.findElement(By.className(element)).toString();
                    tl.insertLog("找到元素"+element);
                    break;
                case id:
                    string = driver.findElement(By.id(element)).toString();
                    tl.insertLog("找到元素"+element);
                    break;
                case name:
                    string = driver.findElement(By.name(element)).toString();
                    tl.insertLog("找到元素"+element);
                    break;
                case partialLinkText:
                    string = driver.findElement(By.partialLinkText(element)).toString();
                    tl.insertLog("找到元素"+element);
                    break;
                case tagName:
                    string = driver.findElement(By.tagName(element)).toString();
                    tl.insertLog("找到元素"+element);
                    break;
                case cssSelector:
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

    public void sendKey(String element,String sendkey,int time,ElementMethod elementMethod)throws Exception{

        try {

            Thread.sleep(time);
            switch (elementMethod){

                case xpath:
                    driver.findElement(By.xpath(element)).clear();
                    driver.findElement(By.xpath(element)).sendKeys(sendkey);
                    tl.insertLog("输入元素"+element);
                    break;
                case linkText:
                    driver.findElement(By.linkText(element)).clear();
                    driver.findElement(By.linkText(element)).sendKeys(sendkey);
                    tl.insertLog("输入元素"+element);
                    break;
                case className:
                    driver.findElement(By.className(element)).clear();
                    driver.findElement(By.className(element)).sendKeys(sendkey);
                    tl.insertLog("输入元素"+element);
                    break;
                case id:
                    driver.findElement(By.id(element)).clear();
                    driver.findElement(By.id(element)).sendKeys(sendkey);
                    tl.insertLog("输入元素"+element);
                    break;
                case name:
                    driver.findElement(By.name(element)).clear();
                    driver.findElement(By.name(element)).sendKeys(sendkey);
                    tl.insertLog("输入元素"+element);
                    break;
                case partialLinkText:
                    driver.findElement(By.partialLinkText(element)).clear();
                    driver.findElement(By.partialLinkText(element)).sendKeys(sendkey);
                    tl.insertLog("输入元素"+element);
                    break;
                case tagName:
                    driver.findElement(By.tagName(element)).clear();
                    driver.findElement(By.tagName(element)).sendKeys(sendkey);
                    tl.insertLog("输入元素"+element);
                    break;
                case cssSelector:
                    driver.findElement(By.cssSelector(element)).clear();
                    driver.findElement(By.cssSelector(element)).sendKeys(sendkey);
                    tl.insertLog("输入元素"+element);
                    break;
                default:
                    tl.insertLog("输入不符合要求的查找元素方式");
                    break;
            }
        }catch (Exception e){

            tl.insertLog("未找到元素："+element+"导致输入"+sendkey+"失败！");
        }
    }

    public void pageDownElement(String element,ElementMethod elementMethod,int time)throws Exception{

        Thread.sleep(time);
        try {

            switch (elementMethod){

                case xpath:
                    driver.findElement(By.xpath(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                case linkText:
                    driver.findElement(By.linkText(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                case className:
                    driver.findElement(By.className(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                case id:
                    driver.findElement(By.id(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                case name:
                    driver.findElement(By.name(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                case partialLinkText:
                    driver.findElement(By.partialLinkText(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                case tagName:
                    driver.findElement(By.tagName(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                case cssSelector:
                    driver.findElement(By.cssSelector(element)).sendKeys(Keys.PAGE_DOWN);
                    break;
                default:
                    tl.insertLog("输入不符合要求的查找元素方式");
                    break;
            }
        }catch (Exception e){

            tl.insertLog("页面小幅度拉加载失败");
        }
    }

    public void pageDownEndElement(String element,ElementMethod elementMethod,int time)throws Exception{

        Thread.sleep(time);
        try {

            switch (elementMethod){

                case xpath:
                    driver.findElement(By.xpath(element)).sendKeys(Keys.END);
                    break;
                case linkText:
                    driver.findElement(By.linkText(element)).sendKeys(Keys.END);
                    break;
                case className:
                    driver.findElement(By.className(element)).sendKeys(Keys.END);
                    break;
                case id:
                    driver.findElement(By.id(element)).sendKeys(Keys.END);
                    break;
                case name:
                    driver.findElement(By.name(element)).sendKeys(Keys.END);
                    break;
                case partialLinkText:
                    driver.findElement(By.partialLinkText(element)).sendKeys(Keys.END);
                    break;
                case tagName:
                    driver.findElement(By.tagName(element)).sendKeys(Keys.END);
                    break;
                case cssSelector:
                    driver.findElement(By.cssSelector(element)).sendKeys(Keys.END);
                    break;
                default:
                    tl.insertLog("输入不符合要求的查找元素方式");
                    break;
            }
        }catch (Exception e){

            tl.insertLog("页面下拉到底加载失败");
        }
    }

    public void touchActionElement(String element,ElementMethod elementMethod,int time,Heading heading)throws Exception{

        int startX = 0;
        int startY = 0;
        int width = 0;
        int height = 0;
        int endX = 0;
        int endY = 0;
        int centerX = 0;
        int centerY = 0;
        Thread.sleep(time);
        try {
            switch (elementMethod){
                case xpath:
                    point = driver.findElement(By.xpath(element)).getLocation();
                    dimension = driver.findElement(By.xpath(element)).getSize();
                case linkText:
                    point = driver.findElement(By.linkText(element)).getLocation();
                    dimension = driver.findElement(By.xpath(element)).getSize();
                case className:
                    point = driver.findElement(By.className(element)).getLocation();
                    dimension = driver.findElement(By.xpath(element)).getSize();
                case id:
                    point = driver.findElement(By.id(element)).getLocation();
                    dimension = driver.findElement(By.xpath(element)).getSize();
                case name:
                    point = driver.findElement(By.name(element)).getLocation();
                    dimension = driver.findElement(By.xpath(element)).getSize();
                case partialLinkText:
                    point = driver.findElement(By.partialLinkText(element)).getLocation();
                    dimension = driver.findElement(By.xpath(element)).getSize();
                case tagName:
                    point = driver.findElement(By.tagName(element)).getLocation();
                    dimension = driver.findElement(By.xpath(element)).getSize();
                case cssSelector:
                    point = driver.findElement(By.cssSelector(element)).getLocation();
                    dimension = driver.findElement(By.xpath(element)).getSize();
            }
            //获取元素开始坐标
            startX = point.x;
            startY = point.y;
            //获取元素宽、高
            width = dimension.width;
            height = dimension.height;
            //得到元素坐标的结束坐标
            endX = startX+width;
            endY = startY+height;
            //得到元素中间坐标
            centerX = (startX + endX)/2;
            centerY = (startY + endY)/2;
        }catch (Exception e){

            tl.insertLog("元素："+element+"定位异常");
        }

        try {
            switch (heading) {
                // 向右滑动
                case RIGHT:
                    new TouchAction(driver)
                            .press(PointOption.point(startX,startY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofDays(1000)))
                            .moveTo(PointOption.point(centerX,startY));
                break;
                // 向左滑动
                case LEFT:
                    new TouchAction(driver)
                            .press(PointOption.point(endX,endY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofDays(1000)))
                            .moveTo(PointOption.point(centerX,endY));
                    break;
                //向上滑动
                case UP:
                    new TouchAction(driver).press(PointOption.point(centerX,centerY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofDays(1000)))
                            .moveTo(PointOption.point(centerX,centerY + 10));
                    break;
                //向下滑动
                case DOWN:
                    new TouchAction(driver).press(PointOption.point(centerX,centerY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofDays(1000)))
                            .moveTo(PointOption.point(centerX,centerY - 10));
                    break;
            }
        }catch (Exception e){
            System.out.println("滑动元素"+element+"异常");
        }
    }

}
