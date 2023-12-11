package com.example.omnimove_mobile

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.omnimove_mobile.data.lokal.UserEntity
import com.example.omnimove_mobile.databinding.FragmentLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = RegisterViewModel(application = requireActivity().application)

        binding.login.setOnClickListener {
            val name = binding.username.text.toString()
            val password = binding.password.text.toString()
            val userEntity = UserEntity(0,name,"coba@gmail", password)
            CoroutineScope(viewModel.viewModelScope.coroutineContext).launch {
                viewModel.addUser(userEntity)
            }

            findNavController().navigate(R.id.action_loginFragment_to_berandaFragment)
        }
        return binding.root
    }


}