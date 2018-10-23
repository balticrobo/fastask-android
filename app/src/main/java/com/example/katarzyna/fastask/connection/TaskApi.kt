package com.example.katarzyna.fastask.connection

import android.content.Context
import com.example.katarzyna.fastask.model.dto.TaskDto
import com.example.katarzyna.fastask.model.entity.Task
import com.example.katarzyna.fastask.model.entity.User
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import java.util.concurrent.TimeUnit

interface TaskApi {

    @GET("tasks")
    fun getAllActiveTask(): Observable<List<Task>>

    @GET("mytasks")
    fun getCreatedByMeTask(): Observable<List<Task>>

    @POST("users")
    fun login(@Body login: User): Call<Void>?

    @POST("tasks")
    fun createTask(@Body task: Task): Call<Void>?

    @PUT("tasks")
    fun reserveTast(@Body taskDto: TaskDto): Call<Void>?



    companion object Factory {
        var token: String? = null

        private fun createClient(): OkHttpClient {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY


                val httpClient = OkHttpClient.Builder()
                        .readTimeout(2, TimeUnit.SECONDS)
                httpClient
                        .addInterceptor(logging)
                        .addInterceptor { chain ->
                            val original = chain.request()
                            val requestBuilder = original.newBuilder()
                                    .header("Authorization", token)
                            val request = requestBuilder.build()
                            chain.proceed(request)
                        }
                return httpClient.build()
        }

        fun create(context: Context):TaskApi{
            val httpHostName = "http://virtserver.swaggerhub.com/katstudz/Fastask/1.0.0"
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create())
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                    .client(createClient())
                    .baseUrl(httpHostName)
                    .build()

            return retrofit.create(TaskApi::class.java)
        }

    }

}