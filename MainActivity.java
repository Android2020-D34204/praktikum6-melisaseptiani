package id.ac.id.telkomuniversity.tass.praktikactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonPindah;
    EditText tempatEdit;

    private String KEY_NAME = "TEKS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPindah = findViewById(R.id.button);
        tempatEdit = findViewById(R.id.editText);

        buttonPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String teks = tempatEdit.getText().toString();
                if (TextUtils.isEmpty(teks)) {
                    Toast.makeText(getApplicationContext(), "Input tidak boleh kosong",
                            Toast.LENGTH_LONG).show();

                } else {
                    Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                    intent.putExtra(KEY_NAME, teks);
                    openAlert(intent);

                }
            }
        });
    }
    public void openAlert (final Intent intent){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Yakin ingin pindah ?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                startActivity(intent);

            }
        });
        builder.setNegativeButton("Tidak",null);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.show();
    }

}