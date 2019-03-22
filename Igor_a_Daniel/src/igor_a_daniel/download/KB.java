/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igor_a_daniel.download;

import igor_a_daniel.download.parserFromHtml.DownloadFromHtml;
import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @author Игорь
 */
public class KB {
    

    public void downloadCurrencyFromKB() throws IOException{
        LocalDate date = LocalDate.now();
        String directoryFileName = "KB/KB"+date.toString()+".csv";
        String url = "https://www.kurzy.cz/kurzy-men/kurzovni-listek/komercni-banka/";
        
        DownloadFromHtml html = new DownloadFromHtml();
        html.downloadCurrency(directoryFileName, url);
        
    }
    
}
