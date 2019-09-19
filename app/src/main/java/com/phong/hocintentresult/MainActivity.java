package com.phong.hocintentresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtN;
    Button btnLayUocSo;
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLayUocSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoManHinhXuLyUocSo();
            }
        });
    }

    private void MoManHinhXuLyUocSo() {
        Intent intent = new Intent(MainActivity.this, XuLyUocSoActivity.class);
        //Đẩy giá trị trên giao diện tức là n:
        intent.putExtra("n",Integer.parseInt(edtN.getText().toString()));//Lấy đc giá trị n
        startActivityForResult(intent,113);//Đối số 1 là intent, đối số 2 là mã gửi yêu cầu đi
    }

    //Lắng nghe kết quả trả vể:

    @Override
    protected void onActivityResult(
            int requestCode,//Mã yêu cầu là 113
            int resultCode,//Mã kết quả trả về là 115 bên XuLyUocSoActivity
            @Nullable Intent data//Là kết quả trả về
    ) {
        super.onActivityResult(requestCode, resultCode, data);
        //Kiểm tra kết quả trả vể:
        if (requestCode==113 && resultCode==115)
        {
            ArrayList<Integer> dsUS = data.getIntegerArrayListExtra("DSUS");//data chính là kiểu Intent mà gói tin gửi về
            //Hiển thị lên giao diện:
            txtKetQua.setText("");
            for (int us : dsUS)
            {
                txtKetQua.append(us + "\n");
            }
        }
    }

    private void addControls() {
        edtN = (EditText) findViewById(R.id.edtN);
        btnLayUocSo = (Button) findViewById(R.id.btnLayUocSo);
        txtKetQua = (TextView) findViewById(R.id.txtKetQua);
    }
}
