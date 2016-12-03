package com.example.asuspc.bloodseeker0;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class RequestBlood extends AppCompatActivity {

    public Button btnrequest;
    public Button btngetcode;
    public Button btnok;
    public static final int CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_blood);
        btnrequest = (Button) findViewById(R.id.btn_request);

        btnrequest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(RequestBlood.this);
                View verify = getLayoutInflater().inflate(R.layout.dialogue_request, null);

                TextView descrip = (TextView) verify.findViewById(R.id.descrip);
                ImageView img = (ImageView) verify.findViewById(R.id.imgalert);
                btngetcode = (Button) verify.findViewById(R.id.btn_verify);

                alertDialogBuilder.setView(verify);
                AlertDialog dialog = alertDialogBuilder.create();
                alertDialogBuilder.show();

                btngetcode.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        integrate();
                    }
                });

            }
        });


    }

    public void integrate(){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();

    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result!= null){
            if(result.getContents() == null)
                Toast.makeText(this, "You cancelled scanning", Toast.LENGTH_SHORT).show();
            else{
                String[] tmp = null;
                try {
                    tmp = result.getContents().split("\\|\\|"); //hospital name, hospital code or validation code
                    double code = 0;
                    String name = "";

                    if (tmp.length == 2) {
                        try{
                            code = Double.parseDouble(tmp[0]);
                            name = tmp[1];
                            if(!name.isEmpty()) {
                                if(code > 1) {
                                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(RequestBlood.this);
                                    View mView = getLayoutInflater().inflate(R.layout.dialogue_verified, null);

                                    TextView descrip = (TextView) mView.findViewById(R.id.descrip);
                                    ImageView img = (ImageView) mView.findViewById(R.id.imgalert);
                                    btnok = (Button) mView.findViewById(R.id.btn_ok);

                                    alertDialogBuilder.setView(mView);
                                    AlertDialog dialog = alertDialogBuilder.create();
                                    alertDialogBuilder.show();

                                    btnok.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View view) {
                                            startActivity(new Intent(RequestBlood.this, Home2.class));
                                        }

                                    });
                                }
                            }else {
                                Toast.makeText(this, "Invalid QR Code 4", Toast.LENGTH_LONG).show();
                                integrate();
                            }
                        }catch (Exception e){
                            Toast.makeText(this, "Invalid QR Code 3", Toast.LENGTH_LONG).show();

                            integrate();
                        }

                    } else {
                        Toast.makeText(this, "Invalid QR Code 2", Toast.LENGTH_LONG).show();
                        integrate();
                    }

                }catch(Exception e){
                    Toast.makeText(this, "Invalid QR Code  1", Toast.LENGTH_LONG).show();
                    integrate();
                }
            }
        }
        else
            super.onActivityResult(requestCode, resultCode, data);
    }


}
