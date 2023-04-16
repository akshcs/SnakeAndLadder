package com.example.LLD;

import com.example.LLD.entity.Board;
import com.example.LLD.entity.Game;
import com.example.LLD.entity.Player;
import com.example.LLD.entity.impl.Ladder;
import com.example.LLD.entity.impl.Snake;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan
public class SnakeAndLadderApplication {
	public static void main(String[] args) {
		// Create Game
		Game game= new Game(10, 1);

		// Add Players
		game.addPlayer(new Player("A", "Red"));
		game.addPlayer(new Player("B", "Blue"));
		game.addPlayer(new Player("C", "Green"));
		game.addPlayer(new Player("D", "Yellow"));

		// Add Snake and Ladders
		Board board = game.getBoard();
		board.addEntity(new Snake(28, 12));
		board.addEntity(new Snake(78, 34));
		board.addEntity(new Snake(96, 6));
		board.addEntity(new Snake(84, 65));
		board.addEntity(new Ladder(24, 56));
		board.addEntity(new Ladder(43, 83));
		board.addEntity(new Ladder(3, 31));
		board.addEntity(new Ladder(72, 91));

		game.start();
//		SpringApplication.run(SnakeAndLadderApplication.class, args);
	}
}
