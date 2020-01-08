import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class main {

    public static void main( String args[] ) {

        String searchString = "potato panda";
        String headlineInspiration = "Sauce";

        ImageRetriever imageRetriever = new ImageRetriever( searchString );
        BufferedImage image = imageRetriever.getImage();

        File outputFile = new File( "result.jpg" );
        try {
            ImageIO.write(image, "jpg", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HeadlineGenerator headlineGenerator = new HeadlineGenerator( headlineInspiration );
        String headline = headlineGenerator.getHeadline();

        System.out.println(headline);

    }

}
