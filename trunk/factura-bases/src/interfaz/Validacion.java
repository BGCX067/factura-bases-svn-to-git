/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class Validacion {

    Color color;

    public int mensaje(String msj, int op) {
        int seleccion = 0;
        switch (op) {
            case 1:
                JOptionPane.showMessageDialog(null, msj, "Informacion", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, msj, "Informacion", JOptionPane.ERROR_MESSAGE);
                break;
            case 3: {
                seleccion = JOptionPane.showOptionDialog(
                        null, // Componente padre
                        msj, //Mensaje
                        "Seleccione una opción", // Título
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, // null para icono por defecto.
                        new Object[]{"Si", "No"}, // null para YES, NO y CANCEL
                        "Si");

            }
            break;

        }
        return seleccion;
    }

    public boolean solonumerico(String valor) {
        boolean b = false;
        for (int i = 0; i < valor.length(); i++) {

            if (Character.isDigit(i) == true) {
                b = true;
                break;
            } // end if

        } // end for
        return b;
    }

    public boolean esPalabra(String palabra) {

        for (int i = 0; i < palabra.length(); i++) {
            if (!((palabra.charAt(i) > 64 && palabra.charAt(i) < 91)
                    || (palabra.charAt(i) > 96 && palabra.charAt(i) < 123))) {
                getColor(false);
                return false;

            }
        }
        getColor(true);
        return true;
    }

    public boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;

        try {

            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
// Coeficientes de validación cédula
// El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

return cedulaCorrecta;
    }

    public void getColor(boolean f) {
        if (f) {
            color = new Color(204, 204, 255);

        } else {
            color = new Color(255, 102, 102);

        }

    }

    public Color getColor() {
        return color;
    }
}
