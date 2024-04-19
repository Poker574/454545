/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication12;

/**
 *
 * @author poker
 */

    /**
     * @param args the command line arguments
     */
import java.util.Scanner;

class Node {
    double coefficient;
    int exponent;
    Node next;

    // Constructor para inicializar un nodo con coeficiente y exponente
    public Node(double coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}

// Clase que representa una lista enlazada
class LinkedList {
    Node head;

    // Constructor para inicializar una lista enlazada vacía
    public LinkedList() {
        this.head = null;
    }

    // Método para insertar un nuevo término (coeficiente, exponente) en la lista enlazada
    public void insert(double coefficient, int exponent) {
        Node newNode = new Node(coefficient, exponent);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Método para evaluar el polinomio para un valor dado de x
    public double evaluatePolynomial(double x) {
        double result = 0;
        Node temp = head;
        while (temp != null) {
            result += temp.coefficient * Math.pow(x, temp.exponent);
            temp = temp.next;
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList polynomial = new LinkedList();

        System.out.println("Ingrese los términos del polinomio separados por comas y espacios:");
        System.out.println("Ejemplo: (2X^3-5X^2+ 3X+7) 23, 52, 3 1,70");

        String input = scanner.nextLine();
        String[] terms = input.split(",");
        for (String term : terms) {
            term = term.trim();
            String[] parts = term.split("\\s+");
            try {
                double coefficient = Double.parseDouble(parts[0]);
                int exponent = Integer.parseInt(parts[1]);
                polynomial.insert(coefficient, exponent);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Formato inválido. Verifique que los términos estén separados por comas y espacios.");
                return;
            }
        }

        // Calcular y mostrar los valores del polinomio para x 
        System.out.println("Tabla de valores del polinomio:");
        System.out.println("x\t| Polinomio");
        System.out.println("---------------------");
        for (double x = 0.0; x <= 5.0; x += 0.5) {
            double result = polynomial.evaluatePolynomial(x);
            System.out.println(x + "\t| " + result);
        }

        scanner.close();
    }
}
