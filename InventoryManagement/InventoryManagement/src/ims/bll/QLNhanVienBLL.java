/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import ims.dal.QLNhanVienDAL;
import ims.dto.DanToc;
import ims.dto.HoKhau;
import ims.dto.ListNhanVien;
import ims.dto.NguyenQuan;
import ims.dto.NhanVien;
import ims.dto.NoiCapCMT;
import ims.dto.NoiSinh;
import ims.dto.QuanHuyen;
import ims.dto.QuocTich;
import ims.dto.TinhTrangHonNhan;
import ims.dto.TonGiao;
import ims.dto.TrinhDoHocVan;
import ims.dto.VanHoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author agfor
 */
public class QLNhanVienBLL {
    QLNhanVienDAL dal = new QLNhanVienDAL();

    public ArrayList<NhanVien> ReadEmployeeBll() {
        ArrayList<NhanVien> listEmployee = new ArrayList<>();
        listEmployee = dal.readEmployee();
        return listEmployee;
    }
    public QuanHuyen getQuanHuyenBLL(String tenQuanHuyen) {
         QuanHuyen gT = new QuanHuyen();
         gT = dal.getQuanHuyenDAL(tenQuanHuyen);
         return gT;
     }
    public NoiCapCMT getNoiCapBLL(String tenNoiCap) {
         NoiCapCMT gT = new NoiCapCMT();
         gT = dal.getNoiCapDAL(tenNoiCap);
         return gT;
     }
    public DanToc getDanTocBLL(String tenDanToc) {
         DanToc gT = new DanToc();
         gT = dal.getDanTocDAL(tenDanToc);
         return gT;
     }
    public TrinhDoHocVan getHocVanBLL(String tenHocVan) {
         TrinhDoHocVan gT = new TrinhDoHocVan();
         gT = dal.getHocVanDAL(tenHocVan);
         return gT;
     }
    public HoKhau getHoKhauBLL(String tenHoKhau) {
         HoKhau gT = new HoKhau();
         gT = dal.getHoKhauDAL(tenHoKhau);
         return gT;
     }
    public TinhTrangHonNhan getHonNhanBLL(String tenTinhTrang) {
         TinhTrangHonNhan gT = new TinhTrangHonNhan();
         gT = dal.getHonNhanDAL(tenTinhTrang);
         return gT;
     }
    public NguyenQuan getNguyenQuanBLL(String tenNguyenQuan) {
         NguyenQuan gT = new NguyenQuan();
         gT = dal.getNguyenQuanDAL(tenNguyenQuan);
         return gT;
     }
    public NoiSinh getNoiSinhBLL(String tenNoiSinh) {
         NoiSinh gT = new NoiSinh();
         gT = dal.getNoiSinhDAL(tenNoiSinh);
         return gT;
     }
    public QuocTich getQuocTichBLL(String tenQuocTich) {
         QuocTich gT = new QuocTich();
         gT = dal.getQuocTichDAL(tenQuocTich);
         return gT;
     }
    public TonGiao getTonGiaoBLL(String tenTonGiao) {
         TonGiao gT = new TonGiao();
         gT = dal.getTonGiaoDAL(tenTonGiao);
         return gT;
     }
    public VanHoa getVanHoaBLL(String tenVanHoa) {
         VanHoa gT = new VanHoa();
         gT = dal.getVanHoaDAL(tenVanHoa);
         return gT;
     }
    public byte[] getImageFromDB() {
        if (dal.getImageFromDB() != null) {
            return dal.getImageFromDB();
        } else {
            JOptionPane.showMessageDialog(null, "File not found");
            throw new NumberFormatException("File not found");
        }
    }
//       public ListNhanVien readEmployeeList() {
//        ResultSet rs = dal.readEmployeeId();
//        ListNhanVien list = new ListNhanVien();
//        try {
//            while (rs.next()) {
//          
//                
//                NhanVien nV = new NhanVien();
//                nV.setMaNhanVien(rs.getString("MaNhanVien"));
//                nV.setSoTaiKhoan(rs.getString("SoTaiKhoan"));
//                nV.setMaSoThue(rs.getString("MaSoThue"));
//                nV.setMaQuanHuyen(rs.getString("MaQuanHuyen"));
//                nV.setDienThoai(rs.getInt("DienThoai"));
//                nV.setChungMinhThu(rs.getInt("CMND"));
//                nV.setMaNoiCap(rs.getString("MaNoiCap"));
//                nV.setMaNguyenQuan(rs.getString("MaNguyenQuan"));
//                nV.setMaDantoc(rs.getString("MaDanToc"));
//                nV.setMaTonGiao(rs.getString("MaTonGiao"));
//                nV.setThuongTru(rs.getString("ThuongTru"));
//                nV.setMaHoKhau(rs.getString("MaHoKhau"));
//                nV.setTenDem(rs.getString("TenDem"));
//                nV.setTen(rs.getString("Ten"));
//                nV.setGioiTinh(rs.getString("GioiTinh"));
//                nV.setNgaySinh(rs.getDate("NgaySinh"));
//                nV.setMaNoiSinh(rs.getString("MaNoiSinh"));
//                nV.setTamTru(rs.getString("TamTru"));
//                nV.setMaQuocTich(rs.getString("MaQuocTich"));
//                nV.setMaTinhTrangHonNhan(rs.getString("MaTinhTrangHonNhan"));
//                nV.setNgayNhapDoan(rs.getDate("NgayNhapDoan"));
//                nV.setChucVuDoan(rs.getString("ChucVuDoan"));
//                nV.setNoiSinhHoatDoan(rs.getString("NoiSinhHoatDoan"));
//                nV.setNgayNhapDang(rs.getDate("NgayNhapDang"));
//                nV.setNoiSinhHoatDang(rs.getString("NoiSinhHoatDang"));
//                nV.setChucVuDang(rs.getString("ChucVuDang"));
//                nV.setNgayNhapNgu(rs.getDate("NgayNhapNgu"));
//                nV.setNgayXuatNgu(rs.getDate("NgayXuatNgu"));
//                nV.setNoiSinhHoat(rs.getString("NoiSinhHoat"));
//                nV.setImg(rs.getString("HinhAnh"));
//                nV.setGhiChu(rs.getString("GhiTru"));
//                nV.setMaVanHoa(rs.getString("MaVanHoa"));
//                nV.setMaHocVan(rs.getString("MaHocVan"));
//                nV.setDiDong(rs.getInt("DiDong"));
//                nV.setNgayCap(rs.g("NgayCap"));
//                
//
//                list.listEmployee.add(epl);
//            }
//            return list;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(null, "Không thấy ảnh");
//            ex.printStackTrace();
//        }
//        return null;
//    }
     


    public void addNewNhanVienBLL(NhanVien nhanVien) {
        dal.addNewNhanVienDAL(nhanVien);
    }
    public void deleteNhanVienBLL(String id) {
        dal.deleteNhanVienDAL(id);
    }
}
