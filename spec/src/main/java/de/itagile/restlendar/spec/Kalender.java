package de.itagile.restlendar.spec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class Kalender {

    private String basisUrl;
    private String kalenderRessource = "kalender";

    public Kalender(String basisUrl) {
        this.basisUrl = basisUrl;
    }
    
    public List<String> holeTermine() throws Exception {
        return entferneLeere(einzeltermineAus(alleTermine()));
    }

    private String alleTermine() throws Exception {
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(String.format("%s/%s", basisUrl, kalenderRessource));
        String termine = "";
        try {
            httpClient.executeMethod(getMethod);
            termine = getMethod.getResponseBodyAsString();
        } finally {
            getMethod.releaseConnection();
        }
        return termine;
    }

    private List<String> entferneLeere(List<String> result) {
        result.remove("");
        return result;
    }

    private List<String> einzeltermineAus(String response) {
        return new ArrayList<String>(Arrays.asList(response.split("\\n")));
    }
}
