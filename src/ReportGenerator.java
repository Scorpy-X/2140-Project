
import java.util.ArrayList;

public  class ReportGenerator{
   // private static TaylorAdmin TaylorHall;
    private static Block blocks;
    
    
        public ReportGenerator(){}
            
       

        public static int excellentFurniture(ArrayList<Block> blocklst){//Total number of excellent furn
           int count = 0;
            for(Block block: blocklst){
                for(Room rooms: block.getRooms()){
                   count = rooms.getExcellentFurnitureCount();
                   
                }
            }
            return count;
        }

        public static int FairFurniture(ArrayList<Block> blocklst){//Total number of fair furn
           
                int count = 0;
                 for(Block block: blocklst){
                     for(Room rooms: block.getRooms()){
                        count = rooms.getFairFurnitureCount();
                         
                     }
                 }
                 return count;
             }
     

        public static int PoorFurniture(ArrayList<Block> blocklst){//Total number of poor furn
            int count = 0;
            for(Block block: blocklst){
                for(Room rooms: block.getRooms()){
                   count = rooms.getPoorFurnitureCount();
                   
                }
            }
            return count;
        }

        public static int MissingFurniture(ArrayList<Block> blocklst){//Total number of missing furn
            int count = 0;
            for(Block block: blocklst){
                for(Room rooms: block.getRooms()){
                   count = rooms.getMissingFurnitureCount();
                    
                }
            }
            return count;
        }

        ///////////////////////////////////blocks 
        public static int excellentFBlock(Block block){//excellent for given block 
           int count = 0;
            for(Room rooms: block.getRooms()){
                count = rooms.getExcellentFurnitureCount();
           }
           
           
                     return count;
        }
        
        public static int FairFBlock(Block block){//fairfor block 
            int count = 0;
            for(Room rooms: block.getRooms()){
                count = rooms.getFairFurnitureCount();
           }
           
           
                     return count;
        }

        public static int PoorFBlock(Block block){///poor for block
            int count = 0;
            for(Room rooms: block.getRooms()){
                count = rooms.getPoorFurnitureCount();
           }
           
           
                     return count;
        }

        public static int MissingFBlock(Block block){//missing for block 
            int count = 0;
            for(Room rooms: block.getRooms()){
                count = rooms.getMissingFurnitureCount();
           }
           
           
                     return count;
        }

        public static int totalOccupants(ArrayList<Block> blocklst){/// total occupants
            int count = 0;
                 for(Block block: blocklst){
                     for(Room rooms: block.getRooms()){
                        count = rooms.getNumOccupants();
                         
                     }
                 }
                 return count;
        }
        
        public static int totalOccupantsBlock(Block block){//Total occupants per block 
            int count = 0;
            for(Room rooms: block.getRooms()){
                count = rooms.getNumOccupants();
           }
           
           
                     return count;
        
        }

    
    public static void main(String[] args) {
        // Example login attempts
     
        TaylorAdmin TaylorHall = new TaylorAdmin();
        
   
        ReportGenerator  ReportGenerator1 = new ReportGenerator();
       // ReportGenerator1.blockCount();
       // ReportGenerator1.listAllBlocks();
        }


}




       
