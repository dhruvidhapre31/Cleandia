package com.example.cleandia;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InformationDetail extends AppCompatActivity {
    //Creating a variable for our Firebase Database.
    FirebaseDatabase firebaseDatabase;
    //Creating a variable for our Database Reference for Firebase.
    DatabaseReference databaseReference, childReference;

    TextView wasteType, disposalTitle, disposalMethod, info, wasteInfo;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_detail);

        wasteType = findViewById(R.id.wasteType);
        image = findViewById(R.id.waste_image_detail);
        info = findViewById(R.id.waste);
        wasteInfo = findViewById(R.id.waste_info);
        disposalTitle = findViewById(R.id.disposal);
        disposalMethod = findViewById(R.id.disposal_method);

        if(getIntent().getIntExtra("type",0) == 1) {

            final String waste_type = getIntent().getStringExtra("waste type");
            final int waste_image = getIntent().getIntExtra("image",0);

            wasteType.setText(String.format("%s Waste", waste_type));
            image.setImageResource(waste_image);
            info.setText(String.format("What is %s Waste?", waste_type));
            disposalTitle.setText(String.format("How to dispose %s Waste?", waste_type));
            getData(waste_type);
        }
    }

    private void getData(String waste_type) {
        //Get the instance of our Firebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();
        //Get reference for our database.
        databaseReference = firebaseDatabase.getReference("data");

        //Calling add value event listener method for getting the values from database.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value1, value2;
                //This method is call to get the realtime updates in the data.
                //This method is called when the data is changed in our Firebase console.
                switch (waste_type){
                case "Agricultural":
                    value1 = snapshot.child("content1").child("agricultural").getValue(String.class);
                    value2 = snapshot.child("content2").child("agricultural").getValue(String.class);
                    break;
                case "Chemical":
                    value1 = snapshot.child("content1").child("chemical").getValue(String.class);
                    value2 = snapshot.child("content2").child("chemical").getValue(String.class);
                    break;
                case "Electronic":
                    value1 = snapshot.child("content1").child("electronic").getValue(String.class);
                    value2 = snapshot.child("content2").child("electronic").getValue(String.class);
                    break;
                case "Liquid":
                    value1 = snapshot.child("content1").child("liquid").getValue(String.class);
                    value2 = snapshot.child("content2").child("liquid").getValue(String.class);
                    break;
                case "Kitchen":
                    value1 = snapshot.child("content1").child("kitchen").getValue(String.class);
                    value2 = snapshot.child("content2").child("kitchen").getValue(String.class);
                    break;
                case "Medical":
                    value1 = snapshot.child("content1").child("medical").getValue(String.class);
                    value2 = snapshot.child("content2").child("medical").getValue(String.class);
                    break;
                case "Sewage":
                    value1 = snapshot.child("content1").child("sewage").getValue(String.class);
                    value2 = snapshot.child("content2").child("sewage").getValue(String.class);
                    break;
                case "Industrial":
                    value1 = snapshot.child("content1").child("industrial").getValue(String.class);
                    value2 = snapshot.child("content2").child("industrial").getValue(String.class);
                    break;
                case "Radioactive":
                    value1 = snapshot.child("content1").child("radioactive").getValue(String.class);
                    value2 = snapshot.child("content2").child("radioactive").getValue(String.class);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + waste_type);
                }

                //Setting value to text view
                wasteInfo.setText(value1);
                disposalMethod.setText(value2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Calling on cancelled method when we receive any error or we are not able to get the data.
                Toast.makeText(InformationDetail.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}