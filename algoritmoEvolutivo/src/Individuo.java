public class Individuo {
    public Gen[] filas; // X indice
    public long nota;

    public Individuo(int[][] valores) {
        nota = -1;
        // Inicializamos las filas (genes)
        filas = new Gen[9];
        for (int x = 0; x < 9; x++) {
            filas[x] = new Gen();
        }

        // Cargamos los datos
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (valores[x][y] == 0) {
                    // Si el valor es 0 significa que no es un valor fijo
                    filas[x].filaFijos[y] = false;
                    filas[x].filaGen[y] = 0;
                } else {
                    // Si el valor es distinto de 0 significa que es un valor fijo, activamos la
                    // bandera
                    // Tambien eliminamos de la lista de datos a meter ese numero porque ya esta en
                    // la fila
                    filas[x].filaFijos[y] = true;
                    filas[x].filaGen[y] = valores[x][y];
                    filas[x].listaAMeter.remove(Integer.valueOf(valores[x][y]));
                }
            }
        }
    }

    public Individuo(Individuo indi1) {
        // Clonamos el individuo con su nota incluida
        nota = indi1.nota;

        // Inicializamos las filas (genes)
        filas = new Gen[9];
        for (int x = 0; x < 9; x++) {
            filas[x] = new Gen();
        }

        // Cargamos los datos
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (indi1.filas[x].filaFijos[y]) {
                    // Si es true significa que es fijo
                    filas[x].filaFijos[y] = true;
                    filas[x].filaGen[y] = indi1.filas[x].filaGen[y];
                    filas[x].listaAMeter.remove(Integer.valueOf(indi1.filas[x].filaGen[y]));
                } else {
                    // Si es false es un valor no fijo
                    filas[x].filaFijos[y] = false;
                    filas[x].filaGen[y] = indi1.filas[x].filaGen[y];
                }
            }
        }
    }

    // ESTE CONSTRUCTOR SOLO DEBE USARSE PARA LAS PRUEBAS
    public Individuo(String data) {
        int c = 0;
        filas = new Gen[9];
        for (int x = 0; x < 9; x++) {
            filas[x] = new Gen();
        }
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                filas[x].filaGen[y] = c;
            }
        }

    }

    public long getNota() {
        return nota;
    }

    public void evaluarSimple() {
        // Restriccion de elementos ausentes REA // SECCION 1 // SECCION 1
        long rea = 0;
        // Buscamos en todas las columnas
        for (int columna = 0; columna < 9; columna++) {
            // Todos los numeros
            for (int buscando = 1; buscando < 10; buscando++) {
                // En cada casilla
                for (int y = 0; y < 9; y++) {
                    if (filas[y].filaGen[columna] == buscando) {
                        // Lo ha encontrado, pasamos al siguiente numero a buscar
                        break;
                    }
                    // Si esto se ejecuta es porque no ha encontrado el numero x en la columna
                    if (y == 8) {
                        rea++;
                    }
                }
            }
        }

        // Buscamos en todas las cuadriculas
        for (int xx = 0; xx < 3; xx++) {
            for (int yy = 0; yy < 3; yy++) {
                // Todos los numeros
                for (int buscando = 1; buscando < 10; buscando++) {
                    // En cada casilla
                    boolean encontrado = false;
                    for (int x = 0; x < 3; x++) {
                        for (int y = 0; y < 3; y++) {
                            int posX = xx * 3 + x;
                            int posY = yy * 3 + y;
                            if (buscando == filas[posX].filaGen[posY]) encontrado = true;
                        }
                    }
                    if (!encontrado) rea++;
                }
            }
        }

        // Restriccion de sumas RS // SECCION 2 // SECCION 2
        long sumaColumnas = 0, sumaCuadriculas = 0, rs = 0;

        // Buscamos en todas las columnas
        for (int columna = 0; columna < 9; columna++) {
            // En cada casilla
            for (int y = 0; y < 9; y++) {
                sumaColumnas += filas[y].filaGen[columna];
            }
            rs += (45 - sumaColumnas);
            sumaColumnas = 0;
        }

        // Buscamos en todas las cuadriculas
        for (int xx = 0; xx < 3; xx++) {
            for (int yy = 0; yy < 3; yy++) {
                // En cada casilla
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        int posX = xx * 3 + x;
                        int posY = yy * 3 + y;
                        sumaCuadriculas += filas[posX].filaGen[posY];
                    }
                }
                rs += (45 - sumaCuadriculas);
                sumaCuadriculas = 0;
            }
        }

        // Restriccion de productosumas RP // SECCION 3 // SECCION 3
        long rp = 0;

        sumaColumnas = 1;
        // Buscamos en todas las columnas
        for (int columna = 0; columna < 9; columna++) {
            // En cada casilla
            for (int y = 0; y < 9; y++) {
                sumaColumnas *= filas[y].filaGen[columna];
            }
            double raiz = Math.sqrt(Math.abs(362880 - sumaColumnas));
            rp += raiz;
            sumaColumnas = 1;
        }

        sumaCuadriculas = 1;
        // Buscamos en todas las cuadriculas
        for (int xx = 0; xx < 3; xx++) {
            for (int yy = 0; yy < 3; yy++) {
                // En cada casilla
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        int posX = xx * 3 + x;
                        int posY = yy * 3 + y;
                        sumaCuadriculas *= filas[posX].filaGen[posY];
                    }
                }
                double raiz = Math.sqrt(Math.abs(362880 - sumaCuadriculas));
                rp += raiz;
                sumaCuadriculas = 1;
            }
        }
        nota = (5 * rs) + (20 * rea);// +(long)Math.sqrt(rp);// + rp;
    }

    public void randomizar() {
        for (int x = 0; x < 9; x++) {
            filas[x].randomizar();
        }
    }

    public void printIndividuo() {
        System.out.println("\n");
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                System.out.print(" " + filas[x].filaGen[y] + " ");
                if (y == 2 || y == 5) {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
            if (x == 2 || x == 5) {
                System.out.print("\n");
            }
        }
    }

    // SE USA EN DEBUG
    public String getStringIndi() {
        String devolver = "";
        for (int x = 0; x < 9; x++) for (int y = 0; y < 9; y++) devolver += filas[x].filaGen[y] + "";
        return devolver;
    }


    public static Individuo cruzarIndividuos(Individuo indi1, Individuo indi2) {
        Individuo nuevoA = new Individuo(indi1);
        Individuo nuevoB = new Individuo(indi1);
        Individuo nuevoC = new Individuo(indi1);

        // Generamos una fila que sera el punto de cruze
        int indiceEmpezarA = (int) (Math.random() * 9);
        int indiceEmpezarB = (int) (Math.random() * 9);
        int indiceEmpezarC = (int) (Math.random() * 9);

        // Generamos la cantidad de filas que coge del indi 2
        int cantidadA = (int) (Math.random() * 9);
        int cantidadB = (int) (Math.random() * 9);
        int cantidadC = (int) (Math.random() * 9);

        // Recorremos todas las filas
        for (int x = 0; x < 9; x++)
            if (x >= indiceEmpezarA && x < indiceEmpezarA + cantidadA)
                for (int y = 0; y < 9; y++) nuevoA.filas[x].filaGen[y] = indi2.filas[x].filaGen[y];

        // Recorremos todas las filas
        for (int x = 0; x < 9; x++)
            if (x >= indiceEmpezarB && x < indiceEmpezarB + cantidadB)
                for (int y = 0; y < 9; y++) nuevoB.filas[x].filaGen[y] = indi2.filas[x].filaGen[y];

        // Recorremos todas las filas
        for (int x = 0; x < 9; x++)
            if (x >= indiceEmpezarC && x < indiceEmpezarC + cantidadC)
                for (int y = 0; y < 9; y++) nuevoC.filas[x].filaGen[y] = indi2.filas[x].filaGen[y];

        nuevoA.evaluarSimple();
        nuevoB.evaluarSimple();
        nuevoC.evaluarSimple();

        if (nuevoA.getNota() <= nuevoB.getNota() && nuevoA.getNota() <= nuevoC.getNota()) return nuevoA;
        if (nuevoB.getNota() <= nuevoA.getNota() && nuevoB.getNota() <= nuevoC.getNota()) return nuevoB;
        return nuevoC;
    }


    public static Individuo mutarIndividuo(Individuo indi1) {
        Individuo[] nuevo = new Individuo[3];

        // Inicializamos los nuevos
        for (int x = 0; x < nuevo.length; x++) {
            nuevo[x] = new Individuo(indi1);
        }

        // Recorremos todas las filas y en las que toque mutamos
        for (int x = 0; x < 9; x++) {
            int[] aleatorios = new int[nuevo.length];

            // Generamos tres valores aleatorios
            for (int z = 0; z < aleatorios.length; z++) {
                aleatorios[z] = (int) (Math.random() * Poblacion.PROBMUTARFILA);
            }

            // Miramos si toca mutar en cada individuo
            for (int z = 0; z < aleatorios.length; z++) {
                if (aleatorios[z] == 0) {
                    int[] indices = indi1.filas[x].getDosNoFijos();
                    nuevo[z].filas[x].filaGen[indices[0]] = indi1.filas[x].filaGen[indices[1]];
                    nuevo[z].filas[x].filaGen[indices[1]] = indi1.filas[x].filaGen[indices[0]];
                }
            }
        }

        // Evaluamos los nuevos
        for (Individuo ind : nuevo) ind.evaluarSimple();

        // Obtenemos el indice del mejor
        int min = 0;
        for (int z = 0; z < nuevo.length; z++) {
            if (nuevo[z].getNota() < nuevo[min].getNota()) {
                min = z;
            }
        }
        return nuevo[min];
    }
}
