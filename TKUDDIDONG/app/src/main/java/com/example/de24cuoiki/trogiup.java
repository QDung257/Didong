package com.example.de24cuoiki;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class trogiup extends AppCompatActivity {
    private ImageView img1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trogiup);

        img1 = findViewById(R.id.imagethoattrogiup);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }



    // Phương thức xử lý khi nhấn vào nút "Liên hệ qua điện thoại"
    public void callPhoneNumber(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0343547805")); // Thay đổi số điện thoại tại đây
        startActivity(intent);
    }

    // Phương thức xử lý khi nhấn vào nút "Liên hệ qua email"
    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:")); // Chỉ định rõ là gửi email
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"nqdung2507@gmail.com"}); // Thay đổi email tại đây
        intent.putExtra(Intent.EXTRA_SUBJECT, "Yêu cầu hỗ trợ"); // Chủ đề email
        intent.putExtra(Intent.EXTRA_TEXT, "Xin chào,\n\nTôi đang gặp một số vấn đề và cần sự trợ giúp của bạn.\n\nXin cảm ơn!"); // Nội dung email
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Send Email"));
        }
    }
}
