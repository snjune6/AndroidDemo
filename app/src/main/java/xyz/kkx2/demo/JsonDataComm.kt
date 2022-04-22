package xyz.kkx2.demo

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class JsonDataComm {

    interface JsonService {
        @GET("posts/")
        fun getJson(): Call<List<Map<String, Object>>>
    }


    fun getJson(baseUrl: String): List<Map<String, Object>>? {

        var map: List<Map<String, Object>>? = null;

        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build();
        val service = retrofit.create(JsonService::class.java);

        service.getJson()?.enqueue(object : Callback<List<Map<String, Object>>>{
            override fun onResponse(call: Call<List<Map<String, Object>>>, response: Response<List<Map<String, Object>>>) {
                if(response.isSuccessful){
                    // 정상적으로 통신이 성고된 경우
                    var result: List<Map<String, Object>>? = response.body()
                    Log.d("YMC", "onResponse 성공: " + result);
                    map = result;
                }else{
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("YMC", "onResponse 실패")
                }
            }

            override fun onFailure(call: Call<List<Map<String, Object>>>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("YMC", "onFailure 에러: " + t.message.toString());
            }
        })

        return map;
    }



}