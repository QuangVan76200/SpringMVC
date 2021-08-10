package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DaoImplement.AbstractImplement;
import Mapper.RowMapper;

public class GenericDao<T> implements AbstractImplement<T> {

	
	private static Connection connection =null;
	private static PreparedStatement preparedStatement =null;
	private static ResultSet resultSet= null;
	static final String URL="jdbc:sqlserver://localhost:1433;databaseName=QLNV;integratedSecurity=false;";
	static final String user="DemoDB1";
	static final String pass="quangvan123";
	
  
         private Connection conncetion() throws SQLException{
        	 if(connection ==null)
        	 {
        		 try {
 					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 					return DriverManager.getConnection(URL, user, pass);
 				} catch (SQLException | ClassNotFoundException e) {
 					return null;
 	         }
        	 }
        	 return null;
        
         }


		public ArrayList<T> query(String SQL, RowMapper<T> rowMapper, Object... parameters) throws SQLException {
			if(connection==null) {
				try {
					ArrayList<T> result=new ArrayList<T>();
					connection=conncetion();
					preparedStatement = connection.prepareStatement(SQL);
					setStatement(preparedStatement,parameters);
					resultSet=preparedStatement.executeQuery();
					while(resultSet.next())
					{
						result.add((T)rowMapper.rowMapper(resultSet));
					}

					return result;
				} catch (SQLException e) {
					return null;
				}finally {
					close();
				}
			}
			return null;
		}
		void close() {
			if(connection !=null)
				connection=null;
			if(resultSet !=null)
				resultSet=null;
			if(preparedStatement !=null)
				preparedStatement=null;
		}
		public int queryCount(String SQL) throws SQLException {
			if(connection==null) {
				try {
					
					connection=conncetion();
					preparedStatement = connection.prepareStatement(SQL);
					resultSet=preparedStatement.executeQuery();
					int count=0;
					while(resultSet.next())
					{
						count=resultSet.getInt(1);
					}

					return count;
				} catch (SQLException e) {
					return 0;
				}finally {
					close();
				}
			}
			return 0;
		}

		private void setStatement(PreparedStatement preparedStatement, Object[] parameters)throws SQLException {
			for(int i =0;i<parameters.length;i++)
			{
				if(parameters[i] instanceof String )
					preparedStatement.setString(i+1,parameters[i].toString());
			}
			
		}


		
}