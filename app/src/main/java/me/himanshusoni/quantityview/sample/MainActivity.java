package me.himanshusoni.quantityview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import me.himanshusoni.quantityview.QuantityView;

public class MainActivity extends AppCompatActivity implements QuantityView.OnQuantityChangeListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuantityView quantityViewDefault = (QuantityView) findViewById(R.id.quantityView_default);
        quantityViewDefault.setOnQuantityChangeListener(this);

        QuantityView quantityViewCustom1 = (QuantityView) findViewById(R.id.quantityView_custom_1);
        quantityViewCustom1.setOnQuantityChangeListener(this);

        QuantityView quantityViewCustom2 = (QuantityView) findViewById(R.id.quantityView_custom_2);
        quantityViewCustom2.setOnQuantityChangeListener(this);

    }

    @Override
    public void onQuantityChanged(int newQuantity, boolean programmatically) {
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
        }

        return super.onOptionsItemSelected(item);
    }
}
