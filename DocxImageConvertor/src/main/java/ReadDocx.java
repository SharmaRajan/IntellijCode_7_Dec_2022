
// Step 1
import org.apache.poi.xwpf.usermodel.XWPFDocument;

//Step 2: Reading out documents
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.extractor.*;

//Step 3: Read from Hard drive
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

//Step 4: Choose file
import javax.swing.JFileChooser;

public class ReadDocx {

    public void readDoc(){
        JFileChooser window = new JFileChooser();
        int returnVal = window.showOpenDialog(null);

//        FileInputStream fileInputStream = new FileInputStream();

        //APPROVE_OPTION is Open Button itself
        if(returnVal == JFileChooser.APPROVE_OPTION){
            try {
                XWPFDocument document = new XWPFDocument(new FileInputStream(window.getSelectedFile()));

                XWPFWordExtractor extractor = new XWPFWordExtractor(document);

                List<String> getText = Collections.singletonList(extractor.getText());
                for(String str: getText)
                    System.out.println(str);

            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }catch(Exception exc){
                exc.printStackTrace();
            }
        }

    }

}
