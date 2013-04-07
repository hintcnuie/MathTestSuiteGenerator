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

import com.javadocx.CreateDocx;

/**
 * Create a DOCX file. Page break example
 *
 * @version    2.0
 */
public class PageBreak {

    /**
     * Create docx file.
     * @param args
     */
    public static void main(final String[] args) {
        CreateDocx docx = new CreateDocx("docx");

        String text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit"
                + " sed do eiusmod tempor incididunt ut labore et dolore magna "
                + "aliqua. Ut enim ad minim veniam, quis nostrud exercitation "
                + "ullamco laboris nisi ut aliquip ex ea commodo consequat. "
                + "Duis aute irure dolor in reprehenderit in voluptate velit "
                + "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint "
                + "occaecat cupidatat non proident, sunt in culpa qui officia "
                + "deserunt mollit anim id est laborum.";

        docx.addText(text);

        docx.addBreak("line");

        docx.addText(text);

        docx.addBreak("line");
        docx.addBreak("line");

        docx.addText(text);

        docx.addBreak("page");

        docx.addText(text);

        docx.createDocx("example_pagebreak");
    }
}
