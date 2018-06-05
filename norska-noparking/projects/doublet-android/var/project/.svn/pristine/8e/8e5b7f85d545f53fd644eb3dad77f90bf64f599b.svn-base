package net.noparking.projects.utl

import java.io.File

class Directory(internal var root: File, internal var name: String) {
	private lateinit var _path: File

	init {
		_path = File(root, name)
	}

	fun create() {
		if (!_path.exists()) {
			_path.mkdirs()
		}
	}

	fun delete() {
		if (_path.exists()) {
			_path.deleteRecursively()
		}
	}

	fun getPath(): File {
		return _path
	}
}