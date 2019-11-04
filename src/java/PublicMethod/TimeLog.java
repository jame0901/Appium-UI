package PublicMethod;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeLog{
    private String log;
    public void setLog(String log) {
        this.log = log;
    }
    public String getLog() {
        return log;
    }
    public void insertLog(String log) throws Exception {
        //文件放在src/main/java/Log 目录下 命名为log.text
        File file = new File("src/java/Log/log.text");
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        //如果文件不存在，创建一个文件
        if (!file.exists()) {
            file.createNewFile();
            try {
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                bw.write(dateFormat.format(date)+"-->"+log);
                bw.newLine();
            } catch (Exception e) {
            } finally {
                if (bw!=null){
                    try {
                        bw.close();
                    }catch (Exception e){
                    }
                }
                if (fw!=null){
                    try {
                        fw.close();
                    }catch (Exception e){
                    }
                }
            }
        }else {
            try {
                //如果文件存在，则追加内容
                fw = new FileWriter(file, true);
            } catch (Exception e) {
            }
            pw = new PrintWriter(fw);
            pw.println(dateFormat.format(date)+"-->"+log);
            pw.flush();
            try {
                fw.flush();
                if (pw!=null){
                    try {
                        pw.close();
                    }catch (Exception e){
                    }
                }
                if (fw!=null){
                    try {
                        fw.close();
                    }catch (Exception e){
                    }
                }
            }catch (Exception e){
                System.out.println("释放日志资源异常");
            }
        }
    }
}
