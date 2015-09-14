SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `shopping`
--

-- --------------------------------------------------------

--
-- 表的结构 `cart`
--

CREATE TABLE IF NOT EXISTS `cart` (
  `cartId` int(10) NOT NULL AUTO_INCREMENT,
  `productId` int(10) NOT NULL,
  `amount` int(10) NOT NULL,
  `userId` int(20) NOT NULL,
  PRIMARY KEY (`cartId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- 转存表中的数据 `cart`
--

INSERT INTO `cart` (`cartId`, `productId`, `amount`, `userId`) VALUES
(1, 2, 2, 3),
(2, 3, 1, 3),
(12, 5, 3, 5),
(13, 6, 1, 5),
(15, 1, 1, 5),
(17, 1, 1, 6),
(18, 1, 2, 7),
(19, 1, 1, 8);

-- --------------------------------------------------------

--
-- 表的结构 `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `pId` int(11) DEFAULT NULL,
  `categoryName` varchar(255) NOT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- 转存表中的数据 `category`
--

INSERT INTO `category` (`categoryId`, `pId`, `categoryName`) VALUES
(1, 1, 'Phone'),
(2, 2, 'Phone'),
(3, 3, 'Phone'),
(4, NULL, 'Book'),
(5, NULL, 'Fruit'),
(6, NULL, 'Computer'),
(7, NULL, ' Salad'),
(8, NULL, 'Pizza'),
(9, NULL, 'Hamburger');

-- --------------------------------------------------------

--
-- 表的结构 `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `context` text NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  `quantity` int(10) NOT NULL,
  `categoryName` varchar(100) NOT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- 转存表中的数据 `product`
--

INSERT INTO `product` (`productId`, `productName`, `price`, `context`, `image`, `quantity`, `categoryName`) VALUES
(1, 'Iphone 5s', 6000, 'A chip with 64-bit architecture. A fingerprint identity sensor. A better, faster camera. And an operating system built specifically for 64-bit. Any one of these features in a smartphone would make it ahead of its time. All of these features in a smartphone make it an iPhone that’s definitely ahead of its time.', 'Phone/iphone5s.jpg', 10, 'Phone'),
(2, 'Iphone 4s', 5000, 'The iPhone 4S, the successor to the iPhone 4, is marked by a number of under-the-hood improvements, as well as major software additions. The iPhone 4S is also the first iPhone to work officially on the Sprint network.', 'Phone/iphone4s.jpg', 5, 'Phone'),
(3, 'Note2 SAMSUNG', 3000, 'Samsung Galaxy Note II sports a slightly bigger, 5.5-inch display, a quad-core processor that gets rid of the slight lag in the original Note, and best of all Android 4.1 Jelly Bean right out of the box. The Galaxy Note II is armed with a brighter and larger 5.5” HD Super AMOLED display with resolution of 720 x 1280 pixels.', 'Phone/note2.jpg', 23, 'Phone'),
(4, 'strawberry', 20, 'adfkjalkdfjklajdflka', 'Fruit/strawberry.jpg', 100, 'Fruit'),
(5, 'Banana', 25, 'banana banana banana banana', 'Fruit/banana.jpg', 100, 'Fruit'),
(6, 'Apple', 10, 'apple,apple,apple,apple,appleapple,apple', 'Fruit/apple.jpg', 144, 'Fruit'),
(7, 'Book1', 30, 'This is my first english book', 'Book/book1.jpg', 35, 'Book'),
(8, 'Book2', 44, 'This is my first chinese book', 'Book/book2.jpg', 22, 'Book'),
(9, 'Book3', 99, 'This is the mathmatic book', 'Book/book3.jpg', 11, 'Book');

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `password` varchar(16) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `cartId` int(25) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`userId`, `name`, `password`, `email`, `address`, `cartId`) VALUES
(1, 'admin', 'admin', 'abelldandy@hotail.com', 'Rack', 1),
(5, 'user1', 'user1', 'user1@hotmail.com', 'user1 addressss', 0),
(6, 'user2', 'user2', 'user1@hotmail.com', 'user3', 0),
(7, 'feng', 'feng', 'fengziyi@hotmail.com', 'fengziyi', 0),
(8, 'lan', 'lan', 'lan', 'lan', 0);