package com.reke.learn.bootExamples.util;

import com.reke.learn.bootExamples.config.Constant;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import java.util.TreeMap;


public class TenpayUtil {

	public static String signWxSha1(TreeMap<String,String> map){
		Set<String> keySet = map.keySet();

		StringBuilder stringSignTemp = new StringBuilder();
		int count = 0;
		for(String key : keySet) {
			String value = map.get(key);
			if(value.equals("")) continue;
			if(0 == count) {
				stringSignTemp.append(key +"="+ value);
			}else {
				stringSignTemp.append("&"+ key +"="+ value);
			}
			++count;
		}
		System.out.println(stringSignTemp.toString());
		String sign = Sha1Util.getSha1(stringSignTemp.toString());
		return sign;

	}

	public static String getDeviceToken() {

		//https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
		//{"access_token":"ACCESS_TOKEN","expires_in":7200}
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&" + "appid=" + Constant.WEIXIN_H5_AppID + "&secret=" + Constant.WEIXIN_H5_AppSecret;
		String response = BaseHttpClient.doGet(url);
		System.out.println("get weixin deviceToken:" + response);
		JSONObject jsObject = JSONObject.fromObject(response);
		String deviceToken = jsObject.getString("access_token");

		return deviceToken;


	}

	public static String getJsapiTicket() {

		//https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi
		//{"errcode":0,"errmsg":"ok","ticket":"bxLdikRXVbTPdHSM05e5u5sUoXNKd8-41ZO3MhKoyN5OfkWITDGgnr2fwJ0m9E8NYzWKVZvdVtaUgWvsdshFKA","expires_in":7200}
		String deviceToken = getDeviceToken();
		String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + deviceToken + "&type=jsapi";
		String response = BaseHttpClient.doGet(url);
		System.out.println("getJsapiTicket:" + response);
		JSONObject jsObject = JSONObject.fromObject(response);
		String jsapiTicket = jsObject.getString("ticket");


		return jsapiTicket;
	}

}
