package duyndph34554.fpoly.bai_6.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import duyndph34554.fpoly.bai_6.network.ApiService
import duyndph34554.fpoly.bai_6.network.RetrofitClient
import duyndph34554.fpoly.bai_6.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule() {
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return RetrofitClient.instance
    }

    @Provides
    @Singleton
    fun provideUseRepository(apiService: ApiService): UserRepository {
        return UserRepository(apiService)
    }
}