package Web.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Dao.NhanVienDao;
import Model.NhanVienModel;


@org.springframework.stereotype.Controller
public class Controller extends HttpServlet {
	
	@RequestMapping(value="/Hello")
	public String Test1(ModelMap modelMap,HttpServletResponse resp,HttpServletRequest req,@RequestParam (name="page") int page)  throws ServletException, IOException{
		try {
			NhanVienDao nhanvien= new NhanVienDao();
			ArrayList<NhanVienModel> List =nhanvien.findNhanVien("Select * from NhanVien");
			int countEmployee=(nhanvien.countEmployee("select COUNT('ManNV')from NhanVien "));
			req.setAttribute("List", List);
			req.setAttribute("countEmployee", countEmployee);
			modelMap.addAttribute("message", "Kết Nối Thành Công");
			
			
		} catch (SQLException e) {
			modelMap.addAttribute("message", "Kết Nối Thất Bại");
		}
		return"Hello";
		
	}
	@RequestMapping(value="/Home")
	public String Home() {
		return"Home";
	}
	public static void main(String[] args) throws SQLException {
		NhanVienDao nhanvien= new NhanVienDao();
		ArrayList<NhanVienModel> List =nhanvien.findNhanVien("Select * from NhanVien");
		int countEmployee=(nhanvien.countEmployee("select COUNT('ManNV')from NhanVien "));
		System.out.println(countEmployee);
	}
	
}
