package com.example.babyak;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostActivity extends AppCompatActivity {
    private Button savebtn;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_post);

        savebtn = (Button) findViewById(R.id.savePost);

        savebtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                databaseReference.child("postArticle").push().setValue(new PostData());
            }
        });
    }
}
