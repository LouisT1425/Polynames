package back.database;

import java.sql.SQLException;

public class PolyNameDataBase extends MySQLDatabase{

    public PolyNameDataBase() throws SQLException{
        super("localhost", 3306, "polynames", "root", "");
    }
}