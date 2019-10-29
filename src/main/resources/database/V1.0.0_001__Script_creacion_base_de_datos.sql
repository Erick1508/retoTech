-- ----------------------------------------------------------------------------
-- Creacion de base de datos
-- ----------------------------------------------------------------------------
CREATE TABLE client (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name  VARCHAR(100),
  lastName  VARCHAR(100),
  age  INT,
  birthday  DATE,
  PRIMARY KEY (id)
);


