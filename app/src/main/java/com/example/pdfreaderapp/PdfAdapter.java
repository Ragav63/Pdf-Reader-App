package com.example.pdfreaderapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class PdfAdapter extends RecyclerView.Adapter<PdfViewHolder> {
    private Context context;
    private String[] pdfFiles;

    public PdfAdapter(Context context, String[] pdfFiles) {
        this.context = context;
        this.pdfFiles = pdfFiles;
    }

    @NonNull
    @Override
    public PdfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.element_holder, parent, false);
        return new PdfViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PdfViewHolder holder, @SuppressLint("RecyclerView") int position) {

        String fileName=pdfFiles[position];
        holder.tvName.setText(fileName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open PDF file on item click
                Intent intent = new Intent(context, DocumentActivity.class);
                intent.putExtra("fileName", fileName);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pdfFiles.length;
    }
}
