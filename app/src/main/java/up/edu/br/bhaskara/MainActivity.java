package up.edu.br.bhaskara;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    private EditText edtNumA, edtNumB, edtNumC;
    private Button btnCalcular;
    private TextView txtResultadoX1, txtResultadoX2;
    private Double delta, valorA, valorB, valorC, x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumA = findViewById(R.id.edtNumA);
        edtNumB = findViewById(R.id.edtNumB);
        edtNumC = findViewById(R.id.edtNumC);

        txtResultadoX1 = findViewById(R.id.txtResultadoX1);
        txtResultadoX2 = findViewById(R.id.txtResultadoX2);

        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = edtNumA.getText().toString();
                String s2 = edtNumB.getText().toString();
                String s3 = edtNumC.getText().toString();

                valorA = Double.valueOf(s1);
                valorB = Double.valueOf(s2);
                valorC = Double.valueOf(s3);

                delta = (valorB * valorB) - (4 * valorA * valorC);

                if(delta >= 0)
                {
                    x1 = (- valorB + Math.sqrt(delta)) / (2 * valorA);
                    x2 = (- valorB - Math.sqrt(delta)) / (2 * valorA);

                    String formatX1 = String.format("%.2f", x1);
                    String formatX2 = String.format("%.2f", x2);

                    txtResultadoX1.setText(formatX1);
                    txtResultadoX2.setText(formatX2);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Delta não pode ser calculado", Toast.LENGTH_SHORT).show();
                }

                exibirMensagem();
            }
        });

    }

    private void exibirMensagem() {
        //Caixa de Mensagem
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //        Thread.sleep(5000);

        builder.setMessage("Deseja reiniciar?");

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                edtNumA.setText("");
                edtNumB.setText("");
                edtNumC.setText("");
                txtResultadoX1.setText("");
                txtResultadoX2.setText("");
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        //Criando a Mensagem
        AlertDialog dialog = builder.create();
        dialog.show();
    }



}
