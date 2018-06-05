<?php
/* Norska -- Copyright (C) No Parking 2013 - 2013 */

$config = array(
	'parameters' => array(
		'check_interval'	=> 30, // Intervalle (en secondes) entre chaque checks. (defaut=30s)
		'timeout'			=> 2 * 60, // Temps (en secondes) de timeout. (defaut=2m)
		'svn'				=> "/usr/bin/svn", // Chemin vers SVN
		'git'				=> "/usr/bin/git", // Chemin vers Git
		'php'				=> "/usr/bin/php", // Chemin vers PHP
	),
);
