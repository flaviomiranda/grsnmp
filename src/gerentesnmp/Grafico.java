/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gerentesnmp;

import java.awt.HeadlessException;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author 
 */
public class Grafico extends JFrame{

    public Grafico(String title, List<DadosGrafico> lstDados) throws HeadlessException {
        super(title);
        CategoryDataset dataset = Grafico.createDataset(lstDados);
        JFreeChart chart = Grafico.createBarChart(dataset);
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(700, 600));
        setContentPane(panel);
    }

    //metricas

   public static CategoryDataset createDataset(List<DadosGrafico> lstDados)

    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(DadosGrafico d: lstDados)
        {
            dataset.addValue(d.getValor(), d.getCor(), d.getTitulo());
        }

        return dataset;
    }

   public static JFreeChart createBarChart(CategoryDataset dataset)
    {
        JFreeChart chart = ChartFactory.createBarChart(
                "MÉTRICAS", //Titulo
                "Métrica", // Eixo X
                "Quantidade", //Eixo Y
                dataset, // Dados para o grafico
                PlotOrientation.VERTICAL, //Orientacao do grafico
                true, false, false); // exibir: legendas, tooltips, url
        return chart;
    }

}
