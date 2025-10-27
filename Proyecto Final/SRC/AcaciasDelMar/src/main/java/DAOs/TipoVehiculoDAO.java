package DAOs;

import DTOs.TipoVehiculoDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class TipoVehiculoDAO {
    private final String dbFullURL;
    private final String dbUser;
    private final String dbPswd;
    
    @Autowired
    public TipoVehiculoDAO(
            @Qualifier("dbName") String dbName,
            @Qualifier("dbURL") String dbURL,
            @Qualifier("dbUser") String dbUser,
            @Qualifier("dbPswd") String dbPswd)
    {
        dbFullURL = "jdbc:mysql://" + dbURL + "/" + dbName;
        this.dbUser = dbUser;
        this.dbPswd = dbPswd;
    }
    
    
    public List<String> getTiposVehiculos(){
        ArrayList<String> res = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection(dbFullURL,dbUser,dbPswd);
            Statement stmt = con.createStatement();
            stmt.execute("Select DISTINCT denominacion FROM tipos_vehiculo;");
            ResultSet rs = stmt.getResultSet();
            
            while(rs.next()){
                res.add(rs.getString(1));
            }
            con.close();
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return res;
    }
}
