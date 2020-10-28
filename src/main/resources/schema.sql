-- Supplier table
CREATE TABLE IF NOT EXISTS supplier (
                                        user_id INTEGER NOT NULL ,
                                        firstname VARCHAR (100) NOT NULL ,
                                        lastname VARCHAR(100) NOT NULL ,
                                        phoneNumber VARCHAR(100) NOT NULL ,
                                        email VARCHAR(100) NOT NULL ,
                                        organization VARCHAR(100) NOT NULL ,
                                        CONSTRAINT supplier_pk PRIMARY KEY (user_id)
);

-- Consumer table
CREATE TABLE IF NOT EXISTS consumer (
                                        user_id INTEGER NOT NULL ,
                                        firstname VARCHAR(100) NOT NULL ,
                                        lastname VARCHAR(100) NOT NULL ,
                                        phoneNumber VARCHAR(100) NOT NULL ,
                                        email VARCHAR(100) NOT NULL ,
                                        counterpartyType VARCHAR(100) NOT NULL ,
                                        CONSTRAINT consumer_pk PRIMARY KEY (user_id)
);

-- Goods table
CREATE TABLE IF NOT EXISTS goods (
                                        id serial NOT NULL UNIQUE ,
                                        name VARCHAR(100) NOT NULL ,
                                        price NUMERIC(5, 2) NOT NULL ,
                                        goods_type_id INTEGER NOT NULL ,
                                        supplier_id INTEGER NOT NULL ,
                                        CONSTRAINT goods_pk PRIMARY KEY (id, goods_type_id)
);

-- GoodsType table
CREATE TABLE IF NOT EXISTS goods_type (
                                         id serial NOT NULL UNIQUE ,
                                         parent_id INTEGER ,
                                         name VARCHAR(100) NOT NULL ,
                                         vendorCode VARCHAR(100) NOT NULL ,
                                         CONSTRAINT goods_type_pk PRIMARY KEY (id)
);

-- User table
CREATE TABLE IF NOT EXISTS "user" (
                                         id serial NOT NULL UNIQUE,
                                         username VARCHAR(100) NOT NULL UNIQUE ,
                                         password VARCHAR(100) NOT NULL ,
                                         CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Role table table
CREATE TABLE IF NOT EXISTS role (
                                        id serial NOT NULL UNIQUE,
                                        name VARCHAR(50) NOT NULL UNIQUE
);

-- User_Role table
CREATE TABLE IF NOT EXISTS user_role (
                                        id serial NOT NULL UNIQUE,
                                        user_id INTEGER NOT NULL,
                                        role_id INTEGER NOT NULL
);

-- Order table
CREATE TABLE IF NOT EXISTS "order" (
                                       id serial NOT NULL UNIQUE,
                                       number INTEGER NOT NULL ,
                                       user_id INTEGER NOT NULL ,
                                       orderDate TIMESTAMP NOT NULL ,
                                       CONSTRAINT order_pk PRIMARY KEY (id, user_id)
);

-- BasketOfGoods table table
CREATE TABLE IF NOT EXISTS basket_of_goods (
                                        goods_id INTEGER NOT NULL ,
                                        order_id INTEGER NOT NULL ,
                                        count INTEGER NOT NULL ,
                                        sum NUMERIC(5, 2) NOT NULL
);

-- adding foreign key for tables
ALTER TABLE goods DROP CONSTRAINT IF EXISTS goods_fk1;
ALTER TABLE goods ADD CONSTRAINT goods_fk1 FOREIGN KEY (goods_type_id) REFERENCES goods_type(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE goods DROP CONSTRAINT IF EXISTS goods_fk2;
ALTER TABLE goods ADD CONSTRAINT goods_fk2 FOREIGN KEY (supplier_id) REFERENCES supplier(user_id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE goods_type DROP CONSTRAINT IF EXISTS goods_type_fk;
ALTER TABLE goods_type ADD CONSTRAINT goods_type_fk FOREIGN KEY (parent_id) REFERENCES goods_type(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "order" DROP CONSTRAINT IF EXISTS order_fk;
ALTER TABLE "order" ADD CONSTRAINT order_fk FOREIGN KEY (user_id) REFERENCES consumer(user_id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE consumer DROP CONSTRAINT IF EXISTS consumer_fk;
ALTER TABLE consumer ADD CONSTRAINT consumer_fk FOREIGN KEY (user_id) REFERENCES "user"(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE supplier DROP CONSTRAINT IF EXISTS supplier_fk;
ALTER TABLE supplier ADD CONSTRAINT supplier_fk FOREIGN KEY (user_id) REFERENCES "user"(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE user_role DROP CONSTRAINT IF EXISTS user_role_fk1;
ALTER TABLE user_role ADD CONSTRAINT user_role_fk1 FOREIGN KEY (user_id) REFERENCES "user"(id);
ALTER TABLE user_role DROP CONSTRAINT IF EXISTS user_role_fk2;
ALTER TABLE user_role ADD CONSTRAINT user_role_fk2 FOREIGN KEY (role_id) REFERENCES role(id);

ALTER TABLE basket_of_goods DROP CONSTRAINT IF EXISTS basket_of_goods_fk1;
ALTER TABLE basket_of_goods ADD CONSTRAINT basket_of_goods_fk1 FOREIGN KEY (goods_id) REFERENCES goods(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE basket_of_goods DROP CONSTRAINT IF EXISTS basket_of_goods_fk2;
ALTER TABLE basket_of_goods ADD CONSTRAINT basket_of_goods_fk2 FOREIGN KEY (order_id) REFERENCES "order"(id)  ON DELETE CASCADE ON UPDATE CASCADE;
