public class Casilla   { 
    private Numero numeroCasilla; 
    private int x ; 
    private int y ; 

    public Casilla (Numero numeroCasilla, int x, int y ) { 
        setNumeroCasilla (numeroCasilla ) ; 
        setCoordenadas (x,y); 
    } 

    public void setNumeroCasilla (Numero numeroCasilla ) { 
        this.numeroCasilla = numeroCasilla ; 
    }

    public Numero  getNumeroCasilla ()  {
        return numeroCasilla ; 
    }

    public void setX (int x ) { 
        this.x = x ; 
    }

    public void setY(int y ) { 
        this.y= y ; 
    }

    public int getX() {
        return x; 
    } 

    public int getY () {
        return y ; 
    }

    public void setCoordenadas  ( int x , int y ) { 
        setX(x) ; 
        setY(y); 
    }

    public int [] getCoordenadas  ()  {
        int [] coordenadas = new int  [2] ; 
        coordenadas [0] = x ; 
        coordenadas [1] = y;
        return coordenadas;
    }

} 