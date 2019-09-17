/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Emmanuel-Homecoming
 */
public class Lab5 {

public static void query0(int p) {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:VGRecords.db";
            conn = DriverManager.getConnection(url);           
            System.out.println("Connection to SQLite has been established.");           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
               
       Statement s = null;
       int t=0;
       if(p==0){
          t=1; 
       }
       String [] list ={"Game", "Creator", "Console", "DevCompany"};
       String [] tn ={"Name","Title"};
       
       try{//Code to connect to database goes here (step 2)
           String url = "jdbc:sqlite:VGRecords.db";
           conn = DriverManager.getConnection(url);
           s = conn.createStatement();
           String sql = ("SELECT "+tn[t]+" FROM "+list[p]);
           ResultSet rs = s.executeQuery(sql);
           System.out.println(String.format("List of %s \n", list[p]));
           while(rs.next()){
         //code to access rows goes here
            String Title= rs.getString(tn[t]);    
            System.out.println(String.format("%s",Title));      
           }
           s.close();
           conn.close();
       }catch(Exception e){
           e.printStackTrace();
       }
       System.out.println("\nOn to the next Query.\n");       
    }    
public static void query1(int rt) {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:VGRecords.db";
            conn = DriverManager.getConnection(url);           
            System.out.println("Connection to SQLite has been established.");           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
               
       Statement s = null;
       int rating=rt;
       
       try{//Code to connect to database goes here (step 2)
           String url = "jdbc:sqlite:VGRecords.db";
           conn = DriverManager.getConnection(url);
           s = conn.createStatement();
           String sql = ("SELECT Title FROM Game WHERE rating >="+rating);
           ResultSet rs = s.executeQuery(sql);
           System.out.println(String.format("These are the games above %d \n", rating));
           while(rs.next()){
         //code to access rows goes here
            String GameTitle= rs.getString("Title");    
            System.out.println(String.format("The game is %s",GameTitle));      
           }
           s.close();
           conn.close();
       }catch(Exception e){
           e.printStackTrace();
       }
       System.out.println("\nOn to the next Query.\n");       
    }
public static void query2(String a, String b) {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:VGRecords.db";
            conn = DriverManager.getConnection(url);           
            System.out.println("Connection to SQLite has been established.");           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
               
       Statement s = null;
       

       try{//Code to connect to database goes here (step 2)
           String url = "jdbc:sqlite:VGRecords.db";
           conn = DriverManager.getConnection(url);
           s = conn.createStatement();
           String sql = ("SELECT Title, Creator.Name" + 
                        " FROM Game, InteractsWith, Creator"+
                        " WHERE Creator.Id=CreatorId AND Game.Id=GameId AND"+
                        " ReleaseDate >='"+a+"' AND ReleaseDate<'"+b+"'"
                        );
           ResultSet rs = s.executeQuery(sql);
           System.out.println(String.format("These are the Director and their Games between %s and %s \n", a, b));
           while(rs.next()){
         //code to access rows goes here
            String GameTitle= rs.getString("Title");
            String GameCreator= rs.getString("Name"); 
            
            System.out.println(String.format("%s by %s",GameTitle, GameCreator));      
           }
           s.close();
           conn.close();
       }catch(Exception e){
           e.printStackTrace();
       }
       System.out.println("\nOn to the next Query.\n");       
    }   
public static void query3(String a, String b) {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:VGRecords.db";
            conn = DriverManager.getConnection(url);           
            System.out.println("Connection to SQLite has been established.");           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
               
       Statement s = null;
       

       try{//Code to connect to database goes here (step 2)
           String url = "jdbc:sqlite:VGRecords.db";
           conn = DriverManager.getConnection(url);
           s = conn.createStatement();
           String sql = ("SELECT Title, Publisher.Name" + 
                        " FROM Game, Distributed, Publisher"+
                        " WHERE Publisher.Id=PublisherId AND Game.Id=GameId AND"+
                        " Regions ='"+a+"' AND PlaceOfOrigin='"+b+"';"
                        );
           ResultSet rs = s.executeQuery(sql);
           System.out.println(String.format("These are the Games released to %s by publishers from %s \n", a, b));
           while(rs.next()){
         //code to access rows goes here
            String GameTitle= rs.getString("Title");
            String GamePublisher= rs.getString("Name"); 
            
            System.out.println(String.format("%s distributed by %s",GameTitle, GamePublisher));      
           }
           
           s.close();
           conn.close();
       }catch(Exception e){
           e.printStackTrace();
       }
       System.out.println("\nOn to the next Query.\n");       
    }
public static void query4(String a) {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:VGRecords.db";
            conn = DriverManager.getConnection(url);           
            System.out.println("Connection to SQLite has been established.");           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
               
       Statement s = null;
       

       try{//Code to connect to database goes here (step 2)
           String url = "jdbc:sqlite:VGRecords.db";
           conn = DriverManager.getConnection(url);
           s = conn.createStatement();
           String sql = ("SELECT Name" + 
                        " FROM Game, InteractsWith, Console"+
                        " WHERE Console.Id=ConsoleId AND Game.Id=GameId AND"+
                        " Title ='"+a+"';"
                        );
           ResultSet rs = s.executeQuery(sql);
           System.out.println(String.format("These are the Consoles %s has been released to. \n", a));
           while(rs.next()){
         //code to access rows goes here
            String GameConsole= rs.getString("Name");            
            System.out.println(String.format("%s",GameConsole));      
           }
           
           s.close();
           conn.close();
       }catch(Exception e){
           e.printStackTrace();
       }
       System.out.println("\nOn to the next Query.\n");       
    }
public static void query5(int rt) {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:VGRecords.db";
            conn = DriverManager.getConnection(url);           
            System.out.println("Connection to SQLite has been established.");           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
               
       Statement s = null;
       
       try{//Code to connect to database goes here (step 2)
           String url = "jdbc:sqlite:VGRecords.db";
           conn = DriverManager.getConnection(url);
           s = conn.createStatement();
           String sql = ("SELECT Name FROM Creator "+
                         "EXCEPT "+
                         "SELECT Name FROM Game, Creator "+
                         "WHERE Creator.Id=CreatorId AND rating>="+rt);
           ResultSet rs = s.executeQuery(sql);
           System.out.println(String.format("These are the Creaotrs whose games are below %d \n", rt));
           while(rs.next()){
         //code to access rows goes here
            String GameCreator= rs.getString("Name");    
            System.out.println(String.format("%s",GameCreator));      
           }
           s.close();
           conn.close();
       }catch(Exception e){
           e.printStackTrace();
       }
       System.out.println("\nOn to the next Query.\n");       
    }
public static void query6() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:VGRecords.db";
            conn = DriverManager.getConnection(url);           
            System.out.println("Connection to SQLite has been established.");           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
               
       Statement s = null;
       
       try{//Code to connect to database goes here (step 2)
           String url = "jdbc:sqlite:VGRecords.db";
           conn = DriverManager.getConnection(url);
           s = conn.createStatement();
           String sql = ("SELECT Title FROM Game "+
                         "EXCEPT "+
                         "SELECT Title FROM Game, InteractsWith "+
                         "WHERE Game.Id=GameId AND ReleaseDate <=date('now')");
           ResultSet rs = s.executeQuery(sql);
           System.out.println(String.format("These are the games not released yet. \n"));
           while(rs.next()){
         //code to access rows goes here
            String Game= rs.getString("Title");    
            System.out.println(String.format("%s",Game));      
           }
           s.close();
           conn.close();
       }catch(Exception e){
           e.printStackTrace();
       }
       System.out.println("\nOn to the next Query.\n");       
    }
public static void query7(String a) {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:VGRecords.db";
            conn = DriverManager.getConnection(url);           
            System.out.println("Connection to SQLite has been established.");           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
               
       Statement s = null;
       

       try{//Code to connect to database goes here (step 2)
           String url = "jdbc:sqlite:VGRecords.db";
           conn = DriverManager.getConnection(url);
           s = conn.createStatement();
           String sql = ("SELECT Title" + 
                        " FROM Game, InteractsWith, Console"+
                        " WHERE Console.Id=ConsoleId AND Game.Id=GameId AND"+
                        " Console.Name ='"+a+"';"
                        );
           ResultSet rs = s.executeQuery(sql);
           System.out.println(String.format("These are the Games that was released to %s. \n", a));
           while(rs.next()){
         //code to access rows goes here
            String Game= rs.getString("Title");            
            System.out.println(String.format("%s",Game));      
           }
           
           s.close();
           conn.close();
       }catch(Exception e){
           e.printStackTrace();
       }
       System.out.println("\nOn to the next Query.\n");       
    }
public static void query8() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:VGRecords.db";
            conn = DriverManager.getConnection(url);           
            System.out.println("Connection to SQLite has been established.");           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
               
       Statement s = null;
       
       try{//Code to connect to database goes here (step 2)
           String url = "jdbc:sqlite:VGRecords.db";
           conn = DriverManager.getConnection(url);
           s = conn.createStatement();
           String sql = ("SELECT Title, Rating FROM Game "+
                         "ORDER BY Rating DESC "+
                         "LIMIT 5");
           ResultSet rs = s.executeQuery(sql);
           System.out.println(String.format("These are the top 5 games.\n"));
           int i=1;
           while(rs.next()){
         //code to access rows goes here
            String Game= rs.getString("Title");
            String Rating= rs.getString("Rating"); 
            
            System.out.println(String.format("%d. %s --- %s",i, Game, Rating)); 
            i=i+1;
           }
           s.close();
           conn.close();
       }catch(Exception e){
           e.printStackTrace();
       }
       System.out.println("\nOn to the next Query.\n");       
    }
public static void query9(String a) {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:VGRecords.db";
            conn = DriverManager.getConnection(url);           
            System.out.println("Connection to SQLite has been established.");           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
               
       Statement s = null;
       

       try{//Code to connect to database goes here (step 2)
           String url = "jdbc:sqlite:VGRecords.db";
           conn = DriverManager.getConnection(url);
           s = conn.createStatement();
           String sql = ("SELECT DISTINCT Creator.Name, Genre.Title" + 
                        " FROM Game, GameGenre, Genre, Creator"+
                        " WHERE Creator.Id=CreatorId AND Game.Id=GameId AND"+
                        " Genre.Id=GenreId AND Creator.Name='"+a+"';"
                        );
           ResultSet rs = s.executeQuery(sql);
           System.out.println(String.format("These are the Genres %s was involved with.\n", a));
           while(rs.next()){
         //code to access rows goes here
            String Genre= rs.getString("Title");            
            System.out.println(String.format("%s",Genre));      
           }
           
           s.close();
           conn.close();
       }catch(Exception e){
           e.printStackTrace();
       }
       System.out.println("\nOn to the next Query.\n");       
    }
public static void query10(String a, int year) {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:VGRecords.db";
            conn = DriverManager.getConnection(url);           
            System.out.println("Connection to SQLite has been established.");           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
               
       Statement s = null;
       
       

       try{//Code to connect to database goes here (step 2)
           String url = "jdbc:sqlite:VGRecords.db";
           conn = DriverManager.getConnection(url);
           s = conn.createStatement();
           String sql = ("SELECT Title, ReleaseDate" + 
                        " FROM Game, InteractsWith, DevCompany"+
                        " WHERE DevCompany.Id=DevCompanyId AND Game.Id=GameId AND"+
                        " DevCompany.Name='"+a+"' AND"+
                        " ReleaseDate >= '"+year+"-01-01'  AND ReleaseDate < '"+year+"-12-31'"
                        );
           ResultSet rs = s.executeQuery(sql);
           System.out.println(String.format("These are the Games released by %s in the year %d \n", a, year));
           while(rs.next()){
         //code to access rows goes here
            String GameTitle= rs.getString("Title"); 
            String GameDate= rs.getString("ReleaseDate");
            
            System.out.println(String.format("%s, released on %s",GameTitle, GameDate));      
           }
           s.close();
           conn.close();
       }catch(Exception e){
           e.printStackTrace();
       }
       System.out.println("\nOn to the next Query.\n");       
    } 

     /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
     Scanner myObj1 = new Scanner(System.in);
     System.out.println("To List Current Entries, Type 0");
     System.out.println("To List Games above a certain rating, Type 1");
     System.out.println("To List Games by a Creator within a timeframe, Type 2");
     System.out.println("To List Games released in a specific Region and Publisher, Type 3");
     System.out.println("To List Consoles that have a specific game, Type 4");
     System.out.println("To List Creator who are not above a certain rating, Type 5");
     System.out.println("To List Games not yet released Type 6");
     System.out.println("To List Games released on a specific consoles, Type 7");
     System.out.println("To List The Top 5 Rated Games, Typer 8");
     System.out.println("To List Genres Associate with a Creator, Type 9");
     System.out.println("To List Games made a Developer Company in a certain year, Type 10");
     System.out.println("To Exit, Type 11 ");
     while(true){

     
     System.out.print("Enter Number: ");
     
     int queryno = myObj1.nextInt();
     
    Scanner myObj = new Scanner(System.in);
     switch(queryno){
      
         
     case 0: 
        System.out.print("Select list of Names/Titles for... Game=0, Creator=1, Console=2, DevCompany=3: "); 
        int list=myObj.nextInt();
        query0(list);
      break;    
      
      case 1: 
        System.out.print("Select Rating Games should be above of: "); 
        int score=myObj.nextInt();
        query1(score);
      break;
      
      case 2: 
        System.out.print("Select Date Beginning Date(YYYY-MM-DD): "); 
        String after=myObj.next();
        System.out.print("Select Date Ending Date(YYYY-MM-DD): "); 
         String before=myObj.next();
        query2(after, before);
      break;
      
      case 3: 
        System.out.print("Select Location Distributed to (Japan or USA): "); 
        String region=myObj.next();
        System.out.print("Select Origin Publishers should be from (Japan, USA): "); 
        String origin=myObj.next();
        query3(region, origin);
      break;
      
      case 4: 
        System.out.print("Input Game Title: "); 
        String console=myObj.nextLine();
        query4(console);
      break;
      
      case 5: 
        System.out.print("Select Rating not achieved: "); 
        int rating=myObj.nextInt();
        query5(rating);
      break;
      
      case 6:
        query6();
      break;
      
      case 7: 
        System.out.print("Input Game Console: "); 
        console=myObj.nextLine();
        query7(console);
      break;
      
      case 8:
        query8();
      break;
      
      case 9: 
        System.out.print("Input The Creator's Name: "); 
        String creator=myObj.nextLine();
        query9(creator);
      break;
      
      case 10: 
        System.out.print("Input The Developer Company's Name: "); 
        String dev=myObj.nextLine();
        System.out.print("Input the specified year: "); 
        int y=myObj.nextInt();
        query10(dev, y);
      break;
      
      case 11:
          return;
      
      default:
         System.out.println("Please provide a number from the choices above");  
      break;
      
     }
     }
    }
     
}
