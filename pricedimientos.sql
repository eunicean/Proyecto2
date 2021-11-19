DROP DATABASE IF EXISTS platillos;
CREATE DATABASE platillos;
USE platillos;

DROP TABLE IF EXISTS ingrediente;
CREATE TABLE ingrediente(
	id_ingrediente			INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_ingrediente		VARCHAR(100),
    cantidad_ingrediente 	VARCHAR(100),
    id_receta				INT
);

DROP TABLE IF EXISTS receta;
CREATE TABLE receta(
	id_receta		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_receta	VARCHAR(100),
    pasos			VARCHAR(200)
);

DROP TABLE IF EXISTS users;
CREATE TABLE users(
	id_user			INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_user		VARCHAR(100),
    contr			VARCHAR(100),
    rol				INT
);

DROP TABLE IF EXISTS r_favoritos;
CREATE TABLE r_favoritos(
    id_receta		INT,
    id_user			INT
);

#Agregar una receta
DROP PROCEDURE IF EXISTS add_receta;
DELIMITER //
CREATE PROCEDURE add_receta
(
	IN cnombre_receta    		VARCHAR(100),
	IN cnombre_ingrediente1   	VARCHAR(100),
    IN ccantidad_ingrediente1	VARCHAR(100),
	IN cnombre_ingrediente2   	VARCHAR(100),
    IN ccantidad_ingrediente2	VARCHAR(100),
	IN cnombre_ingrediente3   	VARCHAR(100),
    IN ccantidad_ingrediente3	VARCHAR(100),
    IN cpasos_receta			VARCHAR(200)
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	
	INSERT INTO receta(nombre_receta,pasos) VALUES (cnombre_receta,cpasos_receta);
    
    SET @id_ultima_receta = LAST_INSERT_ID();
    
    INSERT INTO ingrediente(nombre_ingrediente, cantidad_ingrediente, id_receta)
	VALUES
	(cnombre_ingrediente1, ccantidad_ingrediente1, @id_ultima_receta),
	(cnombre_ingrediente2, ccantidad_ingrediente2, @id_ultima_receta),
	(cnombre_ingrediente3, ccantidad_ingrediente3, @id_ultima_receta);

END //
DELIMITER ;

#obtener todas las recetas sin pasos
DROP PROCEDURE IF EXISTS get_recetas;
DELIMITER //
CREATE PROCEDURE get_recetas()
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	SELECT 
	i.id_ingrediente,
    i.cantidad_ingrediente,
    i.nombre_ingrediente,
    (SELECT nombre_receta FROM receta r WHERE r.id_receta = i.id_receta) as nombreReceta,
    (SELECT id_receta FROM receta r WHERE r.id_receta = i.id_receta) as id_receta
	FROM ingrediente i;
END //
DELIMITER ;

#obtener las recetas con pasos
DROP PROCEDURE IF EXISTS get_recetas_pasos;
DELIMITER //
CREATE PROCEDURE get_recetas_pasos(
	IN pid_pasos	INT
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	SELECT 
	i.id_ingrediente,
    i.cantidad_ingrediente,
    i.nombre_ingrediente,
    (SELECT nombre_receta FROM receta r WHERE r.id_receta = i.id_receta) as nombreReceta,
    (SELECT id_receta FROM receta r WHERE r.id_receta = i.id_receta) as id_receta,
    (SELECT pasos FROM receta r WHERE r.id_receta = i.id_receta) as pasosRecetas
	FROM ingrediente i WHERE i.id_receta = pid_pasos;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS get_receta;
DELIMITER //
CREATE PROCEDURE get_receta(
	IN cid_receta	INT
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	SELECT 
	i.id_ingrediente,
    i.cantidad_ingrediente,
    i.nombre_ingrediente,
    (SELECT nombre_receta FROM receta r WHERE r.id_receta = i.id_receta) as nombreReceta,
    r.id_receta
	FROM ingrediente i
	WHERE i.id_receta = xcid_receta;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS get_users;
DELIMITER //
CREATE PROCEDURE get_users(

)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	SELECT * FROM users;
END //
DELIMITER ;

-- ro 0=administrador, 1 = visitante

DROP PROCEDURE IF EXISTS create_users;
DELIMITER //
CREATE PROCEDURE create_users(
	pnomb_user		VARCHAR(100),
    pcontrane		VARCHAR(100),
    prol			INT
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	INSERT INTO users(nombre_user,contr,rol) VALUES(pnomb_user,pcontrane,prol);
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS verf_users;
DELIMITER //
CREATE PROCEDURE verf_users(
	vnomb_user		VARCHAR(100),
    vcontrane		VARCHAR(100)
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	SELECT COUNT(*) FROM users WHERE nombre_user = vnomb_user AND contr = vcontrane;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS obt_rol_users;
DELIMITER //
CREATE PROCEDURE obt_rol_users(
	vnomb_user		VARCHAR(100),
    vcontrane		VARCHAR(100)
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	SELECT rol FROM users WHERE nombre_user = vnomb_user AND contr = vcontrane;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS drop_receta;
DELIMITER //
CREATE PROCEDURE drop_receta(
	id_drop		INT
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	SET SQL_SAFE_UPDATES =0;
    DELETE FROM receta where id_receta = id_drop;
    DELETE FROM ingrediente WHERE id_receta = id_drop;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS add_t_favoritos;
DELIMITER //
CREATE PROCEDURE add_t_favoritos(
	fid_receta		INT,
    fid_user			INT
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	INSERT INTO r_favoritos(id_receta,id_user) VALUES(fid_receta,fid_user);
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS get_favoritos;
DELIMITER //
CREATE PROCEDURE get_favoritos(
	IN user_idf		INT
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SHOW ERRORS;
END;
	SELECT 
	i.id_ingrediente,
    i.cantidad_ingrediente,
    i.nombre_ingrediente,
    (SELECT nombre_receta FROM receta r WHERE r.id_receta = i.id_receta) as nombreReceta,
    (SELECT id_receta FROM receta r WHERE r.id_receta = i.id_receta) as id_receta
	FROM ingrediente i, r_favoritos WHERE (r_favoritos.id_receta = i.id_receta) AND r_favoritos.id_user = user_idf;
END //
DELIMITER ;


CALL add_receta(
'TORTILLA DE PATATA RELLENA DE QUESO Y JAMON',
'Patata Mediana', '3 unidades',
'Huevos', '5 unidades', 
'Cebolla', '1/2 unidad'
);

CALL add_receta('Pan con queso', 'Pan', '2 rodajas', 'Queso', '500 gramos', '', '','Juntar todo');

CALL get_recetas();
CALL get_recetas_pasos();
CALL get_receta(1);

CALL get_users();

SELECT * FROM receta where nombre_receta LIKE '%Tortilla%';
SELECT * FROM receta;

INSERT INTO users(nombre_user,contr) VALUES ("test1","123"), ("test2", "456");

CALL add_t_favoritos(1,5);
CALL get_favoritos(6);

SELECT * FROM r_favoritos;

CALL create_users("Test1","000",1);
CALL obt_rol_users("Test3","111");
CALL obt_rol_users("Test1","000");

SELECT 
	(SELECT nombre_receta FROM receta r WHERE r.id_receta = i.id_receta) as nombre_receta
FROM ingrediente i
WHERE nombre_ingrediente LIKE '%queso%';

CALL drop_receta(3);
CALL pasos_receta(2);

DELETE FROM receta where id_receta = null;

SELECT * FROM receta;
