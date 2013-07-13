package com.babyduncan.basicUIs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {


    private static int REQUEST_CODE = 1;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button) this.findViewById(R.id.button);
        final TextView textView = (TextView) this.findViewById(R.id.showTextView);
        textView.setText("");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Ò³Ãæ¼´½«Ìø×ª");
                Intent intent = new Intent(MyActivity.this, showContentActivity.class);
                intent.putExtra("name", "babyduncan");
                intent.putExtra("age", 21);
                startActivity(intent);
            }
        });


        Button calc = (Button) this.findViewById(R.id.calc);
        final EditText editText1 = (EditText) this.findViewById(R.id.editText);
        final EditText editText2 = (EditText) this.findViewById(R.id.editText1);

        calc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int firstNum = Integer.parseInt(editText1.getText().toString().replace(" ", ""));
                int secondNum = Integer.parseInt(editText2.getText().toString().replace(" ", ""));

                Intent intent = new Intent(MyActivity.this, Calc.class);
                intent.putExtra("f", firstNum);
                intent.putExtra("s", secondNum);

                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        Button _button = (Button) this.findViewById(R.id.button2);
        final TextView t_result = (TextView) this.findViewById(R.id.textView3);
        _button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int firstNum = 0;
                int secondNum = 0;
                int result = 0;

                try {
                    firstNum = Integer.parseInt(editText1.getText().toString().replace(" ", ""));
                    secondNum = Integer.parseInt(editText2.getText().toString().replace(" ", ""));
                    result = Integer.parseInt(t_result.getText().toString().replace(" ", ""));
                } catch (Exception e) {
                    return;
                }
                if (result == firstNum + secondNum) {
                    t_result.setTextColor(Color.GREEN);

                } else {
                    t_result.setTextColor(Color.RED);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            if (REQUEST_CODE == requestCode) {
                TextView result = (TextView) this.findViewById(R.id.textView3);
                result.setText(data.getStringExtra("result"));
            }
        }
    }
}
