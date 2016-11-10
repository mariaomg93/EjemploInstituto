/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploinstituto;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class EjemploInstituto {

    static ArrayList<Persona> personas = new ArrayList<Persona>();

    //Rellena los datos de ejemplo para poder trabajar con ello
    public static void rellenarDatos() {
        Alumno al;
        Profesor p;
        ProfesorInterino pi;
        for (int i = 0; i < 10; i++) {
            al = new Alumno();
            al.setNombre("ALUMNO"+i);
            al.setEdad(i);
            personas.add(al);
            
            p = new Profesor();
            p.setNombre("PROF"+i);
            p.setEspecialidad("MATEMATICAS");
            p.setEdad(i+10);
            personas.add(p);
            
            pi = new ProfesorInterino();
            pi.setNombre("PROF"+i);
            pi.setEspecialidad("LENGUA");
            pi.setEdad(i+10);
            personas.add(pi);          
        }
    }

    //Busca y muestra al profesor mayor de todo el vector de personas
    //  (utiliza un FOR habitual)
    public static void mostrarProfesorMasViejo() {
        int edadMaxima = 0;
        Profesor personaEdadMaxima = null;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i) instanceof Profesor) {
                //System.out.println (personas.get(i).getClass());
                if (edadMaxima < personas.get(i).getEdad()) {
                    edadMaxima = personas.get(i).getEdad();
                    personaEdadMaxima = (Profesor) personas.get(i);
                }
            }
        }
        System.out.println(personaEdadMaxima.getNombre());
    }
    
    //Busca y muestra al profesor mayor de todo el vector de personas
    //  (utiliza un FOR declarativo
    public static void mostrarProfesorMasViejo_version2() {
        int edadMaxima = 0;
        Profesor personaEdadMaxima;
        for (Persona persona : personas) {
            //Esto comentado es por si queremos solo los de tipo 'Profesor'
            //if ((persona instanceof Profesor) && (!(persona instanceof ProfesorInterino))) {
            if (persona instanceof Profesor) {
                System.out.println (persona.getClass());
                if (edadMaxima < persona.getEdad()) {
                    edadMaxima = persona.getEdad();
                    personaEdadMaxima = (Profesor) persona;
                }
            }
        }
    }
    
    //Busca y muestra al alumno más jóven de todo el vector de personas
    public static void mostrarAlumnoMasJoven() {
        int edadMin = 9999999;
        Persona personaMasJoven = null;
        for (Persona persona : personas) {
            if (persona instanceof Alumno) {
                
                if (edadMin > persona.getEdad()) {
                    edadMin = persona.getEdad();
                    personaMasJoven = persona;
                }
                
            }
        }
        System.out.println(personaMasJoven.getNombre());
    }

    //Recibe un profesor y la nueva especialidad para el mismo
    public static void cambiarEspecialidad (Profesor p, String especialidad) {
        p.setEspecialidad(especialidad);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        rellenarDatos();
        //mostrarProfesorMasViejo();
        //mostrarProfesorMasViejo_version2();
        
        Profesor prof = null;
        //Primer profesor que me encuentre (primero de tipo profesor)
        int i = 0;
        int encontrado = 0;
        while (  (i < personas.size()) && (encontrado == 0)   ) {
            if (personas.get(i) instanceof Profesor) {
                encontrado = 1;
                prof = (Profesor) personas.get(i);
            }
            i++;
        }
        
        cambiarEspecialidad(prof,"CIENCIAS SOCIALES");        
    }    
}
