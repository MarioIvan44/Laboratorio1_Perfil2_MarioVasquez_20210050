package MarioVasquez_20210050;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.TreeMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    TreeMap<Integer, String> agendaContactos = new TreeMap<>();

    public static void main(String[] args) {
        Main obj = new Main();

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir){
            System.out.println("------Menu de opciones-----");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Mostrar Contactos ordenados");
            System.out.println("3. Buscar contacto por nombre");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Salir");
            System.out.println("Ingrese el numero de la opcion que desea realizar");
            int respuesta = sc.nextInt();

            if(respuesta == 1){
                boolean seguir = true;
                while (seguir){
                    System.out.println("Ingrese el ID para el contacto");
                    Integer id = sc.nextInt();
                    System.out.println("Ingrese el nombre: ");
                    String nombre = sc.next();
                    System.out.println("Ingrese el apellido: ");
                    String apellido = sc.next();
                    System.out.println("Ingrese el telefono: ");
                    String telefono = sc.next();
                    System.out.println("Ingrese el correo: ");
                    String correo = sc.next();

                    if(obj.agregarContacto(id, nombre)){
                        Contacto contacto = new Contacto(id, nombre, apellido, correo, telefono);
                    }
                    else {
                        System.out.println("ERROR");
                    }

                    System.out.println("¿Desea agregar otro contacto? (s/n) ");
                    String continuar = sc.next();
                    if(continuar.equalsIgnoreCase("s")){
                        seguir = true;
                    }
                    else if (continuar.equalsIgnoreCase("n")){
                        System.out.println("Proceso finalizado");
                        seguir = false;
                    }
                }

            }
            else if(respuesta == 2){
                System.out.println("Contactos ordenados: " + obj.agendaContactos);
            }
            else if(respuesta == 3){
                System.out.println("Ingrese el nombre del contacto que desea ver: ");
                String nombre = sc.next();
                obj.obtenerConctacto(nombre);
            }
            else if(respuesta == 4){
                System.out.println("Ingrese el ID del contacto que desea eliminar: ");
                int id = sc.nextInt();
                obj.EliminarContacto(id);
            }
            else if(respuesta == 5){
                salir = true;
                System.out.println("Usted ha salido del sistema, gracias por utilizarlo");
            }
            else{
                System.out.println("Opcion no valida");
            }
        }
    }

    public boolean agregarContacto(Integer id, String nombre){
        if(agendaContactos.containsKey(id)){
            System.out.println("ERROR: El id ya existe");
            return false;
        }
        else {
            agendaContactos.put(id, nombre);
            System.out.println("El contacto ha sido agregado correctamente");
            return true;
        }
    }

    public void obtenerConctacto(String nombre){
        if(agendaContactos.containsValue(nombre)){
            System.out.println("ID: ");
            System.out.println("Nombre: " + nombre);
            System.out.println("Apellido: ");
            System.out.println("Telefono: ");
            System.out.println("Correo: ");
        }
        else {
            System.out.println("No se encontró ningún contacto con ese nombre");
        }
    }

    public void EliminarContacto(int id){
        if(agendaContactos.containsKey(id)){
            agendaContactos.remove(id);
            System.out.println("El registro ha sido eliminado");
        }
        else {
            System.out.println("No se ha encontrado un contacto con ese id");
        }
    }


}