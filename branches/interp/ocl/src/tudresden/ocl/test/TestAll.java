/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * OCL Compiler                                                      *
 * Copyright (C) 1999, 2000 Frank Finger (frank@finger.org).         *
 * All rights reserved.                                              *
 *                                                                   *
 * This work was done as a diploma project at the Chair for Software *
 * Technology, Dresden University Of Technology, Germany             *
 * (http://www-st.inf.tu-dresden.de).  It is understood that any     *
 * modification not identified as such is not covered by the         *
 * preceding statement.                                              *
 *                                                                   *
 * This work is free software; you can redistribute it and/or        *
 * modify it under the terms of the GNU Library General Public       *
 * License as published by the Free Software Foundation; either      *
 * version 2 of the License, or (at your option) any later version.  *
 *                                                                   *
 * This work is distributed in the hope that it will be useful,      *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of    *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU *
 * Library General Public License for more details.                  *
 *                                                                   *
 * You should have received a copy of the GNU Library General Public *
 * License along with this library; if not, write to the             *
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,      *
 * Boston, MA  02111-1307, USA.                                      *
 *                                                                   *
 * To submit a bug report, send a comment, or get the latest news on *
 * this project and other projects, please visit the web site:       *
 * http://www-st.inf.tu-dresden.de/ (Chair home page) or             *
 * http://www-st.inf.tu-dresden.de/ocl/ (project home page)          *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package tudresden.ocl.test;

import junit.framework.*;
import java.util.*;

public class TestAll extends TestCase {

  public TestAll(String s) {
    super(s);
  }

  public static Test suite() {
    TestSuite suite=new TestSuite();
    suite.addTest( tudresden.ocl.lib.test.TestAll.suite() );
    suite.addTest( TestNameCreator.suite() );
    suite.addTest( TestParser.suite() );
    suite.addTest( TestNormalize.suite() );
    suite.addTest( new TestSuite(TestJavaGenerator.class) );
    suite.addTest( tudresden.ocl.check.types.xmifacade.stress.Test.suite() );
    suite.addTest( tudresden.ocl.injection.test.TestInjection.suite() );
    suite.addTest( new TestSuite(TestTypeCheck.class) );

    // Test Injector Reverseeng GUI
    // Added 11/24/2000-sz9
    suite.addTest( tudresden.ocl.injection.reverseeng.test.RevengTestSuite.suite() );

    // Test SQL stuff
    suite.addTest( tudresden.ocl.test.sql.TestSQLClasses.suite() );

    return suite;
  }
}

