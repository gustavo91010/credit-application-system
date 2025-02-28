
CREATE TABLE address(
    id SERIAL PRIMARY KEY,
    zip_code VARCHAR(20) NOT NULL,
    street VARCHAR(100) NOT NULL,
    number VARCHAR(20) NOT NULL ,
  customer_id BIGINT
);
