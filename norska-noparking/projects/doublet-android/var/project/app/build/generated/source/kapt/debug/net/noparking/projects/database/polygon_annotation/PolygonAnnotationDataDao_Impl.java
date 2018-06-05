package net.noparking.projects.database.polygon_annotation;

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

public class PolygonAnnotationDataDao_Impl implements PolygonAnnotationDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfPolygonAnnotation;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByPolygonId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByImageId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public PolygonAnnotationDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPolygonAnnotation = new EntityInsertionAdapter<PolygonAnnotation>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `polygon_annotations`(`id`,`polygon_id`,`image_id`,`width`,`height`,`surface`,`comment`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PolygonAnnotation value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getPolygon_id());
        stmt.bindLong(3, value.getImage_id());
        if (value.getWidth() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getWidth());
        }
        if (value.getHeight() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getHeight());
        }
        stmt.bindDouble(6, value.getSurface());
        if (value.getComment() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getComment());
        }
      }
    };
    this.__preparedStmtOfDeleteByPolygonId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM polygon_annotations WHERE polygon_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByImageId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM polygon_annotations WHERE image_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE from polygon_annotations";
        return _query;
      }
    };
  }

  @Override
  public long insert(PolygonAnnotation AnnotationData) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfPolygonAnnotation.insertAndReturnId(AnnotationData);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteByPolygonId(long id) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByPolygonId.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, id);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteByPolygonId.release(_stmt);
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
  public LiveData<List<PolygonAnnotation>> getAll() {
    final String _sql = "SELECT * from polygon_annotations";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<PolygonAnnotation>>() {
      private Observer _observer;

      @Override
      protected List<PolygonAnnotation> compute() {
        if (_observer == null) {
          _observer = new Observer("polygon_annotations") {
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
          final int _cursorIndexOfPolygonId = _cursor.getColumnIndexOrThrow("polygon_id");
          final int _cursorIndexOfImageId = _cursor.getColumnIndexOrThrow("image_id");
          final int _cursorIndexOfWidth = _cursor.getColumnIndexOrThrow("width");
          final int _cursorIndexOfHeight = _cursor.getColumnIndexOrThrow("height");
          final int _cursorIndexOfSurface = _cursor.getColumnIndexOrThrow("surface");
          final int _cursorIndexOfComment = _cursor.getColumnIndexOrThrow("comment");
          final List<PolygonAnnotation> _result = new ArrayList<PolygonAnnotation>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PolygonAnnotation _item;
            _item = new PolygonAnnotation();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final long _tmpPolygon_id;
            _tmpPolygon_id = _cursor.getLong(_cursorIndexOfPolygonId);
            _item.setPolygon_id(_tmpPolygon_id);
            final long _tmpImage_id;
            _tmpImage_id = _cursor.getLong(_cursorIndexOfImageId);
            _item.setImage_id(_tmpImage_id);
            final Float _tmpWidth;
            if (_cursor.isNull(_cursorIndexOfWidth)) {
              _tmpWidth = null;
            } else {
              _tmpWidth = _cursor.getFloat(_cursorIndexOfWidth);
            }
            _item.setWidth(_tmpWidth);
            final Float _tmpHeight;
            if (_cursor.isNull(_cursorIndexOfHeight)) {
              _tmpHeight = null;
            } else {
              _tmpHeight = _cursor.getFloat(_cursorIndexOfHeight);
            }
            _item.setHeight(_tmpHeight);
            final float _tmpSurface;
            _tmpSurface = _cursor.getFloat(_cursorIndexOfSurface);
            _item.setSurface(_tmpSurface);
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
  public LiveData<PolygonAnnotation> getById(long id) {
    final String _sql = "SELECT * from polygon_annotations WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return new ComputableLiveData<PolygonAnnotation>() {
      private Observer _observer;

      @Override
      protected PolygonAnnotation compute() {
        if (_observer == null) {
          _observer = new Observer("polygon_annotations") {
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
          final int _cursorIndexOfPolygonId = _cursor.getColumnIndexOrThrow("polygon_id");
          final int _cursorIndexOfImageId = _cursor.getColumnIndexOrThrow("image_id");
          final int _cursorIndexOfWidth = _cursor.getColumnIndexOrThrow("width");
          final int _cursorIndexOfHeight = _cursor.getColumnIndexOrThrow("height");
          final int _cursorIndexOfSurface = _cursor.getColumnIndexOrThrow("surface");
          final int _cursorIndexOfComment = _cursor.getColumnIndexOrThrow("comment");
          final PolygonAnnotation _result;
          if(_cursor.moveToFirst()) {
            _result = new PolygonAnnotation();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _result.setId(_tmpId);
            final long _tmpPolygon_id;
            _tmpPolygon_id = _cursor.getLong(_cursorIndexOfPolygonId);
            _result.setPolygon_id(_tmpPolygon_id);
            final long _tmpImage_id;
            _tmpImage_id = _cursor.getLong(_cursorIndexOfImageId);
            _result.setImage_id(_tmpImage_id);
            final Float _tmpWidth;
            if (_cursor.isNull(_cursorIndexOfWidth)) {
              _tmpWidth = null;
            } else {
              _tmpWidth = _cursor.getFloat(_cursorIndexOfWidth);
            }
            _result.setWidth(_tmpWidth);
            final Float _tmpHeight;
            if (_cursor.isNull(_cursorIndexOfHeight)) {
              _tmpHeight = null;
            } else {
              _tmpHeight = _cursor.getFloat(_cursorIndexOfHeight);
            }
            _result.setHeight(_tmpHeight);
            final float _tmpSurface;
            _tmpSurface = _cursor.getFloat(_cursorIndexOfSurface);
            _result.setSurface(_tmpSurface);
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
  public LiveData<PolygonAnnotation> getByPolygonId(long id) {
    final String _sql = "SELECT * FROM polygon_annotations WHERE polygon_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return new ComputableLiveData<PolygonAnnotation>() {
      private Observer _observer;

      @Override
      protected PolygonAnnotation compute() {
        if (_observer == null) {
          _observer = new Observer("polygon_annotations") {
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
          final int _cursorIndexOfPolygonId = _cursor.getColumnIndexOrThrow("polygon_id");
          final int _cursorIndexOfImageId = _cursor.getColumnIndexOrThrow("image_id");
          final int _cursorIndexOfWidth = _cursor.getColumnIndexOrThrow("width");
          final int _cursorIndexOfHeight = _cursor.getColumnIndexOrThrow("height");
          final int _cursorIndexOfSurface = _cursor.getColumnIndexOrThrow("surface");
          final int _cursorIndexOfComment = _cursor.getColumnIndexOrThrow("comment");
          final PolygonAnnotation _result;
          if(_cursor.moveToFirst()) {
            _result = new PolygonAnnotation();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _result.setId(_tmpId);
            final long _tmpPolygon_id;
            _tmpPolygon_id = _cursor.getLong(_cursorIndexOfPolygonId);
            _result.setPolygon_id(_tmpPolygon_id);
            final long _tmpImage_id;
            _tmpImage_id = _cursor.getLong(_cursorIndexOfImageId);
            _result.setImage_id(_tmpImage_id);
            final Float _tmpWidth;
            if (_cursor.isNull(_cursorIndexOfWidth)) {
              _tmpWidth = null;
            } else {
              _tmpWidth = _cursor.getFloat(_cursorIndexOfWidth);
            }
            _result.setWidth(_tmpWidth);
            final Float _tmpHeight;
            if (_cursor.isNull(_cursorIndexOfHeight)) {
              _tmpHeight = null;
            } else {
              _tmpHeight = _cursor.getFloat(_cursorIndexOfHeight);
            }
            _result.setHeight(_tmpHeight);
            final float _tmpSurface;
            _tmpSurface = _cursor.getFloat(_cursorIndexOfSurface);
            _result.setSurface(_tmpSurface);
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
