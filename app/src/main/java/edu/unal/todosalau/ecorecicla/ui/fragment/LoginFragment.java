package edu.unal.todosalau.ecorecicla.ui.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.unal.todosalau.ecorecicla.R;

public class LoginFragment extends Fragment {

    private LoginViewModel viewModel;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.state.observe(getViewLifecycleOwner(), loginState -> {
            if(loginState.getLogged()){
                //Manda a la otra actividad
            }
            if(!loginState.getError().isEmpty()){

            }
        });

    }
}