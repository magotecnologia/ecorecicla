package edu.unal.todosalau.ecorecicla.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.unal.todosalau.ecorecicla.R;
import edu.unal.todosalau.ecorecicla.databinding.ActivityLoginBinding;
import edu.unal.todosalau.ecorecicla.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        navigateToCategoryFragment();
    }

    public void navigateToCategoryFragment() {
        navController.navigate(R.id.homeFragment);
    }
}