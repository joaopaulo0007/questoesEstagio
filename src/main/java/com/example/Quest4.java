package com.example;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Quest4 {
    static class faturamentoEstado {
        private String estado;
        private double faturamento;
        faturamentoEstado(String estado, double faturamento) {
            this.estado = estado;
            this.faturamento = faturamento;
        }
        String getEstado() {
            return this.estado;
        }
        double getFaturamento() {
            return this.faturamento;
        }
        public void setEstado(String estado) {
            this.estado = estado;
        }
        public void setFaturamento(double faturamento) {
            this.faturamento = faturamento;
        }
    }
    public static void main(String[] args) {
        List<faturamentoEstado> faturamentoEstados = new ArrayList<faturamentoEstado>();
        faturamentoEstados.add(new faturamentoEstado("SP", 67836.43));
        faturamentoEstados.add(new faturamentoEstado("RJ", 36678.66));
        faturamentoEstados.add(new faturamentoEstado("MG", 29229.88));
        faturamentoEstados.add(new faturamentoEstado("ES", 27165.48));
        faturamentoEstados.add(new faturamentoEstado("Outros", 19849.53));

        double totalFaturamento = 0;
        for (faturamentoEstado faturamentoEstado : faturamentoEstados) {
            totalFaturamento += faturamentoEstado.getFaturamento();
        }
        System.out.println("Total de faturamento: " + totalFaturamento);

        double porcentagemFaturamento = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        for (faturamentoEstado faturamentoEstado : faturamentoEstados) {
            porcentagemFaturamento = (faturamentoEstado.getFaturamento() / totalFaturamento) * 100;
            System.out.println(faturamentoEstado.getEstado() + ": " + df.format(porcentagemFaturamento )+ "%");
        }
    }
}
