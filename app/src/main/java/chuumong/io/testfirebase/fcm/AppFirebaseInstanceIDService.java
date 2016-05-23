package chuumong.io.testfirebase.fcm;

import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import static android.util.Log.DEBUG;

/**
 * Created by LeeJongHun on 2016-05-23.
 */

public class AppFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = AppFirebaseInstanceIDService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        FirebaseCrash.logcat(DEBUG, TAG, "Refreshed Token : " + refreshedToken);

        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String refreshedToken) {
        // TODO: 2016-05-23 커스텀 서버에 토큰 전송 구현
    }
}
