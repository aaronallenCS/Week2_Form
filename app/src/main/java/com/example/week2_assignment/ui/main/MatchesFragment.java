package com.example.week2_assignment.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.week2_assignment.Match;
import com.example.week2_assignment.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MatchesFragment extends Fragment {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    MatchesViewAdapter recyclerViewAdapter;

    DatabaseReference mBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mBase = FirebaseDatabase.getInstance().getReference("matches");

        View view = inflater.inflate(R.layout.fragment_matches, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(view.getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        FirebaseRecyclerOptions<Match> options =
                new FirebaseRecyclerOptions.Builder<Match>()
                .setQuery(mBase, Match.class)
                .build();

        recyclerViewAdapter = new MatchesViewAdapter(options);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        recyclerViewAdapter.startListening();
    }

    @Override
    public void onStop()
    {
        super.onStop();
        recyclerViewAdapter.stopListening();
    }
}