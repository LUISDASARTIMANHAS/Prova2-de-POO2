-- -----------------------------------------------------
-- Table Produto
-- -----------------------------------------------------
CREATE TABLE Produto (
  idProduto SERIAL,
  nome VARCHAR(100) NOT NULL,
  quantidade INT NOT NULL,
  preco FLOAT NOT NULL,
  PRIMARY KEY (idProduto)
);


-- -----------------------------------------------------
-- Table Venda
-- -----------------------------------------------------
CREATE TABLE Venda (
  idVenda SERIAL,
  dataVenda DATE NOT NULL,
  qtdeVendida INT NOT NULL,
  valorTotal FLOAT NOT NULL,
  idProduto INT NOT NULL,
  PRIMARY KEY (idVenda),
  FOREIGN KEY (idProduto)
    REFERENCES Produto (idProduto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
