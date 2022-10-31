package com.example.scrollingtextaddcomment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public int comments_counter;
    public Button btn_add_comment;
    public EditText new_comment;
    public TextView comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new_comment = (EditText) findViewById(R.id.new_text);
        comments = (TextView) findViewById(R.id.comments);
        comments_counter = 0;

        btn_add_comment = (Button) findViewById(R.id.btn_add_comment);
        btn_add_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_add_comment.getText().equals("Add Comment")){
                    btn_add_comment.setText("SEND");
                    new_comment.setVisibility(View.VISIBLE);
                }else if(btn_add_comment.getText().equals("SEND")){
                    comments_counter = comments_counter+1;
                    comments.append(comments_counter+": "+new_comment.getText().toString()+"\n");
                    new_comment.setVisibility(View.INVISIBLE);
                    new_comment.setText("");
                    btn_add_comment.setText("Add Comment");
                }
            }
        });
    }
}