package com.example.tarot101.rv;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarot101.R;
import com.example.tarot101.fragment.FragmentInterface;
import com.example.tarot101.models.Card;
import com.example.tarot101.models.CardKey;

public class CardViewHolder extends RecyclerView.ViewHolder {

private TextView cardName;
CardKey cardKeyfirst;

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        cardName = itemView.findViewById(R.id.card_name_list);
    }
    public void onBind(final Card cardKey, FragmentInterface fragmentInterface){
        cardName.setText(cardKey.getName());

        itemView.setOnClickListener(v->{
//          if(cardKeyfirst.getCards().size()!=0)
            fragmentInterface.toCardDetailFragment(cardKey);
        });

    }
}
