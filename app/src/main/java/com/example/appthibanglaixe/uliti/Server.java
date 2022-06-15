package com.example.appthibanglaixe.uliti;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appthibanglaixe.MainActivity;

import java.util.ArrayList;

public class Server  {

//    public static String ip(){
//        ArrayList<IPServer> valuse = MainActivity.ipServerArrayList();
//        return valuse.get(0).getIP();
//    }
    public static String localhost = "192.168.1.8";
    public static String Duongdancauhoi_dapan = "http://"+ localhost +"/filexuliAPI/getcauhoi_traloi.php";
    public static String Duongdanbienbao1 = "http://"+ localhost +"/filexuliAPI/getbienbao1.php";
    public static String Duongdanbienbao2 = "http://"+ localhost +"/filexuliAPI/getbienbao2.php";
    public static String Duongdanbienbao3 = "http://"+ localhost +"/filexuliAPI/getbienbao3.php";
    public static String Duongdanlytuyet = "http://"+ localhost +"/filexuliAPI/getdulieulythuyet.php";
    public static String Duongdanbode = "http://"+ localhost +"/filexuliAPI/getbode1.php";
}
