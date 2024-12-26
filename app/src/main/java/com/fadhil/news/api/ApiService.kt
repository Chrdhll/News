package com.fadhil.news.api

import androidx.activity.result.IntentSenderRequest
import com.fadhil.news.models.BeritaResponse
import com.fadhil.news.models.LoginRequest
import com.fadhil.news.models.LoginResponse
import com.fadhil.news.models.RegisterRequest
import com.fadhil.news.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @FormUrlEncoded
    @POST("MobileApiBasic/register.php")
    fun register(
        @Field("username") username:String,
        @Field("password") password:String,
        @Field("fullname") fullname:String,
        @Field("email") email:String,
    ):Call<RegisterResponse>

    @FormUrlEncoded
    @POST("MobileApiBasic/login.php")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String,

    ):Call<LoginResponse>

    @GET("MobileApiBasic/get_berita.php")
    fun getListBerita(@Query("judul") judul: String): Call<BeritaResponse>
}