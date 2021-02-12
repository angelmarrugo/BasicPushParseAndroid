package com.monoremix.basicpushnotification;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.SaveCallback;
import com.parse.fcm.ParseFCM;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(
                new Parse.Configuration.Builder(this)
                        .applicationId("fOvPrzWkthGMxey6244gaFZELpj7vOTyIDzvECwo")
                        .clientKey("T1C4jEf60WydbfPZXujvdMNxPKdN6LElDsq3uQJ1")
                        .server("https://parseapi.back4app.com/")
                        .build()
        );
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put("GCMSenderId", "331877817914");
        installation.saveInBackground();
        ParseFCM.register(installation.getDeviceToken());

        ParsePush.subscribeInBackground("global", new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e==null) {
                    Log.d("ParsePush.sub", "subbed in background to global");
                }else {
                    e.printStackTrace();
                }
            }
        });
    }
}
