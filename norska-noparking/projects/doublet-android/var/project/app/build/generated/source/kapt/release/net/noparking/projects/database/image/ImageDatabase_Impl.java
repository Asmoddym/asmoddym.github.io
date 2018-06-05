package net.noparking.projects.database.image;

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

public class ImageDatabase_Impl extends ImageDatabase {
  private volatile ImageDataDao _imageDataDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(6) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `images` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `project_id` INTEGER NOT NULL, `file_name` TEXT NOT NULL, `image_name` TEXT NOT NULL, `uri` TEXT NOT NULL, `color` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"026657b192aaf3f1efcfb824c74ca6f8\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `images`");
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
        final HashMap<String, TableInfo.Column> _columnsImages = new HashMap<String, TableInfo.Column>(6);
        _columnsImages.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsImages.put("project_id", new TableInfo.Column("project_id", "INTEGER", true, 0));
        _columnsImages.put("file_name", new TableInfo.Column("file_name", "TEXT", true, 0));
        _columnsImages.put("image_name", new TableInfo.Column("image_name", "TEXT", true, 0));
        _columnsImages.put("uri", new TableInfo.Column("uri", "TEXT", true, 0));
        _columnsImages.put("color", new TableInfo.Column("color", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysImages = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesImages = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoImages = new TableInfo("images", _columnsImages, _foreignKeysImages, _indicesImages);
        final TableInfo _existingImages = TableInfo.read(_db, "images");
        if (! _infoImages.equals(_existingImages)) {
          throw new IllegalStateException("Migration didn't properly handle images(net.noparking.projects.database.image.Image).\n"
                  + " Expected:\n" + _infoImages + "\n"
                  + " Found:\n" + _existingImages);
        }
      }
    }, "026657b192aaf3f1efcfb824c74ca6f8");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "images");
  }

  @Override
  public ImageDataDao ImageDataDao() {
    if (_imageDataDao != null) {
      return _imageDataDao;
    } else {
      synchronized(this) {
        if(_imageDataDao == null) {
          _imageDataDao = new ImageDataDao_Impl(this);
        }
        return _imageDataDao;
      }
    }
  }
}
