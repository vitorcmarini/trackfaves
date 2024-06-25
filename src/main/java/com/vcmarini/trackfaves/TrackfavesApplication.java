package com.vcmarini.trackfaves;

import com.vcmarini.trackfaves.service.APIConsumer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrackfavesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TrackfavesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumer = new APIConsumer();
		var json = APIConsumer.catchData("https://api.jikan.moe/v4/manga");
		System.out.println(json.toString());
	}

}
