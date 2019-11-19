package com.Sebastian.ClubCervezero.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.Sebastian.ClubCervezero.MapsActivity;
import com.Sebastian.ClubCervezero.R;
import com.Sebastian.ClubCervezero.view.fragments.HomeFragment;
import com.Sebastian.ClubCervezero.view.fragments.ProfileFragment;
import com.Sebastian.ClubCervezero.view.fragments.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class ContainerActivity extends AppCompatActivity  implements  View.OnClickListener {

    Button btn_mapa;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        btn_mapa = findViewById(R.id.mapa);
        btn_mapa.setOnClickListener(this);
        final BottomBar bottomBar = findViewById(R.id.bottombar);

        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, homeFragment).commit();

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (tabId) {

                    case R.id.tab_home:

                        HomeFragment homeFragment = new HomeFragment();
                        transaction.replace(R.id.container, homeFragment, "home");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                    case R.id.tab_profile:

                        ProfileFragment profileFragment = new ProfileFragment();
                        transaction.replace(R.id.container, profileFragment, "profile");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                    case R.id.tab_search:

                        SearchFragment searchFragment = new SearchFragment();
                        transaction.replace(R.id.container, searchFragment, "search");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                }
            }

        });

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener(){

            @Override
            public void onBackStackChanged() {

//                int backCount = getSupportFragmentManager().getBackStackEntryCount();
//                if (backCount == 0){
//                    // block where back has been pressed. since backstack is zero.
//                    int aux = bottomBar.getCurrentTabId();
//                    bottomBar.selectTabWithId(R.id.tab_home);
//                    ultimo_tab = aux;
//
//                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);
    }
}
