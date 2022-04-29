package com.example.localtools;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class HomeFragment extends Fragment {

    private ImageButton button;
    private ImageButton button2;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = (ImageButton) getView().findViewById(R.id.perkakas);
        button2 = (ImageButton) getView().findViewById(R.id.tukang);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChatActivity();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChatActivity2();
            }
        });
    }

    public void openChatActivity(){
        Fragment fragment = new SewaPerkakasFragment();
        getParentFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, fragment).commit();

    }

    public void openChatActivity2(){
        Fragment fragment = new SewaTukangFragment();
        getParentFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, fragment).commit();

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}

