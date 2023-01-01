import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import net.sf.saxon.trans.SymbolicName;

import javax.xml.crypto.Data;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    }


    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) { //получается передаем здесь на вход ссылку на объект airport

        Date date = new Date();//установила текущее время

        List<Flight> s = airport.getTerminals().stream().flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .filter(flight -> flight.getDate().getTime() >= date.getTime() && flight.getDate().getTime() <= date.getTime() + 7200000)
                .collect(Collectors.toList());

        return s;











        //TODO Метод должен вернуть список рейсов вылетающих в ближайшие два часа.
        //return Collections.emptyList();
    }

}