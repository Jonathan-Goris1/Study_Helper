package com.zybooks.studyhelper.model;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface SubjectDao {
    @Query("SELECT * FROM Subject WHERE id = :id")
    Subject getSubject(long id);

    @Query("SELECT * FROM Subject WHERE text = :subjectText")
    Subject getSubjectByText(String subjectText);

    @Query("SELECT * FROM Subject ORDER BY text COLLATE NOCASE")
    List<Subject> getSubjects();

    @Query("SELECT * FROM Subject ORDER BY updated DESC")
    List<Subject> getSubjectsNewerFirst();

    @Query("SELECT * FROM Subject ORDER BY updated ASC")
    List<Subject> getSubjectsOlderFirst();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertSubject(Subject subject);

    @Update
    void updateSubject(Subject subject);

    @Delete
    void deleteSubject(Subject subject);
}