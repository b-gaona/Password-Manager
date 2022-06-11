package creadorImagenes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Imagen extends javax.swing.JPanel { //Debe de derivar de JPanel

    private BufferedImage ruta; //Creamos un objeto de Buffered Image

    //Creamos al constructor de la clase
    public Imagen(int ancho, int alto, BufferedImage ruta) { //En vez de String en ruta es BufferedImage

        this.setSize(ancho, alto); //Inicializamos el objeto con las medidas que nos dieron
        this.ruta = ruta; //E inicializamos la ruta que se recibio con el valor de ruta
    }

    @Override
    public void paint(Graphics g) { //Sobreescribimos el metodo paint
        Dimension tamaño = getSize(); //Creamos un objeto de tipo Dimension y lo ponemos con el tamaño de la imagen
        //Este sirve para cuando NO le das a escoger entre archivos y directorios. Y al g.drawImage usa un .getImage()
        //ImageIcon img= new ImageIcon(getClass().getResource(ruta)); //Mandamos la ruta 

        //Este sirve para cuando DAS a escoger entre archivos y NO esta en base de datos
        //Image img= new ImageIcon(ruta).getImage(); //Instanciamos una imagen con la ruta y obtenemos la imagen
        BufferedImage img = ruta; //Obtenemos la imagen mediante la ruta que obtengamos
        //Como parametros se pasan: la imagen, el setBounds, y en donde se va a reproducir
        g.drawImage(img, 0, 0, tamaño.width, tamaño.height, this);
        setOpaque(false); //Para que se vea
        super.paintComponent(g); //De la clase padre de todo, que se pinte.
    }

}
