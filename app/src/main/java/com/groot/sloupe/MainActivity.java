package com.groot.sloupe;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.groot.sloupe.Init.Init_Activity;
import com.groot.sloupe.Net.Jsoup.Teste.JsoupTeste;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButton;
//    private TextView textView;
//    private EditText editText;
    private int numValue;

    JsoupTeste js = new JsoupTeste();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView)findViewById(R.id.editttext);
        final EditText editText = (EditText)findViewById(R.id.numtext);
        final ImageView imageView = (ImageView)findViewById(R.id.imageView3);
        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.v("EditText", editText.getText().toString());
//                textView.setText(editText.getText().toString());
//                Log.v("tetxedit : ",textView.getText().toString());
//                Log.v("tetxedit sfff : ",editText.getText().toString());

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {



//                        numValue = Integer.parseInt(editText.getText().toString());
                        js.setValue(numValue);
                        js.setValueString(textView.getText().toString());

                        try {
                            new DownLoadImageTask(imageView).execute(js.getUrl());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

//                        try {
//                            Picasso.with(MainActivity.this).load(js.getUrl())
//                                    .placeholder(R.drawable.ic_user_icon)
//                                    .into(imageView);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }

//                        Log.v("TesteS : ",js.getImgUrl());
                        try {
                            js.getUrl();
//                            Log.v("Url : ",js.getUrl().toString());

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
//                        try {
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
                    }
                };

                Thread thread = new Thread(runnable);
                thread.start();



            }

        };
        floatingActionButton.setOnClickListener(onClickListener);
//        floatingActionButton.findViewById(R.id.floatingActionButton);

//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Runnable runnable = new Runnable() {
//                    @Override
//                    public void run() {
////                        JsoupTeste js= new JsoupTeste();
////                        numValue = Integer.parseInt(editText.getText().toString());
////                        js.setValue(numValue);
////                        js.setValueString(textView.getText().toString());
////                        try {
////                            js.getUrl();
////                        } catch (IOException e) {
////                            e.printStackTrace();
////                        }
//                    }
//                };
//            }
//        });
    }

    private class DownLoadImageTask extends AsyncTask<String,Void, Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                logo = BitmapFactory.decodeStream(is);
            }catch(Exception e){ // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        /*
            onPostExecute(Result result)
                Runs on the UI thread after doInBackground(Params...).
         */
        protected void onPostExecute(Bitmap result){
            imageView.setImageBitmap(result);
        }
    }



}