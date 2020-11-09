/*
package com.example.backgrounddataupdater.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdbapi.models.RackingZoneModel;
import com.example.roomdbapi.util.Constants;

import java.util.List;

@Dao
public interface ZoneDao {
    @Query("SELECT * FROM " + Constants.TABLE_NAME_ZONES)
    List<RackingZoneModel> getZones();


    @Insert
    long insertZone(RackingZoneModel zone);

    @Update
    void updateZone(RackingZoneModel zone);

    @Delete
    void deleteZone(RackingZoneModel zone);

    @Delete
    void deleteZone(RackingZoneModel... zone);

}
*/
