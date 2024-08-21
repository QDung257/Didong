package com.example.de24cuoiki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.UUID;
import java.util.regex.Pattern;

public class dangkyy extends AppCompatActivity {
    EditText email, taiKhoan, matKhau;
    ImageView imgBack, dangky;
    databaseUser databaseUser;
    TextView quayvedangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dangkyy);

        email = findViewById(R.id.editTextemail1);
        taiKhoan = findViewById(R.id.edittaikhoan1);
        matKhau = findViewById(R.id.editpassword1);

        dangky = findViewById(R.id.imagedangki);
        imgBack = findViewById(R.id.imageback);
        databaseUser = new databaseUser(this);

        quayvedangnhap = findViewById(R.id.textquayvedangnhap);
        quayvedangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dangkyy.this, dangnhapp.class);
                startActivity(i);
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dangkyy.this, dangnhapp.class);
                startActivity(i);
            }
        });


        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInput = email.getText().toString().trim();
                String taiKhoanInput = taiKhoan.getText().toString().trim();
                String matKhauInput = matKhau.getText().toString().trim();

                if (emailInput.isEmpty() || taiKhoanInput.isEmpty() || matKhauInput.isEmpty()) {
                    Toast.makeText(dangkyy.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else if (!KtraDinhDangEmail(emailInput)) {
                    Toast.makeText(dangkyy.this, "Email không đúng định dạng", Toast.LENGTH_SHORT).show();
                } else if (databaseUser.KTraTaiKhoan(taiKhoanInput)) {
                    Toast.makeText(dangkyy.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                } else if (databaseUser.KtraEmail(emailInput)) {
                    Toast.makeText(dangkyy.this, "Email đã được sử dụng", Toast.LENGTH_SHORT).show();
                } else {
                    user newUser = createUser(emailInput, taiKhoanInput, matKhauInput);
                    databaseUser.addUser(newUser);
                    Toast.makeText(dangkyy.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private user createUser(String email, String taiKhoan, String matKhau) {
        String id = UUID.randomUUID().toString();
        return new user(id, email, taiKhoan, matKhau);
    }

    private boolean KtraDinhDangEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+$";
        return Pattern.matches(emailPattern, email);
    }
}