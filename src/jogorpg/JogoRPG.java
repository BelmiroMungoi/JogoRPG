
package jogorpg;

/**
 *
 * @author Belmiro-Mungoi
 */
import java.io.*;
import java.util.Random;

public class JogoRPG {

    public static void main(String[] args) throws IOException{
        batalha();
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int cont = 1, record = 0, pontos;
        while (cont == 1){
            
            pontos = batalha();
            System.out.println("\nO jogador chegou a " + pontos + " pontos");
            if(pontos > record){
                record = pontos;
            }
            System.out.println("======== Novo Record: " + record +" ========");
            System.out.println("\n====== GAME OVER ======\nDeseja continuar?\n1-SIM == 2-NAO");
            cont = Integer.parseInt(br.readLine());
        }
    }
    
    static void vizualizarVida(int vidaUsuario, int vidaComputador, int contEspecial){
        System.out.println("===============================");
        System.out.println("-----* Vida Usuario *----: " + vidaUsuario);
        System.out.println("---* Vida Computador *---: " + vidaComputador);
        System.out.println("=== Ataques  especias ===: " + contEspecial);
        System.out.println("===============================");
    }
    
    static int batalha()throws IOException{
        int vidaUsuario = 180, vidaComputador = 15, contEspecial = 7;
        int ataque, i = 1;
        
        while(vidaUsuario > 0){
            vidaComputador = 14 + i;
            
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Inimigo: " + i);
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
            
            while (vidaUsuario > 0 && vidaComputador > 0){
                 vizualizarVida(vidaUsuario, vidaComputador, contEspecial);
                ataque = escolhaAtaque();
                switch(ataque){
                    case 1:
                        System.out.println("\nUsuario atacou usando um soco.");
                        vidaComputador -= 10;
                        break;
                    case 2:
                        System.out.println("Usuario atacou usando o ataque especial");
                        vidaComputador -= 25;
                        contEspecial--;
                        break;
                    default:
                        System.out.println("INVALIDO!!!");
                }
                if(vidaComputador > 0){
                    ataque = ataqueComputador();
                    switch(ataque){
                        case 1: System.out.println("Computador atacou usando um soco");
                            vidaUsuario -= 5 + (int)(i/10);
                            break;
                        case 2: System.out.println("Computador atacou usando um pontape");
                            vidaUsuario -= 8 + (int)(i/10);;
                            break;
                        case 3: System.out.println("Computador atacou usando o ataque especial");
                            vidaUsuario -= 7 + (int)(i/20);;
                        break;
                    }
                } else {
                    System.out.println("\n====== Inimigo Derrotado ======");
                  }
            }
            if(vidaUsuario > 0){
                vidaUsuario +=5;
                if(vidaUsuario == 180) {
                    vidaUsuario = 180;
                }
                if (i % 10 == 0){
                    contEspecial++;
                    if(contEspecial > 7){
                        contEspecial = 7;
                    }
                }
            }
            i++;
        }
        return i;
    }
    
    static int escolhaAtaque() throws IOException{
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        int num;
        System.out.println("Escolha o seu ataque: ");
        System.out.println("1- Soco\n2-Ataque Especial");
        num = Integer.parseInt(br.readLine());
        return num;
    }
    
    static int ataqueComputador(){
        Random  gerar = new Random();
        return gerar.nextInt(3)+1;
    }
    
}
