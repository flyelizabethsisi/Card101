package com.example.tarot101.network;

import com.example.tarot101.models.Card;
import com.example.tarot101.models.CardKey;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CardApi {
    @GET("/api/v1/cards")
    Call <CardKey> getCardInfo();
}
