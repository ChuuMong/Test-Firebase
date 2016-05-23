package chuumong.io.testfirebase;

import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.iid.FirebaseInstanceId;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.util.Log.DEBUG;
import static android.util.Log.ERROR;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            throw new RuntimeException("Test Firebase Crash Report");
        }
        catch (RuntimeException e) {
            FirebaseCrash.logcat(ERROR, TAG, e.getMessage());
            FirebaseCrash.report(e);
        }

        FirebaseCrash.logcat(DEBUG, TAG, "FirebaseInstanceId : " + FirebaseInstanceId.getInstance().getToken());
    }
}
