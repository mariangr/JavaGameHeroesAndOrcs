package javagame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Map {
    private Node[][] field;
    private int size;
    private static Random rand = new Random();
    
    public Map(int size){
        this.field=new Node[size][size];
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.field[i][j] = new Node();
            }
        }
        this.size=size;
    }
    
    public boolean addEntity(int x,int y,Entity object){
        if(!isFree(x, y)) {
            return false;
        }
        
        field[x][y].object=object;
        
        return true;
    }
    

    public void removeEntity(int x,int y){
        field[x][y].object=null;
    }
    
    public boolean isFree(int x, int y) {
        if(field[x][y].isObstacle || field[x][y].object != null) {
            return false;
        }
        return true;
    }
    
    public void addObsticle(int x,int y) {
        field[x][y].isObstacle=true;
    }
    
    
    @Override
    public String toString(){
        String result = "";
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(isFree(i,j)){
                    result+="-";
                }
                if(field[i][j].object instanceof Hero) {
                    result+="H";
                }
                if(field[i][j].object instanceof Orc) {
                    result+="O";
                }
                if(field[i][j].isObstacle){
                    result+="=";
                }
            }
            result+="\n";
        }
        
        return result;
    }
    
    /*public Entity returnObject(int x,int y){
        return field[x][y].object;
    }*/
    
    public static Map readFromFile(String path) {
        BufferedReader reader = null;
        Map map = null;
        
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = null;
            line = reader.readLine();
            int size = line.length();
            map = new Map (size);
            int br=0;
            
            while (line != null) {
                for (int i=0;i<size;i++){
                    switch(line.charAt(i)){
                        case 'O': map.addEntity(br, i, new Orc(null, 100, br, i));
                            break;
                        case 'H': map.addEntity(br, i, new Hero(null, 100, null, br, i));
                            break;
                        case '=': map.addObsticle(br, i);
                            break;
                    }
                        
                }
                line = reader.readLine();
                br+=1;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return map;
    }
    
    public void placeEntity(Entity entity){
        for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                if(field[i][j].object instanceof Hero && entity instanceof Hero){
                    field[i][j].object = entity;
                    field[i][j].object.setCoordinates(i, j);
                    break;
                }
                if(field[i][j].object instanceof Orc && entity instanceof Orc){
                    field[i][j].object = entity;
                    field[i][j].object.setCoordinates(i, j);
                    break;
                }
            }
            }
        
    }
    
    public void automaticMove(Entity entity){
        int x = entity.getXCoord();
        int y = entity.getYCoord();
        boolean success=false;
        int chance = rand.nextInt(100);
        
        while(!success){
        if (chance < 25){
            field[x][y].object.move(x-1, y);
            success=true;
        }
        if (chance >= 25 && chance < 50){
            field[x][y].object.move(x+1, y);
            success=true;
        }
        if (chance >= 50 && chance < 75){
            field[x][y].object.move(x, y-1);
            success=true;
        }
        if (chance >= 75){
            field[x][y].object.move(x, y-1);
            success=true;
        }
        }
                
    }
    
    public boolean areClose(int x, int y){
        boolean areClose = false;
        for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i==0 && j==0){
                        continue;
                    }
                    if (field[x+i][y+j].object!=null){
                        areClose = true;
                    }
                }
            
            }
        return areClose;
    }


    private class Node {
        private boolean isObstacle;
        private Entity object;
        
        private Node(){
            object=null;
            isObstacle=false;
        }


    }
}