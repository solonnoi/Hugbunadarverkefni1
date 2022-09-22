package is.hi.hbv501g.hbv501g.Vidmot;
import is.hi.hbv501g.hbv501g.Database.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static is.hi.hbv501g.hbv501g.Database.DatabaseConnection.getConn;



public class WorkoutController {
    public static ResultSet searchBar(String search, Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery("select title from workouts where lower(title) like '%" + search + "%'");
    }
  //  ResultSet search = searchBar("b",);
/*
        while(search.next()){
        System.out.println("Niðurstöður leitarinnar er: " + search.getString(1));
    }

 */

}
