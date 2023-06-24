CREATE DATABASE `tarefas` ;
USE tarefas;

CREATE TABLE `usuarios` (
  `login` varchar(20) NOT NULL,
  `nome` varchar(250) DEFAULT NULL,
  `senha` varchar(250) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tarefa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(20) DEFAULT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `data_criacao` date DEFAULT NULL,
  `data_conclusao` date DEFAULT NULL,
  `login_usuario` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE tarefa ADD CONSTRAINT fk_tarefa_login FOREIGN KEY (login_usuario) REFERENCES usuarios (login);
select * from usuarios;