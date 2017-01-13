package me.himanshusoni.quantityview.sample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import me.himanshusoni.quantityview.QuantityView;

public class MainActivity extends AppCompatActivity implements QuantityView.OnQuantityChangeListener {

    private int pricePerProduct = 180;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }

        final QuantityView quantityViewDefault = (QuantityView) findViewById(R.id.quantityView_default);
        quantityViewDefault.setOnQuantityChangeListener(this);
        quantityViewDefault.setQuantityClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Change Quantity");

                View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_dialog_change_quantity, null, false);
                final EditText et = (EditText) inflate.findViewById(R.id.et_qty);
                final TextView tvPrice = (TextView) inflate.findViewById(R.id.tv_price);
                final TextView tvTotal = (TextView) inflate.findViewById(R.id.tv_total);

                et.setText(String.valueOf(quantityViewDefault.getQuantity()));
                tvPrice.setText("$ " + pricePerProduct);
                tvTotal.setText("$ " + quantityViewDefault.getQuantity() * pricePerProduct);


                et.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (TextUtils.isEmpty(s)) return;
                        if (QuantityView.isValidNumber(s.toString())) {
                            int intNewQuantity = Integer.parseInt(s.toString());
                            tvTotal.setText("$ " + intNewQuantity * pricePerProduct);
                        } else {
                            Toast.makeText(MainActivity.this, "Enter valid integer", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                builder.setView(inflate);
                builder.setPositiveButton("Change", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String newQuantity = et.getText().toString();
                        if (TextUtils.isEmpty(newQuantity)) return;

                        int intNewQuantity = Integer.parseInt(newQuantity);

                        quantityViewDefault.setQuantity(intNewQuantity);
                    }
                }).setNegativeButton("Cancel", null);
                builder.show();
            }
        });

        QuantityView quantityViewCustom1 = (QuantityView) findViewById(R.id.quantityView_custom_1);
        quantityViewCustom1.setOnQuantityChangeListener(this);

        QuantityView quantityViewCustom2 = (QuantityView) findViewById(R.id.quantityView_custom_2);
        quantityViewCustom2.setOnQuantityChangeListener(this);

    }

    @Override
    public void onQuantityChanged(int oldQuantity, int newQuantity, boolean programmatically) {
        QuantityView quantityViewCustom1 = (QuantityView) findViewById(R.id.quantityView_custom_1);
        if (newQuantity == 3) {
            quantityViewCustom1.setQuantity(oldQuantity);
        }
        Toast.makeText(MainActivity.this, "Quantity: " + newQuantity, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLimitReached() {
        Log.d(getClass().getSimpleName(), "Limit reached");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
