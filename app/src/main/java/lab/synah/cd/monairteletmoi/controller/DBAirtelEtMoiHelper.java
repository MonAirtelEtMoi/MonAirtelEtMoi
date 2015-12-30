package lab.synah.cd.monairteletmoi.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Michelo on 30/12/15.
 */
public class DBAirtelEtMoiHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "MonAirtelDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = "MonAirtelDbAdapter";

    private static final String DATABASE_CREATE =
            "CREATE TABLE if not exists Suscriber ( _id integer PRIMARY KEY autoincrement, fullname text not null, phone number text not null unique, town text)";


    public DBAirtelEtMoiHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.w(TAG, DATABASE_CREATE);
        db.execSQL(DATABASE_CREATE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS Suscriber");
        onCreate(db);
    }


}
