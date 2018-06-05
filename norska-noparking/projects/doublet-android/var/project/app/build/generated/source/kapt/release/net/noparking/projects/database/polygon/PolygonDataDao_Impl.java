package net.noparking.projects.database.polygon;

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

public class PolygonDataDao_Impl implements PolygonDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfPolygon;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfPolygon;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByImageId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public PolygonDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPolygon = new EntityInsertionAdapter<Polygon>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `polygons`(`id`,`image_id`,`closed`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Polygon value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getImage_id());
        final int _tmp;
        _tmp = value.getClosed() ? 1 : 0;
        stmt.bindLong(3, _tmp);
      }
    };
    this.__updateAdapterOfPolygon = new EntityDeletionOrUpdateAdapter<Polygon>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `polygons` SET `id` = ?,`image_id` = ?,`closed` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Polygon value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getImage_id());
        final int _tmp;
        _tmp = value.getClosed() ? 1 : 0;
        stmt.bindLong(3, _tmp);
        if (value.getId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteByImageId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM polygons WHERE image_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE from polygons";
        return _query;
      }
    };
  }

  @Override
  public long insert(Polygon PolygonData) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfPolygon.insertAndReturnId(PolygonData);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(Polygon PolygonData) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfPolygon.handle(PolygonData);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
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
  public LiveData<List<Polygon>> getAll() {
    final String _sql = "SELECT * from polygons";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Polygon>>() {
      private Observer _observer;

      @Override
      protected List<Polygon> compute() {
        if (_observer == null) {
          _observer = new Observer("polygons") {
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
          final int _cursorIndexOfImageId = _cursor.getColumnIndexOrThrow("image_id");
          final int _cursorIndexOfClosed = _cursor.getColumnIndexOrThrow("closed");
          final List<Polygon> _result = new ArrayList<Polygon>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Polygon _item;
            _item = new Polygon();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final long _tmpImage_id;
            _tmpImage_id = _cursor.getLong(_cursorIndexOfImageId);
            _item.setImage_id(_tmpImage_id);
            final boolean _tmpClosed;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfClosed);
            _tmpClosed = _tmp != 0;
            _item.setClosed(_tmpClosed);
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
  public LiveData<Polygon> getById(long id) {
    final String _sql = "SELECT * from polygons WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return new ComputableLiveData<Polygon>() {
      private Observer _observer;

      @Override
      protected Polygon compute() {
        if (_observer == null) {
          _observer = new Observer("polygons") {
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
          final int _cursorIndexOfImageId = _cursor.getColumnIndexOrThrow("image_id");
          final int _cursorIndexOfClosed = _cursor.getColumnIndexOrThrow("closed");
          final Polygon _result;
          if(_cursor.moveToFirst()) {
            _result = new Polygon();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _result.setId(_tmpId);
            final long _tmpImage_id;
            _tmpImage_id = _cursor.getLong(_cursorIndexOfImageId);
            _result.setImage_id(_tmpImage_id);
            final boolean _tmpClosed;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfClosed);
            _tmpClosed = _tmp != 0;
            _result.setClosed(_tmpClosed);
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
  public LiveData<List<Polygon>> getByImageId(long id) {
    final String _sql = "SELECT * FROM polygons WHERE image_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return new ComputableLiveData<List<Polygon>>() {
      private Observer _observer;

      @Override
      protected List<Polygon> compute() {
        if (_observer == null) {
          _observer = new Observer("polygons") {
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
          final int _cursorIndexOfImageId = _cursor.getColumnIndexOrThrow("image_id");
          final int _cursorIndexOfClosed = _cursor.getColumnIndexOrThrow("closed");
          final List<Polygon> _result = new ArrayList<Polygon>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Polygon _item;
            _item = new Polygon();
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final long _tmpImage_id;
            _tmpImage_id = _cursor.getLong(_cursorIndexOfImageId);
            _item.setImage_id(_tmpImage_id);
            final boolean _tmpClosed;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfClosed);
            _tmpClosed = _tmp != 0;
            _item.setClosed(_tmpClosed);
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
