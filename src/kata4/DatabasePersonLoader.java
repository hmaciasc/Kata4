package kata4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabasePersonLoader implements PersonLoader{

    private final Connection connection;

    public DatabasePersonLoader(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public Person[] load() {
        try {
            return processPeople(connection.createStatement().executeQuery("SELECT * FROM people"));
        } catch (SQLException ex) {
            return new Person[0];
        }
    }

    private Person[] processPeople(ResultSet resultSet) {
        ArrayList<Person> personList = new ArrayList<>();
        return personList.toArray(new Person[personList.size()]);
    }
    
}
