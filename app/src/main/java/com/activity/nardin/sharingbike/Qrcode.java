package com.activity.nardin.sharingbike;
import android.Manifest;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;

public class Qrcode extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private static final int REQUEST_CAMERA =1;
    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            if(checkPermission()){
                Toast.makeText(Qrcode.this, "Permission is granted", Toast.LENGTH_LONG).show();
            }
            else{
                requestPermission();
            }
        }

    }



    private boolean checkPermission(){
        return(ContextCompat.checkSelfPermission(Qrcode.this, CAMERA)== PackageManager.PERMISSION_GRANTED);

    }
    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
    }
    public void onRequestPermissionsResult(int requestCode, String permission[], int grantResults[] ){
        switch (requestCode){
            case REQUEST_CAMERA :
                if(grantResults.length > 0){
                    boolean cameraAccepted = grantResults[0]== PackageManager.PERMISSION_GRANTED;
                    if(cameraAccepted){
                        Toast.makeText(Qrcode.this, "Permission Granted", Toast.LENGTH_LONG).show();

                    }
                    else{
                        Toast.makeText(Qrcode.this, "Permission Denied", Toast.LENGTH_LONG).show();
                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                            if(shouldShowRequestPermissionRationale(CAMERA)){
                                displayAlertMessage(" You need to allow access for both Permissions",
                                        new OnClickListener(){

                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                requestPermissions(new String[]{CAMERA}, REQUEST_CAMERA);
                                                if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.M)
                                                    requestPermissions(new String[]{CAMERA},REQUEST_CAMERA);
                                            }
                                        });
                            }
                        }
                    }

                }

                break;
        }
    }

    public void onResume()
    {
        super.onResume();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            if( checkPermission())
            {
                if (scannerView == null)
                {
                    scannerView = new ZXingScannerView(this);
                    setContentView(scannerView);
                }
                scannerView.setResultHandler(this);
                scannerView.startCamera();
            }
            else
            {
                requestPermission();

            }
        }
    }


    public void onDestroy()
    {
        super.onDestroy();
        scannerView.stopCamera();
    }





    public void displayAlertMessage(String message, OnClickListener listener){
        new AlertDialog.Builder(Qrcode.this)
                .setMessage(message)
                .setPositiveButton("OK", listener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }
    @Override
    public void handleResult(final Result result) {
        final String scanResult = result.getText();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("scan result");
        builder.setPositiveButton("ok", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                scannerView.resumeCameraPreview(Qrcode.this);
            }
        });
        builder.setNeutralButton("visit", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(scanResult));
                startActivity(intent);
            }
        });
        builder.setMessage(scanResult);
        AlertDialog alert = builder.create();
        alert.show();


    }

}

