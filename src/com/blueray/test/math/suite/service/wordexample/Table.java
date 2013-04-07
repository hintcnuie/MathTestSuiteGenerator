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
 * Create a DOCX file. Table example
 *
 * @version    2.0
 */
public class Table {
    /**
     * Create docx file.
     * @param args
     */
    public static void main(final String[] args) {
        CreateDocx docx = new CreateDocx("docx");

        ArrayList valuesTable = new ArrayList();
        ArrayList row1 = new ArrayList();
        row1.add("11");
        row1.add("12");
        valuesTable.add(row1);
        
        ArrayList row2 = new ArrayList();
        row2.add("22");
        row2.add("21");
        valuesTable.add(row2);

        HashMap paramsTable = new HashMap();
        paramsTable.put("border", "single");
        paramsTable.put("border_sz", "20");

        docx.addTable(valuesTable, paramsTable);
        docx.createDocx("d:\\temp\\example_table");
    }
}
