<?php
/* Norska -- Copyright (C) No Parking 2013 - 2015 */

class Norska_Opentime_Hooks implements Norska_Hooks {

	protected $svn;
	protected $parameters;
	protected $mysqlConfig;
	protected $config;

	public function __construct(Norska_Project_Config $config) {
		$this->config = $config;
		$this->parameters = $config->get_config('parameters');
		$this->mysqlConfig = $config->get_config('mysql');
		$this->svn = new Norska_Repository_Svn($config->get_config('svn'));
	}

	public function install_before() {
		return true;
	}

	public function install_after() {
		$this->configure_filerights($this->parameters['path']);
		$this->configure_opentime($this->parameters['path']);
	}

	public function update_after() {
		exec("php ".$this->parameters['path']."/cli/bot.php"." --update");
	}

	protected function configure_filerights($path) {
		$command = "chmod -R 777 ".$path;
		exec($command);

		$command = "chown -R ".$this->parameters['owner'].":".$this->parameters['group']." " . $path;
		exec($command);

		if ($handle = opendir($path)) {
			while (false !== ($file = readdir($handle))) {
				if (!preg_match("/^\./", $file)) {
					if (is_dir($file)) {
						$command = "chmod -R 777 ".$path.$file;
					} else {
						$command = "chmod 777 ".$path.$file;
					}
					exec($command);
				}
			}
		}
		closedir($handle);
	}

	protected function configure_opentime($path) {
		$result = false;

		$cfg_file = $path."cfg/config.inc.php";
		if (!file_exists($cfg_file) and file_exists($cfg_file.".dist")) {
			copy($cfg_file.".dist", $cfg_file);

			$cfg = file_get_contents($cfg_file);

			$cfg = preg_replace("/(backupconfig\['path'\]\s+=\s+\")[^\"]*(\")/", "\\1".$this->parameters['mysqldump_path']."mysqldump"."\\2", $cfg);
			if ($cfg === null) {
				throw new Exception(Norska::__("backupconfig['path'] not found in config file"));
			}

			$cfg = preg_replace("/(config\['root_url'\]\s+=\s+\")[^\"]*(\")/", "\\1".$this->parameters['root_url']."\\2", $cfg);
			if ($cfg === null) {
				throw new Exception(Norska::__("config['root_url'] not found in config file"));
			}

			$cfg = preg_replace("/(dbconfig\['name'\]\s+=\s+\")[^\"]*(\")/", "\\1".$this->mysqlConfig['name']."\\2", $cfg);
			if ($cfg === null) {
				throw new Exception(Norska::__("config['name'] not found in config file"));
			}

			$cfg = preg_replace("/(dbconfig\['user'\]\s+=\s+\")[^\"]*(\")/", "\\1".$this->mysqlConfig['user']."\\2", $cfg);
			if ($cfg === null) {
				throw new Exception(Norska::__("config['user'] not found in config file"));
			}

			$cfg = preg_replace("/(dbconfig\['pass'\]\s+=\s+\")[^\"]*(\")/", "\\1".$this->mysqlConfig['pass']."\\2", $cfg);
			if ($cfg === null) {
				throw new Exception(Norska::__("config['pass'] not found in config file"));
			}

			$cfg = preg_replace("/(config\['email_smtp'\]\s+=\s+\")[^\"]*(\")/", "\\1".$this->parameters['smtp']."\\2", $cfg);
			if ($cfg === null) {
				throw new Exception(Norska::__("config['email_smtp'] not found in config file"));
			}

			if (!file_put_contents($cfg_file, $cfg)) {
				throw new Exception(Norska::__("Failed to write config file"));
			}
		}

		$param_file = $path."cfg/param.inc.php";
		if (!file_exists($param_file) and file_exists($param_file.".dist")) {
			copy($param_file.".dist", $param_file);

			$param = file_get_contents($param_file);

			$param = preg_replace("/(param\['email_enable'\]\s+=\s+\")[^\"]*(\")/", "\\1".$this->parameters['email_enable']."\\2", $param);
			if ($param === null) {
				throw new Exception(Norska::__("param['email_enable'] not found in param file"));
			}

			if (!file_put_contents($param_file, $param)) {
				throw new Exception(Norska::__("Failed to write param file"));
			}
		}
		
		$locale_file = $path."cfg/locale.inc.php";
		if (!file_exists($locale_file) and file_exists($locale_file.".dist")) {
			copy($locale_file.".dist", $locale_file);
		}
	}

	public function uninstall_before() {
		return true;
	}

	public function uninstall_after() {
		return true;
	}

	public function send_subject_after($subject) {
		return '[nopkg opentime '.$this->svn->number_revision().'] '.$subject;
	}

	public function send_body_after($body) {
		return $body;
	}
}
