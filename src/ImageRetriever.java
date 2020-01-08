import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.Collections;

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

        String[] searchTags = { searchString };

        SearchParameters parameters = new SearchParameters();
        parameters.setAccuracy(1);
        parameters.setTags( searchTags );
        PhotoList<Photo> list = null;
        try {
            list = flickr.getPhotosInterface().search(parameters, 1, 1);
        } catch (FlickrException e) {
            e.printStackTrace();
        }

        if (list != null && list.size() > 0) {
            System.out.println("Number of photos = " + list.size());

            String urlString = null;
            try {
                Photo info = flickr.getPhotosInterface().getInfo(list.get(0).getId(), sharedSecret);
                urlString = info.getUrl();
            } catch (FlickrException e) {
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
