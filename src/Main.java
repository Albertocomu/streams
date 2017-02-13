
import com.sun.org.apache.xpath.internal.operations.String;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {

        Equipo cavs = new Equipo("Cavaliers", "Cliveland", LocalDate.of(1900, 10, 15));
        Equipo lakers = new Equipo("Lakers", "Los Angeles", LocalDate.of(1920, 10, 15));
        Equipo bulls = new Equipo("Bulls", "Chicago", LocalDate.of(1910, 10, 15));
        List<Jugador> jugadores = Arrays.asList(
                new Jugador("Alberto", LocalDate.of(1988, 10, 15), 745, cavs),
                new Jugador("Sergio", LocalDate.of(1989, 10, 15), 450, lakers),
                new Jugador("Fernando", LocalDate.of(1990, 10, 15), 845, bulls),
                new Jugador("Larry", LocalDate.of(1991, 10, 15), 445, cavs),
                new Jugador("Victor", LocalDate.of(1992, 10, 15), 245, bulls)
        );

        System.out.println("Devolver con una lista  todos los jugadores que hayan obtenido más de 500 canastas.");
        List<Jugador> jugadores500 =
                jugadores.stream()
                        .filter(jugador -> jugador.getCanastas() >= 500)
                        .collect(toList());

        System.out.println(jugadores500);
        System.out.println("");

        System.out.println("Devolver con una lista  todos los jugadores que hayan obtenido entre 200 y 500 canastas.");
        List<Jugador> jugadores200a500 =
                jugadores.stream()
                        .filter(jugador -> jugador.getCanastas() >= 200)
                        .filter(jugador -> jugador.getCanastas() <= 500)
                        .collect(toList());
        System.out.println(jugadores200a500);
        System.out.println("");

        System.out.println("Devolver en una lista exclusivamente los nombres de los jugadores que satisfacen los requisitos del 2.3");
        String nombres =
                jugadores.stream()
                        .map(jugador -> jugador.getNombre()).distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(nombres);
        System.out.println("");

        System.out.println("Devolver con una lista todos los jugadores ordenados por la fecha de nacimiento.");
        List<Jugador> jugadoresAño =
                jugadores.stream()
                        .sorted(comparing(Jugador::getNacimiento))
                        .collect(toList());
        System.out.println(jugadoresAño);
        System.out.println("");

        System.out.println("Devolver con una lista todos los jugadores ordenados por número de canastas.");
        List<Jugador> jugadoresByCanastas =
                jugadores.stream()
                        .sorted(comparing(Jugador::getCanastas))
                        .collect(toList());
        System.out.println(jugadoresByCanastas);
        System.out.println("");

        System.out.println("Devolver con una lista con los cinco jugadores que hayan realizado más canastas.");
        List<Jugador> jugadoresLimitado =
                jugadores.stream()
                        .limit(5)
                        .sorted(comparing(Jugador::getCanastas).reversed())
                        .collect(toList());
        System.out.println(jugadoresLimitado);
        System.out.println("");

        System.out.println("Devolver con una lista todos los jugadores que satisfacen el punto 2.3 ordenados por la fecha de nacimiento de manera descendente.");
        List<Jugador> jugadores200To500ByFecha =
                jugadores.stream()
                        .filter(jugador -> jugador.getCanastas() >= 200)
                        .filter(jugador -> jugador.getCanastas() <= 500)
                        .sorted((j1, j2) ->
                                j2.getNacimiento().compareTo(j1.getNacimiento()))
                        .collect(toList());
        System.out.println(jugadores200To500ByFecha);
        System.out.println("");

        System.out.println("Devolver con una lista todos los jugadores que satisfacen el filtro del punto 2.3 ordenados, en primer lugar por número de canastas y en segundo lugar (si tienen el mismo número de canastas) por la fecha de nacimiento.");
        List<Jugador> jugadoresByFechaByFecha =
                jugadores.stream()
                        .filter(jugador -> jugador.getCanastas() >= 200)
                        .filter(jugador -> jugador.getCanastas() <= 500)
                        .sorted(comparing(Jugador::getCanastas).thenComparing(Jugador::getNacimiento))
                        .collect(toList());
        System.out.println(jugadores200To500ByFecha);
        System.out.println("");

        System.out.println("Devolver el jugador que ha realizado el mínimo número de canastas.");
        Optional<Jugador> jugadorMenosCanastas =
                jugadores.stream()
                        .reduce((j1, j2) ->
                                j1.getCanastas() < j2.getCanastas() ? j1 : j2);
        System.out.println(jugadorMenosCanastas);
        System.out.println("");

        System.out.println("Devolver el jugador que ha realizado el máximo número de canastas.");
        Optional<Jugador> jugadorMasCanastas =
                jugadores.stream()
                        .reduce((j1, j2) ->
                                j1.getCanastas() < j2.getCanastas() ? j2 : j1);
        System.out.println(jugadorMasCanastas);
        System.out.println("");

        System.out.println("Devolver la media de canastas de todos los jugadores.");
        Double mediaCanastas =
                jugadores.stream()
                        .mapToDouble(j -> j.getCanastas())
                        .average()
                        .getAsDouble();
        System.out.println(mediaCanastas);
        System.out.println("");

        System.out.println("Devolver con una lista todos los jugadores que pertenezcan a equipos cuya localidad sea Barcelona.");
        List<Jugador> jugadoresCliveland =
                jugadores.stream()
                        .filter(jugador -> jugador.getEquipo().getLocalidad().equals("Cliveland"))
                        .collect(toList());
        System.out.println(jugadoresCliveland);
        System.out.println("");

        System.out.println("Devolver con un boolean si hay algún jugador que ha conseguido más de 4.000 canastas.");
        boolean masDe4000 =
                jugadores.stream()
                        .anyMatch(jugador -> jugador.getCanastas() > 4000);
        System.out.println(masDe4000);
        System.out.println("");

        System.out.println("Devolver con un boolean si todos los jugadores han conseguido más de 50 canastas.");
        boolean menosDe50 =
                jugadores.stream()
                        .anyMatch(jugador -> jugador.getCanastas() < 50);
        System.out.println(menosDe50);
        System.out.println("");

        System.out.println("Devolver con un boolean si todos los jugadores del primer equipo añadido han conseguido más de 50 canastas.");
        boolean menosDe50Equipo1 =
                jugadores.stream()
                        .filter(jugador -> jugador.getEquipo().equals(cavs))
                        .anyMatch(jugador -> jugador.getCanastas() < 50);
        System.out.println(menosDe50Equipo1);
        System.out.println("");

        System.out.println("Devolver un Map<String, List<Equipo> agrupando los equipos que pertenecen a una misma localidad. Hay un ejemplo similar en la página 172 (6.3 Grouping)");
        Map<String, List<Equipo>> mapStringEquipo =
                jugadores.stream()
                        .map(Jugador::getEquipo)
                        .collect(Collectors.groupingBy(Equipo::getLocalidad));
        System.out.println(mapStringEquipo);

        System.out.println("Devolver la suma del número de canastas de todos los jugadores. Utilizar la operación Reduce (página 132,  5.4)");
        int sumaCanastas =
                jugadores.stream()
                        .mapToInt(j -> j.getCanastas())
                        .sum();
        System.out.println(sumaCanastas);
        System.out.println("");

        //Extra: todos los jugadores de un equipo en concreto.
        jugadores.stream()
                .filter(jugador -> jugador.getEquipo().equals(cavs))
                .forEach(System.out::println);
    }
}
