package com.example.tarot101.rv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarot101.R;
import com.example.tarot101.fragment.FragmentInterface;
import com.example.tarot101.models.Card;
import com.example.tarot101.models.CardKey;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private List<Card> cardNameList;
    private FragmentInterface fragmentInterface;

    public CardAdapter(List<Card> cardNameList, FragmentInterface fragmentInterface) {
        this.cardNameList = cardNameList;
        this.fragmentInterface = fragmentInterface;
    }



    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_name_item_view, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.onBind(cardNameList.get(position),fragmentInterface);
    }

    @Override
    public int getItemCount() {
        return cardNameList.size();
    }
}
