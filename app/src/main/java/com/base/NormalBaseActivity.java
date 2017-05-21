package com.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.Serializable;

/**
 * Author: xushangfei
 * Time: created at 2017/5/20.
 * Description:
 */

public class NormalBaseActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String SER_KEY = "object";

    public void launch(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    public void launch(Class<?> clazz, Object object) {
        Intent intent = new Intent(this, clazz);
        intent.putExtra(SER_KEY, (Serializable) object);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {

    }
}
