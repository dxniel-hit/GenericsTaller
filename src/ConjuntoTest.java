public class ConjuntoTest {

    public static void main(String[] args) {

        Conjunto<Integer> conjuntoA = new Conjunto<>(5);
        conjuntoA.agregar(1);
        conjuntoA.agregar(2);
        conjuntoA.agregar(3);

        Conjunto<Integer> conjuntoB = new Conjunto<>(5);
        conjuntoB.agregar(3);
        conjuntoB.agregar(4);
        conjuntoB.agregar(5);

        Conjunto<String> conjuntoC = new Conjunto<>(5);
        conjuntoC.agregar("U");
        conjuntoC.agregar("N");
        conjuntoC.agregar("I");

        Conjunto<String> conjuntoD = new Conjunto<>(5);
        conjuntoD.agregar("B");
        conjuntoD.agregar("S");
        conjuntoD.agregar("D");

        Conjunto<Double> conjuntoE = new Conjunto<>(5);
        conjuntoE.agregar(10.0);
        conjuntoE.agregar(20.0);
        conjuntoE.agregar(30.5);

        Conjunto<Double> conjuntoF = new Conjunto<>(5);
        conjuntoF.agregar(30.5);
        conjuntoF.agregar(40.6);
        conjuntoF.agregar(19.1);


        System.out.println("Conjunto A:");
        conjuntoA.imprimir();

        System.out.println("Conjunto B:");
        conjuntoB.imprimir();

        System.out.println("Conjunto C:");
        conjuntoC.imprimir();

        System.out.println("Conjunto D:");
        conjuntoD.imprimir();

        System.out.println("Conjunto E:");
        conjuntoE.imprimir();

        System.out.println("Conjunto F:");
        conjuntoF.imprimir();

        //Verificar si un elemento está contenido en el conjunto.
        System.out.println("¿Es el conjunto B subconjunto del conjunto A?: " + conjuntoA.esSubconjunto(conjuntoB));

        // Agregar todos los elementos de un conjunto a otro de todos los tipos de datos.
        conjuntoA.union(conjuntoB);
        conjuntoC.union(conjuntoD);
        conjuntoE.union(conjuntoF);

        //Imprimir los conjuntos despues de unirlos.

        System.out.println("Despues de unir , Conjunto A:");
        conjuntoA.imprimir();
        System.out.println("Despues de unir , Conjunto C:");
        conjuntoC.imprimir();
        System.out.println("Despues de unir , Conjunto E:");
        conjuntoE.imprimir();
    }
}