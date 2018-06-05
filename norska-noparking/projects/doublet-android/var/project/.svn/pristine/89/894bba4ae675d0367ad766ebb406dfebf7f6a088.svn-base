package net.noparking.projects.utl

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.content.FileProvider
import java.io.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

class ZipFile(internal val context: Context, internal val root: Directory, internal val file_name: String? = null) {
	private val _path: File
	var uri: Uri = Uri.EMPTY
	private var _out: ZipOutputStream
	var name = ""

	init {
		name = when (file_name == null) {
			true -> generateName()
			else -> file_name!!
		}
		_path = File(root.getPath(), name)
		if (_path.exists()) {
			_path.delete()
		}
		_out = ZipOutputStream(BufferedOutputStream(FileOutputStream(_path)))
		setPermissions()
	}

	private fun generateName(): String {
		return "ZIP_" + SimpleDateFormat("ddMMyyyy_HHmmss").format(Date()) + ".zip"
	}

	private fun setPermissions() {
		uri = FileProvider.getUriForFile(context, context.packageName + ".fileprovider", _path)
		context.grantUriPermission(context.packageName, uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION)
	}

	fun addContent(file: File, entry_name: String) {
		val fi = FileInputStream(file)
		val origin = BufferedInputStream(fi)
		val entry = ZipEntry(entry_name)
		_out.putNextEntry(entry)
		origin.copyTo(_out, 8192)
		origin.close()
	}

	fun close() {
		_out.close()
	}
}