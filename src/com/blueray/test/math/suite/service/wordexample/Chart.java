/**
 * Copyright (c) 2009-2010 Narcea Producciones Multimedia S.L.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * version 3 along with this work. If not, see <http://www.gnu.org/licenses/>.
 */

package com.blueray.test.math.suite.service.wordexample;

import java.util.ArrayList;
import java.util.HashMap;

import com.javadocx.CreateDocx;

/**
 * Create a DOCX file. chart example
 *
 * @version    2.0
 */
public class Chart {
    /**
     * Create docx file.
     * @param args
     */
    public static void main(final String[] args) {
        CreateDocx docx = new CreateDocx("docx");

        HashMap legends = new HashMap();
        ArrayList values1 = new ArrayList();
        values1.add(10);
        values1.add(11);
        values1.add(12);

        ArrayList values2 = new ArrayList();
        values2.add(0);
        values2.add(1);
        values2.add(2);

        ArrayList values3 = new ArrayList();
        values3.add(40);
        values3.add(41);
        values3.add(42);
        
        legends.put("legend1", values1);
        legends.put("legend2", values2);
        legends.put("legend3", values3);
        HashMap paramsChart = new HashMap();
        paramsChart.put("data", legends);
        paramsChart.put("type", "pieChart");
        paramsChart.put("title", "Title");
        paramsChart.put("cornerX", "20");
        paramsChart.put("cornerY", "20");
        paramsChart.put("cornerP", "30");
        paramsChart.put("color", "2");
        paramsChart.put("textWrap", "0");
        paramsChart.put("sizeX", "10");
        paramsChart.put("sizeY", "10");
        paramsChart.put("jc", "right");
        paramsChart.put("showPercent", "1");
        paramsChart.put("font", "Times New Roman");

        docx.addGraphic(paramsChart);
        docx.createDocx("example_chart");
    }
}
