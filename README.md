Si vais al código de la clase teneis javadoc explicado de como se hace y que es cada cosa

# Todos los nombres de las entidades se ven afectadas por <a href="https://github.com/MaQuiNa1995/Ejemplo-Jpa/blob/master/src/main/java/maquina/hibernate/configuration/CustomPhysicalNamingStrategy.java">CustomPhysicalNamingStrategy</a>

Si te fijas ninguna columna tiene @column, con esta clase no nos hace falta
Todo camelCase se convertirá a mayúsculas y "SnakeCase"

# Todas las entidades extienden de <a href="https://github.com/MaQuiNa1995/Ejemplo-Jpa/blob/master/src/main/java/maquina/hibernate/dominio/AbstractEntidadSimple.java">AbstractEntidadSimple</a>
Esta clase tiene 6 campos id y nombre 
Depende el parámetro que pongas en la entidad padre el id será de un tipo u otro
Es decir puedes hacer que el id sea una String un Integer o un Long en cada una de las clases Hijas (Siempre usamos Warpper)

# Adicionalmente esta clase anteriormente mencionada tiene herencia con <a href="https://github.com/MaQuiNa1995/Ejemplo-Jpa/blob/master/src/main/java/maquina/hibernate/dominio/AbstractAuditable.java">AbstractAuditable</a>

Esta clase tiene 4 campos útiles de auditoria para cuando se persiste o modifica una entidad y otros 2 para saber quien ha hecho cada operación
La implementación está hardcodeada porque aqui no he metido spring security

Adicionalmente tenemos una columna @version útil para poder usar la estrategia de hibernate llamada "optimistic locking mechanism"
en el que creamos una manera segura de tratamiento de posibles updates y deletes concurrentes de una entidad

# Entidad Con Clave Compuesta

| Entidad | Clave Primaria |
|:---:|:---:|
|Elementalista | ElementalistaPk |

# Relaciones One2One (Izquierda la dominante):

## Bidireccional
| Dominante | Esclavo | Peculiaridad |
|:---:|:---:|:---:|
| Rango | Técnica |  |
| Personaje | Oficio | Tabla intermedia |
| TipoMagia | Mago | Comparte el mismo Id |
## Unidireccional
| Dominante | Esclavo | Peculiaridad |
|:---:|:---:|:---:|
| Ninja | Ninjutsu |  |

# Relaciones One2Many (Izquierda la dominante)

## Bidireccional
| Dominante | Esclavo | Peculiaridad |
|:---:|:---:|:---:|
| Poción | Alquimista |  |
| Invocador | InvocaciónSuprema | Tabla intermedia |
## Unidireccional
| Dominante | Esclavo | Peculiaridad |
|:---:|:---:|:---:|
| Monje | TécnicaKi |  |

# Relaciones Many2Many (Izquierda la dominante):

## Bidireccional
| Dominante | Esclavo | Peculiaridad |
|:---:|:---:|:---:|
| Arma | Calidad | Tabla intermedia |
## Unidireccional
| Dominante | Esclavo | Peculiaridad |
|:---:|:---:|:---:|
| Domador | Bestia |  |
