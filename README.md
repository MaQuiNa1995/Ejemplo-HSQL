Si vais al código de la clase teneis javadoc explicado de como se hace y que es cada cosa

# Entidad Con Clave Compuesta
Elementalista - ElementalistaPk

# Relaciones One2One (Izquierda la dominante):

Bidireccional

	TipoMagia 		- 		Mago 			- 		(Comparte el mismo Id)
	Técnica			-		Rango

Unidireccional

	Personaje		-		Oficio			-		(Tabla intermedia)
	Ninja			-		Ninjutsu