package inofa.avesbox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import inofa.avesbox.Model.LoginRespon;
import inofa.avesbox.Storage.SharePrefManager;

public class MainActivity extends AppCompatActivity {
    private int waktu_loading = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    if (SharePrefManager.getInstance(MainActivity.this).isLoggedIn()){
                       Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                       intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                       startActivity(intent);
                    }else{
                Intent login = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(login);
                finish();
            }
            }
        }, waktu_loading);
    }

}
