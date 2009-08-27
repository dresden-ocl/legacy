/*
Copyright (C) 2000  Steffen Zschaler

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

/*
 * PropertyPageEvent.java
 *
 * Created on 13. September 2000, 11:26
 */
 
package tudresden.ocl20.injection.reverseeng.propertypages.events;

import tudresden.ocl20.injection.reverseeng.propertypages.*;

import java.util.*;

/** 
  * Event issued by {@link PropertyPage property pages} to indicate changes in their state.
  *
  * @author  sz9 (Steffen Zschaler)
  * @version 1.0
  */
public class PropertyPageEvent extends EventObject {

  /** 
    * Create a new PropertyPageEvent.
    *
    * @param ppSource the source property page.
    */
  public PropertyPageEvent (PropertyPage ppSource) {    
    super (ppSource);
  }
  
  /** Get the property page that issued this event.
    * @return the property page that issued this event.
    */
  public PropertyPage getSourcePage() {
    return (PropertyPage) getSource();
  }
}