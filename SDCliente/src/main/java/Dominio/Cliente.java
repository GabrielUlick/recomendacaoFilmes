package Dominio;

import java.io.IOException;
import java.net.*;

public class Cliente {

    private String nomeDNS;
    private int serverPort;
    private byte[] meuIP;

    public Cliente() {
        try {
            InetAddress endereco = InetAddress.getLocalHost();
            nomeDNS = endereco.getHostName();
            meuIP = endereco.getAddress();
        } catch (UnknownHostException e) {
            System.out.println("Host Desconhecido: " + e.getMessage());
        }
        serverPort = 6789;
    }

    public String enviaMensagem(String mensagem) throws UnknownHostException, IOException {
        DatagramSocket aSocket = null;
        String resposta = "";
        try {
            aSocket = new DatagramSocket();
            byte[] m = mensagem.getBytes();
            InetAddress aHost = InetAddress.getByName(nomeDNS);
            DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
            aSocket.send(request);
            byte[] buffer = new byte[600];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            resposta = new String(reply.getData()).trim();
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Input Output: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
        return resposta;
    }

    public String[] getUsuarios() throws IOException {
        return enviaMensagem("5,getUsuarios").split(",");
    }

    public String[] getFilmes() {
        String mensagem = "6,getFilmes";
        try {
            String resposta = enviaMensagem(mensagem);
            return resposta.split(",");
        } catch (IOException e) {
            return new String[]{"Erro ao obter a lista de filmes"};
        }
    }

    public String enviarAvaliacao(int usuario, int filme, int nota) {
        String mensagem = "2," + usuario + "," + filme + "," + nota;
        try {
            return enviaMensagem(mensagem);
        } catch (IOException e) {
            System.out.println("Erro ao enviar avaliação");
        }
        return "";
    }

    public String solicitarRecomendacao(int usuario) {
        String mensagem = "3," + usuario;
        try {
            return enviaMensagem(mensagem);
        } catch (IOException e) {
            return "Erro ao solicitar recomendação";
        }
    }

    public String listarAvaliacoes(int usuarioIndex) {
        String mensagem = "4," + usuarioIndex;
        try {
            return enviaMensagem(mensagem);
        } catch (IOException e) {
            return "Erro ao listar avaliações";
        }
    }

}
