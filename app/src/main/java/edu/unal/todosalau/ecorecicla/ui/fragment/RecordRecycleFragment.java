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

public class RecordRecycleFragment extends Fragment {

    private RecordRecycleViewModel mViewModel;

    public static RecordRecycleFragment newInstance() {
        return new RecordRecycleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_record_recycle, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RecordRecycleViewModel.class);
        // TODO: Use the ViewModel
    }

}