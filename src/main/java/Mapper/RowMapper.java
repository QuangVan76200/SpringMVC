package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
	T rowMapper(ResultSet resultSet) throws SQLException;
}
