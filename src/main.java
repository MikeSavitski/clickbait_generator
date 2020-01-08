import java.awt.image.BufferedImage;

public class main {

    public static void main( String args[] ) {

        String searchString = "potato";
        ImageRetriever imageRetriever = new ImageRetriever( searchString );
        BufferedImage image = imageRetriever.getImage();

    }

}
