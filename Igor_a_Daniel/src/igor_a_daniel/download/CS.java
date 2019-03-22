/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igor_a_daniel.download;
import java.time.LocalDate;
import igor_a_daniel.download.parserFromHtml.DownloadFromHtml;
import java.io.IOException;
/**
 *
 * @author Игорь
 */
public class CS {

    public void downloadCurrencyFromCS() throws IOException{
        LocalDate date = LocalDate.now();
        String directoryFileName = "CS/CS"+date.toString()+".csv";
        String url = "https://www.kurzy.cz/kurzy-men/kurzovni-listek/ceska-sporitelna/";
        
        DownloadFromHtml html = new DownloadFromHtml();
        html.downloadCurrency(directoryFileName, url);
        
    }
    

}


