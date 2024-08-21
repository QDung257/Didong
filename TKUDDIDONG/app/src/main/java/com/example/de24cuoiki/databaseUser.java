package com.example.de24cuoiki;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databaseUser extends SQLiteOpenHelper {
    // Tên của cơ sở dữ liệu
    private static final String DATABASE_NAME = "UserDatabase.db";
    // Phiên bản của cơ sở dữ liệu
    private static final int DATABASE_VERSION = 1;

    // Tên bảng và các cột
    public static final String TABLE_USER = "user";
    public static final String ID = "id";
    public static final String EMAIL = "email";
    public static final String TAIKHOAN = "taiKhoan";
    public static final String MATKHAU = "matKhau";

    // Câu lệnh SQL để tạo bảng user
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_USER + " (" +
                    ID + " TEXT PRIMARY KEY, " +
                    EMAIL + " TEXT, " +
                    TAIKHOAN + " TEXT, " +
                    MATKHAU + " TEXT);";

    public databaseUser(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    // Thêm tài khoản
    public void addUser(user newUser) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, newUser.getId());
        values.put(EMAIL, newUser.getEmail());
        values.put(TAIKHOAN, newUser.getTaiKhoan());
        values.put(MATKHAU, newUser.getMatKhau());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    // Hàm kiểm tra tài khoản
    public boolean KTraTaiKhoan(String taiKhoan) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) FROM " + TABLE_USER + " WHERE " + TAIKHOAN + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{taiKhoan});
        boolean exists = false;
        if (cursor.moveToFirst()) {
            exists = cursor.getInt(0) > 0;
        }
        cursor.close();
        db.close();
        return exists;
    }

    // Hàm kiểm tra email
    public boolean KtraEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) FROM " + TABLE_USER + " WHERE " + EMAIL + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email});
        boolean exists = false;
        if (cursor.moveToFirst()) {
            exists = cursor.getInt(0) > 0;
        }
        cursor.close();
        db.close();
        return exists;
    }

    // Hàm kiểm tra người dùng
    public boolean KtraNguoiDung(String taiKhoan, String matKhau) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) FROM " + TABLE_USER + " WHERE " + TAIKHOAN + " = ? AND " + MATKHAU + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{taiKhoan, matKhau});
        boolean exists = false;
        if (cursor.moveToFirst()) {
            exists = cursor.getInt(0) > 0;
        }
        cursor.close();
        db.close();
        return exists;
    }
}
