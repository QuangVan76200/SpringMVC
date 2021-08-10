package DaoImplement;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.NhanVienModel;

public interface NhanVienImplement {
	public ArrayList<NhanVienModel> findNhanVien(String SQL,Object... parameters)throws SQLException;
	public int countEmployee(String SQL)throws SQLException;
}
