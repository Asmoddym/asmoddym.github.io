package net.noparking.projects.database.polygon_annotation;

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

public class PolygonAnnotationDatabase_Impl extends PolygonAnnotationDatabase {
  private volatile PolygonAnnotationDataDao _polygonAnnotationDataDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(7) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `polygon_annotations` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `polygon_id` INTEGER NOT NULL, `image_id` INTEGER NOT NULL, `width` REAL, `height` REAL, `surface` REAL NOT NULL, `comment` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"f949ee80cbd34eadddf8f0b564e1b992\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `polygon_annotations`");
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
        final HashMap<String, TableInfo.Column> _columnsPolygonAnnotations = new HashMap<String, TableInfo.Column>(7);
        _columnsPolygonAnnotations.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsPolygonAnnotations.put("polygon_id", new TableInfo.Column("polygon_id", "INTEGER", true, 0));
        _columnsPolygonAnnotations.put("image_id", new TableInfo.Column("image_id", "INTEGER", true, 0));
        _columnsPolygonAnnotations.put("width", new TableInfo.Column("width", "REAL", false, 0));
        _columnsPolygonAnnotations.put("height", new TableInfo.Column("height", "REAL", false, 0));
        _columnsPolygonAnnotations.put("surface", new TableInfo.Column("surface", "REAL", true, 0));
        _columnsPolygonAnnotations.put("comment", new TableInfo.Column("comment", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPolygonAnnotations = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPolygonAnnotations = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPolygonAnnotations = new TableInfo("polygon_annotations", _columnsPolygonAnnotations, _foreignKeysPolygonAnnotations, _indicesPolygonAnnotations);
        final TableInfo _existingPolygonAnnotations = TableInfo.read(_db, "polygon_annotations");
        if (! _infoPolygonAnnotations.equals(_existingPolygonAnnotations)) {
          throw new IllegalStateException("Migration didn't properly handle polygon_annotations(net.noparking.projects.database.polygon_annotation.PolygonAnnotation).\n"
                  + " Expected:\n" + _infoPolygonAnnotations + "\n"
                  + " Found:\n" + _existingPolygonAnnotations);
        }
      }
    }, "f949ee80cbd34eadddf8f0b564e1b992");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "polygon_annotations");
  }

  @Override
  public PolygonAnnotationDataDao PolygonAnnotationDataDao() {
    if (_polygonAnnotationDataDao != null) {
      return _polygonAnnotationDataDao;
    } else {
      synchronized(this) {
        if(_polygonAnnotationDataDao == null) {
          _polygonAnnotationDataDao = new PolygonAnnotationDataDao_Impl(this);
        }
        return _polygonAnnotationDataDao;
      }
    }
  }
}
