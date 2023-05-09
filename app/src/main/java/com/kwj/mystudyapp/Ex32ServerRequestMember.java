package com.kwj.mystudyapp;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Ex32ServerRequestMember extends StringRequest {
    // 서버 URL 설정 ( PHP 파일 연동 )

    //222222222222222222222
    final static private String URL = "http://dnwls.dothome.co.kr/test/member_list.php";
    private Map<String, String> map;


    public Ex32ServerRequestMember( Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
