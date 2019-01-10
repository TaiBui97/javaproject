/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.gui;

import ims.bll.QLNhanVienBLL;
import ims.dal.QLNhanVienDAL;
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
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author NAT
 */
public class Employee extends javax.swing.JFrame {

    private ResultSet result;
    private final QLNhanVienDAL nhanVienDAL = new QLNhanVienDAL();
    private final QLNhanVienBLL nhanVienBLL = new QLNhanVienBLL();

    private final NhanVien nhanVien = new NhanVien();
    private QuanHuyen qHuyen = new QuanHuyen();
    private DanToc dToc = new DanToc();
    private HoKhau hKhau = new HoKhau();
    private NguyenQuan nQuan = new NguyenQuan();
    private NoiCapCMT cMT = new NoiCapCMT();
    private NoiSinh nSinh = new NoiSinh();
    private QuocTich qTich = new QuocTich();
    private TinhTrangHonNhan hNhan = new TinhTrangHonNhan();
    private TonGiao tGiao = new TonGiao();
    private TrinhDoHocVan hVan = new TrinhDoHocVan();
    private VanHoa vHoa = new VanHoa();
    
    DefaultComboBoxModel modelTinhThanh = new DefaultComboBoxModel();
    DefaultComboBoxModel modelQuanHuyen = new DefaultComboBoxModel();
    DefaultComboBoxModel modelQuocTich = new DefaultComboBoxModel();
    DefaultComboBoxModel modelTTHN = new DefaultComboBoxModel();
    DefaultComboBoxModel modelVanHoa = new DefaultComboBoxModel();
    DefaultComboBoxModel modelTrinhDoHV = new DefaultComboBoxModel();
    DefaultComboBoxModel modelNoiCap = new DefaultComboBoxModel();
    DefaultComboBoxModel modelNguyenQuan = new DefaultComboBoxModel();
    DefaultComboBoxModel modelDanToc = new DefaultComboBoxModel();
    DefaultComboBoxModel modelTonGiao = new DefaultComboBoxModel();
    String imgPath;

    /**
     * Creates new form Employee
     */
    public Employee() {
        initComponents();
        stateButton(true);
        setInfoDialog();

    }
    public int getCbId(String id, DefaultComboBoxModel model) {
        NoiSinh item = new NoiSinh();
        for (int i = 0; i < model.getSize(); i++) {
            item = (NoiSinh) model.getElementAt(i);
            if (item.getMaNoiSinh().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return 0;
    }

    Employee(NhanVien nv) {
       initComponents();
       setTitle("Sửa nhân viên");
       stateButton(false);
       //Format formatter = new SimpleDateFormat("yyyy-MM-dd");


       txtMaNhanVien.setText(nv.getMaNhanVien());
       txtSTK.setText(nv.getSoTaiKhoan());
       txtMsThue.setText(nv.getMaSoThue());
       txtDienThoai.setText(String.valueOf(nv.getDienThoai()));
       txtCMND.setText(String.valueOf(nv.getChungMinhThu()));
     //  txtNgayCap.setText(formatter.format(nv.getNgayCap()));
       txtThuongTru.setText(nv.getThuongTru());
       txtGhiChu.setText(nv.getGhiChu());
       txtTenDem.setText(nv.getTenDem());
       txtTen.setText(nv.getTen());
       txtEmail.setText(nv.geteMail());
//       txtNgaySinh.setText(formatter.format(nv.getNgaySinh()));
//       txtNgayGiaNhapDoan.setText(formatter.format(nv.getNgayNhapDoan()));
//       txtNgayGiaNhapDang.setText(formatter.format(nv.getNgayNhapDang()));
//       txtNgayXuatNgu.setText(formatter.format(nv.getNgayXuatNgu()));
//       txtNgayNhapNgu.setText(formatter.format(nv.getNgayNhapNgu()));
       txtDiDong.setText(String.valueOf(nv.getDiDong()));
       txtChucVuDoan.setText(nv.getChucVuDoan());
       txtChucVuDang.setText(nv.getChucVuDang());
       txtNoiSinhHoatDoan.setText(nv.getNoiSinhHoatDoan());
       txtNoiSinhHoatDang.setText(nv.getNoiSinhHoatDang());
       txtNoiSinhHoatQuanDoi.setText(nv.getNoiSinhHoat());
       
        cboNoiSinh.setSelectedItem(modelTinhThanh.getElementAt(getCbId(nv.getMaNoiSinh(), modelTinhThanh)));
        ImageIcon image = new ImageIcon(nv.getImgByte());
        Image im = image.getImage();
        Image myImg = im.getScaledInstance(lbAnh.getWidth(), lbAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);
        lbAnh.setIcon(newImage);

    }

    public void setDataQuanHuyenComboBox() {
        cboQuanHuyen.removeAllItems();
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cboQuanHuyen.getModel();
        ArrayList<QuanHuyen> ls = nhanVienDAL.readQuanHuyen();
        QuanHuyen qh = new QuanHuyen();
        for (int i = 0; i < ls.size(); i++) {
            qh = ls.get(i);
            comboModel.addElement(qh.getTenQuanHuyen());
        }
        ls.clear();
    }

    public void setDataNoiCapComboBox() {
        cboNoiCap.removeAllItems();
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cboNoiCap.getModel();
        ArrayList<NoiCapCMT> ls = nhanVienDAL.readNoiCap();
        NoiCapCMT nc = new NoiCapCMT();
        for (int i = 0; i < ls.size(); i++) {
            nc = ls.get(i);
            comboModel.addElement(nc.getNoiCapCMT());
        }
        ls.clear();
    }

    public void setDataNguyenQuanComboBox() {
        cboNguyenQuan.removeAllItems();
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cboNguyenQuan.getModel();
        ArrayList<NguyenQuan> ls = nhanVienDAL.readNguyenQuan();
        NguyenQuan nq = new NguyenQuan();
        for (int i = 0; i < ls.size(); i++) {
            nq = ls.get(i);
            comboModel.addElement(nq.getNguyenQuan());
        }
        ls.clear();
    }

    public void setDataDanTocComboBox() {
        cboDanToc.removeAllItems();
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cboDanToc.getModel();
        ArrayList<DanToc> ls = nhanVienDAL.readDanToc();
        DanToc qh = new DanToc();
        for (int i = 0; i < ls.size(); i++) {
            qh = ls.get(i);
            comboModel.addElement(qh.getTenDanToc());
        }
        ls.clear();
    }

    public void setDataTonGiaoComboBox() {
        cboTonGiao.removeAllItems();
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cboTonGiao.getModel();
        ArrayList<TonGiao> ls = nhanVienDAL.readTonGiao();
        TonGiao qh = new TonGiao();
        for (int i = 0; i < ls.size(); i++) {
            qh = ls.get(i);
            comboModel.addElement(qh.getTonGiao());
        }
        ls.clear();
    }

    public void setDataHoKhauComboBox() {
        cboHoKhau.removeAllItems();
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cboHoKhau.getModel();
        ArrayList<HoKhau> ls = nhanVienDAL.readHoKhau();
        HoKhau qh = new HoKhau();
        for (int i = 0; i < ls.size(); i++) {
            qh = ls.get(i);
            comboModel.addElement(qh.getTenThanhPho());
        }
        ls.clear();
    }

    public void setDataNoiSinhComboBox() {
        cboNoiSinh.removeAllItems();
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cboNoiSinh.getModel();
        ArrayList<NoiSinh> ls = nhanVienDAL.readNoiSinh();
        NoiSinh qh = new NoiSinh();
        for (int i = 0; i < ls.size(); i++) {
            qh = ls.get(i);
            comboModel.addElement(qh.getTenNoiSinh());
        }
        ls.clear();
    }

    public void setDataQuocTichComboBox() {
        cboQuocTich.removeAllItems();
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cboQuocTich.getModel();
        ArrayList<QuocTich> ls = nhanVienDAL.readQuocTich();
        QuocTich qh = new QuocTich();
        for (int i = 0; i < ls.size(); i++) {
            qh = ls.get(i);
            comboModel.addElement(qh.getQuocTich());
        }
        ls.clear();
    }

    public void setDataHonNhanComboBox() {
        cboHonNhan.removeAllItems();
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cboHonNhan.getModel();
        ArrayList<TinhTrangHonNhan> ls = nhanVienDAL.readHonNhan();
        TinhTrangHonNhan qh = new TinhTrangHonNhan();
        for (int i = 0; i < ls.size(); i++) {
            qh = ls.get(i);
            comboModel.addElement(qh.getTinhTrang());
        }
        ls.clear();
    }

    public void setDataVanHoaComboBox() {
        cboVanHoa.removeAllItems();
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cboVanHoa.getModel();
        ArrayList<VanHoa> ls = nhanVienDAL.readVanHoa();
        VanHoa qh = new VanHoa();
        for (int i = 0; i < ls.size(); i++) {
            qh = ls.get(i);
            comboModel.addElement(qh.getVanHoa());
        }
        ls.clear();
    }

    public void setDataHocVanComboBox() {
        cboHocVan.removeAllItems();
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cboHocVan.getModel();
        ArrayList<TrinhDoHocVan> ls = nhanVienDAL.readHocVan();
        TrinhDoHocVan qh = new TrinhDoHocVan();
        for (int i = 0; i < ls.size(); i++) {
            qh = ls.get(i);
            comboModel.addElement(qh.getTrinhDoHocVan());
        }
        ls.clear();
    }

    public void setInfoDialog() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
        setResizable(false);
    }

    public void stateButton(boolean value) {

//        btNew.setVisible(value);
//        btEdit.setVisible(value);
//        btDelete.setVisible(value);
//        btPrint.setVisible(value);
//        btClose.setVisible(value);
        btSave.setVisible(value);
        btCancel.setVisible(value);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        btSave = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        lbAnh = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        txtMaNhanVien = new javax.swing.JTextField();
        txtSTK = new javax.swing.JTextField();
        txtMsThue = new javax.swing.JTextField();
        txtDienThoai = new javax.swing.JTextField();
        cboQuanHuyen = new javax.swing.JComboBox();
        txtCMND = new javax.swing.JTextField();
        txtNgayCap = new javax.swing.JTextField();
        cboNoiCap = new javax.swing.JComboBox();
        cboNguyenQuan = new javax.swing.JComboBox();
        cboDanToc = new javax.swing.JComboBox();
        cboTonGiao = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtThuongTru = new javax.swing.JTextArea();
        cboHoKhau = new javax.swing.JComboBox();
        txtTenDem = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        chkNam = new javax.swing.JCheckBox();
        chkNu = new javax.swing.JCheckBox();
        cboNoiSinh = new javax.swing.JComboBox();
        txtTamTru = new javax.swing.JTextField();
        cboQuocTich = new javax.swing.JComboBox();
        cboHonNhan = new javax.swing.JComboBox();
        txtDiDong = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        cboVanHoa = new javax.swing.JComboBox();
        cboHocVan = new javax.swing.JComboBox();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel27 = new javax.swing.JLabel();
        txtNgayGiaNhapDoan = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtNoiSinhHoatDoan = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtChucVuDoan = new javax.swing.JTextField();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jLabel30 = new javax.swing.JLabel();
        txtNgayGiaNhapDang = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtNoiSinhHoatDang = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtChucVuDang = new javax.swing.JTextField();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jLabel33 = new javax.swing.JLabel();
        txtNgayNhapNgu = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtNoiSinhHoatQuanDoi = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtNgayXuatNgu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btSave.setText("Ghi");
        btSave.setPreferredSize(new java.awt.Dimension(75, 23));
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 600, 117, 37));

        btCancel.setText("Hủy");
        btCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 600, 118, 37));
        getContentPane().add(lbAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 109, 152));

        jLabel2.setText("Mã nhân viên");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 10, -1, -1));

        jLabel3.setText("Số tài khoản");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 49, -1, -1));

        jLabel4.setText("MS thuế");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 94, -1, -1));

        jLabel5.setText("Quận/Huyện");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 137, -1, -1));

        jLabel6.setText("Điện thoại");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 171, -1, -1));

        jLabel7.setText("CMND/Passport");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 201, -1, -1));

        jLabel8.setText("Ngày cấp");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 242, -1, -1));

        jLabel9.setText("Nơi cấp");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 273, -1, -1));

        jLabel10.setText("Nguyên quán");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 317, -1, -1));

        jLabel11.setText("Dân tộc");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 361, -1, -1));

        jLabel12.setText("Tôn giáo");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 394, -1, -1));

        jLabel13.setText("Thường trú");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 422, -1, -1));

        jLabel14.setText("Hộ khẩu");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 542, -1, -1));

        jLabel15.setText("Họ và tên đệm");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jLabel16.setText("Ngày sinh");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 49, -1, -1));

        jLabel17.setText("Tạm trú");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 94, -1, -1));

        jLabel18.setText("Quốc tịch");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 137, -1, -1));

        jLabel19.setText("Di động");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 171, -1, -1));

        jLabel20.setText("Văn hóa");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 201, -1, -1));

        jLabel21.setText("Tên");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 10, -1, -1));

        jLabel22.setText("Nơi sinh");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(619, 49, -1, -1));

        jLabel23.setText("TT hôn nhân");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 137, -1, -1));

        jLabel24.setText("Email");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(631, 168, -1, -1));

        jLabel25.setText("Trình độ học vấn");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(631, 211, -1, -1));

        jLabel26.setText("*Ghi chú");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 254, -1, -1));

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 292, 109, 271));

        txtMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNhanVienActionPerformed(evt);
            }
        });
        getContentPane().add(txtMaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 6, 135, -1));
        getContentPane().add(txtSTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 45, 135, -1));
        getContentPane().add(txtMsThue, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 90, 135, -1));
        getContentPane().add(txtDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 167, 135, -1));

        cboQuanHuyen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboQuanHuyenItemStateChanged(evt);
            }
        });
        getContentPane().add(cboQuanHuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 132, 135, -1));
        getContentPane().add(txtCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 197, 134, -1));
        getContentPane().add(txtNgayCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 238, 134, -1));

        cboNoiCap.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNoiCapItemStateChanged(evt);
            }
        });
        getContentPane().add(cboNoiCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 268, 134, -1));

        cboNguyenQuan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNguyenQuanItemStateChanged(evt);
            }
        });
        getContentPane().add(cboNguyenQuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 312, 134, -1));

        cboDanToc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboDanTocItemStateChanged(evt);
            }
        });
        getContentPane().add(cboDanToc, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 356, 134, -1));

        cboTonGiao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTonGiaoItemStateChanged(evt);
            }
        });
        getContentPane().add(cboTonGiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 394, 134, -1));

        txtThuongTru.setColumns(20);
        txtThuongTru.setRows(5);
        jScrollPane2.setViewportView(txtThuongTru);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 426, 134, 102));

        cboHoKhau.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboHoKhauItemStateChanged(evt);
            }
        });
        getContentPane().add(cboHoKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 537, 134, -1));
        getContentPane().add(txtTenDem, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 6, 160, -1));
        getContentPane().add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 45, 135, -1));
        getContentPane().add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 6, 113, -1));

        chkNam.setText("Nam");
        chkNam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkNamItemStateChanged(evt);
            }
        });
        getContentPane().add(chkNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(824, 6, -1, -1));

        chkNu.setText("Nữ");
        getContentPane().add(chkNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 6, -1, -1));

        cboNoiSinh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNoiSinhItemStateChanged(evt);
            }
        });
        getContentPane().add(cboNoiSinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(689, 44, 240, -1));
        getContentPane().add(txtTamTru, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 90, 463, -1));

        cboQuocTich.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboQuocTichItemStateChanged(evt);
            }
        });
        getContentPane().add(cboQuocTich, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 132, 135, -1));

        cboHonNhan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboHonNhanItemStateChanged(evt);
            }
        });
        getContentPane().add(cboHonNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(769, 132, 160, -1));
        getContentPane().add(txtDiDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 164, 135, -1));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(668, 164, 261, -1));

        cboVanHoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboVanHoaItemStateChanged(evt);
            }
        });
        getContentPane().add(cboVanHoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 206, 135, -1));

        cboHocVan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboHocVanItemStateChanged(evt);
            }
        });
        getContentPane().add(cboHocVan, new org.netbeans.lib.awtextra.AbsoluteConstraints(742, 206, 187, -1));

        jInternalFrame1.setTitle("Đoàn Thanh Niên");
        jInternalFrame1.setVisible(true);

        jLabel27.setText("Ngày gia nhập");

        jLabel28.setText("Nơi sinh hoạt");

        jLabel29.setText("Chức vụ");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayGiaNhapDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtChucVuDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(txtNoiSinhHoatDoan)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtNgayGiaNhapDoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(txtChucVuDoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28)
                    .addComponent(txtNoiSinhHoatDoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        getContentPane().add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 238, 549, -1));

        jInternalFrame2.setTitle("Đảng Cộng Sản Việt Nam");
        jInternalFrame2.setVisible(true);

        jLabel30.setText("Ngày gia nhập");

        jLabel31.setText("Nơi sinh hoạt");

        jLabel32.setText("Chức vụ");

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayGiaNhapDang, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtChucVuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(txtNoiSinhHoatDang)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtNgayGiaNhapDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(txtChucVuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31)
                    .addComponent(txtNoiSinhHoatDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jInternalFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 549, -1));

        jInternalFrame3.setTitle("Quân đội");
        jInternalFrame3.setVisible(true);

        jLabel33.setText("Ngày nhập ngũ");

        jLabel34.setText("Nơi sinh hoạt");

        jLabel35.setText("Ngày xuất ngũ");

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayNhapNgu, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgayXuatNgu, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(18, 18, 18)
                        .addComponent(txtNoiSinhHoatQuanDoi)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtNgayNhapNgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(txtNgayXuatNgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNoiSinhHoatQuanDoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jInternalFrame3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 549, -1));

        jButton1.setText("Choose...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        stateButton(true);
        try {
            String maNhanVien = txtMaNhanVien.getText();
            String soTaiKhoan = txtSTK.getText();
            String maSoTHue = txtMsThue.getText();
            String dienThoaiStr = txtDienThoai.getText();
            int dienThoai = Integer.parseInt(dienThoaiStr);
            String chungMinhThuStr = txtCMND.getText();
            int chungMinhThu = Integer.parseInt(chungMinhThuStr);
            String ngayCapStr = txtNgayCap.getText();
            String thuongTru = txtThuongTru.getText();
            String tenDem = txtTenDem.getText();
            String hoTen = txtTen.getText();
            String ngaySinhStr = txtNgaySinh.getText();
            String tamTru = txtTamTru.getText();
            String diDongStr = txtDiDong.getText();
            int diDong = Integer.parseInt(diDongStr);
            String eMail = txtEmail.getText();
            String ngayNhapDoanStr = txtNgayGiaNhapDoan.getText();
            String chucVuDoan = txtChucVuDoan.getText();
            String sinhHoatDoan = txtNoiSinhHoatDoan.getText();
            String ngayNhapDangStr = txtNgayGiaNhapDang.getText();
            String chucVuDang = txtChucVuDang.getText();
            String sinhHoatDang = txtNoiSinhHoatDang.getText();
            String ngayNhapNguStr = txtNgayNhapNgu.getText();
            String ngayXuatNguStr = txtNgayXuatNgu.getText();
            String sinhHoatQuanDoi = txtNoiSinhHoatQuanDoi.getText();
            String ghiChu = txtGhiChu.getText();
            String gioiTinh;
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");           
            Date ngayCapDate = (Date) formatter.parse(ngayCapStr);
            java.sql.Date ngaySinh = new java.sql.Date(ngayCapDate.getTime());           
            Date ngaySinhDate = (Date) formatter.parse(ngaySinhStr);
            java.sql.Date ngayCap = new java.sql.Date(ngaySinhDate.getTime());            
            Date ngayNhapDoanDate = (Date) formatter.parse(ngayNhapDoanStr);
            java.sql.Date ngayNhapDoan = new java.sql.Date(ngayNhapDoanDate.getTime());            
            Date ngayNhapDangDate = (Date) formatter.parse(ngayNhapDangStr);
            java.sql.Date ngayNhapDang = new java.sql.Date(ngayNhapDangDate.getTime());           
            Date ngayXuatNguDate = (Date) formatter.parse(ngayXuatNguStr);
            java.sql.Date ngayXuatNgu = new java.sql.Date(ngayXuatNguDate.getTime());            
            Date ngayNhapNguDate = (Date) formatter.parse(ngayNhapNguStr);
            java.sql.Date ngayNhapNgu = new java.sql.Date(ngayNhapNguDate.getTime());
            
            if(chkNam.isSelected()){
                gioiTinh = "Male";
                nhanVien.setGioiTinh(gioiTinh);
            }else if(chkNu.isSelected()){
                gioiTinh = "FeMale";
                nhanVien.setGioiTinh(gioiTinh);
            }
       
            nhanVien.setMaNhanVien(maNhanVien);
            nhanVien.setMaSoThue(maSoTHue);
            nhanVien.setMaQuanHuyen(qHuyen.getMaQuanHuyen());
            nhanVien.setSoTaiKhoan(soTaiKhoan);
            nhanVien.setDienThoai(dienThoai);
            nhanVien.setChungMinhThu(chungMinhThu);
            nhanVien.setNgayCap(ngayCap);
            nhanVien.setMaNoiCap(cMT.getMaNoiCapCMT());
            nhanVien.setMaDantoc(dToc.getMaDanToc());
            nhanVien.setMaNguyenQuan(nQuan.getMaNguyenQuan());
            nhanVien.setMaTonGiao(tGiao.getMaTonGiao());
            nhanVien.setMaNguyenQuan(nQuan.getMaNguyenQuan());
            nhanVien.setThuongTru(thuongTru);
            nhanVien.setMaHoKhau(hKhau.getMaThanhPho());
            nhanVien.setTenDem(tenDem);
            nhanVien.setTen(hoTen);
            nhanVien.setNgaySinh(ngaySinh);
            nhanVien.setMaNoiSinh(nSinh.getMaNoiSinh());
            nhanVien.setTamTru(tamTru);
            nhanVien.setMaQuocTich(qTich.getMaQuocTich());
            nhanVien.setMaTinhTrangHonNhan(hNhan.getMaTinhTrang());
            nhanVien.setDiDong(diDong);
            nhanVien.setMaVanHoa(vHoa.getMaVanHoa());
            nhanVien.setMaHocVan(hVan.getMaTrinhDoHocVan());
            nhanVien.seteMail(eMail);
            nhanVien.setNgayNhapDoan(ngayNhapDoan);
            nhanVien.setChucVuDoan(chucVuDoan);
            nhanVien.setNoiSinhHoatDoan(sinhHoatDoan);
            nhanVien.setNgayNhapDang(ngayNhapDang);
            nhanVien.setChucVuDang(chucVuDang);
            nhanVien.setNoiSinhHoatDang(sinhHoatDang);
            nhanVien.setNgayNhapNgu(ngayNhapNgu);
            nhanVien.setNgayXuatNgu(ngayXuatNgu);
            nhanVien.setNoiSinhHoat(sinhHoatQuanDoi);
            nhanVien.setGhiChu(ghiChu);
            nhanVien.setImg(imgPath);

            nhanVienBLL.addNewNhanVienBLL(nhanVien);
        } catch (ParseException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btSaveActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        stateButton(true);

    }//GEN-LAST:event_btCancelActionPerformed

    private void txtMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNhanVienActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setDataQuanHuyenComboBox();
        setDataNoiCapComboBox();
        setDataNguyenQuanComboBox();
        setDataDanTocComboBox();
        setDataTonGiaoComboBox();
        setDataHoKhauComboBox();
        setDataNoiSinhComboBox();
        setDataQuocTichComboBox();
        setDataVanHoaComboBox();
        setDataHocVanComboBox();
        setDataHonNhanComboBox();

    }//GEN-LAST:event_formWindowOpened

    private void cboQuanHuyenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboQuanHuyenItemStateChanged
        String getQuanHuyen = cboQuanHuyen.getSelectedItem().toString();
        QLNhanVienBLL bLL = new QLNhanVienBLL();
        qHuyen = bLL.getQuanHuyenBLL(getQuanHuyen);
    }//GEN-LAST:event_cboQuanHuyenItemStateChanged

    private void cboNoiCapItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNoiCapItemStateChanged
        String getNoiCap = cboNoiCap.getSelectedItem().toString();
        QLNhanVienBLL bLL = new QLNhanVienBLL();
        cMT = bLL.getNoiCapBLL(getNoiCap);
    }//GEN-LAST:event_cboNoiCapItemStateChanged

    private void cboNguyenQuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNguyenQuanItemStateChanged
        String getNguyenQuan = cboNguyenQuan.getSelectedItem().toString();
        QLNhanVienBLL bLL = new QLNhanVienBLL();
        nQuan = bLL.getNguyenQuanBLL(getNguyenQuan);
    }//GEN-LAST:event_cboNguyenQuanItemStateChanged

    private void cboDanTocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboDanTocItemStateChanged
        String getDanToc = cboDanToc.getSelectedItem().toString();
        QLNhanVienBLL bLL = new QLNhanVienBLL();
        dToc = bLL.getDanTocBLL(getDanToc);
    }//GEN-LAST:event_cboDanTocItemStateChanged

    private void cboTonGiaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTonGiaoItemStateChanged
        String getTonGiao = cboTonGiao.getSelectedItem().toString();
        QLNhanVienBLL bLL = new QLNhanVienBLL();
        tGiao = bLL.getTonGiaoBLL(getTonGiao);
    }//GEN-LAST:event_cboTonGiaoItemStateChanged

    private void cboHoKhauItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboHoKhauItemStateChanged
        String getHoKhau = cboHoKhau.getSelectedItem().toString();
        QLNhanVienBLL bLL = new QLNhanVienBLL();
        hKhau = bLL.getHoKhauBLL(getHoKhau);
    }//GEN-LAST:event_cboHoKhauItemStateChanged

    private void cboNoiSinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNoiSinhItemStateChanged
        String getNoiSinh = cboNoiSinh.getSelectedItem().toString();
        QLNhanVienBLL bLL = new QLNhanVienBLL();
        nSinh = bLL.getNoiSinhBLL(getNoiSinh);
    }//GEN-LAST:event_cboNoiSinhItemStateChanged

    private void cboQuocTichItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboQuocTichItemStateChanged
        String getQuocTich = cboQuocTich.getSelectedItem().toString();
        QLNhanVienBLL bLL = new QLNhanVienBLL();
        qTich = bLL.getQuocTichBLL(getQuocTich);
    }//GEN-LAST:event_cboQuocTichItemStateChanged

    private void cboHonNhanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboHonNhanItemStateChanged
        String getHonNhan = cboHonNhan.getSelectedItem().toString();
        QLNhanVienBLL bLL = new QLNhanVienBLL();
        hNhan = bLL.getHonNhanBLL(getHonNhan);
    }//GEN-LAST:event_cboHonNhanItemStateChanged

    private void cboVanHoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboVanHoaItemStateChanged
        String getVanHoa = cboVanHoa.getSelectedItem().toString();
        QLNhanVienBLL bLL = new QLNhanVienBLL();
        vHoa = bLL.getVanHoaBLL(getVanHoa);
    }//GEN-LAST:event_cboVanHoaItemStateChanged

    private void cboHocVanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboHocVanItemStateChanged
        String getHocVan = cboHocVan.getSelectedItem().toString();
        QLNhanVienBLL bLL = new QLNhanVienBLL();
        hVan = bLL.getHocVanBLL(getHocVan);
    }//GEN-LAST:event_cboHocVanItemStateChanged

    private void chkNamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkNamItemStateChanged
       
    }//GEN-LAST:event_chkNamItemStateChanged

    public ImageIcon ResizeImage(String imgPath) {
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(lbAnh.getWidth(), lbAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbAnh.setIcon(ResizeImage(path));
            imgPath = path;
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Data");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btSave;
    private javax.swing.JComboBox cboDanToc;
    private javax.swing.JComboBox cboHoKhau;
    private javax.swing.JComboBox cboHocVan;
    private javax.swing.JComboBox cboHonNhan;
    private javax.swing.JComboBox cboNguyenQuan;
    private javax.swing.JComboBox cboNoiCap;
    private javax.swing.JComboBox cboNoiSinh;
    private javax.swing.JComboBox cboQuanHuyen;
    private javax.swing.JComboBox cboQuocTich;
    private javax.swing.JComboBox cboTonGiao;
    private javax.swing.JComboBox cboVanHoa;
    private javax.swing.JCheckBox chkNam;
    private javax.swing.JCheckBox chkNu;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAnh;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtChucVuDang;
    private javax.swing.JTextField txtChucVuDoan;
    private javax.swing.JTextField txtDiDong;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtMsThue;
    private javax.swing.JTextField txtNgayCap;
    private javax.swing.JTextField txtNgayGiaNhapDang;
    private javax.swing.JTextField txtNgayGiaNhapDoan;
    private javax.swing.JTextField txtNgayNhapNgu;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNgayXuatNgu;
    private javax.swing.JTextField txtNoiSinhHoatDang;
    private javax.swing.JTextField txtNoiSinhHoatDoan;
    private javax.swing.JTextField txtNoiSinhHoatQuanDoi;
    private javax.swing.JTextField txtSTK;
    private javax.swing.JTextField txtTamTru;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenDem;
    private javax.swing.JTextArea txtThuongTru;
    // End of variables declaration//GEN-END:variables
}
