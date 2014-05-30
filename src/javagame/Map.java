package javagame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Map {
    private Node[][] field;
    private int size;
    
    
    
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
                        case 'O': map.addEntity(br, i, new Orc("Name", 100, br, i));
                            break;
                        case 'H': map.addEntity(br, i, new Hero("Name", 100, "NickName", br, i));
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


    private class Node {
        private boolean isObstacle;
        private Entity object;
        
        private Node(){
            object=null;
            isObstacle=false;
        }



    }
}