package chuumong.io.testfirebase;

import com.google.firebase.crash.FirebaseCrash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.util.Log.ERROR;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            throw new RuntimeException("Test Firebase Crash Report");
        }
        catch (RuntimeException e) {
            FirebaseCrash.logcat(ERROR, this.getClass().getSimpleName(), e.getMessage());
            FirebaseCrash.report(e);
        }
    }
}
