package PublicMethod;


import org.apache.http.Consts;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

    //重构后Get方法：
    public static  CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
        //创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建一个HttpGet的请求对象
        HttpGet httpget = new HttpGet(url);
        //执行请求,相当于jmeter上点击运行按钮，然后赋值给HttpResponse对象接收
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);

        return httpResponse;

    }

    //2. Get 请求方法（带请求头信息）
    public static CloseableHttpResponse get(String url, HashMap<String, String> headermap) throws ClientProtocolException, IOException {
        //创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建一个HttpGet的请求对象
        HttpGet httpget = new HttpGet(url);

        //加载请求头到httpget对象
        for (Map.Entry<String, String> entry : headermap.entrySet()) {
            httpget.addHeader(entry.getKey(), entry.getValue());
        }
        //执行请求,相当于postman上点击发送按钮，然后赋值给HttpResponse对象接收
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);
        return httpResponse;

    }

    //3. POST方法
    public static CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headermap) throws ClientProtocolException, IOException {
        //创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建一个HttpPost的请求对象
        HttpPost httppost = new HttpPost(url);
        //设置请求参数,post请求的body部分;setEntity(),()中是一个httpEntity;get请求没有body部分，请求参数都在header中所以没用setEntity(）这个方法
        httppost.setEntity(new StringEntity(entityString));
        //加载请求头到httppost对象，post请求的头部分，如果报文格式是json还是xml等
        for (Map.Entry<String, String> entry : headermap.entrySet()) {
            httppost.addHeader(entry.getKey(), entry.getValue());
        }
        //发送post请求
        CloseableHttpResponse httpResponse = httpclient.execute(httppost);
        return httpResponse;
    }


    public static String httpPostJson(String url, String jsonStr, Map<String, String> headers) throws IOException {
        Request httpRequest = Request.Post(url).connectTimeout(5000).socketTimeout(5000);
        if (headers != null && headers.size() > 0) {
            for (String k : headers.keySet()) {
                httpRequest.setHeader(k, headers.get(k));
            }
        }
        return httpRequest.bodyString(jsonStr, ContentType.APPLICATION_JSON).execute().returnContent().asString(Consts.UTF_8);

    }
}

