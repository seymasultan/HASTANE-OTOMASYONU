-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 30 Ara 2018, 21:27:56
-- Sunucu sürümü: 10.1.37-MariaDB
-- PHP Sürümü: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `hastane_otomasyonu`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `bolum`
--

CREATE TABLE `bolum` (
  `id` int(11) NOT NULL,
  `bolum_adı` varchar(128) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `bolum`
--

INSERT INTO `bolum` (`id`, `bolum_adı`) VALUES
(1, 'Kardiyoloji'),
(2, 'Göz Hastalıkları'),
(3, 'Nöroloji'),
(4, 'KBB'),
(5, 'Histoloji ve Embriyoloji'),
(6, 'Kalp Ve Damar Cerrahisi'),
(7, 'Ortopedi Ve Travmatoloji'),
(8, 'Radyoloji'),
(9, 'Çocuk Sağlığı Ve Hastalıkları'),
(10, 'Üroloji'),
(11, 'Fiziksel Tıb Ve Rehabilitasyon'),
(12, 'Genel Cerrahi'),
(13, 'Mikrobiyoloji'),
(14, 'Dermatoloji');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `doktorlar`
--

CREATE TABLE `doktorlar` (
  `id` int(11) NOT NULL,
  `adı` varchar(128) COLLATE utf8_turkish_ci NOT NULL,
  `soyadı` varchar(128) COLLATE utf8_turkish_ci NOT NULL,
  `bolum_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `doktorlar`
--

INSERT INTO `doktorlar` (`id`, `adı`, `soyadı`, `bolum_id`) VALUES
(21, 'Gonca ', 'Erbaş', 8),
(22, 'Gülçin', 'Kaymak', 11),
(23, 'Hakan', 'Atabar', 7),
(24, 'İdil', 'Yenicesu', 9),
(25, 'İlhan', 'Yetkin', 10),
(26, 'İrem', 'Çapraz', 3),
(27, 'Kağan', 'Sönmez', 2),
(28, 'Kemal', 'Uygur', 5),
(29, 'Kıvılcım', 'Gücüyener', 12),
(30, 'Levent ', 'Gökgöz', 6),
(31, 'Mehmet', 'Karamercan', 1),
(32, 'Mehmet', 'Erdem', 4),
(33, 'Gülçin', 'Çınar', 1),
(34, 'Zeynep', 'GÜLAY', 13),
(35, 'Mine', 'DERELİ', 13),
(36, 'Turna', 'İlknur', 14),
(37, 'Sevgi', 'Akarsu', 14),
(38, 'Murat', 'Duman', 9),
(39, 'Banu', 'Dilek', 11),
(40, 'Ataç', 'Sönmez', 8),
(41, 'Enis', 'Güneri', 4),
(42, 'Ömer', 'Akçalı', 7),
(43, 'Tufan', 'Egeli', 12),
(44, 'Aras', 'Canda', 12),
(45, 'Hakan', 'Öner', 2),
(46, 'Ayşe Tülin', 'Berk', 2),
(49, 'Berril', 'Dönmez', 3),
(50, 'Erdem', 'Yaka', 3),
(51, 'Güven', 'Erbil', 5),
(52, 'Turan', 'Gençpınar', 6),
(53, 'İlhan', 'Çelebi', 10);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hastalar`
--

CREATE TABLE `hastalar` (
  `id` bigint(255) UNSIGNED NOT NULL,
  `ad` varchar(128) COLLATE utf8_turkish_ci NOT NULL,
  `soyad` varchar(128) COLLATE utf8_turkish_ci NOT NULL,
  `tc_kimlik` bigint(255) UNSIGNED NOT NULL,
  `kan_grubu` varchar(6) COLLATE utf8_turkish_ci DEFAULT NULL,
  `parola` varchar(128) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `hastalar`
--

INSERT INTO `hastalar` (`id`, `ad`, `soyad`, `tc_kimlik`, `kan_grubu`, `parola`) VALUES
(14, 'Cihat', 'Cüni', 12345678999, 'ARh+', '26062018'),
(15, 'Şeyma Sultan', 'Sözen', 12345678912, '0Rh+', '0606'),
(17, 'Mukaddes', 'Sözen', 14725836914, 'ARh+', '4444'),
(18, 'Esra', 'Özkul', 96385274196, 'ARh+', 'esrauz'),
(20, 'Eda', 'Aköz', 22233344455, 'ARh+', 'edanur75'),
(21, 'Rabia', 'Çalışkan', 48700235115, '0Rh+', '15K15'),
(22, 'Sıla', 'Eryılmaz', 75234918492, 'ABRh+', '62348'),
(23, 'Kübra', 'Çalış', 25375805321, 'BRh+', '9876'),
(27, 'Seda', 'Durmuş', 25160163333, 'ARh+', '33333');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `randevular`
--

CREATE TABLE `randevular` (
  `id` int(11) NOT NULL,
  `hst_ad` varchar(128) COLLATE utf8_turkish_ci NOT NULL,
  `dok_ad` varchar(128) COLLATE utf8_turkish_ci NOT NULL,
  `tarih` date NOT NULL,
  `saat` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `randevular`
--

INSERT INTO `randevular` (`id`, `hst_ad`, `dok_ad`, `tarih`, `saat`) VALUES
(1, 'şeyma sultan sözen', 'Mehmet Karamercan', '2018-12-25', '08:00:00'),
(3, 'şeyma sultan sözen', 'Kağan Sönmez', '2018-12-26', '08:15:00'),
(10, 'şeyma sultan sözen', 'Kemal Uygur', '2018-12-20', '11:30:00'),
(11, 'Esra Özkul', 'Gülçin Çınar', '2018-12-29', '09:15:00'),
(12, 'Eda Aköz', 'Kıvılcım Gücüyener', '2019-01-16', '12:30:00'),
(13, 'Eda Aköz', 'Gonca  Erbaş', '2019-02-04', '17:45:00'),
(14, 'Rabia Çalışkan', 'İrem Çapraz', '2019-01-25', '14:30:00'),
(15, 'Rabia Çalışkan', 'Kıvılcım Gücüyener', '2019-02-06', '11:15:00'),
(16, 'Sıla Eryılmaz', 'Kağan Sönmez', '2018-12-30', '16:15:00'),
(17, 'Mukaddes Sözen', 'Hakan Atabar', '2019-01-29', '09:45:00'),
(18, 'Cihat Cüni', 'Mehmet Erdem', '2019-02-18', '12:15:00'),
(19, 'Cihat Cüni', 'Levent  Gökgöz', '2019-02-28', '09:00:00'),
(20, 'Kübra Çalış', 'Enis Güneri', '2019-01-31', '11:15:00'),
(21, 'Kübra Çalış', 'Turan Gençpınar', '2019-01-21', '16:45:00'),
(22, 'Sıla Eryılmaz', 'Sevgi Akarsu', '2018-12-30', '08:00:00'),
(23, 'Sıla Eryılmaz', 'Zeynep GÜLAY', '2019-01-03', '13:45:00'),
(25, 'Seda Durmuş', 'Kıvılcım Gücüyener', '2018-12-31', '11:30:00');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `bolum`
--
ALTER TABLE `bolum`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `doktorlar`
--
ALTER TABLE `doktorlar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bolum_id` (`bolum_id`);

--
-- Tablo için indeksler `hastalar`
--
ALTER TABLE `hastalar`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `tc_kimlik` (`tc_kimlik`);

--
-- Tablo için indeksler `randevular`
--
ALTER TABLE `randevular`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `bolum`
--
ALTER TABLE `bolum`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Tablo için AUTO_INCREMENT değeri `doktorlar`
--
ALTER TABLE `doktorlar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- Tablo için AUTO_INCREMENT değeri `hastalar`
--
ALTER TABLE `hastalar`
  MODIFY `id` bigint(255) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Tablo için AUTO_INCREMENT değeri `randevular`
--
ALTER TABLE `randevular`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `doktorlar`
--
ALTER TABLE `doktorlar`
  ADD CONSTRAINT `doktorlar_ibfk_1` FOREIGN KEY (`bolum_id`) REFERENCES `bolum` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
