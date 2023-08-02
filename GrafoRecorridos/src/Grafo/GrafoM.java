package Grafo;
import java.util.Scanner;
public class GrafoM {

	int numVerts;
	static int MaxVerts = 20; 
	Vertices [] verts;
	int [][] matAd;
	static final int CLAVE = -1;

	public GrafoM(){
		this(MaxVerts);
	}
	public GrafoM(int mx){
		matAd = new int [mx][mx];
		verts = new Vertices[mx];
		for (int i = 0; i < mx; i++)
			for (int j = 0; i < mx; i++)
				matAd[i][j] = 0;
		numVerts = 0;
	}

	public void nuevoVertice (String nom){
		boolean esta = numVertice(nom) >= 0;
		if (!esta) {
			Vertices v = new Vertices(nom); 
			v.asigVert(numVerts);
			verts[numVerts++] = v;
		}
	}
	public int numVertice(String vs){
		Vertices v = new Vertices(vs);
		boolean encontrado = false;
		int i = 0;
		for (; (i < numVerts) && !encontrado;){
			encontrado = verts[i].equals(v);
			if (!encontrado) i++ ; 
		}
		return (i < numVerts) ? i : -1 ;
	}
	
	public int numeroDeVertices() {
	    return numVerts;
	}
	
	//agregar una nueva arista entre dos vertices por su nombre
	public void nuevoArco(String a, String b)throws Exception{
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
		matAd[va][vb] = 1;
	}
	//agregar una nueva arista entre dos vertices por su indice
	public void nuevoArco(int va, int vb)throws Exception{
		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
		matAd[va][vb] = 1;
	}
	//verificar si dos vertices son adyacentes por su nombre
	public boolean adyacente(String a, String b)throws Exception{
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
		return matAd[va][vb] == 1;
	}
	//verificar si dos vertices son adyacentes por su indice
	public boolean adyacente(int va, int vb)throws Exception{
		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
		return matAd[va][vb] == 1;
	}

	public void pedirVerticesAlUsuario() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el número de vértices que desea agregar (máximo 20): ");
		int numVerticesIngresar = scanner.nextInt();

		while (numVerticesIngresar > MaxVerts || numVerticesIngresar <= 0) {
			System.out.println("El número de vértices debe estar entre 1 y 20. Ingrese nuevamente:");
			numVerticesIngresar = scanner.nextInt();
		}

		for (int i = 0; i < numVerticesIngresar; i++) {
			System.out.println("Ingrese el nombre del vértice " + (i + 1) + ": ");
			String nombreVertice = scanner.next();
			nuevoVertice(nombreVertice);
		}

		System.out.println("¿Desea agregar más vértices? (Sí: 1, No: 0)");
		int opcion = scanner.nextInt();

		while (opcion == 1) {
			System.out.println("Ingrese el nombre del vértice: ");
			String nombreVertice = scanner.next();
			nuevoVertice(nombreVertice);

			System.out.println("¿Desea agregar más vértices? (Sí: 1, No: 0)");
			opcion = scanner.nextInt();
		}

		System.out.println("Ingrese la información de adyacencia entre los vértices:");
		for (int i = 0; i < numVerts; i++) {
			for (int j = 0; j < numVerts; j++) {
				if (i != j) {
					System.out.println("¿El vértice " + verts[i].nombre + " es adyacente al vértice " + verts[j].nombre + "? (Sí: 1, No: 0)");
					int esAdyacente = scanner.nextInt();
					if (esAdyacente == 1) {
						try {
							nuevoArco(i, j);
						} catch (Exception e) {
							System.out.println("Error al agregar el arco: " + e.getMessage());
						}
					}
				}
			}
		}
	}
	
	public void mostrarInformacionGrafo() {
        System.out.println("Información del grafo:");

        // Mostrar lista de vértices
        for (int i = 0; i < numVerts; i++) {
            System.out.println("Vértice " + verts[i].nombre);
        }

        // Mostrar aristas adyacentes para cada vértice
        for (int i = 0; i < numVerts; i++) {
            System.out.print("Vértice " + verts[i].nombre + " es adyacente a: ");
            for (int j = 0; j < numVerts; j++) {
                try {
					if (adyacente(i, j)) {
					    System.out.print(verts[j].nombre + " ");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            System.out.println();
        }
    }
}
