package grailstest

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
try {

    String dbURL = "jdbc:mysql://localhost/mysql?user=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    Connection connection = DriverManager.getConnection(dbURL)
    Statement statement = connection.createStatement()
    boolean resultset = statement.execute("CREATE Database if not exists report_dev")
    print resultset
}catch (SQLException e){
    e.printStackTrace()
}
        GrailsApp.run(Application, args)
    }
}