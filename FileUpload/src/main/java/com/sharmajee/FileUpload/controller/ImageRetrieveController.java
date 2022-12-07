package com.sharmajee.FileUpload.controller;

import com.aspose.words.*;

import com.aspose.words.Document;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.tomcat.util.http.fileupload.FileItem;

//import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/docx/png")
public class ImageRetrieveController {

    public Document extractPages(int index, int count)
            throws java.lang.Exception{

        return null;
    }


//    public static void readWordDocument() {
//        try {
//            String fileName = "C:\\sample.docx";
//
//            if (!(fileName.endsWith(".doc") || fileName.endsWith(".docx"))) {
//                throw new FileFormatException();
//            } else {
//
//                XWPFDocument doc = new XWPFDocument(new FileInputStream(fileName));
//
//                List<XWPFTable> table = doc.getTables();
//
//                for (XWPFTable xwpfTable : table) {
//                    List<XWPFTableRow> row = xwpfTable.getRows();
//                    for (XWPFTableRow xwpfTableRow : row) {
//                        List<XWPFTableCell> cell = xwpfTableRow.getTableCells();
//                        for (XWPFTableCell xwpfTableCell : cell) {
//                            if (xwpfTableCell != null) {
//                                System.out.println(xwpfTableCell.getText());
//                                List<XWPFTable> itable = xwpfTableCell.getTables();
//                                if (itable.size() != 0) {
//                                    for (XWPFTable xwpfiTable : itable) {
//                                        List<XWPFTableRow> irow = xwpfiTable.getRows();
//                                        for (XWPFTableRow xwpfiTableRow : irow) {
//                                            List<XWPFTableCell> icell = xwpfiTableRow.getTableCells();
//                                            for (XWPFTableCell xwpfiTableCell : icell) {
//                                                if (xwpfiTableCell != null) {
//                                                    System.out.println(xwpfiTableCell.getText());
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
            public static void extractImages(String src){
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
                        ImageIO.write(imag, "jpg", new File("C:/Desktop/imagefromword"+i+".jpg"));
                        i++;
                    }

                }catch(Exception e){System.exit(-1);}

            }

            @PostMapping
//    public void convertDocxToPng(MultipartFile multipart, Path dir){
    public void convertDocxToPng() throws Exception {
//        Path filePath = Paths.get(dir.toString(), multipart.getOriginalFilename());
//
//        try(OutputStream out = Files.newOutputStream(filePath)){
//            multipart.transferTo(filePath);
//        }catch(IOException ioException){
//
//        }catch (Exception exc){
//
//        }

        Document doc = new Document("Document.docx");

        for (int page = 0; page < doc.getPageCount(); page++)
        {
            //Document extractedPage = doc.extractPages(page, 1);
            //extractedPage.save(String.format("Output_%d.Output.png", page + 1));
        }
    }

    public  static File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
        multipart.transferTo(convFile);
        return convFile;
    }

    public File convertMultiPartToFile(MultipartFile file ) throws IOException {
        File convFile = new File( file.getOriginalFilename() );
        FileOutputStream fos = new FileOutputStream( convFile );
        fos.write( file.getBytes() );
        fos.close();
        return convFile;
    }

    public File getTempFile(MultipartFile multipartFile)
    {
//        CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile) multipartFile;
//        FileItem fileItem = commonsMultipartFile.getFileItem();
//        DiskFileItem diskFileItem = (DiskFileItem) fileItem;
//        String absPath = diskFileItem.getStoreLocation().getAbsolutePath();
//        File file = new File(absPath);
//
//        //trick to implicitly save on disk small files (<10240 bytes by default)
//        if (!file.exists()) {
//            file.createNewFile();
//            multipartFile.transferTo(file);
//        }
//
//        return file;


//        else if(formName != null && formName.equals("statutoryCompliances")) {
//        if(clfFormDate != null && !clfFormDate.isEmpty()) {
//
//            List<Financial> fins = finyearRepository.findAll();
//            SimpleDateFormat formatter =new SimpleDateFormat("yyyy-mm-dd");
//            Date date2=formatter.parse(clfFormDate);
//            List<Financial> test = new ArrayList<Financial>();
//            List<Financial> finList = new ArrayList<Financial>();
//            Date date = new Date();
//            boolean iflag = true;
//            boolean jflag = true;
//            int a = -1;
//            int b = -1;
//
//            for(int i =0; i<fins.size();i++ ) {
//                Financial fx = fins.get(i);
//                iflag = date2.after(fx.getFnclStartDate()) || date2.equals(fx.getFnclStartDate()) ;
//                if(iflag==false) {
//                    a=i;
//                    break;
//                }
//
//            }
//
//            for(int j = 0; j <fins.size();j++ ) {
//                Financial fx = fins.get(j);
//                jflag = date.after(fx.getFnclEndDate()) || date.equals(fx.getFnclEndDate());
//                if(jflag==false) {
//                    b=j;
//                    break;
//                }
//            }
//
//
//
//            if((a > 0 && b > 0) ) {
//                for (int k = a - 1; k < b + 1; k++) {
//                    test.add(fins.get(k));
//                }
//            }
//
//            if((test.size() > 3)) {
//                for (int m = test.size() - 3; m > test.size(); m++) {
//                    finList.add(test.get(m));
//                }
//                wrapperList = finList.stream().map(fin -> modelMapper.map(fin, FinancialYearResponse.class))
//                        .collect(Collectors.toList());
//            }else if((test.size() >= 0 && test.size() <= 3)){
//                wrapperList = test.stream().map(fin -> modelMapper.map(fin, FinancialYearResponse.class))
//                        .collect(Collectors.toList());
//            }
//        }
//        else {
//            List<Financial> fins = finyearRepository.findAll();
//            wrapperList = fins.stream().map(fin -> modelMapper.map(fin, FinancialYearResponse.class))
//                    .collect(Collectors.toList());
//        }
//
//    }




        return null;
    }

    public static void getPnfFrmDocx(MultipartFile multipartFile) throws Exception {

//        CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile) multipartFile;
//        FileItem fileItem = commonsMultipartFile.getFileItem();
//        DiskFileItem diskFileItem = (DiskFileItem) fileItem;
//        String absPath = diskFileItem.getStoreLocation().getAbsolutePath();
//        File file = new File(absPath);

        // Load Word document
        Document doc = new Document("Document.docx");

        // Get all the shapes
        NodeCollection<Shape> shapes = (NodeCollection<Shape>) doc.getChildNodes(NodeType.SHAPE, true);
        int imageIndex = 0;

        // Loop through the shape collection
        for (Shape shape : shapes) {

            // Check if shape has image
            if (shape.hasImage()) {

                // Extract and save the image
                String imageFileName = String.format(
                        "Image.ExportImages.{0}_out_{1}", imageIndex, FileFormatUtil.imageTypeToExtension(shape.getImageData().getImageType()));
                OutputStream dataDir = null;
                shape.getImageData().save(dataDir + imageFileName);
                imageIndex++;
            }
        }
    }


}
