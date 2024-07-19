package duyndph34554.fpoly.bai_6.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import duyndph34554.fpoly.bai_6.model.User
import duyndph34554.fpoly.bai_6.repository.UserRepository
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val users: LiveData<List<User>> = userRepository.getUsers()
}