USE AIMS_System;

CREATE TABLE media (
  id int NOT NULL AUTO_INCREMENT,
  category varchar(45) NOT NULL,
  price int NOT NULL,
  quantity int NOT NULL,
  title varchar(55) NOT NULL,
  value int NOT NULL,
  imageUrl varchar(55) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE book (
  id int NOT NULL AUTO_INCREMENT,
  author varchar(55) NOT NULL,
  coverType varchar(55) NOT NULL,
  language varchar(55) NOT NULL,
  bookCategory varchar(55) NOT NULL,
  publisher varchar(55) NOT NULL,
  publishDate DATETIME NOT NULL,
  numberOfPages int NOT NULL,
  mediaId int NOT NULL,
  PRIMARY KEY (id),
  CONSTRAint fk_book_media FOREIGN KEY (id) REFERENCES media(id)
);

CREATE TABLE cd (
  id int NOT NULL,
  artist varchar(55) NOT NULL,
  recordLabel varchar(55) NOT NULL,
  musicType varchar(55) NOT NULL,
  releasedDate DATE NULL DEFAULT NULL,
  mediaId int NOT NULL,
  PRIMARY KEY (id),
  CONSTRAint fk_cd_media FOREIGN KEY (id) REFERENCES media(id)
);

CREATE TABLE dvd (
  id int NOT NULL,
  discType varchar(45) NOT NULL,
  director varchar(45) NOT NULL,
  runtime int NOT NULL,
  studio varchar(55) NOT NULL,
  subtitle varchar(55) NOT NULL,
  releasedDate DATETIME NULL DEFAULT NULL,
  mediaId int NOT NULL,
  PRIMARY KEY (id),
  CONSTRAint fk_dvd_media FOREIGN KEY (id) REFERENCES media(id)
);

CREATE TABLE deliveryInfo (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NULL DEFAULT NULL,
  province varchar(45) NULL DEFAULT NULL,
  instructions varchar(55) NULL DEFAULT NULL,
  address varchar(55) NULL DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE orders (
  id int NOT NULL,
  shippingFees varchar(55) NULL DEFAULT NULL,
  DeliveryInfoId int NOT NULL,
  rushorders BIT NOT NULL,
  expectedTime varchar(55),
  PRIMARY KEY (id),
  CONSTRAint fk_orders_deliveryInfo FOREIGN KEY (id) REFERENCES deliveryInfo(id)
);

CREATE TABLE invoice (
  id int NOT NULL,
  totalAmount int NOT NULL,
  ordersId int NOT NULL,
  PRIMARY KEY (id),
  CONSTRAint fk_invoice_orders FOREIGN KEY (id) REFERENCES orders(id)
);

CREATE TABLE ordersMedia (
  ordersId int NOT NULL,
  price int NOT NULL,
  quantity int NOT NULL,
  mediaId int NOT NULL,
  PRIMARY KEY (ordersId, mediaId),
  CONSTRAint fk_ordersmedia_media FOREIGN KEY (mediaId) REFERENCES media(id),
  CONSTRAint fk_ordersmedia_orders FOREIGN KEY (ordersId) REFERENCES orders(id)
);

CREATE TABLE paymentTransaction (
  id int NOT NULL,
  createAt DATETIME NOT NULL,
  content varchar(55) NOT NULL,
  method varchar(55) NULL DEFAULT NULL,
  invoiceId int NOT NULL,
  PRIMARY KEY (id),
  CONSTRAint fk_paymentTransaction_invoice FOREIGN KEY (id) REFERENCES invoice(id)
);

