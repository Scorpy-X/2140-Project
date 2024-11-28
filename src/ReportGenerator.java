
import java.util.ArrayList;

public  class ReportGenerator{
    //private static TaylorAdmin TaylorHall;
    private static Block blocks;
    
    
        public ReportGenerator(){}
            
       

        public static int getExcellentFurniture(ArrayList<Block> blocklst){//Total number of excellent furn
           int count = 0;
            for(Block block: blocklst){
                for(Room rooms: block.getRooms()){
                   count = rooms.getExcellentFurnitureCount();
                   
                }
            }
            return count;
        }

        public static int getFairFurniture(ArrayList<Block> blocklst){//Total number of fair furn
           
                int count = 0;
                 for(Block block: blocklst){
                     for(Room rooms: block.getRooms()){
                        count = rooms.getFairFurnitureCount();
                         
                     }
                 }
                 return count;
             }
     

        public static int getPoorFurniture(ArrayList<Block> blocklst){//Total number of poor furn
            int count = 0;
            for(Block block: blocklst){
                for(Room rooms: block.getRooms()){
                   count = rooms.getPoorFurnitureCount();
                   
                }
            }
            return count;
        }

        public static int getMissingFurniture(ArrayList<Block> blocklst){//Total number of missing furn
            int count = 0;
            for(Block block: blocklst){
                for(Room rooms: block.getRooms()){
                   count = rooms.getMissingFurnitureCount();
                    
                }
            }
            return count;
        }

        ///////////////////////////////////blocks 
        public static int getExcellentFBlock(char block, ArrayList<Block> blocklst){//excellent for given block 
           int count = 0;
           for(Block blocks: blocklst){

            for(Room rooms: blocks.getRooms()){
                if(rooms.getRoomID().startsWith(Character.toString((block)))){
                    count = rooms.getExcellentFurnitureCount();
                }

                 }
           }
                     return count;
        }
        
        public static int getFairFBlock(char block, ArrayList<Block> blocklst){//fairfor block 
            int count = 0;
            for(Block blocks: blocklst){
 
             for(Room rooms: blocks.getRooms()){
                 if(rooms.getRoomID().startsWith(Character.toString((block)))){
                     count = rooms.getFairFurnitureCount();
                 }
 
                  }
            }
                      return count;
        }

        public static int getPoorFBlock(char block, ArrayList<Block> blocklst){///poor for block
            int count = 0;
            for(Block blocks: blocklst){
 
             for(Room rooms: blocks.getRooms()){
                 if(rooms.getRoomID().startsWith(Character.toString((block)))){
                     count = rooms.getPoorFurnitureCount();
                 }
 
                  }
            }
                      return count;
        }

        public static int getMissingFBlock(char block, ArrayList<Block> blocklst){//missing for block 
            int count = 0;
            for(Block blocks: blocklst){
 
             for(Room rooms: blocks.getRooms()){
                 if(rooms.getRoomID().startsWith(Character.toString((block)))){
                     count = rooms.getMissingFurnitureCount();
                 }
 
                  }
            }
                      return count;
        }

        public static int getTotalOccupants(ArrayList<Block> blocklst){/// total occupants
            int count = 0;
                 for(Block block: blocklst){
                     for(Room rooms: block.getRooms()){
                        count = rooms.getNumOccupants();
                         
                     }
                 }
                 return count;
        }
        
        public static int getTotalOccupantsBlock(char block, ArrayList<Block> blocklst){//Total occupants per block 
            int count = 0;
            for(Block blocks: blocklst){
 
             for(Room rooms: blocks.getRooms()){
                 if(rooms.getRoomID().startsWith(Character.toString((block)))){
                     count = rooms.getNumOccupants();
                 }
 
                  }
            }
                      return count;
        
        }
        


        
        
        //hello my version 

  
     

    
    public static void main(String[] args) {
        // Example login attempts
     
      ///////////////////////////////////////////// TaylorAdmin TaylorHall = new TaylorAdmin(DataManager.loadData());
        TaylorAdmin TaylorHall = new TaylorAdmin();
       // ReportGenerator  ReG1 = new ReportGenerator();
        ReportGenerator.getExcellentFurniture(TaylorHall.getBlocks());

       // ReportGenerator1.blockCount();
       // ReportGenerator1.listAllBlocks();
        }


}




       
