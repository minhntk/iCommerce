CREATE TABLE IF NOT EXISTS `delivery`
(
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `order_item_id` BIGINT NOT NULL,
    `store_id` BIGINT NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `delivery_by` VARCHAR(50) DEFAULT NULL,
    `delivery_from` VARCHAR(200) DEFAULT NULL,
    `delivery_to` VARCHAR(200) DEFAULT NULL,
    `plan_delivery_at` DATETIME DEFAULT NULL,
    `delivery_at` DATETIME DEFAULT NULL,
    `created_date` DATETIME NOT NULL,
    `updated_date` DATETIME DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE IF NOT EXISTS `shipper`
(
    `id` VARCHAR(50) PRIMARY KEY,
    `full_name` VARCHAR(150) NOT NULL,
    `phone_number` VARCHAR(50) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `created_date` DATETIME NOT NULL,
    `updated_date` DATETIME DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;