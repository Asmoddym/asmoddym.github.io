<?php
/* Norska -- Copyright (C) No Parking 2013 - 2015 */

require_once dirname(__FILE__)."/../../opentime/inc/hooks.inc.php";

class Norska_Lozeil_com_Hooks implements Norska_Hooks
{
	function __construct(Norska_Project_Config $config) {
		$this->config = $config;

		$this->parameters = $config->get_config("parameters");
		$this->mysql = $config->get_config("mysql");
		$this->svn = new Norska_Repository_Svn($config->get_config("svn"));
	}

	function install_before() {
	}

	function install_after() {
		$this->configure_lozeil($this->parameters['path']."applications/lozeil/");
		$this->configure_lozeil($this->parameters['path']."lozeil/");
	}
	
	public function update_after() {
		exec("php ".$this->parameters['path']."/cli/bot.php"." --update");
	}

	function configure_lozeil($path) {
		$cfg_file = $path . "cfg/config.inc.php";
		if (!file_exists($cfg_file)) {
			copy($cfg_file . ".dist", $cfg_file);
		}

		$cfg = file_get_contents($cfg_file);

		$cfg = preg_replace("/(config\['root_url'\]\s+=\s+\")[^\"]*(\")/", "\\1" . $this->parameters['root_url'] . "\\2", $cfg);
		if ($cfg === null) {
			throw new Exception(Norska::__("config['root_url'] not found in config file"));
		}

		$cfg = preg_replace("/(dbconfig\['name'\]\s+=\s+\")[^\"]*(\")/", "\\1" . $this->mysql['name'] . "\\2", $cfg);
		if ($cfg === null) {
			throw new Exception(Norska::__("config['name'] not found in config file"));
		}

		$cfg = preg_replace("/(dbconfig\['user'\]\s+=\s+\")[^\"]*(\")/", "\\1" . $this->mysql['user'] . "\\2", $cfg);
		if ($cfg === null) {
			throw new Exception(Norska::__("config['user'] not found in config file"));
		}

		$cfg = preg_replace("/(dbconfig\['pass'\]\s+=\s+\")[^\"]*(\")/", "\\1" . $this->mysql['pass'] . "\\2", $cfg);
		if ($cfg === null) {
			throw new Exception(Norska::__("config['pass'] not found in config file"));
		}

		$cfg = preg_replace("/(config\['email_smtp'\]\s+=\s+\")[^\"]*(\")/", "\\1" . $this->parameters['smtp'] . "\\2", $cfg);
		if ($cfg === null) {
			throw new Exception(Norska::__("config['email_smtp'] not found in config file"));
		}

		if (!file_put_contents($cfg_file, $cfg)) {
			throw new Exception(Norska::__("Failed to write config file"));
		}

		$param_file = $path . "cfg/param.inc.php";
		if (!file_exists($param_file)) {
			copy($param_file . ".dist", $param_file);
		}
	}

	function uninstall_before() {
	}

	function uninstall_after() {

	}

	function send_subject_after($subject) {
		return '[nopkg lozeil.com '.$this->svn->number_revision().'] '.$subject;
	}

	function send_body_after($body) {
		return $body;
	}
}
