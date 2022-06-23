<?php
include "connect.php";
$query1 = "SELECT * FROM bienbao Where loai_BB = 1";
$query2 = "SELECT * FROM bienbao Where loai_BB = 2";
$query3 = "SELECT * FROM bienbao Where loai_BB = 3";

$data1 = mysqli_query($conn,$query1);
$data2 = mysqli_query($conn,$query2);
$data3 = mysqli_query($conn,$query3);

$mangbienbao1 = array();
$mangbienbao2 = array();
$mangbienbao3 = array();


while($row = mysqli_fetch_assoc($data1)){
    array_push($mangbienbao1,new bienbao(
        $row['hinh_BB'],
        $row['nd_BB'],
        $row['loai_BB']
    ));
}
echo json_encode($mangbienbao1);
    class bienbao{
    function bienbao ($hinhbienbao,$noidungbienbao,$loaibienbao){
	$this->hinhbienbao= $hinhbienbao;
	$this->noidungbienbao= $noidungbienbao;
	$this->loaibienbao= $loaibienbao;
    }
}
while($row = mysqli_fetch_assoc($data2)){
    array_push($mangbienbao2,new bienbao(
        $row['hinh_BB'],
        $row['nd_BB'],
        $row['loai_BB']
    ));
}
echo json_encode($mangbienbao2);
        class bienbao{
    function bienbao ($hinhbienbao,$noidungbienbao,$loaibienbao){
	$this->hinhbienbao= $hinhbienbao;
	$this->noidungbienbao= $noidungbienbao;
	$this->loaibienbao= $loaibienbao;
    }
}
while($row = mysqli_fetch_assoc($data3)){
    array_push($mangbienbao3,new bienbao(
        $row['hinh_BB'],
        $row['nd_BB'],
        $row['loai_BB']
    ));
}
echo json_encode($mangbienbao3);
        class bienbao{
    function bienbao ($hinhbienbao,$noidungbienbao,$loaibienbao){
	$this->hinhbienbao= $hinhbienbao;
	$this->noidungbienbao= $noidungbienbao;
	$this->loaibienbao= $loaibienbao;
    }
}

?>