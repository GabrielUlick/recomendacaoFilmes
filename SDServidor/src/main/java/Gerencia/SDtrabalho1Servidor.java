package Gerencia;

import java.io.IOException;
import java.net.*;

public class SDtrabalho1Servidor {

    private static BaseDeDados bd = null;

    public static void main(String[] args) {
        DatagramSocket aSocket = null;
        bd = new BaseDeDados(10, 20);

        try {
            aSocket = new DatagramSocket(6789);

            while (true) {
                //==== RECEBIMENTO DE MENSAGEM DO CLIENTE =====================================

                byte[] buffer = new byte[600];
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);

                //==== PROCESSAMENTO DO SERVIDOR SOBRE A MENSAGEM RECEBIDA ====================
                String mensagem = new String(request.getData()).trim();

                String[] mensagemSplit = mensagem.split(",");
                int operacao = Integer.parseInt(mensagemSplit[0]);
                String nomeUsuario = mensagemSplit[1];

                String resposta = "";

                switch (operacao) {
                    case 1:
                        //parte não implementada
                        break;
                    case 2:
                        // Registra avaliação
                        int nomeIndex = Integer.parseInt(nomeUsuario);
                        int filmeIndex = Integer.parseInt(mensagemSplit[2]);
                        int nota = Integer.parseInt(mensagemSplit[3]);
                        resposta = bd.registrarAvaliacao(nomeIndex, filmeIndex, nota);
                        break;
                    case 3:
                        // Solicita recomendação
                        int nomeIndexCase3 = Integer.parseInt(nomeUsuario); // Renomeie a variável para evitar conflito
                        resposta = bd.solicitarRecomendacao(nomeIndexCase3);
                        break;
                    case 4:
                        // Lista avaliações
                        int usuarioIndexCase4 = Integer.parseInt(nomeUsuario);
                        resposta = bd.listarAvaliacoes(usuarioIndexCase4);
                        break;

                    case 5:
                        resposta = bd.getUsuarios();
                        break;
                    case 6:
                        resposta = bd.getFilmes();
                        break;

                    default:
                        resposta = "Operação inválida";
                        break;
                }

                byte[] todasMsg = resposta.getBytes();

                //==== ENVIO DE MENSAGEM DE RESPOSTA ==========================================
                DatagramPacket reply = new DatagramPacket(todasMsg, todasMsg.length, request.getAddress(), request.getPort());

                aSocket.send(reply);
            }//fim do While
        } catch (SocketException e) {
            System.out.println("Servidor - Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Servidor - Input Output: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }//try catch
    }//main
}
