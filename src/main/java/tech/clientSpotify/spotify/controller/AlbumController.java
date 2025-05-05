package tech.clientSpotify.spotify.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.clientSpotify.spotify.client.Album;
import tech.clientSpotify.spotify.client.AllbumSpotifyClient;
import tech.clientSpotify.spotify.client.AuthSpotifyClient;
import tech.clientSpotify.spotify.client.LoginRequest;

import java.util.List;


@RestController
@RequestMapping("/spotfy/api")
public class AlbumController {
    private final AuthSpotifyClient authSpotifyClient;

    private final AllbumSpotifyClient allbumSpotifyClient;

    public AlbumController(AuthSpotifyClient authSpotifyClient, AllbumSpotifyClient allbumSpotifyClient) {
        this.authSpotifyClient = authSpotifyClient;
        this.allbumSpotifyClient = allbumSpotifyClient;
    }

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> helloWorld() {
        String grantType = "client_credentials";
        String clientId = "690801ac14d648fca9cc73d701d92ebd";
        String clientSecret = "a474a7b9ba5c42aca56ffe3039cadb11";

        var accessToken = authSpotifyClient
                .login(grantType, clientId, clientSecret)
                .getAccessToken();

        allbumSpotifyClient.getReleases("Bearer" + accessToken);

        return ResponseEntity.ok();

    }

}


