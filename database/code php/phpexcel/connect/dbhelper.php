<?php
require_once('config.php');
// Câu lệnh chèn dữ liệu(insert)
function execute($sql) {
    // Mở kết nổi
    $conn = mysqli_connect(HOST,USERNAME,PASSWORD,DATABASE);
    mysqli_set_charset($conn,'utf8');
    // mysqli_set_charset('utf8');
    // Câu truy vấn
    mysqli_query($conn, $sql);
    // Đóng kết nối
    mysqli_close($conn);
}

// SQL: SELCT dữ liệu -> lấy dữ liệu đầu ra
// $sql là lấy ra toàn bộ bảng
// $isSingle = false sử dụng khi ta chỉ lấy 1 cột trong bảng

function executeResult($sql, $isSingle= false) {
    $data = null;
    // mở kết nối
    $conn = mysqli_connect(HOST,USERNAME,PASSWORD,DATABASE);
	mysqli_set_charset($conn,'utf8');
    // Câu truy vấn
    $resultset = mysqli_query($conn,$sql);
    if($isSingle) {
        $data = mysqli_fetch_array($resultset,1);
    } else {
        $data = [];
        while(($row = mysqli_fetch_array($resultset,1)) != null) {
            $data[]=$row;
        }
    }
    // Đóng kết nối
    mysqli_close($conn);
    return $data;
}
// Hàm mã hóa thông tin MD5

// function getSecurityMD5($pwd) {
//     return md5(md5($pwd).PRIVATE_KEY);
// }