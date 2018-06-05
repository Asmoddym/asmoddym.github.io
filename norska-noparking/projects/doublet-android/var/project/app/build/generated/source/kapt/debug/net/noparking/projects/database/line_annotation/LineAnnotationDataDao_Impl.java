package net.noparking.projects.database.line_annotation;

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
import java.lang.Float;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LineAnnotationDataDao_Impl implements LineAnnotationDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfLineAnnotation;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByImageId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public LineAnnotationDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLineAnnotation = new EntityInsertionAdapter<LineAnnotation>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `line_annotations`(`id`,`line_id`,`image_id`,`length`,`comment`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LineAnnotation value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getLine_id());
        stmt.bindLong(3, value.getImage_id());
        if (value.getLength() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getLength());
        }
        if (value.getComment() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getComment());
        }
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM line_annotations WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByImageId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM line_annotations WHERE image_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE from line_annotations";
        return _query;
      }
    };
  }

  @Override
  public long insert(LineAnnotation AnnotationData) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfLineAnnotation.insertAndReturnId(AnnotationData);
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
  public void deleteByImageId(long id) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByImageId.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, id);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteByImageId.release(_stmt);
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
  public LiveData<List<LineAnnotation>> getAll() {
    final String _sql = "SELECT * from line_annotations";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<LineAnnotation>>() {
      private Observer _observer;

      @Override
      protected List<LineAnnotation> compute() {
        if (_observer == null) {
          _observer = new Observer("line_annotations") {
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
          final int _cursorIndexOfLineId = _cursor.getColumnIndexOrThrow("line_id");
          final int _cursorIndexOfImageId = _cursor.getColumnIndexOrThrow("image_id");
          final int _cursorIndexOfLength = _cursor.getColumnIndexOrThrow("length");
          final int _cursorIndexOfComment = _cursor.getColumnIndexOrThrow("comment");
          final List<LineAnnotation> _result = new ArrayList<LineAnnotation>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final LineAnnotation _item;
            _item = new LineAnnotation();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final long _tmpLine_id;
            _tmpLine_id = _cursor.getLong(_cursorIndexOfLineId);
            _item.setLine_id(_tmpLine_id);
            final long _tmpImage_id;
            _tmpImage_id = _cursor.getLong(_cursorIndexOfImageId);
            _item.setImage_id(_tmpImage_id);
            final Float _tmpLength;
            if (_cursor.isNull(_cursorIndexOfLength)) {
              _tmpLength = null;
            } else {
              _tmpLength = _cursor.getFloat(_cursorIndexOfLength);
            }
            _item.setLength(_tmpLength);
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            _item.setComment(_tmpComment);
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
  public LiveData<LineAnnotation> getById(long id) {
    final String _sql = "SELECT * FROM line_annotations WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return new ComputableLiveData<LineAnnotation>() {
      private Observer _observer;

      @Override
      protected LineAnnotation compute() {
        if (_observer == null) {
          _observer = new Observer("line_annotations") {
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
          final int _cursorIndexOfLineId = _cursor.getColumnIndexOrThrow("line_id");
          final int _cursorIndexOfImageId = _cursor.getColumnIndexOrThrow("image_id");
          final int _cursorIndexOfLength = _cursor.getColumnIndexOrThrow("length");
          final int _cursorIndexOfComment = _cursor.getColumnIndexOrThrow("comment");
          final LineAnnotation _result;
          if(_cursor.moveToFirst()) {
            _result = new LineAnnotation();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _result.setId(_tmpId);
            final long _tmpLine_id;
            _tmpLine_id = _cursor.getLong(_cursorIndexOfLineId);
            _result.setLine_id(_tmpLine_id);
            final long _tmpImage_id;
            _tmpImage_id = _cursor.getLong(_cursorIndexOfImageId);
            _result.setImage_id(_tmpImage_id);
            final Float _tmpLength;
            if (_cursor.isNull(_cursorIndexOfLength)) {
              _tmpLength = null;
            } else {
              _tmpLength = _cursor.getFloat(_cursorIndexOfLength);
            }
            _result.setLength(_tmpLength);
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            _result.setComment(_tmpComment);
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
  public LiveData<List<LineAnnotation>> getByImageId(long id) {
    final String _sql = "SELECT * FROM line_annotations WHERE image_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return new ComputableLiveData<List<LineAnnotation>>() {
      private Observer _observer;

      @Override
      protected List<LineAnnotation> compute() {
        if (_observer == null) {
          _observer = new Observer("line_annotations") {
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
          final int _cursorIndexOfLineId = _cursor.getColumnIndexOrThrow("line_id");
          final int _cursorIndexOfImageId = _cursor.getColumnIndexOrThrow("image_id");
          final int _cursorIndexOfLength = _cursor.getColumnIndexOrThrow("length");
          final int _cursorIndexOfComment = _cursor.getColumnIndexOrThrow("comment");
          final List<LineAnnotation> _result = new ArrayList<LineAnnotation>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final LineAnnotation _item;
            _item = new LineAnnotation();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final long _tmpLine_id;
            _tmpLine_id = _cursor.getLong(_cursorIndexOfLineId);
            _item.setLine_id(_tmpLine_id);
            final long _tmpImage_id;
            _tmpImage_id = _cursor.getLong(_cursorIndexOfImageId);
            _item.setImage_id(_tmpImage_id);
            final Float _tmpLength;
            if (_cursor.isNull(_cursorIndexOfLength)) {
              _tmpLength = null;
            } else {
              _tmpLength = _cursor.getFloat(_cursorIndexOfLength);
            }
            _item.setLength(_tmpLength);
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            _item.setComment(_tmpComment);
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
  public LiveData<LineAnnotation> getByLineId(long id) {
    final String _sql = "SELECT * FROM line_annotations WHERE line_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return new ComputableLiveData<LineAnnotation>() {
      private Observer _observer;

      @Override
      protected LineAnnotation compute() {
        if (_observer == null) {
          _observer = new Observer("line_annotations") {
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
          final int _cursorIndexOfLineId = _cursor.getColumnIndexOrThrow("line_id");
          final int _cursorIndexOfImageId = _cursor.getColumnIndexOrThrow("image_id");
          final int _cursorIndexOfLength = _cursor.getColumnIndexOrThrow("length");
          final int _cursorIndexOfComment = _cursor.getColumnIndexOrThrow("comment");
          final LineAnnotation _result;
          if(_cursor.moveToFirst()) {
            _result = new LineAnnotation();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _result.setId(_tmpId);
            final long _tmpLine_id;
            _tmpLine_id = _cursor.getLong(_cursorIndexOfLineId);
            _result.setLine_id(_tmpLine_id);
            final long _tmpImage_id;
            _tmpImage_id = _cursor.getLong(_cursorIndexOfImageId);
            _result.setImage_id(_tmpImage_id);
            final Float _tmpLength;
            if (_cursor.isNull(_cursorIndexOfLength)) {
              _tmpLength = null;
            } else {
              _tmpLength = _cursor.getFloat(_cursorIndexOfLength);
            }
            _result.setLength(_tmpLength);
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            _result.setComment(_tmpComment);
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
