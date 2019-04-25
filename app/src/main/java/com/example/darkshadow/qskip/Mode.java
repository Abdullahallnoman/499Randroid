package com.example.darkshadow.qskip;

import android.content.Intent;
import android.provider.Contacts;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;

import java.util.List;

public class Mode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);
        Button userMode = (Button) findViewById(R.id.userModeButton);
        Button institutionMode = (Button) findViewById(R.id.institutionModeButton);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

//        DocumentReference docRef = db.collection("offices").document("polash.c@gmail.com");
//        Source source = Source.CACHE;

// Get the document, forcing the SDK to use the offline cache
//        db.collection("offices").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Overridet queryDocumentSnapshots) {
//                if (!queryDocumentSnapshots.isEmpty()){
//                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
//                }
//            }
//        });
//        db.collection("offices")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d("xxx", document.getId() + " => " + document.getData());
//                            }
//                        } else {
//                            Log.d("xxx", "Error getting documents: ", task.getException());
//                        }
//                    }
//                });
        userMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mode.this, SignInSignUp.class);
                startActivity(intent);
            }
        });

        institutionMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mode.this, SignInSignUp.class);
                startActivity(intent);
            }
        });

    }

    private static final String TAG = "sss";
    @Override
//    protected void onStart() {
//        super.onStart();
//
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        //final DocumentReference docRef = ;
//
//        Log.d(TAG, "onStart: xxxbb ");
//        db.collection("offices").document("polash.c@gmail.com").addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot snapshot,
//                                @Nullable FirebaseFirestoreException e) {
//                if (e != null) {
//                    Log.w("xxxbb", "Listen failed.", e);
//                    return;
//                }
//
//                if (snapshot != null && snapshot.exists()) {
//                    Log.d("xxxbb", "Current data: " + snapshot.getData());
//                } else {
//                    Log.d("xxxbb", "Current data: null");
//
//                }
//            }
//        });
//
//
//    }
    public void onStart() {
        super.onStart();
//         Check if user is signed in (non-null) and update Contacts.Intents.UI accordingly.
        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Log.d("aaaaaaasss", currentUser.getUid());
        if (currentUser.getEmail()!=null){
            Intent intent = new Intent(Mode.this, UserHome.class);
            startActivity(intent);
        }
    }

}
