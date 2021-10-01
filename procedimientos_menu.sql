#CLASES
USE mimenusin; #Conectar a la base datos

DROP TABLE IF EXISTS ingredientesprincipales;
CREATE TABLE 'ingredientesprincipales'(
    'nombrereceta' varchar(100) NOT NULL,
    'ingrediente1' varchar(100) NOT NULL,
    'ingrediente2' varchar(100) NOT NULL,
    'ingrediente3' varchar(100) NOT NULL,
    PRIMARY KEY (nombrereceta)
);

/*----------------------------------------PROCESOS----------------------------------------*/
/*------------------Agregar una receta------------------*/

DROP PROCEDURE IF EXISTS agregar_receta;
DELIMITER //
CREATE PROCEDURE agregar_receta(
    IN nombrereceta varchar(100),
    IN ingrediente1 varchar(100),
    IN ingrediente2 varchar(100),
    IN ingrediente3 varchar(100),
)
BEGIN
    INSERT Into ingredientesprincipales(nombrereceta,ingrediente1,ingrediente2,ingrediente3) Values (nombrereceta,ingrediente1,ingrediente2,ingrediente3)
END //
DELIMITER ;
/*------------------------------------------------------*/

/*------------------Buscar una receta------------------*/
DROP PROCEDURE IF EXISTS buscar_receta;
DELIMITER //
CREATE PROCEDURE buscar_receta(
    IN ingrediente varchar(100)
)
BEGIN
    SELECT * FROM ingredientesprincipales where ingrediente1=ingrediente OR ingrediente2=ingrediente OR ingrediente3=ingrediente;
END //
DELIMITER ;
/*-----------------------------------------------------*/

/*------------------------------CREAR DATOS------------------------------*/
call agregar_receta('receta 1','papa','brocoli','tomate');
call agregar_receta('receta 2','berengena','wicoy','papa');
call agregar_receta('receta 1','tomate','lechuga','pasta');
/*-----------------------------------------------------------------------*/