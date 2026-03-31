public class App {
    public static void main(String[] args) throws Exception { 
        MesinKopi mesinLobby = new MesinKopi();   //NO.1

        System.out.println(mesinLobby.bijiKopi);    //NO.4
        System.out.println(mesinLobby.air);     //No.4
        System.out.println(mesinLobby.susu);        //NO.4

        mesinLobby.isiUlangBahan(1000, 5000, 5000);     // NO.2
        System.out.println(mesinLobby.cekBahan());       //NO.3

    }
    
}
