package net.noparking.projects.utl


import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.util.Log
import android.widget.Toast
import net.noparking.projects.R
import java.io.File
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

class Image(internal val context: Context, internal val directory: Directory? = null, internal val contentResolver: ContentResolver? = null): Serializable {
	var file_name: String = ""
	var uri: Uri = Uri.EMPTY
	lateinit var file: File
	private var _angle = 0f
	var dimensions = Dimensions()

	fun create(name: String? = null) {
		file_name = generateName(name)
		file = File(directory?.getPath(), file_name)

		generatePermissions()
	}

	fun removeIfExisting() {
		if (file.exists()) {
			file.delete()
		}
	}

	private fun generateName(name: String?): String {
		return when (name == null) {
			true -> "IMG_" + SimpleDateFormat("ddMMyyyy_HHmmss").format(Date()) + ".jpg"
			else -> name!!
		}
	}

	private fun generatePermissions() {
		uri = generateUriFromFile(file)
		context.grantUriPermission(context.packageName, uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION)
	}

	private fun generateUriFromFile(file: File): Uri {
		return FileProvider.getUriForFile(context, context.packageName + ".fileprovider", file)
	}

	fun getBitmap(content_resolver: ContentResolver? = null): Bitmap? {
		var bitmap: Bitmap? = null

		getImageSpecifications()
		try {
			bitmap = when (content_resolver) {
				null -> MediaStore.Images.Media.getBitmap(contentResolver, uri)
				else -> MediaStore.Images.Media.getBitmap(content_resolver, uri)
			}
		} catch (e: Exception) {
			Toast.makeText(context, context.getString(R.string.unable_to_get_bitmap_from_image), Toast.LENGTH_SHORT).show()
		}

		return when (_angle) {
			0f -> bitmap
			else -> getRotatedBitmap(bitmap)
		}
	}

	private fun getImageSpecifications() {
		val data = ExifInterface(file.absolutePath)

		dimensions.width = data.getAttributeInt(ExifInterface.TAG_IMAGE_LENGTH, 0)
		dimensions.height = data.getAttributeInt(ExifInterface.TAG_IMAGE_WIDTH, 0)
		_angle = when (data.getAttributeInt(ExifInterface.TAG_ORIENTATION, 0)) {
			3 -> 180f
			6 -> 90f
			8 -> 270f
			else -> 0f
		}
	}

	private fun getRotatedBitmap(source: Bitmap?): Bitmap? {
		val matrix = Matrix()
		matrix.postRotate(_angle)
		return when (source) {
			null -> null
			else -> Bitmap.createBitmap(source, 0, 0, source.width, source.height, matrix, true)
		}
	}
}