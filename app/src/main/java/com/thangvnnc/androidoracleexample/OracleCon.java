package com.thangvnnc.androidoracleexample;

import java.sql.*;


public class OracleCon {
    public static void getEmp(final Callback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //step1 load the driver class
//                    Class.forName("oracle.jdbc.driver.OracleDriver");

                    //step2 create  the connection object
                    Connection con = DriverManager.getConnection(
                            "jdbc:oracle:thin:@192.168.1.105:1521:KEIDB", "keiusr", "kuser0000");

                    //step3 create the statement object
                    Statement stmt = con.createStatement();

                    //step4 execute query
                    ResultSet rs = stmt.executeQuery("select * from M02_KIJUN");
                    String stringResult = "";
                    while (rs.next()) {
                        stringResult += rs.getInt(1) + "  " + rs.getInt(2) + "\n";
                    }
                    //step5 close the connection object
                    con.close();
                    callback.result(stringResult);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }).start();
    }
}
