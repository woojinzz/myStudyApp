package com.kwj.mystudyapp;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Ex32ServerRequestLogin extends StringRequest {
    // 서버 URL 설정 ( PHP 파일 연동 )

    //222222222222222222222
    final static private String URL = "http://dnwls.dothome.co.kr/test/login.php";
    private Map<String, String> map;


    public Ex32ServerRequestLogin(String id, String pw, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("id",id);
        map.put("pw",pw);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
