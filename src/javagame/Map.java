package javagame;

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


    private class Node {
        private boolean isObstacle;
        private Entity object;
        
        private Node(){
            object=null;
            isObstacle=false;
        }



    }
}