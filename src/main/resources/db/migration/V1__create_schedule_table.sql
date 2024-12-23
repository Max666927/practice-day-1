CREATE TABLE delivery_schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(50) NOT NULL,
    delivery_number INT NOT NULL,
    delivery_date DATE NOT NULL,
    supplier VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    unloading_shop VARCHAR(50) NOT NULL
);
