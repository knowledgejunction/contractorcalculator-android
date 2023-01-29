package com.example.contractorcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculateTotal();
    }

    private void calculateTotal() {
        Button calculateButton = findViewById(R.id.button_calculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double taxRate = 0.05;
                DecimalFormat df = new DecimalFormat("#.00");
                EditText laborTextField = findViewById(R.id.editText_labor);
                EditText materialsTextField = findViewById(R.id.editText_material);

                double laborCost = Double.parseDouble(laborTextField.getText().toString());
                double materialCost = Double.parseDouble(materialsTextField.getText().toString());
                double subTotal = laborCost+materialCost;
                double tax=subTotal*taxRate;
                double total = subTotal + tax;

                TextView subTotalTxtView = findViewById(R.id.textView_subTotal);
                String subTotalInString = String.format("SubTotal:   %s",df.format(subTotal));
                subTotalTxtView.setText(subTotalInString);

                TextView taxView = findViewById(R.id.textView_tax);
                String taxInString = String.format("Tax:   %s",df.format(tax));
                taxView.setText(taxInString);

                TextView totalTxtView = findViewById(R.id.textView_total);
                String totalInString = String.format("Total:   %s",df.format(total));
                totalTxtView.setText(totalInString);
            }
        });
    }
}