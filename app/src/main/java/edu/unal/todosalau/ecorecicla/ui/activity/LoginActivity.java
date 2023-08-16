package edu.unal.todosalau.ecorecicla.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import dagger.hilt.android.AndroidEntryPoint;
import edu.unal.todosalau.ecorecicla.R;
import edu.unal.todosalau.ecorecicla.databinding.ActivityLoginBinding;
import edu.unal.todosalau.ecorecicla.ui.viewmodel.LoginViewModel;

@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity {
    private NavHostFragment navHostFragment;
    private LoginViewModel viewModel;

    private ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.login_nav_host_fragment);
        viewModel.getState().observe(this, state -> {
            if (state.getLogged()) {
                startActivity(new Intent(this, MainActivity.class));
            }
        });
    }

}
