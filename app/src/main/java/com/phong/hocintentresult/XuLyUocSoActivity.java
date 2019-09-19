package com.phong.hocintentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class XuLyUocSoActivity extends AppCompatActivity {

    TextView txtN;
    Button btnTraVe;
    Intent intent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xu_ly_uoc_so);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTraVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyTraUocSo();
            }
        });
    }

    private void XuLyTraUocSo() {
        int n = Integer.parseInt(txtN.getText().toString());//Lấy n ra
        //Tìm ước số của n:
        ArrayList<Integer> dsUS = new ArrayList<>();
        for (int i=1;i<=n;i++)
        {
            if (n%i==0)
            {
                dsUS.add(i);
            }
        }
        //Đẩy qua MainActivity:
        intent.putExtra("DSUS",dsUS);
        setResult(115,intent);//Đối số 1 là mã kết quả, đối số 2 là gói tin muốn gửi ngược lại
        //Đối số 1 đánh dấu mã kết quả trả về là 115
        finish();//Lúc này bên MainActivity mới nhận đc kết quả này bởi vì chỉ lắng nghe kq trong Foredground Lifetime
    }

    private void addControls() {
        //Lấy bên MainActivity qua:
        intent = getIntent();
        int n = intent.getIntExtra("n",0);
        txtN = (TextView) findViewById(R.id.txtN);
        btnTraVe = (Button) findViewById(R.id.btnTraVe);
        txtN.setText(n + "");//Hiển thị kiểu int lên giao diện phải + chuỗi
    }
}
