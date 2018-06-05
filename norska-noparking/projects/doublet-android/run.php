<?php
/*
	norska
	$Author: sylvain $
	$URL: svn://svn.noparking.net/var/repos/projets/norska/projects/opentime/run.php $
	$Revision: $

	Copyright (C) No Parking 2018 - 2018
*/

$config = array();
require dirname(__FILE__) . "/cfg/config.cfg.php";
$config_project = $config;
unset($config);

exec($config_project['parameters']['path'] . "gradlew -b " . $config_project['parameters']['path'] . "build.gradle --console=auto --info test");
