package edu.unal.todosalau.ecorecicla.ui.fragment;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.os.Bundle;
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
        });
        setClickEvents();
    }

    private void setClickEvents() {
        binding.btnLogin.setOnClickListener(view -> {
            viewModel.login(binding.etUser.getText().toString(), binding.etPassword.getText().toString());
        });
        binding.tvRegister.setOnClickListener(view -> {
            navController.navigate(R.id.action_from_login_to_register);
        });
        binding.tvPasswordRecovery.setOnClickListener(view -> {
            navController.navigate(R.id.action_from_login_to_restore);
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}