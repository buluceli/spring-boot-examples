package com.reke.learn.bootExamples.controller;

import com.reke.learn.bootExamples.config.Constant;
import com.reke.learn.bootExamples.util.Sha1Util;
import com.reke.learn.bootExamples.util.TenpayUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by sinocall on 2017/7/14.
 */
@RestController
public class ShareController {

	@RequestMapping("weixinShareConfig")

	public Map<String,String> weixinShareConfig(String currentUrl) {
		String nonce_str = Sha1Util.getNonceStr();
		String timestamp = Sha1Util.getTimeStamp();

		// 签名参数列表appId，partnerId，prepayId，nonceStr，timeStamp，package，唯有以上字段参与签名
		TreeMap<String, String> prePayParams = new TreeMap<String, String>();
		prePayParams.put("noncestr", nonce_str);
		prePayParams.put("timestamp", timestamp);
		prePayParams.put("jsapi_ticket", TenpayUtil.getJsapiTicket());
		StringBuilder url = new StringBuilder();
		url.append(currentUrl);
		prePayParams.put("url", url.toString());
		String sign = TenpayUtil.signWxSha1(prePayParams);
		Map<String,String> data = new HashMap<String,String>();
		data.put("appId", Constant.WEIXIN_H5_AppID);
		data.put("timestamp", timestamp);
		data.put("noncestr", nonce_str);
		data.put("signature", sign);

		return data;
	}
}
