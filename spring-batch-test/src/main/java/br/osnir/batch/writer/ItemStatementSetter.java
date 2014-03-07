package br.osnir.batch.writer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.stereotype.Component;

import br.osnir.batch.object.PersonTax;

/**
 * @author Osnir F CUNHA
 * 
 */
@Component("itemPreparedStatementSetter")
public class ItemStatementSetter implements ItemPreparedStatementSetter<PersonTax> {

    public void setValues(PersonTax item, PreparedStatement ps) throws SQLException {

    	ps.setLong(1, item.getPerson().getId());
        ps.setBoolean(2, item.isFree());
        ps.setDouble(3, item.getTax());
        ps.setDate(4, new Date(item.getDate().getTime()));
        
    }

}
