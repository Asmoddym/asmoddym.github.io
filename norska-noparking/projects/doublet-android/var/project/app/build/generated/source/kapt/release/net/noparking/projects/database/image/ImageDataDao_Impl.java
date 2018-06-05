package net.noparking.projects.database.image;

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

public class ImageDataDao_Impl implements ImageDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfImage;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ImageDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfImage = new EntityInsertionAdapter<Image>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `images`(`id`,`project_id`,`file_name`,`image_name`,`uri`,`color`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Image value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getProject_id());
        if (value.getFile_name() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFile_name());
        }
        if (value.getImage_name() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getImage_name());
        }
        if (value.getUri() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUri());
        }
        stmt.bindLong(6, value.getColor());
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM images WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE from images";
        return _query;
      }
    };
  }

  @Override
  public long insert(Image ImageData) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfImage.insertAndReturnId(ImageData);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
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
  public LiveData<List<Image>> getAll() {
    final String _sql = "SELECT * from images";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Image>>() {
      private Observer _observer;

      @Override
      protected List<Image> compute() {
        if (_observer == null) {
          _observer = new Observer("images") {
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
          final int _cursorIndexOfProjectId = _cursor.getColumnIndexOrThrow("project_id");
          final int _cursorIndexOfFileName = _cursor.getColumnIndexOrThrow("file_name");
          final int _cursorIndexOfImageName = _cursor.getColumnIndexOrThrow("image_name");
          final int _cursorIndexOfUri = _cursor.getColumnIndexOrThrow("uri");
          final int _cursorIndexOfColor = _cursor.getColumnIndexOrThrow("color");
          final List<Image> _result = new ArrayList<Image>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Image _item;
            _item = new Image();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final long _tmpProject_id;
            _tmpProject_id = _cursor.getLong(_cursorIndexOfProjectId);
            _item.setProject_id(_tmpProject_id);
            final String _tmpFile_name;
            _tmpFile_name = _cursor.getString(_cursorIndexOfFileName);
            _item.setFile_name(_tmpFile_name);
            final String _tmpImage_name;
            _tmpImage_name = _cursor.getString(_cursorIndexOfImageName);
            _item.setImage_name(_tmpImage_name);
            final String _tmpUri;
            _tmpUri = _cursor.getString(_cursorIndexOfUri);
            _item.setUri(_tmpUri);
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
  public LiveData<Image> getById(long id) {
    final String _sql = "SELECT * from images WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return new ComputableLiveData<Image>() {
      private Observer _observer;

      @Override
      protected Image compute() {
        if (_observer == null) {
          _observer = new Observer("images") {
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
          final int _cursorIndexOfProjectId = _cursor.getColumnIndexOrThrow("project_id");
          final int _cursorIndexOfFileName = _cursor.getColumnIndexOrThrow("file_name");
          final int _cursorIndexOfImageName = _cursor.getColumnIndexOrThrow("image_name");
          final int _cursorIndexOfUri = _cursor.getColumnIndexOrThrow("uri");
          final int _cursorIndexOfColor = _cursor.getColumnIndexOrThrow("color");
          final Image _result;
          if(_cursor.moveToFirst()) {
            _result = new Image();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _result.setId(_tmpId);
            final long _tmpProject_id;
            _tmpProject_id = _cursor.getLong(_cursorIndexOfProjectId);
            _result.setProject_id(_tmpProject_id);
            final String _tmpFile_name;
            _tmpFile_name = _cursor.getString(_cursorIndexOfFileName);
            _result.setFile_name(_tmpFile_name);
            final String _tmpImage_name;
            _tmpImage_name = _cursor.getString(_cursorIndexOfImageName);
            _result.setImage_name(_tmpImage_name);
            final String _tmpUri;
            _tmpUri = _cursor.getString(_cursorIndexOfUri);
            _result.setUri(_tmpUri);
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

  @Override
  public LiveData<List<Image>> getByProjectId(long id) {
    final String _sql = "SELECT * FROM images WHERE project_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return new ComputableLiveData<List<Image>>() {
      private Observer _observer;

      @Override
      protected List<Image> compute() {
        if (_observer == null) {
          _observer = new Observer("images") {
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
          final int _cursorIndexOfProjectId = _cursor.getColumnIndexOrThrow("project_id");
          final int _cursorIndexOfFileName = _cursor.getColumnIndexOrThrow("file_name");
          final int _cursorIndexOfImageName = _cursor.getColumnIndexOrThrow("image_name");
          final int _cursorIndexOfUri = _cursor.getColumnIndexOrThrow("uri");
          final int _cursorIndexOfColor = _cursor.getColumnIndexOrThrow("color");
          final List<Image> _result = new ArrayList<Image>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Image _item;
            _item = new Image();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final long _tmpProject_id;
            _tmpProject_id = _cursor.getLong(_cursorIndexOfProjectId);
            _item.setProject_id(_tmpProject_id);
            final String _tmpFile_name;
            _tmpFile_name = _cursor.getString(_cursorIndexOfFileName);
            _item.setFile_name(_tmpFile_name);
            final String _tmpImage_name;
            _tmpImage_name = _cursor.getString(_cursorIndexOfImageName);
            _item.setImage_name(_tmpImage_name);
            final String _tmpUri;
            _tmpUri = _cursor.getString(_cursorIndexOfUri);
            _item.setUri(_tmpUri);
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
}
