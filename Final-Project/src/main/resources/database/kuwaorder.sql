-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 20, 2024 lúc 06:48 AM
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
  `status` varchar(50) NOT NULL DEFAULT 'Chờ gửi',
  `note` text DEFAULT NULL,
  `request_id` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`id`, `product_id`, `quantity`, `unit`, `desired_date`, `status`, `note`, `request_id`) VALUES
(1, 1, 500, 'cái', '21/05/2024', 'Chờ xử lý', 'mua site nào xịn nhé', 1),
(8, 2, 450, 'cái', '21/05/2024', 'Chờ xử lý', 'khách cần gấp', 1),
(9, 3, 420, 'cái', '22/05/2024', 'Chờ xử lý', 'kaka', 1),
(10, 4, 120, 'cái', '30/05/2024', 'Chờ xử lý', NULL, 1),
(11, 5, 150, 'cái', '23/05/2024', 'Chờ xử lý', NULL, 2),
(12, 6, 142, 'cái', '24/05/2024', 'Chờ xử lý', NULL, 2),
(13, 7, 145, 'cái', '25/05/2024', 'Chờ xử lý', NULL, 3),
(14, 8, 500, 'cái', '20/05/2024', 'Chờ xử lý', NULL, 3),
(15, 9, 333, 'cái', '22/05/2024', 'Chờ xử lý', NULL, 4),
(16, 10, 25, 'cái', '21/05/2024', 'Chờ xử lý', NULL, 4),
(17, 11, 50, 'cái', '28/05/2024', 'Chờ xử lý', 'kiii', 5),
(18, 12, 2, 'cái', '29/05/2024', 'Chờ xử lý', 'Cần cái nịt', 5),
(19, 11, 20, 'cái', '24/05/2024', 'Chờ xử lý', NULL, 6),
(20, 3, 100, 'cái', '20/05/2024', 'Chờ xử lý', NULL, 6),
(21, 7, 120, 'cái', '21/05/2024', 'Chờ xử lý', NULL, 7),
(22, 6, 230, 'cái', '22/05/2024', 'Chờ xử lý', NULL, 7),
(23, 9, 532, 'cái', '24/05/2024', 'Chờ xử lý', NULL, 8),
(24, 3, 145, 'cái', '22/05/2024', 'Chờ xử lý', '66554hh', 8),
(25, 4, 12, 'cái', '23/05/2024', 'Chờ xử lý', NULL, 9),
(26, 5, 54, 'cái', '22/05/2024', 'Chờ xử lý', NULL, 9),
(27, 1, 150, 'cái', '22/05/2024', 'Chờ xử lý', NULL, 10),
(28, 2, 55, 'cái', '23/05/2024', 'Chờ xử lý', NULL, 10),
(29, 3, 12, 'cái', '22/05/2024', 'Chờ xử lý', NULL, 11),
(30, 4, 154, 'cái', '21/05/2024', 'Chờ xử lý', NULL, 11),
(31, 5, 44, 'cái', '21/05/2024', 'Chờ xử lý', NULL, 12),
(32, 11, 44, 'cái', '21/05/2024', 'Chờ xử lý', NULL, 12),
(34, 8, 145, 'cái', '23/05/2024', 'Chờ xử lý', 'kaka', 1);

--
-- Bẫy `orders`
--
DELIMITER $$
CREATE TRIGGER `update_order_quantity` AFTER INSERT ON `orders` FOR EACH ROW UPDATE `requests`
SET `order_quantity` = `order_quantity` + 1
WHERE `id` = NEW.request_id
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
(1, 'Tivi', '../images/products/1-tivi.jpg', 'Điện máy', 'Tivi thì để sờ em chứ còn làm gì'),
(2, 'Tủ lạnh', '../images/products/2-tulanh.jpg', 'Điện máy', 'Trời nóng thì vào nằm cho mát'),
(3, 'Máy giặt', '../images/products/3-maygiat.png', 'Điện máy', 'Nhân cách bẩn quá thì vào để reset'),
(4, 'Máy hút bụi', '../images/products/4-mayhutbui.jpg', 'Gia dụng', 'Dùng nhiều không biết nhà có sạch không nhưng ít ra nó đỡ bẩn hơn không dùng'),
(5, 'Láp tóp tóp', '../images/products/5-laptop.jpg', 'Công nghệ', 'Phương tiện đưa bạn lên thách đấu'),
(6, 'Ai phôn nè', '../images/products/6-iphone.png', 'Công nghệ', 'Không phải Android'),
(7, 'Lò nướng', '../images/products/7-lonuong.jpg', 'Gia dụng', 'Khoai nướng siêu ngon, đảm bảo nương khoái'),
(8, 'Kẹo mút', '../images/products/8-keomut.jpg', 'Thực phẩm', 'Mút mút mút'),
(9, 'Nước ngọt', '../images/products/9-nuocngot.jpg', 'Đồ uống', 'Uống kèm với thuốc cho đỡ đắng'),
(10, 'Tai nghe', '../images/products/10-tainghe.jpg', 'Công nghệ', 'Ủa? Tai không để nghe thì để làm gì'),
(11, 'Chuột Mickey', '../images/products/11-chuotkhongday.jpg', 'Công nghệ', 'Để bắt Doraemon'),
(12, 'Cái nịt', '../images/products/12-cainit.jpg', 'Vật phẩm quý hiếm', ':D');

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
  `status` varchar(50) NOT NULL DEFAULT 'Chờ gửi'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `requests`
--

INSERT INTO `requests` (`id`, `name`, `order_quantity`, `send_date`, `description`, `status`) VALUES
(1, 'Request 01', 5, '2024-05-18 11:34:15', 'Cần đặt cấp tốc ', 'Chờ xử lý'),
(2, 'Request 02', 2, '2024-05-18 11:34:15', 'Mua lẹ em ơi', 'Chờ xử lý'),
(3, 'Request 03', 2, '2024-05-18 11:34:15', 'Chú ý chọn hàng xịn', 'Chờ xử lý'),
(4, 'Request 04', 2, '2024-05-18 11:34:15', 'Yêu cầu đặt hàng về hàng đặt', 'Chờ xử lý'),
(5, 'Request 05', 2, '2024-05-18 11:34:15', '050505050', 'Chờ xử lý'),
(6, 'Request 06', 2, '2024-05-18 11:34:15', 'đặt hàng 6', 'Chờ xử lý'),
(7, 'Request 07', 2, '2024-05-18 11:34:15', 'thất thất thất', 'Chờ xử lý'),
(8, 'Request 08', 2, '2024-05-18 11:34:15', 'tám chín mười một trăm', 'Chờ xử lý'),
(9, 'Request 09', 2, '2024-05-18 11:34:15', 'chín rồi, ăn được rồi', 'Chờ xử lý'),
(10, 'Request 10', 2, '2024-05-18 11:34:15', 'mười điểm', 'Chờ xử lý'),
(11, 'Request 11', 2, '2024-05-18 11:34:15', 'hehe', 'Chờ xử lý'),
(12, 'Request 12', 2, '2024-05-18 11:34:15', 'haha', 'Chờ xử lý'),
(13, 'test', 0, '2024-05-18 16:48:11', 'ko coji', 'Chờ gửi');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `siteorders`
--

CREATE TABLE `siteorders` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `order_id` bigint(20) UNSIGNED NOT NULL,
  `site_id` bigint(20) UNSIGNED NOT NULL,
  `quantity` int(11) NOT NULL,
  `delivery_type` varchar(5) NOT NULL DEFAULT 'ship',
  `price` double NOT NULL,
  `status` varchar(50) NOT NULL DEFAULT 'Chờ xác nhận',
  `note` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(1, 1, 1, 9990, 0, 21000000),
(2, 1, 2, 9999, 0, 15000000),
(3, 1, 3, 9999, 0, 12000000),
(4, 1, 4, 9999, 5, 7500000),
(5, 1, 7, 9876, 20, 4500000),
(6, 2, 11, 9999, 0, 1500000),
(7, 2, 12, 1, 0, 99999999999),
(8, 2, 5, 9999, 12, 40000000),
(9, 2, 3, 9876, 0, 12500000),
(10, 2, 2, 8888, 0, 14800000),
(11, 3, 6, 9999, 0, 30000000),
(12, 3, 11, 9876, 0, 1675000),
(13, 3, 5, 9777, 7, 39800000),
(14, 3, 10, 9866, 0, 2000000),
(15, 3, 12, 1, 0, 9888888888),
(16, 4, 8, 99999, 0, 900),
(17, 4, 9, 99999, 0, 9000),
(18, 4, 4, 10235, 0, 7250000),
(19, 4, 5, 5469, 0, 40500000),
(20, 4, 10, 15200, 0, 1980000),
(21, 5, 7, 9999, 0, 4725000),
(22, 5, 1, 15200, 0, 20500000),
(23, 5, 6, 7891, 0, 31000000),
(24, 5, 7, 12000, 0, 4250000),
(25, 5, 8, 152365, 0, 850),
(26, 6, 9, 14236, 0, 8600),
(27, 6, 1, 2100, 0, 21200000),
(28, 6, 2, 12365, 0, 15750000),
(29, 6, 5, 11111, 0, 38999000),
(30, 6, 10, 8888, 0, 2050000),
(31, 7, 3, 15220, 0, 11800000),
(32, 7, 4, 14566, 0, 7550000),
(33, 7, 6, 14555, 0, 29800000),
(34, 7, 9, 52300, 0, 9200),
(35, 7, 11, 9563, 0, 1400000),
(36, 8, 8, 87000, 0, 970),
(37, 8, 3, 12366, 0, 12250000),
(38, 8, 12, 1, 0, 9876543210),
(39, 8, 5, 3985, 0, 39600000),
(40, 8, 2, 4444, 0, 14870000),
(41, 9, 8, 125000, 0, 920),
(42, 9, 3, 8750, 0, 11950000),
(43, 9, 7, 12222, 0, 4400000),
(44, 9, 6, 12500, 0, 30800000),
(45, 9, 11, 12554, 0, 1480000),
(46, 10, 1, 1452, 0, 20800000),
(47, 10, 4, 125, 0, 7400000),
(48, 10, 10, 500, 0, 1980000),
(49, 10, 9, 1253, 0, 9000),
(50, 10, 7, 500, 0, 4600000),
(51, 11, 12, 1, 0, 9777777000),
(52, 11, 1, 125, 0, 20900000),
(53, 11, 4, 145, 0, 7600000),
(54, 11, 6, 253, 0, 30500000),
(55, 11, 8, 1456, 0, 950),
(56, 12, 2, 450, 0, 14777000),
(57, 12, 9, 1250, 0, 8900),
(58, 12, 10, 365, 0, 2100000),
(59, 12, 11, 875, 0, 1550000),
(60, 12, 5, 390, 0, 39200000);

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
(4, 4, 22, 0),
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
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `requests`
--
ALTER TABLE `requests`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `siteorders`
--
ALTER TABLE `siteorders`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `siteproducts`
--
ALTER TABLE `siteproducts`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

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
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

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
