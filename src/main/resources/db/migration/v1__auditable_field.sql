ALTER TABLE product
    ADD COLUMN created_by VARCHAR(255),
ADD COLUMN created_date TIMESTAMP,
ADD COLUMN last_modified_by VARCHAR(255),
ADD COLUMN last_modified_date TIMESTAMP;

ALTER TABLE sales
    ADD COLUMN created_by VARCHAR(255),
ADD COLUMN created_date TIMESTAMP,
ADD COLUMN last_modified_by VARCHAR(255),
ADD COLUMN last_modified_date TIMESTAMP;

ALTER TABLE sales_detail
    ADD COLUMN created_by VARCHAR(255),
ADD COLUMN created_date TIMESTAMP,
ADD COLUMN last_modified_by VARCHAR(255),
ADD COLUMN last_modified_date TIMESTAMP;

ALTER TABLE user
    ADD COLUMN created_by VARCHAR(255),
ADD COLUMN created_date TIMESTAMP,
ADD COLUMN last_modified_by VARCHAR(255),
ADD COLUMN last_modified_date TIMESTAMP;