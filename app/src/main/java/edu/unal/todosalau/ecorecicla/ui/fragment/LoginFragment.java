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

public class LoginFragment extends Fragment {
//    private FragmentLoginBinding binding;
    private LoginViewModel viewModel;

    private NavController navController;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        binding = FragmentLoginBinding.inflate(inflater, container, false);
//        return binding.getRoot();
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = findNavController(this);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.state.observe(getViewLifecycleOwner(), loginState -> {
            if (loginState.getLogged()) {
                //Manda a la otra actividad
            }
            if (!loginState.getError().isEmpty()) {
                //Muestra el error
            }
        });
        setClickEvents();
    }

    private void setClickEvents() {
//        binding.loginButton.setOnClickListener(view -> {
//            //viewModel.login(binding.txtUser.getText().toString(), binding.txtUser.getText().toString());
//        });
//        binding.btnRegister.setOnClickListener(view -> {
//            navController.navigate(R.id.action_from_login_to_register);
//        });
//        binding.btnPasswordRecovery.setOnClickListener(view -> {
//            navController.navigate(R.id.action_from_login_to_restore);
//        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }
}