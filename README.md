Si vais al código de la clase teneis javadoc explicado de como se hace y que es cada cosa

# Todas las entidades extienden de <a href="https://github.com/MaQuiNa1995/Ejemplo-Jpa/blob/master/src/main/java/es/maquina1995/hsqldb/dominio/AbstractEntidadSimple.java">AbstractEntidadSimple</a>
Esta clase tiene 2 campos id y nombre
Depende el parámetro que pongas en la entidad padre el id será de un tipo u otro
Es decir puedes hacer que el id sea una String un Integer o un Long en cada una de las clases Hijas (Siempre usamos Warpper)

# Entidad Con Clave Compuesta
Elementalista - ElementalistaPk

# Relaciones One2One (Izquierda la dominante):

Bidireccional

	Técnica			-		Rango
	Personaje		-		Oficio			-		(Tabla intermedia)
	TipoMagia 		- 		Mago 			- 		(Comparte el mismo Id)
	
Unidireccional

	Ninja			-		Ninjutsu
	
# Relaciones One2Many (Izquierda la dominante):

Bidireccional

	Alquimista		-		Poción
	Invocador		-		InvocaciónSuprema	-		(Tabla intermedia)

Unidireccional

	Monje			-		TécnicaKi
	
	
	
	