CREATE TABLE `expense` (
  `id` int(11) NOT NULL,
  `person_name` varchar(100) COLLATE utf8_unicode_520_ci,
  `description` varchar(200) COLLATE utf8_unicode_520_ci,
  `date_time` datetime NOT NULL,
  `value` decimal(10,0) NOT NULL,
  `tags` varchar(100) COLLATE utf8_unicode_520_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci;

ALTER TABLE `expense`
  ADD PRIMARY KEY (`id`);
  
  ALTER TABLE `expense`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;