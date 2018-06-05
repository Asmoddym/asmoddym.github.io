<?php
/*
	norska
	$Author: rusk23 $
	$URL: svn://svn.noparking.net/var/repos/projets/norska/projects/opentime/run.php $
	$Revision: 13 $

	Copyright (C) No Parking 2012 - 2012
*/
$config = array();
require dirname(__FILE__)."/cfg/config.cfg.php";
$config_project = $config;
unset($config);

if (isset($argv[1])) {
	require $config_project['parameters']['path']."/tests/unit/".$argv[1];
} else {
	foreach (glob($config_project['parameters']['path']."/tests/unit/*.test.php") as $filename) {
		require $filename;
	}
}
