-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 22, 2024 lúc 05:54 PM
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
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`request_id`) REFERENCES `requests` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
