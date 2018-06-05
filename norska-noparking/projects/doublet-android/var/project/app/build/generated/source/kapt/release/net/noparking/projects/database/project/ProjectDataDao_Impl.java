package net.noparking.projects.database.project;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import android.support.annotation.NonNull;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProjectDataDao_Impl implements ProjectDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfProject;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  public ProjectDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProject = new EntityInsertionAdapter<Project>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `projects`(`id`,`project_name`,`directory`,`color`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Project value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getProject_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProject_name());
        }
        if (value.getDirectory() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDirectory());
        }
        stmt.bindLong(4, value.getColor());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE from projects";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM projects WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public long insert(Project ProjectData) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfProject.insertAndReturnId(ProjectData);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public void deleteById(long id) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, id);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteById.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Project>> getAll() {
    final String _sql = "SELECT * from projects";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Project>>() {
      private Observer _observer;

      @Override
      protected List<Project> compute() {
        if (_observer == null) {
          _observer = new Observer("projects") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfProjectName = _cursor.getColumnIndexOrThrow("project_name");
          final int _cursorIndexOfDirectory = _cursor.getColumnIndexOrThrow("directory");
          final int _cursorIndexOfColor = _cursor.getColumnIndexOrThrow("color");
          final List<Project> _result = new ArrayList<Project>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Project _item;
            _item = new Project();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpProject_name;
            _tmpProject_name = _cursor.getString(_cursorIndexOfProjectName);
            _item.setProject_name(_tmpProject_name);
            final String _tmpDirectory;
            _tmpDirectory = _cursor.getString(_cursorIndexOfDirectory);
            _item.setDirectory(_tmpDirectory);
            final int _tmpColor;
            _tmpColor = _cursor.getInt(_cursorIndexOfColor);
            _item.setColor(_tmpColor);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<Project> getById(long id) {
    final String _sql = "SELECT * from projects WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return new ComputableLiveData<Project>() {
      private Observer _observer;

      @Override
      protected Project compute() {
        if (_observer == null) {
          _observer = new Observer("projects") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfProjectName = _cursor.getColumnIndexOrThrow("project_name");
          final int _cursorIndexOfDirectory = _cursor.getColumnIndexOrThrow("directory");
          final int _cursorIndexOfColor = _cursor.getColumnIndexOrThrow("color");
          final Project _result;
          if(_cursor.moveToFirst()) {
            _result = new Project();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _result.setId(_tmpId);
            final String _tmpProject_name;
            _tmpProject_name = _cursor.getString(_cursorIndexOfProjectName);
            _result.setProject_name(_tmpProject_name);
            final String _tmpDirectory;
            _tmpDirectory = _cursor.getString(_cursorIndexOfDirectory);
            _result.setDirectory(_tmpDirectory);
            final int _tmpColor;
            _tmpColor = _cursor.getInt(_cursorIndexOfColor);
            _result.setColor(_tmpColor);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
