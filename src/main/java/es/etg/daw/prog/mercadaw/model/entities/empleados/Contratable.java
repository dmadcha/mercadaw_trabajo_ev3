package es.etg.daw.prog.mercadaw.model.entities.empleados;

public interface Contratable {
    public static final double SUELDO_EMPLE = 1000;
    public static final double SUELDO_REPON = 1200;
    public static final double SUELDO_CAJER = 1300;
    public static final double SUELDO_ENCAR = 1500;

    public double getSalarioNeto();
    public double getSalarioBruto();
    public double getAportaciones();
    public double getIndemnizacion(TipoDespido tipo);
}
