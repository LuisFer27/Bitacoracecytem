/**
 * Nombre del proyecto:Bitacoracecytem
 * Descripción:Aplicación para llevar un control de registro de alumnos que estan en un área especifica 
 * Fecha:04/07/2024
 * Autor:Luis Fernando Mendez Barrera
 * Versión 1.0.0
 */

//clase bitacora cecytem donde se almacenaran los get y sets
public class BitacoraCecytem {
//valores a obtener ya que todos son del tipo string 
static String id;
static String noControl;
static String nombrePlantel;
static String horaEntrada;
static String horaSalida;
static String fecha;
public static String getId() {
	return id;
}
//get y set del id
public static void setId(String id) {
	BitacoraCecytem.id = id;
}
public static String getNoControl() {
	return noControl;
}
//get y set del número de control
public static void setNoControl(String noControl) {
	BitacoraCecytem.noControl = noControl;
}
public static String getNombrePlantel() {
	return nombrePlantel;
}
//get y set del nombre del plantel
public static void setNombrePlantel(String nombrePlantel) {
	BitacoraCecytem.nombrePlantel = nombrePlantel;
}
public static String getHoraEntrada() {
	return horaEntrada;
}
//get y set de la hora de entrada
public static void setHoraEntrada(String horaEntrada) {
	BitacoraCecytem.horaEntrada = horaEntrada;
}
//get y set de la hora de salida
public static String getHoraSalida() {
	return horaSalida;
}
public static void setHoraSalida(String horaSalida) {
	BitacoraCecytem.horaSalida = horaSalida;
}
//get y set de la fecha 
public static String getFecha() {
	return fecha;
}
public static void setFecha(String fecha) {
	BitacoraCecytem.fecha = fecha;
}

}
