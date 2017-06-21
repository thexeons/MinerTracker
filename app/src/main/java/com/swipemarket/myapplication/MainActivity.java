package com.swipemarket.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String jsonString;
    DecimalFormat formatter = new DecimalFormat("#,###.00");
    double jumlah;
    double rupiah;
    String zcl,zclassic, ayy;
    List <Data> d;
    TextView tv,zcltv, unconfirmed, confirmed, hashrate,balancetv,total,IDR, percentage;
    ProgressBar progress2;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.text1);
        zcltv = (TextView) findViewById(R.id.ZCL);
        unconfirmed = (TextView) findViewById(R.id.unconfirmed);
        confirmed = (TextView) findViewById(R.id.confirmed);
        hashrate = (TextView) findViewById(R.id.hashrate);
        balancetv = (TextView) findViewById(R.id.balancetv);
        total = (TextView) findViewById(R.id.total);
        IDR = (TextView) findViewById(R.id.totalIDR);
        percentage = (TextView) findViewById(R.id.textView12);
        progress2 = (ProgressBar) findViewById(R.id.progressBar3);

    }
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        new AsyncCaller().execute();
    }
    public void Klik(View v)
    {
        new AsyncCaller().execute();
    }

    private class AsyncCaller extends AsyncTask<Void, Void, Void>
    {
        ProgressDialog pdLoading = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //this method will be running on UI thread
            pdLoading.setMessage("\tLoading...");
            pdLoading.show();
        }
        @Override
        protected Void doInBackground(Void... params) {
            //this method will be running on background thread so don't update UI frome here
            //do your long running http tasks here,you dont want to pass argument and u can access the parent class' variable url over here
            URL url = null;
            try {
                url = new URL("https://vip.bitcoin.co.id/api/btc_idr/ticker");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection urlConnection = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BufferedInputStream in = new BufferedInputStream(urlConnection.getInputStream());
                jsonString = IOUtils.toString(in,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }
            //URL2
            try {
                url = new URL("https://bittrex.com/api/v1.1/public/getmarketsummary?market=btc-zcl");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            urlConnection = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BufferedInputStream in = new BufferedInputStream(urlConnection.getInputStream());
                zcl = IOUtils.toString(in,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }
            //URL3
            try {
                url = new URL("http://zclassic.miningpoolhub.com/index.php?page=api&action=getdashboarddata&api_key=72903ab815d0884027a55940558ffbdd607d3c6e9b5b726041ffb3776734d991");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            urlConnection = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BufferedInputStream in = new BufferedInputStream(urlConnection.getInputStream());
                zclassic = IOUtils.toString(in,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }

            //URL4
            try {
                url = new URL("https://aayanl.tech/insight-api/addr/t1WtGhNbKXEwzsXXr4Qs9SthS5vqvEaogv3/?noTxList=1");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            urlConnection = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BufferedInputStream in = new BufferedInputStream(urlConnection.getInputStream());
                ayy = IOUtils.toString(in,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            //this method will be running on UI thread
            //Toast.makeText(MainActivity.this, test, Toast.LENGTH_SHORT).show();
            JSONObject a = new JSONObject();
            JSONObject ticker = new JSONObject();
            try {
                a = new JSONObject(jsonString);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                ticker = a.getJSONObject("ticker");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                tv.setText(ticker.getString("last"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //URL 2
            JSONArray arr1 = new JSONArray();

            try {
                a = new JSONObject(zcl);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                arr1 = a.getJSONArray("result");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                zcltv.setText(arr1.getJSONObject(0).getString("Last"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //URL3
            try {
                a = new JSONObject(zclassic);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                ticker = a.getJSONObject("getdashboarddata");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONObject data = new JSONObject();
            try {
                data = ticker.getJSONObject("data");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONObject personal = new JSONObject();
            try {
                personal = data.getJSONObject("personal");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONObject estimates = new JSONObject();
            try {
                estimates = personal.getJSONObject("estimates");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONObject balance = new JSONObject();
            try {
                balance = data.getJSONObject("balance");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                unconfirmed.setText(balance.getString("unconfirmed"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                confirmed.setText(balance.getString("confirmed"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Update hashrate di UI
            try {
                hashrate.setText(personal.getString("hashrate"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //URL4
            try {
                a = new JSONObject(ayy);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                balancetv.setText(a.getString("balance"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jumlah = Double.parseDouble(unconfirmed.getText().toString()) + Double.parseDouble(confirmed.getText().toString()) + Double.parseDouble(balancetv.getText().toString());
            rupiah = jumlah * Double.parseDouble(zcltv.getText().toString()) * Double.parseDouble(tv.getText().toString());
            double currentDouble = (Double.parseDouble(unconfirmed.getText().toString()) + Double.parseDouble(confirmed.getText().toString())) * 10;
            int current = (int) currentDouble;
            int persen = current * 100 / 26;
            total.setText(Double.toString(jumlah));
            IDR.setText(" (IDR " + formatter.format(rupiah) + ")");
            percentage.setText(persen + "% Completion rate");
            progress2.setMax(26);
            progress2.setProgress(current);
            pdLoading.dismiss();
        }
    }

}
