package com.um.lab.movix.movix.requests;

import com.um.lab.movix.movix.entities.*;
import com.um.lab.movix.movix.enums.Genres;
import com.um.lab.movix.movix.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;
import sun.security.provider.SHA;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.um.lab.movix.movix.utils.Utils.*;

@RestController
public class Router {


    public Router() {

    }

    @Autowired
    private MovieEmprRepo movieEmprRepo;
    @Autowired
    private MovieFunctionRepo movieFunctionRepo;
    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private RoomRepo roomRepo;
    @Autowired
    private ReservaRepo reservaRepo;
    @Autowired
    private UserRepo userRepo;

    @RequestMapping({"/"})
    public String hello() {
        return "Hello, the path specified doesn't seems to be right, try looking into the documentation and try again.";
    }


    @RequestMapping(value = "/list/rooms", method = RequestMethod.GET)
    public ArrayList<Room> reportingRooms(@RequestParam(value = "limit", required = false) String parameter) {
        if (parameter != null) {
            int offset = Integer.parseInt(parameter, 10);
        }
        ArrayList<Room> rooms = (ArrayList<Room>) roomRepo.findAll();
        return rooms;
    }

    @RequestMapping(value = "upload/movie", method = RequestMethod.POST)
    public String uploadMovieGetInfo(
            @RequestBody Movie newMovie
    ) {
        String ret = "";
        boolean success = false;
        try {

            success = true;
            movieRepo.save(newMovie);
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        } finally {
            ret = success ? "Your movie " + newMovie.getTitle() + " has been uploaded successfully" : " We couldn't upload the movie";
        }

        return ret;
    }

    @RequestMapping(value = "upload/room", method = RequestMethod.POST)
    public String uploadRoomGetInfo(
            @RequestBody Room newRoom


    ) {
        String result = "";
        try {

            roomRepo.save(newRoom);
            result += "La sala se ha creado correctamente";
        } catch (Exception e) {
            result += "La sala no se pudo crear";
        }
        return result;
    }

    @RequestMapping(value = "/list/movie/search", method = RequestMethod.GET)
    public ArrayList<Movie> reportingMoviesSearch(
            @RequestParam(value = "limit", required = false) String parameter,
            @RequestParam(value = "name", required = false) String title,
            @RequestParam(value = "genre", required = false) String genre) {
        if (parameter != null) {
            int offset = Integer.parseInt(parameter, 10);
        }

        ArrayList<Movie> movieList;
        if (title != null && genre == null) {
            movieList = (ArrayList<Movie>) movieRepo.findByTitle(title);
        } else if (title == null && genre != null) {

            movieList = (ArrayList<Movie>) movieRepo.findByGenre(genre);
        } else {
//            Filtro por nombre y genero
            movieList = null;
        }
        return movieList;
    }

    @RequestMapping(value = "/list/movie", method = RequestMethod.GET)
    public List<Movie> reportingMoviesSearch(
            @RequestParam(value = "limit", required = false) String parameter) {
        int offset = 0;
        if (parameter != null) {
            offset = Integer.parseInt(parameter, 10);
        }
        Pageable limit = PageRequest.of(offset, 8);
        Page<Movie> movieList = movieRepo.findAll(limit);
        List<Movie> movieListArray = movieList.getContent();

        return movieListArray;
    }

    @RequestMapping(value = "/list/movieTimes", method = RequestMethod.GET)
    public ArrayList<MovieFunction> listMovieTimes(
            @RequestParam(value = "movie_id", required = false) int parameter) {

        ArrayList<MovieFunction> movieEmprList = (ArrayList<MovieFunction>) movieFunctionRepo.findById(parameter);

        System.out.println(movieEmprList.get(0).getSchedule_time());

        return movieEmprList;
    }

    @RequestMapping(value = "/list/cinemas", method = RequestMethod.GET)
    public Optional<MovieEmpr> listCinemas(
            @RequestParam(value = "empr_id", required = false) int parameter) {

        Optional<MovieEmpr> movieEmprList = movieEmprRepo.findById(parameter);


        return movieEmprList;
    }

    @RequestMapping(value = "/times/movie/locals", method = RequestMethod.GET)
    public List<MovieFunction> horariosDisp(
            @RequestParam(value = "movie_id", required = false) int movie_id
            , @RequestParam(value = "date", required = false) String string_date
            , @RequestParam(value = "empr_name", required = true) String empr_name
            , @RequestParam(value = "empr_local", required = true) String empr_local) {

        String sDate1 = string_date.split("-")[0] + "/" + string_date.split("-")[1] + "/" + string_date.split("-")[2];
        ArrayList<String> lstStr = new ArrayList<>();
        List<MovieFunction> movieFunctionList = null;
        try {
            Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
            System.out.println(sDate1);

            System.out.println(date1);

            movieFunctionList = movieFunctionRepo.horariosEnDia_CineYlocal(movie_id, date1, empr_name, empr_local);

            for (MovieFunction mfunc : movieFunctionList) {
                lstStr.add(mfunc.getSchedule_time());
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return movieFunctionList;
    }

    @RequestMapping(value = "/locals/movie/cinema", method = RequestMethod.GET)
    public List<String> localsCineMoive(
            @RequestParam(value = "movie_id", required = false) String movie_id
            , @RequestParam(value = "date", required = false) String string_date
            , @RequestParam(value = "empr_name", required = true) String empr_name) {
        System.out.println("movie_id " + movie_id + " string_date " + string_date + "empr_name " + empr_name);
        Date date = new Date();
//        date.setYear(Integer.parseInt(string_date.split("-")[0]));
//        date.setMonth(Integer.parseInt(string_date.split("-")[1]));
//        date.setDate(Integer.parseInt(string_date.split("-")[2]));

        String sDate1 ="";
        ArrayList<String> lstStr = new ArrayList<>();
        try{
            sDate1 = string_date.split("-")[0] + "/" + string_date.split("-")[1] + "/" + string_date.split("-")[2];

        }catch(Exception e ){}
        try {

            Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);

            System.out.println(date);

            List<MovieEmpr> movieEmprList = movieFunctionRepo.localesEnCinePeliculaDia(Integer.parseInt(movie_id), date1, empr_name);

            for (MovieEmpr mempr : movieEmprList) {
                lstStr.add(mempr.getEmpr_locals());
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return lstStr;
    }

    @RequestMapping(value = "/list/reservas", method = RequestMethod.GET)
    public ArrayList<Reserva> reportingReservas(
            @RequestParam(value = "limit", required = false) String parameter) {
        if (parameter != null) {
            int offset = Integer.parseInt(parameter, 10);
        }

        ArrayList<Reserva> reservaList = (ArrayList<Reserva>) reservaRepo.findAll();

        return reservaList;
    }

    @RequestMapping(value = "/list/empr", method = RequestMethod.GET)
    public ArrayList<MovieEmpr> reportingEmprs(
            @RequestParam(value = "limit", required = false) String parameter) {
        if (parameter != null) {
            int offset = Integer.parseInt(parameter, 10);
        }

        ArrayList<MovieEmpr> movieEmprList = (ArrayList<MovieEmpr>) movieEmprRepo.findAll();

        return movieEmprList;
    }

    @RequestMapping(value = "/list/empr/useradm", method = RequestMethod.GET)
    public ArrayList<MovieEmpr> reportingEmprsADM(
            @RequestParam(value = "empr_name", required = false) String parameter) {


        ArrayList<MovieEmpr> movieEmprList = (ArrayList<MovieEmpr>) movieEmprRepo.findLocalesEmpr(parameter);
//        ArrayList<MovieEmpr> movieEmprList = (ArrayList<MovieEmpr>) movieEmprRepo.findAll();
        return movieEmprList;
    }


    @RequestMapping(value = "/upload/reserva", method = RequestMethod.POST)
    public String createReserva(@RequestBody Reserva newReserva) {

        String success = "";


        try {
            reservaRepo.save(newReserva);
            success += "Su reserva se efectuo correctamente";
        } catch (Exception e) {
            success = "Su reserva no pudo efectuarse";
        }
        return success;


    }

    @RequestMapping(value = "/upload/funcion", method = RequestMethod.POST)
    public String createSingleFunction(@RequestBody MovieFunction newFunction) {

        String success = "";


        try {
            movieFunctionRepo.save(newFunction);
            success += "Su funcion se cargo correctamente, estara disponible a partir de este momento";
        } catch (Exception e) {
            success = "Su funcion NO se cargo correctamente, por tanto no estara disponible.";
        }
        return success;


    }

    @RequestMapping(value = "/upload/user", method = RequestMethod.POST)
    public String createSingleUser(@RequestBody User newUser) {

        String success = "";


        try {
            String oldPasswd = newUser.getPass();
            String newPass = enocedPass(oldPasswd);
            newUser.setPass(newPass);
            if (newUser.getEmpr_name() != null) {
                if (newUser.getEmpr_name().equals("movieadm")) {
                    newUser.setEmpr_name("MovieCenter");
                    newUser.setUtype("a");
                } else if (newUser.getEmpr_name().equals("grupoadm")) {
                    newUser.setEmpr_name("Grupocine");
                    newUser.setUtype("a");
                } else if (newUser.getEmpr_name().equals("developer")) {
                    newUser.setEmpr_name(null);
                    newUser.setUtype("i");
                } else {
                    newUser.setEmpr_name(null);
                    newUser.setUtype("a");
                }
            } else {
                newUser.setUtype("c");
            }
            userRepo.save(newUser);
            success += "Usuario registrado";
        } catch (Exception e) {
            success = "No se pudo registrar al usuario";
        }
        return success;


    }

    @RequestMapping(value = "/list/roomsFromCinema", method = RequestMethod.GET)
    public ArrayList<Room> reportingRoomFromEmpr(
            @RequestParam(value = "empr_id", required = true) int parameter) {
        ArrayList<Room> roomList = (ArrayList<Room>) roomRepo.roomsFromCine(parameter);
        return roomList;
    }

    private static String enocedPass(String pass) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        String encodedhash = Arrays.toString(digest.digest(
                pass.getBytes(StandardCharsets.UTF_8)));
        System.out.println(encodedhash);
        return encodedhash;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User logIn(@RequestBody User attempt) throws Exception {
        User success = null;
        try {
            User userlogged;
            String oldPass = attempt.getPass();
            attempt.setPass(enocedPass(oldPass));
            List<User> userloggins = userRepo.loguserIn(attempt.getEmail(), attempt.getPass());
            System.out.println(" SIZE USERS " + userloggins.size());
            if (userloggins != null && userloggins.size() > 0) {
                userlogged = userloggins.get(0);
                success = userlogged;
            } else {
                throw new Exception("Ususario y contrasenia invalidos");
            }
        } catch (Exception e) {

            success = null;
        }
        return success;


    }

    @RequestMapping(value = "/list/resercas/funcion", method = RequestMethod.GET)
    public ArrayList<Reserva> reportingReservasDeFuncion(
            @RequestParam(value = "function_id", required = true) int parameter) {
        ArrayList<Reserva> reservaList = (ArrayList<Reserva>) reservaRepo.reservasDeFuncion(parameter);
        return reservaList;
    }

    @RequestMapping(value = "/list/reservas/usuario", method = RequestMethod.GET)
    public ArrayList<Reserva> reportingReservasDeUsuario(
            @RequestParam(value = "uid", required = true) String email) {
        ArrayList<Reserva> reservaList = (ArrayList<Reserva>) reservaRepo.reservasPorUsuario(email);
        return reservaList;
    }

    @RequestMapping(value = "/list/reservas/empr", method = RequestMethod.GET)
    public ArrayList<Reserva> reportingReservasDeEmpr(
            @RequestParam(value = "empr_name", required = true) String empr_name) {
        ArrayList<Reserva> reservaList = (ArrayList<Reserva>) reservaRepo.reservasPorCine(empr_name);
        return reservaList;
    }

    @RequestMapping(value = "/show/room/function", method = RequestMethod.GET)
    public Room roomFromFunction(
            @RequestParam(value = "function_id", required = true) int function_id) {
        Room room = (Room) roomRepo.roomFromFuncion(function_id);
        return room;
    }
}
