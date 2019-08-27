package edu.escuelaing.arem.ASE;

/**
 * Hello world!
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.Request;
import spark.Response;
import static spark.Spark.*;
     
    
     public class SparkWebApp {

        private static double media, desvEst; 
        private static Aplicacion app = new Aplicacion();
        
        public static void main(String[] args) {
            port(getPort());
            get("/inputdata", (req, res) -> inputDataPage(req, res));
            get("/results", (req, res) -> resultsPage(req, res));
        }
        
        static int getPort() {
            if (System.getenv() != null) {
                return Integer.parseInt(System.getenv("PORT"));
            }
            return 4567;
        }
        
        private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Media y derivada </h2>"
                + "<form action=\"/results\">"
                + "  * Ingrese los datos de la lista, separados por espacios : <br>"
                + "  <input type=\"text\" name='lista'>"
                + "  <br>"
                + "  <br><br>"
                + "<input type=\"submit\" value=\"Submit\">"
                + "<p> found \"\"\"/results\".</p>"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }
        
    
    private static String resultsPage(Request req, Response res) {
        float a;
        float b;
        String htm;
        String[] values=req.queryParams("lista").split(" ");
        for(String i: values){
            app.agregarElemento(Double.parseDouble(i));
        }
            try {
                htm = "<!DOCTYPE html>"
                        + "<html>"
                        + "<body>"
                        + "<br:>" + "Media :" + app.media()+ "<br:>"
                        + "<p>" + "Desviacion:" + app.desviacionEstandar()+ "<p>"
                        + "</body>"
                        + "</html>";
                return htm;
            } catch (LinkedListException ex) {
                Logger.getLogger(SparkWebApp.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }    
    }
    
}
