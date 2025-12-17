package com.example.cineplusbackend;

import com.example.cineplusbackend.model.Pelicula;
import com.example.cineplusbackend.model.Producto;
import com.example.cineplusbackend.repository.PeliculaRepository;
import com.example.cineplusbackend.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class CineplusbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CineplusbackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(PeliculaRepository peliculaRepository,
                                      ProductoRepository productoRepository) {
        return args -> {

            RestTemplate restTemplate = new RestTemplate();

            if (peliculaRepository.count() == 0) {

                Pelicula p1 = new Pelicula(
                        "Spider-Man: No Way Home",
                        "Peter Parker enfrenta las consecuencias de que el mundo conozca su identidad.",
                        "Acción",
                        9.0
                );

                Pelicula p2 = new Pelicula(
                        "Interstellar",
                        "Un grupo de exploradores viaja a través de un agujero de gusano en busca de un nuevo hogar para la humanidad.",
                        "Ciencia Ficción",
                        9.5
                );

                Pelicula p3 = new Pelicula(
                        "Toy Story",
                        "La vida secreta de los juguetes cuando los humanos no están presentes.",
                        "Animación",
                        8.5
                );

                Pelicula p4 = new Pelicula(
                        "El Señor de los Anillos: La Comunidad del Anillo",
                        "Un joven hobbit emprende un viaje para destruir un anillo poderoso.",
                        "Fantasía",
                        9.2
                );

                Pelicula p5 = new Pelicula(
                        "Shrek",
                        "Un ogro que vive en un pantano ve su vida interrumpida por criaturas de cuento.",
                        "Animación",
                        8.1
                );

                Pelicula p6 = new Pelicula(
                        "Avatar",
                        "Un ex marine viaja al planeta Pandora en una misión que lo cambiará para siempre.",
                        "Ciencia Ficción",
                        7.8
                );

                Pelicula p7 = new Pelicula(
                        "The Dark Knight",
                        "Batman enfrenta al Joker en una batalla por el futuro de Ciudad Gótica.",
                        "Acción",
                        9.0
                );

                Pelicula p8 = new Pelicula(
                        "Gladiator",
                        "Un general romano cae en desgracia y busca venganza en la arena.",
                        "Acción",
                        8.5
                );

                Pelicula p9 = new Pelicula(
                        "Harry Potter and the Sorcerer's Stone",
                        "Un niño descubre que es mago y comienza su vida en Hogwarts.",
                        "Fantasía",
                        7.9
                );

                Pelicula p10 = new Pelicula(
                        "Inception",
                        "Un ladrón especializado en entrar en los sueños debe completar un último trabajo.",
                        "Ciencia Ficción",
                        8.8
                );

                p1.setImagen(obtenerPoster("Spider-Man: No Way Home", restTemplate));
                p2.setImagen(obtenerPoster("Interstellar", restTemplate));
                p3.setImagen(obtenerPoster("Toy Story", restTemplate));
                p4.setImagen(obtenerPoster("The Lord of the Rings: The Fellowship of the Ring", restTemplate));
                p5.setImagen(obtenerPoster("Shrek", restTemplate));
                p6.setImagen(obtenerPoster("Avatar", restTemplate));
                p7.setImagen(obtenerPoster("The Dark Knight", restTemplate));
                p8.setImagen(obtenerPoster("Gladiator", restTemplate));
                p9.setImagen(obtenerPoster("Harry Potter and the Sorcerer's Stone", restTemplate));
                p10.setImagen(obtenerPoster("Inception", restTemplate));

                peliculaRepository.saveAll(List.of(
                        p1, p2, p3, p4,
                        p5, p6, p7, p8, p9, p10
                ));
            }

            if (productoRepository.count() == 0) {

                Producto m1 = new Producto(
                        "Jockey CinePlus",
                        7990,
                        20,
                        List.of("Curvo", "Recto")
                );

                Producto m2 = new Producto(
                        "Taza CinePlus",
                        5990,
                        35,
                        List.of("Blanca", "Azul", "Roja", "Negra")
                );

                Producto m3 = new Producto(
                        "Poster Película",
                        3990,
                        50,
                        List.of("Horizontal", "Vertical")
                );

                Producto m4 = new Producto(
                        "Balde Cabritas CinePlus",
                        6990,
                        15,
                        List.of("Clásico", "Gigante")
                );

                productoRepository.saveAll(List.of(m1, m2, m3, m4));
            }
        };
    }

    private String obtenerPoster(String titulo, RestTemplate restTemplate) {
        try {
            String encoded = URLEncoder.encode(titulo, StandardCharsets.UTF_8);
            String url = "https://www.omdbapi.com/?t=" + encoded + "&apikey=a531fe9d";
            Map response = restTemplate.getForObject(url, Map.class);
            if (response == null) {
                return null;
            }
            Object poster = response.get("Poster");
            if (poster == null) {
                return null;
            }
            return poster.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
