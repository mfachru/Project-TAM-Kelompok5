package com.example.localtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    public static ProfileFragment Instance;

    private EditText editNama;
    private EditText editEmail;
    private EditText editAlamat;
    private EditText editNohp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editNama = (EditText) getView().findViewById(R.id.profile_nama);
        editEmail = (EditText) getView().findViewById(R.id.profile_email);
        editAlamat = (EditText) getView().findViewById(R.id.profile_alamat);
        editNohp = (EditText) getView().findViewById(R.id.profile_no_hp);

        LoadData();

        Instance = this;
    }

    private void LoadData(){
        ArrayList<String> listItem;
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Profile Data", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Saved Profile Data", null);
        listItem = gson.fromJson(json, new TypeToken<ArrayList<String>>(){}.getType());

        if(listItem != null) {
            editNama.setText(listItem.get(0));
            editEmail.setText(listItem.get(1));
            editAlamat.setText(listItem.get(2));
            editNohp.setText(listItem.get(3));
        }


    }

}