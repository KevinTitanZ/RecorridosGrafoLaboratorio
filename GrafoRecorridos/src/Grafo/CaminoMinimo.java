package Grafo;

public class CaminoMinimo {
		private int[][] Pesos;
		private int[] ultimo;
		private int[] D;
		private boolean[] F;
		private int s, n; // vértice origen y número de vértices

		public CaminoMinimo(GrafoPeso gp, int origen) {
			n = gp.numeroDeVertices();
			setS(origen);
			Pesos = gp.getMatPeso();
			setUltimo(new int[n]);
			setD(new int[n]);
			F = new boolean[n];
		}

		public void caminoMinimos() {
			// valores iniciales
			for (int i = 0; i < n; i++) {
				F[i] = false;
				getD()[i] = Pesos[getS()][i];
				getUltimo()[i] = getS();
			}
			F[getS()] = true;
			getD()[getS()] = 0;

			// Pasos para marcar los n-1 vértices
			for (int i = 1; i < n; i++) {
				int v = minimo();
				F[v] = true;

				// actualiza distancia de vértices no marcados
				for (int w = 1; w < n; w++) {
					if (!F[w] && (getD()[v] + Pesos[v][w]) < getD()[w]) {
						getD()[w] = getD()[v] + Pesos[v][w];
						getUltimo()[w] = v;
					}
				}
			}
		}

		private int minimo() {
			int mx = GrafoPeso.INFINITO;
			int v = 1;
			for (int j = 1; j < n; j++) {
				if (!F[j] && (getD()[j] <= mx)) {
					mx = getD()[j];
					v = j;
				}
			}
			return v;
	}

		public int[] getUltimo() {
			return ultimo;
		}

		public void setUltimo(int[] ultimo) {
			this.ultimo = ultimo;
		}

		public int[] getD() {
			return D;
		}

		public void setD(int[] d) {
			D = d;
		}

		public int getS() {
			return s;
		}

		public void setS(int s) {
			this.s = s;
		}
}
