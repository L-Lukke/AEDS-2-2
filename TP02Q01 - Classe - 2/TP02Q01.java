import java.util.Scanner;

public class TP02Q01{
    public static boolean isFim(String word) {
		if (word.equals("FIM"))
			return false;
		else 
			return true;
	}
    public static void main(String [] args) throws Exception{    
        Personagem token = new Personagem();
        String path;
        Scanner sc = new Scanner(System.in);
        path = sc.nextLine();
        path.trim();
        while(!(path.contains("FIM"))){
            token.ler(path);
            token.imprimir();
            path = sc.nextLine();
            path.trim();
        }
        sc.close();
    }
}
