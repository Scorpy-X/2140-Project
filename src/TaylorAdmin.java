import java.util.ArrayList;

public class TaylorAdmin{

    private static ArrayList<Block> blocks;


    public TaylorAdmin(){

        blocks = DataManager.loadData();

    }

    //Accessors

    public static ArrayList<Block> getBlocks() {
        return blocks;
    }


    public int getnumBlocks(){
        return blocks.size();
    }



    
    
    public void saveAllData(){

        DataManager.saveData(blocks);

    }



   




    /*
    @Override
    public String toString(){
        String allBlocks = "Block: "+ getAllBlocks();
            return allBlocks;
    }*/
}