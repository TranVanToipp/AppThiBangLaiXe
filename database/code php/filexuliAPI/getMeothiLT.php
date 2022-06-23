<?php
include "connect.php";
$query = "SELECT * FROM lt_th";
$data = mysqli_query($conn,$query);
$mangbienbao = array();
while($row = mysqli_fetch_assoc($data)){
    array_push($mangbienbao,new bienbao(
        $row['id_meothi'],
        $row['nd_meothi'],
        $row['loai']
    ));

}
echo json_encode($mangbienbao);
    class bienbao{
    function bienbao ($id_meothi,$nd_meothi,$loai){
	$this->id_meo= $id_meothi;
	$this->nd_meo= $nd_meothi;
	$this->loai= $loai;
    }
}

?>