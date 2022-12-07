import com.spire.doc.*;
import com.spire.doc.documents.ImageType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpireConvertor {

    public void wordToImage(String src){
        try{
        //Create a Document instance
        Document document = new Document();
        //Load a Word document
        document.loadFromFile(src);

        //Save the first page to a .png image
//            BufferedImage image= document.saveToImages(0, ImageType.Bitmap);
            BufferedImage image= document.saveToImages(0, ImageType.Metafile);

            String path = "C:\\Users\\Sharmajee\\Desktop\\document.png";

        File file= new File(path);
        ImageIO.write(image, "PNG", file);
        }catch(IOException io){
            io.printStackTrace();
        }catch(Exception exc){
            exc.printStackTrace();
        }
    }

}
