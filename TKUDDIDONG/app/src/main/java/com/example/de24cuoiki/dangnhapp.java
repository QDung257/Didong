package com.example.de24cuoiki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class dangnhapp extends AppCompatActivity {
    EditText taiKhoan,matKhau;

    ImageView dangnhap,hgdan;

    databaseUser databaseUser;

    TextView tvdangki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dangnhapp);

        taiKhoan = findViewById(R.id.edittaikhoan);
        matKhau = findViewById(R.id.editpassword);
        tvdangki = findViewById(R.id.textviewdangki);
        dangnhap = findViewById(R.id.imagedangnhap);
        databaseUser = new databaseUser(this);

        hgdan = findViewById(R.id.imagehuongdan);

        hgdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dangnhapp.this, huongdansudung.class);
                startActivity(intent);
            }
        });


        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taiKhoanInput = taiKhoan.getText().toString().trim();
                String matKhauInput = matKhau.getText().toString().trim();

                if (taiKhoanInput.isEmpty() || matKhauInput.isEmpty()) {
                    Toast.makeText(dangnhapp.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else if (databaseUser.KtraNguoiDung(taiKhoanInput, matKhauInput)) {
                    Toast.makeText(dangnhapp.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(dangnhapp.this, Main2.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(dangnhapp.this, "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                }

            }
        });

        tvdangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dangnhapp.this, dangkyy.class);
                startActivity(intent);
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}