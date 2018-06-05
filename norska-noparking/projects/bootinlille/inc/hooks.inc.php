<?php
/* Norska -- Copyright (C) No Parking 2013 - 2013 */

require_once dirname(__FILE__)."/../../opentime/inc/hooks.inc.php";

class Norska_Bootinlille_Hooks extends Norska_Opentime_Hooks {
	function install_after () {
		$this->configure_filerights($this->parameters['path']);
		$this->configure_opentime($this->parameters['path'] . "opentime/");
		$this->configure_plugin($this->parameters['path'] . "applications/commons/");
		$this->configure_plugin($this->parameters['path'] . "applications/bootinlille/");
	}

	function configure_plugin($path) {
		$result = false;

		$cfg_file = $path . "cfg/config.inc.php";
		if (!file_exists($cfg_file)) {
			copy($cfg_file . ".dist", $cfg_file);
		}

		$param_file = $path . "cfg/param.inc.php";
		if (!file_exists($param_file)) {
			if(file_exists($param_file . ".dist")) {
				copy($param_file . ".dist", $param_file);
			}
		}

		return true;
	}

	function send_subject_after($subject) {
		return "[nopkg bootinlille.com ".$this->svn->number_revision()."] ".$subject;
	}

	function send_body_after ($body) {
		return $body;
	}
}
