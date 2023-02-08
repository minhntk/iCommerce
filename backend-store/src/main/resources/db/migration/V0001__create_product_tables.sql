-- Extension for creating uuid

CREATE TABLE IF NOT EXISTS `store`
(
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(250) NOT NULL,
    `owner` BIGINT NOT NULL,
    `status` VARCHAR(15),
    `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_date` DATETIME DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

insert into store (id, name, description, owner, status)
values (1, 'Alpha Book Store', 'Book Store Description', 1, 'ACTIVE'),
       (2, 'Flower Store', 'Flower Store Description', 2, 'ACTIVE'),
       (3, 'XYZ Grocery', 'XYZ Grocery description', 3, 'ACTIVE'),
       (4, 'Bio-Oil Store', 'Bio-Oil Store description', 4, 'ACTIVE');


CREATE TABLE IF NOT EXISTS `category`
(
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `parent_id` VARCHAR(50),
    `status` VARCHAR(15),
    `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_date` DATETIME DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

insert into category (id, name, parent_id, status)
values (1, 'Book', null, 'ACTIVE'),
       (2, 'Baby & Toddler Toys', null, 'ACTIVE'),
       (3, 'Beauty & Personal Care', null, 'ACTIVE'),
       (4, 'Fiction', 1, 'ACTIVE'),
       (5, 'Skin Care', 3, 'ACTIVE'),
       (6, 'Oral Care', 3, 'ACTIVE');

CREATE TABLE IF NOT EXISTS `product`
(
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(250) NOT NULL,
    `category_id` VARCHAR(50) NOT NULL,
    `store_id` BIGINT,
    `status` VARCHAR(15),
    `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_date` DATETIME DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

insert into product (id, name, category_id, store_id, description)
values (1, 'Spring in action', 1, 1, 'Spring books for Java developers'),
       (2, 'Marvel Rise of the Domo', 2, 3, 'Lego bricks'),
       (3, 'Bio-Oil Skincare Oil', 5, 4, 'Give your skin a break while stuck inside!');


CREATE TABLE IF NOT EXISTS `product_price`
(
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `product_id` BIGINT NOT NULL,
    `description` VARCHAR(250) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `price` DECIMAL (10, 2) NOT NULL,
    `affected_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `expired_date` DATETIME DEFAULT NULL,
    `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_date` DATETIME DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

insert into product_price (id, product_id, price, description, status)
values (1, 1, 15.8, 'Promotion Price', 'ACTIVE'),
       (2, 2, 255, 'Promotion Price', 'ACTIVE'),
       (3, 3, 18.7, 'Promotion Price', 'ACTIVE');


