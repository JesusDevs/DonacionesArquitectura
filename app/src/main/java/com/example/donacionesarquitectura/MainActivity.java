package com.example.donacionesarquitectura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.donacionesarquitectura.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Instanciacion de objeto controller j
        controller = new Controller();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDonation();
            }
        });
    }

    public void saveDonation(){
        Integer amount = Integer.valueOf(binding.etDonacion.getText().toString());
        boolean save = controller.saveDonation(amount);
        if (save){
            String donationTotal = getString(R.string.donacion,
                    String.valueOf(controller.getTotalAmount()));
            binding.tVdonacion.setText(donationTotal);
            displayMessage("Se realizo la donación");
        } else {
            displayMessage("No fue posible realizar la donación en este momento");
        }
        binding.etDonacion.setText("");
    }

    // Recibe un string y muestra un Toast con el mensaje.
    private void displayMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}