package StartMethod;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class RunSuite {
    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        List<String> testFieldList = new ArrayList<>();
        //加载"testng_xrs_homePage.xml"文件
        testFieldList.add("testng_xrs_homePage.xml");
        testng.setTestSuites(testFieldList);
        testng.addListener(tla);
        //设置线程池大小为：1
        testng.setSuiteThreadPoolSize(1);
        testng.run();
        System.out.println("ConfigurationFailures: " + tla.getConfigurationFailures());
        System.out.println("getFailedTests()" + tla.getFailedTests());
    }
}
