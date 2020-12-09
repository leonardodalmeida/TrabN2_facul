package br.pro.adalto.compras2020_2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "listaVeiculos";
    private static final int VERSAO_BANCO = 1;

    public Banco(Context context){
        super(context, NOME_BANCO, null , VERSAO_BANCO );
    }

    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL( "CREATE TABLE IF NOT EXISTS produtos ( " +
//                                " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
//                                " nome TEXT NOT NULL , " +
//                                " preco DOUBLE  ) " );
//    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( "CREATE TABLE IF NOT EXISTS Veiculos ( " +
                " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                " nome_veiculo TEXT NOT NULL , " +
                " kmAtual_veiculo DOUBLE NOT NULL, " +
                " capacidade_tanque DOUBLE NOT NULL, " +
                " MediaKM DOUBLE  ) "
        );
        sqLiteDatabase.execSQL( "CREATE TABLE IF NOT EXISTS Abastecimentos ( " +
                " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                " veiculo_id INTEGER NOT NULL , " +
                " Dt_Abastecimento DATETIME NOT NULL , " +
                " kmAbastecimento_veiculo INTEGER NOT NULL , " +
                " precoGas DOUBLE NOT NULL, " +
                " precoEta DOUBLE NOT NULL, " +
                " capacidade_tanque DOUBLE NOT NULL, " +
                " Combs_indicado TEXT NOT NULL , " +
                " Combs_selecionado TEXT NOT NULL , " +
                " L_abastecidos DOUBLE  , FOREIGN KEY ( veiculo_id ) REFERENCES Veiculos ( id ) ON DELETE RESTRICT ON UPDATE CASCADE) " );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
