CREATE TABLE `library`.`readers` (
`id_reader` INT NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(45) NOT NULL,
`last_name` VARCHAR(45) NOT NULL,
`middle_name` VARCHAR(45) NOT NULL,
`telephone` VARCHAR(45) NULL,
PRIMARY KEY (`id_reader`));


CREATE TABLE `library`.`orders` (
  `id_order` INT NOT NULL AUTO_INCREMENT,
  `reader_id` INT NOT NULL,
  `data_order` DATETIME NOT NULL,
  `finished` TINYINT NOT NULL,
  PRIMARY KEY (`id_order`));

CREATE TABLE `library`.`give` (
  `id_give` INT NOT NULL AUTO_INCREMENT,
  `order_id` INT NOT NULL,
  `catalog_book_id` INT NOT NULL,
  `data_give` DATE NOT NULL,
  `finished` TINYINT NOT NULL,
  PRIMARY KEY (`id_give`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


