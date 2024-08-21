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

public class mangmaytinh extends AppCompatActivity {
    private TextView tv1,tv2,tv3;
    private ImageView image3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangmaytinh);

        tv1 = findViewById(R.id.training_content);
        String fileContent = readRawTextFile(R.raw.noidungmmt);
        tv1.setText(fileContent);

        tv2 = findViewById(R.id.course_list);
        String fileContent1 = readRawTextFile(R.raw.monhocmmt);
        tv2.setText(fileContent1);

        tv3 = findViewById(R.id.jobs);
        String fileContent2 = readRawTextFile(R.raw.nghenghiepmmt);
        tv3.setText(fileContent2);

        image3 = (ImageView) findViewById(R.id.imagethoat2) ;
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView linkTextView = findViewById(R.id.linkTextView2);

        // Thiết lập link movement method để TextView có thể nhấp vào
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());

        // Cài đặt sự kiện click để mở trình duyệt với URL cụ thể
        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.youtube.com/watch?v=HBw1-_Zqf1o";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        TextView linktv4 = findViewById(R.id.linktv4);

        // Thiết lập link movement method để TextView có thể nhấp vào
        linktv4.setMovementMethod(LinkMovementMethod.getInstance());

        // Cài đặt sự kiện click để mở trình duyệt với URL cụ thể
        linktv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://fee.haui.edu.vn/vn/thong-tin-dao-tao/gioi-thieu-tuyen-sinh-nam-2023-nganh-cnkt-mang-may-tinh-va-truyen-thong-du-lieu/76025";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        TextView linktv5 = findViewById(R.id.linktv5);

        // Thiết lập link movement method để TextView có thể nhấp vào
        linktv5.setMovementMethod(LinkMovementMethod.getInstance());

        // Cài đặt sự kiện click để mở trình duyệt với URL cụ thể
        linktv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://qldt.haui.edu.vn/daotao/program?course=61&courseindustry=764";
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
