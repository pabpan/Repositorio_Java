package Objetos_1;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private String sexo;
    private float peso;
    private float altura;

    public Persona(String nombre, int edad, String dni, String sexo, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.dni = "";
        this.sexo = "H";
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = "";
        this.sexo = sexo;
        this.peso = 0;
        this.altura = 0;
    }

}
