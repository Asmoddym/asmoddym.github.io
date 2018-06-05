<?php
/* Norska -- Copyright (C) No Parking 2013 - 2013 */

class Norska_Norska_Hooks implements Norska_Hooks
{
	function __construct(Norska_Project_Config $config) {
		$this->config = $config;

		$this->parameters = $config->get_config("parameters");
		$this->git = new Norska_Repository_Git($config->get_config("git"));
	}

	function install_before() {
	}

	function install_after() {
		$this->configure($this->parameters['path']);
	}

	function configure($path) {
		$cfg_file = $path."/cfg/config.inc.php";
		if (!file_exists($cfg_file)) {
			copy($cfg_file.".dist", $cfg_file);
		}

		include $cfg_file;

		$config['parameters']['svn'] = "/usr/local/bin/svn";
		$config['parameters']['git'] = "/usr/local/bin/git";
		$config['parameters']['php'] = "/usr/local/bin/php";

		$cfg = "<?php".PHP_EOL.PHP_EOL."\$config = ".var_export($config, true).";".PHP_EOL;

		if (!file_put_contents($cfg_file, $cfg)) {
			throw new Exception(Norska::__("Failed to write config file"));
		}
	}

	function uninstall_before() {
	}

	function uninstall_after() {
	}

	function send_subject_after($subject) {
		$path = $this->parameters['path'];
		$commit_id = $this->git->commit_id($path);
		$commit_id = substr($commit_id, 0, 8);

		return "[nopkg norska ".$commit_id."] ".$subject;
	}

	function send_body_after($body) {
		return $body;
	}
}
