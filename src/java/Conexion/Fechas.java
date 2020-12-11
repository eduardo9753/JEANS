package Conexion;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fechas {

    public static Calendar canlendar = Calendar.getInstance();
    private static String fecha;

    public Fechas() {
    }

    public static String Fecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        fecha = sdf.format(canlendar.getTime());
        return fecha;
    }

    public static String FechaBD() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fecha = sdf.format(canlendar.getTime());
        return fecha;
    }
}
