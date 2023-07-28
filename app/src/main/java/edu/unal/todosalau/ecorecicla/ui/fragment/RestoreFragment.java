package edu.unal.todosalau.ecorecicla.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.unal.todosalau.ecorecicla.R;
import edu.unal.todosalau.ecorecicla.ui.viewmodel.RestoreViewModel;

public class RestoreFragment extends Fragment {

    private RestoreViewModel mViewModel;

    public static RestoreFragment newInstance() {
        return new RestoreFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_restore, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RestoreViewModel.class);
        // TODO: Use the ViewModel
    }

}