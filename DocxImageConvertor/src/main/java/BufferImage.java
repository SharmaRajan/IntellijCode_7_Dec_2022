import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class BufferImage {

    public BufferImage(){}

    public BufferedImage readFromFile(int width, int height, BufferedImage bufferedImage){

        try{
            File sampleFile = new File("C:\\Users\\Sharmajee\\Desktop\\Doc.docx");
            bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);

            //Reading input file
            bufferedImage = ImageIO.read(sampleFile);

            System.out.println("Reading complete");

        }catch(IOException io){
            io.printStackTrace();
        } catch(Exception exc){
            exc.printStackTrace();
        }
        return bufferedImage;
    }

    public void writeToFile(BufferedImage image){
        try{
            File output =   new File("C:/Users/Sharmajee/Desktop/out.jpg");
            ImageIO.write(image,"jpg",output);
            System.out.println("Writing complete");
        }catch(IOException io){
            io.printStackTrace();
        } catch(Exception exc){
            exc.printStackTrace();
        }
    }
    public static void extractImages(String src) {
        try {

            //create file inputstream to read from a binary file
            FileInputStream fs = new FileInputStream(src);
            //create office word 2007+ document object to wrap the word file
            XWPFDocument docx = new XWPFDocument(fs);
            //get all images from the document and store them in the list piclist
            List<XWPFPictureData> piclist = docx.getAllPictures();
            //traverse through the list and write each image to a file
            Iterator<XWPFPictureData> iterator = piclist.iterator();
            int i = 1;
            while (iterator.hasNext()) {
                XWPFPictureData pic = iterator.next();
                byte[] bytepic = pic.getData();
                BufferedImage imag = ImageIO.read(new ByteArrayInputStream(bytepic));
                ImageIO.write(imag, "jpg", new File("C:\\Users\\Sharmajee\\Desktop\\docx " + i + ".jpg"));
                i++;
            }

        } catch (Exception e) {
            System.exit(-1);
        }

    }


}
