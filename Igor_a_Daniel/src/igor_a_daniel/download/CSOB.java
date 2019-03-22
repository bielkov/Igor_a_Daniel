/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igor_a_daniel.download;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;



/**
 *
 * @author dvele
 */
public class CSOB {
    private String url;
    private String fileTo;
    
    public CSOB() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String day = format.format(today);
        this.fileTo = day;
        this.url = "https://www.csob.cz/portal/lide/kurzovni-listek/-/date/" + day + "/kurzovni-listek.xml";
    }
    
    public void Download() {
        try {
            URL website = new URL(this.url);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("CSOB/" + this.fileTo + ".xml");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /* TODO
    public void ToCSV() throws Exception {
        File stylesheet = new File("CSOB/CSOB.xsl");
        File xmlSource = new File("CSOB/"+this.fileTo+".xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlSource);

        StreamSource stylesource = new StreamSource(stylesheet);
        Transformer transformer = TransformerFactory.newInstance()
                .newTransformer(stylesource);
        Source source = new DOMSource(document);
        Result outputTarget = new StreamResult(new File("CSOB/x.csv"));
        transformer.transform(source, outputTarget);
    
    }*/
    
    public static void main(String[] args) throws Exception  {
        CSOB c = new CSOB();
        c.Download();
        //c.ToCSV();
    }
}
