package net.noparking.projects.database.polygon;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;

public class PolygonDatabase_Impl extends PolygonDatabase {
  private volatile PolygonDataDao _polygonDataDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(4) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `polygons` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `image_id` INTEGER NOT NULL, `closed` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"828c71bc0596f6c83cfed1c223c0c2ac\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `polygons`");
      }

      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsPolygons = new HashMap<String, TableInfo.Column>(3);
        _columnsPolygons.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsPolygons.put("image_id", new TableInfo.Column("image_id", "INTEGER", true, 0));
        _columnsPolygons.put("closed", new TableInfo.Column("closed", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPolygons = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPolygons = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPolygons = new TableInfo("polygons", _columnsPolygons, _foreignKeysPolygons, _indicesPolygons);
        final TableInfo _existingPolygons = TableInfo.read(_db, "polygons");
        if (! _infoPolygons.equals(_existingPolygons)) {
          throw new IllegalStateException("Migration didn't properly handle polygons(net.noparking.projects.database.polygon.Polygon).\n"
                  + " Expected:\n" + _infoPolygons + "\n"
                  + " Found:\n" + _existingPolygons);
        }
      }
    }, "828c71bc0596f6c83cfed1c223c0c2ac");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "polygons");
  }

  @Override
  public PolygonDataDao PolygonDataDao() {
    if (_polygonDataDao != null) {
      return _polygonDataDao;
    } else {
      synchronized(this) {
        if(_polygonDataDao == null) {
          _polygonDataDao = new PolygonDataDao_Impl(this);
        }
        return _polygonDataDao;
      }
    }
  }
}
