package restapi.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistsItemsRequest;

import restapi.model.Chamada;
import restapi.model.Faixa;
import restapi.model.Playlist;
import restapi.repository.ChamadaRepository;


@RestController
public class IndexController {
	
	//chaves api spotify
	private String clientId = "4fda7f4932bf4c068141a1e526502f7e";
	private String clientSecret = "8c5b88ea1fed465badebafbfa4dfc5de";
	
	//chave api openweathermap
	private String appid = "6801fe9e74c3fd9d5a5b0ea6b668d7af";

	private SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(clientId)
			.setClientSecret(clientSecret).build();
	
	private ClientCredentialsRequest clientCredentialsRequest = 
			spotifyApi.clientCredentials().build();
	
	@Autowired
	private ChamadaRepository chamadaRepository;
	  
	
	@GetMapping(value="/{cidade}", produces="application/json")
	public ResponseEntity<Playlist> init(@PathVariable(value="cidade") String cidade){
		
		String urlRequisitada = "http://api.openweathermap.org/data/2.5/weather?q="
		+ cidade + "&appid=" + appid + "&units=metric";
		
		Playlist playlist = getPlaylist(urlRequisitada);
		
		Chamada chamada = new Chamada();
		chamada.setChamada("/" + cidade);
		chamada.setDataHora(LocalDateTime.now());
		
		chamadaRepository.save(chamada);
		
		return new ResponseEntity<Playlist>(playlist, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{latitude}/{longitude}", produces="application/json")
	public ResponseEntity<Playlist> init(@PathVariable(value="latitude") String latitude, 
			@PathVariable(value="longitude") String longitude){
		
		String urlRequisitada = "http://api.openweathermap.org/data/2.5/weather?lat="
		+ latitude + "&lon=" + longitude + "&appid=" + appid + "&units=metric";
		
		Playlist playlist = getPlaylist(urlRequisitada);
		
		Chamada chamada = new Chamada();
		chamada.setChamada("/" + latitude + "/" + longitude);
		chamada.setDataHora(LocalDateTime.now());
		
		chamadaRepository.save(chamada);
		
		return new ResponseEntity<Playlist>(playlist, HttpStatus.OK);
		
	}
	
	
	private Playlist getPlaylist(String urlRequisitada) {
		
		URL url = null;		
		Playlist playlist = new Playlist();
		
		try {			
			url = new URL(urlRequisitada);
			
			URLConnection connection;
			
			connection = url.openConnection();
			
			InputStream inputStream = connection.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			
			String str = br.readLine();
			
			JSONObject jsonObject = new JSONObject(str);
			
			String strTemperatura = jsonObject.getJSONObject("main").get("temp").toString();
			
			Double temperatura = Double.parseDouble(strTemperatura);
			
			String playlistId = "";
			
			ClientCredentials clientCredentials = clientCredentialsRequest.execute();			
			spotifyApi.setAccessToken(clientCredentials.getAccessToken());
			
			if(temperatura>30) {playlistId = "1ZlIQ1QPtY3usZJ0EVOpR0";}//party
			else if(temperatura>=15 && temperatura <=30) {playlistId = "6CBQJuJpdkAPHOUe0MMy1Y";}//pop
			else if(temperatura>=10 && temperatura <15) {playlistId = "3GdzmOJUqZVJosIbLtG3N9";}//rock
			else {playlistId = "3sqmptqbdOYGi74QVjpCRH";}//classic			
			
			GetPlaylistsItemsRequest getPlaylistsItemsRequest = 
					spotifyApi.getPlaylistsItems(playlistId).build();

			Paging<PlaylistTrack> playlistTrackPaging = getPlaylistsItemsRequest.execute();
			
			int totalDeFaixas = playlistTrackPaging.getTotal();
			
			int limitePagina = 99;
			
			if (totalDeFaixas > limitePagina) {
				totalDeFaixas = limitePagina;
			}
			
			List<Faixa> listFaixas = new ArrayList<>(); 
			
			for(int i=0; totalDeFaixas > i; i++) {
				
				Faixa faixa = new Faixa();
				faixa.setFaixa(playlistTrackPaging.getItems()[i].getTrack().getName());
				
				listFaixas.add(faixa);					
			}		
			
			playlist.setPlayList(listFaixas);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return playlist;
		
	}

}
