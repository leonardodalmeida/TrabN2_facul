package br.pro.adalto.compras2020_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class AbasteceActivity2 extends AppCompatActivity {

    private EditText etValorGasolina, etValorEtanol, etQuilometragem, etLitrosAbastecidos;
    private Button btnSalvar;
    private Spinner spTipo;
    private String acao;
    private Produto produto;
    private Abastecimento abastecimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastece2);

        acao = getIntent().getExtras().getString("acao");

        etValorGasolina = findViewById(R.id.etValorGasolina);
        etValorEtanol = findViewById(R.id.etValorEtanol);
        etQuilometragem = findViewById(R.id.etQuilometragem);
        etLitrosAbastecidos = findViewById(R.id.etLitrosAbastecidos);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        if( acao.equals("editar") ){
            int id = getIntent().getExtras().getInt("idProduto");
            produto = ProdutoDAO.getProdutoById(AbasteceActivity2.this, id);
            //etNome.setText( produto.getNome() );
            etQuilometragem.setText( String.valueOf( abastecimento.getKM_abastecimento() )  );
            etLitrosAbastecidos.setText( String.valueOf( abastecimento.getLitrosAbastecidos() )  );
        }
        spTipo = findViewById(R.id.spTipo);

        spTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String tipo = adapterView.getItemAtPosition(i).toString();
                selecionarTipo(tipo);                        //adicionando as informações do spinner, o usuário acionou um item
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        etValorEtanol.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                String ValorGasolina = etValorGasolina.getText().toString();
                String ValorEtanol = etValorEtanol.getText().toString();

                if (!ValorGasolina.isEmpty() && !ValorEtanol.isEmpty()) {
                    ValorGasolina = ValorGasolina.replace(",", ".");
                    double Vg = Double.valueOf(ValorGasolina);
                    //produto.setvGas(Vg);

                    ValorEtanol = ValorEtanol.replace(",", ".");
                    double Ve = Double.valueOf(ValorEtanol);
                    //produto.setvEta(Ve);

                    double valor = Produto.calcular(Vg, Ve);

                    if (valor < 0.7) {
                        //AlertDialog.Builder alerta = new AlertDialog.Builder(FormularioActivity2.this);
                        AlertDialog.Builder alerta = new AlertDialog.Builder(AbasteceActivity2.this);
                        alerta.setMessage("Abasteça com Etanol");
                        alerta.setPositiveButton("OK", null);
                        alerta.show();
                    } else {
                        AlertDialog.Builder alerta = new AlertDialog.Builder(AbasteceActivity2.this);
                        alerta.setMessage("Abasteça com Gasolina");
                        alerta.setPositiveButton("OK", null);
                        alerta.show();
                    }
                }
            }
        });

        etValorGasolina.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {

                    String ValorGasolina = etValorGasolina.getText().toString();
                    String ValorEtanol = etValorEtanol.getText().toString();

                    if (!ValorGasolina.isEmpty() && !ValorEtanol.isEmpty()) {
                        ValorGasolina = ValorGasolina.replace(",", ".");
                        double Vg = Double.valueOf(ValorGasolina);
                        //produto.setvGas(Vg);

                        ValorEtanol = ValorEtanol.replace(",", ".");
                        double Ve = Double.valueOf(ValorEtanol);
                        //produto.setvEta(Ve);

                        double valor = Produto.calcular(Vg, Ve);

                        if (valor > 0.7) {
                            AlertDialog.Builder alerta = new AlertDialog.Builder(AbasteceActivity2.this);
                            alerta.setMessage("Abasteça com Gasolina");
                            alerta.setPositiveButton("OK", null);
                            alerta.show();
                        } else {
                            AlertDialog.Builder alerta = new AlertDialog.Builder(AbasteceActivity2.this);
                            alerta.setMessage("Abasteça com Etanol");
                            alerta.setPositiveButton("OK", null);
                            alerta.show();
                        }
                    }
                }
            }
        });
    }

    private void salvar(){
        if ( abastecimento == null ){
            abastecimento = new Abastecimento();
        }

        // tentei copiar o salvar para mudar da classe FommularioActivity2 _mas entendo que vou precisar ajustar outras coisas primeiro

        Double KM = Double.valueOf(etQuilometragem.getText().toString());
        Double Litros = Double.valueOf(etLitrosAbastecidos.getText().toString());
        if ( KM.isNaN() && Litros.isNaN() ){
            AlertDialog.Builder alerta = new AlertDialog.Builder( this);
            alerta.setTitle("Atenção!");
            alerta.setMessage("O KM do veículo deve ser preenchido!");
            alerta.setIcon( android.R.drawable.ic_dialog_alert );
            alerta.setPositiveButton("OK", null);
            alerta.show();
        }else{
            abastecimento.setKM_abastecimento( KM );
            String sLitros_abst = etLitrosAbastecidos.getText().toString();
            String sKM_Atual = etQuilometragem.getText().toString();
            //km atual
            if( sKM_Atual.isEmpty() ){
                //if( sPreco.isEmpty() ){
                abastecimento.setKM_abastecimento( 0.0 );
            }else {
                sKM_Atual = sKM_Atual.replace( "," , ".");
                double KM_Atual = Double.valueOf( sKM_Atual );
                abastecimento.setKM_abastecimento( KM_Atual );
            }
            //tanque
            if( sLitros_abst.isEmpty() ){
                abastecimento.setTanque( 0.0 );
            }else {
                sLitros_abst = sLitros_abst.replace( "," , ".");
                double Tanque = Double.valueOf( sLitros_abst );
                abastecimento.setTanque( Tanque );
            }

            if( acao.equals( "inserir" ) ){
                AbastecimentoDAO.inserir( this , abastecimento );
                abastecimento = null;
                etLitrosAbastecidos.setText("");
                etQuilometragem.setText("");
                etValorEtanol.setText("");
                etValorGasolina.setText("");
            }else{
                AbastecimentoDAO.editar(this, abastecimento);
                finish();
            }

        }
    }

    private void selecionarTipo (String tipo){
        String[] tipoComb = {"Selecione", "Gasolina", "Etanol"};

        String[] tipos;

        switch (tipo) {
            case "Gasolina":
                tipos = tipoComb;
                spTipo.setEnabled(true);
                break;
            case "Etanol":
                tipos = tipoComb;
                spTipo.setEnabled(true);
                break;
            default:
                tipos = new String[]{"Selecione um tipo de combustível!"};
                spTipo.setEnabled(false);
        }

        ArrayAdapter adapter = new ArrayAdapter(AbasteceActivity2.this, android.R.layout.simple_list_item_1);
        spTipo.setAdapter(adapter);
    }
}
