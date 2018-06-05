<?php
/* Norska -- Copyright (C) No Parking 2013 - 2013 */

$config = array(
	'svn' => array(
		'url' => "svn://svn.noparking.net/usr/local/svn/opentime",
		'user' => "sylvain.chaugny",
		'pass' => "Af3f4J43hD",
	),
	'mysql' => array(
		'host' => "localhost",
		'user' => "root",
		'pass' => "root",
		'name' => "opentime",
	),
	'parameters' => array(
		'mysqldump_path' 	=> "/usr/local/mysql/bin/",
		'root_url' 			=> "http://project.local/",
		'path'     			=>  dirname(__FILE__)."/../var/project/",
		'owner'    			=> "www-data",
		'group'    			=> "www-data",
		'smtp'     			=> "smtp.noparking.net",
	),
);