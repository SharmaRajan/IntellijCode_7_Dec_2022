import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.docx4j.Docx4J;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        extractImages("C:\\Users\\Sharmajee\\Desktop\\file-sample_500kB.docx");
//        convertFiletoMultiPart();
//        createDocx();

//        ReadDocx readDocx = new ReadDocx();
//        readDocx.readDoc();

//        int width = 963;
//        int heigth = 640;
//
//        BufferImage bufferImage = new BufferImage();
//
//        BufferedImage image = null;
//
//        image = bufferImage.readFromFile(width,heigth,image);
//        bufferImage.writeToFile(image);

//        DocToPng png = new DocToPng();
        String src = "C:\\Users\\Sharmajee\\Desktop\\Doc.docx";
////        png.DOcxToPngFile("C:\\Users\\Sharmajee\\Desktop\\Doc.docx");
//
//        png.readWordDocument();
//        png.extractImages(src);

        //SpireConvertor png = new SpireConvertor();
        //png.wordToImage(src);



        ConvertDocToPng doc = new ConvertDocToPng();
        doc.docxTOPng(src);

    }



//    private static void convertFiletoMultiPart() {
//        try {
//            File file = new File(FILE_PATH);
//            if (file.exists()) {
//                System.out.println("File Exist => " + file.getName() + " :: " + file.getAbsolutePath());
//            }
//            FileInputStream input = new FileInputStream(file);
//            MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain",
//                    IOUtils.toByteArray(input));
//            System.out.println("multipartFile => " + multipartFile.isEmpty() + " :: "
//                    + multipartFile.getOriginalFilename() + " :: " + multipartFile.getName() + " :: "
//                    + multipartFile.getSize() + " :: " + multipartFile.getBytes());
//        } catch (IOException e) {
//            System.out.println("Exception => " + e.getLocalizedMessage());
//        }
//
//    }

    public static void docsTOPng(){
        String inPath="D:\\pdfconverterfolder\\test.docx";
        String outPath="D:\\pdfconverterfolder\\pngOutput.png";
        File theFile = new File(inPath);
        File outile=new File(outPath);
        try {
            WordprocessingMLPackage wordMLPckg = Docx4J.load(theFile);
            OutputStream os = new FileOutputStream(outile);
            FOSettings settings = Docx4J.createFOSettings();
            settings.setWmlPackage(wordMLPckg);
            settings.setApacheFopMime("images/png");
            Docx4J.toFO(settings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);
            os.close();
        }catch(Exception exc){
            exc.printStackTrace();
        }
        System.out.println("DOne");
    }

    public static void createDocx(){
//        try {
//            WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
//            MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
//            mainDocumentPart.addStyledParagraphOfText("Title", "Hello World!");
//            mainDocumentPart.addParagraphOfText("Welcome To Baeldung");
//            File exportFile = new File("welcome.docx");
//            wordPackage.save(exportFile);
//        }catch(Exception exc){
//            exc.printStackTrace();
//        }

//        ObjectFactory factory = Context.getWmlObjectFactory();
//        P p = factory.createP();
//        R r = factory.createR();
//        Text t = factory.createText();
//        t.setValue("Welcome To Baeldung");
//        r.getContent().add(t);
//        p.getContent().add(r);
//        RPr rpr = factory.createRPr();
//        BooleanDefaultTrue b = new BooleanDefaultTrue();
//        rpr.setB(b);
//        rpr.setI(b);
//        rpr.setCaps(b);
//        Color green = factory.createColor();
//        green.setVal("green");
//        rpr.setColor(green);
//        r.setRPr(rpr);
//        mainDocumentPart.getContent().add(p);
//        File exportFile = new File("welcome.docx");
//        wordPackage.save(exportFile);
    }
}