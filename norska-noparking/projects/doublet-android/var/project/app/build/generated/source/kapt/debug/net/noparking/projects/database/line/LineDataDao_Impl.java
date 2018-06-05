package net.noparking.projects.database.line;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
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

public class LineDataDao_Impl implements LineDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfLine;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfLine;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByPolygonId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByImageId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public LineDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLine = new EntityInsertionAdapter<Line>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `lines`(`id`,`polygon_id`,`image_id`,`from_x`,`from_y`,`to_x`,`to_y`,`color`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Line value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getPolygon_id());
        stmt.bindLong(3, value.getImage_id());
        stmt.bindDouble(4, value.getFrom_x());
        stmt.bindDouble(5, value.getFrom_y());
        stmt.bindDouble(6, value.getTo_x());
        stmt.bindDouble(7, value.getTo_y());
        stmt.bindLong(8, value.getColor());
      }
    };
    this.__updateAdapterOfLine = new EntityDeletionOrUpdateAdapter<Line>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `lines` SET `id` = ?,`polygon_id` = ?,`image_id` = ?,`from_x` = ?,`from_y` = ?,`to_x` = ?,`to_y` = ?,`color` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Line value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getPolygon_id());
        stmt.bindLong(3, value.getImage_id());
        stmt.bindDouble(4, value.getFrom_x());
        stmt.bindDouble(5, value.getFrom_y());
        stmt.bindDouble(6, value.getTo_x());
        stmt.bindDouble(7, value.getTo_y());
        stmt.bindLong(8, value.getColor());
        if (value.getId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM lines WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByPolygonId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM lines WHERE polygon_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByImageId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM lines WHERE image_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE from lines";
        return _query;
      }
    };
  }

  @Override
  public long insert(Line LineData) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfLine.insertAndReturnId(LineData);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(Line LineData) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfLine.handle(LineData);
      __db.setTransactionSuccessful();
      return _total;
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
  public LiveData<List<Line>> getAll() {
    final String _sql = "SELECT * from lines";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Line>>() {
      private Observer _observer;

      @Override
      protected List<Line> compute() {
        if (_observer == null) {
          _observer = new Observer("lines") {
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
          final int _cursorIndexOfFromX = _cursor.getColumnIndexOrThrow("from_x");
          final int _cursorIndexOfFromY = _cursor.getColumnIndexOrThrow("from_y");
          final int _cursorIndexOfToX = _cursor.getColumnIndexOrThrow("to_x");
          final int _cursorIndexOfToY = _cursor.getColumnIndexOrThrow("to_y");
          final int _cursorIndexOfColor = _cursor.getColumnIndexOrThrow("color");
          final List<Line> _result = new ArrayList<Line>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Line _item;
            _item = new Line();
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
            final float _tmpFrom_x;
            _tmpFrom_x = _cursor.getFloat(_cursorIndexOfFromX);
            _item.setFrom_x(_tmpFrom_x);
            final float _tmpFrom_y;
            _tmpFrom_y = _cursor.getFloat(_cursorIndexOfFromY);
            _item.setFrom_y(_tmpFrom_y);
            final float _tmpTo_x;
            _tmpTo_x = _cursor.getFloat(_cursorIndexOfToX);
            _item.setTo_x(_tmpTo_x);
            final float _tmpTo_y;
            _tmpTo_y = _cursor.getFloat(_cursorIndexOfToY);
            _item.setTo_y(_tmpTo_y);
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
  public LiveData<Line> getById(long id) {
    final String _sql = "SELECT * from lines WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return new ComputableLiveData<Line>() {
      private Observer _observer;

      @Override
      protected Line compute() {
        if (_observer == null) {
          _observer = new Observer("lines") {
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
          final int _cursorIndexOfFromX = _cursor.getColumnIndexOrThrow("from_x");
          final int _cursorIndexOfFromY = _cursor.getColumnIndexOrThrow("from_y");
          final int _cursorIndexOfToX = _cursor.getColumnIndexOrThrow("to_x");
          final int _cursorIndexOfToY = _cursor.getColumnIndexOrThrow("to_y");
          final int _cursorIndexOfColor = _cursor.getColumnIndexOrThrow("color");
          final Line _result;
          if(_cursor.moveToFirst()) {
            _result = new Line();
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
            final float _tmpFrom_x;
            _tmpFrom_x = _cursor.getFloat(_cursorIndexOfFromX);
            _result.setFrom_x(_tmpFrom_x);
            final float _tmpFrom_y;
            _tmpFrom_y = _cursor.getFloat(_cursorIndexOfFromY);
            _result.setFrom_y(_tmpFrom_y);
            final float _tmpTo_x;
            _tmpTo_x = _cursor.getFloat(_cursorIndexOfToX);
            _result.setTo_x(_tmpTo_x);
            final float _tmpTo_y;
            _tmpTo_y = _cursor.getFloat(_cursorIndexOfToY);
            _result.setTo_y(_tmpTo_y);
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
  public LiveData<List<Line>> getByPolygonId(long id) {
    final String _sql = "SELECT * FROM lines WHERE polygon_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return new ComputableLiveData<List<Line>>() {
      private Observer _observer;

      @Override
      protected List<Line> compute() {
        if (_observer == null) {
          _observer = new Observer("lines") {
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
          final int _cursorIndexOfFromX = _cursor.getColumnIndexOrThrow("from_x");
          final int _cursorIndexOfFromY = _cursor.getColumnIndexOrThrow("from_y");
          final int _cursorIndexOfToX = _cursor.getColumnIndexOrThrow("to_x");
          final int _cursorIndexOfToY = _cursor.getColumnIndexOrThrow("to_y");
          final int _cursorIndexOfColor = _cursor.getColumnIndexOrThrow("color");
          final List<Line> _result = new ArrayList<Line>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Line _item;
            _item = new Line();
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
            final float _tmpFrom_x;
            _tmpFrom_x = _cursor.getFloat(_cursorIndexOfFromX);
            _item.setFrom_x(_tmpFrom_x);
            final float _tmpFrom_y;
            _tmpFrom_y = _cursor.getFloat(_cursorIndexOfFromY);
            _item.setFrom_y(_tmpFrom_y);
            final float _tmpTo_x;
            _tmpTo_x = _cursor.getFloat(_cursorIndexOfToX);
            _item.setTo_x(_tmpTo_x);
            final float _tmpTo_y;
            _tmpTo_y = _cursor.getFloat(_cursorIndexOfToY);
            _item.setTo_y(_tmpTo_y);
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
  public LiveData<List<Line>> getByImageId(long id) {
    final String _sql = "SELECT * FROM lines WHERE image_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return new ComputableLiveData<List<Line>>() {
      private Observer _observer;

      @Override
      protected List<Line> compute() {
        if (_observer == null) {
          _observer = new Observer("lines") {
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
          final int _cursorIndexOfFromX = _cursor.getColumnIndexOrThrow("from_x");
          final int _cursorIndexOfFromY = _cursor.getColumnIndexOrThrow("from_y");
          final int _cursorIndexOfToX = _cursor.getColumnIndexOrThrow("to_x");
          final int _cursorIndexOfToY = _cursor.getColumnIndexOrThrow("to_y");
          final int _cursorIndexOfColor = _cursor.getColumnIndexOrThrow("color");
          final List<Line> _result = new ArrayList<Line>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Line _item;
            _item = new Line();
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
            final float _tmpFrom_x;
            _tmpFrom_x = _cursor.getFloat(_cursorIndexOfFromX);
            _item.setFrom_x(_tmpFrom_x);
            final float _tmpFrom_y;
            _tmpFrom_y = _cursor.getFloat(_cursorIndexOfFromY);
            _item.setFrom_y(_tmpFrom_y);
            final float _tmpTo_x;
            _tmpTo_x = _cursor.getFloat(_cursorIndexOfToX);
            _item.setTo_x(_tmpTo_x);
            final float _tmpTo_y;
            _tmpTo_y = _cursor.getFloat(_cursorIndexOfToY);
            _item.setTo_y(_tmpTo_y);
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
