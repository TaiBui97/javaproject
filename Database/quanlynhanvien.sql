-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 10, 2019 lúc 04:41 AM
-- Phiên bản máy phục vụ: 10.1.37-MariaDB
-- Phiên bản PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlynhanvien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dantoc`
--

CREATE TABLE `dantoc` (
  `MaDanToc` char(11) NOT NULL,
  `TenDanToc` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `dantoc`
--

INSERT INTO `dantoc` (`MaDanToc`, `TenDanToc`) VALUES
('1', 'Kinh'),
('2', 'Khmer');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hocvan`
--

CREATE TABLE `hocvan` (
  `MaHocVan` char(11) NOT NULL,
  `TenHocVan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `hocvan`
--

INSERT INTO `hocvan` (`MaHocVan`, `TenHocVan`) VALUES
('1', 'Dai Hoc'),
('2', 'CaoDang'),
('3', 'Trung Cap');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hokhau`
--

CREATE TABLE `hokhau` (
  `MaHoKhau` char(11) NOT NULL,
  `TenHoKhau` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `hokhau`
--

INSERT INTO `hokhau` (`MaHoKhau`, `TenHoKhau`) VALUES
('1', 'Dong Thap'),
('2', 'Vung Tau'),
('3', 'Ha Noi');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `honnhan`
--

CREATE TABLE `honnhan` (
  `MaTinhTrangHonNhan` char(11) NOT NULL,
  `TenTinhTrang` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `honnhan`
--

INSERT INTO `honnhan` (`MaTinhTrangHonNhan`, `TenTinhTrang`) VALUES
('1', 'Da Ket Hon'),
('2', 'Doc Than');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguyenquan`
--

CREATE TABLE `nguyenquan` (
  `MaNguyenQuan` char(11) NOT NULL,
  `TenNguyenQuan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `nguyenquan`
--

INSERT INTO `nguyenquan` (`MaNguyenQuan`, `TenNguyenQuan`) VALUES
('1', 'Dong Thap'),
('2', 'Ha Noi'),
('3', 'An Giang');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNhanVien` char(255) NOT NULL,
  `SoTaiKhoan` char(11) DEFAULT NULL,
  `MaSoThue` char(255) DEFAULT NULL,
  `MaQuanHuyen` char(11) DEFAULT NULL,
  `DienThoai` int(11) NOT NULL,
  `CMND` int(11) DEFAULT NULL,
  `MaNoiCap` char(11) DEFAULT NULL,
  `MaNguyenQuan` char(11) DEFAULT NULL,
  `MaDanToc` char(11) DEFAULT NULL,
  `MaTonGiao` char(11) DEFAULT NULL,
  `ThuongTru` varchar(255) DEFAULT NULL,
  `MaHoKhau` char(11) DEFAULT NULL,
  `TenDem` varchar(255) DEFAULT NULL,
  `Ten` varchar(255) DEFAULT NULL,
  `GioiTinh` varchar(255) DEFAULT NULL,
  `NgaySinh` date DEFAULT NULL,
  `MaNoiSinh` char(11) DEFAULT NULL,
  `TamTru` varchar(255) DEFAULT NULL,
  `MaQuocTich` char(11) DEFAULT NULL,
  `MaTinhTrangHonNhan` char(11) DEFAULT NULL,
  `NgayNhapDoan` date DEFAULT NULL,
  `ChucVuDoan` varchar(11) DEFAULT NULL,
  `NoiSinhHoatDoan` varchar(255) DEFAULT NULL,
  `NgayNhapDang` date DEFAULT NULL,
  `ChucVuDang` varchar(255) DEFAULT NULL,
  `NoiSinhHoatDang` varchar(255) DEFAULT NULL,
  `NgayNhapNgu` date DEFAULT NULL,
  `NgayXuatNgu` date DEFAULT NULL,
  `NoiSinhHoat` varchar(255) DEFAULT NULL,
  `HinhAnh` blob,
  `GhiTru` varchar(255) DEFAULT NULL,
  `MaVanHoa` char(11) DEFAULT NULL,
  `MaHocVan` char(11) DEFAULT NULL,
  `DiDong` int(11) DEFAULT NULL,
  `NgayCap` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNhanVien`, `SoTaiKhoan`, `MaSoThue`, `MaQuanHuyen`, `DienThoai`, `CMND`, `MaNoiCap`, `MaNguyenQuan`, `MaDanToc`, `MaTonGiao`, `ThuongTru`, `MaHoKhau`, `TenDem`, `Ten`, `GioiTinh`, `NgaySinh`, `MaNoiSinh`, `TamTru`, `MaQuocTich`, `MaTinhTrangHonNhan`, `NgayNhapDoan`, `ChucVuDoan`, `NoiSinhHoatDoan`, `NgayNhapDang`, `ChucVuDang`, `NoiSinhHoatDang`, `NgayNhapNgu`, `NgayXuatNgu`, `NoiSinhHoat`, `HinhAnh`, `GhiTru`, `MaVanHoa`, `MaHocVan`, `DiDong`, `NgayCap`) VALUES
('1', '123', '123345', '1', 123123123, 341123123, '1', '1', '1', '1', 'Ho Chi Minh', '1', 'Bui', 'Tai', '1', '1997-12-12', '1', '0', '1', '1', '1997-12-12', '0', '0000-00-00', '1997-12-12', 'abc', 'abc', '1997-12-12', '1997-12-12', 'HCM', 0x6162632e6a7067, '0', '1', '1', NULL, '0000-00-00'),
('12', '123', '123', '1', 123, 123, '1', '1', '1', '1', 'asdasd', '1', 'tai', 'bui', 'FeMale', '0016-04-17', '1', 'asdsad', '1', '1', '0016-04-17', 'asd', 'asdas', '0016-04-17', 'asdas', 'asdas', '0016-04-17', '0016-04-17', 'asdasd', '', 'asd', '1', '1', 123123, '0016-04-17'),
('123', '123', '123', '1', 123123, 123, '1', '1', '1', '1', 'ASDAS', '1', 'TAI', 'BUI', '', '0018-06-10', '1', 'sasdasd', '1', '1', '0018-06-10', 'ASD', 'ASD', '0018-06-10', 'ASD', 'ASD', '0018-06-10', '0018-06-10', 'ASD', '', 'ASDAS', '1', '1', 123123, '0018-06-10'),
('123123', '123123', '132123', '1', 12312, 3123123, '1', '1', '1', '1', 'asdas', '1', 'dasdas', 'asd', 'FeMale', '0018-05-20', '2', 'asdas', '2', '1', '0018-05-20', 'asd', 'asd', '0018-05-20', 'asd', 'asd', '0018-05-20', '0018-05-20', 'asdsad', 0x433a55736572736167666f724465736b746f706363632e6a7067, 'asd', '1', '1', 123123, '0018-05-20'),
('12344', '123123', '1231', '1', 123123, 123213, '1', '1', '1', '1', 'asdas', '1', 'tai', 'asd', 'Male', '0018-05-14', '1', 'asdasd', '1', '1', '0018-05-14', 'aasd', 'asd', '0018-05-14', 'asd', 'asd', '0018-05-14', '0018-05-14', 'asdasd', 0x433a55736572736167666f724465736b746f70362e6a7067, 'asdasd', '1', '1', 123123123, '0018-05-14'),
('40', '123', '123', '1', 123, 123, '1', '1', '1', '1', 'asda', '1', 'asd', 'asd', 'null', '0018-05-20', '1', 'asda', '1', '1', '0018-05-20', 'asd', 'asd', '0018-05-20', 'asd', 'asd', '0018-05-20', '0018-05-20', 'asdasd', 0x433a55736572736167666f724465736b746f70352e6a7067, 'asdsa', '1', '1', 123213, '0018-05-20'),
('45', '123', '123', '1', 123123, 123123, '1', '1', '1', '1', 'ads', '1', 'tai', 'tai', 'FeMale', '0018-05-20', '1', 'asdasdasd', '1', '1', '0018-05-20', 'adsas', 'asdasd', '0018-05-20', 'asdasd', 'asdasd', '0018-05-20', '0018-05-20', 'asdsad', '', 'asdsad', '1', '1', 12312312, '0018-05-20'),
('67', '567', '567', '1', 567657, 567567, '1', '1', '1', '1', 'asd', '1', 'tai', 'asd', 'Male', '0018-05-20', '1', 'sdasd', '1', '1', '0018-05-20', 'asd', 'ads', '0018-05-20', 'asdasd', 'asdasd', '0018-05-20', '0018-05-20', 'asd', 0x6a6176612e696f2e46696c65496e70757453747265616d403439626639613934, 'asd', '1', '1', 12312312, '0018-05-20');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `noisinh`
--

CREATE TABLE `noisinh` (
  `MaNoiSinh` char(11) NOT NULL,
  `TenNoiSinh` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `noisinh`
--

INSERT INTO `noisinh` (`MaNoiSinh`, `TenNoiSinh`) VALUES
('1', 'Dong Thap'),
('2', 'Ho Chi Minh'),
('3', 'Ha Noi');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nopcap`
--

CREATE TABLE `nopcap` (
  `MaNoiCap` char(11) NOT NULL,
  `NoiCap` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `nopcap`
--

INSERT INTO `nopcap` (`MaNoiCap`, `NoiCap`) VALUES
('1', 'Dong Thap'),
('2', 'Ho Chi Minh'),
('3', 'Ha Noi'),
('4', 'An Giang');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quanhuyen`
--

CREATE TABLE `quanhuyen` (
  `MaQuanHuyen` char(11) NOT NULL,
  `TenQuanHuyen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `quanhuyen`
--

INSERT INTO `quanhuyen` (`MaQuanHuyen`, `TenQuanHuyen`) VALUES
('1', 'Ho Chi Minh'),
('2', 'Ho Chi Minh'),
('3', 'Ha Noi'),
('4', 'Long An');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quoctich`
--

CREATE TABLE `quoctich` (
  `MaQuocTich` char(11) NOT NULL,
  `TenQuocTich` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `quoctich`
--

INSERT INTO `quoctich` (`MaQuocTich`, `TenQuocTich`) VALUES
('1', 'Viet Nam'),
('2', 'Lao'),
('3', 'Campuchia'),
('4', 'Singapo');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tongiao`
--

CREATE TABLE `tongiao` (
  `MaTonGiao` char(11) NOT NULL,
  `TenTonGiao` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `tongiao`
--

INSERT INTO `tongiao` (`MaTonGiao`, `TenTonGiao`) VALUES
('1', 'Khong co'),
('2', 'Dao Phat'),
('3', 'Thien Chua');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vanhoa`
--

CREATE TABLE `vanhoa` (
  `MaVanHoa` char(11) NOT NULL,
  `TenVanHoa` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `vanhoa`
--

INSERT INTO `vanhoa` (`MaVanHoa`, `TenVanHoa`) VALUES
('1', '12/12'),
('2', '9/9'),
('4', 'Dai Hoc');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `dantoc`
--
ALTER TABLE `dantoc`
  ADD PRIMARY KEY (`MaDanToc`);

--
-- Chỉ mục cho bảng `hocvan`
--
ALTER TABLE `hocvan`
  ADD PRIMARY KEY (`MaHocVan`);

--
-- Chỉ mục cho bảng `hokhau`
--
ALTER TABLE `hokhau`
  ADD PRIMARY KEY (`MaHoKhau`);

--
-- Chỉ mục cho bảng `honnhan`
--
ALTER TABLE `honnhan`
  ADD PRIMARY KEY (`MaTinhTrangHonNhan`);

--
-- Chỉ mục cho bảng `nguyenquan`
--
ALTER TABLE `nguyenquan`
  ADD PRIMARY KEY (`MaNguyenQuan`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNhanVien`),
  ADD KEY `MaSoThue` (`MaSoThue`),
  ADD KEY `MaNoiCap` (`MaNoiCap`),
  ADD KEY `MaQuocTich` (`MaQuocTich`),
  ADD KEY `MaTonGiao` (`MaTonGiao`),
  ADD KEY `MaDanToc` (`MaDanToc`),
  ADD KEY `MaNguyenQuan` (`MaNguyenQuan`),
  ADD KEY `MaHoKhau` (`MaHoKhau`),
  ADD KEY `MaNoiSinh` (`MaNoiSinh`),
  ADD KEY `MaTinhTrangHonNhan` (`MaTinhTrangHonNhan`),
  ADD KEY `MaQuanHuyen` (`MaQuanHuyen`),
  ADD KEY `MaVanHoa` (`MaVanHoa`),
  ADD KEY `MaHocVan` (`MaHocVan`);

--
-- Chỉ mục cho bảng `noisinh`
--
ALTER TABLE `noisinh`
  ADD PRIMARY KEY (`MaNoiSinh`);

--
-- Chỉ mục cho bảng `nopcap`
--
ALTER TABLE `nopcap`
  ADD PRIMARY KEY (`MaNoiCap`);

--
-- Chỉ mục cho bảng `quanhuyen`
--
ALTER TABLE `quanhuyen`
  ADD PRIMARY KEY (`MaQuanHuyen`);

--
-- Chỉ mục cho bảng `quoctich`
--
ALTER TABLE `quoctich`
  ADD PRIMARY KEY (`MaQuocTich`);

--
-- Chỉ mục cho bảng `tongiao`
--
ALTER TABLE `tongiao`
  ADD PRIMARY KEY (`MaTonGiao`);

--
-- Chỉ mục cho bảng `vanhoa`
--
ALTER TABLE `vanhoa`
  ADD PRIMARY KEY (`MaVanHoa`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`MaDanToc`) REFERENCES `dantoc` (`MaDanToc`),
  ADD CONSTRAINT `nhanvien_ibfk_10` FOREIGN KEY (`MaQuanHuyen`) REFERENCES `quanhuyen` (`MaQuanHuyen`),
  ADD CONSTRAINT `nhanvien_ibfk_11` FOREIGN KEY (`MaHoKhau`) REFERENCES `hokhau` (`MaHoKhau`),
  ADD CONSTRAINT `nhanvien_ibfk_2` FOREIGN KEY (`MaTonGiao`) REFERENCES `tongiao` (`MaTonGiao`),
  ADD CONSTRAINT `nhanvien_ibfk_3` FOREIGN KEY (`MaQuocTich`) REFERENCES `quoctich` (`MaQuocTich`),
  ADD CONSTRAINT `nhanvien_ibfk_4` FOREIGN KEY (`MaNguyenQuan`) REFERENCES `nguyenquan` (`MaNguyenQuan`),
  ADD CONSTRAINT `nhanvien_ibfk_5` FOREIGN KEY (`MaNoiCap`) REFERENCES `nopcap` (`MaNoiCap`),
  ADD CONSTRAINT `nhanvien_ibfk_6` FOREIGN KEY (`MaTinhTrangHonNhan`) REFERENCES `honnhan` (`MaTinhTrangHonNhan`),
  ADD CONSTRAINT `nhanvien_ibfk_7` FOREIGN KEY (`MaVanHoa`) REFERENCES `vanhoa` (`MaVanHoa`),
  ADD CONSTRAINT `nhanvien_ibfk_8` FOREIGN KEY (`MaHocVan`) REFERENCES `hocvan` (`MaHocVan`),
  ADD CONSTRAINT `nhanvien_ibfk_9` FOREIGN KEY (`MaNoiSinh`) REFERENCES `noisinh` (`MaNoiSinh`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
