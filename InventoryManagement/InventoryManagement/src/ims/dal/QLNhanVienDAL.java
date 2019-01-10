/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import ims.dto.DanToc;
import ims.dto.HoKhau;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author agfor
     */
public class QLNhanVienDAL extends Database{
   private final Database db = new Database();
   public static Connection conn = null;
   public static Statement stmt = null;;
   public ArrayList<NhanVien> readEmployee() {
        ArrayList<NhanVien> emlist = new ArrayList<>();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT MaNhanVien, TenDem, Ten,NgaySinh,MaNoiSinh FROM nhanvien";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                NhanVien em = new NhanVien();
                em.setMaNhanVien(rs.getString("MaNhanVien"));
                em.setTenDem(rs.getString("TenDem"));
                em.setTen(rs.getString("Ten"));
                em.setNgaySinh(rs.getDate("NgaySinh"));
                em.setMaNoiSinh(rs.getString("MaNoiSinh"));
                emlist.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return emlist;
        }

    }
   public byte[] getImageFromDB() {
        ImageIcon newImage;
        conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `nhanvien`";
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                byte[] img = rs.getBytes("img");
                return img;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
   public ArrayList<QuanHuyen> readQuanHuyen() {
        ArrayList<QuanHuyen> emlist = new ArrayList<>();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT TenQuanHuyen FROM quanhuyen";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                QuanHuyen em = new QuanHuyen();  
                em.setTenQuanHuyen(rs.getString("TenQuanHuyen"));
                emlist.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return emlist;
        }

    }
   public ArrayList<NoiCapCMT> readNoiCap() {
        ArrayList<NoiCapCMT> emlist = new ArrayList<>();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT NoiCap FROM nopcap";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                NoiCapCMT em = new NoiCapCMT();  
                em.setNoiCapCMT(rs.getString("NoiCap"));
                emlist.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return emlist;
        }

    }
   public ArrayList<NguyenQuan> readNguyenQuan() {
        ArrayList<NguyenQuan> emlist = new ArrayList<>();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT TenNguyenQuan FROM nguyenquan";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                NguyenQuan em = new NguyenQuan();  
                em.setNguyenQuan(rs.getString("TenNguyenQuan"));
                emlist.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return emlist;
        }

    }
   public ArrayList<DanToc> readDanToc() {
        ArrayList<DanToc> emlist = new ArrayList<>();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT TenDanToc FROM dantoc";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                DanToc em = new DanToc();  
                em.setTenDanToc(rs.getString("TenDanToc"));
                emlist.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return emlist;
        }

    }
   public ArrayList<TonGiao> readTonGiao() {
        ArrayList<TonGiao> emlist = new ArrayList<>();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT TenTonGiao FROM tongiao";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                TonGiao em = new TonGiao();  
                em.setTonGiao(rs.getString("TenTonGiao"));
                emlist.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return emlist;
        }

    }
   public ArrayList<HoKhau> readHoKhau() {
        ArrayList<HoKhau> emlist = new ArrayList<>();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT TenHoKhau FROM hokhau";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                HoKhau em = new HoKhau();  
                em.setTenThanhPho(rs.getString("TenHoKhau"));
                emlist.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return emlist;
        }

    }
   public ArrayList<NoiSinh> readNoiSinh() {
        ArrayList<NoiSinh> emlist = new ArrayList<>();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT TenNoiSinh FROM noisinh";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                NoiSinh em = new NoiSinh();  
                em.setTenNoiSinh(rs.getString("TenNoiSinh"));
                emlist.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return emlist;
        }

    }
   public ArrayList<QuocTich> readQuocTich() {
        ArrayList<QuocTich> emlist = new ArrayList<>();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT TenQuocTich FROM quoctich";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                QuocTich em = new QuocTich();  
                em.setQuocTich(rs.getString("TenQuocTich"));
                emlist.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return emlist;
        }

    }
   public ArrayList<TinhTrangHonNhan> readHonNhan() {
        ArrayList<TinhTrangHonNhan> emlist = new ArrayList<>();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT TenTinhTrang FROM honnhan";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                TinhTrangHonNhan em = new TinhTrangHonNhan();  
                em.setTinhTrang(rs.getString("TenTinhTrang"));
                emlist.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return emlist;
        }

    }
   public ArrayList<VanHoa> readVanHoa() {
        ArrayList<VanHoa> emlist = new ArrayList<>();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT TenVanHoa FROM vanhoa";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                VanHoa em = new VanHoa();  
                em.setVanHoa(rs.getString("TenVanHoa"));
                emlist.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return emlist;
        }

    }
   public ArrayList<TrinhDoHocVan> readHocVan() {
        ArrayList<TrinhDoHocVan> emlist = new ArrayList<>();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT TenHocVan FROM hocvan";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                TrinhDoHocVan em = new TrinhDoHocVan();  
                em.setTrinhDoHocVan(rs.getString("TenHocVan"));
                emlist.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return emlist;
        }

    }
   public QuanHuyen getQuanHuyenDAL(String tenQuanHuyen) {
        QuanHuyen gT = new QuanHuyen();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT MaQuanHuyen, TenQuanHuyen FROM quanhuyen WHERE TenQuanHuyen = '" + tenQuanHuyen + "'";
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                gT.setMaQuanHuyen(rs.getString("MaQuanHuyen"));
                gT.setTenQuanHuyen(rs.getString("TenQuanHuyen"));
            }
        } catch (SQLException e) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, e);           
        }   finally {
            return gT;
        }
    }
   public NoiCapCMT getNoiCapDAL(String tenNoiCap) {
        NoiCapCMT gT = new NoiCapCMT();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT MaNoiCap, NoiCap FROM nopcap WHERE NoiCap = '" + tenNoiCap + "'";
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                gT.setMaNoiCapCMT(rs.getString("MaNoiCap"));
                gT.setNoiCapCMT(rs.getString("NoiCap"));
            }
        } catch (SQLException e) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, e);           
        }   finally {
            return gT;
        }
    }
   public DanToc getDanTocDAL(String tenDanToc) {
        DanToc gT = new DanToc();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT MaDanToc, TenDanToc FROM dantoc WHERE TenDanToc = '" + tenDanToc + "'";
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                gT.setMaDanToc(rs.getString("MaDanToc"));
                gT.setTenDanToc(rs.getString("TenDanToc"));
            }
        } catch (SQLException e) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, e);           
        }   finally {
            return gT;
        }
    }
   public TrinhDoHocVan getHocVanDAL(String tenHocVan) {
        TrinhDoHocVan gT = new TrinhDoHocVan();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT MaHocVan, TenHocVan FROM hocvan WHERE TenHocVan = '" + tenHocVan + "'";
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                gT.setMaTrinhDoHocVan(rs.getString("MaHocVan"));
                gT.setTrinhDoHocVan(rs.getString("TenHocVan"));
            }
        } catch (SQLException e) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, e);           
        }   finally {
            return gT;
        }
    }
   public HoKhau getHoKhauDAL(String tenHoKhau) {
        HoKhau gT = new HoKhau();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT MaHoKhau, TenHoKhau FROM hokhau WHERE TenHoKhau = '" + tenHoKhau + "'";
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                gT.setMaThanhPho(rs.getString("MaHoKhau"));
                gT.setTenThanhPho(rs.getString("TenHoKhau"));
            }
        } catch (SQLException e) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, e);           
        }   finally {
            return gT;
        }
    }
   public TinhTrangHonNhan getHonNhanDAL(String tenTinhTrang) {
        TinhTrangHonNhan gT = new TinhTrangHonNhan();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT MaTinhTrangHonNhan, TenTinhTrang FROM honnhan WHERE TenTinhTrang = '" + tenTinhTrang + "'";
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                gT.setMaTinhTrang(rs.getString("MaTinhTrangHonNhan"));
                gT.setTinhTrang(rs.getString("TenTinhTrang"));
            }
        } catch (SQLException e) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, e);           
        }   finally {
            return gT;
        }
    }
   public NguyenQuan getNguyenQuanDAL(String tenNguyenQuan) {
        NguyenQuan gT = new NguyenQuan();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT MaNguyenQuan, TenNguyenQuan FROM nguyenquan WHERE TenNguyenQuan = '" + tenNguyenQuan + "'";
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                gT.setMaNguyenQuan(rs.getString("MaNguyenQuan"));
                gT.setNguyenQuan(rs.getString("TenNguyenQuan"));
            }
        } catch (SQLException e) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, e);           
        }   finally {
            return gT;
        }
    }
   public NoiSinh getNoiSinhDAL(String tenNoiSinh) {
        NoiSinh gT = new NoiSinh();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT MaNoiSinh, TenNoiSinh FROM noisinh WHERE TenNoiSinh = '" + tenNoiSinh + "'";
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                gT.setMaNoiSinh(rs.getString("MaNoiSinh"));
                gT.setTenNoiSinh(rs.getString("TenNoiSinh"));
            }
        } catch (SQLException e) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, e);           
        }   finally {
            return gT;
        }
    }
   public QuocTich getQuocTichDAL(String tenQuocTich) {
        QuocTich gT = new QuocTich();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT MaQuocTich, TenQuocTich FROM quoctich WHERE TenQuocTich = '" + tenQuocTich + "'";
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                gT.setMaQuocTich(rs.getString("MaQuocTich"));
                gT.setQuocTich(rs.getString("TenQuocTich"));
            }
        } catch (SQLException e) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, e);           
        }   finally {
            return gT;
        }
    }
   public TonGiao getTonGiaoDAL(String tenTonGiao) {
        TonGiao gT = new TonGiao();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT MaTonGiao, TenTonGiao FROM tongiao WHERE TenTonGiao = '" + tenTonGiao + "'";
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                gT.setMaTonGiao(rs.getString("MaTonGiao"));
                gT.setTonGiao(rs.getString("TenTonGiao"));
            }
        } catch (SQLException e) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, e);           
        }   finally {
            return gT;
        }
    }
   public VanHoa getVanHoaDAL(String tenVanHoa) {
        VanHoa gT = new VanHoa();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT MaVanHoa, TenVanHoa FROM vanhoa WHERE TenVanHoa = '" + tenVanHoa + "'";
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                gT.setMaVanHoa(rs.getString("MaVanHoa"));
                gT.setVanHoa(rs.getString("TenVanHoa"));
            }
        } catch (SQLException e) {
            Logger.getLogger(QLNhanVienDAL.class.getName()).log(Level.SEVERE, null, e);           
        }   finally {
            return gT;
        }
    }
   public void deleteNhanVienDAL(String id) {
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            String sql = "DELETE FROM nhanvien WHERE MaNhanVien = " + id;
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   }
     public void addNewNhanVienDAL(NhanVien nhanVien){
        conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
          //  InputStream hinhAnh = new FileInputStream(new File(nhanVien.getImg()));
            String maNV = nhanVien.getMaNhanVien();
            String maSoThue = nhanVien.getMaSoThue();
            int dienThoai = nhanVien.getDienThoai();
            String soTaiKhoan = nhanVien.getSoTaiKhoan();
            String maQuanHuyen = nhanVien.getMaQuanHuyen();
            int chungMinhThu = nhanVien.getChungMinhThu();
            String maNoiCap = nhanVien.getMaNoiCap();
            String maDanToc = nhanVien.getMaDantoc();
            String maNguyenQuan = nhanVien.getMaNguyenQuan();
            String maTonGiao = nhanVien.getMaTonGiao();
            String thuongTru = nhanVien.getThuongTru();
            String maHoKhau = nhanVien.getMaHoKhau();
            String tenDem = nhanVien.getTenDem();
            String tenHo = nhanVien.getTen();
            String maNoiSinh = nhanVien.getMaNoiSinh();
            String tamTru = nhanVien.getTamTru();
            String maQuocTich = nhanVien.getMaQuocTich();
            String maTinhTrangHonNhan = nhanVien.getMaTinhTrangHonNhan();
            int diDong = nhanVien.getDiDong();
            String maVanHoa = nhanVien.getMaVanHoa();
            String maHocVan = nhanVien.getMaHocVan();
            String eMail = nhanVien.geteMail();
            String chucVuDoan = nhanVien.getChucVuDoan();
            String noiSinhHoatDoan = nhanVien.getNoiSinhHoatDoan();
            String chucVuDang = nhanVien.getChucVuDang();
            String noiSinhHoatDang = nhanVien.getChucVuDang();
            String noiSinHoatQuanDoi = nhanVien.getNoiSinhHoat();
            String ghiChu = nhanVien.getGhiChu();
            Date ngaySinh = nhanVien.getNgaySinh();
            Date ngayNhapDoan = nhanVien.getNgayNhapDoan();
            Date ngayNhapDang = nhanVien.getNgayNhapDang();
            Date ngayNhapNgu = nhanVien.getNgayNhapNgu();
            Date ngayXuatNgu = nhanVien.getNgayXuatNgu();
            Date ngayCap = nhanVien.getNgayCap();
            String gioiTinh = nhanVien.getGioiTinh();
            String hinhAnh = nhanVien.getImg();
            
            String sql = "INSERT INTO `nhanvien`(`MaNhanVien`, `SoTaiKhoan`, `MaSoThue`,`MaQuanHuyen`,`DienThoai`,`CMND`,`MaNoiCap`,`MaNguyenQuan`,`MaDanToc`,`MaTonGiao`,`ThuongTru`,`MaHoKhau`,`TenDem`,`Ten`,`GioiTinh`,`NgaySinh`,`MaNoiSinh`,`TamTru`,`MaQuocTich`,`MaTinhTrangHonNhan`,`NgayNhapDoan`,`ChucVuDoan`,`NoiSinhHoatDoan`,`NgayNhapDang`,`ChucVuDang`,`NoiSinhHoatDang`,`NgayNhapNgu`,`NgayXuatNgu`,`NoiSinhHoat`,`HinhAnh`,`GhiTru`,`MaVanHoa`,`MaHocVan`,`DiDong`,`NgayCap`) VALUES ('"+ maNV +"','"+ soTaiKhoan +"','"+ maSoThue +"','"+ maQuanHuyen +"','"+ dienThoai +"','"+ chungMinhThu +"','"+ maNoiCap +"','"+ maNguyenQuan +"','"+ maDanToc +"','"+ maTonGiao +"','"+ thuongTru +"','"+ maHoKhau +"','"+ tenDem +"','"+ tenHo +"','"+ gioiTinh +"','"+ ngaySinh +"','"+ maNoiSinh +"','"+ tamTru +"','"+ maQuocTich +"','"+ maTinhTrangHonNhan +"','"+ ngayNhapDoan +"','"+ chucVuDoan +"','"+ noiSinhHoatDoan +"','"+ ngayNhapDang +"','"+ chucVuDang +"','"+ noiSinhHoatDang +"','"+ ngayNhapNgu +"','"+ ngayXuatNgu +"','"+ noiSinHoatQuanDoi +"','"+ hinhAnh +"','"+ ghiChu +"','"+ maVanHoa +"','"+ maHocVan +"','"+ diDong +"','"+ ngayCap +"')";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
     
   
    
   
    
}
