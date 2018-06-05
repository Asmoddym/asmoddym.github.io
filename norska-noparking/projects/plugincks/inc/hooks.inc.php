<?php
/* Norska -- Copyright (C) No Parking 2013 - 2013 */

require_once dirname(__FILE__)."/../../opentime/inc/hooks.inc.php";

class Norska_Plugincks_Hooks extends Norska_Opentime_Hooks {
	function install_after () {
		$this->configure_filerights($this->parameters['path']);
		$this->configure_opentime($this->parameters['path'] . "/opentime/");
		$this->configure_opentime($this->parameters['path'] . "/plugins/cks/");
	}

	function send_subject_after($subject) {
		return "[nopkg cks ".$this->svn->number_revision()."] ".$subject;
	}

	function send_body_after ($body) {
		return $body;
	}
}
