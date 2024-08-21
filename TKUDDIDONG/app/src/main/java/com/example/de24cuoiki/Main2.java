package com.example.de24cuoiki;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Main2 extends AppCompatActivity {

    private ImageView btnDTVT, btnKTMT, btnMMT, btnDTYS,trogiup;
    private Button btthoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnDTVT = findViewById(R.id.btn_dtvt);
        btnKTMT = findViewById(R.id.btn_ktmt);
        btnMMT = findViewById(R.id.btn_mmt);
        btnDTYS = findViewById(R.id.btn_dtys);
        btthoat = findViewById(R.id.thoat);
        trogiup = findViewById(R.id.imagetrogiup);




        trogiup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2.this, trogiup.class);
                startActivity(intent);
            }
        });

        // Thay đổi từ TextView thành ImageView
        ImageView linkImageView = findViewById(R.id.imagemap);

// Thiết lập sự kiện click để mở trình duyệt với URL cụ thể
        linkImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+C%C3%B4ng+" +
                        "nghi%E1%BB%87p+H%C3%A0+N%E1%BB%99i/@21.053731,105.7325319,17z" +
                        "/data=!3m1!4b1!4m6!3m5!1s0x31345457e292d5bf:0x20ac91c94d74439a!8m2!3d21.053731!4d105.7351068!16s%2Fm%2F0vb3l31?hl=vi-VN&entry=ttu";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });


        btnDTVT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2.this, dientuvienthong.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        btnKTMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2.this, kithuatmaytinh.class);
                startActivity(intent);
            }
        });

        btnMMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2.this, mangmaytinh.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        btnDTYS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2.this, dientuysinh.class);
                startActivity(intent);
            }
        });
        

        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mydialog = new AlertDialog.Builder(Main2.this);
                AlertDialog.Builder b =new
                        AlertDialog.Builder(Main2.this);
                b.setTitle("Question");
                b.setMessage("Ban muốn thoát ứng dụng?");
                b.setIcon(R.drawable.kdientu);
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        finishAffinity();
                    }});
                b.setNegativeButton("No", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                dialog.cancel();
                            }
                        });
                b.create().show();
            }
        });


    }
}
