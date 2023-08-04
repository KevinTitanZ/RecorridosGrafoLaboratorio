package Grafo;

import javax.swing.JOptionPane;
import java.util.*;

public class Menu {
	RecorridoGrafos re = new RecorridoGrafos();
	Scanner scanner = new Scanner(System.in);
	GrafoM info = new GrafoM();

	public void MenuOpciones() throws Exception {


		int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
				"BIENVENIDO A LAS FUNCIONES BASICAS DE LOS GRAFOS\n 1.Insertar nuevo vertice\n 2. Mostrar la información del grafo\n3. Recorrido de anchura\n4.Recorrido de profundidad\n5. Algoritmo Dijkstra\n6. SALIR"));

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
				info.pedirVerticesAlUsuario();
		        
		        Scanner scanner = new Scanner(System.in);
		        System.out.println("Ingrese el vértice de origen para el algoritmo de Dijkstra: ");
		        String origen2 = scanner.next();
		        
		        int origenIndex = info.numVertice(origen2);
		        if (origenIndex < 0) {
		            System.out.println("El vértice de origen no existe.");
		            return;
		        }
		        
		        GrafoPeso grafMatPeso = new GrafoPeso(info.numeroDeVertices());
		        
		        for (int i = 0; i < info.numeroDeVertices(); i++) {
		            for (int j = 0; j < info.numeroDeVertices(); j++) {
		                if (info.adyacente(i, j)) {
		                    // Pregunta al usuario por el peso de la arista entre los vértices i y j
		                    System.out.println("Ingrese el peso de la arista entre " + info.verts[i].nombre + " y " + info.verts[j].nombre + ": ");
		                    int peso = scanner.nextInt();
		                    
		                    // Actualiza el peso en la matriz de pesos si la arista existe
		                    grafMatPeso.getMatPeso()[i][j] = peso;
		                    grafMatPeso.getMatPeso()[j][i] = peso; // Si es un grafo no dirigido
		                } else {
		                    // Asigna un valor de INFINITO para las aristas no existentes
		                    grafMatPeso.getMatPeso()[i][j] = GrafoPeso.INFINITO;
		                }
		            }
		        }
		        
		        CaminoMinimo dijkstra = new CaminoMinimo(grafMatPeso, origenIndex);
		        dijkstra.caminoMinimos();
		        System.out.println("Resultados del algoritmo de Dijkstra:");

		        for (int i = 0; i < dijkstra.getD().length; i++) {
		            System.out.println("Distancia mínima desde el vértice " + info.verts[dijkstra.getS()].nombre + " al vértice " + info.verts[i].nombre + ": " + dijkstra.getD()[i]);
		            
		            System.out.print("Camino: " + info.verts[i].nombre);
		            int anterior = dijkstra.getUltimo()[i];
		            while (anterior != dijkstra.getS()) {
		                System.out.print(" <- " + info.verts[anterior].nombre);
		                anterior = dijkstra.getUltimo()[anterior];
		            }
		            System.out.println(" <- " + info.verts[dijkstra.getS()].nombre);
		        }
		        MenuOpciones();
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "Gracias por utilizar la aplicacion");
				System.exit(0);
				break;
			default:
				JOptionPane.showInputDialog(null, "Opcion Incorrecta");
			}
		} while (opcion != 6);
	}
}
