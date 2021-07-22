package com.example.tarot101.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CardRetrofit {

    private static final String CARD_BASE_URL = "https://rws-cards-api.herokuapp.com";
    private static Retrofit instance;
   // https://rws-cards-api.herokuapp.com/api/v1/cards/

   // https://rws-cards-api.herokuapp.com/api/v1/cards/
    public CardRetrofit() {
    }

    public static Retrofit getCardRetrofit() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(CARD_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
