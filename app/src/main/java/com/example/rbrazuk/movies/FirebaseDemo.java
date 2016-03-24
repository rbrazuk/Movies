package com.example.rbrazuk.movies;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirebaseDemo extends AppCompatActivity {

    @Bind(R.id.bt_firebase) Button mButton;
    @Bind(R.id.et_firebase) EditText mEditText;
    @Bind(R.id.tv_firebase) TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_demo);

        ButterKnife.bind(this);

        mTextView.setAlpha(0.0f);
    }

    @OnClick(R.id.bt_firebase)
    public void addEntry(View view) {
        Firebase ref = new Firebase("https://rcbmovieapp.firebaseio.com/");
        String data = mEditText.getText().toString();
        ref.child("title").setValue(data);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("DATA","The Data Changed");



                String newValue = dataSnapshot.child("title").getValue().toString();
                mTextView.setText(newValue);

                ObjectAnimator fadeOut = ObjectAnimator.ofFloat(mTextView, "alpha", 1.0f).setDuration(500);
                fadeOut.start();


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
