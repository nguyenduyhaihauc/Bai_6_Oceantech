package duyndph34554.fpoly.bai_6.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import duyndph34554.fpoly.bai_6.model.User
import duyndph34554.fpoly.bai_6.network.ApiResponse
import duyndph34554.fpoly.bai_6.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: ApiService) {

    fun getUsers(): LiveData<List<User>> {
        val data = MutableLiveData<List<User>>()

        apiService.getUsers().enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    data.value = response.body()?.results
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                data.value = emptyList()
            }
        })

        return data
    }
}