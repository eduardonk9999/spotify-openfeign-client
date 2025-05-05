package tech.clientSpotify.spotify.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.swing.*;

@FeignClient(
        name = "AlbumSpotifyClient",
        url = "https://api.spotify.com"
)
public interface AllbumSpotifyClient {

    @GetMapping(value = "/v1/browse/new-releases")
    AlbumResponse getReleases(@RequestHeader("Authorization") Spring authorization);
}
