import convertidoredad.Controlador.Fechas;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Usuario iTC
 */
public class ConvertidorEdad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //Fechas f = new Fechas();
        String mayorEdad = "", menorEdad = "";

        System.out.println("\nPrograma para calcular la mayor y menor edad (Arreglos)");
        System.out.print("\n> Que numero de estudiante registraran su fecha de nacimiento: ");
        int numeroEstudiantes = sc.nextInt();
        Fechas[] registroFechas = new Fechas[numeroEstudiantes];
        
        int[] edadEstudiantes = new int[numeroEstudiantes];
        for (int i = 0; i < numeroEstudiantes; i++) {
            System.out.println("\n--------------------------------------------------------------");
            System.out.println("Estudiante "+(i + 1)+": IMPORTANTE -> Formato Fecha : dd/MM/yyyy");
            System.out.print("> Ingrese el dia que nacio:");
            String dia = sc.next();
            System.out.print("> Ingrese el mes que nacio:");
            String mes = sc.next();
            System.out.print("> Ingrese el año que nacio:");
            String anio = sc.next();
            System.out.println("--------------------------------------------------------------");
            registroFechas[i] = new Fechas(dia, mes, anio);
        }

        int anioMayor = 0, mesMayor = 0, diaMayor = 0, auxMayor = 0;
        int anioMenor = 9999, mesMenor = 99, diaMenor = 99, auxMenor = 0;
        for (int i = 0; i < numeroEstudiantes; i++) {
            
            LocalDate fechaNacimiento = LocalDate.parse(registroFechas[i].getDia() + "/" + registroFechas[i].getMes() + "/" + registroFechas[i].getAnio(), formatoFecha);
            
            Period edad = Period.between(fechaNacimiento, LocalDate.now());
            
            
            if (edad.getYears() >= anioMayor) {
                auxMayor = anioMayor;
                anioMayor = edad.getYears();

               if(auxMayor != 0){
                   if(auxMayor != anioMayor){
                       mesMayor = edad.getMonths();
                       diaMayor = edad.getDays();
                   }
               }
                if (edad.getMonths() >= mesMayor) {
                    mesMayor = edad.getMonths();
                    if (edad.getDays() >= diaMayor) {
                        diaMayor = edad.getDays();
                    }
                }
            }
            
            mayorEdad = (anioMayor+" años, "+mesMayor+" meses, "+diaMayor+" dias");
            
            if (edad.getYears() <= anioMenor) {
                auxMenor = anioMenor;
                anioMenor = edad.getYears();
                if(auxMenor != 0){
                    if (auxMenor != anioMenor){
                        mesMenor = edad.getMonths(); 
                        diaMenor = edad.getDays();
                    }
                }
                if (edad.getMonths() <= mesMenor) {
                    mesMenor = edad.getMonths();
                    if (edad.getDays() <= diaMenor) {
                        diaMenor = edad.getDays();
                    }
                }
            }
            menorEdad = (anioMenor +" años, "+mesMenor +" meses, "+diaMenor +" dias");
        }
        
        System.out.print("\n---------------------RESULTADO---------------------");
        System.out.println("\nMayor Edad Encontrada: "+mayorEdad);
        System.out.println("Menor Edad Encontrada: " + menorEdad);
        System.out.println("---------------------------------------------------");
    }
}
