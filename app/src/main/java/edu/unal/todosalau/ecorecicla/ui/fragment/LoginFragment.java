package edu.unal.todosalau.ecorecicla.ui.fragment;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import edu.unal.todosalau.ecorecicla.R;
import edu.unal.todosalau.ecorecicla.databinding.FragmentLoginBinding;
import edu.unal.todosalau.ecorecicla.ui.viewmodel.LoginViewModel;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    private LoginViewModel viewModel;

    private NavController navController;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = findNavController(this);
        viewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        viewModel.getState().observe(getViewLifecycleOwner(), loginState -> {
            if (!loginState.getError().isEmpty()) {
                //Muestra el error
            }
            if (!binding.etUser.getText().toString().equals(loginState.getUsername())) {
                binding.etUser.setText(loginState.getUsername());
            }
            if (!binding.etPassword.getText().toString().equals(loginState.getPassword())) {
                binding.etPassword.setText(loginState.getUsername());
            }
        });
        setClickEvents();
        bindData();
    }

    private void setClickEvents() {
        binding.btnLogin.setOnClickListener(view -> {
            if (checkLogin()) {
                viewModel.login();
            }
        });
        binding.tvRegister.setOnClickListener(view -> {
            navController.navigate(R.id.action_from_login_to_register);
        });
        binding.tvPasswordRecovery.setOnClickListener(view -> {
            navController.navigate(R.id.action_from_login_to_restore);
        });

    }

    private void bindData() {
        binding.etUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.setUser(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        binding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.setPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private boolean checkLogin() {
        if (binding.etUser.getText().toString().isEmpty()) {
            binding.etUser.setError(requireContext().getString(R.string.empty_field));
            return false;
        }
        if (binding.etPassword.getText().toString().isEmpty()) {
            binding.etPassword.setError(requireContext().getString(R.string.empty_field));
            return false;
        }
        return true;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}