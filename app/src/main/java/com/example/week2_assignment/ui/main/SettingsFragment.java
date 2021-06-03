package com.example.week2_assignment.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.week2_assignment.R;
import com.example.week2_assignment.db.Settings;
import com.example.week2_assignment.db.SettingsDao;
import com.example.week2_assignment.db.SettingsDatabase;
import com.google.android.material.slider.Slider;

import java.util.List;


public class SettingsFragment extends Fragment
{
    Spinner matchReminder;
    Slider maxDistance;
    Spinner gender;
    Spinner privatePublicAccount;
    Slider interestedAge;
    Button changeSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        SettingsDatabase db = SettingsDatabase.getDbInstance(getActivity().getApplicationContext());

        matchReminder = v.findViewById(R.id.match_reminder_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.reminder_time_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        matchReminder.setAdapter(adapter);


        maxDistance = v.findViewById(R.id.max_distance_seek);
        int[] distance = {0};
        maxDistance.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                int sliderValue = (int)slider.getValue();
                distance[0] = sliderValue;
            }
        });


        gender = v.findViewById(R.id.gender_spinner);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.gender_array, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(genderAdapter);

        privatePublicAccount = v.findViewById(R.id.public_private_spinner);
        ArrayAdapter<CharSequence> publicPrivateAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.private_public_array, android.R.layout.simple_spinner_item);
        publicPrivateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        privatePublicAccount.setAdapter(publicPrivateAdapter);

        interestedAge = v.findViewById(R.id.age_range_bar);
        int[] age = {0};
        interestedAge.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                age[0] = (int)slider.getValue();
            }
        });

        //DATABASE FUNCTIONS

        changeSettings = v.findViewById(R.id.update_settings);
        changeSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveSettings(db,
                        matchReminder.getSelectedItem().toString(),
                        distance[0],
                        gender.getSelectedItem().toString(),
                        privatePublicAccount.getSelectedItem().toString(),
                        age[0]);

                Toast.makeText(getActivity().getApplicationContext(), "Settings Updated!", Toast.LENGTH_LONG).show();
            }
        });

        SettingsDao settingDao = db.settingsDao();
        List<Settings> settings = settingDao.getAll();
        if(!settings.isEmpty())
        {
            //grabs most recent entry in the DB
            interestedAge.setValue(settings.get(settings.size() - 1).ageRange);
            privatePublicAccount.setSelection(publicPrivateAdapter.getPosition(settings.get(settings.size() - 1).privateOrPublic));
            gender.setSelection(genderAdapter.getPosition(settings.get(settings.size() - 1).gender));
            maxDistance.setValue(settings.get(settings.size() - 1).maxDistance);
            matchReminder.setSelection(adapter.getPosition(settings.get(settings.size() - 1).reminderTime));
        }


        return v;
    }

    private void saveSettings(SettingsDatabase db, String matchReminder, int distance, String gender, String privatePublic, int age)
    {
        Settings setting = new Settings();
        setting.reminderTime = matchReminder;
        setting.maxDistance = distance;
        setting.gender = gender;
        setting.privateOrPublic = privatePublic;
        setting.ageRange = age;

        db.settingsDao().insertSettings(setting);
    }


}