CREATE TABLE IF NOT EXISTS `order`
(
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `user_id` BIGINT NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `required_at` DATETIME,
    `delivered_at` DATETIME,
    `created_date` DATETIME NOT NULL,
    `updated_date` DATETIME DEFAULT NULL,
    INDEX idx__user_id (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `order_item`
(
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `order_id` BIGINT NOT NULL,
    `item_id` BIGINT NOT NULL,
    `inventory_id` BIGINT NOT NULL,
    `name` VARCHAR(50),
    `status` VARCHAR(50) NOT NULL,
    `quantity` INT NOT NULL,
    `required_at` DATETIME,
    `created_date` DATETIME NOT NULL,
    `updated_date` DATETIME DEFAULT NULL,
    INDEX idx__order_id (`order_id`),
    FOREIGN KEY (`order_id`) REFERENCES `order`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
