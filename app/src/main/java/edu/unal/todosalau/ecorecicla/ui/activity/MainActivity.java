package edu.unal.todosalau.ecorecicla.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import edu.unal.todosalau.ecorecicla.R;
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
        navController.navigate(R.id.action_homeFragment_to_statsFragment);
    }
}