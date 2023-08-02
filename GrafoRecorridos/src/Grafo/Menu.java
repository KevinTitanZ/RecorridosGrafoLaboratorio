package Grafo;

import javax.swing.JOptionPane;
import java.util.*;

public class Menu {
	RecorridoGrafos re = new RecorridoGrafos();
	Scanner scanner = new Scanner(System.in);

	public void MenuOpciones() {


		int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
				"BIENVENIDO A LAS FUNCIONES BASICAS DE LOS GRAFOS\n 1.Insertar nuevo vertice\n 2. Mostrar la información del grafo\n3. Recorrido de anchura\n4.Recorrido de profundidad\n5. SALIR"));

		do {
			switch (opcion) {
			case 1:
				re.pedirVerticesAlUsuario();
				MenuOpciones();
				break;
			case 2:
				re.mostrarInformacionGrafo();
				MenuOpciones();
				break;
			case 3:
				System.out.println("Ingrese el vértice de origen para el recorrido en profundidad (DFS): ");
				String origen = scanner.next();

				try {
					int v = re.numVertice(origen);
					if (v < 0) {
						throw new Exception("Vértice de origen no existe");
					}

					System.out.println("Recorrido en profundidad (DFS) comenzando desde el vértice " + origen + ":");
					int[] resultado = re.recorrerProf(re, origen);
					for (int i = 0; i < resultado.length; i++) {
						System.out.println("Vértice " + re.verts[i].nombre + " marcado: " + (resultado[i] == 1));
					}
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
				MenuOpciones();
				break;
			case 4:
				System.out.println("Ingrese el vértice de origen para el recorrido en profundidad (DFS): ");
				String origen1 = scanner.next();

				try {
					System.out.println("Recorrido en anchura (BFS) comenzando desde el vértice " + origen1 +  ":");
					int[] resultado = re.recorrerAnchura(origen1);
					for (int i = 0; i < resultado.length; i++) {
						System.out.println("Distancia desde el vértice " + origen1 + " al vértice" + re.verts[i].nombre + "': " + resultado[i]);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				MenuOpciones();
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Gracias por utilizar la aplicacion");
				System.exit(0);
				break;
			default:
				JOptionPane.showInputDialog(null, "Opcion Incorrecta");
			}
		} while (opcion != 5);
	}
}
