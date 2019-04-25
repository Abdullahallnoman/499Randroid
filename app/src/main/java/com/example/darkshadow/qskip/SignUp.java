package com.example.darkshadow.qskip;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.auth.User;

public class SignUp extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText passSignupActivity;
    EditText emailSignupActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

// ...
// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
//        EditText emailSignupActivity;
         passSignupActivity = (EditText)findViewById(R.id.passSignupActivity);
         emailSignupActivity = (EditText)findViewById(R.id.emailSignupActivity);
        Button signupSubmit = (Button) findViewById(R.id.signupSubmitButton);
        signupSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signupp();
//                Log.d("vvv", emailSignupActivity.getText().toString());

            }
        });

    }
    public void signupp(){
        mAuth.createUserWithEmailAndPassword(emailSignupActivity.getText().toString(), passSignupActivity.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                                    Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user.getEmail()!=null){
                                Intent intent = new Intent(SignUp.this, SignIn.class);
                                startActivity(intent);
                            }
                        } else {

                        }

                        // ...
                    }
                });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        Log.d("aaaaaaasss", currentUser.getUid());
//        if (currentUser.getEmail()!=null){
//            Intent intent = new Intent(SignUp.this, UserHome.class);
//            startActivity(intent);
//        }
    }
}
