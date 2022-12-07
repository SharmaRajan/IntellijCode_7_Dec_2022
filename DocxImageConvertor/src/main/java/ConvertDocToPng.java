import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xpath.operations.Mult;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;

import java.io.*;

public class ConvertDocToPng {

//    public MultipartFile docxToPdf(String src) throws Exception{
//        File file = new File(src);
//        FileInputStream inputStream = new FileInputStream(file);
//        MultipartFile file = new Mock
//
//
//    }

//    public MultipartFile pdfToPng(MultipartFile multipartFile){
//
//    }

//    public void docxToPdf(MultipartFile file,String fileName){
//
//
//        try {
//            File pdfFile=convertMultiPartToFile(file);
//            InputStream is = new FileInputStream(pdfFile);
//            OutputStream out = new FileOutputStream(new File("rdtschools-Docx2PdfConverted_PDF_File.pdf"));
////            MultipartFile out = new File
//            long start = System.currentTimeMillis();
//            // 1) Load DOCX into XWPFDocument
//            XWPFDocument document = new XWPFDocument(is);
//            // 2) Prepare Pdf options
//            PdfOptions options = PdfOptions.create();
//            // 3) Convert XWPFDocument to Pdf
//            PdfConverter.getInstance().convert(document, out, options);
//            System.out.println("rdtschools-Docx2PdfConversion-word-sample.docx was converted to a PDF file in :: "
//                    + (System.currentTimeMillis() - start) + " milli seconds");
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//    }

    private File convertMultiPartToFile(MultipartFile file ) throws IOException {
        File convFile = new File( file.getOriginalFilename() );
        FileOutputStream fos = new FileOutputStream( convFile );
        fos.write( file.getBytes() );
        fos.close();
        return convFile;
    }

    public void docxTOPng(String src){
        String str = "C:\\Users\\Sharmajee\\Desktop\\document.pdf";

        // Creating pdf from word file
        try{
            FileInputStream file = new FileInputStream(src);
            Document document = new Document();
            PdfWriter.getInstance(document,new FileOutputStream(str));
            document.open();
            Paragraph paragraph = new Paragraph("This is testing");

            document.add(paragraph);
            document.close();
//            XWPFDocument document = new XWPFDocument(file);
//            PdfOptions options = PdfOptions.create();

//            OutputStream out = new FileOutputStream(str);
//
//            PdfConverter.getInstance().convert(document,out,options);
//            document.close();
//            out.close();
            System.out.println("Done");
        }catch (Exception exc){
            exc.printStackTrace();
        }
    }

}
