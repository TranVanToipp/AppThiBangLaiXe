<?php
include "connect.php";
$mang_BD= array();
for($i=0;$i<11;$i++){
	$bd=$i+1;
	$sql= "SELECT * FROM cauhoi_dapan WHERE BD_S='$bd'";
	$data=mysqli_query($conn,$sql);
		while($row = mysqli_fetch_assoc($data)){
			array_push($mang_BD,new cauhoi(
				$row['cau'],
				$row['nd_cauhoi'],
				$row['hinh_cauhoi'],
				$row['a'],
				$row['b'],
				$row['c'],
				$row['d'],
				$row['caudung'],
				$row['caudiemliet'],
				$row['loai_CH'],
				$row['BD_S']
			));
	}
}
echo json_encode($mang_BD);
    class cauhoi{
		function cauhoi($cau,$noidungcauhoi,$hinhcauhoi,$a,$b,$c,$d,$caudung,$caudiemliet,$loai_CH,$BD_S){
			$this->cau=$cau;
			$this->noidungcauhoi=$noidungcauhoi;
			$this->hinhcauhoi=$hinhcauhoi;
			$this->a=$a;
			$this->b=$b;
			$this->c=$c;
			$this->d=$d;
			$this->caudung=$caudung;
			$this->caudiemliet=$caudiemliet;
			$this->loaicauhoi=$loai_CH;
			$this->sobode=$BD_S;
		}
	}
?>