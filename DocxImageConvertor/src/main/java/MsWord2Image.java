import com.mswordtoimage.MsWordToImageConvert;
import com.mswordtoimage.OutputImageFormat;

import java.io.IOException;

public class MsWord2Image {

    public void docxToImageCon(String src,String dest) throws IOException {

        MsWordToImageConvert convert = new MsWordToImageConvert();
        convert.fromFile(src);
        boolean convertedFile = convert.toFile(dest, OutputImageFormat.PNG);

        if(convertedFile){
            System.out.println("File converted");
        }else{
            System.out.println("File not converted");
        }
    }

}
