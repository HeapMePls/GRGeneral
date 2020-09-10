package com.LabMovix.Movix.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import javafx.event.ActionEvent;

import java.awt.image.BufferedImage;

import java.io.*;
import java.net.URI;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class Controller {

    public static String urlserver = "http://localhost:8080";
    public RestTemplate restTemplate = new RestTemplate();
    private int appcode = 0; //if appcode is 0 app is adm but if is 1 app is cliente
    Calendar c1 = Calendar.getInstance();
    GregorianCalendar c2 = new GregorianCalendar();
    Date fecha = new Date();
    LocalDate dia = LocalDate.now();
    private byte[] imgDataBytecode;
    @FXML
    private RadioButton lunesf;
    @FXML
    private RadioButton martesf;
    @FXML
    private RadioButton miercolesf;
    @FXML
    private RadioButton juevesf;
    @FXML
    private RadioButton viernesf;
    @FXML
    private RadioButton sabadof;
    @FXML
    private RadioButton domingof;
    @FXML
    private DatePicker hastafuncion;
    @FXML
    private DatePicker desdefuncion;
    @FXML
    private DatePicker dia1;
    @FXML
    private Button dia2;
    @FXML
    private Button dia3;
    @FXML
    private Button dia4;
    @FXML
    private Button dia5;
    @FXML
    private Button dia6;
    @FXML
    private Button dia7;
    @FXML
    private MenuButton selectLocal;
    @FXML
    private MenuButton room_type;
    @FXML
    private AnchorPane pan2;
    @FXML
    private AnchorPane pan6;
    @FXML
    private AnchorPane pan7;
    @FXML
    private AnchorPane pan51;
    @FXML
    private AnchorPane searchbutton;
    @FXML
    private AnchorPane pan1;
    @FXML
    private AnchorPane cine;
    @FXML
    private AnchorPane pan3;
    @FXML
    private ScrollPane pan4;
    //private AnchorPane pan4;
    @FXML
    private Button boton1;
    @FXML
    private AnchorPane pan5;
    @FXML
    private AnchorPane panbarra;
    @FXML
    private AnchorPane panbarracine;
    @FXML
    private AnchorPane panbarra1;
    @FXML
    private AnchorPane panbarra1cine;
    @FXML
    private AnchorPane panbarracf1;
    @FXML
    private AnchorPane panbarracf;
    @FXML
    private AnchorPane peliculaseleccionada;
    @FXML
    private AnchorPane confirmarcompra;
    @FXML
    private AnchorPane asientoselejidos;
    @FXML
    private Circle progressCircle2;
    @FXML
    private Circle progressCircle3;
    @FXML
    private AnchorPane infoview;
    @FXML
    private AnchorPane GrupoCine1;
    @FXML
    private AnchorPane MovieCenter1;
    @FXML
    private RadioButton dosdPelicula;
    @FXML
    private RadioButton tresdpelicula;
    @FXML
    private RadioButton cuatrodPelicula;

    @FXML
    private ListView list_view_horarios;
    @FXML
    private TextField searchbar;
    @FXML
    private TextArea infoPelicula;
    @FXML
    private TextArea descripcionPelicula;
    @FXML
    private Text nombrepeli;
    @FXML
    private Text diapeli;
    @FXML
    private Text ubicacionpeli;
    @FXML
    private Text cinepeli;
    @FXML
    private Text horapeli;
    @FXML
    private Text asietnospeli;

    @FXML
    private DatePicker estrenoPelicula;
    @FXML
    private ImageView imagen;
    @FXML
    private DatePicker limitePelicula;

    @FXML
    private TextField emprsala;
    @FXML
    private TextField ubicacionsala;
    @FXML
    private TextField capsala;
    @FXML
    private TextField tituloPelicula;
    @FXML
    private MenuButton generoPelicula;
    @FXML
    private TextField actoresPelicula;
    @FXML
    private TextField directorPelicula;
    @FXML
    private TextField edadminPelicula;
    @FXML
    private TextField duracionPelicula;
    @FXML
    private TextField peli1;
    @FXML
    private TextField peli3;
    @FXML
    private TextField peli2;
    @FXML
    private TextField descripcionview;

    @FXML
    private TextArea pantallaPeliculas;

    @FXML
    private ImageView menub;
    @FXML
    private ImageView peliculab;
    @FXML
    private ImageView salab;
    @FXML
    private ImageView peliculasCreadasb;
    @FXML
    private MenuButton selectCine;
    private List<Movie> peliculas;
    private Effect Lighting;
    private int peliculaSeleccionada;
    private String fechaSeleccionada;
    private String localString;
    private String selectedTime;
    private Movie selectedMovie;
    private ArrayList<Seat> asientosSeleccionados;
    private List<MovieFunction> movieFunctionsList;
    private MovieFunction selectedFunction;
    private User userLogged;
    private Room selectedRoom;
    private int qty;

    public void Iniciar(MouseEvent evento) {
        appcode = 0;
        pan1.setVisible(false);
        pan4.setVisible(true);
        pan2.setVisible(false);
        pan3.setVisible(false);
        pan5.setVisible(false);
        pan51.setVisible(false);
        pan6.setVisible(false);
        pan7.setVisible(false);
        pan8.setVisible(false);
        panbarra.setVisible(true);
        panbarra1.setVisible(false);
        menub.setVisible(true);
        peliculab.setVisible(true);
        salab.setVisible(true);

        infoview.setVisible(false);
        panbarracf.setVisible(false);
        panbarracf1.setVisible(false);
        panbarra1cine.setVisible(false);
        panbarracine.setVisible(false);
        // this.peliculas = listarPeliculas(null);
//        System.out.println(this.peliculas.get(0).getTitle());
//        peli1.setText(this.peliculas.get(0).getTitle());
//        peli2.setText(this.peliculas.get(1).getTitle());
//        peli3.setText(this.peliculas.get(2).getTitle());


    }

    @FXML
    private Spinner<Integer> cantidadAsientosSpinner;

    public void Iniciarcf(MouseEvent evento) {
        cantidadAsientosSpinner.setEditable(false);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        cantidadAsientosSpinner.setValueFactory(valueFactory);
        this.seatsToReserve = cantidadAsientosSpinner.getValue();
        this.seatCount = 0;

        appcode = 1;
        //System.out.println(appcode);
        pan1.setVisible(false);
        pan4.setVisible(true);
        pan8.setVisible(false);
        pan2.setVisible(false);
        pan3.setVisible(false);
        pan6.setVisible(false);
        pan6.setVisible(false);
        pan7.setVisible(false);
        pan51.setVisible(false);
        pan5.setVisible(false);
        panbarracf.setVisible(true);
        panbarra.setVisible(false);
        panbarracf1.setVisible(false);
        infoview.setVisible(false);
        panbarra1cine.setVisible(false);
        panbarracine.setVisible(false);
//        this.peliculas = listarPeliculas(null);
//        System.out.println(this.peliculas.get(0).getTitle());
//        peli1.setText(this.peliculas.get(0).getTitle());
//        peli2.setText(this.peliculas.get(1).getTitle());
//        peli3.setText(this.peliculas.get(2).getTitle());


    }

    public void Iniciarcine(MouseEvent evento) {
        appcode = 2;
        //System.out.println(appcode);
        pan1.setVisible(false);
        pan4.setVisible(true);
        pan2.setVisible(false);
        pan3.setVisible(false);
        pan5.setVisible(false);
        pan8.setVisible(false);
        pan51.setVisible(false);
        pan6.setVisible(false);
        pan7.setVisible(false);

        panbarracf.setVisible(false);
        panbarra.setVisible(false);
        panbarra1.setVisible(false);
        panbarra1cine.setVisible(false);
        panbarracine.setVisible(true);
        panbarracf1.setVisible(false);
        infoview.setVisible(false);
//        this.peliculas = listarPeliculas(null);
//        System.out.println(this.peliculas.get(0).getTitle());
//        peli1.setText(this.peliculas.get(0).getTitle());
//        peli2.setText(this.peliculas.get(1).getTitle());
//        peli3.setText(this.peliculas.get(2).getTitle());


    }

    public void mostrarPanel(MouseEvent event) {
        descripcionview.setText("");
        System.out.println(" event " + event.getSource());
        TextField ap = (TextField) event.getSource();
        String apId = ap.getId();
        System.out.println("ide " + apId);
        int inApId = Integer.parseInt(apId.split("peli")[1]);
        System.out.println("desc " + inApId);
        descripcionview.setText(this.peliculas.get(inApId - 1).getDescription());
        this.peliculaSeleccionada = this.peliculas.get(inApId - 1).getMovie_id();
    }

    public void crearPelicula(MouseEvent evento) {
        try {
            String urlCrear = urlserver + "/upload/movie";
            Movie movToCreate = Movie.builder().
                    title(tituloPelicula.getText()).
                    duration(duracionPelicula.getText()).
                    minAge(edadminPelicula.getText()).
                    actors(actoresPelicula.getText()).
                    director(directorPelicula.getText()).
                    description(descripcionPelicula.getText()).

                    icon(this.imgDataBytecode).
                    build();
            ObjectMapper om = new ObjectMapper();
            System.out.println(om.writeValueAsString(movToCreate));
            System.out.println("bytecode " + movToCreate.getIcon());
            System.out.println("mov class  " + movToCreate.toString());

            HttpEntity<Movie> request = new HttpEntity<>(movToCreate);

            URI location = restTemplate
                    .postForLocation(urlCrear, request);


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pelicula Creada");
            alert.setHeaderText("Pelicula Creada!");
            alert.setContentText("click en 'aceptar' para crar otra pelicula ");
            alert.showAndWait();
        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pelicula NO Creada");
            alert.setHeaderText("Pelicula NO Creada!");
            alert.setContentText("click en 'aceptar' para crar otra pelicula ");
            alert.showAndWait();
        }

    }

    public void crearSala(MouseEvent evento) {
        try {
            String urlCrear = urlserver + "upload/room";
            Room movToCreate = Room.builder().
                    capacity(Integer.parseInt(capsala.getText())).
                    empr_id(Integer.parseInt(selectCine.getText().split("-")[2])).
                    ubicacion(ubicacionsala.getText()).
                    type(String.valueOf(room_type.getItems().get(1).getText())).
                    build();

            HttpEntity<Room> request = new HttpEntity<>(movToCreate);
            URI location = restTemplate.postForLocation(urlCrear, request);


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sala Creada");
            alert.setHeaderText("Sala Creada!");
            alert.setContentText("click en 'aceptar' para crar otra Sala ");
            alert.showAndWait();
        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sala NO Creada");
            alert.setHeaderText("Sala NO Creada!");
            alert.setContentText("click en 'aceptar' para crar otra Sala ");
            alert.showAndWait();
        }
    }

    public void Pelicula(MouseEvent evento) {
        pan1.setVisible(false);
        pan4.setVisible(false);
        pan2.setVisible(true);
        pan8.setVisible(false);
        pan3.setVisible(false);
        pan6.setVisible(false);
        pan7.setVisible(false);
        pan5.setVisible(false);
        pan51.setVisible(false);

        panbarra.setVisible(true);
        panbarra1.setVisible(false);
        menub.setVisible(true);
        peliculab.setVisible(true);
        salab.setVisible(true);
        menub.setVisible(true);
    }

    public void Sala(MouseEvent evento) {
        pan1.setVisible(false);
        pan4.setVisible(false);
        pan8.setVisible(false);
        pan2.setVisible(false);
        pan3.setVisible(true);
        pan5.setVisible(false);
        pan51.setVisible(false);
        pan6.setVisible(false);
        pan7.setVisible(false);

        panbarra.setVisible(true);
        panbarra1.setVisible(false);
        menub.setVisible(true);
        peliculab.setVisible(true);
        salab.setVisible(true);

//        query cines
        if (this.selectCine.getItems() != null && this.selectCine.getItems().size() <= 1) {
            ResponseEntity<List<MovieEmpr>> rateResponse = restTemplate.exchange(urlserver + "/list/empr", HttpMethod.GET, null, new ParameterizedTypeReference<List<MovieEmpr>>() {
            });
            List<MovieEmpr> cinesDropdown = rateResponse.getBody();
            EventHandler<ActionEvent> action_empr = setCineDropdown();
            System.out.println("CINES --> " + cinesDropdown.get(0).getEmpr_name());

            for (MovieEmpr cin : cinesDropdown) {
                MenuItem cineMI = new MenuItem(cin.getEmpr_name() + "-" + cin.getEmpr_locals() + "-" + cin.getEmpr_id());
                cineMI.setOnAction(action_empr);
                this.selectCine.getItems().add(cineMI);
            }
        }
    }

    private EventHandler<ActionEvent> setCineDropdown() {
        Controller self = this;
        EventHandler<ActionEvent> p = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                MenuItem mItem = (MenuItem) event.getSource();
                String side = mItem.getText();
                selectCine.setText(side);
            }
        };
        return p;
    }

    private EventHandler<ActionEvent> setCineDropdownFuncion() {
        Controller self = this;
        EventHandler<ActionEvent> p = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                MenuItem mItem = (MenuItem) event.getSource();
                String side = mItem.getText();
                cinefuncion.setText(side);
                String urlToQuery = self.urlserver + "/list/roomsFromCinema";
                ResponseEntity<List<Room>> rateResponse = restTemplate.exchange(urlToQuery + "?empr_id=" + side.split("-")[2], HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {
                });
                List<Room> roomsEmpr = rateResponse.getBody();
                setSalasDropdown(roomsEmpr);
            }
        };
        return p;
    }

    public EventHandler<ActionEvent> selectedRoomAction() {
        Controller self = this;
        EventHandler<ActionEvent> p = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                MenuItem mItem = (MenuItem) event.getSource();
                String side = mItem.getText();
                salaFuncion.setText(side);
            }
        };
        return p;
    }

    @FXML
    public MenuButton salaFuncion;

    public void setSalasDropdown(List<Room> roomlist) {
        this.salaFuncion.getItems().clear();
        for (Room room : roomlist) {
            MenuItem roomMI = new MenuItem(room.getRoom_id() + "-" + room.getType() + "-(" + room.getCapacity() + ")");
            roomMI.setOnAction(selectedRoomAction());
            this.salaFuncion.getItems().add(roomMI);
        }
    }

    public void MenuAgrandado(MouseEvent evento) {
        if (appcode == 0) {
            panbarra.setVisible(true);
            panbarra1.setVisible(true);
            GrupoCine1.setVisible(true);
            MovieCenter1.setVisible(true);

        } else if (appcode == 1) {
            panbarracf.setVisible(true);
            panbarracf1.setVisible(true);

            TranslateTransition openNav = new TranslateTransition(new Duration(350), panbarracf1);
            openNav.setToX(0);
            TranslateTransition closeNav = new TranslateTransition(new Duration(350), panbarracf1);
            if(panbarracf1.getTranslateX()!=0){
                openNav.play();
            } else {
                closeNav.setToX(-(panbarracf1.getWidth()));
                closeNav.play();
            }

            if (this.userLogged.getEmpr_name() != null && this.userLogged.getEmpr_name().equals("MovieCenter")) {
                GrupoCine1.setVisible(true);
                MovieCenter1.setVisible(false);
            } else {
                GrupoCine1.setVisible(false);
                MovieCenter1.setVisible(true);
            }
        } else if (appcode == 2) {
            panbarracine.setVisible(true);
            panbarra1cine.setVisible(true);
            GrupoCine1.setVisible(false);
            MovieCenter1.setVisible(false);

            TranslateTransition openNav = new TranslateTransition(new Duration(350), panbarra1cine);
            openNav.setToX(0);
            TranslateTransition closeNav = new TranslateTransition(new Duration(350), panbarra1cine);
            if(panbarra1cine.getTranslateX()!=0){
                openNav.play();
            } else {
                closeNav.setToX(-(panbarra1cine.getWidth()));
                closeNav.play();
            }
        }

    }

    public void MenuAgrandadoOff(MouseEvent evento) {
        if (appcode == 0) {
            panbarra.setVisible(true);
            panbarra1.setVisible(false);

        } else if (appcode == 1) {
            panbarracf.setVisible(true);
            panbarracf1.setVisible(false);
        } else if (appcode == 2) {
            panbarracine.setVisible(true);
            panbarra1cine.setVisible(false);
        }

    }

    @FXML
    private WebView trailer;
    @FXML
    private WebView resenas;

    public void mostarInfo(MouseEvent evento) {


        infoview.setVisible(true);


        mostrarPeli(evento);
        trailer.setVisible(true);
        WebEngine engine = trailer.getEngine();
        engine.load(this.selectedMovie.getTrailer());

        mostrarPeli(evento);
        resenas.setVisible(true);
        WebEngine engine2 = resenas.getEngine();
        engine2.load("https://www.rottentomatoes.com/");

    }


    public String crearDia(int dia, int mes, int annio) {
        String resDay = null;

        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10) {
            if (dia >= 31) {
                int modDay = dia - 30;
                resDay = modDay + "-" + mes++ + "-" + annio;
            } else {
                resDay = dia++ + "-" + mes + "-" + annio;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia >= 30) {
                int modDay = dia - 29;
                resDay = modDay + "-" + mes++ + "-" + annio;
            } else {
                resDay = dia++ + "-" + mes + "-" + annio;
            }
        } else if (mes == 2) {
            if (!c2.isLeapYear(annio)) {
                if (dia >= 29) {
                    int modDay = dia - 28;
                    resDay = modDay + "-" + mes++ + "-" + annio;
                } else {
                    resDay = dia++ + "-" + mes + "-" + annio;
                }
            } else {
                if (dia >= 28) {
                    int modDay = dia - 28;
                    resDay = modDay + "-" + mes++ + "-" + annio;
                } else {
                    resDay = dia++ + "-" + mes + "-" + annio;
                }
            }
        } else if (mes == 12) {
            if (dia >= 31) {
                int modDay = dia - 30;
                resDay = modDay + "-" + 1 + "-" + annio++;
            } else {
                resDay = dia++ + "-" + mes + "-" + annio;
            }
        }
        return resDay;

    }

    public void Creadas(MouseEvent evento) {
        pan1.setVisible(false);
        pan4.setVisible(false);
        pan8.setVisible(false);
        pan2.setVisible(false);
        pan3.setVisible(false);
        pan6.setVisible(false);
        pan7.setVisible(false);
        //pan51.setVisible(false);
        this.cinefuncion.getItems().clear();
        System.out.print("USUARIO ADM DEL CINE "+ this.userLogged.getEmpr_name());
        if (this.cinefuncion.getItems() != null && this.cinefuncion.getItems().size() <= 1) {
            ResponseEntity<List<MovieEmpr>> rateResponse = restTemplate.exchange(urlserver + "list/empr/useradm?empr_name=" + this.userLogged.getEmpr_name(), HttpMethod.GET, null, new ParameterizedTypeReference<List<MovieEmpr>>() {
            });
            List<MovieEmpr> cinesDropdown = rateResponse.getBody();
            EventHandler<ActionEvent> action_empr = setCineDropdownFuncion();


            for (MovieEmpr cin : cinesDropdown) {
                MenuItem cineMI = new MenuItem(cin.getEmpr_name() + "-" + cin.getEmpr_locals() + "-" + cin.getEmpr_id());
                cineMI.setOnAction(action_empr);
                this.cinefuncion.getItems().add(cineMI);
            }
        }
//        Cargar listado de peliculas
        ObservableList<Movie> listado = FXCollections.observableArrayList(this.moviesCONST);
        listadoPeliculas.setCellFactory(param -> new ListCell<Movie>() {
            @Override
            protected void updateItem(Movie item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getTitle() == null) {
                    setText(null);
                } else {
                    setText(item.getTitle());
                }
            }
        });

        listadoPeliculas.setItems(listado);
        pan5.setVisible(true);
        panbarra.setVisible(true);
        panbarra1.setVisible(false);
        menub.setVisible(true);
        peliculab.setVisible(true);
        salab.setVisible(true);
    }

    public List<Movie> listarPeliculas(MouseEvent evento) {
//       this.restTemplate;
        try {
//            Quote[] quote = restTemplate.getForObject(urlserver + "/list/movie?limit=20", Quote[].class);
//            System.out.println("Quote: " + quote.toString());
            String pantallaText = "";
//            for (Quote q : quote) {
//                pantallaText += q.toString();
//            }
            ResponseEntity<List<Movie>> rateResponse = restTemplate.exchange(urlserver + "/list/movie?limit=1", HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>() {
            });
            List<Movie> movies = rateResponse.getBody();
            for (Movie movie : movies) {
                pantallaText += "Titulo : " + movie.getTitle() + "\n";
                pantallaText += "Descripcion : " + movie.getDescription() + "\n";

            }
            pantallaPeliculas.setText(pantallaText);

            return movies;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void out(MouseEvent evento) {
        pan1.setVisible(true);
        pan4.setVisible(false);
        pan8.setVisible(false);
        pan2.setVisible(false);
        pan3.setVisible(false);
        pan51.setVisible(false);
        pan5.setVisible(false);
        pan6.setVisible(false);
        pan7.setVisible(false);
        panbarra.setVisible(false);
        panbarra1.setVisible(false);
        panbarracf.setVisible(false);
        panbarracf1.setVisible(false);
        panbarra1cine.setVisible(false);
        panbarracine.setVisible(false);
        pan4.setVisible(false);
        pan1.setVisible(true);
    }

    public void selectionAll(MouseEvent evento) {
        List<String> choices = new ArrayList<>();
        choices.add("a");
        choices.add("b");
        choices.add("c");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("b", choices);
        dialog.setTitle("Choice Dialog");
        dialog.setHeaderText("Look, a Choice Dialog");
        dialog.setContentText("Choose your letter:");
        ArrayList<String> grup = new ArrayList<>(3);
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("Your choice: " + result.get() + result.get() + result.get());
        }
        result.ifPresent(letter -> System.out.println("Your choice: " + letter));
    }

    public void importFiles(MouseEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Importar imagen de la pelicula");
        Stage stage = new Stage();
        File file = fc.showOpenDialog(stage);
        try {
            Image img = new Image(file.toURI().toString());
            imagen.setImage(img);
        } catch (NullPointerException e) {
        }
        try {
            BufferedImage bImage = ImageIO.read(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos);
            byte[] data = bos.toByteArray();
            this.imgDataBytecode = data;
        } catch (Exception e) {
            System.out.println(e);

        }
        // System.out.println(file); imprime el path completo

    }


    public void filtroSer(MouseEvent evente) {
        String filtro = searchbar.getText();

    }

    public void vistaPeliculaSeleccionada(MouseEvent evento) throws IOException {
        TranslateTransition openNav = new TranslateTransition(new Duration(350), panbarracf);
        openNav.setToX(0);
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), panbarracf);
        //menub.setOnEvent((ActionEvent evt)->{
        if (panbarracf.getTranslateX() != 0) {
            openNav.play();
        } else {
            closeNav.setToX(-(panbarracf.getWidth()));
            closeNav.play();
        }
    }

    private int offset;


    @FXML
    private TextArea smallDesc;

    private int movid;

    @FXML
    private TextArea smallDesc1;

    @FXML
    private Button btnNext;
    @FXML
    private Button btnPrev;

    @FXML
    private ImageView movieCell0;
    @FXML
    private ImageView movieCell1;
    @FXML
    private Button boton5;
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
    @FXML
    private TextField searchbarr;
    @FXML
    private TableView tableRoom;
    @FXML
    private MenuButton roomType;

    public List<Movie> moviesCONST = listarPeliculas(null, this.offset);

    @FXML
    protected void initialize() throws IOException {
        System.out.println("Initiating...");
        this.offset = 0;
        cargarListadoPeliculas(this.offset, null);
        this.moviesCONST = listarPeliculas(null, this.offset);
        // action event
        EventHandler<ActionEvent> datepickerevent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // get the date picker value
                list_view_horarios.getItems().clear();

                Controller.this.selectLocal.getItems().clear();
                System.out.println("FECHA SELECCIONADA " + dia1.getValue());
                Controller.this.fechaSeleccionada = dia1.getValue().toString();
            }
        };
        dia1.setOnAction(datepickerevent);
    }

    private static Image convertToFxImage(BufferedImage image) {
        WritableImage wr = null;
        if (image != null) {
            wr = new WritableImage(image.getWidth(), image.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    pw.setArgb(x, y, image.getRGB(x, y));
                }
            }
        }

        return new ImageView(wr).getImage();
    }

    public void cargarListadoPeliculas(int offset, List<Movie> movs) throws IOException {
        if (movs == null) {
            this.moviesCONST = listarPeliculas(null, offset);
        } else {
            this.moviesCONST = movs;
        }
        try {

            movieCell0.setImage(null);
            movieCell1.setImage(null);
            movieCell2.setImage(null);
            movieCell3.setImage(null);
            movieCell4.setImage(null);
            movieCell5.setImage(null);
            movieCell6.setImage(null);
            movieCell7.setImage(null);
        } catch (Exception e) {
        }
        int index = 0;

        for (Movie mov : moviesCONST) {

            switch (index) {
                case 0:
                    movieCell0.setAccessibleText(String.valueOf(mov.getMovie_id()));
                    if (mov.getIcon() != null) {
                        BufferedImage img = ImageIO.read(new ByteArrayInputStream(mov.getIcon()));
                        if (img != null) {
                            Image image = convertToFxImage(img);
                            movieCell0.setImage(image);

                        }
                    }

                    break;
                case 1:
                    if (mov.getIcon() != null) {
                        BufferedImage img = ImageIO.read(new ByteArrayInputStream(mov.getIcon()));
                        if (img != null) {
                            Image image = convertToFxImage(img);
                            movieCell1.setImage(image);
                        }
                    }
                    movieCell1.setAccessibleText(String.valueOf(mov.getMovie_id()));
                    break;
                case 2:
                    if (mov.getIcon() != null) {
                        BufferedImage img = ImageIO.read(new ByteArrayInputStream(mov.getIcon()));
                        if (img != null) {
                            Image image = convertToFxImage(img);
                            movieCell2.setImage(image);
                        }
                    }
                    movieCell2.setAccessibleText(String.valueOf(mov.getMovie_id()));
                    break;
                case 3:

                    if (mov.getIcon() != null) {
                        BufferedImage img = ImageIO.read(new ByteArrayInputStream(mov.getIcon()));
                        if (img != null) {
                            Image image = convertToFxImage(img);
                            movieCell3.setImage(image);

                        }
                    }
                    movieCell3.setAccessibleText(String.valueOf(mov.getMovie_id()));
                    break;
                case 4:
                    if (mov.getIcon() != null) {
                        BufferedImage img = ImageIO.read(new ByteArrayInputStream(mov.getIcon()));
                        if (img != null) {
                            Image image = convertToFxImage(img);
                            movieCell4.setImage(image);
                        }
                    }
                    movieCell4.setAccessibleText(String.valueOf(mov.getMovie_id()));
                    break;
                case 5:
                    if (mov.getIcon() != null) {
                        BufferedImage img = ImageIO.read(new ByteArrayInputStream(mov.getIcon()));
                        if (img != null) {
                            Image image = convertToFxImage(img);
                            movieCell5.setImage(image);
                        }
                    }
                    movieCell5.setAccessibleText(String.valueOf(mov.getMovie_id()));
                    break;
                case 6:
                    if (mov.getIcon() != null) {
                        BufferedImage img = ImageIO.read(new ByteArrayInputStream(mov.getIcon()));
                        if (img != null) {
                            Image image = convertToFxImage(img);
                            movieCell6.setImage(image);
                        }
                    }
                    movieCell6.setAccessibleText(String.valueOf(mov.getMovie_id()));
                    break;
                case 7:
                    if (mov.getIcon() != null) {
                        BufferedImage img = ImageIO.read(new ByteArrayInputStream(mov.getIcon()));
                        if (img != null) {
                            Image image = convertToFxImage(img);
                            movieCell7.setImage(image);
                        }
                    }
                    movieCell7.setAccessibleText(String.valueOf(mov.getMovie_id()));
                    break;

            }
            index++;
        }
    }

    private void setGlobalMovieId(int movie_id) {
        this.movid = movie_id;
    }

    public void mostrarPeli(MouseEvent event) {
        try {
            if (this.moviesCONST == null || this.moviesCONST.size() == 0) {
                this.moviesCONST = listarPeliculas(null, 1);
            }
            smallDesc.setText("");
            ImageView imgSelected = (ImageView) event.getSource();
            try {
                this.movieSelectedPoster.setImage(imgSelected.getImage());
            } catch (Exception e) {
            }

            this.movid = Integer.parseInt(imgSelected.getAccessibleText());

            Movie selectedMovie = getMovieFromListByID(movid);
            this.selectedMovie = selectedMovie;
            smallDesc.setText(selectedMovie.getDescription());
            movid = selectedMovie.getMovie_id();
            this.peliculaSeleccionada = movid;
            ResponseEntity<List<MovieFunction>> rateResponse = restTemplate.exchange(urlserver + "/list/movieTimes?movie_id=" + movid, HttpMethod.GET, null, new ParameterizedTypeReference<List<MovieFunction>>() {
            });
            List<MovieFunction> moviesFunc = rateResponse.getBody();
            String longStr = "";
            for (MovieFunction mf : moviesFunc) {
                longStr = "\n";
                String time = mf.getSchedule_time();
                String emprId = String.valueOf(mf.getEmpr_id());
                String cieema = "";
                ResponseEntity<MovieEmpr> cinemaA = restTemplate.exchange(urlserver + "/list/cinemas?empr_id=" + emprId, HttpMethod.GET, null, new ParameterizedTypeReference<MovieEmpr>() {
                });
                MovieEmpr cine = (MovieEmpr) cinemaA.getBody();

                String stringMsg = " At " + time + " in " + cine.getEmpr_name() + " ubicated in " + cine.getEmpr_locals();
                longStr += stringMsg;
            }
            smallDesc1.setText(longStr);
//    SetText del field con longstr

        } catch (Exception e) {
            System.out.println("ERRROR " + e);

        }
    }

    private Movie getMovieFromListByID(int movid) {
        Movie ret = null;
        for (Movie m : this.moviesCONST) {
            if (m.getMovie_id() == movid) {
                ret = m;
                break;
            }
        }
        return ret;
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
            return movies;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    private void pageNext() {
        listarPeliculas(null, this.offset + 1);
    }

    private void pagePrev() {
        if (this.offset - 1 < 0) return;
        else {
            listarPeliculas(null, this.offset - 1);
            this.offset = this.offset - 1;
        }
    }

    public void filtros(MouseEvent mouse) throws IOException {
        System.out.println("SEARCH BUTTON PRESSED");
        String condicion = searchbar.getText();
        String urlserverSer = urlserver + "/list/movie/search?limit=22&name=" + condicion;
        ResponseEntity<List<Movie>> rateResponse = restTemplate.exchange(urlserverSer, HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>() {
        });
        List<Movie> movies = rateResponse.getBody();
        this.moviesCONST = movies;
        try {
            this.cargarListadoPeliculas(1, movies);
        } catch (IOException e) {

            e.printStackTrace();
            throw e;
        }
    }

   /* public String getFecha(MouseEvent event) {
        list_view_horarios.getItems().clear();

        this.selectLocal.getItems().clear();
        System.out.println("FECHA SELECCIONADA " + dia1.getValue());
        this.fechaSeleccionada = dia1.getValue().toString();


        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        return this.fechaSeleccionada;
    }*/

    private String cineselec;
    private String horario;
    private String nombre;
    private String ubicacionselecx;
    private String asientoselec;

    public String getCine(MouseEvent event) {
        System.out.println(event);
        cine = (AnchorPane) event.getSource();
        System.out.println(cine.getId());
        cargarLocales(cine.getId());
        cineselec = cine.getId();
        return cine.getId();
    }

    public String getPeliId(MouseEvent event) {
        System.out.println(event);
        cine = (AnchorPane) event.getSource();
        System.out.println(cine.getId());
        return cine.getId();
    }


    public void changeSelectionReg() {
        roomType.setText("Regular");
    }


    public void comprarButton(MouseEvent mouseEvent) {
        String local = selectLocal.getText();

    }

    public void elejirasiento(MouseEvent evento) {
        this.seatsToReserve = cantidadAsientosSpinner.getValue();
        this.qty = this.seatsToReserve;
        this.seatCount = 0;
        for (Seat e : this.roomShape) {
            e.setState(0);
            e.getImage().setImage(new Image("images/seatAvailable.png"));
        }
        this.selectedTime = (String) list_view_horarios.getSelectionModel().getSelectedItem();
        try {
            this.selectedTime = this.selectedTime.split("-")[1];
        } catch (Exception e) {
        }

        try {
            ResponseEntity<List<Reserva>> rateResponse = restTemplate.exchange(urlserver + "/list/resercas/funcion?function_id=" + this.selectedFunction.getFunction_id(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Reserva>>() {
            });
            List<Reserva> reservas = rateResponse.getBody();
            String ar = "";
            for (Reserva r : reservas) {
                ar += "," + r.getAsientos();
            }
            List<String> strList = Arrays.asList(ar.split(","));
            occupiedSeatFill(strList);
            System.out.println("ASIENTOS RESERVADOS " + ar);

        } catch (Exception e) {
            throw e;
        }

        pan4.setVisible(false);
        pan1.setVisible(false);
        pan8.setVisible(false);
        pan2.setVisible(false);
        Color gold = Color.web("#d19e28");
        Color blanco = Color.web("#ffffff");
        progressCircle2.setStroke(blanco);
        progressCircle3.setStroke(gold);
        pan3.setVisible(false);
        pan4.setVisible(false);
        pan51.setVisible(true);

        asientoselejidos.setVisible(true);
        boton5.setVisible(true);
        confirmarcompra.setVisible(false);
        backer = 0;

    }

    int backer = 0;

    public void confirmarCompra(MouseEvent evento) throws MessagingException {
        if (this.userLogged == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Algo ha fallado");
            alert.setHeaderText("Debes estar registrado para poder efectuar una compra");
            alert.setContentText("click en 'aceptar' para volver al menu principal");
            alert.showAndWait();
            iniciarMenuCorrespondiente();

        } else {
            Reserva res = Reserva.builder().asientos(this.asientoselec).function_id(this.selectedFunction.getFunction_id()).uid(this.userLogged.getUid()).build();

            HttpEntity<Reserva> request = new HttpEntity<>(res);
            ResponseEntity<String> location = restTemplate
                    .exchange(urlserver + "/upload/reserva", HttpMethod.POST, request, String.class);
            String status = location.getBody();

            System.out.println("RESERVA " + status);

//            if (crearCorreo(enviarCorreo())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Entrada comprada!");
            alert.setHeaderText("Gracias por su compra!");
            alert.setContentText("click en 'aceptar' para ir al menu");
            alert.showAndWait();
            iniciarMenuCorrespondiente();
//            } else {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Algo ha fallado");
//                alert.setHeaderText("Por favor vuelva a intentarlo");
//                alert.setContentText("click en 'aceptar' para intentar de nuevo");
//                alert.showAndWait();
//            }
        }
    }

    private void iniciarMenuCorrespondiente() {
        cantidadAsientosSpinner.setEditable(false);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        cantidadAsientosSpinner.setValueFactory(valueFactory);
        this.seatsToReserve = cantidadAsientosSpinner.getValue();
        this.qty = this.seatsToReserve;
        this.seatCount = 0;
        if (this.userLogged == null) {
            out(null);
        } else {
            if (this.userLogged.getUtype().equals("c")) {
                Iniciarcf(null);
            } else if (this.userLogged.getUtype().equals("a")) {
                Iniciarcine(null);
            } else if (this.userLogged.getUtype().equals("i")) {
                Iniciar(null);
            } else {
                Iniciarcf(null);
            }
        }
    }

    public void confirmarcompra(MouseEvent evento) {
        confirmarcompra.setVisible(true);
        asientoselejidos.setVisible(false);
        pan4.setVisible(false);
        pan1.setVisible(false);
        pan8.setVisible(false);
        pan3.setVisible(false);
        pan4.setVisible(false);
        pan2.setVisible(false);
        Color gold = Color.web("#d19e28");
        Color blanco = Color.web("#ffffff");
        progressCircle2.setStroke(gold);
        progressCircle3.setStroke(blanco);
        confirmarcompra.setVisible(true);
        boton5.setVisible(false);

        this.asientosSeleccionados = buscarAsientosSeleccionados();
        popConfirm();


        asientoselec = "";
        for (Seat s : this.asientosSeleccionados) {
            if (asientoselec.length() > 1) {
                asientoselec += "," + s.getPos();
            } else {
                asientoselec = s.getPos();
            }
        }

        backer = 1;

    }

    private ArrayList<Seat> buscarAsientosSeleccionados() {
        ArrayList<Seat> ret = new ArrayList<>();
        for (int i = 0; i < this.roomShape.size(); i++) {
            if (this.roomShape.get(i).getState() == 1) {
//                El asiento fue marcado para reservar
                ret.add(roomShape.get(i));
            }
        }
        return ret;
    }

    private List<Reserva> getReservasDelCine() {
        if (!this.userLogged.getUtype().equals("i")) {
            ResponseEntity<List<Reserva>> rateResponse = restTemplate.exchange(urlserver + "/list/reservas/empr?empr_name=" + this.userLogged.getEmpr_name(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Reserva>>() {
            });
            return rateResponse.getBody();
        } else {
            ResponseEntity<List<Reserva>> rateResponse = restTemplate.exchange(urlserver + "/list/reservas?limit=22", HttpMethod.GET, null, new ParameterizedTypeReference<List<Reserva>>() {
            });
            List<Reserva> reservas = rateResponse.getBody();
            return rateResponse.getBody();
        }
    }

    private List<Reserva> getReservasDelUsuario() {
        if (this.userLogged != null) {
            ResponseEntity<List<Reserva>> rateResponse = restTemplate.exchange(urlserver + "/list/reservas/usuario?uid=" + this.userLogged.getEmail(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Reserva>>() {
            });
            return rateResponse.getBody();
        } else {
            return null;
        }
    }

    public void compraback(MouseEvent evento) {

        if (backer == 1) {
            elejirasiento(evento);
        } else if (backer == 0) {
            iniciarMenuCorrespondiente();
        }
    }

    @FXML
    private ImageView seatA1;
    @FXML
    private ImageView seatA2;
    @FXML
    private ImageView seatA3;
    @FXML
    private ImageView seatA4;
    @FXML
    private ImageView seatA5;
    @FXML
    private ImageView seatA6;
    @FXML
    private ImageView seatA7;
    @FXML
    private ImageView seatA8;
    @FXML
    private ImageView seatA9;
    @FXML
    private ImageView seatA10;
    @FXML
    private ImageView seatA11;
    @FXML
    private ImageView seatA12;
    @FXML
    private ImageView seatA13;
    @FXML
    private ImageView seatA14;
    @FXML
    private ImageView seatA15;
    @FXML
    private ImageView seatA16;
    @FXML
    private ImageView seatB1;
    @FXML
    private ImageView seatB2;
    @FXML
    private ImageView seatB3;
    @FXML
    private ImageView seatB4;
    @FXML
    private ImageView seatB5;
    @FXML
    private ImageView seatB6;
    @FXML
    private ImageView seatB7;
    @FXML
    private ImageView seatB8;
    @FXML
    private ImageView seatB9;
    @FXML
    private ImageView seatB10;
    @FXML
    private ImageView seatB11;
    @FXML
    private ImageView seatB12;
    @FXML
    private ImageView seatB13;
    @FXML
    private ImageView seatB14;
    @FXML
    private ImageView seatB15;
    @FXML
    private ImageView seatB16;
    @FXML
    private ImageView seatC1;
    @FXML
    private ImageView seatC2;
    @FXML
    private ImageView seatC3;
    @FXML
    private ImageView seatC4;
    @FXML
    private ImageView seatC5;
    @FXML
    private ImageView seatC6;
    @FXML
    private ImageView seatC7;
    @FXML
    private ImageView seatC8;
    @FXML
    private ImageView seatC9;
    @FXML
    private ImageView seatC10;
    @FXML
    private ImageView seatC11;
    @FXML
    private ImageView seatC12;
    @FXML
    private ImageView seatC13;
    @FXML
    private ImageView seatC14;
    @FXML
    private ImageView seatC15;
    @FXML
    private ImageView seatC16;
    @FXML
    private ImageView seatD1;
    @FXML
    private ImageView seatD2;
    @FXML
    private ImageView seatD3;
    @FXML
    private ImageView seatD4;
    @FXML
    private ImageView seatD5;
    @FXML
    private ImageView seatD6;
    @FXML
    private ImageView seatD7;
    @FXML
    private ImageView seatD8;
    @FXML
    private ImageView seatD9;
    @FXML
    private ImageView seatD10;
    @FXML
    private ImageView seatD11;
    @FXML
    private ImageView seatD12;
    @FXML
    private ImageView seatD13;
    @FXML
    private ImageView seatD14;
    @FXML
    private ImageView seatD15;
    @FXML
    private ImageView seatD16;
    @FXML
    private ImageView seatE1;
    @FXML
    private ImageView seatE2;
    @FXML
    private ImageView seatE3;
    @FXML
    private ImageView seatE4;
    @FXML
    private ImageView seatE5;
    @FXML
    private ImageView seatE6;
    @FXML
    private ImageView seatE7;
    @FXML
    private ImageView seatE8;
    @FXML
    private ImageView seatE9;
    @FXML
    private ImageView seatE10;
    @FXML
    private ImageView seatE11;
    @FXML
    private ImageView seatE12;
    @FXML
    private ImageView seatE13;
    @FXML
    private ImageView seatE14;
    @FXML
    private ImageView seatE15;
    @FXML
    private ImageView seatE16;
    @FXML
    private ImageView seatF1;
    @FXML
    private ImageView seatF2;
    @FXML
    private ImageView seatF3;
    @FXML
    private ImageView seatF4;
    @FXML
    private ImageView seatF5;
    @FXML
    private ImageView seatF6;
    @FXML
    private ImageView seatF7;
    @FXML
    private ImageView seatF8;
    @FXML
    private ImageView seatF9;
    @FXML
    private ImageView seatF10;
    @FXML
    private ImageView seatF11;
    @FXML
    private ImageView seatF12;
    @FXML
    private ImageView seatF13;
    @FXML
    private ImageView seatF14;
    @FXML
    private ImageView seatF15;
    @FXML
    private ImageView seatF16;
    @FXML
    private ImageView seatG1;
    @FXML
    private ImageView seatG2;
    @FXML
    private ImageView seatG3;
    @FXML
    private ImageView seatG4;
    @FXML
    private ImageView seatG5;
    @FXML
    private ImageView seatG6;
    @FXML
    private ImageView seatG7;
    @FXML
    private ImageView seatG8;
    @FXML
    private ImageView seatG9;
    @FXML
    private ImageView seatG10;
    @FXML
    private ImageView seatG11;
    @FXML
    private ImageView seatG12;
    @FXML
    private ImageView seatG13;
    @FXML
    private ImageView seatG14;
    @FXML
    private ImageView seatG15;
    @FXML
    private ImageView seatG16;
    @FXML
    private ImageView seatH1;
    @FXML
    private ImageView seatH2;
    @FXML
    private ImageView seatH3;
    @FXML
    private ImageView seatH4;
    @FXML
    private ImageView seatH5;
    @FXML
    private ImageView seatH6;
    @FXML
    private ImageView seatH7;
    @FXML
    private ImageView seatH8;
    @FXML
    private ImageView seatH9;
    @FXML
    private ImageView seatH10;
    @FXML
    private ImageView seatH11;
    @FXML
    private ImageView seatH12;
    @FXML
    private ImageView seatH13;
    @FXML
    private ImageView seatH14;
    @FXML
    private ImageView seatH15;
    @FXML
    private ImageView seatH16;
    @FXML
    private ImageView seatI1;
    @FXML
    private ImageView seatI2;
    @FXML
    private ImageView seatI3;
    @FXML
    private ImageView seatI4;
    @FXML
    private ImageView seatI5;
    @FXML
    private ImageView seatI6;
    @FXML
    private ImageView seatI7;
    @FXML
    private ImageView seatI8;
    @FXML
    private ImageView seatI9;
    @FXML
    private ImageView seatI10;
    @FXML
    private ImageView seatI11;
    @FXML
    private ImageView seatI12;
    @FXML
    private ImageView seatI13;
    @FXML
    private ImageView seatI14;
    @FXML
    private ImageView seatI15;
    @FXML
    private ImageView seatI16;
    @FXML
    private ImageView seatJ1;
    @FXML
    private ImageView seatJ2;
    @FXML
    private ImageView seatJ3;
    @FXML
    private ImageView seatJ4;
    @FXML
    private ImageView seatJ5;
    @FXML
    private ImageView seatJ6;
    @FXML
    private ImageView seatJ7;
    @FXML
    private ImageView seatJ8;
    @FXML
    private ImageView seatJ9;
    @FXML
    private ImageView seatJ10;
    @FXML
    private ImageView seatJ11;
    @FXML
    private ImageView seatJ12;
    @FXML
    private ImageView seatJ13;
    @FXML
    private ImageView seatJ14;
    @FXML
    private ImageView seatJ15;
    @FXML
    private ImageView seatJ16;
    @FXML
    private ImageView seatK1;
    @FXML
    private ImageView seatK2;
    @FXML
    private ImageView seatK3;
    @FXML
    private ImageView seatK4;
    @FXML
    private ImageView seatK5;
    @FXML
    private ImageView seatK6;
    @FXML
    private ImageView seatK7;
    @FXML
    private ImageView seatK8;
    @FXML
    private ImageView seatK9;
    @FXML
    private ImageView seatK10;
    @FXML
    private ImageView seatK11;
    @FXML
    private ImageView seatK12;
    @FXML
    private ImageView seatK13;
    @FXML
    private ImageView seatK14;
    @FXML
    private ImageView seatK15;
    @FXML
    private ImageView seatK16;
    @FXML
    private ImageView seatL1;
    @FXML
    private ImageView seatL2;
    @FXML
    private ImageView seatL3;
    @FXML
    private ImageView seatL4;
    @FXML
    private ImageView seatL5;
    @FXML
    private ImageView seatL6;
    @FXML
    private ImageView seatL7;
    @FXML
    private ImageView seatL8;
    @FXML
    private ImageView seatL9;
    @FXML
    private ImageView seatL10;
    @FXML
    private ImageView seatL11;
    @FXML
    private ImageView seatL12;
    @FXML
    private ImageView seatL13;
    @FXML
    private ImageView seatL14;
    @FXML
    private ImageView seatL15;
    @FXML
    private ImageView seatL16;
    @FXML
    private ImageView seatM1;
    @FXML
    private ImageView seatM2;
    @FXML
    private ImageView seatM3;
    @FXML
    private ImageView seatM4;
    @FXML
    private ImageView seatM5;
    @FXML
    private ImageView seatM6;
    @FXML
    private ImageView seatM7;
    @FXML
    private ImageView seatM8;
    @FXML
    private ImageView seatM9;
    @FXML
    private ImageView seatM10;
    @FXML
    private ImageView seatM11;
    @FXML
    private ImageView seatM12;
    @FXML
    private ImageView seatM13;
    @FXML
    private ImageView seatM14;
    @FXML
    private ImageView seatM15;
    @FXML
    private ImageView seatM16;
    @FXML
    private ImageView seatN1;
    @FXML
    private ImageView seatN2;
    @FXML
    private ImageView seatN3;
    @FXML
    private ImageView seatN4;
    @FXML
    private ImageView seatN5;
    @FXML
    private ImageView seatN6;
    @FXML
    private ImageView seatN7;
    @FXML
    private ImageView seatN8;
    @FXML
    private ImageView seatN9;
    @FXML
    private ImageView seatN10;
    @FXML
    private ImageView seatN11;
    @FXML
    private ImageView seatN12;
    @FXML
    private ImageView seatN13;
    @FXML
    private ImageView seatN14;
    @FXML
    private ImageView seatN15;
    @FXML
    private ImageView seatN16;


    public ArrayList<Seat> roomShape = new ArrayList();

    public void createRoomShape() {
        Seat oSeatA1 = Seat.builder().image(seatA1).state(0).pos("A1").build();
        Seat oSeatA2 = Seat.builder().image(seatA2).state(0).pos("A2").build();
        Seat oSeatA3 = Seat.builder().image(this.seatA3).state(0).pos("A3").build();
        Seat oSeatA4 = Seat.builder().image(this.seatA4).state(0).pos("A4").build();
        Seat oSeatA5 = Seat.builder().image(this.seatA5).state(0).pos("A5").build();
        Seat oSeatA6 = Seat.builder().image(this.seatA6).state(0).pos("A6").build();
        Seat oSeatA7 = Seat.builder().image(this.seatA7).state(0).pos("A7").build();
        Seat oSeatA8 = Seat.builder().image(this.seatA8).state(0).pos("A8").build();
        Seat oSeatA9 = Seat.builder().image(this.seatA9).state(0).pos("A9").build();
        Seat oSeatA10 = Seat.builder().image(this.seatA10).state(0).pos("A10").build();
        Seat oSeatA11 = Seat.builder().image(this.seatA11).state(0).pos("A11").build();
        Seat oSeatA12 = Seat.builder().image(this.seatA12).state(0).pos("A12").build();
        Seat oSeatA13 = Seat.builder().image(this.seatA13).state(0).pos("A13").build();
        Seat oSeatA14 = Seat.builder().image(this.seatA14).state(0).pos("A14").build();
        Seat oSeatA15 = Seat.builder().image(this.seatA15).state(0).pos("A15").build();
        Seat oSeatA16 = Seat.builder().image(this.seatA16).state(0).pos("A16").build();
        Seat oSeatB1 = Seat.builder().image(this.seatB1).state(0).pos("B1").build();
        Seat oSeatB2 = Seat.builder().image(this.seatB2).state(0).pos("B2").build();
        Seat oSeatB3 = Seat.builder().image(this.seatB3).state(0).pos("B3").build();
        Seat oSeatB4 = Seat.builder().image(this.seatB4).state(0).pos("B4").build();
        Seat oSeatB5 = Seat.builder().image(this.seatB5).state(0).pos("B5").build();
        Seat oSeatB6 = Seat.builder().image(this.seatB6).state(0).pos("B6").build();
        Seat oSeatB7 = Seat.builder().image(this.seatB7).state(0).pos("B7").build();
        Seat oSeatB8 = Seat.builder().image(this.seatB8).state(0).pos("B8").build();
        Seat oSeatB9 = Seat.builder().image(this.seatB9).state(0).pos("B9").build();
        Seat oSeatB10 = Seat.builder().image(this.seatB10).state(0).pos("B10").build();
        Seat oSeatB11 = Seat.builder().image(this.seatB11).state(0).pos("B11").build();
        Seat oSeatB12 = Seat.builder().image(this.seatB12).state(0).pos("B12").build();
        Seat oSeatB13 = Seat.builder().image(this.seatB13).state(0).pos("B13").build();
        Seat oSeatB14 = Seat.builder().image(this.seatB14).state(0).pos("B14").build();
        Seat oSeatB15 = Seat.builder().image(this.seatB15).state(0).pos("B15").build();
        Seat oSeatB16 = Seat.builder().image(this.seatB16).state(0).pos("B16").build();
        Seat oSeatC1 = Seat.builder().image(this.seatC1).state(0).pos("C1").build();
        Seat oSeatC2 = Seat.builder().image(this.seatC2).state(0).pos("C2").build();
        Seat oSeatC3 = Seat.builder().image(this.seatC3).state(0).pos("C3").build();
        Seat oSeatC4 = Seat.builder().image(this.seatC4).state(0).pos("C4").build();
        Seat oSeatC5 = Seat.builder().image(this.seatC5).state(0).pos("C5").build();
        Seat oSeatC6 = Seat.builder().image(this.seatC6).state(0).pos("C6").build();
        Seat oSeatC7 = Seat.builder().image(this.seatC7).state(0).pos("C7").build();
        Seat oSeatC8 = Seat.builder().image(this.seatC8).state(0).pos("C8").build();
        Seat oSeatC9 = Seat.builder().image(this.seatC9).state(0).pos("C9").build();
        Seat oSeatC10 = Seat.builder().image(this.seatC1).state(0).pos("C10").build();
        Seat oSeatC11 = Seat.builder().image(this.seatC1).state(0).pos("C11").build();
        Seat oSeatC12 = Seat.builder().image(this.seatC1).state(0).pos("C12").build();
        Seat oSeatC13 = Seat.builder().image(this.seatC1).state(0).pos("C13").build();
        Seat oSeatC14 = Seat.builder().image(this.seatC1).state(0).pos("C14").build();
        Seat oSeatC15 = Seat.builder().image(this.seatC1).state(0).pos("C15").build();
        Seat oSeatC16 = Seat.builder().image(this.seatC1).state(0).pos("C16").build();
        Seat oSeatD1 = Seat.builder().image(this.seatD1).state(0).pos("D1").build();
        Seat oSeatD2 = Seat.builder().image(this.seatD2).state(0).pos("D2").build();
        Seat oSeatD3 = Seat.builder().image(this.seatD3).state(0).pos("D3").build();
        Seat oSeatD4 = Seat.builder().image(this.seatD4).state(0).pos("D4").build();
        Seat oSeatD5 = Seat.builder().image(this.seatD5).state(0).pos("D5").build();
        Seat oSeatD6 = Seat.builder().image(this.seatD6).state(0).pos("D6").build();
        Seat oSeatD7 = Seat.builder().image(this.seatD7).state(0).pos("D7").build();
        Seat oSeatD8 = Seat.builder().image(this.seatD8).state(0).pos("D8").build();
        Seat oSeatD9 = Seat.builder().image(this.seatD9).state(0).pos("D9").build();
        Seat oSeatD10 = Seat.builder().image(this.seatD1).state(0).pos("D10").build();
        Seat oSeatD11 = Seat.builder().image(this.seatD1).state(0).pos("D11").build();
        Seat oSeatD12 = Seat.builder().image(this.seatD1).state(0).pos("D12").build();
        Seat oSeatD13 = Seat.builder().image(this.seatD1).state(0).pos("D13").build();
        Seat oSeatD14 = Seat.builder().image(this.seatD1).state(0).pos("D14").build();
        Seat oSeatD15 = Seat.builder().image(this.seatD1).state(0).pos("D15").build();
        Seat oSeatD16 = Seat.builder().image(this.seatD1).state(0).pos("D16").build();
        Seat oSeatE1 = Seat.builder().image(this.seatE1).state(0).pos("E1").build();
        Seat oSeatE2 = Seat.builder().image(this.seatE2).state(0).pos("E2").build();
        Seat oSeatE3 = Seat.builder().image(this.seatE3).state(0).pos("E3").build();
        Seat oSeatE4 = Seat.builder().image(this.seatE4).state(0).pos("E4").build();
        Seat oSeatE5 = Seat.builder().image(this.seatE5).state(0).pos("E5").build();
        Seat oSeatE6 = Seat.builder().image(this.seatE6).state(0).pos("E6").build();
        Seat oSeatE7 = Seat.builder().image(this.seatE7).state(0).pos("E7").build();
        Seat oSeatE8 = Seat.builder().image(this.seatE8).state(0).pos("E8").build();
        Seat oSeatE9 = Seat.builder().image(this.seatE9).state(0).pos("E9").build();
        Seat oSeatE10 = Seat.builder().image(this.seatE1).state(0).pos("E10").build();
        Seat oSeatE11 = Seat.builder().image(this.seatE1).state(0).pos("E11").build();
        Seat oSeatE12 = Seat.builder().image(this.seatE1).state(0).pos("E12").build();
        Seat oSeatE13 = Seat.builder().image(this.seatE1).state(0).pos("E13").build();
        Seat oSeatE14 = Seat.builder().image(this.seatE1).state(0).pos("E14").build();
        Seat oSeatE15 = Seat.builder().image(this.seatE1).state(0).pos("E15").build();
        Seat oSeatE16 = Seat.builder().image(this.seatE1).state(0).pos("E16").build();
        Seat oSeatF1 = Seat.builder().image(this.seatF1).state(0).pos("F1").build();
        Seat oSeatF2 = Seat.builder().image(this.seatF2).state(0).pos("F2").build();
        Seat oSeatF3 = Seat.builder().image(this.seatF3).state(0).pos("F3").build();
        Seat oSeatF4 = Seat.builder().image(this.seatF4).state(0).pos("F4").build();
        Seat oSeatF5 = Seat.builder().image(this.seatF5).state(0).pos("F5").build();
        Seat oSeatF6 = Seat.builder().image(this.seatF6).state(0).pos("F6").build();
        Seat oSeatF7 = Seat.builder().image(this.seatF7).state(0).pos("F7").build();
        Seat oSeatF8 = Seat.builder().image(this.seatF8).state(0).pos("F8").build();
        Seat oSeatF9 = Seat.builder().image(this.seatF9).state(0).pos("F9").build();
        Seat oSeatF10 = Seat.builder().image(this.seatF1).state(0).pos("F10").build();
        Seat oSeatF11 = Seat.builder().image(this.seatF1).state(0).pos("F11").build();
        Seat oSeatF12 = Seat.builder().image(this.seatF1).state(0).pos("F12").build();
        Seat oSeatF13 = Seat.builder().image(this.seatF1).state(0).pos("F13").build();
        Seat oSeatF14 = Seat.builder().image(this.seatF1).state(0).pos("F14").build();
        Seat oSeatF15 = Seat.builder().image(this.seatF1).state(0).pos("F15").build();
        Seat oSeatF16 = Seat.builder().image(this.seatF1).state(0).pos("F16").build();
        Seat oSeatG1 = Seat.builder().image(this.seatG1).state(0).pos("G1").build();
        Seat oSeatG2 = Seat.builder().image(this.seatG2).state(0).pos("G2").build();
        Seat oSeatG3 = Seat.builder().image(this.seatG3).state(0).pos("G3").build();
        Seat oSeatG4 = Seat.builder().image(this.seatG4).state(0).pos("G4").build();
        Seat oSeatG5 = Seat.builder().image(this.seatG5).state(0).pos("G5").build();
        Seat oSeatG6 = Seat.builder().image(this.seatG6).state(0).pos("G6").build();
        Seat oSeatG7 = Seat.builder().image(this.seatG7).state(0).pos("G7").build();
        Seat oSeatG8 = Seat.builder().image(this.seatG8).state(0).pos("G8").build();
        Seat oSeatG9 = Seat.builder().image(this.seatG9).state(0).pos("G9").build();
        Seat oSeatG10 = Seat.builder().image(this.seatG1).state(0).pos("G10").build();
        Seat oSeatG11 = Seat.builder().image(this.seatG1).state(0).pos("G11").build();
        Seat oSeatG12 = Seat.builder().image(this.seatG1).state(0).pos("G12").build();
        Seat oSeatG13 = Seat.builder().image(this.seatG1).state(0).pos("G13").build();
        Seat oSeatG14 = Seat.builder().image(this.seatG1).state(0).pos("G14").build();
        Seat oSeatG15 = Seat.builder().image(this.seatG1).state(0).pos("G15").build();
        Seat oSeatG16 = Seat.builder().image(this.seatG1).state(0).pos("G16").build();
        Seat oSeatH1 = Seat.builder().image(this.seatH1).state(0).pos("H1").build();
        Seat oSeatH2 = Seat.builder().image(this.seatH2).state(0).pos("H2").build();
        Seat oSeatH3 = Seat.builder().image(this.seatH3).state(0).pos("H3").build();
        Seat oSeatH4 = Seat.builder().image(this.seatH4).state(0).pos("H4").build();
        Seat oSeatH5 = Seat.builder().image(this.seatH5).state(0).pos("H5").build();
        Seat oSeatH6 = Seat.builder().image(this.seatH6).state(0).pos("H6").build();
        Seat oSeatH7 = Seat.builder().image(this.seatH7).state(0).pos("H7").build();
        Seat oSeatH8 = Seat.builder().image(this.seatH8).state(0).pos("H8").build();
        Seat oSeatH9 = Seat.builder().image(this.seatH9).state(0).pos("H9").build();
        Seat oSeatH10 = Seat.builder().image(this.seatH1).state(0).pos("H10").build();
        Seat oSeatH11 = Seat.builder().image(this.seatH1).state(0).pos("H11").build();
        Seat oSeatH12 = Seat.builder().image(this.seatH1).state(0).pos("H12").build();
        Seat oSeatH13 = Seat.builder().image(this.seatH1).state(0).pos("H13").build();
        Seat oSeatH14 = Seat.builder().image(this.seatH1).state(0).pos("H14").build();
        Seat oSeatH15 = Seat.builder().image(this.seatH1).state(0).pos("H15").build();
        Seat oSeatH16 = Seat.builder().image(this.seatH1).state(0).pos("H16").build();
        Seat oSeatI1 = Seat.builder().image(this.seatI1).state(0).pos("I1").build();
        Seat oSeatI2 = Seat.builder().image(this.seatI2).state(0).pos("I2").build();
        Seat oSeatI3 = Seat.builder().image(this.seatI3).state(0).pos("I3").build();
        Seat oSeatI4 = Seat.builder().image(this.seatI4).state(0).pos("I4").build();
        Seat oSeatI5 = Seat.builder().image(this.seatI5).state(0).pos("I5").build();
        Seat oSeatI6 = Seat.builder().image(this.seatI6).state(0).pos("I6").build();
        Seat oSeatI7 = Seat.builder().image(this.seatI7).state(0).pos("I7").build();
        Seat oSeatI8 = Seat.builder().image(this.seatI8).state(0).pos("I8").build();
        Seat oSeatI9 = Seat.builder().image(this.seatI9).state(0).pos("I9").build();
        Seat oSeatI10 = Seat.builder().image(this.seatI1).state(0).pos("I10").build();
        Seat oSeatI11 = Seat.builder().image(this.seatI1).state(0).pos("I11").build();
        Seat oSeatI12 = Seat.builder().image(this.seatI1).state(0).pos("I12").build();
        Seat oSeatI13 = Seat.builder().image(this.seatI1).state(0).pos("I13").build();
        Seat oSeatI14 = Seat.builder().image(this.seatI1).state(0).pos("I14").build();
        Seat oSeatI15 = Seat.builder().image(this.seatI1).state(0).pos("I15").build();
        Seat oSeatI16 = Seat.builder().image(this.seatI1).state(0).pos("I16").build();
        Seat oSeatJ1 = Seat.builder().image(this.seatJ1).state(0).pos("J1").build();
        Seat oSeatJ2 = Seat.builder().image(this.seatJ2).state(0).pos("J2").build();
        Seat oSeatJ3 = Seat.builder().image(this.seatJ3).state(0).pos("J3").build();
        Seat oSeatJ4 = Seat.builder().image(this.seatJ4).state(0).pos("J4").build();
        Seat oSeatJ5 = Seat.builder().image(this.seatJ5).state(0).pos("J5").build();
        Seat oSeatJ6 = Seat.builder().image(this.seatJ6).state(0).pos("J6").build();
        Seat oSeatJ7 = Seat.builder().image(this.seatJ7).state(0).pos("J7").build();
        Seat oSeatJ8 = Seat.builder().image(this.seatJ8).state(0).pos("J8").build();
        Seat oSeatJ9 = Seat.builder().image(this.seatJ9).state(0).pos("J9").build();
        Seat oSeatJ10 = Seat.builder().image(this.seatJ1).state(0).pos("J10").build();
        Seat oSeatJ11 = Seat.builder().image(this.seatJ1).state(0).pos("J11").build();
        Seat oSeatJ12 = Seat.builder().image(this.seatJ1).state(0).pos("J12").build();
        Seat oSeatJ13 = Seat.builder().image(this.seatJ1).state(0).pos("J13").build();
        Seat oSeatJ14 = Seat.builder().image(this.seatJ1).state(0).pos("J14").build();
        Seat oSeatJ15 = Seat.builder().image(this.seatJ1).state(0).pos("J15").build();
        Seat oSeatJ16 = Seat.builder().image(this.seatJ1).state(0).pos("J16").build();
        Seat oSeatK1 = Seat.builder().image(this.seatK1).state(0).pos("K1").build();
        Seat oSeatK2 = Seat.builder().image(this.seatK2).state(0).pos("K2").build();
        Seat oSeatK3 = Seat.builder().image(this.seatK3).state(0).pos("K3").build();
        Seat oSeatK4 = Seat.builder().image(this.seatK4).state(0).pos("K4").build();
        Seat oSeatK5 = Seat.builder().image(this.seatK5).state(0).pos("K5").build();
        Seat oSeatK6 = Seat.builder().image(this.seatK6).state(0).pos("K6").build();
        Seat oSeatK7 = Seat.builder().image(this.seatK7).state(0).pos("K7").build();
        Seat oSeatK8 = Seat.builder().image(this.seatK8).state(0).pos("K8").build();
        Seat oSeatK9 = Seat.builder().image(this.seatK9).state(0).pos("K9").build();
        Seat oSeatK10 = Seat.builder().image(this.seatK1).state(0).pos("K10").build();
        Seat oSeatK11 = Seat.builder().image(this.seatK1).state(0).pos("K11").build();
        Seat oSeatK12 = Seat.builder().image(this.seatK1).state(0).pos("K12").build();
        Seat oSeatK13 = Seat.builder().image(this.seatK1).state(0).pos("K13").build();
        Seat oSeatK14 = Seat.builder().image(this.seatK1).state(0).pos("K14").build();
        Seat oSeatK15 = Seat.builder().image(this.seatK1).state(0).pos("K15").build();
        Seat oSeatK16 = Seat.builder().image(this.seatK1).state(0).pos("K16").build();
        Seat oSeatL1 = Seat.builder().image(this.seatL1).state(0).pos("L1").build();
        Seat oSeatL2 = Seat.builder().image(this.seatL2).state(0).pos("L2").build();
        Seat oSeatL3 = Seat.builder().image(this.seatL3).state(0).pos("L3").build();
        Seat oSeatL4 = Seat.builder().image(this.seatL4).state(0).pos("L4").build();
        Seat oSeatL5 = Seat.builder().image(this.seatL5).state(0).pos("L5").build();
        Seat oSeatL6 = Seat.builder().image(this.seatL6).state(0).pos("L6").build();
        Seat oSeatL7 = Seat.builder().image(this.seatL7).state(0).pos("L7").build();
        Seat oSeatL8 = Seat.builder().image(this.seatL8).state(0).pos("L8").build();
        Seat oSeatL9 = Seat.builder().image(this.seatL9).state(0).pos("L9").build();
        Seat oSeatL10 = Seat.builder().image(this.seatL1).state(0).pos("L10").build();
        Seat oSeatL11 = Seat.builder().image(this.seatL1).state(0).pos("L11").build();
        Seat oSeatL12 = Seat.builder().image(this.seatL1).state(0).pos("L12").build();
        Seat oSeatL13 = Seat.builder().image(this.seatL1).state(0).pos("L13").build();
        Seat oSeatL14 = Seat.builder().image(this.seatL1).state(0).pos("L14").build();
        Seat oSeatL15 = Seat.builder().image(this.seatL1).state(0).pos("L15").build();
        Seat oSeatL16 = Seat.builder().image(this.seatL1).state(0).pos("L16").build();
        Seat oSeatM1 = Seat.builder().image(this.seatM1).state(0).pos("M1").build();
        Seat oSeatM2 = Seat.builder().image(this.seatM2).state(0).pos("M2").build();
        Seat oSeatM3 = Seat.builder().image(this.seatM3).state(0).pos("M3").build();
        Seat oSeatM4 = Seat.builder().image(this.seatM4).state(0).pos("M4").build();
        Seat oSeatM5 = Seat.builder().image(this.seatM5).state(0).pos("M5").build();
        Seat oSeatM6 = Seat.builder().image(this.seatM6).state(0).pos("M6").build();
        Seat oSeatM7 = Seat.builder().image(this.seatM7).state(0).pos("M7").build();
        Seat oSeatM8 = Seat.builder().image(this.seatM8).state(0).pos("M8").build();
        Seat oSeatM9 = Seat.builder().image(this.seatM9).state(0).pos("M9").build();
        Seat oSeatM10 = Seat.builder().image(this.seatM1).state(0).pos("M10").build();
        Seat oSeatM11 = Seat.builder().image(this.seatM1).state(0).pos("M11").build();
        Seat oSeatM12 = Seat.builder().image(this.seatM1).state(0).pos("M12").build();
        Seat oSeatM13 = Seat.builder().image(this.seatM1).state(0).pos("M13").build();
        Seat oSeatM14 = Seat.builder().image(this.seatM1).state(0).pos("M14").build();
        Seat oSeatM15 = Seat.builder().image(this.seatM1).state(0).pos("M15").build();
        Seat oSeatM16 = Seat.builder().image(this.seatM1).state(0).pos("M16").build();
        Seat oSeatN1 = Seat.builder().image(this.seatN1).state(0).pos("N1").build();
        Seat oSeatN2 = Seat.builder().image(this.seatN2).state(0).pos("N2").build();
        Seat oSeatN3 = Seat.builder().image(this.seatN3).state(0).pos("N3").build();
        Seat oSeatN4 = Seat.builder().image(this.seatN4).state(0).pos("N4").build();
        Seat oSeatN5 = Seat.builder().image(this.seatN5).state(0).pos("N5").build();
        Seat oSeatN6 = Seat.builder().image(this.seatN6).state(0).pos("N6").build();
        Seat oSeatN7 = Seat.builder().image(this.seatN7).state(0).pos("N7").build();
        Seat oSeatN8 = Seat.builder().image(this.seatN8).state(0).pos("N8").build();
        Seat oSeatN9 = Seat.builder().image(this.seatN9).state(0).pos("N9").build();
        Seat oSeatN10 = Seat.builder().image(this.seatN1).state(0).pos("N10").build();
        Seat oSeatN11 = Seat.builder().image(this.seatN1).state(0).pos("N11").build();
        Seat oSeatN12 = Seat.builder().image(this.seatN1).state(0).pos("N12").build();
        Seat oSeatN13 = Seat.builder().image(this.seatN1).state(0).pos("N13").build();
        Seat oSeatN14 = Seat.builder().image(this.seatN1).state(0).pos("N14").build();
        Seat oSeatN15 = Seat.builder().image(this.seatN1).state(0).pos("N15").build();
        Seat oSeatN16 = Seat.builder().image(this.seatN1).state(0).pos("N16").build();


        roomShape.add(oSeatA1);
        roomShape.add(oSeatA2);
        roomShape.add(oSeatA3);
        roomShape.add(oSeatA4);
        roomShape.add(oSeatA5);
        roomShape.add(oSeatA6);
        roomShape.add(oSeatA7);
        roomShape.add(oSeatA8);
        roomShape.add(oSeatA9);
        roomShape.add(oSeatA10);
        roomShape.add(oSeatA11);
        roomShape.add(oSeatA12);
        roomShape.add(oSeatA13);
        roomShape.add(oSeatA14);
        roomShape.add(oSeatA15);
        roomShape.add(oSeatA16);
        roomShape.add(oSeatB1);
        roomShape.add(oSeatB2);
        roomShape.add(oSeatB3);
        roomShape.add(oSeatB4);
        roomShape.add(oSeatB5);
        roomShape.add(oSeatB6);
        roomShape.add(oSeatB7);
        roomShape.add(oSeatB8);
        roomShape.add(oSeatB9);
        roomShape.add(oSeatB10);
        roomShape.add(oSeatB11);
        roomShape.add(oSeatB12);
        roomShape.add(oSeatB13);
        roomShape.add(oSeatB14);
        roomShape.add(oSeatB15);
        roomShape.add(oSeatB16);
        roomShape.add(oSeatC1);
        roomShape.add(oSeatC2);
        roomShape.add(oSeatC3);
        roomShape.add(oSeatC4);
        roomShape.add(oSeatC5);
        roomShape.add(oSeatC6);
        roomShape.add(oSeatC7);
        roomShape.add(oSeatC8);
        roomShape.add(oSeatC9);
        roomShape.add(oSeatC10);
        roomShape.add(oSeatC11);
        roomShape.add(oSeatC12);
        roomShape.add(oSeatC13);
        roomShape.add(oSeatC14);
        roomShape.add(oSeatC15);
        roomShape.add(oSeatC16);
        roomShape.add(oSeatD1);
        roomShape.add(oSeatD2);
        roomShape.add(oSeatD3);
        roomShape.add(oSeatD4);
        roomShape.add(oSeatD5);
        roomShape.add(oSeatD6);
        roomShape.add(oSeatD7);
        roomShape.add(oSeatD8);
        roomShape.add(oSeatD9);
        roomShape.add(oSeatD10);
        roomShape.add(oSeatD11);
        roomShape.add(oSeatD12);
        roomShape.add(oSeatD13);
        roomShape.add(oSeatD14);
        roomShape.add(oSeatD15);
        roomShape.add(oSeatD16);
        roomShape.add(oSeatE1);
        roomShape.add(oSeatE2);
        roomShape.add(oSeatE3);
        roomShape.add(oSeatE4);
        roomShape.add(oSeatE5);
        roomShape.add(oSeatE6);
        roomShape.add(oSeatE7);
        roomShape.add(oSeatE8);
        roomShape.add(oSeatE9);
        roomShape.add(oSeatE10);
        roomShape.add(oSeatE11);
        roomShape.add(oSeatE12);
        roomShape.add(oSeatE13);
        roomShape.add(oSeatE14);
        roomShape.add(oSeatE15);
        roomShape.add(oSeatE16);
        roomShape.add(oSeatF1);
        roomShape.add(oSeatF2);
        roomShape.add(oSeatF3);
        roomShape.add(oSeatF4);
        roomShape.add(oSeatF5);
        roomShape.add(oSeatF6);
        roomShape.add(oSeatF7);
        roomShape.add(oSeatF8);
        roomShape.add(oSeatF9);
        roomShape.add(oSeatF10);
        roomShape.add(oSeatF11);
        roomShape.add(oSeatF12);
        roomShape.add(oSeatF13);
        roomShape.add(oSeatF14);
        roomShape.add(oSeatF15);
        roomShape.add(oSeatF16);
        roomShape.add(oSeatG1);
        roomShape.add(oSeatG2);
        roomShape.add(oSeatG3);
        roomShape.add(oSeatG4);
        roomShape.add(oSeatG5);
        roomShape.add(oSeatG6);
        roomShape.add(oSeatG7);
        roomShape.add(oSeatG8);
        roomShape.add(oSeatG9);
        roomShape.add(oSeatG10);
        roomShape.add(oSeatG11);
        roomShape.add(oSeatG12);
        roomShape.add(oSeatG13);
        roomShape.add(oSeatG14);
        roomShape.add(oSeatG15);
        roomShape.add(oSeatG16);
        roomShape.add(oSeatH1);
        roomShape.add(oSeatH2);
        roomShape.add(oSeatH3);
        roomShape.add(oSeatH4);
        roomShape.add(oSeatH5);
        roomShape.add(oSeatH6);
        roomShape.add(oSeatH7);
        roomShape.add(oSeatH8);
        roomShape.add(oSeatH9);
        roomShape.add(oSeatH10);
        roomShape.add(oSeatH11);
        roomShape.add(oSeatH12);
        roomShape.add(oSeatH13);
        roomShape.add(oSeatH14);
        roomShape.add(oSeatH15);
        roomShape.add(oSeatH16);
        roomShape.add(oSeatI1);
        roomShape.add(oSeatI2);
        roomShape.add(oSeatI3);
        roomShape.add(oSeatI4);
        roomShape.add(oSeatI5);
        roomShape.add(oSeatI6);
        roomShape.add(oSeatI7);
        roomShape.add(oSeatI8);
        roomShape.add(oSeatI9);
        roomShape.add(oSeatI10);
        roomShape.add(oSeatI11);
        roomShape.add(oSeatI12);
        roomShape.add(oSeatI13);
        roomShape.add(oSeatI14);
        roomShape.add(oSeatI15);
        roomShape.add(oSeatI16);
        roomShape.add(oSeatJ1);
        roomShape.add(oSeatJ2);
        roomShape.add(oSeatJ3);
        roomShape.add(oSeatJ4);
        roomShape.add(oSeatJ5);
        roomShape.add(oSeatJ6);
        roomShape.add(oSeatJ7);
        roomShape.add(oSeatJ8);
        roomShape.add(oSeatJ9);
        roomShape.add(oSeatJ10);
        roomShape.add(oSeatJ11);
        roomShape.add(oSeatJ12);
        roomShape.add(oSeatJ13);
        roomShape.add(oSeatJ14);
        roomShape.add(oSeatJ15);
        roomShape.add(oSeatJ16);
        roomShape.add(oSeatK1);
        roomShape.add(oSeatK2);
        roomShape.add(oSeatK3);
        roomShape.add(oSeatK4);
        roomShape.add(oSeatK5);
        roomShape.add(oSeatK6);
        roomShape.add(oSeatK7);
        roomShape.add(oSeatK8);
        roomShape.add(oSeatK9);
        roomShape.add(oSeatK10);
        roomShape.add(oSeatK11);
        roomShape.add(oSeatK12);
        roomShape.add(oSeatK13);
        roomShape.add(oSeatK14);
        roomShape.add(oSeatK15);
        roomShape.add(oSeatK16);
        roomShape.add(oSeatL1);
        roomShape.add(oSeatL2);
        roomShape.add(oSeatL3);
        roomShape.add(oSeatL4);
        roomShape.add(oSeatL5);
        roomShape.add(oSeatL6);
        roomShape.add(oSeatL7);
        roomShape.add(oSeatL8);
        roomShape.add(oSeatL9);
        roomShape.add(oSeatL10);
        roomShape.add(oSeatL11);
        roomShape.add(oSeatL12);
        roomShape.add(oSeatL13);
        roomShape.add(oSeatL14);
        roomShape.add(oSeatL15);
        roomShape.add(oSeatL16);
        roomShape.add(oSeatM1);
        roomShape.add(oSeatM2);
        roomShape.add(oSeatM3);
        roomShape.add(oSeatM4);
        roomShape.add(oSeatM5);
        roomShape.add(oSeatM6);
        roomShape.add(oSeatM7);
        roomShape.add(oSeatM8);
        roomShape.add(oSeatM9);
        roomShape.add(oSeatM10);
        roomShape.add(oSeatM11);
        roomShape.add(oSeatM12);
        roomShape.add(oSeatM13);
        roomShape.add(oSeatM14);
        roomShape.add(oSeatM15);
        roomShape.add(oSeatM16);
        roomShape.add(oSeatN1);
        roomShape.add(oSeatN2);
        roomShape.add(oSeatN3);
        roomShape.add(oSeatN4);
        roomShape.add(oSeatN5);
        roomShape.add(oSeatN6);
        roomShape.add(oSeatN7);
        roomShape.add(oSeatN8);
        roomShape.add(oSeatN9);
        roomShape.add(oSeatN10);
        roomShape.add(oSeatN11);
        roomShape.add(oSeatN12);
        roomShape.add(oSeatN13);
        roomShape.add(oSeatN14);
        roomShape.add(oSeatN15);
        roomShape.add(oSeatN16);
    }

    public void occupiedSeatFill(List<String> seatsOccupied) {

        List<String> seatsOccupiedAll;
        createRoomShape();

        for (String i : seatsOccupied) {
            seatsOccupiedAll = Arrays.asList(i.split(","));

            for (Seat img : roomShape) {
                for (String e : seatsOccupiedAll) {
                    if (img.getPos().equals(e)) {
                        try {
//                            img.getImage().setVisible(false);
                            img.getImage().setImage(new Image("images/seatOccupied.png"));
                            img.setState(2);
                        } catch (Exception ex) {
                        }
                    }
                }
            }
        }

    }

    public void availableSeatFill(List<String> seatsAvailable) {
        List<String> seatsAvailableAll;
        createRoomShape();

        for (String i : seatsAvailable) {
            seatsAvailableAll = Arrays.asList(i.split(","));

            for (Seat img : roomShape) {
                for (String e : seatsAvailableAll) {
                    if (img.getPos().equals(e)) {
                        img.getImage().setImage(new Image("images/seatAvailable.png"));
                        img.setState(0);
                    } else {
                        img.getImage().setVisible(false);
                    }
                }
            }
        }
    }

    public void seleccionarAsientoA1() {
        if (roomShape.get(0).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA1.setImage(new Image("images/seatSelected.png"));
                roomShape.get(0).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(0).getState() == 1) { //Selected
            seatA1.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(0).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoA2() {
        if (roomShape.get(1).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(1).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(1).getState() == 1) { //Selected
            seatA2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(1).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoA3() {
        if (roomShape.get(2).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA3.setImage(new Image("images/seatSelected.png"));
                roomShape.get(2).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(2).getState() == 1) { //Selected
            seatA3.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(2).setState(0);
            decreaseSeatCount();
        }
    }

    private int seatCount;
    private int seatsToReserve = 2; // cambia valor restringido

    public void decreaseSeatCount() {
        if (seatCount <= 0) {
            System.out.println("Too low");
        } else {
            seatCount--;
        }
    }

    public void increaseSeatCount() {
        seatCount++;
    }

//    public void seleccionarAsientoA1() {
//        if (roomShape.get(0).getState() == 0) { //Available
//            if (seatCount < seatsToReserve) {
//                seatA1.setImage(new Image("images/seatSelected.png"));
//                roomShape.get(0).setState(1);
//                increaseSeatCount();
//            } else {
//                //Pop up
//            }
//        } else if (roomShape.get(0).getState() == 1) { //Selected
//            seatA1.setImage(new Image("images/seatAvailable.png"));
//            roomShape.get(0).setState(0);
//            decreaseSeatCount();
//        }
//    }
//
//    public void seleccionarAsientoA2() {
//        if (roomShape.get(1).getState() == 0) { //Available
//            if (seatCount < seatsToReserve) {
//                seatA2.setImage(new Image("images/seatSelected.png"));
//                roomShape.get(1).setState(1);
//                increaseSeatCount();
//            } else {
//                //Pop up
//            }
//        } else if (roomShape.get(1).getState() == 1) { //Selected
//            seatA2.setImage(new Image("images/seatAvailable.png"));
//            roomShape.get(1).setState(0);
//            decreaseSeatCount();
//        }
//    }
//
//    public void seleccionarAsientoA3() {
//        if (roomShape.get(2).getState() == 0) { //Available
//            if (seatCount < seatsToReserve) {
//                seatA3.setImage(new Image("images/seatSelected.png"));
//                roomShape.get(2).setState(1);
//                increaseSeatCount();
//            } else {
//                //Pop up
//            }
//        } else if (roomShape.get(2).getState() == 1) { //Selected
//            seatA3.setImage(new Image("images/seatAvailable.png"));
//            roomShape.get(2).setState(0);
//            decreaseSeatCount();
//        }
//    }

    public void seleccionarAsientoA4() {
        if (roomShape.get(3).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA4.setImage(new Image("images/seatSelected.png"));
                roomShape.get(3).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(3).getState() == 1) { //Selected
            seatA4.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(3).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoA5() {
        if (roomShape.get(4).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA5.setImage(new Image("images/seatSelected.png"));
                roomShape.get(4).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(4).getState() == 1) { //Selected
            seatA5.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(4).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoA6() {
        if (roomShape.get(5).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA6.setImage(new Image("images/seatSelected.png"));
                roomShape.get(5).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(5).getState() == 1) { //Selected
            seatA6.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(5).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoA7() {
        if (roomShape.get(6).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA7.setImage(new Image("images/seatSelected.png"));
                roomShape.get(6).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(6).getState() == 1) { //Selected
            seatA7.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(6).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoA8() {
        if (roomShape.get(7).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA8.setImage(new Image("images/seatSelected.png"));
                roomShape.get(7).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(7).getState() == 1) { //Selected
            seatA8.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(7).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoA9() {
        if (roomShape.get(8).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA9.setImage(new Image("images/seatSelected.png"));
                roomShape.get(8).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(8).getState() == 1) { //Selected
            seatA9.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(8).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoA10() {
        if (roomShape.get(9).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA10.setImage(new Image("images/seatSelected.png"));
                roomShape.get(9).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(9).getState() == 1) { //Selected
            seatA10.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(9).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoA11() {
        if (roomShape.get(10).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA11.setImage(new Image("images/seatSelected.png"));
                roomShape.get(10).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(10).getState() == 1) { //Selected
            seatA11.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(10).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoA12() {
        if (roomShape.get(11).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA12.setImage(new Image("images/seatSelected.png"));
                roomShape.get(11).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(11).getState() == 1) { //Selected
            seatA12.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(11).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoA13() {
        if (roomShape.get(12).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA13.setImage(new Image("images/seatSelected.png"));
                roomShape.get(12).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(12).getState() == 1) { //Selected
            seatA13.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(12).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoA14() {
        if (roomShape.get(13).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA14.setImage(new Image("images/seatSelected.png"));
                roomShape.get(13).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(13).getState() == 1) { //Selected
            seatA14.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(13).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoA15() {
        if (roomShape.get(14).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA15.setImage(new Image("images/seatSelected.png"));
                roomShape.get(14).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(14).getState() == 1) { //Selected
            seatA15.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(14).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoA16() {
        if (roomShape.get(15).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatA16.setImage(new Image("images/seatSelected.png"));
                roomShape.get(15).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(15).getState() == 1) { //Selected
            seatA16.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(15).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB1() {
        if (roomShape.get(16).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB1.setImage(new Image("images/seatSelected.png"));
                roomShape.get(16).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(16).getState() == 1) { //Selected
            seatB1.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(16).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB2() {
        if (roomShape.get(17).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(17).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(17).getState() == 1) { //Selected
            seatB2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(17).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB3() {
        if (roomShape.get(18).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB3.setImage(new Image("images/seatSelected.png"));
                roomShape.get(18).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(18).getState() == 1) { //Selected
            seatB3.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(18).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB4() {
        if (roomShape.get(19).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB4.setImage(new Image("images/seatSelected.png"));
                roomShape.get(19).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(19).getState() == 1) { //Selected
            seatB4.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(19).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB5() {
        if (roomShape.get(20).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB5.setImage(new Image("images/seatSelected.png"));
                roomShape.get(20).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(20).getState() == 1) { //Selected
            seatB5.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(20).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB6() {
        if (roomShape.get(21).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB6.setImage(new Image("images/seatSelected.png"));
                roomShape.get(21).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(21).getState() == 1) { //Selected
            seatB6.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(21).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB7() {
        if (roomShape.get(22).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB7.setImage(new Image("images/seatSelected.png"));
                roomShape.get(22).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(22).getState() == 1) { //Selected
            seatB7.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(22).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB8() {
        if (roomShape.get(23).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB8.setImage(new Image("images/seatSelected.png"));
                roomShape.get(23).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(23).getState() == 1) { //Selected
            seatB8.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(23).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB9() {
        if (roomShape.get(24).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB9.setImage(new Image("images/seatSelected.png"));
                roomShape.get(24).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(24).getState() == 1) { //Selected
            seatB9.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(24).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB10() {
        if (roomShape.get(25).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB10.setImage(new Image("images/seatSelected.png"));
                roomShape.get(25).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(25).getState() == 1) { //Selected
            seatB10.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(25).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB11() {
        if (roomShape.get(26).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB11.setImage(new Image("images/seatSelected.png"));
                roomShape.get(26).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(26).getState() == 1) { //Selected
            seatB11.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(26).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB12() {
        if (roomShape.get(27).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB12.setImage(new Image("images/seatSelected.png"));
                roomShape.get(27).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(27).getState() == 1) { //Selected
            seatB12.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(27).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB13() {
        if (roomShape.get(28).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB13.setImage(new Image("images/seatSelected.png"));
                roomShape.get(28).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(28).getState() == 1) { //Selected
            seatB13.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(28).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB14() {
        if (roomShape.get(29).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(29).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(29).getState() == 1) { //Selected
            seatB2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(29).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB15() {
        if (roomShape.get(30).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB15.setImage(new Image("images/seatSelected.png"));
                roomShape.get(30).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(30).getState() == 1) { //Selected
            seatB15.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(30).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoB16() {
        if (roomShape.get(31).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatB16.setImage(new Image("images/seatSelected.png"));
                roomShape.get(31).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(31).getState() == 1) { //Selected
            seatB16.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(31).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC1() {
        if (roomShape.get(32).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC1.setImage(new Image("images/seatSelected.png"));
                roomShape.get(32).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(32).getState() == 1) { //Selected
            seatC1.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(32).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC2() {
        if (roomShape.get(33).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(33).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(33).getState() == 1) { //Selected
            seatC2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(33).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC3() {
        if (roomShape.get(34).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC3.setImage(new Image("images/seatSelected.png"));
                roomShape.get(34).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(34).getState() == 1) { //Selected
            seatC3.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(34).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC4() {
        if (roomShape.get(35).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC4.setImage(new Image("images/seatSelected.png"));
                roomShape.get(35).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(35).getState() == 1) { //Selected
            seatC4.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(35).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC5() {
        if (roomShape.get(36).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC5.setImage(new Image("images/seatSelected.png"));
                roomShape.get(36).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(36).getState() == 1) { //Selected
            seatC5.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(36).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC6() {
        if (roomShape.get(37).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC6.setImage(new Image("images/seatSelected.png"));
                roomShape.get(37).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(37).getState() == 1) { //Selected
            seatC6.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(37).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC7() {
        if (roomShape.get(38).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC7.setImage(new Image("images/seatSelected.png"));
                roomShape.get(38).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(38).getState() == 1) { //Selected
            seatC7.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(38).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC8() {
        if (roomShape.get(39).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC8.setImage(new Image("images/seatSelected.png"));
                roomShape.get(39).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(39).getState() == 1) { //Selected
            seatC8.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(39).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC9() {
        if (roomShape.get(40).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC9.setImage(new Image("images/seatSelected.png"));
                roomShape.get(40).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(40).getState() == 1) { //Selected
            seatC9.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(40).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC10() {
        if (roomShape.get(41).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC10.setImage(new Image("images/seatSelected.png"));
                roomShape.get(41).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(41).getState() == 1) { //Selected
            seatC10.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(41).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC11() {
        if (roomShape.get(42).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC11.setImage(new Image("images/seatSelected.png"));
                roomShape.get(42).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(42).getState() == 1) { //Selected
            seatC11.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(42).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC12() {
        if (roomShape.get(43).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC12.setImage(new Image("images/seatSelected.png"));
                roomShape.get(43).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(43).getState() == 1) { //Selected
            seatC12.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(43).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC13() {
        if (roomShape.get(44).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC13.setImage(new Image("images/seatSelected.png"));
                roomShape.get(44).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(44).getState() == 1) { //Selected
            seatC13.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(44).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC14() {
        if (roomShape.get(45).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(45).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(45).getState() == 1) { //Selected
            seatC2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(45).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC15() {
        if (roomShape.get(46).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC15.setImage(new Image("images/seatSelected.png"));
                roomShape.get(46).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(46).getState() == 1) { //Selected
            seatC15.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(46).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoC16() {
        if (roomShape.get(47).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatC16.setImage(new Image("images/seatSelected.png"));
                roomShape.get(47).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(47).getState() == 1) { //Selected
            seatC16.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(47).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD1() {
        if (roomShape.get(48).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD1.setImage(new Image("images/seatSelected.png"));
                roomShape.get(48).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(48).getState() == 1) { //Selected
            seatD1.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(48).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD2() {
        if (roomShape.get(49).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(49).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(49).getState() == 1) { //Selected
            seatD2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(49).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD3() {
        if (roomShape.get(50).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD3.setImage(new Image("images/seatSelected.png"));
                roomShape.get(50).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(50).getState() == 1) { //Selected
            seatD3.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(50).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD4() {
        if (roomShape.get(51).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD4.setImage(new Image("images/seatSelected.png"));
                roomShape.get(51).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(51).getState() == 1) { //Selected
            seatD4.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(51).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD5() {
        if (roomShape.get(52).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD5.setImage(new Image("images/seatSelected.png"));
                roomShape.get(52).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(52).getState() == 1) { //Selected
            seatD5.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(52).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD6() {
        if (roomShape.get(53).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD6.setImage(new Image("images/seatSelected.png"));
                roomShape.get(53).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(53).getState() == 1) { //Selected
            seatD6.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(53).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD7() {
        if (roomShape.get(54).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD7.setImage(new Image("images/seatSelected.png"));
                roomShape.get(54).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(54).getState() == 1) { //Selected
            seatD7.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(54).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD8() {
        if (roomShape.get(55).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD8.setImage(new Image("images/seatSelected.png"));
                roomShape.get(55).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(55).getState() == 1) { //Selected
            seatD8.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(55).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD9() {
        if (roomShape.get(56).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD9.setImage(new Image("images/seatSelected.png"));
                roomShape.get(56).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(56).getState() == 1) { //Selected
            seatD9.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(56).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD10() {
        if (roomShape.get(57).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD10.setImage(new Image("images/seatSelected.png"));
                roomShape.get(57).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(57).getState() == 1) { //Selected
            seatD10.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(57).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD11() {
        if (roomShape.get(58).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD11.setImage(new Image("images/seatSelected.png"));
                roomShape.get(58).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(58).getState() == 1) { //Selected
            seatD11.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(58).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD12() {
        if (roomShape.get(59).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD12.setImage(new Image("images/seatSelected.png"));
                roomShape.get(59).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(59).getState() == 1) { //Selected
            seatD12.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(59).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD13() {
        if (roomShape.get(60).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD13.setImage(new Image("images/seatSelected.png"));
                roomShape.get(60).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(60).getState() == 1) { //Selected
            seatD13.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(60).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD14() {
        if (roomShape.get(61).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(61).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(61).getState() == 1) { //Selected
            seatD2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(61).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD15() {
        if (roomShape.get(62).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD15.setImage(new Image("images/seatSelected.png"));
                roomShape.get(62).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(62).getState() == 1) { //Selected
            seatD15.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(62).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoD16() {
        if (roomShape.get(63).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatD16.setImage(new Image("images/seatSelected.png"));
                roomShape.get(63).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(63).getState() == 1) { //Selected
            seatD16.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(63).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE1() {
        if (roomShape.get(64).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE1.setImage(new Image("images/seatSelected.png"));
                roomShape.get(64).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(64).getState() == 1) { //Selected
            seatE1.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(64).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE2() {
        if (roomShape.get(65).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(65).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(65).getState() == 1) { //Selected
            seatE2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(65).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE3() {
        if (roomShape.get(66).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE3.setImage(new Image("images/seatSelected.png"));
                roomShape.get(66).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(66).getState() == 1) { //Selected
            seatE3.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(66).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE4() {
        if (roomShape.get(67).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE4.setImage(new Image("images/seatSelected.png"));
                roomShape.get(67).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(67).getState() == 1) { //Selected
            seatE4.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(67).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE5() {
        if (roomShape.get(68).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE5.setImage(new Image("images/seatSelected.png"));
                roomShape.get(68).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(68).getState() == 1) { //Selected
            seatE5.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(68).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE6() {
        if (roomShape.get(69).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE6.setImage(new Image("images/seatSelected.png"));
                roomShape.get(69).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(69).getState() == 1) { //Selected
            seatE6.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(69).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE7() {
        if (roomShape.get(70).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE7.setImage(new Image("images/seatSelected.png"));
                roomShape.get(70).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(70).getState() == 1) { //Selected
            seatE7.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(70).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE8() {
        if (roomShape.get(71).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE8.setImage(new Image("images/seatSelected.png"));
                roomShape.get(71).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(71).getState() == 1) { //Selected
            seatE8.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(71).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE9() {
        if (roomShape.get(72).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE9.setImage(new Image("images/seatSelected.png"));
                roomShape.get(72).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(72).getState() == 1) { //Selected
            seatE9.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(72).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE10() {
        if (roomShape.get(73).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE10.setImage(new Image("images/seatSelected.png"));
                roomShape.get(73).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(73).getState() == 1) { //Selected
            seatE10.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(73).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE11() {
        if (roomShape.get(74).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE11.setImage(new Image("images/seatSelected.png"));
                roomShape.get(74).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(74).getState() == 1) { //Selected
            seatE11.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(74).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE12() {
        if (roomShape.get(75).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE12.setImage(new Image("images/seatSelected.png"));
                roomShape.get(75).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(75).getState() == 1) { //Selected
            seatE12.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(75).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE13() {
        if (roomShape.get(76).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE13.setImage(new Image("images/seatSelected.png"));
                roomShape.get(76).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(76).getState() == 1) { //Selected
            seatE13.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(76).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE14() {
        if (roomShape.get(77).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(77).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(77).getState() == 1) { //Selected
            seatE2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(77).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE15() {
        if (roomShape.get(78).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE15.setImage(new Image("images/seatSelected.png"));
                roomShape.get(78).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(78).getState() == 1) { //Selected
            seatE15.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(78).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoE16() {
        if (roomShape.get(79).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatE16.setImage(new Image("images/seatSelected.png"));
                roomShape.get(79).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(79).getState() == 1) { //Selected
            seatE16.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(79).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF1() {
        if (roomShape.get(80).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF1.setImage(new Image("images/seatSelected.png"));
                roomShape.get(80).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(80).getState() == 1) { //Selected
            seatF1.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(80).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF2() {
        if (roomShape.get(81).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(81).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(81).getState() == 1) { //Selected
            seatF2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(81).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF3() {
        if (roomShape.get(82).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF3.setImage(new Image("images/seatSelected.png"));
                roomShape.get(82).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(82).getState() == 1) { //Selected
            seatF3.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(82).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF4() {
        if (roomShape.get(83).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF4.setImage(new Image("images/seatSelected.png"));
                roomShape.get(83).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(83).getState() == 1) { //Selected
            seatF4.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(83).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF5() {
        if (roomShape.get(84).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF5.setImage(new Image("images/seatSelected.png"));
                roomShape.get(84).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(84).getState() == 1) { //Selected
            seatF5.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(84).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF6() {
        if (roomShape.get(85).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF6.setImage(new Image("images/seatSelected.png"));
                roomShape.get(85).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(85).getState() == 1) { //Selected
            seatF6.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(85).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF7() {
        if (roomShape.get(86).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF7.setImage(new Image("images/seatSelected.png"));
                roomShape.get(86).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(86).getState() == 1) { //Selected
            seatF7.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(86).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF8() {
        if (roomShape.get(87).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF8.setImage(new Image("images/seatSelected.png"));
                roomShape.get(87).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(87).getState() == 1) { //Selected
            seatF8.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(87).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF9() {
        if (roomShape.get(88).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF9.setImage(new Image("images/seatSelected.png"));
                roomShape.get(88).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(88).getState() == 1) { //Selected
            seatF9.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(88).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF10() {
        if (roomShape.get(89).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF10.setImage(new Image("images/seatSelected.png"));
                roomShape.get(89).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(89).getState() == 1) { //Selected
            seatF10.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(89).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF11() {
        if (roomShape.get(90).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF11.setImage(new Image("images/seatSelected.png"));
                roomShape.get(90).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(90).getState() == 1) { //Selected
            seatF11.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(90).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF12() {
        if (roomShape.get(91).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF12.setImage(new Image("images/seatSelected.png"));
                roomShape.get(91).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(91).getState() == 1) { //Selected
            seatF12.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(91).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF13() {
        if (roomShape.get(92).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF13.setImage(new Image("images/seatSelected.png"));
                roomShape.get(92).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(92).getState() == 1) { //Selected
            seatF13.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(92).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF14() {
        if (roomShape.get(93).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(93).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(93).getState() == 1) { //Selected
            seatF2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(93).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF15() {
        if (roomShape.get(94).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF15.setImage(new Image("images/seatSelected.png"));
                roomShape.get(94).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(94).getState() == 1) { //Selected
            seatF15.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(94).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoF16() {
        if (roomShape.get(95).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatF16.setImage(new Image("images/seatSelected.png"));
                roomShape.get(95).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(95).getState() == 1) { //Selected
            seatF16.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(95).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG1() {
        if (roomShape.get(96).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG1.setImage(new Image("images/seatSelected.png"));
                roomShape.get(96).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(96).getState() == 1) { //Selected
            seatG1.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(96).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG2() {
        if (roomShape.get(97).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(97).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(97).getState() == 1) { //Selected
            seatG2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(97).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG3() {
        if (roomShape.get(98).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG3.setImage(new Image("images/seatSelected.png"));
                roomShape.get(98).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(98).getState() == 1) { //Selected
            seatG3.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(98).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG4() {
        if (roomShape.get(99).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG4.setImage(new Image("images/seatSelected.png"));
                roomShape.get(99).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(99).getState() == 1) { //Selected
            seatG4.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(99).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG5() {
        if (roomShape.get(100).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG5.setImage(new Image("images/seatSelected.png"));
                roomShape.get(100).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(100).getState() == 1) { //Selected
            seatG5.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(100).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG6() {
        if (roomShape.get(101).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG6.setImage(new Image("images/seatSelected.png"));
                roomShape.get(101).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(101).getState() == 1) { //Selected
            seatG6.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(101).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG7() {
        if (roomShape.get(102).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG7.setImage(new Image("images/seatSelected.png"));
                roomShape.get(102).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(102).getState() == 1) { //Selected
            seatG7.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(102).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG8() {
        if (roomShape.get(103).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG8.setImage(new Image("images/seatSelected.png"));
                roomShape.get(103).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(103).getState() == 1) { //Selected
            seatG8.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(103).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG9() {
        if (roomShape.get(104).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG9.setImage(new Image("images/seatSelected.png"));
                roomShape.get(104).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(104).getState() == 1) { //Selected
            seatG9.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(104).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG10() {
        if (roomShape.get(105).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG10.setImage(new Image("images/seatSelected.png"));
                roomShape.get(105).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(105).getState() == 1) { //Selected
            seatG10.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(105).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG11() {
        if (roomShape.get(106).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG11.setImage(new Image("images/seatSelected.png"));
                roomShape.get(106).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(106).getState() == 1) { //Selected
            seatG11.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(106).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG12() {
        if (roomShape.get(107).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG12.setImage(new Image("images/seatSelected.png"));
                roomShape.get(107).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(107).getState() == 1) { //Selected
            seatG12.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(107).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG13() {
        if (roomShape.get(108).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG13.setImage(new Image("images/seatSelected.png"));
                roomShape.get(108).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(108).getState() == 1) { //Selected
            seatG13.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(108).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG14() {
        if (roomShape.get(109).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(109).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(109).getState() == 1) { //Selected
            seatG2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(109).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG15() {
        if (roomShape.get(110).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG15.setImage(new Image("images/seatSelected.png"));
                roomShape.get(110).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(110).getState() == 1) { //Selected
            seatG15.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(110).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoG16() {
        if (roomShape.get(111).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatG16.setImage(new Image("images/seatSelected.png"));
                roomShape.get(111).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(111).getState() == 1) { //Selected
            seatG16.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(111).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH1() {
        if (roomShape.get(112).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH1.setImage(new Image("images/seatSelected.png"));
                roomShape.get(112).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(112).getState() == 1) { //Selected
            seatH1.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(112).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH2() {
        if (roomShape.get(113).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(113).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(113).getState() == 1) { //Selected
            seatH2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(113).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH3() {
        if (roomShape.get(114).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH3.setImage(new Image("images/seatSelected.png"));
                roomShape.get(114).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(114).getState() == 1) { //Selected
            seatH3.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(114).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH4() {
        if (roomShape.get(115).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH4.setImage(new Image("images/seatSelected.png"));
                roomShape.get(115).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(115).getState() == 1) { //Selected
            seatH4.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(115).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH5() {
        if (roomShape.get(116).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH5.setImage(new Image("images/seatSelected.png"));
                roomShape.get(116).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(116).getState() == 1) { //Selected
            seatH5.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(116).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH6() {
        if (roomShape.get(117).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH6.setImage(new Image("images/seatSelected.png"));
                roomShape.get(117).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(117).getState() == 1) { //Selected
            seatH6.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(117).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH7() {
        if (roomShape.get(118).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH7.setImage(new Image("images/seatSelected.png"));
                roomShape.get(118).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(118).getState() == 1) { //Selected
            seatH7.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(118).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH8() {
        if (roomShape.get(119).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH8.setImage(new Image("images/seatSelected.png"));
                roomShape.get(119).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(119).getState() == 1) { //Selected
            seatH8.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(119).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH9() {
        if (roomShape.get(120).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH9.setImage(new Image("images/seatSelected.png"));
                roomShape.get(120).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(120).getState() == 1) { //Selected
            seatH9.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(120).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH10() {
        if (roomShape.get(121).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH10.setImage(new Image("images/seatSelected.png"));
                roomShape.get(121).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(121).getState() == 1) { //Selected
            seatH10.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(121).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH11() {
        if (roomShape.get(122).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH11.setImage(new Image("images/seatSelected.png"));
                roomShape.get(122).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(122).getState() == 1) { //Selected
            seatH11.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(122).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH12() {
        if (roomShape.get(123).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH12.setImage(new Image("images/seatSelected.png"));
                roomShape.get(123).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(123).getState() == 1) { //Selected
            seatH12.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(123).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH13() {
        if (roomShape.get(124).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH13.setImage(new Image("images/seatSelected.png"));
                roomShape.get(124).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(124).getState() == 1) { //Selected
            seatH13.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(124).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH14() {
        if (roomShape.get(125).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(125).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(125).getState() == 1) { //Selected
            seatH2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(125).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH15() {
        if (roomShape.get(126).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH15.setImage(new Image("images/seatSelected.png"));
                roomShape.get(126).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(126).getState() == 1) { //Selected
            seatH15.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(126).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoH16() {
        if (roomShape.get(127).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatH16.setImage(new Image("images/seatSelected.png"));
                roomShape.get(127).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(127).getState() == 1) { //Selected
            seatH16.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(127).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI1() {
        if (roomShape.get(128).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI1.setImage(new Image("images/seatSelected.png"));
                roomShape.get(128).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(128).getState() == 1) { //Selected
            seatI1.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(128).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI2() {
        if (roomShape.get(129).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(129).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(129).getState() == 1) { //Selected
            seatI2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(129).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI3() {
        if (roomShape.get(130).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI3.setImage(new Image("images/seatSelected.png"));
                roomShape.get(130).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(130).getState() == 1) { //Selected
            seatI3.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(130).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI4() {
        if (roomShape.get(131).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI4.setImage(new Image("images/seatSelected.png"));
                roomShape.get(131).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(131).getState() == 1) { //Selected
            seatI4.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(131).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI5() {
        if (roomShape.get(132).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI5.setImage(new Image("images/seatSelected.png"));
                roomShape.get(132).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(132).getState() == 1) { //Selected
            seatI5.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(132).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI6() {
        if (roomShape.get(133).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI6.setImage(new Image("images/seatSelected.png"));
                roomShape.get(133).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(133).getState() == 1) { //Selected
            seatI6.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(133).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI7() {
        if (roomShape.get(134).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI7.setImage(new Image("images/seatSelected.png"));
                roomShape.get(134).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(134).getState() == 1) { //Selected
            seatI7.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(134).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI8() {
        if (roomShape.get(135).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI8.setImage(new Image("images/seatSelected.png"));
                roomShape.get(135).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(135).getState() == 1) { //Selected
            seatI8.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(135).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI9() {
        if (roomShape.get(136).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI9.setImage(new Image("images/seatSelected.png"));
                roomShape.get(136).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(136).getState() == 1) { //Selected
            seatI9.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(136).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI10() {
        if (roomShape.get(137).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI10.setImage(new Image("images/seatSelected.png"));
                roomShape.get(137).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(137).getState() == 1) { //Selected
            seatI10.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(137).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI11() {
        if (roomShape.get(138).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI11.setImage(new Image("images/seatSelected.png"));
                roomShape.get(138).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(138).getState() == 1) { //Selected
            seatI11.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(138).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI12() {
        if (roomShape.get(139).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI12.setImage(new Image("images/seatSelected.png"));
                roomShape.get(139).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(139).getState() == 1) { //Selected
            seatI12.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(139).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI13() {
        if (roomShape.get(140).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI13.setImage(new Image("images/seatSelected.png"));
                roomShape.get(140).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(140).getState() == 1) { //Selected
            seatI13.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(140).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI14() {
        if (roomShape.get(141).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(141).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(141).getState() == 1) { //Selected
            seatI2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(141).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI15() {
        if (roomShape.get(142).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI15.setImage(new Image("images/seatSelected.png"));
                roomShape.get(142).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(142).getState() == 1) { //Selected
            seatI15.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(142).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoI16() {
        if (roomShape.get(143).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatI16.setImage(new Image("images/seatSelected.png"));
                roomShape.get(143).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(143).getState() == 1) { //Selected
            seatI16.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(143).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ1() {
        if (roomShape.get(144).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ1.setImage(new Image("images/seatSelected.png"));
                roomShape.get(144).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(144).getState() == 1) { //Selected
            seatJ1.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(144).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ2() {
        if (roomShape.get(145).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(145).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(145).getState() == 1) { //Selected
            seatJ2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(145).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ3() {
        if (roomShape.get(146).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ3.setImage(new Image("images/seatSelected.png"));
                roomShape.get(146).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(146).getState() == 1) { //Selected
            seatJ3.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(146).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ4() {
        if (roomShape.get(147).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ4.setImage(new Image("images/seatSelected.png"));
                roomShape.get(147).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(147).getState() == 1) { //Selected
            seatJ4.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(147).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ5() {
        if (roomShape.get(148).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ5.setImage(new Image("images/seatSelected.png"));
                roomShape.get(148).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(148).getState() == 1) { //Selected
            seatJ5.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(148).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ6() {
        if (roomShape.get(149).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ6.setImage(new Image("images/seatSelected.png"));
                roomShape.get(149).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(149).getState() == 1) { //Selected
            seatJ6.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(149).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ7() {
        if (roomShape.get(150).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ7.setImage(new Image("images/seatSelected.png"));
                roomShape.get(150).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(150).getState() == 1) { //Selected
            seatJ7.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(150).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ8() {
        if (roomShape.get(151).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ8.setImage(new Image("images/seatSelected.png"));
                roomShape.get(151).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(151).getState() == 1) { //Selected
            seatJ8.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(151).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ9() {
        if (roomShape.get(152).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ9.setImage(new Image("images/seatSelected.png"));
                roomShape.get(152).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(152).getState() == 1) { //Selected
            seatJ9.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(152).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ10() {
        if (roomShape.get(153).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ10.setImage(new Image("images/seatSelected.png"));
                roomShape.get(153).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(153).getState() == 1) { //Selected
            seatJ10.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(153).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ11() {
        if (roomShape.get(154).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ11.setImage(new Image("images/seatSelected.png"));
                roomShape.get(154).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(154).getState() == 1) { //Selected
            seatJ11.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(154).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ12() {
        if (roomShape.get(155).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ12.setImage(new Image("images/seatSelected.png"));
                roomShape.get(155).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(155).getState() == 1) { //Selected
            seatJ12.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(155).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ13() {
        if (roomShape.get(156).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ13.setImage(new Image("images/seatSelected.png"));
                roomShape.get(156).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(156).getState() == 1) { //Selected
            seatJ13.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(156).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ14() {
        if (roomShape.get(157).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(157).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(157).getState() == 1) { //Selected
            seatJ2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(157).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ15() {
        if (roomShape.get(158).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ15.setImage(new Image("images/seatSelected.png"));
                roomShape.get(158).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(158).getState() == 1) { //Selected
            seatJ15.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(158).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoJ16() {
        if (roomShape.get(159).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatJ16.setImage(new Image("images/seatSelected.png"));
                roomShape.get(159).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(159).getState() == 1) { //Selected
            seatJ16.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(159).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK1() {
        if (roomShape.get(160).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK1.setImage(new Image("images/seatSelected.png"));
                roomShape.get(160).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(160).getState() == 1) { //Selected
            seatK1.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(160).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK2() {
        if (roomShape.get(161).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(161).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(161).getState() == 1) { //Selected
            seatK2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(161).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK3() {
        if (roomShape.get(162).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK3.setImage(new Image("images/seatSelected.png"));
                roomShape.get(162).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(162).getState() == 1) { //Selected
            seatK3.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(162).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK4() {
        if (roomShape.get(163).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK4.setImage(new Image("images/seatSelected.png"));
                roomShape.get(163).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(163).getState() == 1) { //Selected
            seatK4.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(163).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK5() {
        if (roomShape.get(164).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK5.setImage(new Image("images/seatSelected.png"));
                roomShape.get(164).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(164).getState() == 1) { //Selected
            seatK5.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(164).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK6() {
        if (roomShape.get(165).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK6.setImage(new Image("images/seatSelected.png"));
                roomShape.get(165).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(165).getState() == 1) { //Selected
            seatK6.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(165).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK7() {
        if (roomShape.get(166).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK7.setImage(new Image("images/seatSelected.png"));
                roomShape.get(166).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(166).getState() == 1) { //Selected
            seatK7.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(166).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK8() {
        if (roomShape.get(167).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK8.setImage(new Image("images/seatSelected.png"));
                roomShape.get(167).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(167).getState() == 1) { //Selected
            seatK8.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(167).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK9() {
        if (roomShape.get(168).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK9.setImage(new Image("images/seatSelected.png"));
                roomShape.get(168).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(168).getState() == 1) { //Selected
            seatK9.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(168).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK10() {
        if (roomShape.get(169).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK10.setImage(new Image("images/seatSelected.png"));
                roomShape.get(169).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(169).getState() == 1) { //Selected
            seatK10.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(169).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK11() {
        if (roomShape.get(170).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK11.setImage(new Image("images/seatSelected.png"));
                roomShape.get(170).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(170).getState() == 1) { //Selected
            seatK11.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(170).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK12() {
        if (roomShape.get(171).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK12.setImage(new Image("images/seatSelected.png"));
                roomShape.get(171).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(171).getState() == 1) { //Selected
            seatK12.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(171).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK13() {
        if (roomShape.get(172).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK13.setImage(new Image("images/seatSelected.png"));
                roomShape.get(172).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(172).getState() == 1) { //Selected
            seatK13.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(172).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK14() {
        if (roomShape.get(173).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(173).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(173).getState() == 1) { //Selected
            seatK2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(173).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK15() {
        if (roomShape.get(174).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK15.setImage(new Image("images/seatSelected.png"));
                roomShape.get(174).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(174).getState() == 1) { //Selected
            seatK15.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(174).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoK16() {
        if (roomShape.get(175).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatK16.setImage(new Image("images/seatSelected.png"));
                roomShape.get(175).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(175).getState() == 1) { //Selected
            seatK16.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(175).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL1() {
        if (roomShape.get(176).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL1.setImage(new Image("images/seatSelected.png"));
                roomShape.get(176).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(176).getState() == 1) { //Selected
            seatL1.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(176).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL2() {
        if (roomShape.get(177).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(177).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(177).getState() == 1) { //Selected
            seatL2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(177).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL3() {
        if (roomShape.get(178).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL3.setImage(new Image("images/seatSelected.png"));
                roomShape.get(178).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(178).getState() == 1) { //Selected
            seatL3.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(178).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL4() {
        if (roomShape.get(179).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL4.setImage(new Image("images/seatSelected.png"));
                roomShape.get(179).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(179).getState() == 1) { //Selected
            seatL4.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(179).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL5() {
        if (roomShape.get(180).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL5.setImage(new Image("images/seatSelected.png"));
                roomShape.get(180).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(180).getState() == 1) { //Selected
            seatL5.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(180).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL6() {
        if (roomShape.get(181).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL6.setImage(new Image("images/seatSelected.png"));
                roomShape.get(181).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(181).getState() == 1) { //Selected
            seatL6.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(181).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL7() {
        if (roomShape.get(182).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL7.setImage(new Image("images/seatSelected.png"));
                roomShape.get(182).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(182).getState() == 1) { //Selected
            seatL7.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(182).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL8() {
        if (roomShape.get(183).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL8.setImage(new Image("images/seatSelected.png"));
                roomShape.get(183).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(183).getState() == 1) { //Selected
            seatL8.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(183).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL9() {
        if (roomShape.get(184).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL9.setImage(new Image("images/seatSelected.png"));
                roomShape.get(184).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(184).getState() == 1) { //Selected
            seatL9.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(184).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL10() {
        if (roomShape.get(185).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL10.setImage(new Image("images/seatSelected.png"));
                roomShape.get(185).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(185).getState() == 1) { //Selected
            seatL10.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(185).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL11() {
        if (roomShape.get(186).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL11.setImage(new Image("images/seatSelected.png"));
                roomShape.get(186).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(186).getState() == 1) { //Selected
            seatL11.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(186).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL12() {
        if (roomShape.get(187).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL12.setImage(new Image("images/seatSelected.png"));
                roomShape.get(187).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(187).getState() == 1) { //Selected
            seatL12.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(187).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL13() {
        if (roomShape.get(188).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL13.setImage(new Image("images/seatSelected.png"));
                roomShape.get(188).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(188).getState() == 1) { //Selected
            seatL13.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(188).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL14() {
        if (roomShape.get(189).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(189).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(189).getState() == 1) { //Selected
            seatL2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(189).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL15() {
        if (roomShape.get(190).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL15.setImage(new Image("images/seatSelected.png"));
                roomShape.get(190).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(190).getState() == 1) { //Selected
            seatL15.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(190).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoL16() {
        if (roomShape.get(191).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatL16.setImage(new Image("images/seatSelected.png"));
                roomShape.get(191).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(191).getState() == 1) { //Selected
            seatL16.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(191).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM1() {
        if (roomShape.get(192).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM1.setImage(new Image("images/seatSelected.png"));
                roomShape.get(192).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(192).getState() == 1) { //Selected
            seatM1.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(192).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM2() {
        if (roomShape.get(193).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(193).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(193).getState() == 1) { //Selected
            seatM2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(193).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM3() {
        if (roomShape.get(194).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM3.setImage(new Image("images/seatSelected.png"));
                roomShape.get(194).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(194).getState() == 1) { //Selected
            seatM3.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(194).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM4() {
        if (roomShape.get(195).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM4.setImage(new Image("images/seatSelected.png"));
                roomShape.get(195).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(195).getState() == 1) { //Selected
            seatM4.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(195).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM5() {
        if (roomShape.get(196).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM5.setImage(new Image("images/seatSelected.png"));
                roomShape.get(196).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(196).getState() == 1) { //Selected
            seatM5.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(196).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM6() {
        if (roomShape.get(197).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM6.setImage(new Image("images/seatSelected.png"));
                roomShape.get(197).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(197).getState() == 1) { //Selected
            seatM6.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(197).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM7() {
        if (roomShape.get(198).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM7.setImage(new Image("images/seatSelected.png"));
                roomShape.get(198).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(198).getState() == 1) { //Selected
            seatM7.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(198).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM8() {
        if (roomShape.get(199).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM8.setImage(new Image("images/seatSelected.png"));
                roomShape.get(199).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(199).getState() == 1) { //Selected
            seatM8.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(199).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM9() {
        if (roomShape.get(200).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM9.setImage(new Image("images/seatSelected.png"));
                roomShape.get(200).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(200).getState() == 1) { //Selected
            seatM9.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(200).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM10() {
        if (roomShape.get(201).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM10.setImage(new Image("images/seatSelected.png"));
                roomShape.get(201).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(201).getState() == 1) { //Selected
            seatM10.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(201).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM11() {
        if (roomShape.get(202).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM11.setImage(new Image("images/seatSelected.png"));
                roomShape.get(202).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(202).getState() == 1) { //Selected
            seatM11.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(202).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM12() {
        if (roomShape.get(203).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM12.setImage(new Image("images/seatSelected.png"));
                roomShape.get(203).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(203).getState() == 1) { //Selected
            seatM12.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(203).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM13() {
        if (roomShape.get(204).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM13.setImage(new Image("images/seatSelected.png"));
                roomShape.get(204).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(204).getState() == 1) { //Selected
            seatM13.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(204).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM14() {
        if (roomShape.get(205).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(205).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(205).getState() == 1) { //Selected
            seatM2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(205).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM15() {
        if (roomShape.get(206).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM15.setImage(new Image("images/seatSelected.png"));
                roomShape.get(206).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(206).getState() == 1) { //Selected
            seatM15.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(206).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoM16() {
        if (roomShape.get(207).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatM16.setImage(new Image("images/seatSelected.png"));
                roomShape.get(207).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(207).getState() == 1) { //Selected
            seatM16.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(207).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN1() {
        if (roomShape.get(208).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN1.setImage(new Image("images/seatSelected.png"));
                roomShape.get(208).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(208).getState() == 1) { //Selected
            seatN1.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(208).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN2() {
        if (roomShape.get(209).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(209).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(209).getState() == 1) { //Selected
            seatN2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(209).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN3() {
        if (roomShape.get(210).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN3.setImage(new Image("images/seatSelected.png"));
                roomShape.get(210).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(210).getState() == 1) { //Selected
            seatN3.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(210).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN4() {
        if (roomShape.get(211).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN4.setImage(new Image("images/seatSelected.png"));
                roomShape.get(211).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(211).getState() == 1) { //Selected
            seatN4.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(211).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN5() {
        if (roomShape.get(212).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN5.setImage(new Image("images/seatSelected.png"));
                roomShape.get(212).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(212).getState() == 1) { //Selected
            seatN5.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(212).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN6() {
        if (roomShape.get(213).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN6.setImage(new Image("images/seatSelected.png"));
                roomShape.get(213).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(213).getState() == 1) { //Selected
            seatN6.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(213).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN7() {
        if (roomShape.get(214).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN7.setImage(new Image("images/seatSelected.png"));
                roomShape.get(214).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(214).getState() == 1) { //Selected
            seatN7.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(214).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN8() {
        if (roomShape.get(215).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN8.setImage(new Image("images/seatSelected.png"));
                roomShape.get(215).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(215).getState() == 1) { //Selected
            seatN8.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(215).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN9() {
        if (roomShape.get(216).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN9.setImage(new Image("images/seatSelected.png"));
                roomShape.get(216).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(216).getState() == 1) { //Selected
            seatN9.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(216).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN10() {
        if (roomShape.get(217).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN10.setImage(new Image("images/seatSelected.png"));
                roomShape.get(217).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(217).getState() == 1) { //Selected
            seatN10.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(217).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN11() {
        if (roomShape.get(218).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN11.setImage(new Image("images/seatSelected.png"));
                roomShape.get(218).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(218).getState() == 1) { //Selected
            seatN11.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(218).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN12() {
        if (roomShape.get(219).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN12.setImage(new Image("images/seatSelected.png"));
                roomShape.get(219).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(219).getState() == 1) { //Selected
            seatN12.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(219).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN13() {
        if (roomShape.get(220).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN13.setImage(new Image("images/seatSelected.png"));
                roomShape.get(220).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(220).getState() == 1) { //Selected
            seatN13.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(220).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN14() {
        if (roomShape.get(221).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN2.setImage(new Image("images/seatSelected.png"));
                roomShape.get(221).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(221).getState() == 1) { //Selected
            seatN2.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(221).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN15() {
        if (roomShape.get(222).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN15.setImage(new Image("images/seatSelected.png"));
                roomShape.get(222).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(222).getState() == 1) { //Selected
            seatN15.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(222).setState(0);
            decreaseSeatCount();
        }
    }

    public void seleccionarAsientoN16() {
        if (roomShape.get(223).getState() == 0) { //Available
            if (seatCount < seatsToReserve) {
                seatN16.setImage(new Image("images/seatSelected.png"));
                roomShape.get(223).setState(1);
                increaseSeatCount();
            } else {
                //Pop up
            }
        } else if (roomShape.get(223).getState() == 1) { //Selected
            seatN16.setImage(new Image("images/seatAvailable.png"));
            roomShape.get(223).setState(0);
            decreaseSeatCount();
        }
    }

    @FXML
    private Text confText1;
    @FXML
    private Text confText2;
    @FXML
    private Text confText3;
    @FXML
    private Text confText4;
    @FXML
    private Text confText5;

    public void cargarLocales(String cine) {
        selectLocal.getItems().clear();
        System.out.println("this.movid " + (this.movid) + "this.fechaSeleccionada " + this.fechaSeleccionada + " cine " + cine);
        String urlserverSer = urlserver + "/locals/movie/cinema?movie_id=" + (this.movid) + "&date=" + this.fechaSeleccionada + "&empr_name=" + cine;
        ResponseEntity<List<String>> rateResponse = restTemplate.exchange(urlserverSer, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
        });
        List<String> locales = rateResponse.getBody();
        System.out.println(locales);
        EventHandler<ActionEvent> action = setTextOnMenu();
        selectLocal.getItems().clear();

//        Eliminando duplicados de local
        List<String> listWithDuplicates = locales;
        List<String> listWithoutDuplicates = new ArrayList<>(
                new HashSet<>(listWithDuplicates));

        for (String loc : listWithoutDuplicates) {
            MenuItem locationMI = new MenuItem(loc);
            locationMI.setOnAction(action);
            selectLocal.getItems().add(locationMI);
        }
    }


    private EventHandler<ActionEvent> setTextOnMenu() {
        Controller self = this;
        EventHandler<ActionEvent> p = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                MenuItem mItem = (MenuItem) event.getSource();
                String side = mItem.getText();
                selectLocal.setText(side);
                Controller.this.localString = side;
                listHorarios();
            }
        };

        return p;
    }

    public void listHorarios() {
        System.out.println("FECHA SELECCIONADA " + this.fechaSeleccionada);
        String urlToHorarios = urlserver + "/times/movie/locals?movie_id=" + (this.movid) + "&date=" + this.fechaSeleccionada + "&empr_name=" + this.cineselec + "&empr_local=" + this.localString;
        ResponseEntity<List<MovieFunction>> horarios = restTemplate.exchange(urlToHorarios, HttpMethod.GET, null, new ParameterizedTypeReference<List<MovieFunction>>() {
        });
        List<MovieFunction> functions = horarios.getBody();
        this.movieFunctionsList = functions;
        System.out.println("FUNCIONES " + functions + "TAM " + functions.size());
        try {
            list_view_horarios.getItems().clear();
            list_view_horarios.setVisible(true);
            if (functions.size() == 0) {
                list_view_horarios.getItems().add("No hay funciones disponibles en el local seleccionado");
                list_view_horarios.setDisable(true);
            } else {
                list_view_horarios.setDisable(false);
                for (MovieFunction f : functions) {
                    try {
                        list_view_horarios.getItems().add(f.getSchedule_time() + " en sala " + f.getRoom_id() + " -" + f.getFunction_id() + "-" + f.getFunction_id() + "");
                    } catch (Exception e) {
                    }
                }
                list_view_horarios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov,
                                        final String oldvalue, final String newvalue) {
                        setFunctionOnContext(ov, oldvalue, newvalue);
                    }
                });
            }
        } catch (Exception e) {

        }
        /**/
    }

    private void setFunctionOnContext(ObservableValue<? extends String> ov, String oldvalue, String newvalue) {
        System.out.println("OLD VALUE = " + oldvalue + " NEW VALUE = " + newvalue);
        String fnIdToFind = "";
        fnIdToFind = newvalue.split("-")[2];

        System.out.println("fnIdToFind " + fnIdToFind);
        MovieFunction mfSelected = null;
        for (MovieFunction mf : this.movieFunctionsList) {
            if (mf.getFunction_id() == Integer.parseInt(fnIdToFind)) {
                mfSelected = mf;
                break;
            }
        }
        System.out.println("MF SELECTED " + mfSelected);
        this.selectedFunction = mfSelected;

    }


    @FXML
    private TextField ubicacionfuncion;
    @FXML
    private TextField horariofuncion;
    @FXML
    private TextField salafuncion;
    @FXML
    private TextField nombrepelifncion;
    @FXML
    private MenuButton cinefuncion;
    @FXML
    private ListView reservaListView;

    public void entradaComprada(MouseEvent evento) {
        pan7.setVisible(true);
        pan1.setVisible(false);
        pan8.setVisible(false);
        pan2.setVisible(false);
        pan3.setVisible(false);
        pan4.setVisible(false);
        pan5.setVisible(false);
        pan51.setVisible(false);
        pan6.setVisible(false);

//        Cargar reservas
        try {
//            ResponseEntity<List<Reserva>> rateResponse = restTemplate.exchange(urlserver + "/list/reservas?limit=22", HttpMethod.GET, null, new ParameterizedTypeReference<List<Reserva>>() {
//            });
            List<Reserva> reservas = getReservasDelCine();// rateResponse.getBody();
            System.out.println("size de reservas " + reservas.size());


            ObservableList<Reserva> data = FXCollections.observableArrayList(reservas);
            FilteredList<Reserva> filteredData = new FilteredList<>(data, s -> true);
            reservaListView.getItems().clear();
            for (Reserva r : data) {
                try {
                    reservaListView.getItems().add("ID:" + r.getReserva_id() + " - Function:" + r.getFunction_id() + " -Asientos: " + r.getAsientos());
                } catch (Exception e) {
                }
            }

        } catch (Exception e) {
        }
    }

    public void crearFuncion(MouseEvent evento) {
        try {
            String urlFuncion = urlserver + "upload/funcion";
            Movie mov = (Movie) listadoPeliculas.getSelectionModel().getSelectedItem();
            int roomid = Integer.parseInt(this.salaFuncion.getText().split("-")[0]);
            String selectedCinema = this.cinefuncion.getText().split("-")[2];
            String horarioSeleccionado = this.horariofuncion.getText();
//            MovieFunction movFuncToCreate = MovieFunction.builder().
//                    empr_id(Integer.parseInt(selectedCinema)).movie_id(mov.getMovie_id()).room_id(roomid).schedule_date(new Date("11/11/2019")).schedule_time(horarioSeleccionado).build();

            LocalDate dateHasta = hastafuncion.getValue();
            LocalDate dateDesde = desdefuncion.getValue();

            LocalDate dateStep = dateDesde;
            while (dateStep.isBefore(dateHasta)) {
                DayOfWeek diaDeSemana = dateStep.getDayOfWeek();
                if (diaDeSemana == DayOfWeek.MONDAY && lunesf.isSelected()) {
                    Date date = Date.from(dateStep.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    MovieFunction movFuncToCreate = MovieFunction.builder().
                            empr_id(Integer.parseInt(selectedCinema)).movie_id(mov.getMovie_id()).room_id(roomid).schedule_date(date).schedule_time(horarioSeleccionado).build();
                    HttpEntity<MovieFunction> request = new HttpEntity<>(movFuncToCreate);
                    URI location = restTemplate.postForLocation(urlFuncion, request);
                } else if (diaDeSemana == DayOfWeek.TUESDAY && martesf.isSelected()) {
                    Date date = Date.from(dateStep.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    MovieFunction movFuncToCreate = MovieFunction.builder().
                            empr_id(Integer.parseInt(selectedCinema)).movie_id(mov.getMovie_id()).room_id(roomid).schedule_date(date).schedule_time(horarioSeleccionado).build();
                    HttpEntity<MovieFunction> request = new HttpEntity<>(movFuncToCreate);
                    URI location = restTemplate.postForLocation(urlFuncion, request);
                } else if (diaDeSemana == DayOfWeek.WEDNESDAY && miercolesf.isSelected()) {
                    Date date = Date.from(dateStep.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    MovieFunction movFuncToCreate = MovieFunction.builder().
                            empr_id(Integer.parseInt(selectedCinema)).movie_id(mov.getMovie_id()).room_id(roomid).schedule_date(date).schedule_time(horarioSeleccionado).build();
                    HttpEntity<MovieFunction> request = new HttpEntity<>(movFuncToCreate);
                    URI location = restTemplate.postForLocation(urlFuncion, request);
                } else if (diaDeSemana == DayOfWeek.THURSDAY && juevesf.isSelected()) {
                    Date date = Date.from(dateStep.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    MovieFunction movFuncToCreate = MovieFunction.builder().
                            empr_id(Integer.parseInt(selectedCinema)).movie_id(mov.getMovie_id()).room_id(roomid).schedule_date(date).schedule_time(horarioSeleccionado).build();
                    HttpEntity<MovieFunction> request = new HttpEntity<>(movFuncToCreate);
                    URI location = restTemplate.postForLocation(urlFuncion, request);
                } else if (diaDeSemana == DayOfWeek.FRIDAY && viernesf.isSelected()) {
                    Date date = Date.from(dateStep.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    MovieFunction movFuncToCreate = MovieFunction.builder().
                            empr_id(Integer.parseInt(selectedCinema)).movie_id(mov.getMovie_id()).room_id(roomid).schedule_date(date).schedule_time(horarioSeleccionado).build();
                    HttpEntity<MovieFunction> request = new HttpEntity<>(movFuncToCreate);
                    URI location = restTemplate.postForLocation(urlFuncion, request);
                } else if (diaDeSemana == DayOfWeek.SATURDAY && sabadof.isSelected()) {
                    Date date = Date.from(dateStep.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    MovieFunction movFuncToCreate = MovieFunction.builder().
                            empr_id(Integer.parseInt(selectedCinema)).movie_id(mov.getMovie_id()).room_id(roomid).schedule_date(date).schedule_time(horarioSeleccionado).build();
                    HttpEntity<MovieFunction> request = new HttpEntity<>(movFuncToCreate);
                    URI location = restTemplate.postForLocation(urlFuncion, request);
                } else if (diaDeSemana == DayOfWeek.SUNDAY && domingof.isSelected()) {
                    Date date = Date.from(dateStep.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    MovieFunction movFuncToCreate = MovieFunction.builder().
                            empr_id(Integer.parseInt(selectedCinema)).movie_id(mov.getMovie_id()).room_id(roomid).schedule_date(date).schedule_time(horarioSeleccionado).build();
                    HttpEntity<MovieFunction> request = new HttpEntity<>(movFuncToCreate);
                    URI location = restTemplate.postForLocation(urlFuncion, request);
                }
                dateStep = dateStep.plusDays(1);
            }


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Funcion(es) Creada(s)");
            alert.setHeaderText("Funcion(es) Creada(s)!");
            alert.setContentText("click en 'aceptar' para crar otra Funcion ");
            alert.showAndWait();
        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Funcion NO Creada");
            alert.setHeaderText("Funcion NO Creada!");
            alert.setContentText("click en 'aceptar' para crar otra Funcion ");
            alert.showAndWait();
            throw e;
        }

    }

    public void registrarse(MouseEvent evento) {
        pan1.setVisible(false);
        pan6.setVisible(true);
        pan8.setVisible(false);
    }

    @FXML
    ListView listadoPeliculas;
    @FXML
    private TextField nombrecu;
    @FXML
    private TextField mailcu;
    @FXML
    private TextField contrasenacu;
    @FXML
    private TextField contrasena2cu;
    @FXML
    private TextField codcu;

    public void registroeiniciar(MouseEvent event) {
        String nombre = nombrecu.getText();
        String mail = mailcu.getText();
        String contraseña = contrasenacu.getText();
        String contraseña2 = contrasena2cu.getText();
        String codigo = codcu.getText() == "" ? null : codcu.getText();
        if (contraseña2.equals(contraseña)) {
            User usuario = User.builder().name(nombre).email(mail).pass(contraseña).empr_name(codigo).build();
            HttpEntity<User> request = new HttpEntity<>(usuario);
            URI location = restTemplate
                    .postForLocation(this.urlserver + " /upload/user", request);

            iniciarMenuCorrespondiente();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Contraseñas No Coinciden");
            alert.setHeaderText("Contraseñas No Coinciden");
            alert.setContentText("Por favor, intente de nuevo con más cuidado");

            alert.showAndWait();
        }

    }

    @FXML
    private TextField iniciarcorreo;
    @FXML
    private PasswordField iniciarcontrasena;

    public void inicioValido(MouseEvent evento) {
        String contrasena = iniciarcontrasena.getText();
        String correo = iniciarcorreo.getText();

        User attempt = User.builder().email(correo).pass(contrasena).build();
        User status = null;
        HttpEntity<User> request = new HttpEntity<>(attempt);

        ResponseEntity<User> location = restTemplate
                .postForEntity(urlserver + "/login", request, User.class);
        status = location.getBody();
        this.userLogged = status;
        if (this.userLogged != null) {
            System.out.print("USUARIO LOGUEADO es" + this.userLogged.getUid());
            iniciarMenuCorrespondiente();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Contraseñas No Coinciden");
            alert.setHeaderText("Contraseñas No Coinciden");
            alert.setContentText("Por favor, intente de nuevo con más cuidado");

            alert.showAndWait();
        }
    }

    private int weekDayPrice2D = 100;
    private int weekDayPrice3D = 150;
    private int weekEndPrice2D = 150;
    private int weekEndPrice3D = 200;
    private int finalPrice;

    public void popConfirm() {
        ArrayList<Seat> selectedSeat = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        confText1.setText(this.selectedMovie.getTitle());
        confText2.setText(selectCine.getText());
        confText3.setText(this.fechaSeleccionada + " - " + this.selectedTime);
        System.out.println("ASIENTOS SELECCIONADOS " + this.asientosSeleccionados);
        asientoselec = "";
        for (Seat s : this.asientosSeleccionados) {
            if (asientoselec.length() > 1) {
                asientoselec += "," + s.getPos();
            } else {
                asientoselec = s.getPos();
            }
        }

        confText4.setText(asientoselec);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate selDate = LocalDate.parse(this.fechaSeleccionada, formatter1);
        DayOfWeek diaSem = selDate.getDayOfWeek();

// Obteniendo la sala de la funcion

        ResponseEntity<Room> rateResponse = restTemplate.exchange(urlserver + "/show/room/function?function_id=" + this.selectedFunction.getFunction_id(), HttpMethod.GET, null, new ParameterizedTypeReference<Room>() {
        });
        this.selectedRoom = rateResponse.getBody();
        if (diaSem.equals(DayOfWeek.MONDAY) || diaSem.equals(DayOfWeek.TUESDAY) || diaSem.equals(DayOfWeek.WEDNESDAY)) {
            if (this.selectedRoom.getType().equals("2D")) {
                finalPrice = weekDayPrice2D;
            } else {
                finalPrice = weekDayPrice3D;
            }
        } else if (diaSem.equals(DayOfWeek.THURSDAY) || diaSem.equals(DayOfWeek.FRIDAY) || diaSem.equals(DayOfWeek.SATURDAY) || diaSem.equals(DayOfWeek.SUNDAY)) {
            if (this.selectedRoom.getType().equals("2D")) {
                finalPrice = weekEndPrice2D;
            } else {
                finalPrice = weekEndPrice3D;
            }
        }
        System.out.print("this.qty " + this.qty);
        this.finalPrice  = finalPrice * this.qty;
        confText5.setText("$" + String.valueOf(this.finalPrice));
    }

    public boolean crearCorreo(Correo c) throws MessagingException {
        try {
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "8099");
            p.setProperty("mail.smtp.user", c.getUsuarioCorreo());
            p.setProperty("mail.smtp.auth", "true");

            Session s = Session.getDefaultInstance(p, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(c.getMensaje());
            BodyPart adjunto = new MimeBodyPart();

//            if (!c.getRutaArchivo().equals("")) {
//                adjunto.setDataHandler(new DataHandler(new FileDataSource(c.getRutaArchivo())));
//                adjunto.setFileName(c.getNombreArchivo());
//            }
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);

//            if (!c.getRutaArchivo().equals("")) {
//                m.addBodyPart(adjunto);
//            }
            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(c.getUsuarioCorreo()));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress((c.getDestino())));
            mensaje.setContent(m);

            Transport t = s.getTransport("smtp");
            t.connect(c.getUsuarioCorreo(), c.getContrasena());
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            return true;

        } catch (Exception e) {
            System.out.println("Error: " + e);
            throw e;
//            return false;
        }

//        return false;
    }

    public Correo enviarCorreo() {
        Correo c = new Correo();
        c.setContrasena("skyktpxsuoiabcgf");
        c.setUsuarioCorreo("peep.juanchi@gmail.com");
        c.setAsunto("Compra");
        c.setMensaje("Usted ha realiazado una compra en MoViX para " + this.selectedMovie.getTitle() + " para el dia " + this.fechaSeleccionada + " - " + this.selectedTime);
        c.setDestino(iniciarcorreo.getText().trim());
//        c.setRutaArchivo("qr.png");
        return c;
    }

    @FXML
    private AnchorPane pan8;
    @FXML
    ListView miscompras;

    public void verCompras(MouseEvent evento) {
        System.out.print("VER COMPRAS");
        pan1.setVisible(false);
        pan2.setVisible(false);
        pan3.setVisible(false);
        pan4.setVisible(false);
        pan51.setVisible(false);
        pan5.setVisible(false);
        pan6.setVisible(false);
        pan7.setVisible(false);
        pan8.setVisible(true);
        miscompras.getItems().clear();
        List<Reserva> userReservas = getReservasDelUsuario();
        for (Reserva r : userReservas) {
            miscompras.getItems().add("Reserva:" + r.getReserva_id() + " Asientos:" + r.getAsientos() + "");
        }
    }
    @FXML
    private AnchorPane filtroback;

    public void outFiltros(MouseEvent evento) throws IOException {
        this.offset = 0;
        cargarListadoPeliculas(this.offset, null);
        this.moviesCONST = listarPeliculas(null, this.offset);
    }


}