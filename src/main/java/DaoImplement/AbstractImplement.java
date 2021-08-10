package DaoImplement;

import java.sql.SQLException;
import java.util.ArrayList;

import Mapper.RowMapper;

public interface AbstractImplement<T> {
	ArrayList<T> query(String SQL,RowMapper<T> rowMapper,Object... parameters) throws SQLException;
	int queryCount(String SQL) throws SQLException;
}
