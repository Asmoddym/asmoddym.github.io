<?php
/*
	norska
	$Author: jeff $
	$URL: svn://svn.noparking.net/var/repos/projets/norska/projects/pluginepaplainedefrance/inc/hooks.inc.php $
	$Revision: 6 $

	Copyright (C) No Parking 2012 - 2012
*/

require_once dirname(__FILE__)."/../../opentime/inc/hooks.inc.php";

class Norska_Pluginepaplainedefrance_Hooks extends Norska_Opentime_Hooks {
	function install_after () {
		$this->configure_filerights($this->parameters['path']);
		$this->configure_opentime($this->parameters['path'] . "/opentime/");
	}

	function send_subject_after($subject) {
		return "[nopkg pluginepaplainedefrance ".$this->svn->number_revision()."] ".$subject;
	}

	function send_body_after ($body) {
		return $body;
	}
}

