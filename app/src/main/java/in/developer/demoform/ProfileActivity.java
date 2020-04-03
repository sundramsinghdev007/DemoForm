package in.developer.demoform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {


    TextView nameTv, emailTv, mobileTv, genderTv,textViewAddresss;
    String name, email, mobile, gender, address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        nameTv = findViewById(R.id.textViewName);
        emailTv = findViewById(R.id.textViewEmail);
        mobileTv = findViewById(R.id.textViewMobile);
        genderTv = findViewById(R.id.textViewGender);
        textViewAddresss = findViewById(R.id.textViewAddress);

        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
        mobile = getIntent().getStringExtra("mobile");
        gender = getIntent().getStringExtra("gender");
        address = getIntent().getStringExtra("address");

        nameTv.setText(name);
        emailTv.setText(email);
        mobileTv.setText(mobile);
        genderTv.setText(gender);
        textViewAddresss.setText(address);
    }
}
