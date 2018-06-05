<?php
/* Norska -- Copyright (C) No Parking 2013 - 2013 */

require_once dirname(__FILE__)."/../../opentime/inc/hooks.inc.php";

class Norska_Ofr_Hooks extends Norska_Opentime_Hooks {
	public function install_after() {
		$this->configure_filerights($this->parameters['path']);
		$this->configure_opentime($this->parameters['path'] . "/opentime/");
		$this->configure_opentime($this->parameters['path'] . "/plugins/accounts/");
		$this->configure_ofr($this->parameters['path'] . "/applications/ofr/");
	}

	private function configure_ofr($path) {
		$result = false;

		$cfg_file = $path . "cfg/config.inc.php";
		if (!file_exists($cfg_file))
		{
			copy($cfg_file . ".dist", $cfg_file);
		}

		$param_file = $path . "cfg/param.inc.php";
		if (!file_exists($param_file))
		{
			copy($param_file . ".dist", $param_file);
		}

		return true;
	}
	
	public function update_after() {
		exec("php ".$this->parameters['path']."/cli/bot.php"." --update_application");
	}

	public function send_subject_after($subject) {
		return '[nopkg ofr ' . $this->svn->number_revision() . '] ' . $subject;
	}

	public function send_body_after($body) {
		return $body;
	}
}
