package br.pro.adalto.compras2020_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNome, etKM_atual, etTanque;
    private Button btnSalvar;
    private String acao;
    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        acao = getIntent().getExtras().getString("acao");

        etNome = findViewById(R.id.etNome);
        etKM_atual = findViewById(R.id.etKM_atual);
        etTanque = findViewById(R.id.etTanque);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        if( acao.equals("editar") ){
            int id = getIntent().getExtras().getInt("idProduto");
            produto = ProdutoDAO.getProdutoById(FormularioActivity.this, id);
            etNome.setText( produto.getNome() );
            etKM_atual.setText( String.valueOf( produto.getKM_atual() )  );
            etTanque.setText( String.valueOf( produto.getTanque() )  );
        }

    }

    private void salvar(){
        if ( produto == null ){
            produto = new Produto();
        }

        String nome = etNome.getText().toString();
        if ( nome.isEmpty() ){
            AlertDialog.Builder alerta = new AlertDialog.Builder( this);
            alerta.setTitle("Atenção!");
            alerta.setMessage("O nome do veículo deve ser preenchido!");
            alerta.setIcon( android.R.drawable.ic_dialog_alert );
            alerta.setPositiveButton("OK", null);
            alerta.show();
        }else{
            produto.setNome( nome );
            String sKM_Atual = etKM_atual.getText().toString();
            String sTanque = etTanque.getText().toString();
            //km atual
            if( sKM_Atual.isEmpty() ){
                //if( sPreco.isEmpty() ){
                produto.setKM_atual( 0.0 );
            }else {
                sKM_Atual = sKM_Atual.replace( "," , ".");
                //sPreco = sPreco.replace( "," , ".");
                double KM_Atual = Double.valueOf( sKM_Atual );
                produto.setKM_atual( KM_Atual );
            }
            //tanque
            if( sTanque.isEmpty() ){
                //if( sPreco.isEmpty() ){
                produto.setTanque( 0.0 );
            }else {
                sTanque = sTanque.replace( "," , ".");
                //sPreco = sPreco.replace( "," , ".");
                double Tanque = Double.valueOf( sTanque );
                produto.setTanque( Tanque );
            }

            if( acao.equals( "inserir" ) ){
                ProdutoDAO.inserir( this , produto );
                produto = null;
                etNome.setText("");
                etKM_atual.setText("");
                etTanque.setText("");
            }else{
                ProdutoDAO.editar(this, produto);
                finish();
            }

        }
    }

}