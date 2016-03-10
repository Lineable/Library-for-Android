package net.lineable.lineablelibrarydemo;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.lineable.library.LineableLibrary;
import net.lineable.library.State;
import net.lineable.library.model.MissingLineable;
import net.lineable.library.tool.L;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("start button click.");
                LineableLibrary.mLogPrint = true; // set true if you want to see console log.
                LineableLibrary.start(MainActivity.this, mLibraryStateReceiver);
            }
        });

        findViewById(R.id.btnStop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("stop button click.");
                LineableLibrary.stop(MainActivity.this);
            }
        });
    }

    private String log = "";
    private void setText(String msg) {
        log = msg + "\n" + log;
        ((TextView)findViewById(R.id.tvState)).setText(log);
    }

    private BroadcastReceiver mLibraryStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // check error states.
            State state = (State)intent.getSerializableExtra("state");
            String content = intent.getStringExtra("content");
            L.d(TAG, "onReceive : " + state.name() + ", content : " + content);
            setText("onReceive : " + state.name() + ", content : " + content);

            switch (state) {
                case BLE_SCAN_START:
                    break;
                case BLE_SCAN_STOP:
                    break;
                case SET_NEXT_ALARM:
                    break;
                case CANCEL_NEXT_ALARM:
                    break;
                case DEPRECATED:
                    // this library is deprecated, please use updated library.
                    break;
                case ERR_BT_NULL:
                    break;
                case ERR_BT_OFF:
                    break;
                case ERR_LOCATION_NEED_M:
                    // user did not permit location service on your app.
                    showLocationServiceAlertForM();
                    break;
                case SERVER_RESPONSE:
                    break;

                case MISSING_LINEABLE:
                    // if missing reported lineable exist.
                    Type listType = new TypeToken<ArrayList<MissingLineable>>() {}.getType();
                    ArrayList<MissingLineable> missingChildArray = new Gson().fromJson(content, listType);
                    processMissingChild(missingChildArray);
                    break;
            }
        }
    };

    private void processMissingChild(ArrayList<MissingLineable> missingChildArray) {
        for(MissingLineable missing : missingChildArray) {
            L.d(TAG, "missing : " + new Gson().toJson(missing));
        }
    }

    private void showLocationServiceAlertForM() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage("Need location service to get location and bluetooth scan");
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            }
        });
        builder.show();
    }

}
