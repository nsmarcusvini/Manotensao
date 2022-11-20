package com.example.manotensao.dto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;

public class PropostaCSV {
    private String nomeCliente;
    private Integer qtdDias;
    private Double qtdHoras;
    private Double valorTotal;
    private String bairro;
    private String rua;

    public PropostaCSV(String nomeCliente, Integer qtdDias, Double qtdHoras, Double valorTotal, String bairro, String rua) {
        this.nomeCliente = nomeCliente;
        this.qtdDias = qtdDias;
        this.qtdHoras = qtdHoras;
        this.valorTotal = valorTotal;
        this.bairro = bairro;
        this.rua = rua;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public Integer getQtdDias() {
        return qtdDias;
    }

    public Double getQtdHoras() {
        return qtdHoras;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }
    public void gravaArquivoCSV(List<PropostaCSV> lista){
        FileWriter arq = null;
        Formatter saida = null;
        boolean error = false;
        String nomeArq = "propostas.csv";

        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        try {
            saida.format("Nome do cliente;Quantidade de dias;Quantidade de horas;Valor total;Bairro;Rua\n");
            for (int i = 0; i < lista.size(); i++) {
                PropostaCSV p = lista.get(i);
                saida.format("%s;%d;%.2f;%.2f;%s;%s\n",p.getNomeCliente(),p.getQtdDias(),p.getQtdHoras(),
                        p.getValorTotal(),p.getBairro(),p.getRua());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
            error = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                error = true;
            }
            if (error) {
                System.exit(1);
            }
        }
    }
}
