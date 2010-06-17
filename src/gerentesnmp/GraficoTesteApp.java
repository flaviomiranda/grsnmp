/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gerentesnmp;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class GraficoTesteApp {

    public static void main( String[] args )
    {
        List<DadosGrafico> lstDadosG = new ArrayList<DadosGrafico>();
        DadosGrafico d1 = new DadosGrafico(8.9, "vermelho", "% Pacotes recebidos c/ erro");
        DadosGrafico d2 = new DadosGrafico(4.2, "azul", "Taxa Bytes p/seg");
        DadosGrafico d3 = new DadosGrafico(3.7, "amarelo", "Utilização de link");
        DadosGrafico d4 = new DadosGrafico(5.05, "preto", "% datagramas IPs rec/erro");
        DadosGrafico d5 = new DadosGrafico(2.0, "roxo", "Taxa forwarding");
        lstDadosG.add(d1);
        lstDadosG.add(d2);
        lstDadosG.add(d3);
        lstDadosG.add(d4);
        lstDadosG.add(d5);
        Grafico chart = new Grafico("Teste Bar Chart", lstDadosG);
        chart.pack();
        chart.setVisible(true);
    }

}
