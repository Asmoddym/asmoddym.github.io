<?php
/*
	norska
	$Author: perrick $
	$URL: svn://svn.noparking.net/var/repos/projets/norska/inc/integration_svn.inc.php $
	$Revision: 6 $

	Copyright (C) No Parking 2012 - 2012
*/

require_once dirname(__FILE__)."/../../opentime/inc/hooks.inc.php";

class Norska_Plugingrdf_Hooks extends Norska_Opentime_Hooks {
	function install_after () {
		$this->configure_filerights($this->parameters['path']);
		$this->configure_opentime($this->parameters['path']."/opentime/");
		$this->configure_opentime($this->parameters['path']."/plugins/grdf/");
		$this->configure_plugin($this->parameters['path']."/plugins/grdf/");
	}

	function update_after() {
		$this->configure_plugin($this->parameters['path']."/plugins/grdf/");
	}

	function configure_plugin($path) {
		$instances_file = $path."cfg/instances.inc.php";

		if (!file_exists($instances_file)) {
			$instances = array();
			include $instances_file.".dist";

			$instances_cfg = "<?php\n\n\$instances += ".var_export($instances, true).";\n";
			file_put_contents($instances_file, $instances_cfg);
		}

		$cfg_file = $path."cfg/config.inc.php";
		copy($cfg_file.".dist", $cfg_file);

		$param_file = $path."cfg/param.inc.php";
		if(file_exists($param_file.".dist")) {
			copy($param_file.".dist", $param_file);
		}
	}

	function send_subject_after($subject) {
		return "[nopkg plugingrdf ".$this->svn->number_revision()."] ".$subject;
	}

	function send_body_after($body) {
		return $body;
	}
}
