package com.example.de24cuoiki;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class kithuatmaytinh extends AppCompatActivity {
    private TextView tv1,tv2,tv3;
    private ImageView image2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kithuatmaytinh);

        tv1 = findViewById(R.id.training_content);
        String fileContent = readRawTextFile(R.raw.noidungktmt);
        tv1.setText(fileContent);

        tv2 = findViewById(R.id.course_list);
        String fileContent1 = readRawTextFile(R.raw.monhocktmt);
        tv2.setText(fileContent1);

        tv3 = findViewById(R.id.jobs);
        String fileContent2 = readRawTextFile(R.raw.nghenghiepktmt);
        tv3.setText(fileContent2);

        image2 = (ImageView) findViewById(R.id.imagethoat1) ;
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView linkTextView = findViewById(R.id.linkTextView1);

        // Thiết lập link movement method để TextView có thể nhấp vào
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());

        // Cài đặt sự kiện click để mở trình duyệt với URL cụ thể
        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.youtube.com/watch?v=nIxScQ7oRY4&embeds_referring_euri=https%3A%2F%2Fwww.haui.edu.vn%2F&source_ve_path=MjM4NTE&feature=emb_title";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        TextView linktv2 = findViewById(R.id.linktv2);

        // Thiết lập link movement method để TextView có thể nhấp vào
        linktv2.setMovementMethod(LinkMovementMethod.getInstance());

        // Cài đặt sự kiện click để mở trình duyệt với URL cụ thể
        linktv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://tuyensinh.haui.edu.vn/dai-hoc/cong-nghe-ky-thuat-may-tinh-2021/5e4b46db376c683184672dd1";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        TextView linktv3 = findViewById(R.id.linktv3);

        // Thiết lập link movement method để TextView có thể nhấp vào
        linktv3.setMovementMethod(LinkMovementMethod.getInstance());

        // Cài đặt sự kiện click để mở trình duyệt với URL cụ thể
        linktv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://qldt.haui.edu.vn/daotao/program?course=16&courseindustry=288";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });


        setupToggle(findViewById(R.id.title_training_content), findViewById(R.id.training_content));
        setupToggle(findViewById(R.id.title_course_list), findViewById(R.id.course_list));
        setupToggle(findViewById(R.id.title_application_images), findViewById(R.id.application_image1), findViewById(R.id.application_image2), findViewById(R.id.application_image3));
        setupToggle(findViewById(R.id.title_jobs), findViewById(R.id.jobs));
    }

    private void setupToggle(View titleView, final View... contentViews) {
        titleView.setOnClickListener(v -> {
            for (View contentView : contentViews) {
                if (contentView.getVisibility() == View.GONE) {
                    contentView.setVisibility(View.VISIBLE);
                } else {
                    contentView.setVisibility(View.GONE);
                }
            }
        });
    }
    private String readRawTextFile(int resId) {
        InputStream inputStream = getResources().openRawResource(resId);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
