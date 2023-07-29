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

import edu.unal.todosalau.ecorecicla.databinding.FragmentCategoryBinding;
import edu.unal.todosalau.ecorecicla.ui.state.EMaterial;
import edu.unal.todosalau.ecorecicla.ui.viewmodel.CategoryViewModel;

public class CategoryFragment extends Fragment {

    private FragmentCategoryBinding binding;
    private CategoryViewModel viewModel;
    private NavController navController;

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = findNavController(this);
        viewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        setListeners();

    }

    private void setListeners() {
        binding.greenRecyclingIV.setOnClickListener(v -> {
            CategoryFragmentDirections.CategoryToRecord action = CategoryFragmentDirections.categoryToRecord();
            action.setMaterial(EMaterial.GLASS);
            navController.navigate(action);
        });
        binding.blueRecyclinIV.setOnClickListener(v -> {
            CategoryFragmentDirections.CategoryToRecord action = CategoryFragmentDirections.categoryToRecord();
            action.setMaterial(EMaterial.PAPER);
            navController.navigate(action);
        });
        binding.yellowRecyclinIV.setOnClickListener(v -> {
            CategoryFragmentDirections.CategoryToRecord action = CategoryFragmentDirections.categoryToRecord();
            action.setMaterial(EMaterial.PLASTIC);
            navController.navigate(action);
        });
    }
}