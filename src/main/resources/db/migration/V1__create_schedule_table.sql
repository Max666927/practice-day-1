CREATE TABLE schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    supply_number INT NOT NULL,
    supply_date DATE NOT NULL,
    supplier VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    unloading_store VARCHAR(255) NOT NULL
);
