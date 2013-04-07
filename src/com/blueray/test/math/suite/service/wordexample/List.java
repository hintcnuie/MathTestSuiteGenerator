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
 * Create a DOCX file. List example
 *
 * @version    2.0
 */
public class List {
    /**
     * Create docx file.
     * @param args
     */
    public static void main(final String[] args) {
        CreateDocx docx = new CreateDocx("docx");

        ArrayList list = new ArrayList();
        list.add("Line 1");
        list.add("Line 2");
        list.add("Line 3");
        list.add("Line 4");
        list.add("Line 5");

        HashMap paramsList = new HashMap();
        paramsList.put("val", "1");

        docx.addList(list, paramsList);

        docx.createDocx("example_list");
    }
}
