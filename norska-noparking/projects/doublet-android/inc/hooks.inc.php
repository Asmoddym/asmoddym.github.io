<?php
/* Norska -- Copyright (C) No Parking 2013 - 2015 */

class Norska_Doublet_Android_Hooks implements Norska_Hooks {

	protected $svn;
	protected $parameters;
	protected $mysqlConfig;
	protected $config;

	public function __construct(Norska_Project_Config $config) {
		$this->config = $config;
		$this->parameters = array();
		$this->mysqlConfig = array();
		$this->svn = new Norska_Repository_Svn($config->get_config('svn'));
	}

	public function install_before() {
		echo "install_before";
		return true;
	}

	public function install_after() {
		echo "install_after";
		return true;
	}

	public function update_after() {
		echo "update_after";
		return true;
	}

	public function uninstall_before() {
		echo "uninstall_before";
		return true;
	}

	public function uninstall_after() {
		echo "uninstall_after";
		return true;
	}

	public function send_subject_after($subject) {
		return '[nopkg doublet-android '.$this->svn->number_revision().'] '.$subject;
	}

	public function send_body_after($body) {
		return $body;
	}
}
