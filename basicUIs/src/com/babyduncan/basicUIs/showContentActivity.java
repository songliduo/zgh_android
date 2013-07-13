package com.babyduncan.basicUIs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * User: guohaozhao (guohaozhao@sohu-inc.com)
 * Date: 13-7-13 14:09
 */
public class showContentActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showcontent);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 0);
        TextView _name = (TextView) this.findViewById(R.id.name);
        _name.setText(name);
        TextView _age = (TextView) this.findViewById(R.id.age);
        _age.setText(age + "");
    }

}