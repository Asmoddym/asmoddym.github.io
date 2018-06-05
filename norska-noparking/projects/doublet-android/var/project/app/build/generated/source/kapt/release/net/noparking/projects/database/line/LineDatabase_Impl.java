package net.noparking.projects.database.line;

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

public class LineDatabase_Impl extends LineDatabase {
  private volatile LineDataDao _lineDataDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(4) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `lines` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `polygon_id` INTEGER NOT NULL, `from_x` REAL NOT NULL, `from_y` REAL NOT NULL, `to_x` REAL NOT NULL, `to_y` REAL NOT NULL, `color` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"443781fbbe4944f1736bf90c4ca08a42\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `lines`");
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
        final HashMap<String, TableInfo.Column> _columnsLines = new HashMap<String, TableInfo.Column>(7);
        _columnsLines.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsLines.put("polygon_id", new TableInfo.Column("polygon_id", "INTEGER", true, 0));
        _columnsLines.put("from_x", new TableInfo.Column("from_x", "REAL", true, 0));
        _columnsLines.put("from_y", new TableInfo.Column("from_y", "REAL", true, 0));
        _columnsLines.put("to_x", new TableInfo.Column("to_x", "REAL", true, 0));
        _columnsLines.put("to_y", new TableInfo.Column("to_y", "REAL", true, 0));
        _columnsLines.put("color", new TableInfo.Column("color", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLines = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLines = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLines = new TableInfo("lines", _columnsLines, _foreignKeysLines, _indicesLines);
        final TableInfo _existingLines = TableInfo.read(_db, "lines");
        if (! _infoLines.equals(_existingLines)) {
          throw new IllegalStateException("Migration didn't properly handle lines(net.noparking.projects.database.line.Line).\n"
                  + " Expected:\n" + _infoLines + "\n"
                  + " Found:\n" + _existingLines);
        }
      }
    }, "443781fbbe4944f1736bf90c4ca08a42");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "lines");
  }

  @Override
  public LineDataDao LineDataDao() {
    if (_lineDataDao != null) {
      return _lineDataDao;
    } else {
      synchronized(this) {
        if(_lineDataDao == null) {
          _lineDataDao = new LineDataDao_Impl(this);
        }
        return _lineDataDao;
      }
    }
  }
}
