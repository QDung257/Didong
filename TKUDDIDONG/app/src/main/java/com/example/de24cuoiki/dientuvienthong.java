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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class dientuvienthong extends AppCompatActivity {
    private TextView tv1,tv2,tv3;
    private ImageView image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dientuvienthong);


        tv1 = findViewById(R.id.training_content);
        String fileContent = readRawTextFile(R.raw.ndungdaotao);
        tv1.setText(fileContent);

        tv2 = findViewById(R.id.course_list);
        String fileContent1 = readRawTextFile(R.raw.monhoc);
        tv2.setText(fileContent1);

        tv3 = findViewById(R.id.jobs);
        String fileContent2 = readRawTextFile(R.raw.nghenghiep);
        tv3.setText(fileContent2);

        image1 = (ImageView) findViewById(R.id.imagethoat) ;
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        TextView linkTextView = findViewById(R.id.linkTextView);

        // Thiết lập link movement method để TextView có thể nhấp vào
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());

        // Cài đặt sự kiện click để mở trình duyệt với URL cụ thể
        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.youtube.com/watch?v=HCx6EdMuJzQ";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        TextView linktv = findViewById(R.id.linktv);

        // Thiết lập link movement method để TextView có thể nhấp vào
        linktv.setMovementMethod(LinkMovementMethod.getInstance());

        // Cài đặt sự kiện click để mở trình duyệt với URL cụ thể
        linktv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://fee.haui.edu.vn/vn/thong-tin-dao-tao/gioi-thieu-tuyen-sinh-nam-2023-nganh-cnkt-dien-tu-vien-thong/76027";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        TextView linktv1 = findViewById(R.id.linktv1);

        // Thiết lập link movement method để TextView có thể nhấp vào
        linktv1.setMovementMethod(LinkMovementMethod.getInstance());

        // Cài đặt sự kiện click để mở trình duyệt với URL cụ thể
        linktv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://qldt.haui.edu.vn/daotao/program?course=37&courseindustry=530";
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
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

