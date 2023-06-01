CREATE DATABASE `tarefas` ;
USE tarefas;

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) DEFAULT NULL,
  `nome` varchar(250) DEFAULT NULL,
  `senha` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tarefa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(20) DEFAULT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `data_criacao` date DEFAULT NULL,
  `data_conclusao` date DEFAULT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE tarefa ADD CONSTRAINT fk_tarefa_id FOREIGN KEY (id_usuario) REFERENCES usuarios (id);
select * from tarefa;
