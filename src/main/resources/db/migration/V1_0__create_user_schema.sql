CREATE TABLE IF NOT EXISTS `citizens` (

`citizens_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`full_name` varchar(20),
`nik` varchar(20),
`date_of_birth` date

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;