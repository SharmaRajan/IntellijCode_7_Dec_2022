
import org.apache.poi.xwpf.usermodel.*;
//import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
import org.docx4j.Docx4J;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import java.util.List;

public class DocToPng {

    public void DOcxToPngFile(String input) {
        String output = "C:\\Users\\Sharmajee\\Desktop\\image.png";

        File theFile = new File(input);
        File outFile = new File(output);
        try {
            WordprocessingMLPackage wordMLPckg = Docx4J.load(theFile);
            OutputStream os = new FileOutputStream(outFile);
            FOSettings settings = Docx4J.createFOSettings();
            settings.setWmlPackage(wordMLPckg);
            settings.setApacheFopMime("image/png");
            Docx4J.toFO(settings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);
            os.close();
            System.out.println("DOne");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void ConvertToImage() {
//        DocumentConverter dc = new DocumentConverter();
//        try {
//            ImageEncoderSettings ies =
//                    (ImageEncoderSettings) dc.getPreferences().getEncoderSettings("image/png");
//
//            ies.setPageAlignment(new PageAlignment(Horizontal.CENTER, Vertical.CENTER));
//            ies.setPageScaling(com.gnostice.documents.image.PageScaling.NONE);
//            ies.setPageSizingMode(PageSizingMode.USE_PAGE_SIZE);
//            dc.getPreferences().getRenderingSettings().getResolution().setDpi(96);
//
//            dc.convertToFile("./ad.pdf", "./sample.png");
//        } catch (FormatNotSupportedException e) {
//            e.printStackTrace();
//        } catch (ConverterException e) {
//            e.printStackTrace();
//        } catch (XDocException e) {
//            e.printStackTrace();
//        }

//        Document doc = new Document("C:\\Temp\\in.docx");
//
//        ImageSaveOptions options = new ImageSaveOptions(SaveFormat.JPEG);
//
//        options.setPageCount(1);
//
//// Save each page of the document as Jpeg.
//
//        for (int i = 0; i < doc.getPageCount(); i++) {
//
//            options.setPageIndex(i);
//
//            doc.save("C:\\Temp\\out_" + i + ".jpg", options);
//
//        }

    }

    public void readWordDocument() {
        try {
            String fileName = "C:\\Users\\Sharmajee\\Desktop\\Doc.docx";
//            extractImages(fileName);
            if (!(fileName.endsWith(".doc") || fileName.endsWith(".docx"))) {
                //throw new FileFormatException();
            } else {

                XWPFDocument doc = new XWPFDocument(new FileInputStream(fileName));

                List<XWPFTable> table = doc.getTables();
                List<XWPFPictureData> piclist=doc.getAllPictures();

                for (XWPFTable xwpfTable : table) {
                    List<XWPFTableRow> row = xwpfTable.getRows();
                    for (XWPFTableRow xwpfTableRow : row) {
                        List<XWPFTableCell> cell = xwpfTableRow.getTableCells();
                        for (XWPFTableCell xwpfTableCell : cell) {
                            if (xwpfTableCell != null) {
                                System.out.println(xwpfTableCell.getText());
                                List<XWPFTable> itable = xwpfTableCell.getTables();
                                if (itable.size() != 0) {
                                    for (XWPFTable xwpfiTable : itable) {
                                        List<XWPFTableRow> irow = xwpfiTable.getRows();
                                        for (XWPFTableRow xwpfiTableRow : irow) {
                                            List<XWPFTableCell> icell = xwpfiTableRow.getTableCells();
                                            for (XWPFTableCell xwpfiTableCell : icell) {
                                                if (xwpfiTableCell != null) {
                                                    System.out.println(xwpfiTableCell.getText());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
//        catch (FileFormatException e) {
//            e.printStackTrace();
//        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void extractImages(String src){
        try{

            //create file inputstream to read from a binary file
            FileInputStream fs=new FileInputStream(src);
            //create office word 2007+ document object to wrap the word file
            XWPFDocument docx=new XWPFDocument(fs);
            //get all images from the document and store them in the list piclist
            List<XWPFPictureData> piclist=docx.getAllPictures();
            //traverse through the list and write each image to a file
            Iterator<XWPFPictureData> iterator=piclist.iterator();
            int i=0;
            while(iterator.hasNext()){
                XWPFPictureData pic=iterator.next();
                byte[] bytepic=pic.getData();
                BufferedImage imag= ImageIO.read(new ByteArrayInputStream(bytepic));
                ImageIO.write(imag, "jpg", new File("C:\\Users\\Sharmajee\\Desktop\\imagefromword"+i+".jpg"));
                i++;
            }

        }catch(Exception e){System.exit(-1);}

    }

}
