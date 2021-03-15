package com.KimYunho.bookyourapartment.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.KimYunho.bookyourapartment.R;
import com.KimYunho.bookyourapartment.RecyclerViewAdapter;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    String s1[], s2[];
    int images[]={R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background};

    RecyclerView recyclerViewHome;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewHome = root.findViewById(R.id.home_recycler);

        s1 = getResources().getStringArray(R.array.apartment_titles);
        s2 = getResources().getStringArray(R.array.apartment_descriptions);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(root.getContext(), s1, s2, images);
        recyclerViewHome.setAdapter(recyclerViewAdapter);
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(root.getContext()));

        return root;
    }
}