package com.reke.learn.bootExamples.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wills on 10/17/14.
 */
public class BaseHttpClient {

//    private static Logger logger=Logger.getLogger(BaseHttpClient.class);

    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static String doGet(String url){
        return doGet(url,"utf-8");
    }

    public static String doGet(String url,String coding){
        CloseableHttpResponse response =null;
        try{
            HttpGet httpGet=new HttpGet(url);
            httpGet.setHeader("Content-Type","text/html; charset="+coding);
            response = httpClient.execute(httpGet);

            HttpEntity resEntity = response.getEntity();
            String httpResponse=null;
            if (resEntity != null) {
                httpResponse= IOUtils.toString(resEntity.getContent(),coding);
            }
            EntityUtils.consume(resEntity);
            response.close();
            return httpResponse;

        }catch(Exception e){
//            logger.warn("baseHttpClient GET method error,",e);
        }
        finally {
            if(response!=null){
                try {
                    response.close();
                }catch (Exception e){}
            }
        }
        return null;
    }

    public static String doGet(String url,String coding,String apikey){
        CloseableHttpResponse response =null;
        try{
            HttpGet httpGet=new HttpGet(url);
            httpGet.setHeader("Content-Type","text/html; charset="+coding);
            httpGet.setHeader("apikey",apikey);
            response = httpClient.execute(httpGet);

            HttpEntity resEntity = response.getEntity();
            String httpResponse=null;
            if (resEntity != null) {
                httpResponse= IOUtils.toString(resEntity.getContent(),coding);
            }
            EntityUtils.consume(resEntity);
            response.close();
            return httpResponse;

        }catch(Exception e){
//            logger.warn("baseHttpClient GET method error,",e);
        }
        finally {
            if(response!=null){
                try {
                    response.close();
                }catch (Exception e){}
            }
        }
        return null;
    }


    public static byte[] doGetBytes(String url){
        CloseableHttpResponse response =null;
        InputStream resultIS= null;
        byte[] result = null;
        try{
            HttpGet httpGet=new HttpGet(url);
//            httpGet.setHeader("Content-Type","text/html; charset="+coding);
            response = httpClient.execute(httpGet);

            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                resultIS = resEntity.getContent();
                int size = resultIS.available();
                result = new byte[size];
                resultIS.read(result);
                resultIS.close();
            }
            EntityUtils.consume(resEntity);
            response.close();
            return result;

        }catch(Exception e){
//            logger.warn("baseHttpClient doGetBytes method error,",e);
        }
        finally {
            if(response!=null){
                try {
                    response.close();;
                }catch (Exception e){}
            }
        }
        return null;
    }

    public static String doPostJson(String url,String json){

        StringEntity requestEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(requestEntity);
        try {
            CloseableHttpResponse  response = httpClient.execute(httpPost);
            HttpEntity resEntity = response.getEntity();
            String httpResponse = null;
            if (resEntity != null) {
                httpResponse= IOUtils.toString(resEntity.getContent(),"utf-8");
            }
            EntityUtils.consume(resEntity);
            response.close();
            return httpResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String doPost(String url,Map<String,String> data){
        return doPost(url,data,"UTF-8");
    }

    public static String doPost(String url,Map<String,String> data, String encoding){
        String httpResponse=null;

        CloseableHttpResponse response =null;
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type","application/x-www-form-urlencoded; charset="+encoding);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (String key:data.keySet()){
            nvps.add(new BasicNameValuePair(key, data.get(key)));
        }

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps,encoding));
            response = httpClient.execute(httpPost);
            HttpEntity resEntity = response.getEntity();

            if (resEntity != null) {
                httpResponse= IOUtils.toString(resEntity.getContent(),encoding);
            }
            EntityUtils.consume(resEntity);
            response.close();
            return httpResponse;
        } catch(Exception e){
//            logger.warn("baseHttpClient POST method error,", e);
        }finally {
            if(response!=null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return httpResponse;
    }
}
