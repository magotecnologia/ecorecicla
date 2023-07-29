package edu.unal.todosalau.ecorecicla.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.unal.todosalau.ecorecicla.databinding.FragmentCategoryPaperBinding;
import edu.unal.todosalau.ecorecicla.ui.viewmodel.RecordRecycleViewModel;

public class CategoryGlassFragment extends Fragment {
    private FragmentCategoryPaperBinding binding;

    private RecordRecycleViewModel mViewModel;

    public static CategoryGlassFragment newInstance() {
        return new CategoryGlassFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCategoryPaperBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RecordRecycleViewModel.class);
    }

}