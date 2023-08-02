package Grafo;

public class Vertices {

	String nombre;
	int numV;
	public Vertices(String x) {
		nombre = x;
		numV = -1;
	}
	
	public String nombreV() {
		return nombre;
	}
	
	public boolean equals(Vertices n) {
		
		return nombre.equals(n.nombre);
		
	}
	
	public void asigVert(int n) {
		numV = n;
	}

	public String toString() {
		return "Vertices [nombre=" + nombre + ", numV=" + numV + "]";
	}	
}
