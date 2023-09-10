SELECT 
    ORDERS.product_name
FROM
    ORDERS
        INNER JOIN
    CUSTOMERS ON ORDERS.customer_id = CUSTOMERS.id
WHERE
    CUSTOMERS.name = ?;