package edu.unal.todosalau.ecorecicla.ui.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import edu.unal.todosalau.ecorecicla.R;
import edu.unal.todosalau.ecorecicla.databinding.FragmentCategoryOptionBinding;
import edu.unal.todosalau.ecorecicla.ui.state.EMaterial;
import edu.unal.todosalau.ecorecicla.ui.viewmodel.RecordRecycleViewModel;

public class CategoryOptionFragment extends Fragment implements DatePickerDialog.OnDateSetListener {
    private FragmentCategoryOptionBinding binding;

    private RecordRecycleViewModel viewModel;

    public static CategoryOptionFragment newInstance() {
        return new CategoryOptionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCategoryOptionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(RecordRecycleViewModel.class);
        setMaterial();
        setActualDateIfEmpty();
        setListeners();


    }

    private void setMaterial() {
        EMaterial material = CategoryOptionFragmentArgs.fromBundle(getArguments()).getMaterial();
        switch (material) {
            case PAPER: {
                binding.categoryGlassACIV.setImageResource(R.drawable.category_paper);
                String initialText = binding.titleCategoryTV.getText().toString();
                String modifiedText = initialText + " " + getResources().getString(R.string.paper);
                binding.titleCategoryTV.setText(modifiedText);
                break;
            }
            case GLASS: {
                binding.categoryGlassACIV.setImageResource(R.drawable.category_glass);
                String initialText = binding.titleCategoryTV.getText().toString();
                String modifiedText = initialText + " " + getResources().getString(R.string.glass);
                binding.titleCategoryTV.setText(modifiedText);
                break;
            }
            case PLASTIC: {
                binding.categoryGlassACIV.setImageResource(R.drawable.category_plastic);
                String initialText = binding.titleCategoryTV.getText().toString();
                String modifiedText = initialText + " " + getResources().getString(R.string.plastic);
                binding.titleCategoryTV.setText(modifiedText);
                break;
            }
        }
    }

    private void setActualDateIfEmpty() {
        if (binding.optionDateS.getText().toString().isEmpty()) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String actualDate = sdf.format(date);
            binding.optionDateS.setText(actualDate);
        }
    }

    private void setListeners() {
        binding.optionDateS.setOnClickListener(v -> {
            String regex = "^(?:3[01]|[12][0-9]|0?[1-9])([\\-/])(0?[1-9]|1[1-2])\\1\\d{4}";
            Calendar date;
            if (binding.optionDateS.getText().toString().matches(regex)) {
                try {
                    date = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    date.setTime(sdf.parse(binding.optionDateS.getText().toString()));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            } else {
                date = Calendar.getInstance();
            }
            DatePickerDialog dialog = new DatePickerDialog(getContext(), this, date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
            dialog.show();
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        binding.optionDateS.setText(dayOfMonth + "/" + month + "/" + year);
    }
}