//package com.pondit.b4.class24_27;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.sql.*;
//
//public class ConnectingDBWithJDBC {
//    public static void main(String[] args) throws ClassNotFoundException, IOException {
//        Class.forName("org.postgresql.Driver");
//        Connection connection = null;
//        try{
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_management", "postgres", "");
//            //............
//        } catch (SQLException e) {
//            // .............
//        }
//        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_management", "postgres", "")) {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            String sessionId = bufferedReader.readLine();
//            // With statement object, it is vulnerable to SQL injection
//            Statement statement = connection.createStatement();
//            ResultSet rs = null;
//            rs = statement.executeQuery("select * from sessions where session_id = " + sessionId);
//
//            // With preparedStatement, it is not vulnerable
//            PreparedStatement pstmt = connection.prepareStatement("select * from sessions where semester_name = ?");
//            pstmt.setString(1, sessionId);
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                System.out.print(rs.getString("session_id") + "\t");
//                System.out.print(rs.getString("semester_name") + "\t");
//                System.out.print(rs.getString("starting_date") + "\t");
//                System.out.println(rs.getString("ending_date"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
