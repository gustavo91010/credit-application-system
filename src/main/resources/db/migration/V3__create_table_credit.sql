
CREATE TABLE address(
  id SERIAL PRIMARY KEY,
  credit_code UUID NOT NULL,
  credit_value DECIMAL(19,2) DEFAULT 0,
  day_first_of_installment DATE NOT NULL,
  number_of_installements INT NOT NULL,
  customer_id BIGINT NOT NULL,
  status VARCHAR(20) NOT NULL
);
