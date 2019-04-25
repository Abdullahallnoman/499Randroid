package com.example.darkshadow.qskip;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Activity_Serial extends AppCompatActivity {
    int onetime =0;
    int initSerial=0;
    int tempSerial=0;
TextView serial;
TextView timee;
String keyy;
String maill;
    String[] separated;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__serial);
serial = (TextView) findViewById(R.id.serial);
        timee = (TextView) findViewById(R.id.timee);
        String sessionId= getIntent().getStringExtra("EXTRA_SESSION_ID");
        separated = sessionId.split("=");
        keyy = separated[1];
        maill = separated[0];
        Log.d("zzz", separated[0]);
        Log.d("zzz", separated[1]);



    }


public  void serialMaintain(){

}
    private static final String TAG = "ssssss";
    @Override
    protected void onStart() {
        super.onStart();
//        hkljvhsdkfjhkjsdfhgjksfdghjksdfgsdf ghsfdkjghskfjdghjksdfghjksdfgh kjfdhgkjsdghksjdfghksdjfghfkjsghsfdkjghsfdkjghsfdkjghsdfgkj hfsdkghsdfgkhsdgkjsdh
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        final DocumentReference docRef = db.collection("offices").document(maill);
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w("xxx", "Listen failed.", e);
                    return;
                }
                if (snapshot != null && snapshot.exists()) {
                    Model model = snapshot.toObject((Model.class));
//                    Log.d("xxxbb", "Current data: " + model.getCoFiveTotal());
                    Log.d(TAG, keyy);
                    final MediaPlayer mp = MediaPlayer.create(Activity_Serial.this, R.raw.m);
//                    mp.start();
                    if (keyy.equals("coOneTotal")){
                        if( onetime==0)
                        {
                            initSerial=model.getCoOneTotal()+1;
                            tempSerial=model.getCoOneTotal()+1;
                            docRef.update(
                                    "coOneTotal", model.getCoOneTotal()+1
                            );
                            serial.setText("Total in que : "+Integer.toString(initSerial));
                            timee.setText("Estimated Time  : "+Double.toString(((Double.valueOf(model.getCoOneTime())*Double.valueOf(initSerial)))/60)+" Minutes");
                        }
                        onetime++;
//                        int a = model.getCoOneTotal();

                        if (model.getCoOneTotal()<tempSerial){
                            if (initSerial==0){
                                mp.start();
                                serial.setText("It's Your turn");
                                timee.setText("");
                            }if (initSerial<0){
                                serial.setText("Thank You");
                                timee.setText("Have a great Day");
                            }

                            Log.d("eeeeeee",Integer.toString((model.getCoOneTime())));
                            serial.setText("Total in que : "+Integer.toString(initSerial));
                            timee.setText("Estimated Time  : "+Double.toString(((Double.valueOf(model.getCoOneTime())*Double.valueOf(initSerial)))/60)+" Minutes");
                            tempSerial=model.getCoOneTotal();
                            initSerial=initSerial-1;
                        }
                        else {
                            tempSerial=model.getCoOneTotal();
                        }
                    }
                    else  if(keyy.equals("coTwoTotal")){
                        if( onetime==0)
                        {
                            initSerial=model.getCoTwoTotal()+1;
                            tempSerial=model.getCoTwoTotal()+1;
                            docRef.update(
                                    "coTwoTotal", model.getCoTwoTotal()+1
                            );
                            serial.setText("Total in que : "+Integer.toString(initSerial));
                            timee.setText("Estimated Time  : "+Double.toString(((Double.valueOf(model.getCoTwoTime())*Double.valueOf(initSerial)))/60)+" Minutes");
                        }
                        onetime++;
                        int a = model.getCoTwoTotal();
//                        if (a==0){
//                            mp.start();
//                        }
                        if (model.getCoTwoTotal()<tempSerial){
                            if (initSerial==0){
                                mp.start();
                                serial.setText("It's Your turn");
                                timee.setText("");
                            }if (initSerial<0){
                                serial.setText("Thank You");
                                timee.setText("Have a great Day");
                            }
                            Log.d("eeeeeee",Integer.toString((model.getCoTwoTime())));
                            serial.setText("Total in que : "+Integer.toString(initSerial));
                            timee.setText("Estimated Time  : "+Double.toString(((Double.valueOf(model.getCoTwoTime())*Double.valueOf(initSerial)))/60)+" Minutes");
                            tempSerial=model.getCoTwoTotal();
                            initSerial=initSerial-1;
                        }
                        else {
                            tempSerial=model.getCoTwoTotal();
                        }
                    }else  if(keyy.equals("coThreeTotal")){
                        if( onetime==0)
                        {
                            initSerial=model.getCoThreeTotal()+1;
                            tempSerial=model.getCoThreeTotal()+1;
                            docRef.update(
                                    "coThreeTotal", model.getCoThreeTotal()+1
                            );
                            serial.setText("Total in que : "+Integer.toString(initSerial));
                            timee.setText("Estimated Time  : "+Double.toString(((Double.valueOf(model.getCoThreeTime())*Double.valueOf(initSerial)))/60)+" Minutes");
                        }
                        onetime++;
                        int a = model.getCoThreeTotal();
//                        if (a==0){
//                            mp.start();
//                        }
                        if (model.getCoThreeTotal()<tempSerial){
                            if (initSerial==0){
                                mp.start();
                                serial.setText("It's Your turn");
                                timee.setText("");
                            }if (initSerial<0){
                                serial.setText("Thank You");
                                timee.setText("Have a great Day");
                            }
                            Log.d("eeeeeee",Integer.toString((model.getCoThreeTime())));
                            serial.setText("Total in que : "+Integer.toString(initSerial));
                            timee.setText("Estimated Time  : "+Double.toString(((Double.valueOf(model.getCoThreeTime())*Double.valueOf(initSerial)))/60)+" Minutes");
                            tempSerial=model.getCoThreeTotal();
                            initSerial=initSerial-1;
                        }
                        else {
                            tempSerial=model.getCoThreeTotal();
                        }
                    }else  if(keyy.equals("coFourTotal")){
                        if( onetime==0)
                        {
                            initSerial=model.getCoFourTotal()+1;
                            tempSerial=model.getCoFourTotal()+1;
                            docRef.update(
                                    "coFourTotal", model.getCoFourTotal()+1

                            );
                            serial.setText("Total in que : "+Integer.toString(initSerial));
                            timee.setText("Estimated Time  : "+Double.toString(((Double.valueOf(model.getCoFourTime())*Double.valueOf(initSerial)))/60)+" Minutes");

                        }
                        onetime++;
                        int a = model.getCoFourTotal();
//                        if (a==0){
//                            mp.start();
//                        }
                        if (model.getCoFourTotal()<tempSerial){
                            if (initSerial==0){
                                mp.start();
                                serial.setText("It's Your turn");
                                timee.setText("");
                            }if (initSerial<0){
                                serial.setText("Thank You");
                                timee.setText("Have a great Day");
                            }
                            Log.d("eeeeeee",Integer.toString((model.getCoFourTime())));
                            serial.setText("Total in que : "+Integer.toString(initSerial));
                            timee.setText("Estimated Time  : "+Double.toString(((Double.valueOf(model.getCoFourTime())*Double.valueOf(initSerial)))/60)+" Minutes");
                            tempSerial=model.getCoFourTotal();
                            initSerial=initSerial-1;
                        }
                        else {
                            tempSerial=model.getCoFourTotal();
                        }
                    }else  if(keyy.equals("coFiveTotal")){
                        if( onetime==0)
                        {

                            initSerial=model.getCoFiveTotal()+1;
                            tempSerial=model.getCoFiveTotal()+1;
                            docRef.update("coFiveTotal", model.getCoFiveTotal()+1);
                            serial.setText("Total in que : "+Integer.toString(initSerial));
                            timee.setText("Estimated Time  : "+Double.toString(((Double.valueOf(model.getCoFiveTime())*Double.valueOf(initSerial)))/60)+" Minutes");
//                            timee.setText("Estimated Time  : "+Integer.toString((model.getCoFiveTime())));
                        }
                        onetime++;
                        int a = model.getCoFiveTotal();
//                        if (a==0){
//                            mp.start();
//                        }
                        if (model.getCoFiveTotal()<tempSerial){
                            if (initSerial==0){
                                mp.start();
                                serial.setText("It's Your turn");
                                timee.setText("");
                            }if (initSerial<0){
                                serial.setText("Thank You");
                                timee.setText("Have a great Day");
                            }
                            Log.d("eeeeeee",Integer.toString((model.getCoFiveTime())));
                            serial.setText("Total in que : "+Integer.toString(initSerial));
                            timee.setText("Estimated Time  : "+Double.toString(((Double.valueOf(model.getCoFiveTime())*Double.valueOf(initSerial)))/60)+" Minutes");
                            tempSerial=model.getCoFiveTotal();
                            initSerial=initSerial-1;
                        }
                        else {
                            tempSerial=model.getCoFiveTotal();
                        }
                    }
                }
            }
        });

//        hkljvhsdkfjhkjsdfhgjksfdghjksdfgsdf ghsfdkjghskfjdghjksdfghjksdfgh kjfdhgkjsdghksjdfghksdjfghfkjsghsfdkjghsfdkjghsfdkjghsdfgkj hfsdkghsdfgkhsdgkjsdhf
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        final DocumentReference docRef = db.collection("offices").document(maill);

//        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot snapshot,
//                                @Nullable FirebaseFirestoreException e) {
//                if (e != null) {
//                    Log.w("xxx", "Listen failed.", e);
//                    return;
//                }
//
//                if (snapshot != null && snapshot.exists()) {
//                    Model model = snapshot.toObject((Model.class));
////                    Log.d("xxxbb", "Current data: " + model.getCoFiveTotal());
//                    Log.d(TAG, keyy);
//                    final MediaPlayer mp = MediaPlayer.create(Activity_Serial.this, R.raw.m);
////                    mp.start();
//
//                    if (keyy.equals("coOneTotal")){
//                        int a = model.getCoOneTotal();
//                        if (a==0){
//                            mp.start();
//                        }
//                        serial.setText("Total in que : "+Integer.toString(model.getCoOneTotal()));
//                        timee.setText("Estimated Time : "+Integer.toString((model.getCoOneTime()*model.getCoOneTotal())/60));
//                    }
//                    else  if(keyy.equals("coTwoTotal")){
//                        int a = model.getCoTwoTotal();
//                        if (a==0){
//                            mp.start();
//                        }
//                        serial.setText("Total in que : "+Integer.toString(model.getCoTwoTotal()));
//                        timee.setText("Estimated Time  : "+Integer.toString((model.getCoTwoTime()*model.getCoTwoTotal())/60));
//                    }else  if(keyy.equals("coThreeTotal")){
//                        int a = model.getCoThreeTotal();
//                        if (a==0){
//                            mp.start();
//                        }
//                        serial.setText("Total in que : "+Integer.toString(model.getCoThreeTotal()));
//                        timee.setText("Estimated Time  : "+Integer.toString((model.getCoThreeTime()*model.getCoThreeTotal())/60));
//                    }else  if(keyy.equals("coFourTotal")){
//                        int a = model.getCoFourTotal();
//                        if (a==0){
//                            mp.start();
//                        }
//                        serial.setText("Total in que : "+Integer.toString(model.getCoFourTotal()));
//                        timee.setText("Estimated Time  : "+Integer.toString((model.getCoFourTime()*model.getCoFourTotal())/60));
//                    }else  if(keyy.equals("coFiveTotal")){
//                        int a = model.getCoFiveTotal();
//                        if (a==0){
//                            mp.start();
//                        }
//                        serial.setText("Total in que : "+Integer.toString(model.getCoFiveTotal()));
//                        timee.setText("Estimated Time  : "+Integer.toString((model.getCoFiveTime()*model.getCoFiveTotal())/60));
//                    }
//
////                    Log.d("xxx", "Current data: " + snapshot.getData());
//                } else {
//                    Log.d("xxx", "Current data: null");
//
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
//                            Log.w("xxx", "Error getting documents.", task.getException());
//                        }
//                    }
//                });

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

    }
}
