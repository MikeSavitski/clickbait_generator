import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.PhotoUrl;
import com.flickr4java.flickr.photos.SearchParameters;
import com.flickr4java.flickr.test.TestInterface;

public class ImageRetriever {

    private String searchString;

    public ImageRetriever( String searchString ) {

        this.searchString = searchString;

    }

    public BufferedImage getImage() {

        BufferedImage retrievedImage = new BufferedImage(1, 1, BufferedImage.TYPE_3BYTE_BGR);

        String apiKey = "ee870310e71986756ef307e2a4184b03";
        String sharedSecret = "4d16fd362d57f34a";
        Flickr flickr = new Flickr(apiKey, sharedSecret, new REST());

        SearchParameters parameters = new SearchParameters();
        parameters.setAccuracy(1);
        parameters.setSort(SearchParameters.RELEVANCE);
        parameters.setLicense("0");
        parameters.setSafeSearch("1");
        parameters.setPrivacyFilter(1);
        parameters.setText( searchString );
        PhotoList<Photo> list = null;
        try {
            list = flickr.getPhotosInterface().search(parameters, 25, 1);
        } catch (FlickrException e) {
            e.printStackTrace();
        }

        if (list != null && list.size() > 0) {

            Random random = new Random();
            int random_int = random.nextInt( list.size() );

            String urlString = null;
            try {
                Photo info = flickr.getPhotosInterface().getInfo(list.get(0).getId(), sharedSecret);
                urlString = info.getUrl();
                retrievedImage = list.get(random_int).getLargeImage();
            } catch (FlickrException | IOException e) {
                e.printStackTrace();
            }

            System.out.println(urlString);
        }
        else {
            System.out.println("No photos.");
        }

        return retrievedImage;

    }

}
