/*package xyz.kkx2.demo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface TestService {

    @GET("posts/")
    fun getUser(): Call<List<Map<String, Object>>>

    @GET("posts/{page}")
    fun getUserPage(@Path("page") page: String): Call<Test>
}*/