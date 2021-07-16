import javax.swing.JOptionPane;
import java.util.Random;
public class Cuadro   { 
  private  Casilla cuadro [][] =  new Casilla [4][4] ; 
    public Cuadro (){}

    public void iniciarCuadro() {
        Random r = new Random();
        for ( int i=0; i<4;i++ ) {
            for  ( int j=0;j<4;j++){
                int valor=r.nextInt(16);//para valores del 0 al 15
                while(buscarNumero(valor)==true){
                    valor=r.nextInt(16);
                }
                Numero temp  = new Numero (valor) ; 
                cuadro[i][j]= new Casilla(temp,i,j ) ;
            }
        }
    }

    public String imprimirCuadro ()  {
        String impresion="";
        impresion+="\n|-------||-------||-------||-------|\n";
        for( int i =0; i<4; i++) {
            for (int j=0; j<4; j++) {
                if(cuadro[i][j].getNumeroCasilla().getValor()!=0){
                    if( cuadro[i][j].getNumeroCasilla().getValor()<10){
                        impresion+="|    "+cuadro [i][j].getNumeroCasilla().getValor()+ "   |"  ; }else{
                        impresion+="|   "+cuadro [i][j].getNumeroCasilla().getValor()+ "  |"  ;}
                }   
                if(cuadro[i][j].getNumeroCasilla().getValor()==0){
                    impresion+= "|          "  ;
                }
            }
            impresion+="\n|-------||-------||-------||-------|\n";
        }
        return impresion;
    }

    public void moverNumero (int valor )  {
        if (!verificarAdyacencia(valor)){
            JOptionPane.showMessageDialog  ( null,"Este numero no se puede mover de su casilla \n" 
                + "debido a que no tiene la casila vacia adyacente" ) ; }
        else {
            moverNumero(valor,verificarAdyacencia(valor));
        }
    }

    private void moverNumero ( int valor, boolean adyacencia )  {
        if( adyacencia) {
            Casilla casillaNumero = buscarCasillaNumero (valor) ;
            Casilla casillaVacia  = buscarCasillaNumero (0) ; 
            Numero numeroAmover = casillaNumero.getNumeroCasilla();
            int xNum = casillaNumero.getX();
            int yNum = casillaNumero.getY(); 
            int xVac =  casillaVacia.getX(); 
            int yVac =  casillaVacia.getY();
            cuadro [xNum][yNum].setNumeroCasilla (new Numero (0));
            cuadro [xVac][yVac].setNumeroCasilla (numeroAmover);
        }
    }

    private boolean verificarAdyacencia  (int valor)  { 
        boolean estado = false ; 
        Casilla casillaNumero = buscarCasillaNumero (valor) ; 
        Casilla casillaVacia = buscarCasillaNumero(0); 
        int xNum = casillaNumero.getX();
        int yNum = casillaNumero.getY(); 
        int xVac =  casillaVacia.getX(); 
        int yVac =  casillaVacia.getY();

        if ( xNum == xVac && yNum +1 == yVac)  {estado = true; }
        if ( xNum == xVac && yNum -1 == yVac)  {estado = true; } 
        if ( xNum + 1 == xVac && yNum == yVac) {estado = true; } 
        if ( xNum - 1 == xVac && yNum == yVac) {estado = true; } 

        return estado ;
    } 

    private Casilla  buscarCasillaNumero (int valor )  {
        Casilla temp = null;
        for (int x=0; x<4; x++) {
            for( int y =0; y<4 ; y++)  {
                if (cuadro[x][y]!= null) {
                    if (cuadro[x][y].getNumeroCasilla().getValor()== valor ) {
                        temp= cuadro[x][y] ; 
                    }
                }
            }
        }
        return temp;
    }

    private boolean buscarNumero (int valor) {
        boolean estado  = false;
        for (int x=0; x<4; x++) {
            for( int y =0; y<4 ; y++)  {
                if (cuadro[x][y]!= null) {
                    if (cuadro[x][y].getNumeroCasilla().getValor()== valor ) {
                        estado = true ; 
                    }
                }
            }
        }
        return estado;
    }

    public boolean solucionado() { 
        Casilla cuadroResuelto[][]= cuadroResuelto();
        boolean estado = false; 
        if ( cuadroResuelto.equals(cuadro)){
            estado =true;
        }
        return estado;
    }

    private Casilla [][] cuadroResuelto () {
        int valor =1; 
        Casilla cuadroResuelto[][] = new Casilla [4][4]; 
        for ( int i=0; i< 4 ; i ++ ) {
            for  ( int j =0; j <4; j++) {
                if ( valor != 16) {
                    Numero temp  = new Numero ( valor ) ; 
                    cuadroResuelto[i][j]= new Casilla( temp, i,j ) ;
                    valor ++;
                }else { cuadroResuelto [i][j]= new Casilla ( new Numero (0) , i, j); valor++; }

            }
        }
        return cuadroResuelto;
    } 

    public String cuadroSolucionado () {
        Casilla cuadroResuelto[][]= cuadroResuelto();
        String impresion="";
        impresion+="\n|-------||-------||-------||-------|\n";
        for( int i =0; i<4; i++) {
            for (int j=0; j<4; j++) {
                if(cuadroResuelto[i][j].getNumeroCasilla().getValor()!=0){
                    if( cuadroResuelto[i][j].getNumeroCasilla().getValor()<10){
                        impresion+="|    "+cuadroResuelto [i][j].getNumeroCasilla().getValor()+ "   |"  ; }else{
                        impresion+="|   "+cuadroResuelto [i][j].getNumeroCasilla().getValor()+ "  |"  ;}
                }   
                if(cuadroResuelto[i][j].getNumeroCasilla().getValor()==0){
                    impresion+= "|          "  ;
                }
            }
            impresion+="\n|-------||-------||-------||-------|\n";
        }
        return impresion;
    } 

} 