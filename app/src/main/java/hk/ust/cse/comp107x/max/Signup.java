package hk.ust.cse.comp107x.max;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    public Button signUpButton;
    public EditText email;
    public EditText phone;
    public EditText password;
    public TextView signInPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        signUpButton = (Button) findViewById(R.id.signUp);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        signInPage = (TextView) findViewById(R.id.signInPage);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = email.getText().toString();
                String userPhoneNumber = phone.getText().toString();
                String userPassword = password.getText().toString();

                SharedPreferences sharepref = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharepref.edit();
                editor.putString("email", userEmail);
                editor.putString("phoneNumber", userPhoneNumber);
                editor.putString("password", userPassword);
                editor.apply();

                Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Signup.this, LandingPage.class));

            }
        });

        signInPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(Signup.this, LogIn.class));

                SharedPreferences sharedpref = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                String email = sharedpref.getString("email", "");
                String phone = sharedpref.getString("phoneNumber", "");
                String password = sharedpref.getString("password", "");

                Toast.makeText(getApplicationContext(), "Email :" + email +" "+"PhoneNumber :"+ phone
                        +" " + "Password: "+password, Toast.LENGTH_LONG).show();
            }
        });
    }

}
