package Grafo;
import java.util.*;
public class RecorridoGrafos extends GrafoM{

	public int[] recorrerAnchura(String org) throws Exception {
		int v = numVertice(org);
		if (v < 0)
			throw new Exception("Vértice origen no existe");

		int[] distancias = new int[numVerts];
		for (int i = 0; i < numVerts; i++) {
			distancias[i] = CLAVE;
		}

		Queue<Integer> cola = new LinkedList<>();
		distancias[v] = 0;
		cola.add(v);

		while (!cola.isEmpty()) {
			int w = cola.poll();
			System.out.println("Vértice " + verts[w].nombre + " visitado");

			for (int u = 0; u < numVerts; u++) {
				if (matAd[w][u] == 1 && distancias[u] == CLAVE) {
					distancias[u] = distancias[w] + 1;
					cola.add(u);
				}
			}
		}

		return distancias;
	}

	public int[] recorrerProf(GrafoM g, String org) throws Exception {
        int v, w;
        Stack<Integer> pila = new Stack<>();
        int[] m = new int[g.numeroDeVertices()];
        v = g.numVertice(org);
        if (v < 0) {
            throw new Exception("Vértice origen no existe");
        }
        for (int i = 0; i < g.numeroDeVertices(); i++) {
            m[i] = CLAVE;
        }
        m[v] = 0; // vértice origen queda marcado
        pila.push(v);
        while (!pila.isEmpty()) {
            w = pila.pop();
            System.out.println("Vértice " + g.verts[w].nombre + " visitado");
            // inserta en la pila los adyacentes de w no marcados
            for (int k = 0; k < g.numeroDeVertices(); k++) {
                if (g.matAd[w][k] == 1 && m[k] == CLAVE) {
                    pila.push(k);
                    m[k] = 1; // vértice queda marcado
                }
            }
        }
        return m;
    }


}
