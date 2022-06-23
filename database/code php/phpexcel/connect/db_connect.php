<?php
	$mysqli = mysqli_connect('localhost','root','','thibanglaia1');
	$mysqli->set_charset('utf8');
	if(mysqli_connect_errno()){
		echo 'fail';
		exit;
	}

?>