
CREATE TABLE `login` (
  `Nome` varchar(220) NOT NULL,
  `Cpf` varchar(220) NOT NULL,
  `Senha` varchar(220) NOT NULL,
  `Funcao` varchar(220) NOT NULL,
  `Id` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`Nome`, `Cpf`, `Senha`, `Funcao`, `Id`) VALUES
('User', '12', '12', 'Gerente', 695),
('User', '123', '123', 'Repositor', 454),
('User', '321', '321', 'Vendedor', 456);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `Nome` varchar(220) NOT NULL,
  `Tipo` varchar(220) NOT NULL,
  `ValorCompra` float NOT NULL,
  `ValorVenda` float NOT NULL,
  `Disponibilidade` int(10) NOT NULL,
  `Id` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`Nome`, `Tipo`, `ValorCompra`, `ValorVenda`, `Disponibilidade`, `Id`) VALUES
('Trident', 'doce', 8, 10, 12, 2),
('Gin', 'Bebida', 12, 21, 71, 5);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `login`
--
ALTER TABLE `login`
  ADD UNIQUE KEY `Cpf` (`Cpf`),
  ADD KEY `Id` (`Id`) USING BTREE;

--
-- Índices para tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Nome` (`Nome`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `login`
--
ALTER TABLE `login`
  MODIFY `Id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=700;

--
-- AUTO_INCREMENT de tabela `produtos`
--
ALTER TABLE `produtos`
  MODIFY `Id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
