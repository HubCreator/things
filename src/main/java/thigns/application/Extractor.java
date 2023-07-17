package thigns.application;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDirectory;

import java.io.File;
import java.io.IOException;

public class Extractor {

    String imagePath = "src/main/resources/leoleo.jpeg";


    public void extract() throws ImageProcessingException, IOException {
        String pdsLat = "";
        String pdsLon = "";

        File file = new File(imagePath);

        Metadata metadata = ImageMetadataReader.readMetadata(file);
        GpsDirectory gpsDirectory = metadata.getFirstDirectoryOfType(GpsDirectory.class);

        //위도,경도 호출
        if (gpsDirectory.containsTag(GpsDirectory.TAG_LATITUDE) && gpsDirectory.containsTag(GpsDirectory.TAG_LONGITUDE)) {

            pdsLat = String.valueOf(gpsDirectory.getGeoLocation().getLatitude());
            pdsLon = String.valueOf(gpsDirectory.getGeoLocation().getLongitude());

            double lat = Double.parseDouble(pdsLat);    //위도
            double lon = Double.parseDouble(pdsLon);    //경도

            System.out.println("lat = " + lat);
            System.out.println("lon = " + lon);
        }
    }

    public static void main(String[] args) throws ImageProcessingException, IOException {
        Extractor extractor = new Extractor();
        extractor.extract();
    }

}
