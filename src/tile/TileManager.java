package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	Tile[] tile;
	int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[15];
		mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
		
		getTileImage();
		loadMap();
	}
	
	public void getTileImage() {
		
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass01.png"));
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water00.png"));
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResource("/tiles/table01.png"));		
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResource("/tiles/floor01.png"));
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water02.png"));
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water03.png"));
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water04.png"));
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water05.png"));
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water06.png"));
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water07.png"));
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water08.png"));
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water09.png"));
			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water01.png"));


			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMap() {
	    try {
	        InputStream is = getClass().getResourceAsStream("/maps/Map_One.txt");
	        if (is == null) {
	            System.err.println("Error: InputStream is null. Check the file path and resource configuration.");
	            return;
	        }

	        BufferedReader br = new BufferedReader(new InputStreamReader(is));

	        int col = 0;
	        int row = 0;

	        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
	            String line = br.readLine();

	            while (col < gp.maxScreenCol) {
	                String numbers[] = line.split(" ");
	                int num = Integer.parseInt(numbers[col]);

	                mapTileNum[col][row] = num;
	                col++;
	            }

	            if (col == gp.maxScreenCol) {
	                col = 0;
	                row++;
	            }
	        }
	        br.close();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	public void draw(Graphics2D g2) {
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
			
			int tileNum = mapTileNum[col][row];
			
			g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
			col++;
			x+= gp.tileSize;
			
			if(col == gp.maxScreenCol) {
				col = 0;
				x = 0;
				row++;
				y += gp.tileSize;
			}
		}
//		g2.drawImage(tile[1].image, 0, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 1 * gp.tileSize, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 2 * gp.tileSize, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 3 * gp.tileSize, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 4 * gp.tileSize, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 5 * gp.tileSize, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 6 * gp.tileSize, 0, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[4].image, 0, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 1 * gp.tileSize, gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 2 * gp.tileSize, gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 3 * gp.tileSize, gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 4 * gp.tileSize, gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 5 * gp.tileSize, gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 6 * gp.tileSize, gp.tileSize, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[4].image, 0, 0, gp.tileSize, 2 * gp.tileSize, null);
//		g2.drawImage(tile[4].image, 1 * gp.tileSize, 2 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 2 * gp.tileSize, 2 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 3 * gp.tileSize, 2 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 4 * gp.tileSize, 2 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 5 * gp.tileSize, 2 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 6 * gp.tileSize, 2 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[4].image, 0, 0, gp.tileSize, 3 * gp.tileSize, null);
//		g2.drawImage(tile[4].image, 1 * gp.tileSize, 3 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 2 * gp.tileSize, 3 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 3 * gp.tileSize, 3 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 4 * gp.tileSize, 3 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 5 * gp.tileSize, 3 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 6 * gp.tileSize, 3 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[4].image, 0, 0, gp.tileSize, 4 * gp.tileSize, null);
//		g2.drawImage(tile[4].image, 1 * gp.tileSize, 4 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 2 * gp.tileSize, 4 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 3 * gp.tileSize, 4 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 4 * gp.tileSize, 4 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 5 * gp.tileSize, 4 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[4].image, 6 * gp.tileSize, 4 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[1].image, 0, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 0, 1 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 0, 2 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 0, 3 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 0, 4 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 0, 5 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[1].image, 0, 5 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 1 * gp.tileSize, 5 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 2 * gp.tileSize, 5 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 3 * gp.tileSize, 5 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 4 * gp.tileSize, 5 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 5 * gp.tileSize, 5 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 6 * gp.tileSize, 5 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[1].image, 6 * gp.tileSize, 1 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 6 * gp.tileSize, 4 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[3].image, 3 * gp.tileSize, 2 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[5].image, 9 * gp.tileSize, 1 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 10 * gp.tileSize, 1 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 11 * gp.tileSize, 1 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 12 * gp.tileSize, 1 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[7].image, 13 * gp.tileSize, 1 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[8].image, 9 * gp.tileSize, 2 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[8].image, 9 * gp.tileSize, 3 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[9].image, 13 * gp.tileSize, 2 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[9].image, 13 * gp.tileSize, 3 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[10].image, 9 * gp.tileSize, 4 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 10 * gp.tileSize, 4 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 11 * gp.tileSize, 4 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 12 * gp.tileSize, 4 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[12].image, 13 * gp.tileSize, 4 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[13].image, 10 * gp.tileSize, 2 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[13].image, 11 * gp.tileSize, 2 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[13].image, 12 * gp.tileSize, 2 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[13].image, 10 * gp.tileSize, 3 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[13].image, 11 * gp.tileSize, 3 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[13].image, 12 * gp.tileSize, 3 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[6].image, 0 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 1 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 2 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 3 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 4 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 5 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 6 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 7 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 8 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 9 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 10 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 11 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 12 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 13 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 14 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[6].image, 15 * gp.tileSize, 10 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawImage(tile[11].image, 0 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 1 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 2 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 3 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 4 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 5 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 6 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 7 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 8 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 9 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 10 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 11 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 12 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 13 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 14 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[11].image, 15 * gp.tileSize, 11 * gp.tileSize, gp.tileSize, gp.tileSize, null);


		
		

	}

}
