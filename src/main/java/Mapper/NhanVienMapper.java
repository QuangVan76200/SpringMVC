package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.NhanVienModel;

public class NhanVienMapper implements RowMapper<NhanVienModel>{

	public NhanVienModel rowMapper(ResultSet resultSet) throws SQLException {
		NhanVienModel nhanvien= new NhanVienModel();
		nhanvien.setManNV(resultSet.getString("ManNV"));
		nhanvien.setHoTen(resultSet.getString("HoTen"));
		nhanvien.setNgaySinh(resultSet.getString("NgaySinh"));
		nhanvien.setMaPhong(resultSet.getString("MaPhong"));
		return nhanvien;
	}
	
}
