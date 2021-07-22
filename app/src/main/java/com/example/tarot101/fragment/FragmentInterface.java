package com.example.tarot101.fragment;

import com.example.tarot101.models.Card;
import com.example.tarot101.models.CardKey;

public interface FragmentInterface {
    void toOnboardingFragment();
    void toSplashFragment();
    void toCardListFragment();
    void toCardImageFragment();
    void toCardDetailFragment(Card cardKey);
}
