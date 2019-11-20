package com.Sebastian.ClubCervezero.view.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Sebastian.ClubCervezero.R;
import com.Sebastian.ClubCervezero.adapter.PictureAdapterRecyclerView;
import com.Sebastian.ClubCervezero.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    androidx.appcompat.widget.Toolbar toolbar;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar = view.findViewById(R.id.toolbar);

        // mostrar toolbar con home
        //showToolbar("home", false, view);
        showToolbar("Inicio", view);

        RecyclerView picturesRecycler = view.findViewById(R.id.recyclerView);

        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_picture , getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        //pasar zona verde de contexto - linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        return view;

    }

    // metodo constructor de array pictures

    public ArrayList<Picture> buildPictures() {

        ArrayList<Picture> pictures = new ArrayList<>();

        pictures.add(new Picture("https://puntobiz.com.ar/data/img_cont/img_imagenes/img_gr/114292_75199.jpg",
                "LAGASH", "hace 7 hs", "88 Likes", "2x1",-32.4773151,-58.2504781));
        pictures.add(new Picture("https://seranoticia.com/wp-content/uploads/2018/09/cerceza.jpg",
                "TRACTOR", "hace 7 hs", "95 Likes", "2x1",-32.4812326,-58.2401659));
        pictures.add(new Picture("https://static.wixstatic.com/media/b54170_cfd1966cf0ee42418f3a67a5337ed2f5~mv2.jpg/v1/fill/w_960,h_720,al_c,q_90/file.jpg",
                "7 COLINAS", "hace 7 hs", "128 Likes", "2x1",-32.4798866,-58.2375424));

        pictures.add(new Picture("https://10619-2.s.cdn12.com/rests/original/329_504097290.jpg",
                "BIGUA", "hace 7 hs", "98 Likes", "2x1",-32.4798866,-58.2375424));

        pictures.add(new Picture("https://i.pinimg.com/236x/a5/d7/d7/a5d7d73d07411da89be0cd833919f7aa.jpg",
                "DRAKKAR", "hace 7 hs", "100 Likes", "2x1",-32.4798866,-58.2375424));

        /*
        pictures.add(new Picture("https://puntobiz.com.ar/data/img_cont/img_imagenes/img_gr/114292_75199.jpg",
                "TRACTOR", "hace 7 hs", "10 Likes", "3x1"));
        */
        return  pictures;
    }

    public void showToolbar(String titulo, boolean upButton, View view) {

//        AppCompatActivity activity = (AppCompatActivity) getActivity();
//        activity.setSupportActionBar(toolbar);
//        activity.getSupportActionBar().setTitle(titulo);
//        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @SuppressLint("RestrictedApi")
    public void showToolbar(String titulo, View view) {

        Toolbar toolbar = view.findViewById(R.id.toolbar);

        toolbar.setTitle(titulo);

        toolbar.setNavigationIcon(null);

    }

}
