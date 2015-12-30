package lab.synah.cd.monairteletmoi.controller;

/**
 * Created by DieuvainMusaghi on 29/12/15.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

//Database adaptateur

public class MonAirtelDBAdapter {

    public static final String KEY_ROWID = "_id";
    public static final String KEY_TOWN = "town";
    public static final String KEY_NAME = "fullname";
    public static final String KEY_PHONE = "phonenumber";

    public static final String KEY_TEXTE = "texte";
    public static final String KEY_CODE = "ussd";


    private static final String SQLITE_SUB = "SUBSCRIBER";
    private static final String SQLITE_USSD = "USSD";

    private static final String TAG = "MonAirtelDbAdapter";
    private DBAirtelEtMoiHelper mDbHelper;
    private SQLiteDatabase mDb;


    private final Context mCtx;


    public MonAirtelDBAdapter(Context ctx)
    {
        this.mCtx = ctx;
    }

    public MonAirtelDBAdapter open() throws SQLException {
        mDbHelper = new DBAirtelEtMoiHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if (mDbHelper != null) {
            mDbHelper.close();
        }
    }

    public long createSubscriber(String town, String fullname, String Phonenumber) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_TOWN, town);
        initialValues.put(KEY_NAME, fullname);
        initialValues.put(KEY_PHONE, Phonenumber);

        return mDb.insert(SQLITE_SUB, null, initialValues);
    }

    public boolean deleteSubscriber() {

        int doneDelete = 0;
        doneDelete = mDb.delete(SQLITE_SUB, null , null);
        Log.w(TAG, Integer.toString(doneDelete));
        return doneDelete > 0;

    }

    public Cursor fetchSubscriberByName(String inputText) throws SQLException {
        Log.w(TAG, inputText);
        Cursor mCursor = null;
        if (inputText == null  ||  inputText.length () == 0)  {
            mCursor = mDb.query(SQLITE_SUB, new String[] {KEY_ROWID,
                            KEY_TOWN, KEY_NAME, KEY_PHONE},
                    null, null, null, null, null);

        }
        else {
            mCursor = mDb.query(SQLITE_SUB, new String[] {KEY_ROWID,
                            KEY_TOWN, KEY_NAME, KEY_PHONE},
                    KEY_NAME + " like '%" + inputText + "%'", null,
                    null, null, null, null);
        }
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    public Cursor fetchAllSubscriber() {

        Cursor mCursor = mDb.query(SQLITE_SUB, new String[] {KEY_ROWID,
                        KEY_TOWN, KEY_NAME, KEY_PHONE},
                null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    // Insertion des Données dans la Table des Utilisateurs enregistrés
    public void insertSomeSubscriber() {

        createSubscriber("GOMA", "DIEUVAIN MUSAGHI", "0994662200");
        createSubscriber("GOMA", "MICHELO MUSAGHI", "0994669800");
        createSubscriber("GOMA", "DIEUVAIN MUSAGHI", "0997892200");
        createSubscriber("GOMA", "HUGO MUSAGHI", "0994662200");
        createSubscriber("GOMA", "MOISE MOGA", "0994662200");
        createSubscriber("GOMA", "SAMUEL MUSAGHI", "0994662200");
        createSubscriber("GOMA", "DJANI MUSAGHI", "0994897009");


}
}
