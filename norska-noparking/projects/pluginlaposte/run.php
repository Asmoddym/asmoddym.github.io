<?php
/*
	norska
	$Author: rusk23 $
	$URL: svn://svn.noparking.net/var/repos/projets/norska/projects/opentime/run.php $
	$Revision: 12 $

	Copyright (C) No Parking 2012 - 2012
*/

$config = array();
require dirname(__FILE__)."/cfg/config.cfg.php";
$config_project = $config;
unset($config);

foreach (glob($config_project['parameters']['path']."plugins/laposte/tests/unit/*.test.php") as $filename) {
	require $filename;
}
