#CONECCION CON LA BASE DE DATOS-------------#
app.config['MYSQL_HOST'] = 'localhost'      #
app.config['MYSQL_USER'] = 'root'           #
app.config['MYSQL_PASSWORD'] = ''           #
app.config['MYSQL_DB'] = 'mimenusin'        #
mysql = MySQL(app)                          #
#CONECCION CON LA BASE DE DATOS-------------#