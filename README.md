Si vais al código de la clase teneis javadoc explicado de como se hace y que es cada cosa

# Entidad Con Clave Compuesta
Elementalista - ElementalistaPk

# Relaciones One2One (Izquierda la dominante):

Bidireccional

	Técnica			-		Rango
	Personaje		-		Oficio						-		(Tabla intermedia)
	TipoMagia 		- 		Mago 						- 		(Comparte el mismo Id)
	
Unidireccional

	Ninja			-		Ninjutsu
	
# Relaciones One2Many (Izquierda la dominante):

Bidireccional

	Alquimista		-		Poción
	Invocador		-		InvocaciónSuprema			-		(Tabla intermedia)

Unidireccional

	Monje			-		TécnicaKi
	
	
	
	