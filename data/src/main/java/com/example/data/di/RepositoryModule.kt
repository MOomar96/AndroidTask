package com.example.data.di

import com.example.data.Repository.ProductRepository
import com.example.domain.contracts.ProductOnlineData
import com.example.domain.contracts.ProductRepositoryContract
import com.example.data.dataSource.ProductOnlineDataImpl
import com.example.data.api.ProductServices
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun bindSourcesRepository(
        impl : ProductRepository
    ): ProductRepositoryContract {
        return impl
    }

    @Provides
    fun providesProductOnlineData(
        productServices: ProductServices
    ): ProductOnlineData {
        return  ProductOnlineDataImpl(productServices)
    }


}