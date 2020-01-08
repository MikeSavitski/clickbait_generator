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

        int minWidth = 1000;
        if ( image.getWidth() < minWidth ) {
            int scale = minWidth / image.getWidth();
            int scaledHeight = image.getHeight() * scale;
            image = scale( image, minWidth, scaledHeight );
            System.out.println( "Tried scaling." );
        }

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

    private BufferedImage scale( BufferedImage src, int w, int h )
    {
        BufferedImage img =
                new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int x, y;
        int ww = src.getWidth();
        int hh = src.getHeight();
        int[] ys = new int[h];
        for (y = 0; y < h; y++)
            ys[y] = y * hh / h;
        for (x = 0; x < w; x++) {
            int newX = x * ww / w;
            for (y = 0; y < h; y++) {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }
        return img;
    }

}
