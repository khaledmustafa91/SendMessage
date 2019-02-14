package com.example.sendmessage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void face(View v)
    {
//        Intent web = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.google.com.eg"));
 //       startActivity(web);
       // Intent app1 = getPackageManager().getLaunchIntentForPackage("com.facebook.katana" );
        //startActivity(app1);
        Intent app = new Intent(Intent.ACTION_VIEW , Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com/IEEEBenhaUnivSB"));
        //Intent app1 = getPackageManager().getLaunchIntentForPackage("com.facebook.katana" );
        startActivity(app);
    }
    public void twitter(View v)
    {

        Intent app = new Intent(Intent.ACTION_VIEW , Uri.parse("https://twitter.com/IEEEBUSB?s=09&fbclid=IwAR1j26WpQG-mJOsqTHwfStAHPaZCNJnijkQ14Mkw9sxNUY5DpWWoAnQDiCA"));
        startActivity(app);
    }

    public void instagram(View v)
    {

        Intent app = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.instagram.com/ieee_benha/?utm_source=ig_profile_share&igshid=erltawqi72p6&fbclid=IwAR0XrZS6RqZFijwrbohlLsL__hUEegI2MT0EW515GE7xwWNDs3n7-bsJi9c"));
        startActivity(app);
    }
    //http://maps.google.co.in/maps?q=
 //   https://www.google.com/maps/place/Shoubra+Faculty+of+Engineering+-+Elkhalafawy+building/@30.101084,31.249584,15z/data=!4m5!3m4!1s0x0:0xd839444d08bb1fa5!8m2!3d30.0995614!4d31.2485974?hl=en-US
    public void map(View v)
    {

        Intent app = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.google.com/maps/place/Shoubra+Faculty+of+Engineering+-+Elkhalafawy+building/@30.101084,31.249584,15z/data=!4m5!3m4!1s0x0:0xd839444d08bb1fa5!8m2!3d30.0995614!4d31.2485974?hl=en-US"));
        startActivity(app);
    }
    Button sendData;
    EditText Email , Subject , Message ;
    public void checkEmpty(View v)
    {
        sendData = (Button) findViewById(R.id.send);
        Email = (EditText) findViewById(R.id.email);
        String EmailSend = Email.getText().toString();
        String [] EmailSendArr = EmailSend.split(",");
        Subject = (EditText) findViewById(R.id.sub);
        String Sub = Subject.getText().toString();

        Message = (EditText) findViewById(R.id.message);
        String SendMessage = Message.getText().toString();


        if(EmailSend.isEmpty() || Sub.isEmpty() || SendMessage.isEmpty())
            Toast.makeText(MainActivity.this , "Please Complate empty text" , Toast.LENGTH_LONG).show();

        else
        {
            Intent sendemail = new Intent(Intent.ACTION_SEND);

            //sendemail.setData(Uri.parse("mailto:" + EmailSend));
            sendemail.setType("message/rfc822");

            sendemail.putExtra(Intent.EXTRA_EMAIL, EmailSendArr);
            sendemail.putExtra(Intent.EXTRA_SUBJECT, Sub);
            sendemail.putExtra(Intent.EXTRA_TEXT, SendMessage);

            startActivity(Intent.createChooser(sendemail, "Send Email to " + EmailSend));
        }
    }


}


