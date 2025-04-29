package tech.clientSpotify.spotify.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.clientSpotify.spotify.client.AuthSpotifyClient;
import tech.clientSpotify.spotify.client.LoginRequest;


@RestController
@RequestMapping("/spotfy/api")
public class AlbumController {
    private final AuthSpotifyClient authSpotifyClient;

    public AlbumController(AuthSpotifyClient authSpotifyClient) {
        this.authSpotifyClient = authSpotifyClient;
    }

    @GetMapping("/albums")
    public ResponseEntity<String> helloWorld() {
        String grantType = "client_credentials";
        String clientId = "690801ac14d648fca9cc73d701d92ebd";
        String clientSecret = "a474a7b9ba5c42aca56ffe3039cadb11";

        String accessToken = authSpotifyClient
                .login(grantType, clientId, clientSecret)
                .getAccessToken();

        return ResponseEntity.ok(accessToken);

    }

}


