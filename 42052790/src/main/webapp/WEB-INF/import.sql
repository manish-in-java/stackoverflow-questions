INSERT INTO credencial (nome) VALUES ('categoria');
INSERT INTO credencial (nome) VALUES ('produto');
INSERT INTO credencial (nome) VALUES ('pagina');
INSERT INTO credencial (nome) VALUES ('usuario');
INSERT INTO credencial (nome) VALUES ('admin');

INSERT INTO autorizacao (nome) VALUES ('insert_categoria');
INSERT INTO autorizacao (nome) VALUES ('update_categoria');
INSERT INTO autorizacao (nome) VALUES ('delete_categoria');

INSERT INTO autorizacao (nome) VALUES ('insert_produto');
INSERT INTO autorizacao (nome) VALUES ('update_produto');
INSERT INTO autorizacao (nome) VALUES ('delete_produto');

INSERT INTO autorizacao (nome) VALUES ('insert_pagina');
INSERT INTO autorizacao (nome) VALUES ('update_pagina');
INSERT INTO autorizacao (nome) VALUES ('delete_pagina');

INSERT INTO autorizacao (nome) VALUES ('insert_usuario');
INSERT INTO autorizacao (nome) VALUES ('update_usuario');
INSERT INTO autorizacao (nome) VALUES ('delete_usuario');

INSERT INTO credencial_autorizacao VALUES (1,1);
INSERT INTO credencial_autorizacao VALUES (1,2);
INSERT INTO credencial_autorizacao VALUES (1,3);

INSERT INTO credencial_autorizacao VALUES (2,4);
INSERT INTO credencial_autorizacao VALUES (2,5);
INSERT INTO credencial_autorizacao VALUES (2,6);

INSERT INTO credencial_autorizacao VALUES (3,7);
INSERT INTO credencial_autorizacao VALUES (3,8);
INSERT INTO credencial_autorizacao VALUES (3,9);

INSERT INTO credencial_autorizacao VALUES (4,10);
INSERT INTO credencial_autorizacao VALUES (4,11);
INSERT INTO credencial_autorizacao VALUES (4,12);

INSERT INTO usuario (login, senha, nome, sobrenome, email) VALUES ('klebermo', '202cb962ac59075b964b07152d234b70', 'kleber', 'mota', 'kleber@mail.com');

INSERT INTO usuario_credencial VALUES (1,1);
INSERT INTO usuario_credencial VALUES (1,2);
INSERT INTO usuario_credencial VALUES (1,3);
INSERT INTO usuario_credencial VALUES (1,4);
INSERT INTO usuario_credencial VALUES (1,5);
