package Grafo;

public class GrafoPeso extends GrafoM{

	public static final int INFINITO = Integer.MAX_VALUE;

    private int numVerts;
    private int[][] matPeso;

    public GrafoPeso(int numVerts) {
        this.numVerts = numVerts;
        setMatPeso(new int[numVerts][numVerts]);
        for (int i = 0; i < numVerts; i++) {
            for (int j = 0; j < numVerts; j++) {
                getMatPeso()[i][j] = (i == j) ? 0 : INFINITO;
            }
        }
    }

    public int numeroDeVertices() {
        return numVerts;
    }

	public int[][] getMatPeso() {
		return matPeso;
	}

	public void setMatPeso(int[][] matPeso) {
		this.matPeso = matPeso;
	}

}
