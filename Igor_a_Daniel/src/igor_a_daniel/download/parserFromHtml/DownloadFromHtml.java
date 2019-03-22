/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igor_a_daniel.download.parserFromHtml;

import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *method was created only for CS and KB banks 
 * @author Игорь
 */
public class DownloadFromHtml {

    public void downloadCurrency(String directory, String url) throws IOException {
        try {
            FileWriter writer = new FileWriter(directory);
            Document doc = Jsoup.connect(url).get();

            Element tableElement = doc.select("table.pdw").first();

            Elements tableHeaderEles = tableElement.select("thead tr th");
            System.out.println("headers");
            for (int i = 0; i < tableHeaderEles.size(); i++) {
                System.out.println(tableHeaderEles.get(i).text());
                writer.append(tableHeaderEles.get(i).text());

                if (i != tableHeaderEles.size() - 1) {
                    writer.append(';');
                }
            }
            writer.append('\n');
            System.out.println();

            Elements tableRowElements = tableElement.select(":not(thead) tr");

            for (int i = 0; i < tableRowElements.size(); i++) {
                Element row = tableRowElements.get(i);
                System.out.println("row");
                Elements rowItems = row.select("td");
                for (int j = 0; j < rowItems.size(); j++) {
                    System.out.print(rowItems.get(j).text());
                    writer.append(rowItems.get(j).text());

                    if (j != rowItems.size() - 1) {
                        writer.append(';');
                    }
                }
                writer.append('\n');
            }

            writer.close();
        }catch(IOException e){
            System.out.println(e);
        }
}
}


