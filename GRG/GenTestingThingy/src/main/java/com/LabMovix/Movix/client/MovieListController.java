package com.LabMovix.Movix.client;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resources;
import java.awt.*;
import java.beans.EventHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MovieListController {

    public static String urlserver = "http://localhost:8080";
    public RestTemplate restTemplate = new RestTemplate();
    private int appcode = 0; //if appcode is 0 app is adm but if is 1 app is cliente
    private int offset;


    @FXML
    private TextArea smallDesc;

    @FXML
    private Button btnNext;
    @FXML
    private Button btnPrev;

    @FXML
    private ImageView movieCell0;
    @FXML
    private ImageView movieCell1;
    @FXML
    private ImageView movieCell2;
    @FXML
    private ImageView movieCell3;
    @FXML
    private ImageView movieCell4;
    @FXML
    private ImageView movieCell5;
    @FXML
    private ImageView movieCell6;
    @FXML
    private ImageView movieCell7;
    @FXML
    private ImageView movieCell8;
    @FXML
    private ImageView movieCell9;
    @FXML
    private ImageView movieCell10;
    @FXML
    private ImageView movieCell11;
    @FXML
    private ImageView movieSelectedPoster;

    public List<Movie> moviesCONST = listarPeliculas(null, 12);

    private List<Movie> peliculas;

    @FXML
    protected void initialize(){
        System.out.println("entra");
        this.offset = 12;
        cargarListadoPeliculas(this.offset);
    }
    public void cargarListadoPeliculas(int offset) {
        this.moviesCONST = listarPeliculas(null, 13);
        int index = 0;
        for (Movie mov : moviesCONST) {
            switch (index) {
                case 0:
                    movieCell0.setImage(null);
                    break;
                case 1:
                    movieCell1.setImage(null);
                    break;
                case 2:
                    movieCell2.setImage(null);
                    break;
                case 3:
                    movieCell3.setImage(null);
                    break;
                case 4:
                    movieCell4.setImage(null);
                    break;
                case 5:
                    movieCell5.setImage(null);
                    break;
                case 6:
                    movieCell6.setImage(null);
                    break;
                case 7:
                    movieCell7.setImage(null);
                    break;
                case 8:
                    movieCell8.setImage(null);
                    break;
                case 9:
                    movieCell9.setImage(null);
                    break;
                case 10:
                    movieCell10.setImage(null);
                    break;
                case 11:
                    movieCell11.setImage(null);
                    break;
            }
            index++;
        }
    }

    public void mostrarPeli(MouseEvent event) {
        moviesCONST = listarPeliculas(null, 13);
        System.out.println(moviesCONST.toString());
        smallDesc.setText("");
        System.out.println(" event " + event.getSource());
        ImageView imgSelected = (ImageView) event.getSource();
        System.out.println(this.moviesCONST.toString());
        smallDesc.setText(this.moviesCONST.get(Integer.parseInt(imgSelected.getId().split("movieCell")[1])).getDescription());
        this.movieSelectedPoster.setImage(imgSelected.getImage());
    }


    public List<Movie> listarPeliculas(MouseEvent evento, int offset) {
//       this.restTemplate;
        try {
//            Quote[] quote = restTemplate.getForObject(urlserver + "/list/movie?limit=20", Quote[].class);
//            System.out.println("Quote: " + quote.toString());
            String pantallaText = "";
//            for (Quote q : quote) {
//                pantallaText += q.toString();
//            }
            ResponseEntity<List<Movie>> rateResponse = restTemplate.exchange(urlserver + "/list/movie?limit=" + offset, HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>() {
            });
            List<Movie> movies = rateResponse.getBody();
//            for (Movie movie : movies) {
//                pantallaText += "Titulo : " + movie.getTitle() + "\n";
//                pantallaText += "Descripcion : " + movie.getDescription() + "\n";
//
//            }
//            pantallaPeliculas.setText(pantallaText);

            return movies;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    private  void pageNext(){
        listarPeliculas(null, this.offset + 12);
    }
    private void  pagePrev( ){
        if (this.offset - 12  <= 0  ) return;
        else listarPeliculas(null, this.offset - 12);
    }


}
