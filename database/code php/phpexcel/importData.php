<?php
	include('connect/db_connect.php');
	include('connect/dbhelper.php');
	include('Classes/PHPExcel.php');

	if(isset($_POST['btnGui'])&& isset($_POST['name'])){
		$name = $_POST['name'];
		$file = $_FILES['file']['tmp_name'];
		$objReader = PHPExcel_IOFactory::createReaderForFile($file);
		if($name == "cauhoi-dapan"){
			$objReader ->setloadSheetsOnly($name);

			$objExcel = $objReader ->load($file);
			$sheetData = $objExcel ->getActiveSheet()->toArray('null', true, true, true);

			$highestRow = $objExcel->setActiveSheetIndex()->getHighestRow();
			for($row = 2; $row<=$highestRow; $row++){
				$cau = $sheetData[$row]['A'];
				$nd_cauhoi = $sheetData[$row]['B'];
				$hinh_cauhoi = $sheetData[$row]['C'];
				$a = $sheetData[$row]['D'];
				$b = $sheetData[$row]['E'];
				$c = $sheetData[$row]['F'];
				$d = $sheetData[$row]['G'];
				$caudung = $sheetData[$row]['H'];
				$caudiemliet = $sheetData[$row]['I'];
				$loai_CH = $sheetData[$row]['J'];
				$BD_S = $sheetData[$row]['K'];
				if($hinh_cauhoi == 'null'){
					$hinh_cauhoi= "";
				}else $hinh_cauhoi = $sheetData[$row]['C'];
				if($a == 'null'){
					$a= "";
				} else $a = $sheetData[$row]['D'];
				if($b == 'null'){
					$b= "";
				}else $b = $sheetData[$row]['E'];
				if($c == 'null'){
					$c= "";
				}else $c = $sheetData[$row]['F'];
				if($d == 'null'){
					$d= "";
				}else $d = $sheetData[$row]['G'];
				if($caudiemliet == 'null'){
					$caudiemliet= "";
				}else $caudiemliet = $sheetData[$row]['I'];
				if($BD_S == 'null'){
					$BD_S= "";
				}else $BD_S = $sheetData[$row]['K'];
				$sql = "INSERT INTO cauhoi_dapan(cau, nd_cauhoi, hinh_cauhoi, a, b, c, d, caudung, caudiemliet, loai_CH,BD_S) 
				VALUES ('$cau', '$nd_cauhoi', '$hinh_cauhoi', '$a', '$b', '$c', '$d', '$caudung', '$caudiemliet','$loai_CH','$BD_S')";
				$mysqli->query($sql);
				
			}
		}
		else if($name == "bienbao"){
			$objReader ->setloadSheetsOnly($name);

			$objExcel = $objReader ->load($file);
			$sheetData = $objExcel ->getActiveSheet()->toArray('null', true, true, true);

			$highestRow = $objExcel->setActiveSheetIndex()->getHighestRow();
			for($row = 2; $row<=$highestRow; $row++){
				$hinh_BB = $sheetData[$row]['A'];
				$nd_BB = $sheetData[$row]['B'];
				$loai_BB = $sheetData[$row]['C'];
				$sql = "INSERT INTO bienbao(hinh_BB, nd_BB, loai_BB) 
				VALUES ('$hinh_BB', '$nd_BB', '$loai_BB')";
				$mysqli->query($sql);
			}
		}
		else if($name == "bode"){
			$objReader ->setloadSheetsOnly($name);

			$objExcel = $objReader ->load($file);
			$sheetData = $objExcel ->getActiveSheet()->toArray('null', true, true, true);

			$highestRow = $objExcel->setActiveSheetIndex()->getHighestRow();
			for($row = 2; $row<=$highestRow; $row++){
				$BD_S = $sheetData[$row]['A'];
				$S_Cau = $sheetData[$row]['B'];
				$sql = "INSERT INTO bode(BD_S, S_Cau) 
				VALUES ('$BD_S','$S_Cau')";
				$mysqli->query($sql);
			}
		}
		else if($name == "lt-th"){
			
			$objReader ->setloadSheetsOnly($name);

			$objExcel = $objReader ->load($file);
			$sheetData = $objExcel ->getActiveSheet()->toArray('null', true, true, true);

			$highestRow = $objExcel->setActiveSheetIndex()->getHighestRow();
			for($row = 2; $row<=$highestRow; $row++){
				$id_meothi = $sheetData[$row]['A'];
				$nd_meothi = $sheetData[$row]['B'];
				$loai = $sheetData[$row]['C'];
				$sql = "INSERT INTO lt_th(id_meothi, nd_meothi, loai) 
				VALUES ('$id_meothi', '$nd_meothi', '$loai')";
				$mysqli->query($sql);
			}
		}
		else if($name == "hoclt"){
			$objReader ->setloadSheetsOnly($name);

			$objExcel = $objReader ->load($file);
			$sheetData = $objExcel ->getActiveSheet()->toArray('null', true, true, true);
			$socau = 0;

			$highestRow = $objExcel->setActiveSheetIndex()->getHighestRow();
			for($row = 2; $row<=$highestRow; $row++){
				$tieude = $sheetData[$row]['A'];
				if($tieude == "Khái niệm và quy tắc"){
					$sql1 = "SELECT * FROM cauhoi_dapan WHERE loai_CH = '1'";
					$ex=executeResult($sql1);
					$socau = count($ex);
				}
				if($tieude == "Văn hóa và đạo đức lái xe"){
					$sql1 = "SELECT * FROM cauhoi_dapan WHERE loai_CH = '2'";
					$ex=executeResult($sql1);
					$socau = count($ex);
				}
				if($tieude == "Kỹ thuật lái xe"){
					$sql1 = "SELECT * FROM cauhoi_dapan WHERE loai_CH = '3'";
					$ex=executeResult($sql1);
					$socau = count($ex);
				}
				if($tieude == "Biển báo đường bộ"){
					$sql1 = "SELECT * FROM cauhoi_dapan WHERE loai_CH = '4'";
					$ex=executeResult($sql1);
					$socau = count($ex);
				}
				if($tieude == "Sa hình"){
					$sql1 = "SELECT * FROM cauhoi_dapan WHERE loai_CH = '5'";
					$ex=executeResult($sql1);
					$socau = count($ex);
				}
				$tiendo = $sheetData[$row]['E'];
				$hinh = $sheetData[$row]['B'];
				$caudiemliet=$sheetData[$row]['D'];
				if($tiendo == "null")
					$tiendo="";
				if($caudiemliet == "null")
					$caudiemliet="";
				$sql = "INSERT INTO hoclt(tieude, hinh, socau, caudiemliet, tiendo) 
					VALUES ('$tieude','$hinh','$socau','$caudiemliet','$tiendo')";
				$mysqli->query($sql);
			}
		}
		else echo 'fail';
		echo 'inserted';
	}



?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>
<body>
	<form method="POST" enctype="multipart/form-data">
		<input type="file" name="file"><input type="text" name="name">
		<button type="submit" name="btnGui">Import</button>
		
	</form>

</body>
</html>