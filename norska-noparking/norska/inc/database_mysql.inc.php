<?php
/* Norska -- Copyright (C) No Parking 2013 - 2013 */

class Norska_Database_Mysql {
	public $config;

	function __construct($config) {
		$this->config = $config;
	}

	function is_configured() {
		if (!isset($this->config['host'])) {
			return false;
		}
		if (!isset($this->config['user'])) {
			return false;
		}
		if (!isset($this->config['pass'])) {
			return false;
		}
		if (!isset($this->config['name'])) {
			return false;
		}
		return true;
	}

	function install() {
		if ($this->is_configured()) {
			$link = mysqli_connect($this->config['host'], $this->config['user'], $this->config['pass']);
			if ($link === false) {
				throw new Exception(Norska::__("Failed to connect to the database"));
			}
			mysqli_select_db($link, $this->config['name']);
			$result = mysqli_query($link, "CREATE DATABASE IF NOT EXISTS ".$this->config['name']);
			if ($result === false) {
				throw new Exception(Norska::__("Failed to create the database"));
			}
			mysqli_select_db($link, $this->config['name']);
			return true;
		}

		return false;
	}

	function uninstall() {
		if ($this->is_configured()) {
			$link = mysqli_connect($this->config['host'], $this->config['user'], $this->config['pass']);
			if ($link === false) {
				throw new Exception(Norska::__("Failed to connect to the database"));
			}
			$result = mysqli_query($link, "DROP DATABASE IF EXISTS ".$this->config['name']);
			if ($result === false) {
				throw new Exception(Norska::__("Failed to drop the database"));
			}
			return true;
		}

		return false;
	}
}
