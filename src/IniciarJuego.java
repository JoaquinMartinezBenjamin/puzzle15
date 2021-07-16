import javax.swing.*;

public class IniciarJuego  {
public void menu(){
try{
  int selector=-1;
        Cuadro c= new Cuadro();
        c.iniciarCuadro();
        while(selector!=0){
            selector=Integer.parseInt(JOptionPane.showInputDialog("Elija una opcion"
                    +"\n-----------------------------------"
                    +"\n1 = Mover numero"
                    +"\n2 = Ver solucion"
                    +"\n0 = Salir"
                    +"\n-----------------------------------"
                    +"\n      CUADRO MAGICO"
                    +"\n-----------------------------------"
                    + c.imprimirCuadro()
                    +"\n-----------------------------------------------------"
                    +"\nIntroduzca aqui el numero de la opcion"
                    +"\n-----------------------------------------------------"));
            switch (selector)
            {
                case 1: int numeroAmover  = Integer.parseInt (JOptionPane.showInputDialog ( c.imprimirCuadro()+"\n Introduzca el numero que " 
                            +  " desea mover") );
                while(numeroAmover<1||numeroAmover>15){
                    numeroAmover  = Integer.parseInt (JOptionPane.showInputDialog ( c.imprimirCuadro()+"\n Introduzca el numero que " 
                            +  " \ndesea mover en un rango del 1 al 15"));
                }
                c.moverNumero(numeroAmover);
                if(c.solucionado()){selector=0;}
                break;
                case 2: JOptionPane.showMessageDialog(null,c.cuadroSolucionado());
                break;
                case 0:
                break;
                default: JOptionPane.showMessageDialog(null,"Esta opci�n no est� dentro del menu"
                    +"\n por favor vuelva a intentar");
                break;
            }
        }
       
        } catch(NumberFormatException e){ 
            JOptionPane.showMessageDialog(null, "Por favor ingrese un numero entero", "Error de sintaxis", JOptionPane.ERROR_MESSAGE);
            //Llamo nuevamente al metodo
            menu();
        }
}


    public static void main(String []args){
      
        IniciarJuego i= new IniciarJuego();
        i.menu();
    }

}