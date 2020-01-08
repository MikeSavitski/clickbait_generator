import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreateBait {

    private BufferedImage image;
    private String headline;

    public CreateBait( BufferedImage image, String headline) {

        this.image = image;
        this.headline = headline;

    }

    public void create() {

        Graphics graphic = image.getGraphics();

        int y = ( image.getHeight() / 10 ) * 8;
        graphic.setColor( Color.WHITE );
        graphic.fillRect( 0, y, image.getWidth(), image.getHeight());

        float fontSize = ( (float) image.getWidth() / (float) headline.length() ) * 2.0f;
        graphic.setFont( graphic.getFont().deriveFont( fontSize ) );
        graphic.setColor( Color.BLACK );
        y = ( image.getHeight() / 10 ) * 9;
        graphic.drawString( headline, 0, y );

        try {
            ImageIO.write( image, "jpg", new File("bait.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
