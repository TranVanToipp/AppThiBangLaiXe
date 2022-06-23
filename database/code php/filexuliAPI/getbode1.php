<?php
include "connect.php";
$mang_BD= array();
for($i=0;$i<11;$i++){
	$bd=$i+1;
	$sql= "SELECT * FROM bode WHERE BD_S='$bd'";
	$data=mysqli_query($conn,$sql);
	while($row = mysqli_fetch_assoc($data)){
			array_push($mang_BD,new bode(
				$row['BD_S'],
				$row['S_Cau'],
			));
		}
}
echo json_encode($mang_BD);
    class bode{
		function bode($bd,$cau){
			$this->bd=$bd;
			$this->cau=$cau;
		}
	}
?>