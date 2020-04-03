package in.developer.demoform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button submitBtn;
    private TextView name, email, mobile, address;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private CheckBox checkBox;
    String checkboxstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        name = findViewById(R.id.userName);

        mobile = findViewById(R.id.userPhone);
        email = findViewById(R.id.userEmail);

        address = findViewById(R.id.userAddress);

        submitBtn = findViewById(R.id.submit);

        checkBox = findViewById(R.id.checkBox2);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (name.getText().toString().trim().equals("")){
                    name.setError("Please fill this field");
                    name.requestFocus();
                    return;
                }
                if (email.getText().toString().trim().equals("")){
                    email.setError("Please fill this field");
                    email.requestFocus();
                    return;
                }
                if (mobile.getText().toString().trim().equals("")){
                    mobile.setError("Please fill this field");
                    mobile.requestFocus();
                    return;
                }

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);



                if (address.getText().toString().trim().equals("")){
                    address.setError("Please fill this field");
                    address.requestFocus();
                    return;
                }

                if (checkBox.isChecked()) {
                    checkboxstr = checkBox.getText().toString();
                } else {
                    checkBox.setError("Select the checkbox");
                    checkBox.requestFocus();
                    return;
                }



                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("name", name.getText().toString().trim());
                intent.putExtra("mobile", mobile.getText().toString().trim());
                intent.putExtra("email", email.getText().toString().trim());
                intent.putExtra("gender", radioButton.getText().toString().trim());
                intent.putExtra("address", address.getText().toString().trim());
                startActivity(intent);
                finish();
            }
        });
    }

}
