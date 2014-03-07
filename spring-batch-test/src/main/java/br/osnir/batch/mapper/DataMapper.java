package br.osnir.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import br.osnir.batch.object.Person;

/**
 * @author Osnir F CUNHA
 * 
 */
@Component("rowMapper")
public class DataMapper implements RowMapper<Person> {

    public Person mapRow(ResultSet ps, int row) throws SQLException {

        Person result = new Person();
        
        result.setId(ps.getLong(1));
        result.setName(ps.getString(2));
        result.setSalary(ps.getDouble(3));
        result.setDependents(ps.getInt(4));
        
        return result;
    }
}
