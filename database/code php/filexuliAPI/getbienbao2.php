<?php
include "connect.php";
$query = "SELECT * FROM bienbao Where loai_BB = 2";
$data = mysqli_query($conn,$query);
$mangbienbao = array();
while($row = mysqli_fetch_assoc($data)){
    array_push($mangbienbao,new bienbao(
        $row['hinh_BB'],
        $row['nd_BB'],
        $row['loai_BB']
    ));

}
echo json_encode($mangbienbao);
    class bienbao{
    function bienbao ($hinhbienbao,$noidungbienbao,$loaibienbao){
	$this->hinhbienbao= $hinhbienbao;
	$this->noidungbienbao= $noidungbienbao;
	$this->loaibienbao= $loaibienbao;
    }
}

?>