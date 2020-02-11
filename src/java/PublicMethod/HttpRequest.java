package PublicMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequest {

    //重构后Get方法：
    public static String get(String url) throws IOException {
        //创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建一个HttpGet的请求对象
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);
        String response = getResponseJson(httpResponse).toJSONString();
        System.out.println("请求路径：" + url + " " + httpResponse + "\n返回结果：\n" + response);
        return response;

    }

    //2. Get 请求方法（带请求头信息）
    public static String getProxy(String url, HashMap <String, String> headermap , String host , int port , String scheme) throws IOException {
        HttpHost proxy = new HttpHost(host,port,scheme);
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        //创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建一个HttpGet的请求对象
        HttpGet httpget = new HttpGet(url);
        //加载请求头到httpget对象
        for (Map.Entry <String, String> entry : headermap.entrySet()) {
            httpget.addHeader(entry.getKey(), entry.getValue());
        }
        httpget.setConfig(config);
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);
        String response = getResponseJson(httpResponse).toJSONString();
        System.out.println("请求路径：" + url + " " + httpResponse + "\n返回结果：\n" + response);
        return response;

    }

    public static String get(String url, HashMap <String, String> headermap) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        for (Map.Entry <String, String> entry : headermap.entrySet()) {
            httpget.addHeader(entry.getKey(), entry.getValue());
        }
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);
        String response = getResponseJson(httpResponse).toJSONString();
        System.out.println("请求路径：" + url + " " + httpResponse + "\n返回结果：\n" + response);
        return response;

    }

    //3. POST方法

    public static String postProxy(String url, String entityString, HashMap <String, String> headermap , String host , int port , String scheme) throws IOException {
        HttpHost proxy = new HttpHost(host,port,scheme);
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        //创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建一个HttpPost的请求对象
        HttpPost httppost = new HttpPost(url);
        //设置请求参数,post请求的body部分
        httppost.setEntity(new StringEntity(entityString));
        //加载请求头到httppost对象，post请求的头部分，如果报文格式是json还是xml等
        for (Map.Entry <String, String> entry : headermap.entrySet()) {
            httppost.addHeader(entry.getKey(), entry.getValue());
        }
        httppost.setConfig(config);
        //发送post请求
        System.out.println("请求参数：" + entityString);
        CloseableHttpResponse httpResponse = httpclient.execute(httppost);
        String response = getResponseJson(httpResponse).toJSONString();
        System.out.println("请求路径：" + url + " " + httpResponse + "\n返回结果：\n" + response);
        return response;
    }

    public static String post(String url, String entityString, HashMap <String, String> headermap) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        httppost.setEntity(new StringEntity(entityString));
        for (Map.Entry <String, String> entry : headermap.entrySet()) {
            httppost.addHeader(entry.getKey(), entry.getValue());
        }
        System.out.println("请求参数：" + entityString);
        CloseableHttpResponse httpResponse = httpclient.execute(httppost);
        String response = getResponseJson(httpResponse).toJSONString();
        System.out.println("请求路径：" + url + " " + httpResponse + "\n返回结果：\n" + response);
        return response;
    }

    //获取接口返回结果
    public static JSONObject getResponseJson(CloseableHttpResponse response) throws IOException {
        String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
        JSONObject responseJson = JSON.parseObject(responseString);
        return responseJson;
    }

    //JSON解析方法
    public static String getValueByJPathString(JSONObject responseJson, String jpath) {
        Object object = responseJson;
        for (String s : jpath.split("/")) {
            if (!s.isEmpty()) {
                if (!(s.contains("[") || s.contains("]"))) {
                    object = ((JSONObject) object).get(s);

                } else if (s.contains("[") || s.contains("]")) {
                    object = ((JSONArray) ((JSONObject) object).get(s.split("\\[")[0]))
                            .get(Integer.parseInt(s.split("\\[")[1].replaceAll("]", "")));
                }
            }
        }
        return object.toString();
    }

    //发送请求
    public static String sendRequest(Map<String, String> params, String url, String sign){
        Request request = Request.Post(url);
        request.addHeader("sign", sign);
        String result = null;
        try {
            result = request.useExpectContinue()
                    .version(HttpVersion.HTTP_1_1)
                    .bodyString(JSON.toJSONString(params), ContentType.APPLICATION_JSON)
                    .setHeader("Content-Type", "application/json; charset=UTF-8")
                    .execute()
                    .returnContent()
                    .asString();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //修改hashMap中key对应的value
    public void updataHashMap(HashMap bodyMap,String key,Object value){

        if(bodyMap.get(key) != null){
            bodyMap.put(key,value);
        }
    }

    //修改List中的元素
    public void updataList(List list,int location,Object value) throws Exception{

        try {
            list.get(location);
        }catch (Exception e){
            System.out.println("输入的位置超过数组长度");
        }
        list.set(location,value);
    }
}
