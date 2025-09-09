package edu.arapahoe;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BillboardHot100Scraper {
    public static void main(String[] args) {
        try {
            String url = "https://www.billboard.com/charts/hot-100/";

            Document doc = Jsoup.connect(url).get();

            Elements songs = doc.select("li.o-chart-results-list__item h3");

            int rank = 1;
            int indentNbr = 0;
            for (Element song : songs) {
                String title = song.text().trim();
                //if (rank > 10) break;
                if (!title.isEmpty()) {
                    for (int i=0; i<indentNbr; i++)
                        System.out.print("\t");
                    System.out.println(rank + ". " + title);
                    if (rank % 10 == 0)
                        indentNbr = indentNbr + 1;
                    rank = rank + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}