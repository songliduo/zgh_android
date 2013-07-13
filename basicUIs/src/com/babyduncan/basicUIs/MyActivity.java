package com.babyduncan.basicUIs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {
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
    }
}
