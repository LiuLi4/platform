package com.bjfu.inspect.common;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * token的获取类
 * 将apiKey和secretKey换取token，注意有效期保存在expiresAt
 */
public class TokenHolder {
    /**
     * url , Token的url，http可以改为https
     */
    private static final String url = "http://openapi.baidu.com/oauth/2.0/token";

    /**
     * asr的权限 scope 是  "audio_voice_assistant_get"
     * tts 的权限 scope 是 "audio_tts_post"
     */
    private String scope;

    /**
     * 网页上申请语音识别应用获取的apiKey
     */
    private String apiKey;

    /**
     * 网页上申请语音识别应用获取的secretKey
     */
    private String secretKey;

    /**
     * 保存访问接口获取的token
     */
    private String token;

    /**
     * 当前的时间戳，毫秒
     */
    private long expiresAt;

    /**
     * @param apiKey    网页上申请语音识别应用获取的apiKey
     * @param secretKey 网页上申请语音识别应用获取的secretKey
     */
    public TokenHolder(String apiKey, String secretKey, String scope) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.scope = scope;
    }


    /**
     * 获取token，refresh 方法后调用有效
     *
     * @return
     */
    public String getToken() {
        return token;
    }

    /**
     * 获取过期时间，refresh 方法后调用有效
     *
     * @return
     */
    public long getExpiresAt() {
        return expiresAt;
    }

    /**
     * 获取token
     *
     * @return
     * @throws IOException   http请求错误
     * @throws Exception http接口返回不是 200, access_token未获取
     */
    public void resfresh() throws IOException, Exception {
        String getTokenURL = url + "?grant_type=client_credentials"
                + "&client_id=" + ConnUtil.urlEncode(apiKey) + "&client_secret=" + ConnUtil.urlEncode(secretKey);

//         打印的url出来放到浏览器内可以复现
//         System.out.println("token url:" + getTokenURL);

        URL url = new URL(getTokenURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        String result = ConnUtil.getResponseString(conn);
        parseJson(result);
//        System.out.println("Token result json:" + result);
    }

    /**
     * @param result token接口获得的result
     * @throws Exception
     */
    private void parseJson(String result) throws Exception {
        JSONObject json = JSONObject.parseObject(result);
        if (!json.containsKey("access_token")) {
            // 返回没有access_token字段
            throw new Exception("access_token not obtained, " + result);
        }
        if (!json.containsKey("scope")) {
            // 返回没有scope字段
            throw new Exception("scopenot obtained, " + result);
        }
        // scope = null, 忽略scope检查

        if (scope != null && !json.getString("scope").contains(scope)) {
            throw new Exception("scope not exist, " + scope + "," + result);
        }
//        System.out.println(json);
        token = json.getString("access_token");
        expiresAt = System.currentTimeMillis() + json.getLong("expires_in") * 1000;
    }
}
