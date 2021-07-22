package com.example.tarot101.models;

import java.util.ArrayList;
import java.util.List;

public class CardKey {
    private List<Card> cards;

    public CardKey(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }


}
