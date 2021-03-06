package GameState;

import TileMap.Background;
import Entity.Animation;
import Entity.Barrier;
import Entity.Booklet;
import Entity.Iska;
import Entity.Isko;
import Entity.Platform;
import Entity.Water;
import Main.Audio;
import Entity.Button;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class LevelState extends GameState{
	
	private Background bg;
	private Audio audioEnd;
	private Audio audioLevel1;
	private Animation black;
	private BufferedImage[] pauseImage;
	private BufferedImage gray;
	private BufferedImage winImage;
	private Isko isko;
	private Iska iska;
	private ArrayList<Platform> platform;
	private ArrayList<Water> water;
	private ArrayList<Booklet> booklet;
	private ArrayList<Barrier> barrier;
	private ArrayList<Button> button;
	private Button btn1;
	private Button btn2;
	private int choice;
	private int currentState;
	
	private boolean reset;
	private boolean pause;
	private boolean next;
	private boolean pausing;
	private boolean win;
	public LevelState (GameStateManager gsm, int level){
		this.gsm = gsm;
		audioEnd = new Audio("C:\\Users\\Mace the Destroyer\\Desktop\\FP\\Isko & Iska\\Resources\\Audio\\end.wav");
		audioLevel1 = new Audio("C:\\Users\\Mace the Destroyer\\Desktop\\FP\\Isko & Iska\\Resources\\Audio\\level1.wav");
		BufferedImage frame;
		BufferedImage[] frames = new BufferedImage[5];
		pauseImage = new BufferedImage[3]; 
		black = new Animation();
		try {
			frame = ImageIO.read(getClass().getResourceAsStream("/Background/blackscreen.png"));
			gray = ImageIO.read(getClass().getResourceAsStream("/Background/black.png"));
			winImage = ImageIO.read(getClass().getResourceAsStream("/Background/Home/congratulations.png"));
			for(int i = 0; i < 5; i++) {
				frames[i] = frame;
			}
			for(int i = 0; i < 3; i++) {
				pauseImage[i] = ImageIO.read(getClass().getResourceAsStream(String.format("/Background/Pause/menu%d.png", i)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		black.setFrames(frames);
		black.setDelay(200);
		currentState = level;
		init(level);
	}
	
	public void initLevel1() {
		choice = 0;
		booklet = new ArrayList<Booklet>();
		platform = new ArrayList<Platform>();
		water = new ArrayList<Water>();
		barrier = new ArrayList<Barrier>();
		button = new ArrayList<Button>();
		try {
			bg = new Background("/Background/Map1/Background.png", 0);
			bg.setVector(0, 0);
			booklet.add(new Booklet(343, 599, "orange"));
			booklet.add(new Booklet(483, 599, "blue"));	
			booklet.add(new Booklet(49, 305, "orange"));
			booklet.add(new Booklet(516, 270, "blue"));
			booklet.add(new Booklet(262, 43, "blue"));
			booklet.add(new Booklet(496, 43, "orange"));
			booklet.add(new Booklet(710, 398, "blue"));
			booklet.add(new Booklet(822, 160, "orange"));
			booklet.add(new Booklet(745, 50, "blue"));
			booklet.add(new Booklet(75, 105, "orange"));
			platform.add(new Platform(0, 669, "Map1/bottomborder.png"));
			platform.add(new Platform(0, 0, "Map1/topborder.png"));
			platform.add(new Platform(0, 0, "Map1/leftborder.png"));
			platform.add(new Platform(868, 0, "Map1/rightborder.png"));
			platform.add(new Platform(40, 562, "Map1/platform0.png"));
			platform.add(new Platform(595, 525, "Map1/platform2.png"));
			platform.add(new Platform(812, 601, "Map1/platform3.png"));
			platform.add(new Platform(369, 471, "Map1/platform4.png"));
			platform.add(new Platform(40, 443, "Map1/platform5.png"));
			platform.add(new Platform(40, 375, "Map1/platform3.png"));
			platform.add(new Platform(136, 327, "Map1/platform6.png"));
			platform.add(new Platform(472, 355, "Map1/platform7.png"));
			platform.add(new Platform(752, 387, "Map1/platform8.png"));
			platform.add(new Platform(812, 285, "Map1/platform3.png"));
			platform.add(new Platform(529, 222, "Map1/platform9.png"));
			platform.add(new Platform(459, 194, "Map1/platform10.png"));
			platform.add(new Platform(139, 222, "Map1/platform11.png"));
			platform.add(new Platform(40, 162, "Map1/platform12.png"));
			platform.add(new Platform(222, 97, "Map1/platform1.png"));
			platform.add(new Platform(456, 97, "Map1/platform1.png"));
			platform.add(new Platform(670, 114, "Map1/platform2.png"));
			water.add(new Water(652, 666, "violetshort"));
			water.add(new Water(300, 666, "orangelong"));
			water.add(new Water(440, 666, "bluelong"));
			water.add(new Water(150, 219, "violetshort"));
			water.add(new Water(335, 219, "orangelong"));
			water.add(new Water(570, 219, "blueshort"));
			btn1 = new Button(660, 515);
			button.add(btn1);
			btn2 = new Button(250, 317);
			button.add(btn2);
			barrier.add(new Barrier(357, 368, btn1, btn2));
			isko = new Isko(43, 601);
			iska = new Iska(43, 500);
			reset = false;
			next = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initLevel2() {
		choice = 0;
		booklet = new ArrayList<Booklet>();
		platform = new ArrayList<Platform>();
		water = new ArrayList<Water>();
		barrier = new ArrayList<Barrier>();
		button = new ArrayList<Button>();
		try {
			bg = new Background("/Background/Map2/Background.png", 0);
			bg.setVector(0, 0);
			booklet.add(new Booklet(200, 610, "orange"));
			booklet.add(new Booklet(265, 610, "orange"));
			booklet.add(new Booklet(200, 510, "blue"));
			booklet.add(new Booklet(265, 510, "blue"));
			booklet.add(new Booklet(489, 610, "blue"));
			booklet.add(new Booklet(554, 610, "blue"));
			booklet.add(new Booklet(489, 510, "orange"));
			booklet.add(new Booklet(554, 510, "orange"));
			booklet.add(new Booklet(517, 409, "blue"));
			booklet.add(new Booklet(610, 409, "orange"));
			booklet.add(new Booklet(260, 409, "blue"));
			booklet.add(new Booklet(353, 409, "orange"));
			booklet.add(new Booklet(435, 270, "orange"));
			booklet.add(new Booklet(435, 200, "blue"));
			booklet.add(new Booklet(80, 55, "orange"));
			booklet.add(new Booklet(150, 55, "blue"));
			booklet.add(new Booklet(75, 225, "blue"));
			booklet.add(new Booklet(820, 50, "orange"));
			btn1 = new Button(687, 457);
			button.add(btn1);
			btn2 = new Button(175, 457);
			button.add(btn2);
			barrier.add(new Barrier(429, 396, btn1, btn2));
			water.add(new Water(190, 666, "orangelong"));
			water.add(new Water(190, 565, "bluelong"));
			water.add(new Water(479, 666, "bluelong"));
			water.add(new Water(479, 565, "orangelong"));
			water.add(new Water(228, 355, "violetlong"));
			water.add(new Water(558, 355, "violetlong"));
			water.add(new Water(420, 145, "violetshort"));
			platform.add(new Platform(0, 669, "Map2/bottomborder.png"));
			platform.add(new Platform(0, 0, "Map2/topborder.png"));
			platform.add(new Platform(0, 0, "Map2/leftborder.png"));
			platform.add(new Platform(868, 0, "Map2/rightborder.png"));
			platform.add(new Platform(160, 568, "Map2/platform0.png"));
			platform.add(new Platform(449, 568, "Map2/platform0.png"));
			platform.add(new Platform(800, 570, "Map2/platform1.png"));
			platform.add(new Platform(44, 467, "Map2/platform2.png"));
			platform.add(new Platform(145, 358, "Map2/platform2.png"));
			platform.add(new Platform(230, 281, "Map2/platform3.png"));
			platform.add(new Platform(560, 281, "Map2/platform3.png"));
			platform.add(new Platform(392, 148, "Map2/platform3.png"));
			platform.add(new Platform(418, 329, "Map2/platform4.png"));
			platform.add(new Platform(748, 309, "Map2/platform5.png"));
			platform.add(new Platform(800, 243, "Map2/platform6.png"));
			platform.add(new Platform(674, 146, "Map2/platform7.png"));
			platform.add(new Platform(515, 118, "Map2/platform8.png"));
			platform.add(new Platform(44, 118, "Map2/platform9.png"));
			isko = new Isko(43, 550);
			iska = new Iska(83, 550);
			reset = false;
			next = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initLevel3() {
		choice = 0;
		booklet = new ArrayList<Booklet>();
		platform = new ArrayList<Platform>();
		water = new ArrayList<Water>();
		barrier = new ArrayList<Barrier>();
		button = new ArrayList<Button>();
		try {
			bg = new Background("/Background/Map3/Background.png", 0);
			bg.setVector(0, 0);
			platform.add(new Platform(0, 669, "Map3/bottomborder.png"));
			platform.add(new Platform(0, 0, "Map3/topborder.png"));
			platform.add(new Platform(0, 0, "Map3/leftborder.png"));
			platform.add(new Platform(868, 0, "Map3/rightborder.png"));
			platform.add(new Platform(43, 112, "Map3/platform0.png"));
			platform.add(new Platform(682, 112, "Map3/platform0.png"));
			platform.add(new Platform(553, 122, "Map3/platform1.png"));
			platform.add(new Platform(427, 143, "Map3/platform1.png"));
			platform.add(new Platform(299, 122, "Map3/platform1.png"));
			platform.add(new Platform(220, 221, "Map3/platform2.png"));
			platform.add(new Platform(43, 333, "Map3/platform0.png"));
			platform.add(new Platform(682, 333, "Map3/platform0.png"));
			platform.add(new Platform(274, 431, "Map3/platform3.png"));
			platform.add(new Platform(514, 431, "Map3/platform3.png"));
			platform.add(new Platform(44, 556, "Map3/platform4.png"));
			platform.add(new Platform(419, 526, "Map3/platform5.png"));
			platform.add(new Platform(102, 508, "Map3/platform6.png"));
			platform.add(new Platform(44, 442, "Map3/platform7.png"));
			water.add(new Water(234, 218, "orangeshort"));
			water.add(new Water(607, 218, "blueshort"));
			water.add(new Water(357, 218, "violetshort"));
			water.add(new Water(484, 218, "violetshort"));
			water.add(new Water(145, 330, "blueshort"));
			water.add(new Water(696, 330, "orangeshort"));
			water.add(new Water(230, 553, "violetlong"));
			water.add(new Water(555, 553, "violetlong"));
			booklet.add(new Booklet(308, 68, "orange"));
			booklet.add(new Booklet(561, 68, "blue"));
			booklet.add(new Booklet(77, 257, "orange"));
			booklet.add(new Booklet(77, 187, "blue"));
			booklet.add(new Booklet(793, 257, "blue"));
			booklet.add(new Booklet(793, 187, "orange"));
			booklet.add(new Booklet(398, 304, "blue"));
			booklet.add(new Booklet(472, 304, "orange"));
			booklet.add(new Booklet(112, 455, "blue"));
			booklet.add(new Booklet(800, 431, "orange"));
			booklet.add(new Booklet(109, 609, "blue"));
			booklet.add(new Booklet(259, 609, "orange"));
			btn1 = new Button(54, 432);
			button.add(btn1);
			btn2 = new Button(182, 659 );
			button.add(btn2);
			barrier.add(new Barrier(371, 593, btn1, btn2));
			isko = new Isko(43, 40);
			iska = new Iska(810, 40);
			iska.facing = -1;
			reset = false;
			next = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void init(int state) {
		if(state == 1) {
			initLevel1();
		}else if(state == 2) {
			initLevel2();
		}else if(state == 3) {
			initLevel3();
		}
	}

	public void choice(int k) {
		if(k == KeyEvent.VK_W || k == KeyEvent.VK_UP) {
			choice--;
		}else if(k == KeyEvent.VK_S || k == KeyEvent.VK_DOWN) {
			choice++;
		}
		if(choice < 0) {
			choice = 2;
		}else if(choice > 2) {
			choice = 0;
		}
		if(k == KeyEvent.VK_ENTER) {
			if(choice == 2) {
				System.exit(0);
			}else if(choice == 1) {
				reset = true;
				pause = false;
			}else {
				pause = false;
			}
		}
	}
	public void update() {
		if(win) {
			audioEnd.play();
		}else if(pause) {
		}else if(next || reset){
			black.update();
		}else {
			if(currentState == 1 || currentState == 2 || currentState == 3) {
				audioLevel1.play();
			}else {
				audioLevel1.stop();
			}
			
			if(isko.smokeAnimation.hasPlayedOnce() || iska.smokeAnimation.hasPlayedOnce()) {
				reset = true;
			}
			for(int i = 0; i < platform.size(); i++) {
				isko.checkPlatformCollision(platform.get(i));
				iska.checkPlatformCollision(platform.get(i));
			}
			for(int i = 0; i < water.size(); i++) {
				water.get(i).update();
				if(isko.checkCollision(water.get(i), true)){
					if(!water.get(i).getColor().equals("blue")) {
						isko.dead = true;
					}
				}
				if(iska.checkCollision(water.get(i), true)){
					if(!water.get(i).getColor().equals("orange")) {
						iska.dead = true;
					}
				}
			}
			for(int i = 0; i < booklet.size(); i++) {
				booklet.get(i).update();
				if(isko.checkCollision(booklet.get(i), false) && booklet.get(i).getColor().equals("blue")){
					booklet.get(i).destroy();
				}
				if(iska.checkCollision(booklet.get(i), false) && booklet.get(i).getColor().equals("orange")){
					booklet.get(i).destroy();
				}
				if(booklet.get(i).hasPlayedOnce()){
					booklet.remove(booklet.get(i));
					if(booklet.size() == 0) {
						next = true;
					}
				}
			}
			for(int i = 0; i < barrier.size(); i++) {
				barrier.get(i).update();
				isko.checkPlatformCollision(barrier.get(i));
				iska.checkPlatformCollision(barrier.get(i));
			}
			for(int i = 0; i < button.size(); i++) {
				button.get(i).update();
				if(isko.checkCollision(button.get(i), true)) {
					button.get(i).pressed = true;
				}else if(iska.checkCollision(button.get(i), true)) {
					button.get(i).pressed = true;
				}else {
					button.get(i).pressed = false;
				}
			}
			isko.update();
			iska.update();
		}
	}
	
	public void draw(Graphics2D g) {
		if(win) {
			g.drawImage(winImage, 0, 0, null);
		}else if(pause) {
			if(pausing) {
				g.drawImage(gray, 0, 0, null);
				pausing = false;
			}
;			g.drawImage(pauseImage[choice], 0, 0, null);
		}else if(next || reset) {
			g.drawImage(black.getImage(), 0, 0, null);
			if(black.hasPlayedOnce()) {
				if(next) {
					currentState++;
					if(currentState > 3) {
						win = true;
					}else {
						gsm.setState(1, currentState);
						next = false;
					}
				}
				else if(reset) {
					gsm.setState(1, currentState);
				}
				black.setPlayedOnce(false);
			}
		}else {
			bg.draw(g);
			for(int i = 0; i < platform.size(); i++) {
				platform.get(i).draw(g);
			}
			for(int i = 0; i < barrier.size(); i++) {
				barrier.get(i).draw(g);
			}
			for(int i = 0; i < booklet.size(); i++) {
				booklet.get(i).draw(g);
			}
			isko.draw(g);
			iska.draw(g);
			for(int i = 0; i < water.size(); i++) {
				water.get(i).draw(g);
			}
			for(int i = 0; i < button.size(); i++) {
				button.get(i).draw(g);
			}
		}
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_P) {
			win = true;
		}
		if(k == KeyEvent.VK_ESCAPE) {
			pause = true;
			pausing = true;
		}
		if(pause) {
			choice(k);
		}
		isko.keyPressed(k);
		iska.keyPressed(k);
	}
	public void keyReleased(int k) {
		isko.keyReleased(k);
		iska.keyReleased(k);
	}
	public void mouseClicked(int x, int y) {
		System.out.println(x + " - " + y);
	}
}
