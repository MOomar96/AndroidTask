package com.example.data.di

import android.util.Log
import com.example.data.api.ProductServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module()
object NetworkModule {

    @Provides
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor{
        return  HttpLoggingInterceptor{
            Log.e("API",it)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        return  OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun providesGsonConverterFactory():GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gsonConverter: GsonConverterFactory, okHttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .client(okHttpClient)
            .addConverterFactory(gsonConverter)
            .build()
    }

    @Singleton
    @Provides
    fun provideProductService(retrofit: Retrofit): ProductServices {
        return retrofit.create(ProductServices::class.java)
    }
}