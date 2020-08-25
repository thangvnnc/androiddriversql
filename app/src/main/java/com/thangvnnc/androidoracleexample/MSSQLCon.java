package com.thangvnnc.androidoracleexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MSSQLCon {
    public static void getEmp(final Callback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
                    // Create a variable for the connection string.
                    String connectionUrl =
                            "jdbc:jtds:sqlserver://192.168.1.105:1433;" +
                                    "databaseName=AndroidTest;user=sa;password=12345678;" +
//                                    "integratedSecurity=true;" +
//                                    "encrypt=true;trustServerCertificate=true;" +
//                                    "sslProtocol=TLS" +
                                    "";
                    try (Connection con = DriverManager.getConnection(connectionUrl);
                         Statement stmt = con.createStatement();) {
                        String SQL = "SELECT * FROM tb_test";
                        ResultSet rs = stmt.executeQuery(SQL);
                        String result = "";
                        // Iterate through the data in the result set and display it.
                        while (rs.next()) {
                            result += (rs.getInt("id") + " " + rs.getInt("idx") + "\n");
                        }

                        callback.result(result);
                    }
                    // Handle any errors that may have occurred.
                    catch (SQLException e) {
                        e.printStackTrace();
                        callback.result("null");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }).start();
    }
}
