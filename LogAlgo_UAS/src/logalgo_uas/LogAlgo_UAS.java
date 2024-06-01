package logalgo_uas;
import java.util.Random;
import java.util.Scanner;
public class LogAlgo_UAS {
   
   public static String[] pemain = new String[20];
   public static String[] easy1 = {"bakso", "pecel", "tempe", "pizza", "telur", "steak", "bayam", "melon", "ramen", "gudeg", "dodol", "nanas", "rujak", "bubur", "donat", "pukis", "jelly", "cakue", "tomat", "sushi"};
   public static String[] easy2 = {"lampu", "kipas", "pisau", "gelas", "galon", "garpu", "sikat", "botol", "sabun", "tikar", "kursi", "jepit", "kasur", "pintu", "kabel", "kunci", "raket", "remot", "wajan", "panci"};
   public static String[] medium1 = {"batagor", "kwetiaw", "kerupuk", "kesemek", "lontong", "biskuit", "seblak", "pisang", "burger", "karedok", "mendoan", "lasagna", "tumpeng", "ketoprak", "pempek", "srikaya", "markisa", "manggis", "jengkol", "alpukat"};
   public static String[] medium2 = {"lipstik", "knalpot", "keramik", "bendera", "gergaji", "adaptor", "prangko", "setrika", "sepedah", "cangkir", "pesawat", "kabinet", "majalah", "pakaian", "kalender", "shampoo", "telephone", "lukisan", "sarung", "sajadah"};
   public static String[] hard1 = {"buburayam", "nasigoreng", "rotibakar", "rotigoreng", "spaghetti", "pisanggoreng", "kentanggoreng", "ayamgoreng", "tahubulat", "mieayam", "sosissolo", "nasikuning", "tahuisi", "nasipadang", "nasibakar", "rotigoreng", "terangbulan", "croissant", "nasikrawu", "lontongbalap"};
   public static String[] hard2 = {"kursiroda", "mesincuci", "ricecooker", "dispenser", "airconditioner", "sepaturoda", "pastagigi", "humidifier", "bolabasket", "microwave", "tempattidur", "mejabelajar", "lemaribaju", "jamdinding", "jamtangan", "bukugambar", "bukutulis", "rakbuku", "raksepatu", "pensilwarna"};
   public static int[][] skor = new int[20][2];
   public static String user, word, tebak;
   public static int players, indeks, akun, level, life, totallife, skorr, lanjut, kategori, c;
   public static boolean ketemu;
  
   public static Scanner input = new Scanner(System.in);
   public static Random random = new Random();
   
   public static void search() {
      ketemu = false;
      for(int i=0; i<players; i++){
         if(user.equalsIgnoreCase(pemain[i])){
            ketemu = true;
            indeks = i;
            break;
         }
      }
   }

   public static void randomm() {
      Scanner sc = new Scanner(System.in);
      life = 7;
      switch(level){
         case 1 -> {
            if(kategori==1){
               word = easy1[(int) (Math.random() * easy1.length)];
            } else { 
               word = easy2[(int) (Math.random() * easy2.length)];
            }
            
            tebak = new String(new char[word.length()]).replace("\0", "-");
         }
         
         case 2 -> {
            if(kategori==1){
               word = medium1[(int) (Math.random() * medium1.length)];
            } else { 
               word = medium2[(int) (Math.random() * medium2.length)];
            }
            tebak = new String(new char[word.length()]).replace("\0", "-");
         }
         
         case 3 -> {
            if(kategori==1){
               word = hard1[(int) (Math.random() * hard1.length)];
            } else { 
               word = hard2[(int) (Math.random() * hard2.length)];
            }
            tebak = new String(new char[word.length()]).replace("\0", "-");
         }
      }
      
      while (life>0 && tebak.contains("-")){
         System.out.println("");
         System.out.println("Hangman : " +tebak);
         System.out.print("Tebak huruf : ");
         String guess = sc.next();
         hang(guess);
      }
   }
   
   public static void hang(String guess) {
      String a = "";
      for (int i=0; i<word.length(); i++){
         if (word.charAt(i) == guess.charAt(0)){
            a += guess.charAt(0);
         } else if (tebak.charAt(i) != '-') {
            a += word.charAt(i);
         } else {
            a += "-";
         }
      }
      
      if (tebak.equals(a)) {
         life--;
         hangmanImage();
      } else {
         tebak = a;
      }
      
      if (tebak.equals(word)) {
         System.out.println("Benar!! Anda Menang!! Kata yang dimaksud adalah " + word);
      }
   }
   
   public static void hangmanImage() {
      if (life == 6) {
         System.out.println("Tebakan salah, coba lagi ");
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println("___|___");
         nyawaa();
         
      }
      if (life == 5) {
         System.out.println("Tebakan salah, coba lagi ");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("___|___");
         nyawaa();
      }
      if (life == 4) {
         System.out.println("Tebakan salah, coba lagi ");
         System.out.println("   ____________");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   | ");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("___|___");
         nyawaa();
      }
      if (life == 3) {
         System.out.println("Tebakan salah, coba lagi ");
         System.out.println("   ____________");
         System.out.println("   |          _|_");
         System.out.println("   |         /   \\");
         System.out.println("   |        |     |");
         System.out.println("   |         \\_ _/");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("___|___");
         nyawaa();
      }
      if (life == 2) {
         System.out.println("Tebakan salah, coba lagi ");
         System.out.println("   ____________");
         System.out.println("   |          _|_");
         System.out.println("   |         /   \\");
         System.out.println("   |        |     |");
         System.out.println("   |         \\_ _/");
         System.out.println("   |           |");
         System.out.println("   |           |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("   |");
         System.out.println("___|___");
         nyawaa();
      }
      if (life == 1) {
         System.out.println("Tebakan salah, coba lagi ");
         System.out.println("   ____________");
         System.out.println("   |          _|_");
         System.out.println("   |         /   \\");
         System.out.println("   |        |     |");
         System.out.println("   |         \\_ _/");
         System.out.println("   |           |");
         System.out.println("   |           |");
         System.out.println("   |          / \\ ");
         System.out.println("   |         /   \\");
         System.out.println("   |");
         System.out.println("___|___");
         nyawaa();
      }
      if (life == 0) {
         System.out.println("GAME OVER!");
         System.out.println("   ____________");
         System.out.println("   |          _|_");
         System.out.println("   |         /   \\");
         System.out.println("   |        |     |");
         System.out.println("   |         \\_ _/");
         System.out.println("   |          _|_");
         System.out.println("   |         / | \\");
         System.out.println("   |          / \\ ");
         System.out.println("   |         /   \\");
         System.out.println("   |");
         System.out.println("___|___");
         nyawaa();
         
         System.out.println("Uh oh.. there's a hang(ed) man.. GAME OVER!!  ");
         System.out.println("Kata yang dimaksud adalah " + word);
         totallife = totallife-1;
    }
	}
   
   public static void nyawaa(){
      if(life==7){
         System.out.println("Nyawa : ||||| ||");
      }
      if(life==6){
         System.out.println("Nyawa : ||||| |");
      }
      if(life==5){
         System.out.println("Nyawa : |||||");
      }
      if(life==4){
         System.out.println("Nyawa : ||||");
      }
      if(life==3){
         System.out.println("Nyawa : |||");
      }
      if(life==2){
         System.out.println("Nyawa : ||");
      }
      if(life==1){
         System.out.println("Nyawa : |");
      }
      if(life==0){
         System.out.println("Nyawa : Habis!!!");
      }
   }
   
   public static void score() {
      switch(level){
         case 1 -> {
            switch(life){
               case 0 -> { skorr = 0; score2(); }
               case 1 -> { skorr = 20; score2(); }
               case 2 -> { skorr = 25; score2(); }
               case 3 -> { skorr = 30; score2(); }
               case 4 -> { skorr = 35; score2(); }
               case 5 -> { skorr = 40; score2(); }
               case 6 -> { skorr = 45; score2(); }
               case 7 -> { skorr = 60; score2(); }
            }
         }
         
         case 2 -> {
            switch(life){
               case 0 -> { skorr = 0; score2(); }
               case 1 -> { skorr = 30; score2(); }
               case 2 -> { skorr = 35; score2(); }
               case 3 -> { skorr = 40; score2(); }
               case 4 -> { skorr = 45; score2(); }
               case 5 -> { skorr = 50; score2(); }
               case 6 -> { skorr = 55; score2(); }
               case 7 -> { skorr = 70; score2(); }
            }
         }
         
         case 3 -> {
            switch(life){
               case 0 -> { skorr = 0; score2(); }
               case 1 -> { skorr = 40; score2(); }
               case 2 -> { skorr = 45; score2(); }
               case 3 -> { skorr = 50; score2(); }
               case 4 -> { skorr = 55; score2(); }
               case 5 -> { skorr = 60; score2(); }
               case 6 -> { skorr = 65; score2(); }
               case 7 -> { skorr = 80; score2(); }
            }
         }
      }
   }
   
   public static void score2() {
      skor[akun][0] = skor[akun][0] + 1;
      skor[akun][1] = skor[akun][1] + skorr;
      
      System.out.println("Wohoooo, dapat skor " + skorr);
   }
   
   public static void sort() {
      int temp1, temp3;
      String temp2;
      
      for(int a=0; a<=players-2; a++){
         for(int b=players-1; b>a; b--){
            if(skor[b][1] < skor[b-1][1]){
               
               //swap 1
               temp1 = skor[b][0];
               skor[b][0] = skor[b-1][0];
               skor[b-1][0] = temp1;
               
               //swap 2
               temp2 = pemain[b];
               pemain[b] = pemain[b-1];
               pemain[b-1] = temp2;
               
               //swap 3
               temp3 = skor[b][1];
               skor[b][1] = skor[b-1][1];
               skor[b-1][1] = temp3;
            }
         }
      }
   }
   
   public static void main(String[] args) {

      System.out.println("=================== WELCOME TO HANGMAN GAME ===================");
      int menu; players = 0;
      do{
         System.out.println("--------------------------- Menu ---------------------------");
         System.out.println("1. Main Hangman   2. Top Skor   3. Tutorial    4. Keluar");
         System.out.print("==> Pilih : ");
         menu = input.nextInt();
         System.out.println("");
         
         switch(menu){
            //main hangman
            case 1 -> {
               System.out.print("Masukkan nama : ");
               user = input.next();
               search();
               if(ketemu==false){
                  pemain[players] = user;
                  akun = players;
                  players = players+1;
               }
               else {
                  akun = indeks;
               }
               System.out.println("---------------------------Level---------------------------");
               System.out.println("1. Mudah\t 2. Medium\t 3. Sulit");
               System.out.print("==> Pilih level : ");
               level = input.nextInt();
               
               switch(level){
                  case 1 -> {
                     System.out.println("----------------------- Easy Level -----------------------");
                     System.out.println("Kategori : 1. Makanan, 2. Benda");
                     System.out.print("==> Pilih : ");
                     kategori = input.nextInt();
                     totallife = 3; 
                     do{
                        randomm(); score();
                        System.out.println("_____________");
                        System.out.println("Nyawa tersisa : " + totallife);
                        System.out.println("Lanjut main?");
                        System.out.print("1. ya, 2. tidak : ");
                        lanjut = input.nextInt();
                        skorr=0;
                     }while(totallife>0 && lanjut==1);
                     
                     if (totallife==0){
                        System.out.println("Oops.. nyawa kamu habis..");
                     }
                  }
                  
                  case 2 -> {
                     System.out.println("-----------------------Medium Level-----------------------");
                     System.out.println("Kategori : 1. Makanan, 2. Benda");
                     System.out.print("==> Pilih : ");
                     kategori = input.nextInt();
                     totallife = 3;
                     do{
                        randomm(); score();
                        System.out.println("_____________");
                        System.out.println("Nyawa tersisa : " + totallife);
                        System.out.println("Lanjut main?");
                        System.out.print("1. ya, 2. tidak : ");
                        lanjut = input.nextInt();
                        skorr=0;
                     }while(totallife>0 && lanjut==1);
                     
                     if (totallife==0){
                        System.out.println("Oops.. nyawa kamu habis..");
                     }
                  }
                  
                  case 3 -> {
                     System.out.println("----------------------- Hard Level -----------------------");
                     System.out.println("Kategori : 1. Makanan, 2. Benda");
                     System.out.print("==> Pilih : ");
                     kategori = input.nextInt();
                     totallife = 3;
                     do{
                        randomm(); score();
                        System.out.println("_____________");
                        System.out.println("Nyawa tersisa : " + totallife);
                        System.out.println("Lanjut main?");
                        System.out.print("1. ya, 2. tidak : ");
                        lanjut = input.nextInt();
                        skorr=0;
                     }while(totallife>0 && lanjut==1);
                     
                     if (totallife==0){
                        System.out.println("Oops.. nyawa kamu habis..");
                     }
                  }
               }
               
            }
            
            //top skor
            case 2 -> {
               c = 1; sort();
               System.out.println("-----------------------Top Score-----------------------");
               System.out.println("No \tNama \t\tSkor \tJumlah Permainan");

                  for(int i=players-1; i>=0; i--){
                     System.out.println((c) + "\t" +pemain[i] +"\t\t"+ skor[i][1] +"\t\t"+ skor[i][0]);
                     c++;
                  }
                  System.out.println("");
            }
            
            //tutorial
            case 3 -> {
               System.out.println(" ______________________________________________________________");
               System.out.println("                        Tutorial Hangman");
               System.out.println("1. Akan diberikan kata acak dengan panjang huruf bervariasi sesuai level.");
               System.out.println("2. Pemain dipersilahkan menebak satu-persatu huruf dari kata tersenut.");
               System.out.println("3. Apabila huruf ada dalam kata, maka akan ditampilkan.");
               System.out.println("4. Pemain akan terus menebak sampai semua huruf terbongkar atau kesempatan habis (7x)");
               System.out.println("5. Skor akan diberikan tergantung seberapa banyak kesempatan tersisa dan level yang dipilih.");
               System.out.println("6. Khusus level Hard, terdapat beberapa kata yang terdiri dari 2 suku kata kemudian digabung");
               System.out.println("6. Setiap kali bermain, pemain akan diberikan 3 nyawa");
               System.out.println("7. Pada menu Top Score akan ditampilkan pemain dengan skor tertinggi.");
               System.out.println(" ______________________________________________________________");
            }
         }
      }while(menu!=4);
      
      System.out.println("===================== BYE-BYE! THANK YOU! =====================");
      System.out.println("");
   } 
}
