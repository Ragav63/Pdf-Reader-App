package com.example.pdfreaderapp;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity //implements OnPdfFileSelectedListener
{

    private PdfAdapter pdfAdapter;
    //private List<File> pdfList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        // Load PDF files from assets folder
        String[] pdfFiles = {"login.pdf"};
//        try {
//            pdfFiles = getAssets().list("");
//        } catch (IOException e) {
//            e.printStackTrace();
//            Toast.makeText(this, "Error accessing assets folder", Toast.LENGTH_SHORT).show();
//        }

        if (pdfFiles != null && pdfFiles.length > 0) {
            pdfAdapter = new PdfAdapter(this, pdfFiles);
            recyclerView.setAdapter(pdfAdapter);
        } else {
            Toast.makeText(this, "No PDF files found in assets folder", Toast.LENGTH_SHORT).show();
        }

        //displayPdf();
    }


//    private void displayPdf() {
//
//                pdfList = new ArrayList<>();
//                pdfList.addAll(findPdf(Environment.getExternalStorageDirectory()));
//                pdfAdapter = new PdfAdapter(this, pdfList, this);
//                recyclerView.setAdapter(pdfAdapter);
//
//    }
//
//    public ArrayList<File> findPdf(File file){
//        ArrayList<File> arrayList=new ArrayList<>();
//        File[] files=file.listFiles();
//
//        if(files!=null) {
//            for (File singleFile : files) {
//                if (singleFile.isDirectory() && !singleFile.isHidden()) {
//                    arrayList.addAll(findPdf(singleFile));
//                } else {
//                    if (singleFile.getName().endsWith(".pdf")) {
//                        arrayList.add(singleFile);
//                    }
//                }
//            }
//        } else {
//            Log.e("MainActivity","Error:files in the array is null in directory"+file.getAbsolutePath());
//        }
//
//        return arrayList;
//    }



//    @Override
//    public void onPdfSelected(File file) {
//        startActivity(new Intent(MainActivity.this, DocumentActivity.class).putExtra("path",file.getAbsolutePath()));
//    }
}