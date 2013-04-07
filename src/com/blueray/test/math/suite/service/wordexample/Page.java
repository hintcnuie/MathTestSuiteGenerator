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

import java.util.HashMap;

import com.javadocx.CreateDocx;

/**
 * Create a DOCX file. Page example
 *
 * @version    2.0
 */
public class Page {
    /**
     * Create docx file.
     * @param args
     */
    public static void main(final String[] args) {
        CreateDocx docx = new CreateDocx("docx");

        String text = "Lorem ipsum dolor sit amet.";
        docx.addText(text);

        HashMap pageSettings = new HashMap();
        pageSettings.put("titlePage", "1");
        pageSettings.put("orient", "normal");
        pageSettings.put("top", "4000");
        pageSettings.put("bottom", "4000");
        pageSettings.put("right", "4000");
        pageSettings.put("left", "4000");

        docx.createDocx("d:\\temp\\example_page", pageSettings);
    }
}
