package luis_alberto_curiel.ipsmarchamalo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class IPSSQLHelper extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE t_mesas (id TEXT, equipo TEXT, envio TEXT, precio TEXT, ticket TEXT, reader TEXT)";

    public IPSSQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS t_mesas");
        db.execSQL(sqlCreate);
    }
}
