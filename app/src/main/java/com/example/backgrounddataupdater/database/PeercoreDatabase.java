package com.example.backgrounddataupdater.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.backgrounddataupdater.database.dao.VoteDao;
import com.example.backgrounddataupdater.models.VoteModel;
import com.example.backgrounddataupdater.util.Constants;
import com.example.backgrounddataupdater.util.DateRoomConverter;

@Database(entities = { VoteModel.class}, version = 1, exportSchema = false)
@TypeConverters({DateRoomConverter.class})

public abstract class PeercoreDatabase extends RoomDatabase {

    public abstract VoteDao getVotes();

    private static PeercoreDatabase PeerDB;

    // synchronized is use to avoid concurrent access in multithreaded environment
    public static /*synchronized*/ PeercoreDatabase getInstance(Context context) {
        if (null == PeerDB) {
            PeerDB = buildDatabaseInstance(context);
        }
        return PeerDB;
    }

    private static PeercoreDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                PeercoreDatabase.class,
                Constants.DB_NAME).allowMainThreadQueries().build();
    }

    public  void cleanUp(){
        PeerDB = null;
    }

}
