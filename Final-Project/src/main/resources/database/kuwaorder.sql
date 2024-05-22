-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 22, 2024 lúc 06:43 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `kuwaorder`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `product_id` bigint(20) UNSIGNED NOT NULL,
  `quantity` int(11) NOT NULL,
  `unit` varchar(20) NOT NULL DEFAULT 'cái',
  `desired_date` varchar(12) NOT NULL,
  `status` varchar(50) NOT NULL DEFAULT 'Chờ xử lý',
  `note` text DEFAULT NULL,
  `request_id` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`id`, `product_id`, `quantity`, `unit`, `desired_date`, `status`, `note`, `request_id`) VALUES
(1, 1, 50, 'cái', '30/05/2024', 'Chờ xử lý', 'mua site nào xịn nhé', 1),
(8, 2, 45, 'cái', '28/05/2024', 'Chờ xử lý', 'khách cần gấp', 1),
(9, 3, 69, 'cái', '22/05/2024', 'Chờ xử lý', 'kaka', 1),
(10, 4, 120, 'cái', '30/05/2024', 'Chờ xử lý', NULL, 1),
(11, 5, 150, 'cái', '23/05/2024', 'Đã tạo đơn', NULL, 2),
(12, 6, 142, 'cái', '24/05/2024', 'Tạo đơn thiếu', NULL, 2),
(13, 7, 145, 'cái', '25/05/2024', 'Tạo đơn thiếu', NULL, 3),
(14, 8, 500, 'cái', '20/05/2024', 'Tạo đơn thiếu', NULL, 3),
(15, 9, 333, 'cái', '22/05/2024', 'Tạo đơn thiếu', NULL, 4),
(16, 10, 25, 'cái', '21/05/2024', 'Tạo đơn thiếu', NULL, 4),
(17, 11, 50, 'cái', '28/05/2024', 'Đã tạo đơn', 'kiii', 5),
(18, 12, 2, 'cái', '29/05/2024', 'Đã tạo đơn', 'Cần cái nịt', 5),
(19, 11, 20, 'cái', '24/05/2024', 'Đã tạo đơn', NULL, 6),
(20, 3, 100, 'cái', '20/05/2024', 'Chờ xử lý', NULL, 6),
(21, 7, 120, 'cái', '21/05/2024', 'Tạo đơn thiếu', NULL, 7),
(22, 6, 230, 'cái', '22/05/2024', 'Tạo đơn thiếu', NULL, 7),
(23, 9, 532, 'cái', '24/05/2024', 'Đã tạo đơn', NULL, 8),
(24, 3, 145, 'cái', '22/05/2024', 'Tạo đơn thiếu', '66554hh', 8),
(25, 4, 12, 'cái', '23/05/2024', 'Chờ xử lý', NULL, 9),
(26, 5, 54, 'cái', '22/05/2024', 'Chờ xử lý', NULL, 9),
(27, 1, 88, 'cái', '22/05/2024', 'Chờ xử lý', NULL, 10),
(28, 2, 55, 'cái', '23/05/2024', 'Chờ xử lý', NULL, 10),
(29, 3, 12, 'cái', '22/05/2024', 'Đã tạo đơn', NULL, 11),
(30, 4, 154, 'cái', '21/05/2024', 'Tạo đơn thiếu', NULL, 11),
(31, 5, 44, 'cái', '21/05/2024', 'Tạo đơn thiếu', NULL, 12),
(32, 11, 44, 'cái', '21/05/2024', 'Tạo đơn thiếu', NULL, 12),
(34, 8, 145, 'cái', '23/05/2024', 'Chờ xử lý', 'kaka', 1),
(35, 5, 44, 'cái', '25/05/2024', 'Chờ xử lý', 'ko co dau', 1),
(36, 6, 130, 'cái', '25/05/2024', 'Chờ xử lý', 'mua nhe', 1),
(37, 7, 20, 'cái', '26/05/2024', 'Chờ xử lý', NULL, 1),
(38, 9, 360, 'cái', '27/05/2024', 'Chờ xử lý', 'aaa', 1),
(39, 10, 111, 'cái', '24/05/2024', 'Chờ xử lý', '455', 1),
(40, 11, 33, 'cái', '25/05/2024', 'Chờ xử lý', 'gg', 1),
(41, 12, 2, 'cái', '26/05/2024', 'Chờ xử lý', 'nit', 1),
(42, 1, 10, 'cái', '30/05/2024', 'Chờ xử lý', '22', 19),
(43, 2, 10, 'cái', '30/05/2024', 'Đã tạo đơn', '22', 19),
(44, 3, 10, 'cái', '30/05/2024', 'Chờ xử lý', '22', 19),
(45, 6, 10, 'cái', '30/05/2024', 'Chờ xử lý', '22', 19),
(46, 12, 10, 'cái', '30/05/2024', 'Chờ xử lý', '22', 19),
(47, 2, 10, 'cái', '28/05/2024', 'Chờ xử lý', 'qq', 20),
(48, 3, 10, 'cái', '28/05/2024', 'Chờ xử lý', 'qq', 20),
(49, 5, 10, 'cái', '28/05/2024', 'Chờ xử lý', 'qq', 20),
(50, 10, 10, 'cái', '28/05/2024', 'Chờ xử lý', 'qq', 20),
(51, 1, 45, 'cái', '31/05/2024', 'Chờ xử lý', '222', 20),
(52, 1, 20, 'cái', '30/05/2024', 'Đã tạo đơn', '10', 21),
(53, 2, 20, 'cái', '30/05/2024', 'Chờ xử lý', '10', 21),
(54, 3, 20, 'cái', '30/05/2024', 'Đã tạo đơn', '10', 21),
(55, 2, 14, 'cái', '30/05/2024', 'Đã tạo đơn', 'hhh', 22),
(56, 3, 14, 'cái', '30/05/2024', 'Đã tạo đơn', 'hhh', 22),
(57, 7, 14, 'cái', '30/05/2024', 'Chờ xử lý', 'hhh', 22),
(58, 11, 14, 'cái', '30/05/2024', 'Chờ xử lý', 'hhh', 22);

--
-- Bẫy `orders`
--
DELIMITER $$
CREATE TRIGGER `update_order_quantity` AFTER INSERT ON `orders` FOR EACH ROW UPDATE `requests`
SET `order_quantity` = `order_quantity` + 1
WHERE `id` = NEW.request_id
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `update_request_status` AFTER UPDATE ON `orders` FOR EACH ROW IF NEW.status <> OLD.status THEN
        UPDATE requests
        SET status = 
            CASE
                WHEN NOT EXISTS (
                    SELECT 1
                    FROM orders
                    WHERE orders.request_id = NEW.request_id
                    AND orders.status = 'Chờ xử lý'
                )
                THEN 'Đã xử lý'
                ELSE status
            END
        WHERE id = NEW.request_id;
    END IF
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `update_requests_decrease_oq` AFTER UPDATE ON `orders` FOR EACH ROW IF NEW.status <> OLD.status THEN
    UPDATE requests
    SET order_quantity = 
        CASE
            WHEN OLD.status = 'Chờ xử lý' THEN order_quantity - 1
            ELSE order_quantity
        END
    WHERE id = NEW.request_id;
END IF
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `category` varchar(255) NOT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `name`, `image`, `category`, `description`) VALUES
(1, 'Tivi', '/images/products/1-tivi.jpg', 'Điện máy', 'Tivi thì để sờ em chứ còn làm gì'),
(2, 'Tủ lạnh', '/images/products/2-tulanh.jpg', 'Điện máy', 'Trời nóng thì vào nằm cho mát'),
(3, 'Máy giặt', '/images/products/3-maygiat.png', 'Điện máy', 'Nhân cách bẩn quá thì vào để reset'),
(4, 'Máy hút bụi', '/images/products/4-mayhutbui.jpg', 'Gia dụng', 'Dùng nhiều không biết nhà có sạch không nhưng ít ra nó đỡ bẩn hơn không dùng'),
(5, 'Láp tóp tóp', '/images/products/5-laptop.jpg', 'Công nghệ', 'Phương tiện đưa bạn lên thách đấu'),
(6, 'Ai phôn nè', '/images/products/6-iphone.png', 'Công nghệ', 'Không phải Android'),
(7, 'Lò nướng', '/images/products/7-lonuong.jpg', 'Gia dụng', 'Khoai nướng siêu ngon, đảm bảo nương khoái'),
(8, 'Kẹo mút', '/images/products/8-keomut.jpg', 'Thực phẩm', 'Mút mút mút'),
(9, 'Nước ngọt', '/images/products/9-nuocngot.jpg', 'Đồ uống', 'Uống kèm với thuốc cho đỡ đắng'),
(10, 'Tai nghe', '/images/products/10-tainghe.jpg', 'Công nghệ', 'Ủa? Tai không để nghe thì để làm gì'),
(11, 'Chuột Mickey', '/images/products/11-chuotkhongday.jpg', 'Công nghệ', 'Để bắt Doraemon'),
(12, 'Cái nịt', '/images/products/12-cainit.jpg', 'Vật phẩm quý hiếm', ':D');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `requests`
--

CREATE TABLE `requests` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `order_quantity` int(11) NOT NULL DEFAULT 0,
  `send_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `description` longtext DEFAULT NULL,
  `status` varchar(50) NOT NULL DEFAULT 'Chờ xử lý'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `requests`
--

INSERT INTO `requests` (`id`, `name`, `order_quantity`, `send_date`, `description`, `status`) VALUES
(1, 'Request 01', 7, '2024-05-18 11:34:15', 'Cần đặt cấp tốc ', 'Chờ xử lý'),
(2, 'Request 02', 2, '2024-05-18 11:34:15', 'Mua lẹ em ơi', 'Chờ xử lý'),
(3, 'Request 03', 2, '2024-05-18 11:34:15', 'Chú ý chọn hàng xịn', 'Chờ xử lý'),
(4, 'Request 04', 2, '2024-05-18 11:34:15', 'Yêu cầu đặt hàng về hàng đặt', 'Chờ xử lý'),
(5, 'Request 05', 2, '2024-05-18 11:34:15', '050505050', 'Chờ xử lý'),
(6, 'Request 06', 2, '2024-05-18 11:34:15', 'đặt hàng 6', 'Chờ xử lý'),
(7, 'Request 07', 2, '2024-05-18 11:34:15', 'thất thất thất', 'Chờ xử lý'),
(8, 'Request 08', 2, '2024-05-18 11:34:15', 'tám chín mười một trăm', 'Đã xử lý'),
(9, 'Request 09', 2, '2024-05-18 11:34:15', 'chín rồi, ăn được rồi', 'Chờ xử lý'),
(10, 'Request 10', 2, '2024-05-18 11:34:15', 'mười điểm', 'Chờ xử lý'),
(11, 'Request 11', 2, '2024-05-18 11:34:15', 'hehe', 'Chờ xử lý'),
(12, 'Request 12', 2, '2024-05-18 11:34:15', 'haha', 'Chờ xử lý'),
(13, 'test', 2, '2024-05-18 16:48:11', 'ko coji', 'Chờ xử lý'),
(14, 'test1', 0, '2024-05-21 09:01:03', NULL, 'Chờ xử lý'),
(15, 'test3', 0, '2024-05-21 09:02:19', NULL, 'Chờ xử lý'),
(16, 'test4', 2, '2024-05-21 09:02:19', NULL, 'Chờ xử lý'),
(17, 'Request 22', 2, '2024-05-21 09:09:58', NULL, 'Chờ xử lý'),
(18, 'Request 23', 2, '2024-05-21 09:10:55', 'kkkkk\r\n', 'Chờ xử lý'),
(19, 'request quan', 4, '2024-05-22 14:57:45', 'ko co', 'Chờ xử lý'),
(20, 'khong co ten', 5, '2024-05-22 14:59:54', 'hehe', 'Chờ xử lý'),
(21, '33', 1, '2024-05-22 15:12:55', '55', 'Chờ xử lý'),
(22, 'yeu cau', 2, '2024-05-22 15:20:44', 'nuuu', 'Chờ xử lý');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `siteorders`
--

CREATE TABLE `siteorders` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `order_id` bigint(20) UNSIGNED NOT NULL,
  `site_id` bigint(20) UNSIGNED NOT NULL,
  `quantity` int(11) NOT NULL,
  `delivery_type` varchar(50) NOT NULL DEFAULT 'ship',
  `price` double NOT NULL,
  `status` varchar(50) NOT NULL DEFAULT 'Chờ xác nhận',
  `note` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `siteorders`
--

INSERT INTO `siteorders` (`id`, `order_id`, `site_id`, `quantity`, `delivery_type`, `price`, `status`, `note`) VALUES
(1, 10, 10, 2, 'Đường thủy', 16900000, 'Đang giao', NULL),
(2, 10, 4, 44, 'Đường thủy', 320750000, 'Đang giao', NULL),
(3, 10, 1, 25, 'Đường thủy', 189500000, 'Đang giao', NULL),
(4, 10, 7, 36, 'Đường thủy', 273950000, 'Đang giao', NULL),
(5, 10, 11, 13, 'Đường thủy', 100700000, 'Đang giao', NULL),
(6, 9, 8, 14, 'Hàng không', 176800000, 'Đang giao', NULL),
(7, 10, 4, 44, 'Đường thủy', 320750000, 'Đang giao', NULL),
(8, 10, 10, 12, 'Đường thủy', 90900000, 'Đang giao', NULL),
(9, 10, 1, 25, 'Đường thủy', 189500000, 'Đang giao', NULL),
(10, 10, 7, 36, 'Đường thủy', 273950000, 'Đang giao', NULL),
(11, 10, 11, 3, 'Đường thủy', 24700000, 'Chờ xác nhận', NULL),
(12, 9, 8, 14, 'Hàng không', 176800000, 'Chờ xác nhận', NULL),
(13, 17, 2, 1, 'Hàng không', 6300000, 'Chờ xác nhận', NULL),
(14, 17, 3, 2, 'Đường thủy', 5850000, 'Đang hủy', NULL),
(15, 17, 9, 3, 'Hàng không', 9390000, 'Chờ xác nhận', NULL),
(16, 17, 7, 39, 'Đường thủy', 56750000, 'Chờ xác nhận', NULL),
(17, 17, 12, 5, 'Đường thủy', 10100000, 'Đã đặt lại', NULL),
(18, 12, 7, 13, 'Hàng không', 391900000, 'Chờ xác nhận', NULL),
(19, 12, 3, 9, 'Hàng không', 274500000, 'Chờ xác nhận', NULL),
(20, 12, 11, 25, 'Hàng không', 767100000, 'Chờ xác nhận', NULL),
(21, 12, 9, 41, 'Hàng không', 1267750000, 'Chờ xác nhận', NULL),
(22, 12, 5, 7, 'Đường thủy', 220000000, 'Chờ xác nhận', NULL),
(23, 11, 12, 34, 'Hàng không', 1337550000, 'Chờ xác nhận', NULL),
(24, 11, 8, 39, 'Hàng không', 1549700000, 'Đang đặt lại', NULL),
(25, 11, 3, 34, 'Hàng không', 1357700000, 'Chờ xác nhận', NULL),
(26, 11, 2, 43, 'Hàng không', 1724800000, 'Chờ xác nhận', NULL),
(27, 23, 6, 142, 'Hàng không', 5021200, 'Đã xác nhận', NULL),
(28, 23, 10, 125, 'Hàng không', 5325000, 'Đã xác nhận', NULL),
(29, 23, 7, 235, 'Hàng không', 6662000, 'Đã đặt lại', NULL),
(30, 23, 12, 30, 'Hàng không', 5017000, 'Đã xác nhận', NULL),
(31, 19, 3, 1, 'Hàng không', 6175000, 'Chờ xác nhận', NULL),
(32, 19, 7, 1, 'Hàng không', 5900000, 'Đang hủy', NULL),
(33, 19, 9, 1, 'Hàng không', 6430000, 'Chờ xác nhận', NULL),
(34, 19, 12, 1, 'Hàng không', 6300000, 'Đang đặt lại', NULL),
(35, 19, 2, 16, 'Hàng không', 28800000, 'Chờ xác nhận', NULL),
(36, 34, 11, 145, 'Hàng không', 4737750, 'Chờ xác nhận', NULL),
(37, 13, 6, 12, 'Đường thủy', 53300000, 'Chờ xác nhận', NULL),
(38, 13, 9, 22, 'Đường thủy', 99250000, 'Chờ xác nhận', NULL),
(39, 13, 1, 18, 'Hàng không', 85000000, 'Chờ xác nhận', NULL),
(40, 13, 10, 50, 'Đường thủy', 232100000, 'Đang hủy', NULL),
(41, 13, 5, 29, 'Đường thủy', 140025000, 'Chờ xác nhận', NULL),
(42, 18, 11, 1, 'Đường thủy', 9779677000, 'Đang hủy', NULL),
(43, 18, 8, 1, 'Đường thủy', 9879043210, 'Chờ xác nhận', NULL),
(44, 22, 5, 7, 'Hàng không', 223000000, 'Chờ xác nhận', NULL),
(45, 29, 8, 12, 'Hàng không', 152300000, 'Chờ xác nhận', NULL),
(46, 24, 8, 14, 'Hàng không', 176800000, 'Chờ xác nhận', NULL),
(47, 8, 12, 45, 'Đường thủy', 667315000, 'Chờ xác nhận', NULL),
(48, 34, 5, 20, 'Hàng không', 6017000, 'Chờ xác nhận', NULL),
(49, 34, 8, 11, 'Hàng không', 5310670, 'Chờ xác nhận', NULL),
(50, 34, 11, 5, 'Hàng không', 4604750, 'Đang hủy', NULL),
(51, 34, 9, 109, 'Hàng không', 5050280, 'Chờ xác nhận', NULL),
(52, 1, 3, 3, 'Đường thủy', 62497000, 'Chờ xác nhận', NULL),
(53, 1, 8, 11, 'Đường thủy', 223600000, 'Đang đặt lại', NULL),
(54, 1, 2, 20, 'Đường thủy', 412200000, 'Chờ xác nhận', NULL),
(55, 1, 5, 16, 'Đường thủy', 331000000, 'Chờ xác nhận', NULL),
(56, 41, 3, 1, 'Đường thủy', 9891388888, 'Đang hủy', NULL),
(57, 41, 11, 1, 'Hàng không', 9782377000, 'Chờ xác nhận', NULL),
(58, 39, 3, 41, 'Hàng không', 86500000, 'Đang đặt lại', NULL),
(59, 39, 12, 36, 'Hàng không', 80350000, 'Chờ xác nhận', NULL),
(60, 55, 1, 9, 'Đường thủy', 137000000, 'Đang giao', NULL),
(61, 55, 2, 5, 'Đường thủy', 76200000, 'Chờ xác nhận', NULL),
(62, 56, 1, 14, 'Đường thủy', 170000000, 'Chờ xác nhận', NULL),
(63, 52, 1, 15, 'Đường thủy', 317000000, 'Chờ xác nhận', NULL),
(64, 52, 3, 3, 'Đường thủy', 62497000, 'Chờ xác nhận', NULL),
(65, 52, 8, 2, 'Đường thủy', 42700000, 'Đang đặt lại', NULL),
(66, 54, 1, 14, 'Đường thủy', 170000000, 'Chờ xác nhận', NULL),
(67, 54, 7, 6, 'Đường thủy', 72950000, 'Chờ xác nhận', NULL),
(68, 43, 1, 9, 'Đường thủy', 137000000, 'Chờ xác nhận', NULL),
(69, 43, 2, 1, 'Đường thủy', 17000000, 'Chờ xác nhận', NULL),
(70, 23, 7, 235, 'Máy bay', 0, 'Chờ xác nhận', NULL),
(71, 17, 3, 5, 'Máy bay', 0, 'Chờ xác nhận', NULL),
(72, 17, 3, 5, 'Tàu', 0, 'Chờ xác nhận', NULL),
(73, 17, 3, 5, 'Máy bay', 0, 'Chờ xác nhận', NULL),
(74, 17, 7, 5, 'Tàu', 0, 'Chờ xác nhận', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `siteproducts`
--

CREATE TABLE `siteproducts` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `site_id` bigint(20) UNSIGNED NOT NULL,
  `product_id` bigint(20) UNSIGNED NOT NULL,
  `quantity` int(11) NOT NULL,
  `sold_quantity` int(11) NOT NULL DEFAULT 0,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `siteproducts`
--

INSERT INTO `siteproducts` (`id`, `site_id`, `product_id`, `quantity`, `sold_quantity`, `price`) VALUES
(1, 1, 1, 15, 0, 21000000),
(2, 1, 2, 0, 9, 15000000),
(3, 1, 3, 14, 0, 12000000),
(4, 1, 4, 0, 30, 7500000),
(5, 1, 7, 18, 20, 4500000),
(6, 2, 11, 33, 0, 1500000),
(7, 2, 12, 1, 0, 99999999999),
(8, 2, 5, 45, 12, 40000000),
(9, 2, 3, 14, 0, 12500000),
(10, 2, 2, 8, 0, 14800000),
(11, 3, 6, 9, 0, 30000000),
(12, 3, 11, 16, 0, 1675000),
(13, 3, 5, 34, 7, 39800000),
(14, 3, 10, 41, 0, 2000000),
(15, 3, 12, 1, 0, 9888888888),
(16, 4, 8, 1452, 0, 900),
(17, 4, 9, 99, 0, 9000),
(18, 4, 4, 44, 0, 7250000),
(19, 4, 5, 54, 0, 40500000),
(20, 4, 10, 15, 0, 1980000),
(21, 5, 7, 29, 0, 4725000),
(22, 5, 1, 23, 0, 20500000),
(23, 5, 6, 7, 0, 31000000),
(24, 6, 7, 12, 0, 4250000),
(25, 5, 8, 152, 0, 850),
(26, 6, 9, 142, 0, 8600),
(27, 6, 1, 42, 0, 21200000),
(28, 6, 2, 12, 0, 15750000),
(29, 6, 5, 11, 0, 38999000),
(30, 6, 10, 37, 0, 2050000),
(31, 7, 3, 15, 0, 11800000),
(32, 7, 4, 36, 0, 7550000),
(33, 7, 6, 13, 0, 29800000),
(34, 7, 9, 235, 0, 9200),
(35, 7, 11, 39, 0, 1400000),
(36, 8, 8, 870, 0, 970),
(37, 8, 3, 14, 0, 12250000),
(38, 8, 12, 1, 0, 9876543210),
(39, 8, 5, 39, 0, 39600000),
(40, 8, 2, 44, 0, 14870000),
(41, 9, 8, 1250, 0, 920),
(42, 9, 3, 15, 0, 11950000),
(43, 9, 7, 22, 0, 4400000),
(44, 9, 6, 41, 0, 30800000),
(45, 9, 11, 21, 0, 1480000),
(46, 10, 1, 14, 0, 20800000),
(47, 10, 4, 12, 0, 7400000),
(48, 10, 10, 52, 0, 1980000),
(49, 10, 9, 125, 0, 9000),
(50, 10, 7, 50, 0, 4600000),
(51, 11, 12, 1, 0, 9777777000),
(52, 11, 1, 15, 0, 20900000),
(53, 11, 4, 14, 0, 7600000),
(54, 11, 6, 25, 0, 30500000),
(55, 11, 8, 1456, 0, 950),
(56, 12, 2, 45, 0, 14777000),
(57, 12, 9, 200, 0, 8900),
(58, 12, 10, 36, 0, 2100000),
(59, 12, 11, 33, 0, 1550000),
(60, 12, 5, 34, 0, 39200000),
(61, 2, 1, 20, 0, 20500000),
(62, 3, 1, 3, 0, 19999000),
(63, 4, 1, 24, 0, 20750000),
(64, 7, 1, 44, 0, 21200000),
(65, 8, 1, 11, 0, 20100000),
(66, 9, 1, 33, 0, 20600000),
(67, 12, 1, 11, 0, 21200000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sites`
--

CREATE TABLE `sites` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `ship_date` int(11) NOT NULL,
  `air_date` int(11) NOT NULL,
  `ship_price` double NOT NULL,
  `air_price` double NOT NULL,
  `sold_quantity` int(11) NOT NULL DEFAULT 0,
  `information` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sites`
--

INSERT INTO `sites` (`id`, `name`, `ship_date`, `air_date`, `ship_price`, `air_price`, `sold_quantity`, `information`) VALUES
(1, 'Site 01', 5, 3, 2000000, 4000000, 0, 'Site 1 nổi tiếng nhất Việt Nam về khoản bán hàng kém chất lượng'),
(2, 'Site 02', 4, 2, 2200000, 4800000, 0, 'Site 2 bán toàn hàng xịn thôi nhưng mà là hàng giả :('),
(3, 'Site 03', 4, 2, 2500000, 4500000, 0, 'Với chúng tôi, chất lượng là số 1 nhưng tiếc là, chúng tôi là số 03. Hic hic'),
(4, 'Site 04 ', 6, 4, 1750000, 3500000, 0, 'Site chúng tôi hơi xa, giao hơi lâu, nhưng yên tâm là sảng phẩm cũng không tốt lắm'),
(5, 'Site 05', 3, 1, 3000000, 6000000, 0, 'Site 05 ngày thức, đêm không ngủ.\r\nTốc độ là quan trọng nhất, chất lượng sản phẩm thì dùng được là được rồi. Nhể ;)'),
(6, 'Site 06', 4, 3, 2300000, 3800000, 0, 'Site 06 vì site chúng tôi đẹp, đẹp hết phần của sản phẩm luôn roài'),
(7, 'Site 07 ', 4, 2, 2150000, 4500000, 0, 'Cứ sai đi vì cuộc đời cho phép, nên có giao sai hàng thì cũng đừng thắc mắc nhé'),
(8, 'Site 08', 4, 1, 2500000, 5300000, 0, 'Site chúng tôi ... hướng nội'),
(9, 'Site 09', 4, 2, 2450000, 4950000, 0, 'Site 09 xin không trái với sự mong đợi của hách khàng'),
(10, 'Site 10', 4, 3, 2100000, 4200000, 0, 'Site 10 chuyên mang đến sản phẩm chất lượng nhất trong các site cung cấp hàng giả, hàng nhái'),
(11, 'Site 11', 5, 2, 1900000, 4600000, 0, 'Site chúng tôi có hai số 1, biết tại sao không? Chúng tôi cũng không biết'),
(12, 'Site 12', 4, 2, 2350000, 4750000, 0, 'Site mười haiiiiiii, hết văn rồi :(');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `storage`
--

CREATE TABLE `storage` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `product_id` bigint(20) UNSIGNED NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT 0,
  `sold_quantity` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `storage`
--

INSERT INTO `storage` (`id`, `product_id`, `quantity`, `sold_quantity`) VALUES
(1, 1, 10, 2),
(2, 2, 20, 1),
(3, 3, 44, 450),
(4, 4, 137, 0),
(5, 5, 145, 15),
(6, 6, 24, 253),
(7, 7, 12, 254),
(8, 8, 420, 15236),
(9, 9, 150, 23000),
(10, 10, 15, 233),
(11, 11, 6, 999),
(12, 12, 0, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` varchar(50) NOT NULL DEFAULT 'Order Placement',
  `avatar` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `type`, `avatar`) VALUES
(1, 'Đặt hàng', 'bophandathang', '12345678', 'op', '/images/avatar.jpg'),
(2, 'Kho', 'warehouse', '12345678', 'wh', '/images/whUserAvartar.jpg'),
(3, 'Site 01', 'site01', '12345678', 'sitehn', '/images/whUserAvartar.jpg'),
(4, 'Quan Vu', 'quanvu', '12345678', 'sale', '/images/macute.png'),
(5, 'Thuc Ngo', 'sites', '12345678', 'sitent', '/images/thuc.jpg');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `product_id` (`product_id`),
  ADD KEY `request_id` (`request_id`) USING BTREE;

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Chỉ mục cho bảng `requests`
--
ALTER TABLE `requests`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `siteorders`
--
ALTER TABLE `siteorders`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `order_id` (`order_id`),
  ADD KEY `site_id` (`site_id`);

--
-- Chỉ mục cho bảng `siteproducts`
--
ALTER TABLE `siteproducts`
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `site_id` (`site_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Chỉ mục cho bảng `sites`
--
ALTER TABLE `sites`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Chỉ mục cho bảng `storage`
--
ALTER TABLE `storage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD UNIQUE KEY `id` (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `requests`
--
ALTER TABLE `requests`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT cho bảng `siteorders`
--
ALTER TABLE `siteorders`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;

--
-- AUTO_INCREMENT cho bảng `siteproducts`
--
ALTER TABLE `siteproducts`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT cho bảng `sites`
--
ALTER TABLE `sites`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `storage`
--
ALTER TABLE `storage`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`request_id`) REFERENCES `requests` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `siteorders`
--
ALTER TABLE `siteorders`
  ADD CONSTRAINT `siteorders_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `siteorders_ibfk_2` FOREIGN KEY (`site_id`) REFERENCES `sites` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `siteproducts`
--
ALTER TABLE `siteproducts`
  ADD CONSTRAINT `siteproducts_ibfk_1` FOREIGN KEY (`site_id`) REFERENCES `sites` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `siteproducts_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `storage`
--
ALTER TABLE `storage`
  ADD CONSTRAINT `storage_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
