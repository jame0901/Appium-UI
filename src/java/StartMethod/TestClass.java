package StartMethod;

import PublicMethod.HttpRequest;
import org.apache.commons.codec.binary.Hex;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.Assert;
import org.junit.Test;
import sun.misc.BASE64Encoder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;

public class TestClass {
//    public static void main(String[] args) {
//        TestListenerAdapter tla = new TestListenerAdapter();
//        TestNG testng = new TestNG();
//        List<String> testFieldList = new ArrayList<>();
//        //加载"testng_xrs_homePage.xml"文件
//        testFieldList.add("testng_xrs_homePage.xml");
//        testng.setTestSuites(testFieldList);
//        testng.addListener(tla);
//        //设置线程池大小为：1
//        testng.setSuiteThreadPoolSize(1);
//        testng.run();
//        System.out.println("ConfigurationFailures: " + tla.getConfigurationFailures());
//        System.out.println("getFailedTests()" + tla.getFailedTests());

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

//    public void reverse(){
//            int i;
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("输入一个三位数：");
//            i = scanner.nextInt();
//            if(i > 999){
//                System.out.println("输入的数字"+"'"+ i +"'"+"非三位数");
//                reverse();
//            }else if (i > 0 && i < 1000){
//                int a = i/100;
//                int b = i%100/10;
//                int c = i%10;
//                int d = a+ b*10 + c*100;
//                System.out.println("反转后的3位数："+d);
//            }
//        }

    public int resultNumber(int k,int n){
        int num = 0;
        for (int i = k; i <= n; i++){
            num +=countNumber(i,k);
        }
        return num;
    }

    public int countNumber(int i, int k){
        int num = 0;
        if (k == 0 && i == 0){
            return 1;
        }
        while (i > 0){
            if(k == i % 10){
                num++;
            }
            i = i/10;
        }
        return num;
    }

    public double sqrtMethod(double a, double b){

        return Math.sqrt(a*a+b*b);
    }

    @Test
    public void postTest()throws IOException{

        String url = "https://xesapi.speiyou.cn/v1/start_up_page/subject_list";
        HttpRequest httpRequest = new HttpRequest();
        HashMap<String,String> headerMap = new HashMap <String, String>();
        headerMap.put("V","7.7.0");
        headerMap.put("devid","zjx");
        headerMap.put("Content-Type","application/json");
        headerMap.put("client_type","1");
        headerMap.put("client_id","122103");
        HashMap<String,String> bodyMap = new HashMap <String, String>();
        bodyMap.put("area_code","010");
        bodyMap.put("grade_id","7");
        String userJsonString = JSON.toJSONString(bodyMap);
        CloseableHttpResponse closeableHttpResponse = httpRequest.post(url, userJsonString, headerMap);
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,200);

    }

        public static void main(String[] args) throws IOException {
            TestClass testClass = new TestClass();
//            System.out.println(testClass.resultNumber(1,141));
//            testClass.reverse();
//            int[] num_one = {1, 2, 13, 1, 13, 3, 5, 5, 7, 9, 9, 10, 10, 18, 18};
//            int[] num = new int[num_one.length/2];
//            int k = 0;
//            int number;
//            for (int i = 0; i < num_one.length; i++){
//                for (int j = i; j < num_one.length; j++){
//                    if ((num_one[i] == num_one[j]) && (i!=j)){
//                        System.out.println(num_one[j]);
//                        num[k] = num_one[j];
//                        k++;
//                    }
//                }
//            }
//            //从小到大排序
//            for (int i = 0; i < num.length - 1; i++) {
//                for (int j = 0; j < num.length - 1 - i; j++) {
//                    if (num[j] > num[j + 1]) {
//                        number = num[j];
//                        num[j] = num[j + 1];
//                        num[j + 1] = number;
//                    }
//                }
//            }
//            //从大到小排序
//            for (int i = 0;i < num.length-1 ; i++){
//                for (int j = num.length - 1; j > 0; j--) {
//                    if (num[j] > num[j - 1]){
//                        number = num[j];
//                        num[j] = num[j - 1];
//                        num[j - 1] = number;
//                    }
//                }
//            }
//            System.out.print("排序后的数组：");
//            for (int x:num) {
//                System.out.print(x+" ");
//            }
//            System.out.println("");
        }
}
