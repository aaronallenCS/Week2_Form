package com.example.week2_assignment.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.week2_assignment.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    TextView name;
    TextView description;
    TextView occupation;
    TextView dob;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tabbed, container, false);

        name = root.findViewById(R.id.name_tv);
        description = root.findViewById(R.id.description_tv);
        occupation = root.findViewById(R.id.occupation_tv);
        dob = root.findViewById(R.id.age_tv);

        name.setText(getActivity().getIntent().getStringExtra("name"));
        description.setText(getActivity().getIntent().getStringExtra("description"));
        occupation.setText(getActivity().getIntent().getStringExtra("occupation"));
        dob.setText(getActivity().getIntent().getStringExtra("DOB"));


        return root;
    }
}