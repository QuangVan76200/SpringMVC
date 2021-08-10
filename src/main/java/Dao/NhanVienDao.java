package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import DaoImplement.NhanVienImplement;
import Mapper.NhanVienMapper;
import Model.NhanVienModel;

public class NhanVienDao extends GenericDao<NhanVienModel> implements NhanVienImplement {

	public ArrayList<NhanVienModel> findNhanVien(String SQL, Object... parameters)throws SQLException {
		return query(SQL, new NhanVienMapper(), parameters) ;
	}
	public int countEmployee(String SQL)throws SQLException{
		close();
		return queryCount(SQL);//select COUNT('ManNV')from NhanVien;
	}

}
