package com.fickler.apiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.fickler.apiclientsdk.model.User;

import java.util.HashMap;
import java.util.Map;

import static com.fickler.apiclientsdk.utils.SingUtils.getSign;

/**
 * 调用第三方接口的客户端
 * @author dell
 * @date 2023/5/16 10:59
 */
public class ApiClient {

    private String accessKey;
    private String secretKey;

    public ApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.get("http://localhost:8123/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.post("http://localhost:8123/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    private Map<String, String> getHeader(String body) {
        Map<String, String> headers = new HashMap<>();
        headers.put("accessKey", accessKey);
        // 一定不能发送给后端
        //headers.put("secretKey", secretKey);
        headers.put("nonce", RandomUtil.randomNumbers(4));
        headers.put("body", body);
        headers.put("timestamp", String.valueOf(System.currentTimeMillis()/1000));
        headers.put("sign", getSign(body, secretKey));
        return headers;
    }

    public String getUsernameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post("http://localhost:8123/api/name/user")
                .addHeaders(getHeader(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

}
