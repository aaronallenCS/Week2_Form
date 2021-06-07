package com.example.week2_assignment.ui.main;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.week2_assignment.Match;
import com.example.week2_assignment.R;
import com.firebase.geofire.GeoFire;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MatchesFragment extends Fragment implements LocationListener {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    MatchesViewAdapter recyclerViewAdapter;


    DatabaseReference mBase;
    private LocationManager locationManager;

    TextView longi;
    TextView lat;


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



        longi = view.findViewById(R.id.longi);
        lat = view.findViewById(R.id.lat);



        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

        recyclerViewAdapter = new MatchesViewAdapter(options);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }


    @Override
    public void onLocationChanged(Location location)
    {
        lat.setText(location.getLatitude() + ", ");
        longi.setText(location.getLongitude()+"");
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