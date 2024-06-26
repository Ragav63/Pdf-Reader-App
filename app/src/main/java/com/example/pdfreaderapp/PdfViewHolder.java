package com.example.pdfreaderapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class PdfViewHolder extends RecyclerView.ViewHolder {

    public TextView tvName;



    public PdfViewHolder(@NonNull View itemView) {
        super(itemView);
        tvName=itemView.findViewById(R.id.textPdfName);

    }
}
