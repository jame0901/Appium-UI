package PublicMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

    //重构后Get方法：
    public static  CloseableHttpResponse get(String url) throws IOException {
        //创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建一个HttpGet的请求对象
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);
        String response = getResponseJson(httpResponse).toJSONString();
        System.out.println("请求路径：" + url +" "+ httpResponse + "返回结果：" + response);
        return httpResponse;

    }

    //2. Get 请求方法（带请求头信息）
    public static CloseableHttpResponse get(String url, HashMap<String, String> headermap) throws IOException {
        //创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建一个HttpGet的请求对象
        HttpGet httpget = new HttpGet(url);

        //加载请求头到httpget对象
        for (Map.Entry<String, String> entry : headermap.entrySet()) {
            httpget.addHeader(entry.getKey(), entry.getValue());
        }
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);
        String response = getResponseJson(httpResponse).toJSONString();
        System.out.println("请求路径：" + url +" "+ httpResponse + "返回结果：" + response);
        return httpResponse;

    }

    //3. POST方法
    public static CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headermap) throws IOException {
        //创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建一个HttpPost的请求对象
        HttpPost httppost = new HttpPost(url);
        //设置请求参数,post请求的body部分
        httppost.setEntity(new StringEntity(entityString));
        //加载请求头到httppost对象，post请求的头部分，如果报文格式是json还是xml等
        for (Map.Entry<String, String> entry : headermap.entrySet()) {
            httppost.addHeader(entry.getKey(), entry.getValue());
        }
        //发送post请求
        System.out.println("请求参数："+ entityString);
        CloseableHttpResponse httpResponse = httpclient.execute(httppost);
        String response = getResponseJson(httpResponse).toJSONString();
        System.out.println("请求路径：" + url +" "+ httpResponse + "返回结果：" + response);
        return httpResponse;
    }


    public static JSONObject getResponseJson (CloseableHttpResponse response) throws IOException {
        String responseString = EntityUtils.toString(response.getEntity(),"UTF-8");
        JSONObject responseJson = JSON.parseObject(responseString);
        return responseJson;
    }
}

