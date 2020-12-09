package br.pro.adalto.compras2020_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AbastecimentoDAO {

//            " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
//            " veiculo_id INTEGER NOT NULL , " +
//            " Dt_Abastecimento DATETIME NOT NULL , " +
//            " kmAbastecimento_veiculo INTEGER NOT NULL , " +
//            " precoGas DOUBLE NOT NULL, " +
//            " precoEta DOUBLE NOT NULL, " +
//            " capacidade_tanque DOUBLE NOT NULL, " +
//            " Combs_indicado TEXT NOT NULL , " +
//            " Combs_selecionado TEXT NOT NULL , " +
//            " L_abastecidos DOUBLE


    public static void inserir(Context context, Abastecimento abastecimento){

        ContentValues valores = new ContentValues();
        valores.put("id" , abastecimento.getId() );
        valores.put("veiculo_id" , abastecimento.getId_veiculo() );
        valores.put("Dt_Abastecimento" , String.valueOf(abastecimento.getDt_Abastecimento()));
        valores.put("kmAbastecimento_veiculo" , abastecimento.getKM_abastecimento() );
        valores.put("precoGas" , abastecimento.getprecoGas() );
        valores.put("precoEta" , abastecimento.getprecoEta() );
        valores.put("capacidade_tanque" , abastecimento.getTanque() );
        valores.put("Combs_indicado" , abastecimento.getCombs_indicado() );
        valores.put("Combs_selecionado" , abastecimento.getCombs_selecionado() );
        valores.put("L_abastecidos" , abastecimento.getLitrosAbastecidos() );

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.insert("Abastecimentos", null, valores);

    }

    public static void editar(Context context, Abastecimento abastecimento){

        ContentValues valores = new ContentValues();
        valores.put("id" , abastecimento.getId() );
        valores.put("veiculo_id" , abastecimento.getId_veiculo() );
        valores.put("Dt_Abastecimento" , String.valueOf(abastecimento.getDt_Abastecimento()));
        valores.put("kmAbastecimento_veiculo" , abastecimento.getKM_abastecimento() );
        valores.put("precoGas" , abastecimento.getprecoGas() );
        valores.put("precoEta" , abastecimento.getprecoEta() );
        valores.put("capacidade_tanque" , abastecimento.getTanque() );
        valores.put("Combs_indicado" , abastecimento.getCombs_indicado() );
        valores.put("Combs_selecionado" , abastecimento.getCombs_selecionado() );
        valores.put("L_abastecidos" , abastecimento.getLitrosAbastecidos() );

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.update("Abastecimentos", valores, " id = " + abastecimento.getId(), null);

    }

    public static void excluir(Context context, int idAbastecimento){

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.delete("Abastecimentos", " id = " + idAbastecimento, null);

    }


//    public static List<Abastecimento> getProdutos(Context context){
//        List<Abastecimento> lista = new ArrayList<>();
//        Banco banco = new Banco(context);
//        SQLiteDatabase db = banco.getReadableDatabase();
//        Cursor cursor =  db.rawQuery("SELECT * FROM Abastecimentos ORDER BY veiculo_id" , null);
//        if( cursor.getCount() > 0 ){
//            cursor.moveToFirst();
//            do {
//                Abastecimento p = new Abastecimento();
//                p.setId( cursor.getInt( 0 ) );
//                p.setNome( cursor.getString( 1 ) );
//                p.setKM_atual( cursor.getDouble( 2 ));
//                lista.add( p );
//            }while ( cursor.moveToNext() );
//        }
//        return lista;
//    }
//
//    public static Abastecimento getProdutoById(Context context, int idAbastecimento){
//
//        Banco banco = new Banco(context);
//        SQLiteDatabase db = banco.getReadableDatabase();
//
//        Cursor cursor =  db.rawQuery("SELECT * FROM Abastecimentos WHERE id = " + idAbastecimento , null);
//        if( cursor.getCount() > 0 ){
//            cursor.moveToFirst();
//
//            Abastecimento p = new Abastecimento();
//            p.setId( cursor.getInt( 0 ) );
//            p.setNome( cursor.getString( 1 ) );
//            p.setKM_atual( cursor.getDouble( 2 ));
//
//            return p;
//
//        }else{
//            return null;
//        }
//    }


}
