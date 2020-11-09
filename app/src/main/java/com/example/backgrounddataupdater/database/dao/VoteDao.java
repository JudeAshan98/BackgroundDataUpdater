package com.example.backgrounddataupdater.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.backgrounddataupdater.models.VoteModel;
import com.example.backgrounddataupdater.util.Constants;

import java.util.List;
@Dao
public interface VoteDao {
    @Query("SELECT * FROM " + Constants.TABLE_NAME_VOTES)
    List<VoteModel> getVotes();

    @Query("SELECT * FROM " + Constants.TABLE_NAME_VOTES + " WHERE " + " 'status' = 'OFF' ")
    List<VoteModel> getOffVotes();


    @Query("SELECT * FROM " + Constants.TABLE_NAME_VOTES + " WHERE " + " 'status' = 'ON' ")
    List<VoteModel> getOnVotes();

    @Insert
    long insertVote(VoteModel vote);

    @Update
    void updateVote(VoteModel vote);

    @Delete
    void deleteVote(VoteModel vote);

    @Delete
    void deleteVote(VoteModel... vote);


}
