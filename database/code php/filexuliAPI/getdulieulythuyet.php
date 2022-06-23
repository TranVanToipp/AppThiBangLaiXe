<?php
include "connect.php";
$idsp = 1;
$manglythuyet = array();
$query = "SELECT * FROM lt_th Where id_meothi = 1";
$data = mysqli_query($conn,$query);
while($row = mysqli_fetch_assoc($data)){
    array_push($manglythuyet,new Lythuyet(
        $row['id_meothi'],
        $row['nd_meothi'],
    ));
}
echo json_encode($manglythuyet);
    class Lythuyet{
    function Lythuyet($idmeothi,$noidungmeothi,$loai){
        $this->idmeothi=$idmeothi;
        $this->noidungmeothi=$noidungmeothi;
    }
}
?>