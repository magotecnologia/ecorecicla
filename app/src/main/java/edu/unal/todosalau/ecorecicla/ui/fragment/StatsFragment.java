package edu.unal.todosalau.ecorecicla.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

import edu.unal.todosalau.ecorecicla.databinding.FragmentStatsBinding;
import edu.unal.todosalau.ecorecicla.ui.viewmodel.StatsViewModel;
import ir.mahozad.android.PieChart;

public class StatsFragment extends Fragment {
    private FragmentStatsBinding binding;

    private StatsViewModel viewModel;

    public static StatsFragment newInstance() {
        return new StatsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentStatsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(StatsViewModel.class);
        PieChart.Slice paperSlice = buildBadicSlice(0.2F, "PAPEL");
        PieChart.Slice glassSlice = buildBadicSlice(0.4F, "VIDRIO");
        binding.pieChart.setSlices(new ArrayList<>(Arrays.asList(paperSlice, glassSlice)));
    }

    PieChart.Slice buildBadicSlice(Float fraction, String legend) {
        return new PieChart.Slice(fraction, Color.rgb(120, 181, 0), Color.rgb(149, 224, 0), NumberFormat.getPercentInstance().format(fraction), null, null, null, null, null, null, null, null, null, null, null, legend, null, null, null, null, null, null, null, null, null, 1f, 1f);
    }

}