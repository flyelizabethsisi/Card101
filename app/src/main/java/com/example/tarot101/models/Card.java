package com.example.tarot101.models;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private String type;
    private String name;
    private String suit;
    private String meaning_up;
    private String meaning_rev;
    private String desc;

    public Card(String type, String name, String suit, String meaning_up, String meaning_rev, String desc) {
        this.type = type;
        this.name = name;
        this.suit = suit;
        this.meaning_up = meaning_up;
        this.meaning_rev = meaning_rev;
        this.desc = desc;
    }

//    public List<Card> getCardNameList(Card card){
//       List<Card> cardNameList = new ArrayList<>();
//
//       return cardNameList;
//    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public String getMeaning_up() {
        return meaning_up;
    }

    public String getMeaning_rev() {
        return meaning_rev;
    }

    public String getDesc() {
        return desc;
    }
}
