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

import com.javadocx.TransformDoc;

/**
 * Create a DOCX file. Transform DOCX to PDF example
 *
 * @version    2.0
 */
public class CreatePDF {

    /**
     * Create docx file.
     * @param args
     */
    public static void main(final String[] args) {
        TransformDoc document = new TransformDoc();
        document.setStrFile("examples/files/Text.docx");
        document.generatePDF();
    }
}
