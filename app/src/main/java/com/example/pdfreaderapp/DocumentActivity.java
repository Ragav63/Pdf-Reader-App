package com.example.pdfreaderapp;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class DocumentActivity extends AppCompatActivity {

    //String filePath="C:\\Users\\ToqSoft\\AndroidStudioProjects";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_document);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        PDFView pdfView=findViewById(R.id.pdfView);
        // Get file name from intent extras
        String fileName = getIntent().getStringExtra("fileName");
        if (fileName != null) {
            // Load PDF file from assets
            try {
                InputStream inputStream = getAssets().open(fileName);
                pdfView.fromStream(inputStream).load();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Error loading PDF file", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Invalid file name", Toast.LENGTH_SHORT).show();
            finish();
        }
//        filePath=getIntent().getStringExtra("path");
//
//        if(filePath!=null && !filePath.isEmpty()) {
//            File file = new File(filePath);
//            Uri path = Uri.fromFile(file);
//            pdfView.fromUri(path).load();
//
//        } else {
//            Toast.makeText(this, "Invalid file path", Toast.LENGTH_SHORT).show();
//            finish(); // Finish activity
//        }
    }
}