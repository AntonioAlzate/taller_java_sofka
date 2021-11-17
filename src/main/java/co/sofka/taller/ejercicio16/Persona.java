package co.sofka.taller.ejercicio16;

public class Persona {

    // Constantes
    public static final int SOBREPESO = 1;
    public static final int ABAJO_PESO_IDEAL = 0;
    public static final int PESO_IDEAL = -1;
    public static final char SEXO_HOMBRE = 'H';
    public static final char SEXO_MUJER = 'M';
    private static final long MINIMO_VALOR_DNI = 10000000;
    private static final long MAXIMO_VALOR_DNI = 99999999;

    // Propiedades
    private String nombre;
    private int edad;
    private char sexo;
    private double peso;
    private double altura;
    private long DNI;

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.sexo = 'M';
        this.peso = 0;
        this.altura = 0;
        this.DNI = generarDNI();
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = 0;
        this.altura = 0;
        this.DNI = generarDNI();
        comprobarSexo(sexo);
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.DNI = generarDNI();
        comprobarSexo(sexo);
    }

    private long generarDNI() {
        long rango = (MAXIMO_VALOR_DNI - MINIMO_VALOR_DNI) + 1;
        long numeroAleatorio = (long) (Math.random() * rango) + MINIMO_VALOR_DNI;
        return numeroAleatorio;
    }

    public int calcularIMC() {
        double valorFormula = peso / (Math.pow(altura, 2));

        if (valorFormula < 20)
            return ABAJO_PESO_IDEAL;
        else if (valorFormula >= 20 && valorFormula <= 25)
            return PESO_IDEAL;
        else
            return SOBREPESO;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    private void comprobarSexo(char sexo) {
        if (sexo == SEXO_HOMBRE)
            this.sexo = sexo;
        else if (sexo == SEXO_MUJER)
            this.sexo = sexo;
        else
            this.sexo = SEXO_HOMBRE;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", sexo=" + sexo +
                ", peso=" + peso +
                ", altura=" + altura +
                ", DNI='" + DNI + '\'' +
                '}';
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}
