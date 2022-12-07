import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.util.List;

public class ImageReader {

    public void imageRead(){
        try {
            FileInputStream fis = new FileInputStream("test.docx");
            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
            List pic = xdoc.getAllPictures();
            if (!pic.isEmpty()) {
//                System.out.print(pic.get(0).getPictureType());
//                System.out.print(pic.get(0).getData());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
