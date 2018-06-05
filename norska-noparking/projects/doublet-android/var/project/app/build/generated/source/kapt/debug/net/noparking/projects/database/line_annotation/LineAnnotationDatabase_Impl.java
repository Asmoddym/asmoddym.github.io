package net.noparking.projects.database.line_annotation;

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

public class LineAnnotationDatabase_Impl extends LineAnnotationDatabase {
  private volatile LineAnnotationDataDao _lineAnnotationDataDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `line_annotations` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `line_id` INTEGER NOT NULL, `image_id` INTEGER NOT NULL, `length` REAL, `comment` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"f422d5e646b9043fc95623bf09f745fb\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `line_annotations`");
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
        final HashMap<String, TableInfo.Column> _columnsLineAnnotations = new HashMap<String, TableInfo.Column>(5);
        _columnsLineAnnotations.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsLineAnnotations.put("line_id", new TableInfo.Column("line_id", "INTEGER", true, 0));
        _columnsLineAnnotations.put("image_id", new TableInfo.Column("image_id", "INTEGER", true, 0));
        _columnsLineAnnotations.put("length", new TableInfo.Column("length", "REAL", false, 0));
        _columnsLineAnnotations.put("comment", new TableInfo.Column("comment", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLineAnnotations = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLineAnnotations = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLineAnnotations = new TableInfo("line_annotations", _columnsLineAnnotations, _foreignKeysLineAnnotations, _indicesLineAnnotations);
        final TableInfo _existingLineAnnotations = TableInfo.read(_db, "line_annotations");
        if (! _infoLineAnnotations.equals(_existingLineAnnotations)) {
          throw new IllegalStateException("Migration didn't properly handle line_annotations(net.noparking.projects.database.line_annotation.LineAnnotation).\n"
                  + " Expected:\n" + _infoLineAnnotations + "\n"
                  + " Found:\n" + _existingLineAnnotations);
        }
      }
    }, "f422d5e646b9043fc95623bf09f745fb");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "line_annotations");
  }

  @Override
  public LineAnnotationDataDao LineAnnotationDataDao() {
    if (_lineAnnotationDataDao != null) {
      return _lineAnnotationDataDao;
    } else {
      synchronized(this) {
        if(_lineAnnotationDataDao == null) {
          _lineAnnotationDataDao = new LineAnnotationDataDao_Impl(this);
        }
        return _lineAnnotationDataDao;
      }
    }
  }
}
