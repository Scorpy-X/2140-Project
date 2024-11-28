public  class ReportGenerator{
    private TaylorAdmin TaylorHall;
    private Block block;


    public ReportGenerator(){}
        
    public ReportGenerator(TaylorAdmin TaylorHall){
        this.TaylorHall = TaylorHall;
    }

    public int blockCount(){//tells the number of blocks
        return TaylorHall.getnumBlocks();
     }


  
     ///to adjust ////
    //  public String listAllBlocks(){//list all the blocks
    //     for(Block block: TaylorAdmin.getBlocks()){
    //         return TaylorHall.toString();/// to fix caaah his wrong badddd//////
        
    //     }
    //     return TaylorHall.toString();
    //}


    //showing all furniture in excellent conditon //from a particular room and furniture name and count how many
    
    
   // public void Displaystate(TaylorAdmin TaylorHall, String state){}
    
    public void DisplayExcellent(){
            int count = 0;
        for(Block blocks: TaylorHall.getBlocks()){
            for(Room rooms : block.getRooms()){
                if(rooms.getRoomType().equals("Single")){

                    if(rooms.getBed().getState().equals("Excellent") ){
                         count++;
                        System.out.println("Bed in"+rooms.getRoomID() + "in Excellent Condition");
                    }
                    if(rooms.getEasyChair().getState().equals("Excellent") ){
                        count++;
                       System.out.println("Easy Chair in"+rooms.getRoomID() + "in Excellent Condition");
                   }
                   if(rooms.getMattress().getState().equals("Excellent") ){
                    count++;
                   System.out.println("Mattress in"+rooms.getRoomID() + "in Excellent Condition");
                    }
                    if(rooms.getCloset().getState().equals("Excellent") ){
                        count++;
                    System.out.println("Closet in"+rooms.getRoomID() + "in Excellent Condition");
                }
                if(rooms.getCoffeeTable().getState().equals("Excellent") ){
                    count++;
                System.out.println("Coffee Table in"+rooms.getRoomID() + "in Excellent Condition");
            }
            if(rooms.getStudyTable().getState().equals("Excellent") ){
                count++;
               System.out.println("StudyTable"+rooms.getRoomID() + "in Excellent Condition");
           }
           if(rooms.getChestOfDraws().getState().equals("Excellent") ){
            count++;
           System.out.println("ChestOfDraws"+rooms.getRoomID() + "in Excellent Condition");
       }
       if(rooms.getWall().getState().equals("Excellent") ){
        count++;
       System.out.println("wall in"+rooms.getRoomID() + "in Excellent Condition");
   }
   if(rooms.getWindow().getState().equals("Excellent") ){
    count++;
   System.out.println("window in"+rooms.getRoomID() + "in Excellent Condition");
}

///////////System.out.println("Total Furniture in Excellent Condition"+ count);
            

                }
 else if (rooms.getRoomType().equals("Double")){
                    

     if(rooms.getBed().getState().equals("Excellent") ){
        count++;
         System.out.println("Bed in"+rooms.getRoomID() + "in Excellent Condition");
                   }
       if(rooms.getEasyChair().getState().equals("Excellent") ){
                       count++;
                      System.out.println("Easy Chair in"+rooms.getRoomID() + "in Excellent Condition");
                  }
             if(rooms.getMattress().getState().equals("Excellent") ){
                   count++;
                  System.out.println("Mattress in"+rooms.getRoomID() + "in Excellent Condition");
                   }
                 if(rooms.getCloset().getState().equals("Excellent") ){
                       count++;
                   System.out.println("Closet in"+rooms.getRoomID() + "in Excellent Condition");
               }
                    if(rooms.getCoffeeTable().getState().equals("Excellent") ){
                        count++;
                    System.out.println("Coffee Table in"+rooms.getRoomID() + "in Excellent Condition");
                }
                        if(rooms.getStudyTable().getState().equals("Excellent") ){
                    count++;
                    System.out.println("StudyTable"+rooms.getRoomID() + "in Excellent Condition");
                }
                    if(rooms.getChestOfDraws().getState().equals("Excellent") ){
                count++;
                System.out.println("ChestOfDraws"+rooms.getRoomID() + "in Excellent Condition");
            }
                if(rooms.getWall().getState().equals("Excellent") ){
            count++;
            System.out.println("wall in"+rooms.getRoomID() + "in Excellent Condition");
        }
             if(rooms.getWindow().getState().equals("Excellent") ){
        count++;
        System.out.println("window in"+rooms.getRoomID() + "in Excellent Condition");
        }

/////////////////doubles ///////////////////////////

               
if(rooms.getBed2().getState().equals("Excellent") ){
    count++;
     System.out.println("Bed2 in"+rooms.getRoomID() + "in Excellent Condition");
               }
   if(rooms.getEasyChair2().getState().equals("Excellent") ){
                   count++;
                  System.out.println("Easy Chair2 in"+rooms.getRoomID() + "in Excellent Condition");
              }
         if(rooms.getMattress2().getState().equals("Excellent") ){
               count++;
              System.out.println("Mattress2 in"+rooms.getRoomID() + "in Excellent Condition");
               }
             if(rooms.getCloset2().getState().equals("Excellent") ){
                   count++;
               System.out.println("Closet2 in"+rooms.getRoomID() + "in Excellent Condition");
           }
                if(rooms.getCoffeeTable2().getState().equals("Excellent") ){
                    count++;
                System.out.println("Coffee2 Table in"+rooms.getRoomID() + "in Excellent Condition");
            }
                    if(rooms.getStudyTable2().getState().equals("Excellent") ){
                count++;
                System.out.println("StudyTable2"+rooms.getRoomID() + "in Excellent Condition");
            }
                if(rooms.getChestOfDraws2().getState().equals("Excellent") ){
            count++;
            System.out.println("ChestOfDraws2"+rooms.getRoomID() + "in Excellent Condition");
        }
            if(rooms.getWall2().getState().equals("Excellent") ){
        count++;
        System.out.println("wall2 in"+rooms.getRoomID() + "in Excellent Condition");
    }
         if(rooms.getWindow2().getState().equals("Excellent") ){
    count++;
    System.out.println("window2 in"+rooms.getRoomID() + "in Excellent Condition");
    }      

   //////////// System.out.println("Total Furniture in Excellent Condition"+ count);   
}

            }


        }


        System.out.println("Total Furniture in Excellent Condition"+ count);
        
    }



    //show all in fair conndition
    public void DisplayFair(){     
        int count = 0;

        for(Block blocks: TaylorHall.getBlocks()){
            for(Room rooms : block.getRooms()){
                if(rooms.getRoomType().equals("Single")){

                    if(rooms.getBed().getState().equals("Fair") ){
                         count++;
                        System.out.println("Bed in"+rooms.getRoomID() + "in Fair Condition");
                    }
                    if(rooms.getEasyChair().getState().equals("Fair") ){
                        count++;
                       System.out.println("Easy Chair in"+rooms.getRoomID() + "in Fair Condition");
                   }
                   if(rooms.getMattress().getState().equals("Fair") ){
                    count++;
                   System.out.println("Mattress in"+rooms.getRoomID() + "in Fair Condition");
                    }
                    if(rooms.getCloset().getState().equals("Fair") ){
                        count++;
                    System.out.println("Closet in"+rooms.getRoomID() + "in Fair Condition");
                }
                if(rooms.getCoffeeTable().getState().equals("Fair") ){
                    count++;
                System.out.println("Coffee Table in"+rooms.getRoomID() + "in Fair Condition");
            }
            if(rooms.getStudyTable().getState().equals("Fair") ){
                count++;
               System.out.println("StudyTable"+rooms.getRoomID() + "in Fair Condition");
           }
           if(rooms.getChestOfDraws().getState().equals("Fair") ){
            count++;
           System.out.println("ChestOfDraws"+rooms.getRoomID() + "in FairCondition");
       }
       if(rooms.getWall().getState().equals("Fair") ){
        count++;
       System.out.println("wall in"+rooms.getRoomID() + "in Fair Condition");
   }
   if(rooms.getWindow().getState().equals("Fair") ){
    count++;
   System.out.println("window in"+rooms.getRoomID() + "in Fair Condition");
}

///////////System.out.println("Total Furniture in Excellent Condition"+ count);
            

                }
 else if (rooms.getRoomType().equals("Double")){
                    

     if(rooms.getBed().getState().equals("Fair") ){
        count++;
         System.out.println("Bed in"+rooms.getRoomID() + "in Fair Condition");
                   }
       if(rooms.getEasyChair().getState().equals("Fair") ){
                       count++;
                      System.out.println("Easy Chair in"+rooms.getRoomID() + "in Fair Condition");
                  }
             if(rooms.getMattress().getState().equals("Fair") ){
                   count++;
                  System.out.println("Mattress in"+rooms.getRoomID() + "in Fair Condition");
                   }
                 if(rooms.getCloset().getState().equals("Fair") ){
                       count++;
                   System.out.println("Closet in"+rooms.getRoomID() + "in Fair Condition");
               }
                    if(rooms.getCoffeeTable().getState().equals("Fair") ){
                        count++;
                    System.out.println("Coffee Table in"+rooms.getRoomID() + "in Fair Condition");
                }
                        if(rooms.getStudyTable().getState().equals("Fair") ){
                    count++;
                    System.out.println("StudyTable"+rooms.getRoomID() + "in Fair Condition");
                }
                    if(rooms.getChestOfDraws().getState().equals("Fair") ){
                count++;
                System.out.println("ChestOfDraws"+rooms.getRoomID() + "in Fair Condition");
            }
                if(rooms.getWall().getState().equals("Fair") ){
            count++;
            System.out.println("wall in"+rooms.getRoomID() + "in Fair Condition");
        }
             if(rooms.getWindow().getState().equals("Fair") ){
        count++;
        System.out.println("window in"+rooms.getRoomID() + "in Fair Condition");
        }

/////////////////doubles ///////////////////////////

               
if(rooms.getBed2().getState().equals("Fair") ){
    count++;
     System.out.println("Bed2 in"+rooms.getRoomID() + "in Fair Condition");
               }
   if(rooms.getEasyChair2().getState().equals("Fair") ){
                   count++;
                  System.out.println("Easy Chair2 in"+rooms.getRoomID() + "in Fair Condition");
              }
         if(rooms.getMattress2().getState().equals("Fair") ){
               count++;
              System.out.println("Mattress2 in"+rooms.getRoomID() + "in Fair Condition");
               }
             if(rooms.getCloset2().getState().equals("Fair") ){
                   count++;
               System.out.println("Closet2 in"+rooms.getRoomID() + "in Fair Condition");
           }
                if(rooms.getCoffeeTable2().getState().equals("Fair") ){
                    count++;
                System.out.println("Coffee2 Table in"+rooms.getRoomID() + "in Fair Condition");
            }
                    if(rooms.getStudyTable2().getState().equals("Fair") ){
                count++;
                System.out.println("StudyTable2"+rooms.getRoomID() + "in Fair Condition");
            }
                if(rooms.getChestOfDraws2().getState().equals("Fair") ){
            count++;
            System.out.println("ChestOfDraws2"+rooms.getRoomID() + "in Fair Condition");
        }
            if(rooms.getWall2().getState().equals("Fair") ){
        count++;
        System.out.println("wall2 in"+rooms.getRoomID() + "in Fair Condition");
    }
         if(rooms.getWindow2().getState().equals("Fair") ){
    count++;
    System.out.println("window2 in"+rooms.getRoomID() + "in Fair Condition");
    }      

   //////////// System.out.println("Total Furniture in Excellent Condition"+ count);   
}

            }


        }


        System.out.println("Total Furniture in Fair Condition"+ count);
        
    }






        
    
    // all in poor 
    public void Poor(){
        int count = 0;

    for(Block blocks: TaylorHall.getBlocks()){
        for(Room rooms : block.getRooms()){
            if(rooms.getRoomType().equals("Poor")){

                if(rooms.getBed().getState().equals("Poor") ){
                     count++;
                    System.out.println("Bed in"+rooms.getRoomID() + "in Poor Condition");
                }
                if(rooms.getEasyChair().getState().equals("Excellent") ){
                    count++;
                   System.out.println("Easy Chair in"+rooms.getRoomID() + "in Poor Condition");
               }
               if(rooms.getMattress().getState().equals("Poor") ){
                count++;
               System.out.println("Mattress in"+rooms.getRoomID() + "in Poor Condition");
                }
                if(rooms.getCloset().getState().equals("Poor") ){
                    count++;
                System.out.println("Closet in"+rooms.getRoomID() + "in Poor Condition");
            }
            if(rooms.getCoffeeTable().getState().equals("Poor") ){
                count++;
            System.out.println("Coffee Table in"+rooms.getRoomID() + "in Poor Condition");
        }
        if(rooms.getStudyTable().getState().equals("Poor") ){
            count++;
           System.out.println("StudyTable"+rooms.getRoomID() + "in Poor Condition");
       }
       if(rooms.getChestOfDraws().getState().equals("Poor") ){
        count++;
       System.out.println("ChestOfDraws"+rooms.getRoomID() + "in Poor Condition");
   }
   if(rooms.getWall().getState().equals("Poor") ){
    count++;
   System.out.println("wall in"+rooms.getRoomID() + "in Poor Condition");
}
if(rooms.getWindow().getState().equals("Poor") ){
count++;
System.out.println("window in"+rooms.getRoomID() + "in Poor Condition");
}

///////////System.out.println("Total Furniture in Excellent Condition"+ count);
        

            }
else if (rooms.getRoomType().equals("Double")){
                

 if(rooms.getBed().getState().equals("Poor") ){
    count++;
     System.out.println("Bed in"+rooms.getRoomID() + "in EPoor Condition");
               }
   if(rooms.getEasyChair().getState().equals("Poor") ){
                   count++;
                  System.out.println("Easy Chair in"+rooms.getRoomID() + "in Poor Condition");
              }
         if(rooms.getMattress().getState().equals("Poor") ){
               count++;
              System.out.println("Mattress in"+rooms.getRoomID() + "in Poor Condition");
               }
             if(rooms.getCloset().getState().equals("Poor") ){
                   count++;
               System.out.println("Closet in"+rooms.getRoomID() + "in Poor Condition");
           }
                if(rooms.getCoffeeTable().getState().equals("Poor") ){
                    count++;
                System.out.println("Coffee Table in"+rooms.getRoomID() + "in Poor Condition");
            }
                    if(rooms.getStudyTable().getState().equals("Poor") ){
                count++;
                System.out.println("StudyTable"+rooms.getRoomID() + "in Poor Condition");
            }
                if(rooms.getChestOfDraws().getState().equals("Poor") ){
            count++;
            System.out.println("ChestOfDraws"+rooms.getRoomID() + "in Poor Condition");
        }
            if(rooms.getWall().getState().equals("Poor") ){
        count++;
        System.out.println("wall in"+rooms.getRoomID() + "in Poor Condition");
    }
         if(rooms.getWindow().getState().equals("Poor") ){
    count++;
    System.out.println("window in"+rooms.getRoomID() + "in Poor Condition");
    }

/////////////////doubles ///////////////////////////

           
if(rooms.getBed2().getState().equals("Poor") ){
count++;
 System.out.println("Bed2 in"+rooms.getRoomID() + "in Poor Condition");
           }
if(rooms.getEasyChair2().getState().equals("Poor") ){
               count++;
              System.out.println("Easy Chair2 in"+rooms.getRoomID() + "in Poor Condition");
          }
     if(rooms.getMattress2().getState().equals("Poor") ){
           count++;
          System.out.println("Mattress2 in"+rooms.getRoomID() + "in Poor Condition");
           }
         if(rooms.getCloset2().getState().equals("Poor") ){
               count++;
           System.out.println("Closet2 in"+rooms.getRoomID() + "in Poor Condition");
       }
            if(rooms.getCoffeeTable2().getState().equals("Poor") ){
                count++;
            System.out.println("Coffee2 Table in"+rooms.getRoomID() + "in Poor Condition");
        }
                if(rooms.getStudyTable2().getState().equals("Poor") ){
            count++;
            System.out.println("StudyTable2"+rooms.getRoomID() + "in PoorCondition");
        }
            if(rooms.getChestOfDraws2().getState().equals("Poor") ){
        count++;
        System.out.println("ChestOfDraws2"+rooms.getRoomID() + "in Poor Condition");
    }
        if(rooms.getWall2().getState().equals("Poor") ){
    count++;
    System.out.println("wall2 in"+rooms.getRoomID() + "in Poor Condition");
}
     if(rooms.getWindow2().getState().equals("Poor") ){
count++;
System.out.println("window2 in"+rooms.getRoomID() + "in Poor Condition");
}      

//////////// System.out.println("Total Furniture in Excellent Condition"+ count);   
}

        }


    }


    System.out.println("Total Furniture in Excellent Condition"+ count);
    
}
        
        
    
    //total oocupants in each block 

    
    public static void main(String[] args) {
        // Example login attempts
     
        TaylorAdmin TaylorHall = new TaylorAdmin(DataManager.loadData());
        
   
        ReportGenerator  ReportGenerator1 = new ReportGenerator();
        ReportGenerator1.blockCount();
       // ReportGenerator1.listAllBlocks();
        }


}




       
