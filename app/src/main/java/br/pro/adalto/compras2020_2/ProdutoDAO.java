package br.pro.adalto.compras2020_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public static void inserir(Context context, Produto produto){

        ContentValues valores = new ContentValues();
        valores.put("nome_veiculo" , produto.getNome() );
        valores.put("kmAtual_veiculo" , produto.getKM_atual() );
        valores.put("capacidade_tanque" , produto.getTanque() );

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.insert("Veiculos", null, valores);

    }

    public static void editar(Context context, Produto produto){

        ContentValues valores = new ContentValues();
        valores.put("nome_veiculo" , produto.getNome() );
        valores.put("kmAtual_veiculo" , produto.getKM_atual() );
        valores.put("capacidade_tanque" , produto.getTanque() );

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.update("Veiculos", valores, " id = " + produto.getId(), null);

    }

    public static void excluir(Context context, int idProduto){

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.delete("Veiculos", " id = " + idProduto, null);

    }


    public static List<Produto> getProdutos(Context context){
        List<Produto> lista = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor =  db.rawQuery("SELECT * FROM Veiculos ORDER BY nome_veiculo" , null);
        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do {
                Produto p = new Produto();
                p.setId( cursor.getInt( 0 ) );
                p.setNome( cursor.getString( 1 ) );
                p.setKM_atual( cursor.getDouble( 2 ));
                lista.add( p );
            }while ( cursor.moveToNext() );
        }
        return lista;
    }

    public static Produto getProdutoById(Context context, int idProduto){

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();

        Cursor cursor =  db.rawQuery("SELECT * FROM Veiculos WHERE id = " + idProduto , null);
        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();

            Produto p = new Produto();
            p.setId( cursor.getInt( 0 ) );
            p.setNome( cursor.getString( 1 ) );
            p.setKM_atual( cursor.getDouble( 2 ));

            return p;

        }else{
            return null;
        }
    }


}
