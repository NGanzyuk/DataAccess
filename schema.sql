CREATE TABLE CUSTOMERS (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    surname VARCHAR(255),
    age INT,
    phone_number VARCHAR(255)
);
CREATE TABLE ORDERS (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    date DATE,
    customer_id INT NOT NULL,
    product_name VARCHAR(255),
    amount INT
);