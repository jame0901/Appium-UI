package PublicMethod;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class CameraTest {

    private String filePreStr; // 用例方法名
    private String defName = "cameraImg";  // 默认截图名称
    String serialNum = null;  //截图名称后面的数字累加
    private String imageFormat; // 图像文件的格式
    private String defaultImageFormat = "png"; //截图后缀
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); //获取全屏幕的宽高尺寸等数据

    public CameraTest() {
        filePreStr = defName;
        imageFormat = defaultImageFormat;
    }

    public CameraTest(String format) {
//        filePreStr = s;
        imageFormat = format;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setFilePreStr(String filePreStr) {
        this.filePreStr = filePreStr;
    }

    public String getFilePreStr() {
        return filePreStr;
    }

    //    public int getSerialNum(){
//        return serialNum;
//    }
//
//    public void setNumber(int serialNum) {
//        this.serialNum = serialNum;
//    }

    public void snapShot(String filePreStr,String serialNum) {

        try {
            //拷贝屏幕到一个BufferedImage对象screenshot
            BufferedImage screenshot = (new Robot()).createScreenCapture(new Rectangle(0, 0, (int) dimension.getWidth(), (int) dimension.getHeight()));
            // 根据文件前缀变量和文件格式变量，自动生成文件名p
            String name = filePreStr + serialNum + "." + imageFormat;
            File file = new File("src/main/java/Photo/"+filePreStr+serialNum + "." + imageFormat);
            System.out.print("Save File:" + name);
            // 将screenshot对象写入图像文件
            ImageIO.write(screenshot, imageFormat, file);
            System.out.println("---END!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    public static void main(String[] args) {
//        CameraTest cam = new CameraTest( "png");
//        cam.snapShot("test","1");
//    }
}
