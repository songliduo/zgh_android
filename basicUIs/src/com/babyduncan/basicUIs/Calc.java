package com.babyduncan.basicUIs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * User: guohaozhao (guohaozhao@sohu-inc.com)
 * Date: 13-7-13 14:58
 */
public class Calc extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.calc);
        Button button = (Button) this.findViewById(R.id.button);
        final EditText editText = (EditText) this.findViewById(R.id.editText);

        Intent intent = getIntent();
        int a = intent.getIntExtra("f", 0);
        int b = intent.getIntExtra("s", 0);

        String s = a + "+" + b + "= ? ";
        TextView textView = (TextView) this.findViewById(R.id.textView);
        textView.setText(s);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent _intent = new Intent();
                String result = editText.getText().toString();
                _intent.putExtra("result", result.toString().replace(" ", ""));
                setResult(1, _intent);
                finish();
            }
        });

    }
}