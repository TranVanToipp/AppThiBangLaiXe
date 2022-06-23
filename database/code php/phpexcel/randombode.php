<?php
	include('connect/dbhelper.php');
	$sql1= "SELECT * FROM cauhoi_dapan where caudiemliet = '1'";
	$ex = executeResult($sql1);
	$length2 = count($ex);
	$cc=0;
	$ss=5;
	$arr = array();
	for($o=0;$o<$length2/5;$o++){
		for ($e = $cc; $e < $ss; $e++) {
			$rd=rand(1,55);
			if($arr == null){
				$arr[$e]=$rd;
			}
			else {
				$a="";
				while ($a==""){
					$a=$rd;
					for($j=0;$j<$e;$j++){
						if($arr[$j]==$a){
							$a="";
							$rd = rand(1,55);
						}
						else 
							$arr[$e]=$a;
					}
				}
			}
		}
		for($e=$cc;$e<$ss;$e++){
			$aa=$o+1;
			$sql4="UPDATE cauhoi_dapan SET BD_S ='$aa' WHERE cau ='$arr[$e]'";
			execute($sql4);
		}
		$cc=$ss;
		$ss+=5;
	}
	$sql2= "SELECT * FROM cauhoi_dapan where caudiemliet = ''";
	$ex3 = executeResult($sql2);
	$length = count($ex3);
	$c=0;
	$s=20;
	$arr1 = array();
	for($i=0;$i<$length/20;$i++){
		for ($z = $c; $z < $s; $z++) {
			$rd=rand(56,275);
			if($arr1 == null){
				$arr1[$z]=$rd;
			}
			else {
				$a="";
				while ($a==""){
					$a=$rd;
					for($j = 0;$j<$z;$j++){
						if($arr1[$j]==$a){
							$a="";
							$rd = rand(56,275);
						}
						else 
							$arr1[$z]=$a;
					}
				}
			}
		}
		for($zz = $c;$zz<$s;$zz++){
			$aa=$i+1;
			$sql4="UPDATE cauhoi_dapan SET BD_S='$aa' WHERE cau ='$arr1[$zz]'";
			execute($sql4);
		}
		$c=$s;
		$s+=20;
	}
	echo "thành công";
?>