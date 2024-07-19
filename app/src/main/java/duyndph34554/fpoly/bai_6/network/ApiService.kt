package duyndph34554.fpoly.bai_6.network

import duyndph34554.fpoly.bai_6.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("?results=20")
    fun getUsers(): Call<ApiResponse>
}

data class ApiResponse(val results: List<User>)