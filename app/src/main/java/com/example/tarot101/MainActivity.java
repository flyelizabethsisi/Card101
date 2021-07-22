package com.example.tarot101;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.tarot101.fragment.CardDetailFragment;
import com.example.tarot101.fragment.CardImageFragment;
import com.example.tarot101.fragment.CardListFragment;
import com.example.tarot101.fragment.FragmentInterface;
import com.example.tarot101.fragment.OnboardingFragment;
import com.example.tarot101.fragment.SplashFragment;
import com.example.tarot101.models.Card;
import com.example.tarot101.models.CardKey;
import com.example.tarot101.rv.ImageViewPagerAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentInterface, OnboardingFragment.OnFragmentInteractionListener {
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toSplashFragment();



    }

    @Override
    public void toOnboardingFragment() {
        OnboardingFragment onboardingFragment = OnboardingFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, onboardingFragment)
                .commit();
    }

    @Override
    public void toSplashFragment() {
        SplashFragment splashFragment = SplashFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, splashFragment)
                .commit();
    }

    @Override
    public void toCardListFragment() {
        CardListFragment cardListFragment = CardListFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, cardListFragment)
                .commit();
    }

    @Override
    public void toCardImageFragment() {
        Integer image = 0;
        CardImageFragment cardImageFragment = CardImageFragment.newInstance(image);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, cardImageFragment)
                .commit();
    }

    @Override
    public void toCardDetailFragment(Card cardKey) {
        String json = new Gson().toJson(cardKey);
        CardDetailFragment cardDetailFragment = CardDetailFragment.newInstance(json);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, cardDetailFragment)
                .commit();
    }


    @Override
    public void imageFragmentInteraction() {
        toCardImageFragment();

    }

    @Override
    public void cardListFragmentInteraction() {
        toCardListFragment();

    }
}