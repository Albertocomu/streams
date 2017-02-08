import java.time.LocalDate;

public class Main {
    Equipo cavs = new Equipo("Cavaliers", "Cliveland", LocalDate.of(1900, 10, 15));
    Equipo lakers = new Equipo("Lakers", "Los Angeles", LocalDate.of(1920, 10, 15));
    Equipo bulls = new Equipo("Bulls", "Chicago", LocalDate.of(1910, 10, 15));
    Jugador alberto = new Jugador("Alberto", LocalDate.of(1988, 10, 15), 45, cavs);
    Jugador sergio = new Jugador("Sergio", LocalDate.of(1988, 10, 15), 45, lakers);
    Jugador fernando = new Jugador("Fernando", LocalDate.of(1988, 10, 15), 45, bulls);
    Jugador larry = new Jugador("Larry", LocalDate.of(1988, 10, 15), 45, cavs);
    Jugador victor = new Jugador("Victor", LocalDate.of(1988, 10, 15), 45, bulls);

    //2.2	Devolver con una lista  todos los jugadores que hayan obtenido más de 500 canastas.

    //2.3	Devolver con una lista  todos los jugadores que hayan obtenido entre 200 y 500 canastas.

    //2.4	Devolver en una lista exclusivamente los nombres de los jugadores que satisfacen  los requisitos del 2.3

    //2.5	Devolver con una lista todos los jugadores ordenados por la fecha de nacimiento.

    //2.6	Devolver con una lista todos los jugadores ordenados por número de canastas.

    //2.7	Devolver con una lista con los cinco jugadores que hayan realizado más canastas.

    //2.8	Devolver con una lista todos los jugadores que satisfacen el punto 2.3 ordenados por la fecha de nacimiento de manera descendente.

    //2.9	Devolver con una lista todos los jugadores que satisfacen el filtro del punto 1.3 ordenados, en primer lugar por número de canastas y en segundo lugar (si tienen el mismo número de canastas) por la fecha de nacimiento.

    //2.10	Devolver el jugador que ha realizado el mínimo número de canastas.

    //2.11	Devolver el jugador que ha realizado el máximo número de canastas.

    //2.12	Devolver la media de canastas de todos los jugadores.

    //2.13	Devolver con una lista todos los jugadores que pertenezcan a equipos cuya localidad sea Barcelona.    //2.14	Devolver con un boolean si hay algún jugador que ha conseguido más de 4.000 canastas

    //2.15	Devolver con un boolean si todos los jugadores han conseguido más de 50 canastas.

    //2.16	Devolver con un boolean si todos los jugadores del primer equipo añadido han conseguido más de 50 canastas.

    //2.17	Devolver un Map<String, List<Equipo>> agrupando los equipos que pertenecen a una misma localidad. Hay un ejemplo similar en la página 172 (6.3 Grouping)

    //2.18	Devolver la suma del número de canastas de todos los jugadores. Utilizar la operación Reduce (página 132,  5.4)

    //Extra: todos los jugadores de un equipo en concreto.

}
