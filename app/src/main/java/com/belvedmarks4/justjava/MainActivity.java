package com.belvedmarks4.justjava;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //Class variable for quantity
    public int quantity = 0;
    public int pricePerCoffee = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display(quantity);
    }

    public void submitOrder(View view) {
        displayPrice(quantity*5);
    }

    public void quantityAdd(View view) {
        quantity += 1;
        display(quantity);
        displayPrice(quantity);
    }

    public void quantitySubtract(View view) {
        if (quantity < 1) {
            quantity = 0;
        } else {
            quantity -= 1;
        }
        display(quantity);
        displayPrice(quantity);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number*pricePerCoffee));
    }

}
