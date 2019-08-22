package com.company;

import java.sql.*;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Main {

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://root:F1c7a657@localhost:3306/world"+
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "F1c7a657";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static Statement stmt1;
    private static Statement stmt2;
    private static Statement stmt3;
    private static Queue<Statement> queueStatement = new LinkedList<>();
    private static Queue<ResultSet> queueResultSet = new LinkedList<>();
    private static ResultSet rs;


    //TODO: Поговорить об интерфейсах и методах

    public static void main(String args[]) {

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            for(int i = 0; i< 4; i++) {
                queueStatement.offer(con.createStatement());
            }
//            stmt = con.createStatement();
//            stmt1 = con.createStatement();
//            stmt2 = con.createStatement();
//            stmt3 = con.createStatement();

            // executing SELECT query

            //queueResultSet.offer(stmt.executeQuery("Select sum(a.population) from (select city.population from city WHERE city.countrycode IN (SELECT code from country where name = \"Russian federation\")) as a;"));


            queueResultSet.offer(Objects.requireNonNull(queueStatement.poll()).executeQuery("Select sum(a.population) from (select city.population from city WHERE city.countrycode IN (SELECT code from country where name = \"Russian federation\")) as a;"));
            queueResultSet.offer(Objects.requireNonNull(queueStatement.poll()).executeQuery("Select headofState from country where code IN (Select countrycode from city where name = \"St Petersburg\")"));
            queueResultSet.offer(Objects.requireNonNull(queueStatement.poll()).executeQuery("Select name from city where id IN (Select capital from  country where code IN (Select countrycode from city where name = \"Vladivostok\"));"));
            queueResultSet.offer(Objects.requireNonNull(queueStatement.poll()).executeQuery("Select language from countryLanguage where countrycode IN (select code from country where headofstate = \"George W. Bush\") and isofficial = \"T\" GROUP BY language;"));
            while (!queueResultSet.isEmpty()) {
                rs = queueResultSet.poll();
                System.out.println("Result select: ");
                while (rs.next()) {
                    String count = rs.getString(1);
                    System.out.println(count);
                }
                System.out.println();
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and result set here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
//            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }


}
